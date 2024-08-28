import json
from dataclasses import dataclass
from abc import ABC, abstractmethod
from typing import Optional, Union, Tuple
from ctypes import c_void_p, c_char_p, CFUNCTYPE, cast
from icure.kotlin_types import symbols
import traceback

@dataclass
class FileSystemStorage:
    """
    Store data as files at the provided directory
    """
    directory: str


class CustomStorageFacade(ABC):
    """
    Stores string data using a custom implementation.
    """

    @abstractmethod
    def get_item(self, key: str) -> Optional[str]:
        """
        Get a stored entry or None if no entry is stored at the provided key
        """
        pass

    @abstractmethod
    def set_item(self, key: str, value: str):
        """
        Sets the entry at key to the provided value, overriding any existing value.
        """
        pass

    @abstractmethod
    def remove_item(self, key: str):
        """
        Remove the entry at key
        """
        pass

StorageOptions = Union[FileSystemStorage, CustomStorageFacade]

_C_GetItem = CFUNCTYPE(None, c_void_p, c_char_p)
_C_SetItem = CFUNCTYPE(None, c_void_p, c_char_p, c_char_p)
_C_RemoveItem = CFUNCTYPE(None, c_void_p, c_char_p)

class _CustomStorageFacadeBridge:
    __CALLBACK_GetItem: _C_GetItem
    __CALLBACK_SetItem: _C_SetItem
    __CALLBACK_RemoveItem: _C_RemoveItem
    __kt_py_storage: Optional[c_void_p]

    def __init__(self, py_storage: CustomStorageFacade):
        self.__py_storage = py_storage
        self.__kt_py_storage = None

    def __del__(self):
        if self.__kt_py_storage is not None:
            symbols.kotlin.root.com.icure.sdk.py.utils.disposeStablePtr(self.__kt_py_storage)

    def get_item(self, result_holder, key):
        try:
            result = self.__py_storage.get_item(cast(key, c_char_p).value.decode('utf-8'))
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def set_item(self, result_holder, key, value):
        try:
            self.__py_storage.set_item(cast(key, c_char_p).value.decode('utf-8'), cast(value, c_char_p).value.decode('utf-8'))
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(result_holder, '{}'.encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def remove_item(self, result_holder, key):
        try:
            self.__py_storage.remove_item(cast(key, c_char_p).value.decode('utf-8'))
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(result_holder, '{}'.encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def get_kt(self) -> c_void_p:
        if self.__kt_py_storage is None:
            self.__CALLBACK_GetItem = _C_GetItem(self.get_item)
            self.__CALLBACK_SetItem = _C_SetItem(self.set_item)
            self.__CALLBACK_RemoveItem = _C_RemoveItem(self.remove_item)
            self.__kt_py_storage = symbols.kotlin.root.com.icure.sdk.py.PyStorage.createCustomStorageFacade(
                self.__CALLBACK_GetItem,
                self.__CALLBACK_SetItem,
                self.__CALLBACK_RemoveItem,
            )
        return self.__kt_py_storage


def _serialize_storage_options(storage_options: StorageOptions) -> Tuple[dict[str, any], Optional[CustomStorageFacade]]:
    if isinstance(storage_options, FileSystemStorage):
        return (
            {
                "type": "com.icure.sdk.py.PyStorage.StorageFacadeOptions.File",
                "directory": storage_options.directory
            },
            None
        )
    elif isinstance(storage_options, CustomStorageFacade):
        return (
            {
                "type": "com.icure.sdk.py.PyStorage.StorageFacadeOptions.Custom"
            },
            storage_options
        )
    else:
        raise Exception(f"{type(storage_options)} is not a known type of StorageOptions")
