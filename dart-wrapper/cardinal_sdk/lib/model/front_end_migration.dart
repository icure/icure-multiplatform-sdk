// auto-generated file
import 'package:cardinal_sdk/model/embed/front_end_migration_status.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class FrontEndMigration implements StoredDocument {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	String? name = null;
	int? startDate = null;
	int? endDate = null;
	FrontEndMigrationStatus? status = null;
	String? logs = null;
	String? userId = null;
	String? startKey = null;
	String? startKeyDocId = null;
	int? processCount = null;
	Set<DecryptedPropertyStub> properties = {};
	FrontEndMigration(
		this.id,
		{
			String? rev,
			int? deletionDate,
			String? name,
			int? startDate,
			int? endDate,
			FrontEndMigrationStatus? status,
			String? logs,
			String? userId,
			String? startKey,
			String? startKeyDocId,
			int? processCount,
			Set<DecryptedPropertyStub>? properties
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		name = name ?? null,
		startDate = startDate ?? null,
		endDate = endDate ?? null,
		status = status ?? null,
		logs = logs ?? null,
		userId = userId ?? null,
		startKey = startKey ?? null,
		startKeyDocId = startKeyDocId ?? null,
		processCount = processCount ?? null,
		properties = properties ?? {};

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
			(data["id"] as String),
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