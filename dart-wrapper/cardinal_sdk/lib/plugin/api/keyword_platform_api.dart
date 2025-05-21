// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/keyword.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class KeywordPlatformApi {
	MethodChannel _methodChannel;
	KeywordPlatformApi(this._methodChannel);

	Future<Keyword?> getKeyword(String sdkId, String keywordId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'KeywordApi.getKeyword',
			{
				"sdkId": sdkId,
				"keywordId": jsonEncode(keywordId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getKeyword");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Keyword.fromJSON(parsedResJson);
	}

	Future<Keyword> createKeyword(String sdkId, Keyword keyword) async {
		final res = await _methodChannel.invokeMethod<String>(
			'KeywordApi.createKeyword',
			{
				"sdkId": sdkId,
				"keyword": jsonEncode(Keyword.encode(keyword)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createKeyword");
		final parsedResJson = jsonDecode(res);
		return Keyword.fromJSON(parsedResJson);
	}

	Future<Keyword> modifyKeyword(String sdkId, Keyword keyword) async {
		final res = await _methodChannel.invokeMethod<String>(
			'KeywordApi.modifyKeyword',
			{
				"sdkId": sdkId,
				"keyword": jsonEncode(Keyword.encode(keyword)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyKeyword");
		final parsedResJson = jsonDecode(res);
		return Keyword.fromJSON(parsedResJson);
	}

	Future<List<Keyword>> getKeywordsByUser(String sdkId, String userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'KeywordApi.getKeywordsByUser',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getKeywordsByUser");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Keyword.fromJSON(x1) ).toList();
	}

	Future<List<DocIdentifier>> deleteKeywords(String sdkId, List<String> keywordIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'KeywordApi.deleteKeywords',
			{
				"sdkId": sdkId,
				"keywordIds": jsonEncode(keywordIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteKeywords");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}
}