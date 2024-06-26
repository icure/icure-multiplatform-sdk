import json
from model.requests.RequestedPermission import RequestedPermission
from crypto.entities.ShareMetadataBehaviour import ShareMetadataBehaviour
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class ContactShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

__all__ = ['ContactShareOptions']