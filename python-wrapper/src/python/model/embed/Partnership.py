import json
from typing import Optional, Union, Dict
from model.embed.PartnershipType import PartnershipType
from model.embed.PartnershipStatus import PartnershipStatus
from dataclasses import dataclass

@dataclass
class Partnership:
	type: Optional['PartnershipType'] = None
	status: Optional['PartnershipStatus'] = None
	partner_id: Optional[str] = None
	me_to_other_relationship_description: Optional[str] = None
	other_to_me_relationship_description: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"status": self.status.__serialize__() if self.status is not None else None,
			"partnerId": self.partner_id,
			"meToOtherRelationshipDescription": self.me_to_other_relationship_description,
			"otherToMeRelationshipDescription": self.other_to_me_relationship_description,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Partnership':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type = PartnershipType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			status = PartnershipStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			partner_id = deserialized_dict.get("partnerId"),
			me_to_other_relationship_description = deserialized_dict.get("meToOtherRelationshipDescription"),
			other_to_me_relationship_description = deserialized_dict.get("otherToMeRelationshipDescription"),
		)

__all__ = ['Partnership']