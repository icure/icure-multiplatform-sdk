// auto-generated file
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/crypto/entities/delegate_share_options.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "failed_request_details.freezed.dart";


@freezed
abstract class FailedRequestDetails with _$FailedRequestDetails {
	const factory FailedRequestDetails({
		required String entityId,
		required EntityReferenceInGroup delegateReference,
		required bool updatedForMigration,
		required int? code,
		required String? reason,
		required DelegateShareOptions? request,
		required bool shouldRetry,
	}) = _FailedRequestDetails;


	static Map<String, dynamic> encode(FailedRequestDetails value) {
		Map<String, dynamic> entityAsMap = {
			"entityId" : value.entityId,
			"delegateReference" : EntityReferenceInGroup.encode(value.delegateReference),
			"updatedForMigration" : value.updatedForMigration,
			"code" : value.code,
			"reason" : value.reason,
			"request" : value.request == null ? null : DelegateShareOptions.encode(value.request!),
			"shouldRetry" : value.shouldRetry
		};
		return entityAsMap;
	}

	static FailedRequestDetails fromJSON(Map<String, dynamic> data) {
		return FailedRequestDetails(
			entityId: (data["entityId"] as String),
			delegateReference: EntityReferenceInGroup.fromJSON(data["delegateReference"]),
			updatedForMigration: (data["updatedForMigration"] as bool),
			shouldRetry: (data["shouldRetry"] as bool),
			code: (data["code"] as int?),
			reason: (data["reason"] as String?),
			request: data["request"] == null ? null : DelegateShareOptions.fromJSON(data["request"]),
		);
	}
}