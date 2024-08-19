# auto-generated file
import json
from icure.kotlin_types import symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.filters import BaseFilterOptions, FilterOptions, SortableFilterOptions, BaseSortableFilterOptions
from icure.model import Contact, Identifier, Patient, serialize_patient
from typing import List, Optional

class ContactFilters:

	@classmethod
	def all_contacts_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.allContactsForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def all_contacts_for_self(cls) -> FilterOptions[Contact]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.allContactsForSelf(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_identifiers_for_self(cls, identifiers: List[Identifier]) -> SortableFilterOptions[Contact]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byIdentifiersForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_identifiers_for_data_owner(cls, data_owner_id: str, identifiers: List[Identifier]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byIdentifiersForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_code_and_opening_date_for_data_owner(cls, data_owner_id: str, code_type: str, code_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeType": code_type,
			"codeCode": code_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byCodeAndOpeningDateForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_code_and_opening_date_for_self(cls, code_type: str, code_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> SortableFilterOptions[Contact]:
		payload = {
			"codeType": code_type,
			"codeCode": code_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byCodeAndOpeningDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_tag_and_opening_date_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byTagAndOpeningDateForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_tag_and_opening_date_for_self(cls, tag_type: str, tag_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> SortableFilterOptions[Contact]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byTagAndOpeningDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_patients_for_data_owner(cls, data_owner_id: str, patients: List[Patient]) -> SortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byPatientsForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_patients_for_self(cls, patients: List[Patient]) -> SortableFilterOptions[Contact]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byPatientsForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_patients_secret_ids_for_data_owner(cls, data_owner_id: str, secret_ids: List[str]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byPatientsSecretIdsForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_patients_secret_ids_for_self(cls, secret_ids: List[str]) -> SortableFilterOptions[Contact]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byPatientsSecretIdsForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_service_ids(cls, service_ids: List[str]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"serviceIds": [x0 for x0 in service_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.ContactFilters.byServiceIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(json.loads(result_info.success))
			return return_value
