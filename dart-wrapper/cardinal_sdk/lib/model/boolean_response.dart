// auto-generated file


class BooleanResponse {
	bool response;
	BooleanResponse(this.response);

	factory BooleanResponse.fromJSON(Map<String, dynamic> data) {
		return BooleanResponse(
			(data["response"] as bool)
		);
	}

	static Map<String, dynamic> encode(BooleanResponse value) {
		Map<String, dynamic> entityAsMap = {
			"response" : value.response
		};
		return entityAsMap;
	}
}