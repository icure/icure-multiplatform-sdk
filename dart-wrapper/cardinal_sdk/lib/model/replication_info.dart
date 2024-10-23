// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class ReplicationInfo {
	bool active = false;
	bool running = false;
	int? _pendingFrom;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get pendingFrom => _pendingFrom;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set pendingFrom(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('pendingFrom value cannot exceed 2147483647');
		}
		_pendingFrom = value;
	}
	int? _pendingTo;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get pendingTo => _pendingTo;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set pendingTo(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('pendingTo value cannot exceed 2147483647');
		}
		_pendingTo = value;
	}
	ReplicationInfo({
			int? pendingFrom,
			int? pendingTo,
			bool? active,
			bool? running
		}) : active = active ?? false,
		running = running ?? false,
		_pendingFrom = pendingFrom,
		_pendingTo = pendingTo;

	factory ReplicationInfo.fromJSON(Map<String, dynamic> data) {
		return ReplicationInfo(
			pendingFrom: data["pendingFrom"],
			pendingTo: data["pendingTo"],
			active: data["active"],
			running: data["running"]
		);
	}

	static Map<String, dynamic> encode(ReplicationInfo value) {
		Map<String, dynamic> entityAsMap = {
			"active" : value.active,
			"running" : value.running,
			"pendingFrom" : value.pendingFrom,
			"pendingTo" : value.pendingTo
		};
		return entityAsMap;
	}
}