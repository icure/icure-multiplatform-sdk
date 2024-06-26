import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class DatabaseInfo:
	id: str
	update_seq: Optional[str] = None
	file_size: Optional[int] = None
	external_size: Optional[int] = None
	active_size: Optional[int] = None
	docs: Optional[int] = None
	q: Optional[int] = None
	n: Optional[int] = None
	w: Optional[int] = None
	r: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"updateSeq": self.update_seq,
			"fileSize": self.file_size,
			"externalSize": self.external_size,
			"activeSize": self.active_size,
			"docs": self.docs,
			"q": self.q,
			"n": self.n,
			"w": self.w,
			"r": self.r,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DatabaseInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			update_seq = deserialized_dict.get("updateSeq"),
			file_size = deserialized_dict.get("fileSize"),
			external_size = deserialized_dict.get("externalSize"),
			active_size = deserialized_dict.get("activeSize"),
			docs = deserialized_dict.get("docs"),
			q = deserialized_dict.get("q"),
			n = deserialized_dict.get("n"),
			w = deserialized_dict.get("w"),
			r = deserialized_dict.get("r"),
		)

__all__ = ['DatabaseInfo']