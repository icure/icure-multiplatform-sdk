from typing import Generic, TypeVar, List, Optional, Callable
from ctypes import c_void_p, cast, c_char_p
from icure.kotlin_types import symbols, DATA_RESULT_CALLBACK_FUNC
from icure.model.CallResult import create_result_from_json
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
        symbols.kotlin.root.com.icure.sdk.py.utils.disposeStablePtr(self.__producer)

    def has_next_blocking(self) -> bool:
        call_result = symbols.kotlin.root.com.icure.sdk.py.utils.PaginatedListIterator.hasNextBlocking(self.__producer)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if result_info.failure is not None:
            raise Exception(result_info.failure)
        else:
            return result_info.success

    async def has_next_async(self) -> bool:
        loop = asyncio.get_running_loop()
        future = loop.create_future()
        def make_result_and_complete(success, failure):
            if failure is not None:
                result = Exception(failure.decode('utf-8'))
                loop.call_soon_threadsafe(lambda: future.set_exception(result))
            else:
                result = json.loads(success.decode('utf-8'))
                loop.call_soon_threadsafe(lambda: future.set_result(result))
        callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
        loop.run_in_executor(
            self.__executor,
            symbols.kotlin.root.com.icure.sdk.py.utils.PaginatedListIterator.hasNextAsync,
            self.__producer,
            callback
        )
        return await future

    def next_blocking(self, limit: int) -> List[T]:
        call_result = symbols.kotlin.root.com.icure.sdk.py.utils.PaginatedListIterator.nextBlocking(self.__producer, limit)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if result_info.failure is not None:
            raise Exception(result_info.failure)
        else:
            return [self.__deserializer(item) for item in result_info.success]

    async def next_async(self, limit: int) -> List[T]:
        loop = asyncio.get_running_loop()
        future = loop.create_future()
        def make_result_and_complete(success, failure):
            if failure is not None:
                result = Exception(failure.decode('utf-8'))
                loop.call_soon_threadsafe(lambda: future.set_exception(result))
            else:
                result = [self.__deserializer(item) for item in json.loads(success)]
                loop.call_soon_threadsafe(lambda: future.set_result(result))
        callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
        loop.run_in_executor(
            self.__executor,
            symbols.kotlin.root.com.icure.sdk.py.utils.PaginatedListIterator.nextAsync,
            self.__producer,
            limit,
            callback
        )
        return await future

