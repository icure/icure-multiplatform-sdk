// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/dropdown_field.dart';
import 'package:cardinal_sdk/model/embed/form/template/radio_button.dart';
import 'package:cardinal_sdk/model/embed/form/template/date_picker.dart';
import 'package:cardinal_sdk/model/embed/form/template/time_picker.dart';
import 'package:cardinal_sdk/model/embed/form/template/date_time_picker.dart';
import 'package:cardinal_sdk/model/embed/form/template/number_field.dart';
import 'package:cardinal_sdk/model/embed/form/template/text_field.dart';
import 'package:cardinal_sdk/model/embed/form/template/check_box.dart';
import 'package:cardinal_sdk/model/embed/form/template/multiple_choice.dart';
import 'package:cardinal_sdk/model/embed/form/template/measure_field.dart';
import 'package:cardinal_sdk/model/embed/form/template/fields_group.dart';


abstract interface class StructureElement {

	static Map<String, dynamic> encode(StructureElement value) {
		switch (value) {
			case DropdownField entity:
				Map<String, dynamic> entityJson = DropdownField.encode(entity);
				entityJson["kotlinType"] = "dropdown";
				return entityJson;
			case RadioButton entity:
				Map<String, dynamic> entityJson = RadioButton.encode(entity);
				entityJson["kotlinType"] = "radio-button";
				return entityJson;
			case DatePicker entity:
				Map<String, dynamic> entityJson = DatePicker.encode(entity);
				entityJson["kotlinType"] = "date-picker";
				return entityJson;
			case TimePicker entity:
				Map<String, dynamic> entityJson = TimePicker.encode(entity);
				entityJson["kotlinType"] = "time-picker";
				return entityJson;
			case DateTimePicker entity:
				Map<String, dynamic> entityJson = DateTimePicker.encode(entity);
				entityJson["kotlinType"] = "date-time-picker";
				return entityJson;
			case NumberField entity:
				Map<String, dynamic> entityJson = NumberField.encode(entity);
				entityJson["kotlinType"] = "number-field";
				return entityJson;
			case TextField entity:
				Map<String, dynamic> entityJson = TextField.encode(entity);
				entityJson["kotlinType"] = "textfield";
				return entityJson;
			case CheckBox entity:
				Map<String, dynamic> entityJson = CheckBox.encode(entity);
				entityJson["kotlinType"] = "checkbox";
				return entityJson;
			case MultipleChoice entity:
				Map<String, dynamic> entityJson = MultipleChoice.encode(entity);
				entityJson["kotlinType"] = "multiple-choice";
				return entityJson;
			case MeasureField entity:
				Map<String, dynamic> entityJson = MeasureField.encode(entity);
				entityJson["kotlinType"] = "measure-field";
				return entityJson;
			case FieldsGroup entity:
				Map<String, dynamic> entityJson = FieldsGroup.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup";
				return entityJson;
			default:
				throw ArgumentError('Invalid subclass $value');
		}
	}

	static StructureElement fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "dropdown":
				return DropdownField.fromJSON(data);
			case "radio-button":
				return RadioButton.fromJSON(data);
			case "date-picker":
				return DatePicker.fromJSON(data);
			case "time-picker":
				return TimePicker.fromJSON(data);
			case "date-time-picker":
				return DateTimePicker.fromJSON(data);
			case "number-field":
				return NumberField.fromJSON(data);
			case "textfield":
				return TextField.fromJSON(data);
			case "checkbox":
				return CheckBox.fromJSON(data);
			case "multiple-choice":
				return MultipleChoice.fromJSON(data);
			case "measure-field":
				return MeasureField.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup":
				return FieldsGroup.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}