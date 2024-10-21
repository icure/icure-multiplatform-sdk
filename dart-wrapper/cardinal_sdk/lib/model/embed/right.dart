// This file is auto-generated


class Right {
	String? userId;
	bool read = false;
	bool write = false;
	bool administration = false;

	Right({
		this.userId,
		bool? read,
		bool? write,
		bool? administration
	}) : read = read ?? false,
		write = write ?? false,
		administration = administration ?? false;

	static Map<String, dynamic> encode(Right value) {
		Map<String, dynamic> entityAsMap = {
			"userId" : value.userId,
			"read" : value.read,
			"write" : value.write,
			"administration" : value.administration
		};
		return entityAsMap;
	}
}