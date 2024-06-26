import json
from typing import List, Union, Dict
from model.specializations.HexString import HexString
from model.requests.RequestedPermission import RequestedPermission
from dataclasses import dataclass

@dataclass
class DelegateShareOptions:
	share_secret_ids: List[str]
	share_encryption_keys: List['HexString']
	share_owning_entity_ids: List[str]
	requested_permissions: 'RequestedPermission'

	def __serialize__(self) -> object:
		return {
			"shareSecretIds": [x0 for x0 in self.share_secret_ids],
			"shareEncryptionKeys": [x0 for x0 in self.share_encryption_keys],
			"shareOwningEntityIds": [x0 for x0 in self.share_owning_entity_ids],
			"requestedPermissions": self.requested_permissions.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DelegateShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			share_secret_ids = [x0 for x0 in deserialized_dict["shareSecretIds"]],
			share_encryption_keys = [x0 for x0 in deserialized_dict["shareEncryptionKeys"]],
			share_owning_entity_ids = [x0 for x0 in deserialized_dict["shareOwningEntityIds"]],
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
		)

__all__ = ['DelegateShareOptions']