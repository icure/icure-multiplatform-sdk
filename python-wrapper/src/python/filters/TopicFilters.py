# auto-generated file
import json
from icure.kotlin_types import symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.filters import BaseFilterOptions, FilterOptions
from icure.model import Topic

class TopicFilters:

	@classmethod
	def all_topics_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[Topic]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.TopicFilters.allTopicsForDataOwner(
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
	def all_topics_for_self(cls) -> FilterOptions[Topic]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.TopicFilters.allTopicsForSelf(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FilterOptions(json.loads(result_info.success))
			return return_value

	@classmethod
	def by_participant(cls, participant_id: str) -> FilterOptions[Topic]:
		payload = {
			"participantId": participant_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.TopicFilters.byParticipant(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = FilterOptions(json.loads(result_info.success))
			return return_value
