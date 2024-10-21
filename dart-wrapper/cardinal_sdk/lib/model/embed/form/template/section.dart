// This file is auto-generated
import 'package:cardinal_sdk/model/embed/form/template/structure_element.dart';


class Section {
	String section;
	List<StructureElement> fields;
	String? description;
	List<String>? keywords;

	Section({
		required this.section,
		required this.fields,
		this.description,
		this.keywords
	});

	static Map<String, dynamic> encode(Section value) {
		Map<String, dynamic> entityAsMap = {
			"section" : value.section,
			"fields" : value.fields.map((x0) => StructureElement.encode(x0)),
			"description" : value.description,
			"keywords" : value.keywords?.map((x0) => x0)
		};
		return entityAsMap;
	}
}