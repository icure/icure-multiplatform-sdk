// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/field.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "check_box.freezed.dart";


@freezed
abstract class CheckBox with _$CheckBox implements Field {
	const factory CheckBox({
		required String field,
		@Default(null) String? shortLabel,
		@Default(null) int? rows,
		@Default(null) int? columns,
		@Default(null) bool? grows,
		@Default(null) bool? multiline,
		@Default(null) String? schema,
		@Default(null) List<String>? tags,
		@Default(null) List<String>? codifications,
		@Default(null) Map<String, String>? options,
		@Default(null) Map<String, String>? labels,
		@Default(null) String? value,
		@Default(null) String? unit,
		@Default(null) bool? required,
		@Default(null) String? hideCondition,
		@Default(null) bool? now,
		@Default(null) bool? translate,
	}) = _CheckBox;


	static Map<String, dynamic> encode(CheckBox value) {
		Map<String, dynamic> entityAsMap = {
			"field" : value.field,
			"shortLabel" : value.shortLabel,
			"rows" : value.rows,
			"columns" : value.columns,
			"grows" : value.grows,
			"multiline" : value.multiline,
			"schema" : value.schema,
			"tags" : value.tags?.map((x0) => x0).toList(),
			"codifications" : value.codifications?.map((x0) => x0).toList(),
			"options" : value.options?.map((k0, v0) => MapEntry(k0, v0)),
			"labels" : value.labels?.map((k0, v0) => MapEntry(k0, v0)),
			"value" : value.value,
			"unit" : value.unit,
			"required" : value.required,
			"hideCondition" : value.hideCondition,
			"now" : value.now,
			"translate" : value.translate
		};
		return entityAsMap;
	}

	static CheckBox fromJSON(Map<String, dynamic> data) {
		return CheckBox(
			field: (data["field"] as String),
			rows: (data["rows"] as int?),
			columns: (data["columns"] as int?),
			shortLabel: (data["shortLabel"] as String?),
			grows: (data["grows"] as bool?),
			multiline: (data["multiline"] as bool?),
			schema: (data["schema"] as String?),
			tags: (data["tags"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
			codifications: (data["codifications"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
			options: (data["options"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			labels: (data["labels"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			value: (data["value"] as String?),
			unit: (data["unit"] as String?),
			required: (data["required"] as bool?),
			hideCondition: (data["hideCondition"] as String?),
			now: (data["now"] as bool?),
			translate: (data["translate"] as bool?),
		);
	}
}