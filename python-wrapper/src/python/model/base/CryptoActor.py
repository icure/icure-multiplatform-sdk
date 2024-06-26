import json
from typing import Union, Dict
from model.CryptoActorStub import CryptoActorStub
from model.EncryptedPatient import EncryptedPatient
from model.DecryptedPatient import DecryptedPatient
from model.Device import Device
from model.HealthcareParty import HealthcareParty

CryptoActor = Union['CryptoActorStub', 'EncryptedPatient', 'DecryptedPatient', 'Device', 'HealthcareParty']

def serialize_crypto_actor(crypto_actor: CryptoActor) -> object:
	if instanceof(crypto_actor, CryptoActorStub):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.CryptoActorStub"})
		return serialized_entity
	elif instanceof(crypto_actor, EncryptedPatient):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.EncryptedPatient"})
		return serialized_entity
	elif instanceof(crypto_actor, DecryptedPatient):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.DecryptedPatient"})
		return serialized_entity
	elif instanceof(crypto_actor, Device):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.Device"})
		return serialized_entity
	elif instanceof(crypto_actor, HealthcareParty):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.HealthcareParty"})
		return serialized_entity
	else:
		raise Exception(f"{type(crypto_actor)} is not a known subclass of CryptoActor")

def deserialize_crypto_actor(data: Union[str, Dict[str, object]]) -> 'CryptoActor':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.CryptoActorStub":
		CryptoActorStub._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.EncryptedPatient":
		EncryptedPatient._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.DecryptedPatient":
		DecryptedPatient._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.Device":
		Device._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.HealthcareParty":
		HealthcareParty._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of CryptoActor")

__all__ = ['CryptoActor','serialize_crypto_actor','deserialize_crypto_actor']