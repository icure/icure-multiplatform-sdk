// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/keyword.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class KeywordApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	KeywordApi(
		this._sdkId,
		this._dartSdk
		);

	Future<Keyword> getKeyword(String frontEndMigrationId) async {
		return await CardinalSdkPlatformInterface.instance.apis.keyword.getKeyword(
			_sdkId,
			frontEndMigrationId,
		);
	}

	Future<Keyword> createKeyword(Keyword frontEndMigration) async {
		return await CardinalSdkPlatformInterface.instance.apis.keyword.createKeyword(
			_sdkId,
			frontEndMigration,
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