from typing import Generic, TypeVar, List, Optional, Callable
from ctypes import c_void_p, cast, c_char_p
from concurrent.futures import Executor
from kotlin_types import symbols
from model import EntitySubscriptionCloseReason
from model.CallResult import create_result_from_json
from datetime import timedelta
from subscription.EntitySubscriptionEvent import EntitySubscriptionEvent
import math


T = TypeVar('T')


class EntitySubscription(Generic[T]):
    def __init__(self, producer: c_void_p, deserializer: Callable[[object], T], executor: Optional[Executor] = None):
        self.__producer = producer
        self.__deserializer = deserializer
        self.__executor = executor

    def __del__(self):
        symbols.kotlin.root.com.icure.sdk.py.utils.disposeStablePtr(self.__producer)

    def close(self):
        call_result = symbols.kotlin.root.com.icure.sdk.py.subscription.EntitySubscription.close(self.__producer)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if result_info.failure is not None:
            raise Exception(result_info.failure)

    def get_close_reason(self) -> Optional[EntitySubscriptionCloseReason]:
        call_result = symbols.kotlin.root.com.icure.sdk.py.subscription.EntitySubscription.getCloseReason(self.__producer)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if result_info.failure is not None:
            raise Exception(result_info.failure)
        elif result_info.success is not None:
            return EntitySubscriptionCloseReason._deserialize(result_info.success)
        else:
            return None

    def get_event(self) -> Optional[EntitySubscriptionEvent[T]]:
        call_result = symbols.kotlin.root.com.icure.sdk.py.subscription.EntitySubscription.getEvent(self.__producer)
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if result_info.failure is not None:
            raise Exception(result_info.failure)
        else:
            return self.__decode_event(result_info.success)

    def wait_for_event_blocking(self, timeout: timedelta) -> Optional[EntitySubscriptionEvent[T]]:
        call_result = symbols.kotlin.root.com.icure.sdk.py.subscription.EntitySubscription.waitForEventBlocking(
            self.__producer,
            EntitySubscription.__time_delta_ms(timeout)
        )
        result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
        symbols.DisposeString(call_result)
        if result_info.failure is not None:
            raise Exception(result_info.failure)
        else:
            return self.__decode_event(result_info.success)

    def wait_for_event_async(self, timeout: timedelta) -> Optional[EntitySubscriptionEvent[T]]:
        raise "TODO"

    def __decode_event(self, encoded_event) -> Optional[EntitySubscriptionEvent[T]]:
        if encoded_event is not None:
            return EntitySubscriptionEvent.deserialize_entity_subscription_event(encoded_event, self.__deserializer)
        else:
            return None

    @staticmethod
    def __time_delta_ms(delta: timedelta) -> int:
        total_milliseconds = delta.total_seconds() * 1000
        return math.ceil(total_milliseconds)
