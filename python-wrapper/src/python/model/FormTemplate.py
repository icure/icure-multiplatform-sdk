import base64
import json
from typing import Optional, List, Union, Dict
from model.embed.form.template.FormTemplateLayout import FormTemplateLayout
from model.embed.DocumentGroup import DocumentGroup
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass

@dataclass
class FormTemplate:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	template_layout: Optional['FormTemplateLayout'] = None
	raw_template_layout: Optional[bytearray] = None
	name: Optional[str] = None
	guid: Optional[str] = None
	group: Optional['DocumentGroup'] = None
	descr: Optional[str] = None
	disabled: Optional[str] = None
	specialty: Optional['CodeStub'] = None
	author: Optional[str] = None
	form_instance_preferred_location: Optional[str] = None
	keyboard_shortcut: Optional[str] = None
	short_report: Optional[str] = None
	medium_report: Optional[str] = None
	long_report: Optional[str] = None
	reports: List[str] = field(default_factory=list)
	tags: List['CodeStub'] = field(default_factory=list)
	layout_attachment_id: Optional[str] = None
	template_layout_attachment_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"templateLayout": self.template_layout.__serialize__() if self.template_layout is not None else None,
			"rawTemplateLayout": base64.b64encode(self.raw_template_layout).decode('utf-8') if self.raw_template_layout is not None else None,
			"name": self.name,
			"guid": self.guid,
			"group": self.group.__serialize__() if self.group is not None else None,
			"descr": self.descr,
			"disabled": self.disabled,
			"specialty": self.specialty.__serialize__() if self.specialty is not None else None,
			"author": self.author,
			"formInstancePreferredLocation": self.form_instance_preferred_location,
			"keyboardShortcut": self.keyboard_shortcut,
			"shortReport": self.short_report,
			"mediumReport": self.medium_report,
			"longReport": self.long_report,
			"reports": [x0 for x0 in self.reports],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"layoutAttachmentId": self.layout_attachment_id,
			"templateLayoutAttachmentId": self.template_layout_attachment_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FormTemplate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			template_layout = FormTemplateLayout._deserialize(deserialized_dict.get("templateLayout")) if deserialized_dict.get("templateLayout") is not None else None,
			raw_template_layout = bytearray(base64.b64decode(deserialized_dict.get("rawTemplateLayout"))) if deserialized_dict.get("rawTemplateLayout") is not None else None,
			name = deserialized_dict.get("name"),
			guid = deserialized_dict.get("guid"),
			group = DocumentGroup._deserialize(deserialized_dict.get("group")) if deserialized_dict.get("group") is not None else None,
			descr = deserialized_dict.get("descr"),
			disabled = deserialized_dict.get("disabled"),
			specialty = CodeStub._deserialize(deserialized_dict.get("specialty")) if deserialized_dict.get("specialty") is not None else None,
			author = deserialized_dict.get("author"),
			form_instance_preferred_location = deserialized_dict.get("formInstancePreferredLocation"),
			keyboard_shortcut = deserialized_dict.get("keyboardShortcut"),
			short_report = deserialized_dict.get("shortReport"),
			medium_report = deserialized_dict.get("mediumReport"),
			long_report = deserialized_dict.get("longReport"),
			reports = [x0 for x0 in deserialized_dict["reports"]],
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			layout_attachment_id = deserialized_dict.get("layoutAttachmentId"),
			template_layout_attachment_id = deserialized_dict.get("templateLayoutAttachmentId"),
		)

__all__ = ['FormTemplate']