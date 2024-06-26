import json
from typing import Dict, Union
from model.specializations.SecureDelegationKeyString import SecureDelegationKeyString
from model.embed.SecureDelegation import SecureDelegation
from model.specializations.Sha256HexString import Sha256HexString
from dataclasses import field, dataclass

@dataclass
class SecurityMetadata:
	secure_delegations: Dict['SecureDelegationKeyString', 'SecureDelegation']
	keys_equivalences: Dict['Sha256HexString', 'Sha256HexString'] = field(default_factory=dict)

	def __serialize__(self) -> object:
		return {
			"secureDelegations": {k0: v0.__serialize__() for k0, v0 in self.secure_delegations.items()},
			"keysEquivalences": {k0: v0 for k0, v0 in self.keys_equivalences.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SecurityMetadata':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secure_delegations = dict(map(lambda kv0: (kv0[0], SecureDelegation._deserialize(kv0[1])), deserialized_dict["secureDelegations"].items())),
			keys_equivalences = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["keysEquivalences"].items())),
		)

__all__ = ['SecurityMetadata']