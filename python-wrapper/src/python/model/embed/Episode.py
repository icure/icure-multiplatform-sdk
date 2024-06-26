import json
from typing import Union, Dict, Optional
from model.specializations.Base64String import Base64String
from dataclasses import dataclass

Episode = Union['DecryptedEpisode', 'EncryptedEpisode']

def serialize_episode(episode: Episode) -> object:
	if isinstance(episode, DecryptedEpisode):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedEpisode",
			"entity": episode.__serialize__()
		}
	elif isinstance(episode, EncryptedEpisode):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedEpisode",
			"entity": episode.__serialize__()
		}
	else:
		raise Exception(f"{type(episode)} is not a known subclass of Episode")

def deserialize_episode(data: Union[str, Dict[str, object]]) -> 'Episode':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedEpisode":
		DecryptedEpisode._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedEpisode":
		EncryptedEpisode._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Episode")

@dataclass
class DecryptedEpisode:
	id: str
	name: Optional[str] = None
	comment: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"name": self.name,
			"comment": self.comment,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedEpisode':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			name = deserialized_dict.get("name"),
			comment = deserialized_dict.get("comment"),
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedEpisode:
	id: str
	name: Optional[str] = None
	comment: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"name": self.name,
			"comment": self.comment,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedEpisode':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			name = deserialized_dict.get("name"),
			comment = deserialized_dict.get("comment"),
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['Episode','serialize_episode','deserialize_episode','DecryptedEpisode','EncryptedEpisode']