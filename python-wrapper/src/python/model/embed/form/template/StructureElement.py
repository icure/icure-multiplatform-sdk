import json
from typing import Union, Dict
from model.embed.form.template.DropdownField import DropdownField
from model.embed.form.template.RadioButton import RadioButton
from model.embed.form.template.DatePicker import DatePicker
from model.embed.form.template.TimePicker import TimePicker
from model.embed.form.template.DateTimePicker import DateTimePicker
from model.embed.form.template.NumberField import NumberField
from model.embed.form.template.TextField import TextField
from model.embed.form.template.CheckBox import CheckBox
from model.embed.form.template.MultipleChoice import MultipleChoice
from model.embed.form.template.MeasureField import MeasureField
from model.embed.form.template.FieldsGroup import FieldsGroup

StructureElement = Union['DropdownField', 'RadioButton', 'DatePicker', 'TimePicker', 'DateTimePicker', 'NumberField', 'TextField', 'CheckBox', 'MultipleChoice', 'MeasureField', 'FieldsGroup']

def serialize_structure_element(structure_element: StructureElement) -> object:
	if isinstance(structure_element, DropdownField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.DropdownField"})
		return serialized_entity
	elif isinstance(structure_element, RadioButton):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.RadioButton"})
		return serialized_entity
	elif isinstance(structure_element, DatePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.DatePicker"})
		return serialized_entity
	elif isinstance(structure_element, TimePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.TimePicker"})
		return serialized_entity
	elif isinstance(structure_element, DateTimePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.DateTimePicker"})
		return serialized_entity
	elif isinstance(structure_element, NumberField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.NumberField"})
		return serialized_entity
	elif isinstance(structure_element, TextField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.TextField"})
		return serialized_entity
	elif isinstance(structure_element, CheckBox):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.CheckBox"})
		return serialized_entity
	elif isinstance(structure_element, MultipleChoice):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.MultipleChoice"})
		return serialized_entity
	elif isinstance(structure_element, MeasureField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.MeasureField"})
		return serialized_entity
	elif isinstance(structure_element, FieldsGroup):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.FieldsGroup"})
		return serialized_entity
	else:
		raise Exception(f"{type(structure_element)} is not a known subclass of StructureElement")

def deserialize_structure_element(data: Union[str, Dict[str, object]]) -> 'StructureElement':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.form.template.DropdownField":
		DropdownField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.RadioButton":
		RadioButton._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.DatePicker":
		DatePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.TimePicker":
		TimePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.DateTimePicker":
		DateTimePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.NumberField":
		NumberField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.TextField":
		TextField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.CheckBox":
		CheckBox._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.MultipleChoice":
		MultipleChoice._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.MeasureField":
		MeasureField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.FieldsGroup":
		FieldsGroup._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of StructureElement")

__all__ = ['StructureElement','serialize_structure_element','deserialize_structure_element']