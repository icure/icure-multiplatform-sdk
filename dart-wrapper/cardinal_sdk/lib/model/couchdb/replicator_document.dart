// auto-generated file
import 'package:cardinal_sdk/model/couchdb/remote.dart';
import 'package:cardinal_sdk/model/couchdb/replication_stats.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';


class ReplicatorDocument implements Versionable<String> {
	@override String id;
	@override String? rev = null;
	Remote? source = null;
	Remote? target = null;
	String? owner = null;
	bool? create_target = null;
	bool? continuous = null;
	List<String>? doc_ids = null;
	String? replicationState = null;
	String? replicationStateTime = null;
	ReplicationStats? replicationStats = null;
	int? _errorCount = null;
	@ActualInt32() int? get errorCount => _errorCount;
	@ActualInt32() set errorCount(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('errorCount value cannot exceed 2147483647');
		}
		_errorCount = value;
	}
	List<Map<String, String>>? revsInfo = null;
	Map<String, String>? revHistory = null;
	ReplicatorDocument(
		this.id,
		{
			int? errorCount,
			String? rev,
			Remote? source,
			Remote? target,
			String? owner,
			bool? create_target,
			bool? continuous,
			List<String>? doc_ids,
			String? replicationState,
			String? replicationStateTime,
			ReplicationStats? replicationStats,
			List<Map<String, String>>? revsInfo,
			Map<String, String>? revHistory
		}) : rev = rev ?? null,
		source = source ?? null,
		target = target ?? null,
		owner = owner ?? null,
		create_target = create_target ?? null,
		continuous = continuous ?? null,
		doc_ids = doc_ids ?? null,
		replicationState = replicationState ?? null,
		replicationStateTime = replicationStateTime ?? null,
		replicationStats = replicationStats ?? null,
		revsInfo = revsInfo ?? null,
		revHistory = revHistory ?? null,
		_errorCount = errorCount ?? null;

	factory ReplicatorDocument.fromJSON(Map<String, dynamic> data) {
		return ReplicatorDocument(
			(data["id"] as String),
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
}