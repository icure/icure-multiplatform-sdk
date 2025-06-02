# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions
from cardinal_sdk.model import Agenda, EntityReferenceInGroup


class AgendaFilters:

	@classmethod
	def all(cls) -> BaseFilterOptions[Agenda]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.all(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_user(cls, user_id: str) -> BaseFilterOptions[Agenda]:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.byUser(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_user_in_group(cls, user_reference: EntityReferenceInGroup) -> BaseFilterOptions[Agenda]:
		payload = {
			"userReference": user_reference.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.byUserInGroup(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def readable_by_user(cls, user_id: str) -> BaseFilterOptions[Agenda]:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.readableByUser(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def readable_by_user_in_group(cls, user_reference: EntityReferenceInGroup) -> BaseFilterOptions[Agenda]:
		payload = {
			"userReference": user_reference.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.readableByUserInGroup(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def readable_by_user_rights(cls, user_id: str) -> BaseFilterOptions[Agenda]:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.readableByUserRights(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def readable_by_user_rights_in_group(cls, user_reference: EntityReferenceInGroup) -> BaseFilterOptions[Agenda]:
		payload = {
			"userReference": user_reference.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.readableByUserRightsInGroup(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_string_property(cls, property_id: str, property_value: str) -> BaseFilterOptions[Agenda]:
		payload = {
			"propertyId": property_id,
			"propertyValue": property_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.byStringProperty(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_boolean_property(cls, property_id: str, property_value: bool) -> BaseFilterOptions[Agenda]:
		payload = {
			"propertyId": property_id,
			"propertyValue": property_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.byBooleanProperty(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_long_property(cls, property_id: str, property_value: int) -> BaseFilterOptions[Agenda]:
		payload = {
			"propertyId": property_id,
			"propertyValue": property_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.byLongProperty(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_double_property(cls, property_id: str, property_value: float) -> BaseFilterOptions[Agenda]:
		payload = {
			"propertyId": property_id,
			"propertyValue": property_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.byDoubleProperty(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def with_property(cls, property_id: str) -> BaseFilterOptions[Agenda]:
		payload = {
			"propertyId": property_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.withProperty(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value
