// auto-generated file
import 'package:cardinal_sdk/model/embed/person_name_use.dart';


class PersonName {
	String? lastName;
	List<String> firstNames = [];
	int? start;
	int? end;
	List<String> prefix = [];
	List<String> suffix = [];
	String? text;
	PersonNameUse? use;
	PersonName({
			this.lastName,
			this.start,
			this.end,
			this.text,
			this.use,
			List<String>? firstNames,
			List<String>? prefix,
			List<String>? suffix
		}) : firstNames = firstNames ?? [],
		prefix = prefix ?? [],
		suffix = suffix ?? [];

	factory PersonName.fromJSON(Map<String, dynamic> data) {
		return PersonName(
			lastName: data["lastName"],
			firstNames: data["firstNames"].map((x0) => x0 ).toList(),
			start: data["start"],
			end: data["end"],
			prefix: data["prefix"].map((x0) => x0 ).toList(),
			suffix: data["suffix"].map((x0) => x0 ).toList(),
			text: data["text"],
			use: data["use"] == null ? null : PersonNameUse.fromJSON(data["use"])
		);
	}

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
}