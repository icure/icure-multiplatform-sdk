// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/group.dart';


class GroupPlatformFilters {
	MethodChannel _methodChannel;
	GroupPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Group>> all() async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupFilters.all',
			{
			}
		);
		if (res == null) throw AssertionError("received null result from platform method all");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Group>> bySuperGroup(String superGroupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupFilters.bySuperGroup',
			{
				"superGroupId": jsonEncode(superGroupId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method bySuperGroup");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Group>> withContent(String superGroupId, String searchString) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupFilters.withContent',
			{
				"superGroupId": jsonEncode(superGroupId),
				"searchString": jsonEncode(searchString),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method withContent");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}
}