import base64
import json
from typing import Optional, List, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.DocumentType import DocumentType
from model.base.ReportVersion import ReportVersion
from model.embed.DocumentGroup import DocumentGroup

@dataclass
class DocumentTemplate:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	attachment: Optional[bytearray] = None
	document_type: Optional['DocumentType'] = None
	main_uti: Optional[str] = None
	name: Optional[str] = None
	other_utis: List[str] = field(default_factory=list)
	attachment_id: Optional[str] = None
	version: Optional['ReportVersion'] = None
	owner: Optional[str] = None
	guid: Optional[str] = None
	group: Optional['DocumentGroup'] = None
	descr: Optional[str] = None
	disabled: Optional[str] = None
	specialty: Optional['CodeStub'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"attachment": base64.b64encode(self.attachment).decode('utf-8') if self.attachment is not None else None,
			"documentType": self.document_type.__serialize__() if self.document_type is not None else None,
			"mainUti": self.main_uti,
			"name": self.name,
			"otherUtis": [x0 for x0 in self.other_utis],
			"attachmentId": self.attachment_id,
			"version": self.version.__serialize__() if self.version is not None else None,
			"owner": self.owner,
			"guid": self.guid,
			"group": self.group.__serialize__() if self.group is not None else None,
			"descr": self.descr,
			"disabled": self.disabled,
			"specialty": self.specialty.__serialize__() if self.specialty is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentTemplate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			attachment = bytearray(base64.b64decode(deserialized_dict.get("attachment"))) if deserialized_dict.get("attachment") is not None else None,
			document_type = DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			main_uti = deserialized_dict.get("mainUti"),
			name = deserialized_dict.get("name"),
			other_utis = [x0 for x0 in deserialized_dict["otherUtis"]],
			attachment_id = deserialized_dict.get("attachmentId"),
			version = ReportVersion._deserialize(deserialized_dict.get("version")) if deserialized_dict.get("version") is not None else None,
			owner = deserialized_dict.get("owner"),
			guid = deserialized_dict.get("guid"),
			group = DocumentGroup._deserialize(deserialized_dict.get("group")) if deserialized_dict.get("group") is not None else None,
			descr = deserialized_dict.get("descr"),
			disabled = deserialized_dict.get("disabled"),
			specialty = CodeStub._deserialize(deserialized_dict.get("specialty")) if deserialized_dict.get("specialty") is not None else None,
		)

__all__ = ['DocumentTemplate']