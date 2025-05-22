// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "view.freezed.dart";


@freezed
abstract class View with _$View {
	const factory View({
		required String map,
		@Default(null) String? reduce,
	}) = _View;


	static Map<String, dynamic> encode(View value) {
		Map<String, dynamic> entityAsMap = {
			"map" : value.map,
			"reduce" : value.reduce
		};
		return entityAsMap;
	}

	static View fromJSON(Map<String, dynamic> data) {
		return View(
			map: (data["map"] as String),
			reduce: (data["reduce"] as String?),
		);
	}
}