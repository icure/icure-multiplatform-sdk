// This file is auto-generated
import 'package:cardinal_sdk/model/embed/form/template/action.dart';
import 'package:cardinal_sdk/model/embed/form/template/section.dart';


class FormTemplateLayout {
	String form;
	List<Action> actions = [];
	List<Section> sections = [];
	String? description;
	List<String>? keywords;

	FormTemplateLayout({
		required this.form,
		this.description,
		this.keywords,
		List<Action>? actions,
		List<Section>? sections
	}) : actions = actions ?? [],
		sections = sections ?? [];

	static Map<String, dynamic> encode(FormTemplateLayout value) {
		Map<String, dynamic> entityAsMap = {
			"form" : value.form,
			"actions" : value.actions.map((x0) => Action.encode(x0)),
			"sections" : value.sections.map((x0) => Section.encode(x0)),
			"description" : value.description,
			"keywords" : value.keywords?.map((x0) => x0)
		};
		return entityAsMap;
	}
}