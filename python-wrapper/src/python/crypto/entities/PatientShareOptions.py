import json
from model.requests.RequestedPermission import RequestedPermission
from crypto.entities.ShareMetadataBehaviour import ShareMetadataBehaviour
from typing import List, Union, Dict
from dataclasses import dataclass

@dataclass
class PatientShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_secret_ids: List[str]

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareSecretIds": [x0 for x0 in self.share_secret_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_secret_ids = [x0 for x0 in deserialized_dict["shareSecretIds"]],
		)

__all__ = ['PatientShareOptions']