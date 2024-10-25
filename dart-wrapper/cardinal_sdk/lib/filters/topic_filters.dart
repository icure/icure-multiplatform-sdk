import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/topic.dart';


abstract class TopicFilters {
	TopicFilters();

	static Future<BaseFilterOptions<Topic>> allTopicsForDataOwner(String dataOwnerId) async {
		return CardinalSdkPlatformInterface.instance.filters.topic.allTopicsForDataOwner(
			dataOwnerId,
		);
	}

	static Future<FilterOptions<Topic>> allTopicsForSelf() async {
		return CardinalSdkPlatformInterface.instance.filters.topic.allTopicsForSelf(
		);
	}

	static Future<FilterOptions<Topic>> byParticipant(String participantId) async {
		return CardinalSdkPlatformInterface.instance.filters.topic.byParticipant(
			participantId,
		);
	}
}