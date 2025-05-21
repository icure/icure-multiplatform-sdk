// auto-generated file
import 'package:cardinal_sdk/model/embed/person_name_use.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "person_name.freezed.dart";


@freezed
abstract class PersonName with _$PersonName {
	const factory PersonName({
		@Default(null) String? lastName,
		@Default([]) List<String> firstNames,
		@Default(null) int? start,
		@Default(null) int? end,
		@Default([]) List<String> prefix,
		@Default([]) List<String> suffix,
		@Default(null) String? text,
		@Default(null) PersonNameUse? use,
	}) = _PersonName;


	static Map<String, dynamic> encode(PersonName value) {
		Map<String, dynamic> entityAsMap = {
			"lastName" : value.lastName,
			"firstNames" : value.firstNames.map((x0) => x0).toList(),
			"start" : value.start,
			"end" : value.end,
			"prefix" : value.prefix.map((x0) => x0).toList(),
			"suffix" : value.suffix.map((x0) => x0).toList(),
			"text" : value.text,
			"use" : value.use == null ? null : PersonNameUse.encode(value.use!)
		};
		return entityAsMap;
	}

	static PersonName fromJSON(Map<String, dynamic> data) {
		return PersonName(
			lastName: (data["lastName"] as String?),
			firstNames: (data["firstNames"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			start: (data["start"] as int?),
			end: (data["end"] as int?),
			prefix: (data["prefix"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			suffix: (data["suffix"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			text: (data["text"] as String?),
			use: data["use"] == null ? null : PersonNameUse.fromJSON(data["use"])
		);
	}
}