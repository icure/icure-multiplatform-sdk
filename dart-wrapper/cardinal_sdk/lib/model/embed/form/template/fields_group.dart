// This file is auto-generated
import 'package:cardinal_sdk/model/embed/form/template/structure_element.dart';


class FieldsGroup implements StructureElement {
	String group;
	List<StructureElement>? fields;
	FieldsGroup(
		this.group,
		{
			this.fields
		});

	factory FieldsGroup.fromJSON(Map<String, dynamic> data) {
		return FieldsGroup(
			data["group"],
			fields: data["fields"]?.map((x0) => StructureElement.fromJSON(x0) ),
		);
	}

	static Map<String, dynamic> encode(FieldsGroup value) {
		Map<String, dynamic> entityAsMap = {
			"group" : value.group,
			"fields" : value.fields?.map((x0) => StructureElement.encode(x0))
		};
		return entityAsMap;
	}
}