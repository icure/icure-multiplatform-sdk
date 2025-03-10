// auto-generated file
import 'package:cardinal_sdk/model/embed/person_name_use.dart';


class PersonName {
	String? lastName = null;
	List<String> firstNames = [];
	int? start = null;
	int? end = null;
	List<String> prefix = [];
	List<String> suffix = [];
	String? text = null;
	PersonNameUse? use = null;
	PersonName({
			String? lastName,
			List<String>? firstNames,
			int? start,
			int? end,
			List<String>? prefix,
			List<String>? suffix,
			String? text,
			PersonNameUse? use
		}) : lastName = lastName ?? null,
		firstNames = firstNames ?? [],
		start = start ?? null,
		end = end ?? null,
		prefix = prefix ?? [],
		suffix = suffix ?? [],
		text = text ?? null,
		use = use ?? null;

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