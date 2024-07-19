from typing import Union, TypeVar, Dict, Generic, Callable, Optional
import json
from enum import Enum


E = TypeVar('E')


class EntitySubscriptionEvent(Generic[E]):
    class Type(Enum):
        Connected = "Connected"
        Reconnected = "Reconnected"
        UnexpectedError = "UnexpectedError"
        ConnectionMissedPing = "ConnectionMissedPing"
        ConnectionClosedByServer = "ConnectionClosedByServer"
        EntityNotification = "EntityNotification"
        EntityDeserializationError = "EntityDeserializationError"

    __type: 'EntitySubscriptionEvent.Type'
    __error_message: Optional[str]
    __entity: Optional[E]

    def __init__(
        self,
        type: 'EntitySubscriptionEvent.Type',
        error_message: Optional[str] = None,
        entity: Optional[E] = None
    ):
        self.__type = type
        self.__error_message = error_message
        self.__entity = entity

    def __str__(self):
        if self.type == EntitySubscriptionEvent.Type.UnexpectedError:
            return f"EntitySubscriptionEvent.UnexpectedError({self.__error_message})"
        elif self.type == EntitySubscriptionEvent.Type.EntityNotification:
            return f"EntitySubscriptionEvent.EntityNotification({self.__entity})"
        else:
            return f"EntitySubscriptionEvent.{self.type.value}"

    @property
    def type(self) -> 'EntitySubscriptionEvent.Type':
        return self.__type

    def error_message(self) -> str:
        if self.type == EntitySubscriptionEvent.Type.UnexpectedError:
            raise Exception("`error_message` is available only for EntitySubscriptionEvent of type UnexpectedError")
        return self.__error_message

    def entity(self) -> E:
        if self.type == EntitySubscriptionEvent.Type.EntityNotification:
            raise Exception("`entity` is available only for EntitySubscriptionEvent of type EntityNotification")
        return self.__error_message

    @classmethod
    def deserialize_entity_subscription_event(
        cls,
        data: Union[str, Dict[str, object]],
        deserialize_entity: Callable[[object], E]
    ) -> 'EntitySubscriptionEvent[E]':
        deserialized_dict: dict[str, object]
        if isinstance(data, str):
            deserialized_dict = json.loads(data)
        else:
            deserialized_dict = data
        qualifier = deserialized_dict.get("type")
        if qualifier is None:
            raise Exception("Missing qualifier: type")
        if qualifier == "com.icure.sdk.subscription.EntitySubscriptionEvent.Connected":
            return EntitySubscriptionEvent(type=EntitySubscriptionEvent.Type.Connected)
        elif qualifier == "com.icure.sdk.subscription.EntitySubscriptionEvent.Reconnected":
            return EntitySubscriptionEvent(type=EntitySubscriptionEvent.Type.Reconnected)
        elif qualifier == "com.icure.sdk.subscription.EntitySubscriptionEvent.UnexpectedError":
            return EntitySubscriptionEvent(type=EntitySubscriptionEvent.Type.UnexpectedError, error_message=deserialized_dict['message'])
        elif qualifier == "com.icure.sdk.subscription.EntitySubscriptionEvent.ConnectionError.MissedPing":
            return EntitySubscriptionEvent(type=EntitySubscriptionEvent.Type.ConnectionMissedPing)
        elif qualifier == "com.icure.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ClosedByServer":
            return EntitySubscriptionEvent(type=EntitySubscriptionEvent.Type.ConnectionClosedByServer)
        elif qualifier == "com.icure.sdk.subscription.EntitySubscriptionEvent.EntityNotification":
            entity = deserialize_entity(deserialized_dict['entity'])
            return EntitySubscriptionEvent(type=EntitySubscriptionEvent.Type.EntityNotification, entity=entity)
        elif qualifier == "com.icure.sdk.subscription.EntitySubscriptionEvent.EntityError.DeserializationError":
            return EntitySubscriptionEvent(type=EntitySubscriptionEvent.Type.EntityDeserializationError)
        else:
            raise Exception(f"{qualifier} is not a known subclass of EntitySubscriptionEvent")