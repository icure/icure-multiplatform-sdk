// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/form/template/field.dart';


class DropdownField implements Field {
	@override String field;
	@override String? shortLabel = null;
	int? _rows = null;
	@ActualInt32() @override int? get rows => _rows;
	@ActualInt32() @override set rows(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('rows value cannot exceed 2147483647');
		}
		_rows = value;
	}
	int? _columns = null;
	@ActualInt32() @override int? get columns => _columns;
	@ActualInt32() @override set columns(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('columns value cannot exceed 2147483647');
		}
		_columns = value;
	}
	@override bool? grows = null;
	@override bool? multiline = null;
	@override String? schema = null;
	@override List<String>? tags = null;
	@override List<String>? codifications = null;
	@override Map<String, String>? options = null;
	@override Map<String, String>? labels = null;
	@override String? value = null;
	@override String? unit = null;
	@override bool? required = null;
	@override String? hideCondition = null;
	@override bool? now = null;
	@override bool? translate = null;
	DropdownField(
		this.field,
		{
			int? rows,
			int? columns,
			String? shortLabel,
			bool? grows,
			bool? multiline,
			String? schema,
			List<String>? tags,
			List<String>? codifications,
			Map<String, String>? options,
			Map<String, String>? labels,
			String? value,
			String? unit,
			bool? required,
			String? hideCondition,
			bool? now,
			bool? translate
		}) : shortLabel = shortLabel ?? null,
		grows = grows ?? null,
		multiline = multiline ?? null,
		schema = schema ?? null,
		tags = tags ?? null,
		codifications = codifications ?? null,
		options = options ?? null,
		labels = labels ?? null,
		value = value ?? null,
		unit = unit ?? null,
		required = required ?? null,
		hideCondition = hideCondition ?? null,
		now = now ?? null,
		translate = translate ?? null,
		_rows = rows ?? null,
		_columns = columns ?? null;

	factory DropdownField.fromJSON(Map<String, dynamic> data) {
		return DropdownField(
			(data["field"] as String),
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

	static Map<String, dynamic> encode(DropdownField value) {
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
}