# auto-generated file
import json
from typing import List
from icure.kotlin_types import symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.filters.FilterOptions import BaseSortableFilterOptions, SortableFilterOptions, BaseFilterOptions, FilterOptions
from icure.model import MaintenanceTask, Identifier

class MaintenanceTaskFilters:

	@classmethod
	def by_ids(cls, ids: List[str]) -> BaseSortableFilterOptions[MaintenanceTask]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MaintenanceTaskFilters.byIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_identifiers_for_data_owner(cls, data_owner_id: str, identifiers: List[Identifier]) -> BaseSortableFilterOptions[MaintenanceTask]:
		payload = {
			"dataOwnerId": data_owner_id,
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MaintenanceTaskFilters.byIdentifiersForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_identifiers_for_self(cls, identifiers: List[Identifier]) -> SortableFilterOptions[MaintenanceTask]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MaintenanceTaskFilters.byIdentifiersForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_type_for_data_owner(cls, data_owner_id: str, type: str) -> BaseFilterOptions[MaintenanceTask]:
		payload = {
			"dataOwnerId": data_owner_id,
			"type": type,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MaintenanceTaskFilters.byTypeForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_type_for_self(cls, type: str) -> FilterOptions[MaintenanceTask]:
		payload = {
			"type": type,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MaintenanceTaskFilters.byTypeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def after_date_for_data_owner(cls, data_owner_id: str, date: int) -> BaseSortableFilterOptions[MaintenanceTask]:
		payload = {
			"dataOwnerId": data_owner_id,
			"date": date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MaintenanceTaskFilters.afterDateForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def after_date_for_self(cls, date: int) -> SortableFilterOptions[MaintenanceTask]:
		payload = {
			"date": date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MaintenanceTaskFilters.afterDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value