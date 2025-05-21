// auto-generated file
import 'package:cardinal_sdk/model/embed/front_end_migration_status.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "front_end_migration.freezed.dart";


@freezed
abstract class FrontEndMigration with _$FrontEndMigration implements StoredDocument {
	const factory FrontEndMigration({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? name,
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) FrontEndMigrationStatus? status,
		@Default(null) String? logs,
		@Default(null) String? userId,
		@Default(null) String? startKey,
		@Default(null) String? startKeyDocId,
		@Default(null) int? processCount,
		@Default({}) Set<DecryptedPropertyStub> properties,
	}) = _FrontEndMigration;


	static Map<String, dynamic> encode(FrontEndMigration value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"status" : value.status == null ? null : FrontEndMigrationStatus.encode(value.status!),
			"logs" : value.logs,
			"userId" : value.userId,
			"startKey" : value.startKey,
			"startKeyDocId" : value.startKeyDocId,
			"processCount" : value.processCount,
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static FrontEndMigration fromJSON(Map<String, dynamic> data) {
		return FrontEndMigration(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			status: data["status"] == null ? null : FrontEndMigrationStatus.fromJSON(data["status"]),
			logs: (data["logs"] as String?),
			userId: (data["userId"] as String?),
			startKey: (data["startKey"] as String?),
			startKeyDocId: (data["startKeyDocId"] as String?),
			processCount: (data["processCount"] as int?),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
		);
	}
}