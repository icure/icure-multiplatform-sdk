// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';


class HealthcarePartyPlatformFilters {
	MethodChannel _methodChannel;
	HealthcarePartyPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<HealthcareParty>> all() async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.all',
			{
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method all");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<HealthcareParty>> byIdentifiers(List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.byIdentifiers',
			{
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiers");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthcareParty>> byCode(String codeType, { String? codeCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.byCode',
			{
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byCode");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthcareParty>> byTag(String tagType, { String? tagCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.byTag',
			{
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTag");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthcareParty>> byIds(List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.byIds',
			{
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byIds");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthcareParty>> byName(String searchString, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.byName',
			{
				"searchString": jsonEncode(searchString),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byName");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthcareParty>> byNationalIdentifier(String searchString, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.byNationalIdentifier',
			{
				"searchString": jsonEncode(searchString),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byNationalIdentifier");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<HealthcareParty>> byParentId(String parentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.byParentId',
			{
				"parentId": jsonEncode(parentId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byParentId");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<HealthcareParty>> byTypeSpecialtyPostCode(String specialty, String specCode, String startPostCode, String endPostCode) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyFilters.byTypeSpecialtyPostCode',
			{
				"specialty": jsonEncode(specialty),
				"specCode": jsonEncode(specCode),
				"startPostCode": jsonEncode(startPostCode),
				"endPostCode": jsonEncode(endPostCode),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTypeSpecialtyPostCode");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}
}