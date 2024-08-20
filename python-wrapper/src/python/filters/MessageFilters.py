# auto-generated file
import json
from icure.kotlin_types import symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.filters.FilterOptions import BaseFilterOptions, FilterOptions, BaseSortableFilterOptions, SortableFilterOptions
from icure.model import Message

class MessageFilters:

	@classmethod
	def all_messages_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MessageFilters.allMessagesForDataOwner(
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
	def all_messages_for_self(cls) -> FilterOptions[Message]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MessageFilters.allMessagesForSelf(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_transport_guid_date_for_data_owner(cls, data_owner_id: str, transport_guid: str) -> BaseSortableFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"transportGuid": transport_guid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MessageFilters.byTransportGuidDateForDataOwner(
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
	def by_transport_guid_date(cls, transport_guid: str) -> SortableFilterOptions[Message]:
		payload = {
			"transportGuid": transport_guid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.MessageFilters.byTransportGuidDate(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value
