import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from model import Device, IdWithRev, FilterChain, PaginatedList, AbstractFilter, serialize_abstract_filter, DocIdentifier
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from typing import List, Optional

class DeviceApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def get_device_async(self, device_id: str) -> Device:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Device._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"device_id": device_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.getDeviceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_device_blocking(self, device_id: str) -> Device:
		payload = {
			"device_id": device_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.getDeviceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Device._deserialize(result_info["success"])
			return return_value

	async def get_devices_async(self, device_ids: List[str]) -> List[Device]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Device._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"device_ids": [x0 for x0 in device_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.getDevicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_devices_blocking(self, device_ids: List[str]) -> List[Device]:
		payload = {
			"device_ids": [x0 for x0 in device_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.getDevicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Device._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def create_device_async(self, p: Device) -> Device:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Device._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"p": p.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.createDeviceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_device_blocking(self, p: Device) -> Device:
		payload = {
			"p": p.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.createDeviceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Device._deserialize(result_info["success"])
			return return_value

	async def update_device_async(self, device: Device) -> Device:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Device._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"device": device.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.updateDeviceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def update_device_blocking(self, device: Device) -> Device:
		payload = {
			"device": device.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.updateDeviceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Device._deserialize(result_info["success"])
			return return_value

	async def create_devices_async(self, devices: List[Device]) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"devices": [x0.__serialize__() for x0 in devices],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.createDevicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_devices_blocking(self, devices: List[Device]) -> List[IdWithRev]:
		payload = {
			"devices": [x0.__serialize__() for x0 in devices],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.createDevicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def update_devices_async(self, devices: List[Device]) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"devices": [x0.__serialize__() for x0 in devices],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.updateDevicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def update_devices_blocking(self, devices: List[Device]) -> List[IdWithRev]:
		payload = {
			"devices": [x0.__serialize__() for x0 in devices],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.updateDevicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def filter_devices_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Device._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.filterDevicesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_devices_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.filterDevicesByBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [Device._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def match_devices_by_async(self, filter: AbstractFilter) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.matchDevicesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def match_devices_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.matchDevicesByBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def delete_device_async(self, device_id: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocIdentifier._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"device_id": device_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.deleteDeviceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_device_blocking(self, device_id: str) -> DocIdentifier:
		payload = {
			"device_id": device_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.deleteDeviceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def delete_devices_async(self, device_ids: List[str]) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocIdentifier._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"device_ids": [x0 for x0 in device_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.deleteDevicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_devices_blocking(self, device_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"device_ids": [x0 for x0 in device_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.deleteDevicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_devices_in_group_async(self, group_id: str, device_ids: Optional[List[str]] = None) -> List[Device]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Device._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"device_ids": [x0 for x0 in device_ids] if device_ids is not None else None,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.getDevicesInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_devices_in_group_blocking(self, group_id: str, device_ids: Optional[List[str]] = None) -> List[Device]:
		payload = {
			"group_id": group_id,
			"device_ids": [x0 for x0 in device_ids] if device_ids is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.getDevicesInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Device._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_device_in_group_async(self, group_id: str, device: Device) -> Device:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Device._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"device": device.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.modifyDeviceInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_device_in_group_blocking(self, group_id: str, device: Device) -> Device:
		payload = {
			"group_id": group_id,
			"device": device.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.modifyDeviceInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Device._deserialize(result_info["success"])
			return return_value

	async def create_device_in_group_async(self, group_id: str, device: Device) -> Device:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Device._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"device": device.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.createDeviceInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_device_in_group_blocking(self, group_id: str, device: Device) -> Device:
		payload = {
			"group_id": group_id,
			"device": device.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.createDeviceInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Device._deserialize(result_info["success"])
			return return_value

	async def delete_devices_in_group_async(self, group_id: str, device_ids: str) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocIdentifier._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"device_ids": device_ids,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.deleteDevicesInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_devices_in_group_blocking(self, group_id: str, device_ids: str) -> List[DocIdentifier]:
		payload = {
			"group_id": group_id,
			"device_ids": device_ids,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DeviceApi.deleteDevicesInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value