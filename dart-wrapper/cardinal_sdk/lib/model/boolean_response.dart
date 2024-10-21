// This file is auto-generated


class BooleanResponse {
	bool response;

	BooleanResponse({
		required this.response
	});

	static Map<String, dynamic> encode(BooleanResponse value) {
		Map<String, dynamic> entityAsMap = {
			"response" : value.response
		};
		return entityAsMap;
	}
}