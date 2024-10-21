// This file is auto-generated
import 'package:cardinal_sdk/model/security/operation.dart';


class OperationToken {
	String tokenHash;
	int creationTime;
	int validity;
	Operation operation;
	String? description;

	OperationToken({
		required this.tokenHash,
		required this.creationTime,
		required this.validity,
		required this.operation,
		this.description
	});

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