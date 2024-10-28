// auto-generated file


class Right {
	String? userId = null;
	bool read = false;
	bool write = false;
	bool administration = false;
	Right({
			String? userId,
			bool? read,
			bool? write,
			bool? administration
		}) : userId = userId ?? null,
		read = read ?? false,
		write = write ?? false,
		administration = administration ?? false;

	factory Right.fromJSON(Map<String, dynamic> data) {
		return Right(
			userId: (data["userId"] as String?),
			read: (data["read"] as bool),
			write: (data["write"] as bool),
			administration: (data["administration"] as bool)
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