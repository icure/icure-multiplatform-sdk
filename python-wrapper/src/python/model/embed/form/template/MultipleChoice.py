import json
from typing import Optional, List, Dict, Union
from dataclasses import dataclass

@dataclass
class MultipleChoice:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MultipleChoice':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field = deserialized_dict["field"],
			short_label = deserialized_dict.get("shortLabel"),
			rows = deserialized_dict.get("rows"),
			columns = deserialized_dict.get("columns"),
			grows = deserialized_dict.get("grows"),
			multiline = deserialized_dict.get("multiline"),
			schema = deserialized_dict.get("schema"),
			tags = [x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications = [x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value = deserialized_dict.get("value"),
			unit = deserialized_dict.get("unit"),
			required = deserialized_dict.get("required"),
			hide_condition = deserialized_dict.get("hideCondition"),
			now = deserialized_dict.get("now"),
			translate = deserialized_dict.get("translate"),
		)

__all__ = ['MultipleChoice']