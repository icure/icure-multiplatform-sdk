// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/keyword.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class KeywordApi {
	final String _sdkId;
	final Object _dartSdk;
	KeywordApi(
		this._sdkId,
		this._dartSdk
		);

	Future<Keyword?> getKeyword(String keywordId) async {
		return await CardinalSdkPlatformInterface.instance.apis.keyword.getKeyword(
			_sdkId,
			keywordId,
		);
	}

	Future<Keyword> createKeyword(Keyword keyword) async {
		return await CardinalSdkPlatformInterface.instance.apis.keyword.createKeyword(
			_sdkId,
			keyword,
		);
	}

	Future<Keyword> modifyKeyword(Keyword keyword) async {
		return await CardinalSdkPlatformInterface.instance.apis.keyword.modifyKeyword(
			_sdkId,
			keyword,
		);
	}

	Future<List<Keyword>> getKeywordsByUser(String userId) async {
		return await CardinalSdkPlatformInterface.instance.apis.keyword.getKeywordsByUser(
			_sdkId,
			userId,
		);
	}

	Future<List<DocIdentifier>> deleteKeywords(List<String> keywordIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.keyword.deleteKeywords(
			_sdkId,
			keywordIds,
		);
	}
}