// auto-generated file
import 'package:cardinal_sdk/model/embed/database_synchronization.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class Replication implements StoredDocument, Identifiable<String>, Named {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	@override String? name = null;
	String? context = null;
	List<DatabaseSynchronization> databaseSynchronizations = [];
	Replication(
		this.id,
		{
			String? rev,
			int? deletionDate,
			String? name,
			String? context,
			List<DatabaseSynchronization>? databaseSynchronizations
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		name = name ?? null,
		context = context ?? null,
		databaseSynchronizations = databaseSynchronizations ?? [];

	static Map<String, dynamic> encode(Replication value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"context" : value.context,
			"databaseSynchronizations" : value.databaseSynchronizations.map((x0) => DatabaseSynchronization.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static Replication fromJSON(Map<String, dynamic> data) {
		return Replication(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			context: (data["context"] as String?),
			databaseSynchronizations: (data["databaseSynchronizations"] as List<dynamic>).map((x0) => DatabaseSynchronization.fromJSON(x0) ).toList(),
		);
	}
}