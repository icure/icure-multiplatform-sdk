// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/structure_element.dart';


class FieldsGroup implements StructureElement {
	String group;
	List<StructureElement>? fields = null;
	FieldsGroup(
		this.group,
		{
			List<StructureElement>? fields
		}) : fields = fields ?? null;

	factory FieldsGroup.fromJSON(Map<String, dynamic> data) {
		return FieldsGroup(
			(data["group"] as String),
			fields: (data["fields"] as List<dynamic>?)?.map((x0) => StructureElement.fromJSON(x0) ).toList(),
		);
	}

	static Map<String, dynamic> encode(FieldsGroup value) {
		Map<String, dynamic> entityAsMap = {
			"group" : value.group,
			"fields" : value.fields?.map((x0) => StructureElement.encode(x0)).toList()
		};
		return entityAsMap;
	}
}