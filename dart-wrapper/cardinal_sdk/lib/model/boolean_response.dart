// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "boolean_response.freezed.dart";


@freezed
abstract class BooleanResponse with _$BooleanResponse {
	const factory BooleanResponse({
		required bool response,
	}) = _BooleanResponse;


	static Map<String, dynamic> encode(BooleanResponse value) {
		Map<String, dynamic> entityAsMap = {
			"response" : value.response
		};
		return entityAsMap;
	}

	static BooleanResponse fromJSON(Map<String, dynamic> data) {
		return BooleanResponse(
			response: (data["response"] as bool)
		);
	}
}