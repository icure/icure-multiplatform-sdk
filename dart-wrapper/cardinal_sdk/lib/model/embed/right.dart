// auto-generated file


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

	factory Right.fromJSON(Map<String, dynamic> data) {
		return Right(
			userId: data["userId"],
			read: data["read"],
			write: data["write"],
			administration: data["administration"]
		);
	}

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