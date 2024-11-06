# auto-generated file
import json
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, FilterOptions, BaseSortableFilterOptions, SortableFilterOptions
from cardinal_sdk.model import HealthElement, Identifier, Patient
from List import typing
from Optional import typing
from serialize_patient import cardinal_sdk.model


class HealthElementFilters:

	@classmethod
	def all_health_elements_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.allHealthElementsForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def all_health_elements_for_self(cls) -> FilterOptions[HealthElement]:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.allHealthElementsForSelf(
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_identifiers_for_data_owner(cls, data_owner_id: str, identifiers: typing[Identifier]) -> BaseSortableFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byIdentifiersForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_identifiers_for_self(cls, identifiers: typing[Identifier]) -> SortableFilterOptions[HealthElement]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byIdentifiersForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_code_for_data_owner(cls, data_owner_id: str, code_type: str, code_code: typing[str] = None) -> BaseSortableFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeType": code_type,
			"codeCode": code_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byCodeForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_code_for_self(cls, code_type: str, code_code: typing[str] = None) -> SortableFilterOptions[HealthElement]:
		payload = {
			"codeType": code_type,
			"codeCode": code_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byCodeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_tag_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code: typing[str] = None) -> BaseSortableFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byTagForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_tag_for_self(cls, tag_type: str, tag_code: typing[str] = None) -> SortableFilterOptions[HealthElement]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byTagForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_for_data_owner(cls, data_owner_id: str, patients: typing[Patient]) -> SortableFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byPatientsForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_for_self(cls, patients: typing[Patient]) -> SortableFilterOptions[HealthElement]:
		payload = {
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byPatientsForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_secret_ids_for_data_owner(cls, data_owner_id: str, secret_ids: typing[str]) -> BaseSortableFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byPatientsSecretIdsForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_secret_ids_for_self(cls, secret_ids: typing[str]) -> SortableFilterOptions[HealthElement]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byPatientsSecretIdsForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_ids(cls, ids: typing[str]) -> BaseSortableFilterOptions[HealthElement]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_opening_date_for_data_owner(cls, data_owner_id: str, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byPatientsOpeningDateForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_opening_date_for_self(cls, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[HealthElement]:
		payload = {
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byPatientsOpeningDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_opening_date_for_data_owner(cls, data_owner_id: str, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byPatientSecretIdsOpeningDateForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_opening_date_for_self(cls, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[HealthElement]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byPatientSecretIdsOpeningDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_status_for_data_owner(cls, data_owner_id: str, status: int) -> BaseFilterOptions[HealthElement]:
		payload = {
			"dataOwnerId": data_owner_id,
			"status": status,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byStatusForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_status_for_self(cls, status: int) -> FilterOptions[HealthElement]:
		payload = {
			"status": status,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.HealthElementFilters.byStatusForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value
