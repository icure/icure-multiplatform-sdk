// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "enable2fa_request.freezed.dart";


@freezed
abstract class Enable2faRequest with _$Enable2faRequest {
	const factory Enable2faRequest({
		required String secret,
		required int otpLength,
	}) = _Enable2faRequest;


	static Map<String, dynamic> encode(Enable2faRequest value) {
		Map<String, dynamic> entityAsMap = {
			"secret" : value.secret,
			"otpLength" : value.otpLength
		};
		return entityAsMap;
	}

	static Enable2faRequest fromJSON(Map<String, dynamic> data) {
		return Enable2faRequest(
			secret: (data["secret"] as String),
			otpLength: (data["otpLength"] as int)
		);
	}
}