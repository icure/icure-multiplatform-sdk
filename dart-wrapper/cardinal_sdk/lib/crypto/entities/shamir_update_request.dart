// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class ShamirUpdateRequest {
	Set<String> notariesIds;
	int _minShares;
	@ActualInt32() int get minShares => _minShares;
	@ActualInt32() set minShares(int value) {
		if (value > 2147483647) {
			throw ArgumentError('minShares value cannot exceed 2147483647');
		}
		_minShares = value;
	}
	ShamirUpdateRequest(
		this.notariesIds,
		int minShares
		) : _minShares = minShares;

	static Map<String, dynamic> encode(ShamirUpdateRequest value) {
		Map<String, dynamic> entityAsMap = {
			"notariesIds" : value.notariesIds.map((x0) => x0).toList(),
			"minShares" : value.minShares
		};
		return entityAsMap;
	}

	static ShamirUpdateRequest fromJSON(Map<String, dynamic> data) {
		return ShamirUpdateRequest(
			(data["notariesIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			(data["minShares"] as int)
		);
	}
}