// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/code.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/boolean_response.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class CodePlatformApi {
	MethodChannel _methodChannel;
	CodePlatformApi(this._methodChannel);

	Future<List<Code>> listCodesByRegionTypeCodeVersion(String sdkId, String region, String? type, String? code, String? version) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.listCodesByRegionTypeCodeVersion',
			{
				"sdkId": sdkId,
				"region": jsonEncode(region),
				"type": jsonEncode(type),
				"code": jsonEncode(code),
				"version": jsonEncode(version),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listCodesByRegionTypeCodeVersion");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Code.fromJSON(x1) );
	}

	Future<List<String>> listCodeTypesBy(String sdkId, String? region, String? type) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.listCodeTypesBy',
			{
				"sdkId": sdkId,
				"region": jsonEncode(region),
				"type": jsonEncode(type),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listCodeTypesBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> listTagTypesBy(String sdkId, String? region, String? type) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.listTagTypesBy',
			{
				"sdkId": sdkId,
				"region": jsonEncode(region),
				"type": jsonEncode(type),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listTagTypesBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<Code> createCode(String sdkId, Code c) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.createCode',
			{
				"sdkId": sdkId,
				"c": jsonEncode(Code.encode(c)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createCode");
		final parsedResJson = jsonDecode(res);
		return Code.fromJSON(parsedResJson);
	}

	Future<List<Code>> createCodes(String sdkId, List<Code> codeBatch) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.createCodes',
			{
				"sdkId": sdkId,
				"codeBatch": jsonEncode(codeBatch.map((x0) => Code.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createCodes");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Code.fromJSON(x1) );
	}

	Future<List<Code>> createCodesInGroup(String sdkId, String groupId, List<Code> codeBatch) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.createCodesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"codeBatch": jsonEncode(codeBatch.map((x0) => Code.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createCodes");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Code.fromJSON(x1) );
	}

	Future<BooleanResponse> isCodeValid(String sdkId, String type, String code, String? version) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.isCodeValid',
			{
				"sdkId": sdkId,
				"type": jsonEncode(type),
				"code": jsonEncode(code),
				"version": jsonEncode(version),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method isCodeValid");
		final parsedResJson = jsonDecode(res);
		return BooleanResponse.fromJSON(parsedResJson);
	}

	Future<Code?> getCodeByRegionLanguageTypeLabel(String sdkId, String region, String label, String type, String? languages) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.getCodeByRegionLanguageTypeLabel',
			{
				"sdkId": sdkId,
				"region": jsonEncode(region),
				"label": jsonEncode(label),
				"type": jsonEncode(type),
				"languages": jsonEncode(languages),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCodeByRegionLanguageTypeLabel");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Code.fromJSON(parsedResJson);
	}

	Future<List<Code>> getCodes(String sdkId, List<String> codeIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.getCodes',
			{
				"sdkId": sdkId,
				"codeIds": jsonEncode(codeIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCodes");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Code.fromJSON(x1) );
	}

	Future<List<Code>> getCodesInGroup(String sdkId, String groupId, List<String> codeIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.getCodesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"codeIds": jsonEncode(codeIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCodes");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Code.fromJSON(x1) );
	}

	Future<Code> getCode(String sdkId, String codeId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.getCode',
			{
				"sdkId": sdkId,
				"codeId": jsonEncode(codeId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCode");
		final parsedResJson = jsonDecode(res);
		return Code.fromJSON(parsedResJson);
	}

	Future<Code> getCodeWithParts(String sdkId, String type, String code, String version) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.getCodeWithParts',
			{
				"sdkId": sdkId,
				"type": jsonEncode(type),
				"code": jsonEncode(code),
				"version": jsonEncode(version),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCodeWithParts");
		final parsedResJson = jsonDecode(res);
		return Code.fromJSON(parsedResJson);
	}

	Future<Code> modifyCode(String sdkId, Code codeDto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.modifyCode',
			{
				"sdkId": sdkId,
				"codeDto": jsonEncode(Code.encode(codeDto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyCode");
		final parsedResJson = jsonDecode(res);
		return Code.fromJSON(parsedResJson);
	}

	Future<List<Code>> modifyCodes(String sdkId, List<Code> codeBatch) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.modifyCodes',
			{
				"sdkId": sdkId,
				"codeBatch": jsonEncode(codeBatch.map((x0) => Code.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyCodes");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Code.fromJSON(x1) );
	}

	Future<List<Code>> modifyCodesInGroup(String sdkId, String groupId, List<Code> codeBatch) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.modifyCodesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"codeBatch": jsonEncode(codeBatch.map((x0) => Code.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyCodes");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Code.fromJSON(x1) );
	}

	Future<PaginatedListIterator<Code>> filterCodesBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.filterCodesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCodesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Code.fromJSON(x0));
	}

	Future<PaginatedListIterator<Code>> filterCodesBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.filterCodesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCodesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Code.fromJSON(x0));
	}

	Future<List<String>> matchCodesBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.matchCodesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchCodesBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchCodesBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.matchCodesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchCodesBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<void> importCodes(String sdkId, String codeType) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CodeApi.importCodes',
			{
				"sdkId": sdkId,
				"codeType": jsonEncode(codeType),
			}
		);
	}
}