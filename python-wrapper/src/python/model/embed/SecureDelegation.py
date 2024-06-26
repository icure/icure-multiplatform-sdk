import json
from model.embed.AccessLevel import AccessLevel
from typing import Optional, List, Union, Dict
from model.specializations.Base64String import Base64String
from dataclasses import field, dataclass
from model.specializations.SecureDelegationKeyString import SecureDelegationKeyString

@dataclass
class SecureDelegation:
	permissions: 'AccessLevel'
	delegator: Optional[str] = None
	delegate: Optional[str] = None
	secret_ids: List['Base64String'] = field(default_factory=list)
	encryption_keys: List['Base64String'] = field(default_factory=list)
	owning_entity_ids: List['Base64String'] = field(default_factory=list)
	parent_delegations: List['SecureDelegationKeyString'] = field(default_factory=list)
	exchange_data_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"delegator": self.delegator,
			"delegate": self.delegate,
			"secretIds": [x0 for x0 in self.secret_ids],
			"encryptionKeys": [x0 for x0 in self.encryption_keys],
			"owningEntityIds": [x0 for x0 in self.owning_entity_ids],
			"parentDelegations": [x0 for x0 in self.parent_delegations],
			"exchangeDataId": self.exchange_data_id,
			"permissions": self.permissions.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SecureDelegation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			delegator = deserialized_dict.get("delegator"),
			delegate = deserialized_dict.get("delegate"),
			secret_ids = [x0 for x0 in deserialized_dict["secretIds"]],
			encryption_keys = [x0 for x0 in deserialized_dict["encryptionKeys"]],
			owning_entity_ids = [x0 for x0 in deserialized_dict["owningEntityIds"]],
			parent_delegations = [x0 for x0 in deserialized_dict["parentDelegations"]],
			exchange_data_id = deserialized_dict.get("exchangeDataId"),
			permissions = AccessLevel._deserialize(deserialized_dict["permissions"]),
		)

__all__ = ['SecureDelegation']