// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/structure_element.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "section.freezed.dart";


@freezed
abstract class Section with _$Section {
	const factory Section({
		required String section,
		required List<StructureElement> fields,
		@Default(null) String? description,
		@Default(null) List<String>? keywords,
	}) = _Section;


	static Map<String, dynamic> encode(Section value) {
		Map<String, dynamic> entityAsMap = {
			"section" : value.section,
			"fields" : value.fields.map((x0) => StructureElement.encode(x0)).toList(),
			"description" : value.description,
			"keywords" : value.keywords?.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static Section fromJSON(Map<String, dynamic> data) {
		return Section(
			section: (data["section"] as String),
			fields: (data["fields"] as List<dynamic>).map((x0) => StructureElement.fromJSON(x0) ).toList(),
			description: (data["description"] as String?),
			keywords: (data["keywords"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
		);
	}
}