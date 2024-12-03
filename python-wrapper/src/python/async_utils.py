from ctypes import c_void_p
from typing import Optional
from cardinal_sdk.model.CallResult import interpret_kt_error
from cardinal_sdk.kotlin_types import symbols, DATA_RESULT_CALLBACK_FUNC, PTR_RESULT_CALLBACK_FUNC
import threading
import asyncio
import json


async def execute_async_method_job(
		executor,
		data_result,
		decode_result,  # takes in input json if data_result, else takes in input ptr
		method,
		*args
) -> any:
	job_holder = __Holder()
	loop = asyncio.get_running_loop()
	future = loop.create_future()
	cancelled_holder = __Holder()
	cancelled_holder.set(False)
	lock = threading.Lock()
	def make_result_and_complete(success, failure):
		if failure is not None:
			error_json = json.loads(failure.decode('utf-8'))
			if error_json["type"] == "kotlinx.coroutines.JobCancellationException":
				loop.call_soon_threadsafe(lambda: future.cancel())
			else:
				loop.call_soon_threadsafe(lambda: future.set_exception(interpret_kt_error(error_json)))
		else:
			result: any
			if data_result:
				result = decode_result(json.loads(success.decode('utf-8')))
			else:
				result = decode_result(success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
	callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete) if data_result else PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
	try:
		await asyncio.shield(__protected_section(
			loop,
			job_holder,
			cancelled_holder,
			executor,
			method,
			args,
			callback,
			lock
		))
		return await asyncio.shield(future)
	except asyncio.CancelledError:
		job: Optional[c_void_p]
		with lock:
			job = job_holder.get()
			if job is None:
				cancelled_holder.set(True)
		if job is not None:
			symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.cancelJob(job_holder.get())
			symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.disposeStablePtr(job_holder.get())
		raise


async def __protected_section(
		loop,
		job_holder,
		cancelled_holder,
		executor,
		method,
		args,
		callback,
		lock
):
	job = await loop.run_in_executor(
		executor,
		method,
		*args,
		callback
	)
	cancelled: bool
	with lock:
		job_holder.set(job)
		cancelled = cancelled_holder.get()
	if cancelled:
		symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.cancelJob(job)
		symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.disposeStablePtr(job)


class __Holder:
	value = None

	def set(self, value):
		self.value = value

	def get(self):
		return self.value
