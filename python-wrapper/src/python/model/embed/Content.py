import json
import base64
from typing import Union, Dict, Optional, List
from model.embed.Measure import Measure
from model.embed.Medication import Medication
from model.embed.TimeSeries import TimeSeries
from model.embed.Service import EncryptedService, DecryptedService
from dataclasses import dataclass

Content = Union['EncryptedContent', 'DecryptedContent']

def serialize_content(content: Content) -> object:
	if isinstance(content, EncryptedContent):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedContent",
			"entity": content.__serialize__()
		}
	elif isinstance(content, DecryptedContent):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedContent",
			"entity": content.__serialize__()
		}
	else:
		raise Exception(f"{type(content)} is not a known subclass of Content")

def deserialize_content(data: Union[str, Dict[str, object]]) -> 'Content':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedContent":
		EncryptedContent._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedContent":
		DecryptedContent._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Content")

@dataclass
class EncryptedContent:
	string_value: Optional[str] = None
	number_value: Optional[float] = None
	boolean_value: Optional[bool] = None
	instant_value: Optional[int] = None
	fuzzy_date_value: Optional[int] = None
	binary_value: Optional[bytearray] = None
	document_id: Optional[str] = None
	measure_value: Optional['Measure'] = None
	medication_value: Optional['Medication'] = None
	time_series: Optional['TimeSeries'] = None
	compound_value: Optional[List['EncryptedService']] = None
	ratio: Optional[List['Measure']] = None
	range: Optional[List['Measure']] = None

	def __serialize__(self) -> object:
		return {
			"stringValue": self.string_value,
			"numberValue": self.number_value,
			"booleanValue": self.boolean_value,
			"instantValue": self.instant_value,
			"fuzzyDateValue": self.fuzzy_date_value,
			"binaryValue": base64.b64encode(self.binary_value).decode('utf-8') if self.binary_value is not None else None,
			"documentId": self.document_id,
			"measureValue": self.measure_value.__serialize__() if self.measure_value is not None else None,
			"medicationValue": self.medication_value.__serialize__() if self.medication_value is not None else None,
			"timeSeries": self.time_series.__serialize__() if self.time_series is not None else None,
			"compoundValue": [x0.__serialize__() for x0 in self.compound_value] if self.compound_value is not None else None,
			"ratio": [x0.__serialize__() for x0 in self.ratio] if self.ratio is not None else None,
			"range": [x0.__serialize__() for x0 in self.range] if self.range is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedContent':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			string_value = deserialized_dict.get("stringValue"),
			number_value = deserialized_dict.get("numberValue"),
			boolean_value = deserialized_dict.get("booleanValue"),
			instant_value = deserialized_dict.get("instantValue"),
			fuzzy_date_value = deserialized_dict.get("fuzzyDateValue"),
			binary_value = bytearray(base64.b64decode(deserialized_dict.get("binaryValue"))) if deserialized_dict.get("binaryValue") is not None else None,
			document_id = deserialized_dict.get("documentId"),
			measure_value = Measure._deserialize(deserialized_dict.get("measureValue")) if deserialized_dict.get("measureValue") is not None else None,
			medication_value = Medication._deserialize(deserialized_dict.get("medicationValue")) if deserialized_dict.get("medicationValue") is not None else None,
			time_series = TimeSeries._deserialize(deserialized_dict.get("timeSeries")) if deserialized_dict.get("timeSeries") is not None else None,
			compound_value = [EncryptedService._deserialize(x0) for x0 in deserialized_dict.get("compoundValue")] if deserialized_dict.get("compoundValue") is not None else None,
			ratio = [Measure._deserialize(x0) for x0 in deserialized_dict.get("ratio")] if deserialized_dict.get("ratio") is not None else None,
			range = [Measure._deserialize(x0) for x0 in deserialized_dict.get("range")] if deserialized_dict.get("range") is not None else None,
		)

@dataclass
class DecryptedContent:
	string_value: Optional[str] = None
	number_value: Optional[float] = None
	boolean_value: Optional[bool] = None
	instant_value: Optional[int] = None
	fuzzy_date_value: Optional[int] = None
	binary_value: Optional[bytearray] = None
	document_id: Optional[str] = None
	measure_value: Optional['Measure'] = None
	medication_value: Optional['Medication'] = None
	time_series: Optional['TimeSeries'] = None
	compound_value: Optional[List['DecryptedService']] = None
	ratio: Optional[List['Measure']] = None
	range: Optional[List['Measure']] = None

	def __serialize__(self) -> object:
		return {
			"stringValue": self.string_value,
			"numberValue": self.number_value,
			"booleanValue": self.boolean_value,
			"instantValue": self.instant_value,
			"fuzzyDateValue": self.fuzzy_date_value,
			"binaryValue": base64.b64encode(self.binary_value).decode('utf-8') if self.binary_value is not None else None,
			"documentId": self.document_id,
			"measureValue": self.measure_value.__serialize__() if self.measure_value is not None else None,
			"medicationValue": self.medication_value.__serialize__() if self.medication_value is not None else None,
			"timeSeries": self.time_series.__serialize__() if self.time_series is not None else None,
			"compoundValue": [x0.__serialize__() for x0 in self.compound_value] if self.compound_value is not None else None,
			"ratio": [x0.__serialize__() for x0 in self.ratio] if self.ratio is not None else None,
			"range": [x0.__serialize__() for x0 in self.range] if self.range is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedContent':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			string_value = deserialized_dict.get("stringValue"),
			number_value = deserialized_dict.get("numberValue"),
			boolean_value = deserialized_dict.get("booleanValue"),
			instant_value = deserialized_dict.get("instantValue"),
			fuzzy_date_value = deserialized_dict.get("fuzzyDateValue"),
			binary_value = bytearray(base64.b64decode(deserialized_dict.get("binaryValue"))) if deserialized_dict.get("binaryValue") is not None else None,
			document_id = deserialized_dict.get("documentId"),
			measure_value = Measure._deserialize(deserialized_dict.get("measureValue")) if deserialized_dict.get("measureValue") is not None else None,
			medication_value = Medication._deserialize(deserialized_dict.get("medicationValue")) if deserialized_dict.get("medicationValue") is not None else None,
			time_series = TimeSeries._deserialize(deserialized_dict.get("timeSeries")) if deserialized_dict.get("timeSeries") is not None else None,
			compound_value = [DecryptedService._deserialize(x0) for x0 in deserialized_dict.get("compoundValue")] if deserialized_dict.get("compoundValue") is not None else None,
			ratio = [Measure._deserialize(x0) for x0 in deserialized_dict.get("ratio")] if deserialized_dict.get("ratio") is not None else None,
			range = [Measure._deserialize(x0) for x0 in deserialized_dict.get("range")] if deserialized_dict.get("range") is not None else None,
		)

__all__ = ['Content','serialize_content','deserialize_content','EncryptedContent','DecryptedContent']