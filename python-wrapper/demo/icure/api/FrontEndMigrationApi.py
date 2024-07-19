import asyncio
import json
from icure.model import FrontEndMigration, DocIdentifier
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from typing import List

class FrontEndMigrationApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def get_front_end_migration_async(self, front_end_migration_id: str) -> FrontEndMigration:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = FrontEndMigration._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"frontEndMigrationId": front_end_migration_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_front_end_migration_blocking(self, front_end_migration_id: str) -> FrontEndMigration:
		payload = {
			"frontEndMigrationId": front_end_migration_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FrontEndMigration._deserialize(result_info.success)
			return return_value

	async def create_front_end_migration_async(self, front_end_migration: FrontEndMigration) -> FrontEndMigration:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = FrontEndMigration._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"frontEndMigration": front_end_migration.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.createFrontEndMigrationAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_front_end_migration_blocking(self, front_end_migration: FrontEndMigration) -> FrontEndMigration:
		payload = {
			"frontEndMigration": front_end_migration.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.createFrontEndMigrationBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FrontEndMigration._deserialize(result_info.success)
			return return_value

	async def get_front_end_migrations_async(self) -> List[FrontEndMigration]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [FrontEndMigration._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationsAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_front_end_migrations_blocking(self) -> List[FrontEndMigration]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationsBlocking(
			self.icure_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [FrontEndMigration._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_front_end_migration_async(self, front_end_migration_id: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DocIdentifier._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"frontEndMigrationId": front_end_migration_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.deleteFrontEndMigrationAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_front_end_migration_blocking(self, front_end_migration_id: str) -> DocIdentifier:
		payload = {
			"frontEndMigrationId": front_end_migration_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.deleteFrontEndMigrationBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def get_front_end_migration_by_name_async(self, front_end_migration_name: str) -> List[FrontEndMigration]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [FrontEndMigration._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"frontEndMigrationName": front_end_migration_name,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationByNameAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_front_end_migration_by_name_blocking(self, front_end_migration_name: str) -> List[FrontEndMigration]:
		payload = {
			"frontEndMigrationName": front_end_migration_name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationByNameBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [FrontEndMigration._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_front_end_migration_async(self, front_end_migration: FrontEndMigration) -> FrontEndMigration:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = FrontEndMigration._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"frontEndMigration": front_end_migration.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.modifyFrontEndMigrationAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_front_end_migration_blocking(self, front_end_migration: FrontEndMigration) -> FrontEndMigration:
		payload = {
			"frontEndMigration": front_end_migration.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.modifyFrontEndMigrationBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FrontEndMigration._deserialize(result_info.success)
			return return_value
