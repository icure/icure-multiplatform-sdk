from typing import Generic, TypeVar, List, Optional, Callable
from ctypes import c_void_p, cast, c_char_p

from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols, DATA_RESULT_CALLBACK_FUNC
from cardinal_sdk.model.CallResult import create_result_from_json
import asyncio
import json
from concurrent.futures import Executor

T = TypeVar('T')

class PaginatedListIterator(Generic[T]):

    def __init__(self, producer: c_void_p, deserializer: Callable[[str], T], executor: Optional[Executor] = None):
        self.__producer = producer
        self.__deserializer = deserializer
        self.__executor = executor

    def __del__(self):
        symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.disposeStablePtr(self.__producer)

    def has_next_blocking(self) -> bool:
        call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PaginatedListIterator.hasNextBlocking(self.__producer)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if result_info.failure is not None:
            raise Exception(result_info.failure)
        else:
            return result_info.success

    async def has_next_async(self) -> bool:
        def do_decode(x):
            return x
        return await execute_async_method_job(
            self.__executor,
            True,
            do_decode,
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PaginatedListIterator.hasNextAsync,
            self.__producer,
        )

    def next_blocking(self, limit: int) -> List[T]:
        call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PaginatedListIterator.nextBlocking(self.__producer, limit)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if result_info.failure is not None:
            raise Exception(result_info.failure)
        else:
            return [self.__deserializer(item) for item in result_info.success]

    async def next_async(self, limit: int) -> List[T]:
        def do_decode(x):
            return [self.__deserializer(item) for item in x]
        return await execute_async_method_job(
            self.__executor,
            True,
            do_decode,
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PaginatedListIterator.nextAsync,
            self.__producer,
            limit
        )
