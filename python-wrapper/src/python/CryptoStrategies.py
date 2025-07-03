import base64
import json
from dataclasses import dataclass
from cardinal_sdk.model import deserialize_data_owner_with_type, CryptoActorStubWithType, DataOwnerWithType
from cardinal_sdk.model.SingletonMeta import SingletonMeta
from typing import Dict, List, Union, Optional
from abc import ABC, abstractmethod
from ctypes import c_void_p, CFUNCTYPE, c_char_p, cast
import traceback
from cardinal_sdk.kotlin_types import symbols

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
        serialized_entity.update({"type": "com.icure.cardinal.sdk.py.PyCryptoStrategies.PyKeyGenerationRequestResult.Allow"})
        return serialized_entity
    elif isinstance(key_generation_request_result, KeyGenerationRequestResultDeny):
        serialized_entity = key_generation_request_result.__serialize__()
        serialized_entity.update({"type": "com.icure.cardinal.sdk.py.PyCryptoStrategies.PyKeyGenerationRequestResult.Deny"})
        return serialized_entity
    elif isinstance(key_generation_request_result, KeyGenerationRequestResultUse):
        serialized_entity = key_generation_request_result.__serialize__()
        serialized_entity.update({"type": "com.icure.cardinal.sdk.py.PyCryptoStrategies.PyKeyGenerationRequestResult.Use"})
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
    if qualifier == "com.icure.cardinal.sdk.py.PyCryptoStrategies.PyKeyGenerationRequestResult.Allow":
        return KeyGenerationRequestResultAllow._deserialize(deserialized_dict)
    elif qualifier == "com.icure.cardinal.sdk.py.PyCryptoStrategies.PyKeyGenerationRequestResult.Deny":
        return KeyGenerationRequestResultDeny._deserialize(deserialized_dict)
    elif qualifier == "com.icure.cardinal.sdk.py.PyCryptoStrategies.PyKeyGenerationRequestResult.Use":
        return KeyGenerationRequestResultUse._deserialize(deserialized_dict)
    else:
        raise Exception(f"{qualifier} is not a known subclass of DataOwnerWithType")

class CryptoStrategies(ABC):
    """
    Allows to customise the behaviour of the iCure SDK when performing cryptographic operations.
    """
    @abstractmethod
    def generate_new_key_for_data_owner(
            self,
            self_data_owner: DataOwnerWithType
    ) -> KeyGenerationRequestResult:
        """
        The correct initialisation of the crypto API requires that at least 1 verified (or device) key pair is available for each data owner part of the
        current data owner hierarchy. If no verified key is available for any of the data owner parents the api initialisation will automatically fail,
        however if there is no verified key for the current data owner you can instead create a new crypto key.
        :param self_data_owner the current data owner.
        :returns a KeyGenerationRequestResult specifying how the SDK should behave.
        """
        pass

    @abstractmethod
    def verify_delegate_public_keys(
            self,
            delegate: CryptoActorStubWithType,
            public_keys: List[str],
            group_id: Optional[str]
    ) -> List[str]:
        """
        Verifies if the public keys of a data owner which will be the delegate of a new exchange key do actually belong to the person the data owner
        represents. This method is not called when the delegate would be the current data owner for the api.

        The user will have to obtain the verified public keys of the delegate from outside iCure, for example by email with another hcp, by checking the
        personal website of the other user, or by scanning verification qr codes at the doctor office...

        As long as one of the public keys is verified the creation of a new exchange key will succeed. If no public key is verified the operation will
        fail.
        :param delegate the potential data owner delegate.
        :param public_keys public keys requiring verification, in spki hex-encoded format.
        :param group_id the id of the delegate's group
        :returns all verified public keys, in spki hex-encoded format.
        """
        pass

    @abstractmethod
    def data_owner_requires_anonymous_delegation(self, data_owner: CryptoActorStubWithType, group_id: Optional[str]) -> bool:
        """
        Specifies if a data owner requires anonymous delegations, i.e. his id should not appear unencrypted in new secure delegations. This should always
        be the case for patient data owners.
        :param data_owner a data owner.
        :param group_id the id of the data owner's group
        :returns true if the delegations for the provided data owner should be anonymous.
        """
        pass

_C_RecoverAndVerifySelfHierarchyKeys = CFUNCTYPE(None, c_void_p, c_char_p, c_void_p)
_C_GenerateNewKeyForDataOwner = CFUNCTYPE(None, c_void_p, c_char_p)
_C_VerifyDelegatePublicKeys = CFUNCTYPE(None, c_void_p, c_char_p, c_char_p, c_char_p)
_C_DataOwnerRequiresAnonymousDelegation = CFUNCTYPE(None, c_void_p, c_char_p, c_char_p)

class _CryptoStrategiesBridge:
    __py_strategies: CryptoStrategies
    __CALLBACK_RecoverAndVerifySelfHierarchyKeys: _C_RecoverAndVerifySelfHierarchyKeys
    __CALLBACK_GenerateNewKeyForDataOwner: _C_GenerateNewKeyForDataOwner
    __CALLBACK_VerifyDelegatePublicKeys: _C_VerifyDelegatePublicKeys
    __CALLBACK_DataOwnerRequiresAnonymousDelegation: _C_DataOwnerRequiresAnonymousDelegation
    __kt_crypto_strategies: Optional[c_void_p]

    def __init__(self, py_strategies: CryptoStrategies):
        self.__kt_crypto_strategies = None
        self.__py_strategies = py_strategies

    def __del__(self):
        if self.__kt_crypto_strategies is not None:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.disposeStablePtr(self.__kt_crypto_strategies)

    def generate_new_key_for_data_owner(self, result_holder, self_data_owner):
        try:
            result = self.__py_strategies.generate_new_key_for_data_owner(
                deserialize_data_owner_with_type(cast(self_data_owner, c_char_p).value.decode('utf-8'))
            )
            result_json = serialize_key_generation_request_result(result)
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result_json).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def verify_delegate_public_keys(self, result_holder, delegate, public_keys, group_id):
        try:
            result = self.__py_strategies.verify_delegate_public_keys(
                CryptoActorStubWithType._deserialize(cast(delegate, c_char_p).value.decode('utf-8')),
                json.loads(cast(public_keys, c_char_p).value.decode('utf-8')),
                json.loads(cast(group_id, c_char_p).value.decode('utf-8'))
            )
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc())

    def data_owner_requires_anonymous_delegation(self, result_holder, data_owner, group_id):
        try:
            result = self.__py_strategies.data_owner_requires_anonymous_delegation(
                CryptoActorStubWithType._deserialize(cast(data_owner, c_char_p).value.decode('utf-8')),
                json.loads(cast(group_id, c_char_p).value.decode('utf-8'))
            )
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def get_kt(self) -> c_void_p:
        if self.__kt_crypto_strategies is None:
            self.__CALLBACK_GenerateNewKeyForDataOwner = _C_GenerateNewKeyForDataOwner(self.generate_new_key_for_data_owner)
            self.__CALLBACK_VerifyDelegatePublicKeys = _C_VerifyDelegatePublicKeys(self.verify_delegate_public_keys)
            self.__CALLBACK_DataOwnerRequiresAnonymousDelegation = _C_DataOwnerRequiresAnonymousDelegation(self.data_owner_requires_anonymous_delegation)
            self.__kt_crypto_strategies = symbols.kotlin.root.com.icure.cardinal.sdk.py.PyCryptoStrategies.create(
                self.__CALLBACK_GenerateNewKeyForDataOwner,
                self.__CALLBACK_VerifyDelegatePublicKeys,
                self.__CALLBACK_DataOwnerRequiresAnonymousDelegation,
            )
        return self.__kt_crypto_strategies