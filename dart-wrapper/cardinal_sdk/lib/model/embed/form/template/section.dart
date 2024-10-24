// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/structure_element.dart';


class Section {
	String section;
	List<StructureElement> fields;
	String? description;
	List<String>? keywords;
	Section(
		this.section,
		this.fields,
		{
			this.description,
			this.keywords
		});

	factory Section.fromJSON(Map<String, dynamic> data) {
		return Section(
			(data["section"] as String),
			(data["fields"] as List<dynamic>).map((x0) => StructureElement.fromJSON(x0) ).toList(),
			description: (data["description"] as String?),
			keywords: (data["keywords"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
		);
	}

	static Map<String, dynamic> encode(Section value) {
		Map<String, dynamic> entityAsMap = {
			"section" : value.section,
			"fields" : value.fields.map((x0) => StructureElement.encode(x0)).toList(),
			"description" : value.description,
			"keywords" : value.keywords?.map((x0) => x0).toList()
		};
		return entityAsMap;
	}
}