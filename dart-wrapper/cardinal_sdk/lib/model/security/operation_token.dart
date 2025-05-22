// auto-generated file
import 'package:cardinal_sdk/model/security/operation.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "operation_token.freezed.dart";


@freezed
abstract class OperationToken with _$OperationToken {
	const factory OperationToken({
		required String tokenHash,
		required int creationTime,
		required int validity,
		required Operation operation,
		@Default(null) String? description,
	}) = _OperationToken;


	static Map<String, dynamic> encode(OperationToken value) {
		Map<String, dynamic> entityAsMap = {
			"tokenHash" : value.tokenHash,
			"creationTime" : value.creationTime,
			"validity" : value.validity,
			"operation" : Operation.encode(value.operation),
			"description" : value.description
		};
		return entityAsMap;
	}

	static OperationToken fromJSON(Map<String, dynamic> data) {
		return OperationToken(
			tokenHash: (data["tokenHash"] as String),
			creationTime: (data["creationTime"] as int),
			validity: (data["validity"] as int),
			operation: Operation.fromJSON(data["operation"]),
			description: (data["description"] as String?),
		);
	}
}