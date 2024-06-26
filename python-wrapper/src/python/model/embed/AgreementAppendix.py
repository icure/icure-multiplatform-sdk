import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class AgreementAppendix:
	doc_seq: Optional[int] = None
	verse_seq: Optional[int] = None
	document_id: Optional[str] = None
	path: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"docSeq": self.doc_seq,
			"verseSeq": self.verse_seq,
			"documentId": self.document_id,
			"path": self.path,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AgreementAppendix':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			doc_seq = deserialized_dict.get("docSeq"),
			verse_seq = deserialized_dict.get("verseSeq"),
			document_id = deserialized_dict.get("documentId"),
			path = deserialized_dict.get("path"),
		)

__all__ = ['AgreementAppendix']