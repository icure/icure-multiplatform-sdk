// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/front_end_migration.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class FrontEndMigrationApi {
	final String _sdkId;
	FrontEndMigrationApi(this._sdkId);

	Future<FrontEndMigration> getFrontEndMigration(String frontEndMigrationId) async {
		return await CardinalSdkPlatformInterface.instance.apis.frontEndMigration.getFrontEndMigration(
			_sdkId,
			frontEndMigrationId,
		);
	}

	Future<FrontEndMigration> createFrontEndMigration(FrontEndMigration frontEndMigration) async {
		return await CardinalSdkPlatformInterface.instance.apis.frontEndMigration.createFrontEndMigration(
			_sdkId,
			frontEndMigration,
		);
	}

	Future<List<FrontEndMigration>> getFrontEndMigrations() async {
		return await CardinalSdkPlatformInterface.instance.apis.frontEndMigration.getFrontEndMigrations(
			_sdkId,
		);
	}

	Future<DocIdentifier> deleteFrontEndMigration(String frontEndMigrationId) async {
		return await CardinalSdkPlatformInterface.instance.apis.frontEndMigration.deleteFrontEndMigration(
			_sdkId,
			frontEndMigrationId,
		);
	}

	Future<List<FrontEndMigration>> getFrontEndMigrationByName(String frontEndMigrationName) async {
		return await CardinalSdkPlatformInterface.instance.apis.frontEndMigration.getFrontEndMigrationByName(
			_sdkId,
			frontEndMigrationName,
		);
	}

	Future<FrontEndMigration> modifyFrontEndMigration(FrontEndMigration frontEndMigration) async {
		return await CardinalSdkPlatformInterface.instance.apis.frontEndMigration.modifyFrontEndMigration(
			_sdkId,
			frontEndMigration,
		);
	}
}