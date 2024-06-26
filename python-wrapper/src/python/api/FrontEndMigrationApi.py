import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from model.FrontEndMigration import FrontEndMigration
from ctypes import c_char_p
from typing import List
from model.couchdb.DocIdentifier import DocIdentifier

class FrontEndMigrationApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createFrontEndMigrationApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_front_end_migration_async(self, front_end_migration_id: str) -> FrontEndMigration:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = FrontEndMigration._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"front_end_migration_id": front_end_migration_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_front_end_migration_blocking(self, front_end_migration_id: str) -> FrontEndMigration:
		payload = {
			"front_end_migration_id": front_end_migration_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = FrontEndMigration._deserialize(result_info["success"])
			return return_value

	async def create_front_end_migration_async(self, front_end_migration: FrontEndMigration) -> FrontEndMigration:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = FrontEndMigration._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"front_end_migration": front_end_migration.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.createFrontEndMigrationAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_front_end_migration_blocking(self, front_end_migration: FrontEndMigration) -> FrontEndMigration:
		payload = {
			"front_end_migration": front_end_migration.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.createFrontEndMigrationBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = FrontEndMigration._deserialize(result_info["success"])
			return return_value

	async def get_front_end_migrations_async(self) -> List[FrontEndMigration]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [FrontEndMigration._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_front_end_migrations_blocking(self) -> List[FrontEndMigration]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [FrontEndMigration._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def delete_front_end_migration_async(self, front_end_migration_id: str) -> DocIdentifier:
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
			"front_end_migration_id": front_end_migration_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.deleteFrontEndMigrationAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_front_end_migration_blocking(self, front_end_migration_id: str) -> DocIdentifier:
		payload = {
			"front_end_migration_id": front_end_migration_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.deleteFrontEndMigrationBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def get_front_end_migration_by_name_async(self, front_end_migration_name: str) -> List[FrontEndMigration]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [FrontEndMigration._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"front_end_migration_name": front_end_migration_name,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationByNameAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_front_end_migration_by_name_blocking(self, front_end_migration_name: str) -> List[FrontEndMigration]:
		payload = {
			"front_end_migration_name": front_end_migration_name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.getFrontEndMigrationByNameBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [FrontEndMigration._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_front_end_migration_async(self, front_end_migration: FrontEndMigration) -> FrontEndMigration:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = FrontEndMigration._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"front_end_migration": front_end_migration.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.modifyFrontEndMigrationAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_front_end_migration_blocking(self, front_end_migration: FrontEndMigration) -> FrontEndMigration:
		payload = {
			"front_end_migration": front_end_migration.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FrontEndMigrationApi.modifyFrontEndMigrationBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = FrontEndMigration._deserialize(result_info["success"])
			return return_value

__all__ = ['FrontEndMigrationApi']