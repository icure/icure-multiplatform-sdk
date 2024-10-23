// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/front_end_migration.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class FrontEndMigrationPlatformApi {
	MethodChannel _methodChannel;
	FrontEndMigrationPlatformApi(this._methodChannel);

	Future<FrontEndMigration> getFrontEndMigration(String sdkId, String frontEndMigrationId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FrontEndMigrationApi.getFrontEndMigration',
			{
				"sdkId": sdkId,
				"frontEndMigrationId": jsonEncode(frontEndMigrationId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getFrontEndMigration");
		final parsedResJson = jsonDecode(res);
		return FrontEndMigration.fromJSON(parsedResJson);
	}

	Future<FrontEndMigration> createFrontEndMigration(String sdkId, FrontEndMigration frontEndMigration) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FrontEndMigrationApi.createFrontEndMigration',
			{
				"sdkId": sdkId,
				"frontEndMigration": jsonEncode(FrontEndMigration.encode(frontEndMigration)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createFrontEndMigration");
		final parsedResJson = jsonDecode(res);
		return FrontEndMigration.fromJSON(parsedResJson);
	}

	Future<List<FrontEndMigration>> getFrontEndMigrations(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FrontEndMigrationApi.getFrontEndMigrations',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getFrontEndMigrations");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => FrontEndMigration.fromJSON(x1) );
	}

	Future<DocIdentifier> deleteFrontEndMigration(String sdkId, String frontEndMigrationId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FrontEndMigrationApi.deleteFrontEndMigration',
			{
				"sdkId": sdkId,
				"frontEndMigrationId": jsonEncode(frontEndMigrationId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteFrontEndMigration");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<FrontEndMigration>> getFrontEndMigrationByName(String sdkId, String frontEndMigrationName) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FrontEndMigrationApi.getFrontEndMigrationByName',
			{
				"sdkId": sdkId,
				"frontEndMigrationName": jsonEncode(frontEndMigrationName),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getFrontEndMigrationByName");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => FrontEndMigration.fromJSON(x1) );
	}

	Future<FrontEndMigration> modifyFrontEndMigration(String sdkId, FrontEndMigration frontEndMigration) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FrontEndMigrationApi.modifyFrontEndMigration',
			{
				"sdkId": sdkId,
				"frontEndMigration": jsonEncode(FrontEndMigration.encode(frontEndMigration)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyFrontEndMigration");
		final parsedResJson = jsonDecode(res);
		return FrontEndMigration.fromJSON(parsedResJson);
	}
}