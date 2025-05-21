// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "database_info.freezed.dart";


@freezed
abstract class DatabaseInfo with _$DatabaseInfo {
	const factory DatabaseInfo({
		required String id,
		@Default(null) String? updateSeq,
		@Default(null) int? fileSize,
		@Default(null) int? externalSize,
		@Default(null) int? activeSize,
		@Default(null) int? docs,
		@Default(null) int? q,
		@Default(null) int? n,
		@Default(null) int? w,
		@Default(null) int? r,
	}) = _DatabaseInfo;


	static Map<String, dynamic> encode(DatabaseInfo value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"updateSeq" : value.updateSeq,
			"fileSize" : value.fileSize,
			"externalSize" : value.externalSize,
			"activeSize" : value.activeSize,
			"docs" : value.docs,
			"q" : value.q,
			"n" : value.n,
			"w" : value.w,
			"r" : value.r
		};
		return entityAsMap;
	}

	static DatabaseInfo fromJSON(Map<String, dynamic> data) {
		return DatabaseInfo(
			id: (data["id"] as String),
			q: (data["q"] as int?),
			n: (data["n"] as int?),
			w: (data["w"] as int?),
			r: (data["r"] as int?),
			updateSeq: (data["updateSeq"] as String?),
			fileSize: (data["fileSize"] as int?),
			externalSize: (data["externalSize"] as int?),
			activeSize: (data["activeSize"] as int?),
			docs: (data["docs"] as int?),
		);
	}
}