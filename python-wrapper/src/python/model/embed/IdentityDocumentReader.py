import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class IdentityDocumentReader:
	justificatif_document_number: Optional[str] = None
	support_serial_number: Optional[str] = None
	time_reading_eid_document: Optional[int] = None
	eid_document_support_type: int = 0
	reason_manual_encoding: int = 0
	reason_using_vignette: int = 0

	def __serialize__(self) -> object:
		return {
			"justificatifDocumentNumber": self.justificatif_document_number,
			"supportSerialNumber": self.support_serial_number,
			"timeReadingEIdDocument": self.time_reading_eid_document,
			"eidDocumentSupportType": self.eid_document_support_type,
			"reasonManualEncoding": self.reason_manual_encoding,
			"reasonUsingVignette": self.reason_using_vignette,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IdentityDocumentReader':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			justificatif_document_number = deserialized_dict.get("justificatifDocumentNumber"),
			support_serial_number = deserialized_dict.get("supportSerialNumber"),
			time_reading_eid_document = deserialized_dict.get("timeReadingEIdDocument"),
			eid_document_support_type = deserialized_dict["eidDocumentSupportType"],
			reason_manual_encoding = deserialized_dict["reasonManualEncoding"],
			reason_using_vignette = deserialized_dict["reasonUsingVignette"],
		)

__all__ = ['IdentityDocumentReader']