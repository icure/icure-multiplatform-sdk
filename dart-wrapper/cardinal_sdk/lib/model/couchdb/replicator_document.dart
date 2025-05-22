// auto-generated file
import 'package:cardinal_sdk/model/couchdb/remote.dart';
import 'package:cardinal_sdk/model/couchdb/replication_stats.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "replicator_document.freezed.dart";


@freezed
abstract class ReplicatorDocument with _$ReplicatorDocument implements Versionable<String> {
	const factory ReplicatorDocument({
		required String id,
		@Default(null) String? rev,
		@Default(null) Remote? source,
		@Default(null) Remote? target,
		@Default(null) String? owner,
		@Default(null) bool? create_target,
		@Default(null) bool? continuous,
		@Default(null) List<String>? doc_ids,
		@Default(null) String? replicationState,
		@Default(null) String? replicationStateTime,
		@Default(null) ReplicationStats? replicationStats,
		@Default(null) int? errorCount,
		@Default(null) List<Map<String, String>>? revsInfo,
		@Default(null) Map<String, String>? revHistory,
	}) = _ReplicatorDocument;


	static Map<String, dynamic> encode(ReplicatorDocument value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"source" : value.source == null ? null : Remote.encode(value.source!),
			"target" : value.target == null ? null : Remote.encode(value.target!),
			"owner" : value.owner,
			"create_target" : value.create_target,
			"continuous" : value.continuous,
			"doc_ids" : value.doc_ids?.map((x0) => x0).toList(),
			"replicationState" : value.replicationState,
			"replicationStateTime" : value.replicationStateTime,
			"replicationStats" : value.replicationStats == null ? null : ReplicationStats.encode(value.replicationStats!),
			"errorCount" : value.errorCount,
			"revsInfo" : value.revsInfo?.map((x0) => x0.map((k1, v1) => MapEntry(k1, v1))).toList(),
			"revHistory" : value.revHistory?.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}

	static ReplicatorDocument fromJSON(Map<String, dynamic> data) {
		return ReplicatorDocument(
			id: (data["id"] as String),
			errorCount: (data["errorCount"] as int?),
			rev: (data["rev"] as String?),
			source: data["source"] == null ? null : Remote.fromJSON(data["source"]),
			target: data["target"] == null ? null : Remote.fromJSON(data["target"]),
			owner: (data["owner"] as String?),
			create_target: (data["create_target"] as bool?),
			continuous: (data["continuous"] as bool?),
			doc_ids: (data["doc_ids"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
			replicationState: (data["replicationState"] as String?),
			replicationStateTime: (data["replicationStateTime"] as String?),
			replicationStats: data["replicationStats"] == null ? null : ReplicationStats.fromJSON(data["replicationStats"]),
			revsInfo: (data["revsInfo"] as List<dynamic>?)?.map((x0) => (x0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as String))) ).toList(),
			revHistory: (data["revHistory"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
		);
	}
}