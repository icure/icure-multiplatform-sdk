// auto-generated file
import 'package:cardinal_sdk/model/security/operation.dart';


class OperationToken {
	String tokenHash;
	int creationTime;
	int validity;
	Operation operation;
	String? description = null;
	OperationToken(
		this.tokenHash,
		this.creationTime,
		this.validity,
		this.operation,
		{
			String? description
		}) : description = description ?? null;

	factory OperationToken.fromJSON(Map<String, dynamic> data) {
		return OperationToken(
			(data["tokenHash"] as String),
			(data["creationTime"] as int),
			(data["validity"] as int),
			Operation.fromJSON(data["operation"]),
			description: (data["description"] as String?),
		);
	}

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
}