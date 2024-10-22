// This file is auto-generated
import 'package:cardinal_sdk/model/embed/database_synchronization.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class Replication implements StoredDocument, Identifiable<String>, Named {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	@override String? name;
	String? context;
	List<DatabaseSynchronization> databaseSynchronizations = [];
	Replication(
		this.id,
		{
			this.rev,
			this.deletionDate,
			this.name,
			this.context,
			List<DatabaseSynchronization>? databaseSynchronizations
		}) : databaseSynchronizations = databaseSynchronizations ?? [];

	factory Replication.fromJSON(Map<String, dynamic> data) {
		return Replication(
			data["id"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			name: data["name"],
			context: data["context"],
			databaseSynchronizations: data["databaseSynchronizations"].map((x0) => DatabaseSynchronization.fromJSON(x0) ),
		);
	}

	static Map<String, dynamic> encode(Replication value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"context" : value.context,
			"databaseSynchronizations" : value.databaseSynchronizations.map((x0) => DatabaseSynchronization.encode(x0))
		};
		return entityAsMap;
	}
}