# auto-generated file
import json
from List import typing
from cardinal_sdk.model import Patient, AccessLog
from Optional import typing
from serialize_patient import cardinal_sdk.model
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from cardinal_sdk.filters.FilterOptions import SortableFilterOptions, BaseSortableFilterOptions


class AccessLogFilters:

	@classmethod
	def by_patients_date_for_data_owner(cls, data_owner_id: str, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[AccessLog]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.AccessLogFilters.byPatientsDateForDataOwner(
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
	def by_patients_date_for_self(cls, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[AccessLog]:
		payload = {
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.AccessLogFilters.byPatientsDateForSelf(
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
	def by_patient_secret_ids_date_for_data_owner(cls, data_owner_id: str, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[AccessLog]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.AccessLogFilters.byPatientSecretIdsDateForDataOwner(
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
	def by_patient_secret_ids_date_for_self(cls, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[AccessLog]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.AccessLogFilters.byPatientSecretIdsDateForSelf(
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
	def by_date(cls, from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[AccessLog]:
		payload = {
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.AccessLogFilters.byDate(
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
	def by_user_type_date(cls, user_id: str, access_type: typing[str] = None, from_: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[AccessLog]:
		payload = {
			"userId": user_id,
			"accessType": access_type,
			"from": from_,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.AccessLogFilters.byUserTypeDate(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
