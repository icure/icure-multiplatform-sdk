// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/structure_element.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "fields_group.freezed.dart";


@freezed
abstract class FieldsGroup with _$FieldsGroup implements StructureElement {
	const factory FieldsGroup({
		required String group,
		@Default(null) List<StructureElement>? fields,
	}) = _FieldsGroup;


	static Map<String, dynamic> encode(FieldsGroup value) {
		Map<String, dynamic> entityAsMap = {
			"group" : value.group,
			"fields" : value.fields?.map((x0) => StructureElement.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static FieldsGroup fromJSON(Map<String, dynamic> data) {
		return FieldsGroup(
			group: (data["group"] as String),
			fields: (data["fields"] as List<dynamic>?)?.map((x0) => StructureElement.fromJSON(x0) ).toList(),
		);
	}
}