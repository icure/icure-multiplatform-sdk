// This file is auto-generated
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

	static Map<String, dynamic> encode(PersonName value) {
		Map<String, dynamic> entityAsMap = {
			"lastName" : value.lastName,
			"firstNames" : value.firstNames.map((x0) => x0),
			"start" : value.start,
			"end" : value.end,
			"prefix" : value.prefix.map((x0) => x0),
			"suffix" : value.suffix.map((x0) => x0),
			"text" : value.text,
			"use" : value.use == null ? null : PersonNameUse.encode(value.use!)
		};
		return entityAsMap;
	}
}