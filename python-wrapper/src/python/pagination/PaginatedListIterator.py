from typing import Generic, TypeVar, List, Optional, Callable
from ctypes import c_void_p, cast, c_char_p
from kotlin_types import symbols
from model.CallResult import create_result_from_json

T = TypeVar('T')

class PaginatedListIterator(Generic[T]):

    def __init__(self, producer: c_void_p, deserializer: Callable[[str], T]):
        self.producer = producer
        self.deserializer = deserializer

    def has_next_blocking(self) -> bool:
        call_result = symbols.kotlin.root.icure.sdk.py.utils.PaginatedListIterator.hasNextBlocking(self.producer)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if "failure" in result_info and result_info.get("failure") is not None:
            raise Exception(result_info["failure"])
        else:
            return result_info["success"]

    def has_next_async(self) -> bool:
        raise "TODO"

    def next_blocking(self, limit: int) -> List[T]:
        call_result = symbols.kotlin.root.icure.sdk.py.utils.PaginatedListIterator.nextBlocking(self.producer, limit)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if "failure" in result_info and result_info.get("failure") is not None:
            raise Exception(result_info["failure"])
        else:
            return result_info["success"]  # TODO deserialize

    def next_async(self, limit: int) -> List[T]:
        raise "TODO"

