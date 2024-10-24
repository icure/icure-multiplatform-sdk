// auto-generated file
import 'package:cardinal_sdk/model/security/operation.dart';


class OperationToken {
	String tokenHash;
	int creationTime;
	int validity;
	Operation operation;
	String? description;
	OperationToken(
		this.tokenHash,
		this.creationTime,
		this.validity,
		this.operation,
		{
			this.description
		});

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