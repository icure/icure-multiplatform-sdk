// This file is auto-generated
import 'package:cardinal_sdk/model/couchdb/remote.dart';
import 'package:cardinal_sdk/model/couchdb/replication_stats.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';


class ReplicatorDocument implements Versionable<String> {
	@override  String id;
	@override  String? rev;
	Remote? source;
	Remote? target;
	String? owner;
	bool? create_target;
	bool? continuous;
	List<String>? doc_ids;
	String? replicationState;
	String? replicationStateTime;
	ReplicationStats? replicationStats;
	int? _errorCount;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get errorCount => _errorCount;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set errorCount(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('errorCount value cannot exceed 2147483647');
		}
		_errorCount = value;
	}
	List<Map<String, String>>? revsInfo;
	Map<String, String>? revHistory;

	ReplicatorDocument({
		required this.id,
		int? errorCount,
		this.rev,
		this.source,
		this.target,
		this.owner,
		this.create_target,
		this.continuous,
		this.doc_ids,
		this.replicationState,
		this.replicationStateTime,
		this.replicationStats,
		this.revsInfo,
		this.revHistory
	}) : _errorCount = errorCount;

	static Map<String, dynamic> encode(ReplicatorDocument value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"source" : value.source == null ? null : Remote.encode(value.source!),
			"target" : value.target == null ? null : Remote.encode(value.target!),
			"owner" : value.owner,
			"create_target" : value.create_target,
			"continuous" : value.continuous,
			"doc_ids" : value.doc_ids?.map((x0) => x0),
			"replicationState" : value.replicationState,
			"replicationStateTime" : value.replicationStateTime,
			"replicationStats" : value.replicationStats == null ? null : ReplicationStats.encode(value.replicationStats!),
			"errorCount" : value.errorCount,
			"revsInfo" : value.revsInfo?.map((x0) => x0.map((k1, v1) => MapEntry(k1, v1))),
			"revHistory" : value.revHistory?.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}