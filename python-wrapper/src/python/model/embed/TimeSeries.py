import json
from typing import List, Union, Dict
from dataclasses import field, dataclass

@dataclass
class TimeSeries:
	fields: List[str] = field(default_factory=list)
	samples: List[List[float]] = field(default_factory=list)
	min: List[float] = field(default_factory=list)
	max: List[float] = field(default_factory=list)
	mean: List[float] = field(default_factory=list)
	median: List[float] = field(default_factory=list)
	variance: List[float] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"fields": [x0 for x0 in self.fields],
			"samples": [[x1 for x1 in x0] for x0 in self.samples],
			"min": [x0 for x0 in self.min],
			"max": [x0 for x0 in self.max],
			"mean": [x0 for x0 in self.mean],
			"median": [x0 for x0 in self.median],
			"variance": [x0 for x0 in self.variance],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimeSeries':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			fields = [x0 for x0 in deserialized_dict["fields"]],
			samples = [[x1 for x1 in x0] for x0 in deserialized_dict["samples"]],
			min = [x0 for x0 in deserialized_dict["min"]],
			max = [x0 for x0 in deserialized_dict["max"]],
			mean = [x0 for x0 in deserialized_dict["mean"]],
			median = [x0 for x0 in deserialized_dict["median"]],
			variance = [x0 for x0 in deserialized_dict["variance"]],
		)

__all__ = ['TimeSeries']