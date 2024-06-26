import json
from typing import Optional, Union, Dict
from crypto.entities.DelegateShareOptions import DelegateShareOptions
from dataclasses import dataclass

@dataclass
class FailedRequestDetails:
	entity_id: str
	delegate_id: str
	updated_for_migration: bool
	code: Optional[int]
	reason: Optional[str]
	request: Optional['DelegateShareOptions']

	def __serialize__(self) -> object:
		return {
			"entityId": self.entity_id,
			"delegateId": self.delegate_id,
			"updatedForMigration": self.updated_for_migration,
			"code": self.code,
			"reason": self.reason,
			"request": self.request.__serialize__() if self.request is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FailedRequestDetails':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity_id = deserialized_dict["entityId"],
			delegate_id = deserialized_dict["delegateId"],
			updated_for_migration = deserialized_dict["updatedForMigration"],
			code = deserialized_dict.get("code"),
			reason = deserialized_dict.get("reason"),
			request = DelegateShareOptions._deserialize(deserialized_dict.get("request")) if deserialized_dict.get("request") is not None else None,
		)

__all__ = ['FailedRequestDetails']