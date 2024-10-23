// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class Enable2faRequest {
	String secret;
	int _otpLength;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get otpLength => _otpLength;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set otpLength(int value) {
		if (value > 2147483647) {
			throw ArgumentError('otpLength value cannot exceed 2147483647');
		}
		_otpLength = value;
	}
	Enable2faRequest(
		this.secret,
		int otpLength
		) : _otpLength = otpLength;

	factory Enable2faRequest.fromJSON(Map<String, dynamic> data) {
		return Enable2faRequest(
			data["secret"],
			data["otpLength"]
		);
	}

	static Map<String, dynamic> encode(Enable2faRequest value) {
		Map<String, dynamic> entityAsMap = {
			"secret" : value.secret,
			"otpLength" : value.otpLength
		};
		return entityAsMap;
	}
}