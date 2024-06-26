import json
from typing import Union, Dict
from model.filter.predicate.NotPredicate import NotPredicate
from model.filter.predicate.AndPredicate import AndPredicate
from model.filter.predicate.AlwaysPredicate import AlwaysPredicate
from model.filter.predicate.OrPredicate import OrPredicate
from model.filter.predicate.KeyValuePredicate import KeyValuePredicate

Predicate = Union['NotPredicate', 'AndPredicate', 'AlwaysPredicate', 'OrPredicate', 'KeyValuePredicate']

def serialize_predicate(predicate: Predicate) -> object:
	if isinstance(predicate, NotPredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.NotPredicate"})
		return serialized_entity
	elif isinstance(predicate, AndPredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.AndPredicate"})
		return serialized_entity
	elif isinstance(predicate, AlwaysPredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.AlwaysPredicate"})
		return serialized_entity
	elif isinstance(predicate, OrPredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.OrPredicate"})
		return serialized_entity
	elif isinstance(predicate, KeyValuePredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.KeyValuePredicate"})
		return serialized_entity
	else:
		raise Exception(f"{type(predicate)} is not a known subclass of Predicate")

def deserialize_predicate(data: Union[str, Dict[str, object]]) -> 'Predicate':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.filter.predicate.NotPredicate":
		NotPredicate._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.filter.predicate.AndPredicate":
		AndPredicate._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.filter.predicate.AlwaysPredicate":
		AlwaysPredicate._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.filter.predicate.OrPredicate":
		OrPredicate._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.filter.predicate.KeyValuePredicate":
		KeyValuePredicate._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Predicate")

__all__ = ['Predicate','serialize_predicate','deserialize_predicate']