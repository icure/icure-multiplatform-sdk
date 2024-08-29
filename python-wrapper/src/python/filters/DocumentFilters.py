# auto-generated file
import json
from typing import List, Optional
from icure.model import Patient, serialize_patient, Document, DocumentType
from icure.kotlin_types import symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.filters.FilterOptions import SortableFilterOptions, BaseSortableFilterOptions, FilterOptions

class DocumentFilters:

	@classmethod
	def by_patients_created_for_data_owner(cls, data_owner_id: str, patients: List[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.DocumentFilters.byPatientsCreatedForDataOwner(
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
	def by_patients_created_for_self(cls, patients: List[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.DocumentFilters.byPatientsCreatedForSelf(
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
	def by_patient_secret_ids_created_for_data_owner(cls, data_owner_id: str, secret_ids: List[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.DocumentFilters.byPatientSecretIdsCreatedForDataOwner(
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
	def by_patient_secret_ids_created_for_self(cls, secret_ids: List[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.DocumentFilters.byPatientSecretIdsCreatedForSelf(
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
	def by_patients_and_type_for_data_owner(cls, data_owner_id: str, document_type: DocumentType, patients: List[Patient]) -> FilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"documentType": document_type.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.DocumentFilters.byPatientsAndTypeForDataOwner(
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
	def by_patients_and_type_for_self(cls, document_type: DocumentType, patients: List[Patient]) -> FilterOptions[Document]:
		payload = {
			"documentType": document_type.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.DocumentFilters.byPatientsAndTypeForSelf(
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
	def by_patient_secret_ids_and_type_for_data_owner(cls, data_owner_id: str, document_type: DocumentType, secret_ids: List[str]) -> FilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"documentType": document_type.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.DocumentFilters.byPatientSecretIdsAndTypeForDataOwner(
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
	def by_patient_secret_ids_and_type_for_self(cls, document_type: DocumentType, secret_ids: List[str]) -> FilterOptions[Document]:
		payload = {
			"documentType": document_type.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.DocumentFilters.byPatientSecretIdsAndTypeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value