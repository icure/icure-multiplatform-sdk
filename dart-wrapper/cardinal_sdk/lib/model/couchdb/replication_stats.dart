// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "replication_stats.freezed.dart";


@freezed
abstract class ReplicationStats with _$ReplicationStats {
	const factory ReplicationStats({
		@Default(null) int? revisionsChecked,
		@Default(null) int? missingRevisionsFound,
		@Default(null) int? docsRead,
		@Default(null) int? docsWritten,
		@Default(null) int? changesPending,
		@Default(null) int? docWriteFailures,
		@Default(null) String? checkpointedSourceSeq,
		@Default(null) String? startTime,
		@Default(null) String? error,
	}) = _ReplicationStats;


	static Map<String, dynamic> encode(ReplicationStats value) {
		Map<String, dynamic> entityAsMap = {
			"revisionsChecked" : value.revisionsChecked,
			"missingRevisionsFound" : value.missingRevisionsFound,
			"docsRead" : value.docsRead,
			"docsWritten" : value.docsWritten,
			"changesPending" : value.changesPending,
			"docWriteFailures" : value.docWriteFailures,
			"checkpointedSourceSeq" : value.checkpointedSourceSeq,
			"startTime" : value.startTime,
			"error" : value.error
		};
		return entityAsMap;
	}

	static ReplicationStats fromJSON(Map<String, dynamic> data) {
		return ReplicationStats(
			revisionsChecked: (data["revisionsChecked"] as int?),
			missingRevisionsFound: (data["missingRevisionsFound"] as int?),
			docsRead: (data["docsRead"] as int?),
			docsWritten: (data["docsWritten"] as int?),
			changesPending: (data["changesPending"] as int?),
			docWriteFailures: (data["docWriteFailures"] as int?),
			checkpointedSourceSeq: (data["checkpointedSourceSeq"] as String?),
			startTime: (data["startTime"] as String?),
			error: (data["error"] as String?)
		);
	}
}