# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, FilterOptions, SortableFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import Form, Patient, serialize_patient
from typing import List, Optional

class FormFilters:

	@classmethod
	def by_parent_id_for_data_owner(cls, data_owner_id: str, parent_id: str) -> BaseFilterOptions[Form]:
		payload = {
			"dataOwnerId": data_owner_id,
			"parentId": parent_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormFilters.byParentIdForDataOwner(
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
	def by_parent_id_for_self(cls, parent_id: str) -> FilterOptions[Form]:
		payload = {
			"parentId": parent_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormFilters.byParentIdForSelf(
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
	def by_patients_opening_date_for_data_owner(cls, data_owner_id: str, patients: List[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Form]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormFilters.byPatientsOpeningDateForDataOwner(
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
	def by_patients_opening_date_for_self(cls, patients: List[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Form]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormFilters.byPatientsOpeningDateForSelf(
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
	def by_patient_secret_ids_opening_date_for_data_owner(cls, data_owner_id: str, secret_ids: List[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Form]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormFilters.byPatientSecretIdsOpeningDateForDataOwner(
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
	def by_patient_secret_ids_opening_date_for_self(cls, secret_ids: List[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Form]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormFilters.byPatientSecretIdsOpeningDateForSelf(
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
	def by_logical_uuid(cls, logical_uuid: str, descending: bool = False) -> BaseSortableFilterOptions[Form]:
		payload = {
			"logicalUuid": logical_uuid,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormFilters.byLogicalUuid(
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
	def by_unique_id(cls, unique_id: str, descending: bool = False) -> BaseSortableFilterOptions[Form]:
		payload = {
			"uniqueId": unique_id,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormFilters.byUniqueId(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
