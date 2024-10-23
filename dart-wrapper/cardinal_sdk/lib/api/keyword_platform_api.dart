// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/keyword.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class KeywordPlatformApi {
	String _sdkId;
	KeywordPlatformApi(this._sdkId);

	Future<Keyword> getKeyword(String frontEndMigrationId) async {
		return await CardinalSdkPlatformInterface.instance.keyword.getKeyword(
			_sdkId,
			frontEndMigrationId,
		);
	}

	Future<Keyword> createKeyword(Keyword frontEndMigration) async {
		return await CardinalSdkPlatformInterface.instance.keyword.createKeyword(
			_sdkId,
			frontEndMigration,
		);
	}

	Future<Keyword> modifyKeyword(Keyword keyword) async {
		return await CardinalSdkPlatformInterface.instance.keyword.modifyKeyword(
			_sdkId,
			keyword,
		);
	}

	Future<List<Keyword>> getKeywordsByUser(String userId) async {
		return await CardinalSdkPlatformInterface.instance.keyword.getKeywordsByUser(
			_sdkId,
			userId,
		);
	}

	Future<List<DocIdentifier>> deleteKeywords(List<String> keywordIds) async {
		return await CardinalSdkPlatformInterface.instance.keyword.deleteKeywords(
			_sdkId,
			keywordIds,
		);
	}
}