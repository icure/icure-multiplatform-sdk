// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/keyword.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class KeywordPlatformApi {
	MethodChannel _methodChannel;
	KeywordPlatformApi(this._methodChannel);

	Future<Keyword> getKeyword(String sdkId, String frontEndMigrationId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'KeywordApi.getKeyword',
			{
				"sdkId": sdkId,
				"frontEndMigrationId": jsonEncode(frontEndMigrationId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getKeyword");
		final parsedResJson = jsonDecode(res);
		return Keyword.fromJSON(parsedResJson);
	}

	Future<Keyword> createKeyword(String sdkId, Keyword frontEndMigration) async {
		final res = await _methodChannel.invokeMethod<String>(
			'KeywordApi.createKeyword',
			{
				"sdkId": sdkId,
				"frontEndMigration": jsonEncode(Keyword.encode(frontEndMigration)),
			}
		);
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
		);
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
		);
		if (res == null) throw AssertionError("received null result from platform method getKeywordsByUser");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Keyword.fromJSON(x1) );
	}

	Future<List<DocIdentifier>> deleteKeywords(String sdkId, List<String> keywordIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'KeywordApi.deleteKeywords',
			{
				"sdkId": sdkId,
				"keywordIds": jsonEncode(keywordIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteKeywords");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}
}