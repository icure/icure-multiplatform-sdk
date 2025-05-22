// auto-generated file
import 'package:cardinal_sdk/model/embed/database_synchronization.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "replication.freezed.dart";


@freezed
abstract class Replication with _$Replication implements StoredDocument, Identifiable<String>, Named {
	const factory Replication({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? name,
		@Default(null) String? context,
		@Default([]) List<DatabaseSynchronization> databaseSynchronizations,
	}) = _Replication;


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
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			context: (data["context"] as String?),
			databaseSynchronizations: (data["databaseSynchronizations"] as List<dynamic>).map((x0) => DatabaseSynchronization.fromJSON(x0) ).toList(),
		);
	}
}