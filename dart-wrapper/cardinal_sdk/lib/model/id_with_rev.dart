// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "id_with_rev.freezed.dart";


@freezed
abstract class IdWithRev with _$IdWithRev {
	const factory IdWithRev({
		required String id,
		@Default(null) String? rev,
	}) = _IdWithRev;


	static Map<String, dynamic> encode(IdWithRev value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}

	static IdWithRev fromJSON(Map<String, dynamic> data) {
		return IdWithRev(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
		);
	}
}