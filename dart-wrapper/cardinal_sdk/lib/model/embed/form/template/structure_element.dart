// This file is auto-generated
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
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.DropdownField";
				return entityJson;
			case RadioButton entity:
				Map<String, dynamic> entityJson = RadioButton.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.RadioButton";
				return entityJson;
			case DatePicker entity:
				Map<String, dynamic> entityJson = DatePicker.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.DatePicker";
				return entityJson;
			case TimePicker entity:
				Map<String, dynamic> entityJson = TimePicker.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.TimePicker";
				return entityJson;
			case DateTimePicker entity:
				Map<String, dynamic> entityJson = DateTimePicker.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.DateTimePicker";
				return entityJson;
			case NumberField entity:
				Map<String, dynamic> entityJson = NumberField.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.NumberField";
				return entityJson;
			case TextField entity:
				Map<String, dynamic> entityJson = TextField.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.TextField";
				return entityJson;
			case CheckBox entity:
				Map<String, dynamic> entityJson = CheckBox.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.CheckBox";
				return entityJson;
			case MultipleChoice entity:
				Map<String, dynamic> entityJson = MultipleChoice.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.MultipleChoice";
				return entityJson;
			case MeasureField entity:
				Map<String, dynamic> entityJson = MeasureField.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.MeasureField";
				return entityJson;
			case FieldsGroup entity:
				Map<String, dynamic> entityJson = FieldsGroup.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup";
				return entityJson;
			default:
				throw ArgumentError('Invalid subclass ${value}');
		}
	}
}