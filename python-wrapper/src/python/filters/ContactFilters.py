# auto-generated file
import json
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, FilterOptions, SortableFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import Contact, Patient, Identifier
from List import typing
from Optional import typing
from serialize_patient import cardinal_sdk.model


class ContactFilters:

	@classmethod
	def all_contacts_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.allContactsForDataOwner(
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
	def all_contacts_for_self(cls) -> FilterOptions[Contact]:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.allContactsForSelf(
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_form_ids_for_data_owner(cls, data_owner_id: str, form_ids: typing[str]) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"formIds": [x0 for x0 in form_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byFormIdsForDataOwner(
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
	def by_form_ids_for_self(cls, form_ids: typing[str]) -> FilterOptions[Contact]:
		payload = {
			"formIds": [x0 for x0 in form_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byFormIdsForSelf(
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
	def by_patients_opening_date_for_data_owner(cls, data_owner_id: str, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsOpeningDateForDataOwner(
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
	def by_patients_opening_date_for_self(cls, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsOpeningDateForSelf(
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
	def by_patient_secret_ids_opening_date_for_data_owner(cls, data_owner_id: str, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientSecretIdsOpeningDateForDataOwner(
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
	def by_patient_secret_ids_opening_date_for_self(cls, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientSecretIdsOpeningDateForSelf(
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
	def by_external_id(cls, external_id: str) -> BaseFilterOptions[Contact]:
		payload = {
			"externalId": external_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byExternalId(
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
	def by_identifiers_for_self(cls, identifiers: typing[Identifier]) -> SortableFilterOptions[Contact]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byIdentifiersForSelf(
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
	def by_identifiers_for_data_owner(cls, data_owner_id: str, identifiers: typing[Identifier]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byIdentifiersForDataOwner(
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
	def by_code_and_opening_date_for_data_owner(cls, data_owner_id: str, code_type: str, code_code: typing[str] = None, start_of_contact_opening_date: typing[int] = None, end_of_contact_opening_date: typing[int] = None) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeType": code_type,
			"codeCode": code_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byCodeAndOpeningDateForDataOwner(
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
	def by_code_and_opening_date_for_self(cls, code_type: str, code_code: typing[str] = None, start_of_contact_opening_date: typing[int] = None, end_of_contact_opening_date: typing[int] = None) -> SortableFilterOptions[Contact]:
		payload = {
			"codeType": code_type,
			"codeCode": code_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byCodeAndOpeningDateForSelf(
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
	def by_tag_and_opening_date_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code: typing[str] = None, start_of_contact_opening_date: typing[int] = None, end_of_contact_opening_date: typing[int] = None) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byTagAndOpeningDateForDataOwner(
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
	def by_opening_date_for_data_owner(cls, data_owner_id: str, start_date: typing[int] = None, end_date: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byOpeningDateForDataOwner(
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
	def by_opening_date_for_self(cls, start_date: typing[int] = None, end_date: typing[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byOpeningDateForSelf(
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
	def by_service_tag_for_self(cls, tag_type: str, tag_code: typing[str] = None) -> FilterOptions[Contact]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceTagForSelf(
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
	def by_service_tag_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code: typing[str] = None) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceTagForDataOwner(
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
	def by_service_code_for_self(cls, code_type: str, code_code: typing[str] = None) -> FilterOptions[Contact]:
		payload = {
			"codeType": code_type,
			"codeCode": code_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceCodeForSelf(
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
	def by_service_code_for_data_owner(cls, data_owner_id: str, code_type: str, code_code: typing[str] = None) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeType": code_type,
			"codeCode": code_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceCodeForDataOwner(
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
	def by_tag_and_opening_date_for_self(cls, tag_type: str, tag_code: typing[str] = None, start_of_contact_opening_date: typing[int] = None, end_of_contact_opening_date: typing[int] = None) -> SortableFilterOptions[Contact]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byTagAndOpeningDateForSelf(
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
	def by_patients_for_data_owner(cls, data_owner_id: str, patients: typing[Patient]) -> SortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsForDataOwner(
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
	def by_patients_for_self(cls, patients: typing[Patient]) -> SortableFilterOptions[Contact]:
		payload = {
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsForSelf(
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
	def by_patients_secret_ids_for_data_owner(cls, data_owner_id: str, secret_ids: typing[str]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsSecretIdsForDataOwner(
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
	def by_patients_secret_ids_for_self(cls, secret_ids: typing[str]) -> SortableFilterOptions[Contact]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsSecretIdsForSelf(
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
	def by_service_ids(cls, service_ids: typing[str]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"serviceIds": [x0 for x0 in service_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
