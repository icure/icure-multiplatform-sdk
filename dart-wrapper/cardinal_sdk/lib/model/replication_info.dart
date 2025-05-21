// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "replication_info.freezed.dart";


@freezed
abstract class ReplicationInfo with _$ReplicationInfo {
	const factory ReplicationInfo({
		@Default(false) bool active,
		@Default(false) bool running,
		@Default(null) int? pendingFrom,
		@Default(null) int? pendingTo,
	}) = _ReplicationInfo;


	static Map<String, dynamic> encode(ReplicationInfo value) {
		Map<String, dynamic> entityAsMap = {
			"active" : value.active,
			"running" : value.running,
			"pendingFrom" : value.pendingFrom,
			"pendingTo" : value.pendingTo
		};
		return entityAsMap;
	}

	static ReplicationInfo fromJSON(Map<String, dynamic> data) {
		return ReplicationInfo(
			pendingFrom: (data["pendingFrom"] as int?),
			pendingTo: (data["pendingTo"] as int?),
			active: (data["active"] as bool),
			running: (data["running"] as bool)
		);
	}
}