// auto-generated file


class BooleanResponse {
	bool response;
	BooleanResponse(this.response);

	static Map<String, dynamic> encode(BooleanResponse value) {
		Map<String, dynamic> entityAsMap = {
			"response" : value.response
		};
		return entityAsMap;
	}

	static BooleanResponse fromJSON(Map<String, dynamic> data) {
		return BooleanResponse(
			(data["response"] as bool)
		);
	}
}