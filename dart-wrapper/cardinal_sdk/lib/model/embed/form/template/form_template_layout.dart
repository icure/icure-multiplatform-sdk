// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/action.dart';
import 'package:cardinal_sdk/model/embed/form/template/section.dart';


class FormTemplateLayout {
	String form;
	List<Action> actions = [];
	List<Section> sections = [];
	String? description = null;
	List<String>? keywords = null;
	FormTemplateLayout(
		this.form,
		{
			List<Action>? actions,
			List<Section>? sections,
			String? description,
			List<String>? keywords
		}) : actions = actions ?? [],
		sections = sections ?? [],
		description = description ?? null,
		keywords = keywords ?? null;

	factory FormTemplateLayout.fromJSON(Map<String, dynamic> data) {
		return FormTemplateLayout(
			(data["form"] as String),
			actions: (data["actions"] as List<dynamic>).map((x0) => Action.fromJSON(x0) ).toList(),
			sections: (data["sections"] as List<dynamic>).map((x0) => Section.fromJSON(x0) ).toList(),
			description: (data["description"] as String?),
			keywords: (data["keywords"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
		);
	}

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
}