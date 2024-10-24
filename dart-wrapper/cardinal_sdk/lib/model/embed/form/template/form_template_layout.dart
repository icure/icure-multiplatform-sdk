// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/action.dart';
import 'package:cardinal_sdk/model/embed/form/template/section.dart';


class FormTemplateLayout {
	String form;
	List<Action> actions = [];
	List<Section> sections = [];
	String? description;
	List<String>? keywords;
	FormTemplateLayout(
		this.form,
		{
			this.description,
			this.keywords,
			List<Action>? actions,
			List<Section>? sections
		}) : actions = actions ?? [],
		sections = sections ?? [];

	factory FormTemplateLayout.fromJSON(Map<String, dynamic> data) {
		return FormTemplateLayout(
			data["form"],
			actions: data["actions"].map((x0) => Action.fromJSON(x0) ).toList(),
			sections: data["sections"].map((x0) => Section.fromJSON(x0) ).toList(),
			description: data["description"],
			keywords: data["keywords"]?.map((x0) => x0 ).toList(),
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