// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/crypto/entities/delegate_share_options.dart';


class FailedRequestDetails {
	String entityId;
	String delegateId;
	bool updatedForMigration;
	int? _code;
	@ActualInt32() int? get code => _code;
	@ActualInt32() set code(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('code value cannot exceed 2147483647');
		}
		_code = value;
	}
	String? reason;
	DelegateShareOptions? request;
	bool shouldRetry;
	FailedRequestDetails(
		this.entityId,
		this.delegateId,
		this.updatedForMigration,
		this.shouldRetry,
		{
			int? code,
			this.reason,
			this.request
		}) : _code = code;

	factory FailedRequestDetails.fromJSON(Map<String, dynamic> data) {
		return FailedRequestDetails(
			data["entityId"],
			data["delegateId"],
			data["updatedForMigration"],
			data["shouldRetry"],
			code: data["code"],
			reason: data["reason"],
			request: data["request"] == null ? null : DelegateShareOptions.fromJSON(data["request"]),
		);
	}

	static Map<String, dynamic> encode(FailedRequestDetails value) {
		Map<String, dynamic> entityAsMap = {
			"entityId" : value.entityId,
			"delegateId" : value.delegateId,
			"updatedForMigration" : value.updatedForMigration,
			"code" : value.code,
			"reason" : value.reason,
			"request" : value.request == null ? null : DelegateShareOptions.encode(value.request!),
			"shouldRetry" : value.shouldRetry
		};
		return entityAsMap;
	}
}