import json
from typing import Optional, List, Union, Dict
from model.base.CodeStub import CodeStub
from model.embed.ReferenceRange import ReferenceRange
from dataclasses import field, dataclass

@dataclass
class Measure:
	value: Optional[float] = None
	ref: Optional[float] = None
	severity: Optional[int] = None
	severity_code: Optional[str] = None
	evolution: Optional[int] = None
	unit: Optional[str] = None
	unit_codes: Optional[List['CodeStub']] = None
	comment: Optional[str] = None
	comparator: Optional[str] = None
	sign: Optional[str] = None
	reference_ranges: List['ReferenceRange'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"value": self.value,
			"ref": self.ref,
			"severity": self.severity,
			"severityCode": self.severity_code,
			"evolution": self.evolution,
			"unit": self.unit,
			"unitCodes": [x0.__serialize__() for x0 in self.unit_codes] if self.unit_codes is not None else None,
			"comment": self.comment,
			"comparator": self.comparator,
			"sign": self.sign,
			"referenceRanges": [x0.__serialize__() for x0 in self.reference_ranges],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Measure':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value = deserialized_dict.get("value"),
			ref = deserialized_dict.get("ref"),
			severity = deserialized_dict.get("severity"),
			severity_code = deserialized_dict.get("severityCode"),
			evolution = deserialized_dict.get("evolution"),
			unit = deserialized_dict.get("unit"),
			unit_codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict.get("unitCodes")] if deserialized_dict.get("unitCodes") is not None else None,
			comment = deserialized_dict.get("comment"),
			comparator = deserialized_dict.get("comparator"),
			sign = deserialized_dict.get("sign"),
			reference_ranges = [ReferenceRange._deserialize(x0) for x0 in deserialized_dict["referenceRanges"]],
		)

__all__ = ['Measure']