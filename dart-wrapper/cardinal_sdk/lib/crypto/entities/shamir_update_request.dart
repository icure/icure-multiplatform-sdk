// This file is auto-generated
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class ShamirUpdateRequest {
	Set<String> notariesIds;
	int _minShares;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get minShares => _minShares;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set minShares(int value) {
		if (value > 2147483647) {
			throw ArgumentError('minShares value cannot exceed 2147483647');
		}
		_minShares = value;
	}

	ShamirUpdateRequest({
		required this.notariesIds,
		required int minShares
	}) : _minShares = minShares;

	static Map<String, dynamic> encode(ShamirUpdateRequest value) {
		Map<String, dynamic> entityAsMap = {
			"notariesIds" : value.notariesIds.map((x0) => x0),
			"minShares" : value.minShares
		};
		return entityAsMap;
	}
}