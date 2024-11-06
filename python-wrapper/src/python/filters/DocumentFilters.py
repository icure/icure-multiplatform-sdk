# auto-generated file
import json
from List import typing
from cardinal_sdk.model import Patient, Document, DocumentType
from Optional import typing
from serialize_patient import cardinal_sdk.model
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from cardinal_sdk.filters.FilterOptions import SortableFilterOptions, BaseSortableFilterOptions, FilterOptions


class DocumentFilters:

	@classmethod
	def by_patients_created_for_data_owner(cls, data_owner_id: str, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientsCreatedForDataOwner(
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
	def by_patients_created_for_self(cls, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientsCreatedForSelf(
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
	def by_patient_secret_ids_created_for_data_owner(cls, data_owner_id: str, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientSecretIdsCreatedForDataOwner(
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
	def by_patient_secret_ids_created_for_self(cls, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientSecretIdsCreatedForSelf(
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
	def by_patients_and_type_for_data_owner(cls, data_owner_id: str, document_type: DocumentType, patients: typing[Patient]) -> FilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"documentType": document_type.__serialize__(),
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientsAndTypeForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_and_type_for_self(cls, document_type: DocumentType, patients: typing[Patient]) -> FilterOptions[Document]:
		payload = {
			"documentType": document_type.__serialize__(),
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientsAndTypeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_and_type_for_data_owner(cls, data_owner_id: str, document_type: DocumentType, secret_ids: typing[str]) -> FilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"documentType": document_type.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientSecretIdsAndTypeForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_and_type_for_self(cls, document_type: DocumentType, secret_ids: typing[str]) -> FilterOptions[Document]:
		payload = {
			"documentType": document_type.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientSecretIdsAndTypeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value
