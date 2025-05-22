// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "indexing_info.freezed.dart";


@freezed
abstract class IndexingInfo with _$IndexingInfo {
	const factory IndexingInfo({
		@Default(null) Map<String, int>? statuses,
	}) = _IndexingInfo;


	static Map<String, dynamic> encode(IndexingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"statuses" : value.statuses?.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}

	static IndexingInfo fromJSON(Map<String, dynamic> data) {
		return IndexingInfo(
			statuses: (data["statuses"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as int)))
		);
	}
}