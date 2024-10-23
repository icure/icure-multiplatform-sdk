// auto-generated file
import 'package:cardinal_sdk/model/embed/front_end_migration_status.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class FrontEndMigration implements StoredDocument {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	String? name;
	int? startDate;
	int? endDate;
	FrontEndMigrationStatus? status;
	String? logs;
	String? userId;
	String? startKey;
	String? startKeyDocId;
	int? processCount;
	Set<DecryptedPropertyStub> properties = {};
	FrontEndMigration(
		this.id,
		{
			this.rev,
			this.deletionDate,
			this.name,
			this.startDate,
			this.endDate,
			this.status,
			this.logs,
			this.userId,
			this.startKey,
			this.startKeyDocId,
			this.processCount,
			Set<DecryptedPropertyStub>? properties
		}) : properties = properties ?? {};

	factory FrontEndMigration.fromJSON(Map<String, dynamic> data) {
		return FrontEndMigration(
			data["id"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			name: data["name"],
			startDate: data["startDate"],
			endDate: data["endDate"],
			status: data["status"] == null ? null : FrontEndMigrationStatus.fromJSON(data["status"]),
			logs: data["logs"],
			userId: data["userId"],
			startKey: data["startKey"],
			startKeyDocId: data["startKeyDocId"],
			processCount: data["processCount"],
			properties: data["properties"].map((x0) => DecryptedPropertyStub.fromJSON(x0) ),
		);
	}

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
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0))
		};
		return entityAsMap;
	}
}