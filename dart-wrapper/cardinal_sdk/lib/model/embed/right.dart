// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "right.freezed.dart";


@freezed
abstract class Right with _$Right {
	const factory Right({
		@Default(null) String? userId,
		@Default(false) bool read,
		@Default(false) bool write,
		@Default(false) bool administration,
	}) = _Right;


	static Map<String, dynamic> encode(Right value) {
		Map<String, dynamic> entityAsMap = {
			"userId" : value.userId,
			"read" : value.read,
			"write" : value.write,
			"administration" : value.administration
		};
		return entityAsMap;
	}

	static Right fromJSON(Map<String, dynamic> data) {
		return Right(
			userId: (data["userId"] as String?),
			read: (data["read"] as bool),
			write: (data["write"] as bool),
			administration: (data["administration"] as bool)
		);
	}
}