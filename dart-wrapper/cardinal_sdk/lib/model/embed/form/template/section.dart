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
			data["section"],
			data["fields"].map((x0) => StructureElement.fromJSON(x0) ),
			description: data["description"],
			keywords: data["keywords"]?.map((x0) => x0 ),
		);
	}

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