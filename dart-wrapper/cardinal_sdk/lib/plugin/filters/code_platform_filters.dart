// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/code.dart';


class CodePlatformFilters {
	MethodChannel _methodChannel;
	CodePlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Code>> all() async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeFilters.all',
			{
			}
		);
		if (res == null) throw AssertionError("received null result from platform method all");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Code>> byIds(List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeFilters.byIds',
			{
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIds");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Code>> byQualifiedLink(String linkType, { String? linkedId }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeFilters.byQualifiedLink',
			{
				"linkType": jsonEncode(linkType),
				"linkedId": jsonEncode(linkedId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byQualifiedLink");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Code>> byRegionTypeCodeVersion(String region, { String? type, String? code, String? version }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeFilters.byRegionTypeCodeVersion',
			{
				"region": jsonEncode(region),
				"type": jsonEncode(type),
				"code": jsonEncode(code),
				"version": jsonEncode(version),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byRegionTypeCodeVersion");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Code>> byLanguageTypeLabelRegion(String language, String type, { String? label, String? region }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeFilters.byLanguageTypeLabelRegion',
			{
				"language": jsonEncode(language),
				"type": jsonEncode(type),
				"label": jsonEncode(label),
				"region": jsonEncode(region),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byLanguageTypeLabelRegion");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Code>> byLanguageTypesLabelRegionVersion(String language, List<String> types, String label, { String? region, String? version }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeFilters.byLanguageTypesLabelRegionVersion',
			{
				"language": jsonEncode(language),
				"types": jsonEncode(types.map((x0) => x0).toList()),
				"label": jsonEncode(label),
				"region": jsonEncode(region),
				"version": jsonEncode(version),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byLanguageTypesLabelRegionVersion");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}
}