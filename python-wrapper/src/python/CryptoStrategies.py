import base64
import json
from dataclasses import dataclass
from enum import Enum
from icure.model import DataOwnerWithType, serialize_data_owner_with_type, deserialize_data_owner_with_type
from icure.model.specializations import SpkiHexString, KeypairFingerprintV1String
from icure.model.SingletonMeta import SingletonMeta
from typing import Dict, List, Union


@dataclass
class KeyDataRecoveryRequest:
    """
    A request to recover key data that was not found for a user.

    Args:
        data_owner_details (DataOwnerWithType): The data owner for which the key data should be recovered.
        unknown_keys (List[SpkiHexString]): ll public keys (in hex-encoded spki format) of `dataOwner` for which the
            authenticity status (verified or unverified) is unknown (no result was cached from a previous api
            instantiation and the key was not generated on the current device). This could include keys that were
            recovered automatically by the sdk and may have overlap with `unavailableKeys`.
        unavailable_keys (List[SpkiHexString]): All public keys (in hex-encoded spki format) of `dataOwner` for which
            the sdk could not recover a private key. May overlap (partially or completely) with `unknownKeys`.
    """
    data_owner_details: DataOwnerWithType
    unknown_keys: List[SpkiHexString]
    unavailable_keys: List[SpkiHexString]

    def __serialize__(self) -> object:
        return {
            "dataOwnerDetails": serialize_data_owner_with_type(self.data_owner_details),
            "unknownKeys": self.unknown_keys,
            "unavailableKeys": self.unavailable_keys
        }

    @classmethod
    def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeyDataRecoveryRequest':
        deserialized_dict: dict[str, object]
        if isinstance(data, str):
            deserialized_dict = json.loads(data)
        else:
            deserialized_dict = data
        return cls(
            data_owner_details=deserialize_data_owner_with_type(deserialized_dict["dataOwnerDetails"]),
            unknown_keys=deserialized_dict["unknownKeys"],
            unavailable_keys=deserialized_dict["unavailableKeys"]
        )


"""
Specifies how the SDK should behave when a new key pair is required for a data owner.
"""
KeyGenerationRequestResult = Union['KeyGenerationRequestResultAllow', 'KeyGenerationRequestResultDeny', 'KeyGenerationRequestResultUse']


class KeyGenerationRequestResultAllow(metaclass=SingletonMeta):
    """
    Allows the SDK to generate a new key pair for the current data owner.
    """

    def __serialize__(self) -> object:
        return {}

    @classmethod
    def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeyGenerationRequestResultAllow':
        return cls()


class KeyGenerationRequestResultDeny(metaclass=SingletonMeta):
    """
    The SDK must not generate a new key for the data owner. The SDK initialisation should fail with a predefined error.
    """

    def __serialize__(self) -> object:
        return {}

    @classmethod
    def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeyGenerationRequestResultDeny':
        return cls()


@dataclass
class KeyGenerationRequestResultUse:
    """
    The SDK should use the provided key pair as a new key for the data owner.

    Args:
        key_pkcs8 (bytearray): The key pair to provide, as byte array.
    """

    key_pkcs8: bytearray

    def __serialize__(self) -> object:
        return {
            "keyPkcs8": base64.b64encode(self.key_pkcs8).decode('utf-8')
        }

    @classmethod
    def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeyGenerationRequestResultUse':
        deserialized_dict: dict[str, object]
        if isinstance(data, str):
            deserialized_dict = json.loads(data)
        else:
            deserialized_dict = data
        return cls(
            key_pkcs8=bytearray(base64.b64decode(deserialized_dict["keyPkcs8"]))
        )


def serialize_key_generation_request_result(key_generation_request_result: KeyGenerationRequestResult) -> object:
    if isinstance(key_generation_request_result, KeyGenerationRequestResultAllow):
        serialized_entity = key_generation_request_result.__serialize__()
        serialized_entity.update({"type": "com.icure.sdk.py.PyCryptoStrategies.KeyGenerationRequestResult.Allow"})
        return serialized_entity
    elif isinstance(key_generation_request_result, KeyGenerationRequestResultDeny):
        serialized_entity = key_generation_request_result.__serialize__()
        serialized_entity.update({"type": "com.icure.sdk.py.PyCryptoStrategies.KeyGenerationRequestResult.Deny"})
        return serialized_entity
    elif isinstance(key_generation_request_result, KeyGenerationRequestResultUse):
        serialized_entity = key_generation_request_result.__serialize__()
        serialized_entity.update({"type": "com.icure.sdk.py.PyCryptoStrategies.KeyGenerationRequestResult.Use"})
        return serialized_entity
    else:
        raise Exception(f"{type(key_generation_request_result)} is not a known subclass of KeyGenerationRequestResult")


def deserialize_key_generation_request_result(data: Union[str, Dict[str, object]]) -> object:
    deserialized_dict: dict[str, object]
    if isinstance(data, str):
        deserialized_dict = json.loads(data)
    else:
        deserialized_dict = data
    qualifier = deserialized_dict.get("type")
    if qualifier is None:
        raise Exception("Missing qualifier: type")
    if qualifier == "com.icure.sdk.py.PyCryptoStrategies.KeyGenerationRequestResult.Allow":
        return KeyGenerationRequestResultAllow._deserialize(deserialized_dict)
    elif qualifier == "com.icure.sdk.py.PyCryptoStrategies.KeyGenerationRequestResult.Deny":
        return KeyGenerationRequestResultDeny._deserialize(deserialized_dict)
    elif qualifier == "com.icure.sdk.py.PyCryptoStrategies.KeyGenerationRequestResult.Use":
        return KeyGenerationRequestResultUse._deserialize(deserialized_dict)
    else:
        raise Exception(f"{qualifier} is not a known subclass of DataOwnerWithType")


class RsaEncryptionAlgorithm(Enum):
    """
    Represents the encryption algorith used to generate the ExportedKeyData.
    """

    OaepWithSha1 = "OaepWithSha1"
    OaepWithSha256 = "OaepWithSha256"

    def __serialize__(self) -> object:
        return self.value

    @classmethod
    def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RsaEncryptionAlgorithm':
        if data == "OaepWithSha1":
            return RsaEncryptionAlgorithm.OaepWithSha1
        elif data == "OaepWithSha256":
            return RsaEncryptionAlgorithm.OaepWithSha256
        else:
            raise Exception(f"{data} is not a valid value for RsaEncryptionAlgorithm enum.")


@dataclass
class ExportedKeyData:
    """
    Represents a private key with the algorithm used to generate it.
    """
    private_key_pkcs8: bytearray
    algorithm: RsaEncryptionAlgorithm

    def __serialize__(self) -> object:
        return {
            "private": base64.b64encode(self.private_key_pkcs8).decode('utf-8'),
            "algorithm": self.algorithm.__serialize__()
        }

    @classmethod
    def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ExportedKeyData':
        deserialized_dict: dict[str, object]
        if isinstance(data, str):
            deserialized_dict = json.loads(data)
        else:
            deserialized_dict = data
        return cls(
            private_key_pkcs8=bytearray(base64.b64decode(deserialized_dict["private"])),
            algorithm=RsaEncryptionAlgorithm._deserialize(deserialized_dict["algorithm"])
        )


@dataclass
class RecoveredKeyData:
    """
    Data recovered for a data owner.

    Args:
        recovered_keys (Dict[KeypairFingerprintV1String, RsaKeyPair]): All keys recovered for the data owner (will be
            automatically considered as verified), by fingerprint.
        key_authenticity (Dict[KeypairFingerprintV1String, bool]): associates each public key fingerprint its
            authenticity. Note that if any of the keys from `unknownKeys` is completely missing from this object the
            key will be considered as unverified in this api instance (same as if associated to false), but this value
            won't be cached (will be again part of `unknownKeys` in future instances.
    """
    recovered_keys: Dict[KeypairFingerprintV1String, RsaKeyPair]
    key_authenticity: Dict[KeypairFingerprintV1String, bool]

    def __serialize__(self) -> object:
        return {
            "recoveredKeys": {k: v.__serialize() for k, v in self.recovered_keys.items()},
            "keyAuthenticity": self.key_authenticity
        }

    @classmethod
    def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveredKeyData':
        deserialized_dict: dict[str, object]
        if isinstance(data, str):
            deserialized_dict = json.loads(data)
        else:
            deserialized_dict = data
        return cls(
            recovered_keys={k: RsaKeyPair._deserialize(v) for k, v in deserialized_dict["recoveredKeys"].items()},
            key_authenticity=deserialized_dict["keyAuthenticity"]
        )
