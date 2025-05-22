// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "shamir_update_request.freezed.dart";


@freezed
abstract class ShamirUpdateRequest with _$ShamirUpdateRequest {
	const factory ShamirUpdateRequest({
		required Set<String> notariesIds,
		required int minShares,
	}) = _ShamirUpdateRequest;


	static Map<String, dynamic> encode(ShamirUpdateRequest value) {
		Map<String, dynamic> entityAsMap = {
			"notariesIds" : value.notariesIds.map((x0) => x0).toList(),
			"minShares" : value.minShares
		};
		return entityAsMap;
	}

	static ShamirUpdateRequest fromJSON(Map<String, dynamic> data) {
		return ShamirUpdateRequest(
			notariesIds: (data["notariesIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			minShares: (data["minShares"] as int)
		);
	}
}