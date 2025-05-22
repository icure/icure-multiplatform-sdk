// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/action.dart';
import 'package:cardinal_sdk/model/embed/form/template/section.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "form_template_layout.freezed.dart";


@freezed
abstract class FormTemplateLayout with _$FormTemplateLayout {
	const factory FormTemplateLayout({
		required String form,
		@Default([]) List<Action> actions,
		@Default([]) List<Section> sections,
		@Default(null) String? description,
		@Default(null) List<String>? keywords,
	}) = _FormTemplateLayout;


	static Map<String, dynamic> encode(FormTemplateLayout value) {
		Map<String, dynamic> entityAsMap = {
			"form" : value.form,
			"actions" : value.actions.map((x0) => Action.encode(x0)).toList(),
			"sections" : value.sections.map((x0) => Section.encode(x0)).toList(),
			"description" : value.description,
			"keywords" : value.keywords?.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static FormTemplateLayout fromJSON(Map<String, dynamic> data) {
		return FormTemplateLayout(
			form: (data["form"] as String),
			actions: (data["actions"] as List<dynamic>).map((x0) => Action.fromJSON(x0) ).toList(),
			sections: (data["sections"] as List<dynamic>).map((x0) => Section.fromJSON(x0) ).toList(),
			description: (data["description"] as String?),
			keywords: (data["keywords"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
		);
	}
}