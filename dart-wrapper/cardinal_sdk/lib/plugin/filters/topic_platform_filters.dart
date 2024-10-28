// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/topic.dart';


class TopicPlatformFilters {
	MethodChannel _methodChannel;
	TopicPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Topic>> allTopicsForDataOwner(String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicFilters.allTopicsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method allTopicsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Topic>> allTopicsForSelf() async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicFilters.allTopicsForSelf',
			{
			}
		);
		if (res == null) throw AssertionError("received null result from platform method allTopicsForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Topic>> byParticipant(String participantId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicFilters.byParticipant',
			{
				"participantId": jsonEncode(participantId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byParticipant");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}
}