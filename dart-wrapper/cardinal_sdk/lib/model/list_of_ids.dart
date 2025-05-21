// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "list_of_ids.freezed.dart";


@freezed
abstract class ListOfIds with _$ListOfIds {
	const factory ListOfIds({
		@Default([]) List<String> ids,
	}) = _ListOfIds;


	static Map<String, dynamic> encode(ListOfIds value) {
		Map<String, dynamic> entityAsMap = {
			"ids" : value.ids.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static ListOfIds fromJSON(Map<String, dynamic> data) {
		return ListOfIds(
			ids: (data["ids"] as List<dynamic>).map((x0) => (x0 as String) ).toList()
		);
	}
}