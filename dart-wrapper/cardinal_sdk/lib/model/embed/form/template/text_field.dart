// This file is auto-generated
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/form/template/field.dart';


class TextField implements Field {
	@override  String field;
	@override  String? shortLabel;
	int? _rows;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get rows => _rows;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set rows(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('rows value cannot exceed 2147483647');
		}
		_rows = value;
	}
	int? _columns;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get columns => _columns;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set columns(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('columns value cannot exceed 2147483647');
		}
		_columns = value;
	}
	@override  bool? grows;
	@override  bool? multiline;
	@override  String? schema;
	@override  List<String>? tags;
	@override  List<String>? codifications;
	@override  Map<String, String>? options;
	@override  Map<String, String>? labels;
	@override  String? value;
	@override  String? unit;
	@override  bool? required;
	@override  String? hideCondition;
	@override  bool? now;
	@override  bool? translate;

	TextField({
		required this.field,
		int? rows,
		int? columns,
		this.shortLabel,
		this.grows,
		this.multiline,
		this.schema,
		this.tags,
		this.codifications,
		this.options,
		this.labels,
		this.value,
		this.unit,
		this.required,
		this.hideCondition,
		this.now,
		this.translate
	}) : _rows = rows,
		_columns = columns;

	static Map<String, dynamic> encode(TextField value) {
		Map<String, dynamic> entityAsMap = {
			"field" : value.field,
			"shortLabel" : value.shortLabel,
			"rows" : value.rows,
			"columns" : value.columns,
			"grows" : value.grows,
			"multiline" : value.multiline,
			"schema" : value.schema,
			"tags" : value.tags?.map((x0) => x0),
			"codifications" : value.codifications?.map((x0) => x0),
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