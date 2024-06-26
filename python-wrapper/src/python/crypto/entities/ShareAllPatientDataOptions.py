import json
from typing import Union, Dict, Optional, List
from enum import Enum
from dataclasses import dataclass
from model.Patient import Patient, serialize_patient, deserialize_patient
from crypto.entities.FailedRequestDetails import FailedRequestDetails

class Tag(Enum):
	All = "All"
	MedicalInformation = "MedicalInformation"
	FinancialInformation = "FinancialInformation"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Tag':
		if data == "All":
			return Tag.All
		elif data == "MedicalInformation":
			return Tag.MedicalInformation
		elif data == "FinancialInformation":
			return Tag.FinancialInformation
		else:
			raise Exception(f"{data} is not a valid value for Tag enum.")

class ShareableEntity(Enum):
	CalendarItem = "CalendarItem"
	Contact = "Contact"
	Classification = "Classification"
	Document = "Document"
	Form = "Form"
	HealthElement = "HealthElement"
	Invoice = "Invoice"
	Patient = "Patient"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareableEntity':
		if data == "CalendarItem":
			return ShareableEntity.CalendarItem
		elif data == "Contact":
			return ShareableEntity.Contact
		elif data == "Classification":
			return ShareableEntity.Classification
		elif data == "Document":
			return ShareableEntity.Document
		elif data == "Form":
			return ShareableEntity.Form
		elif data == "HealthElement":
			return ShareableEntity.HealthElement
		elif data == "Invoice":
			return ShareableEntity.Invoice
		elif data == "Patient":
			return ShareableEntity.Patient
		else:
			raise Exception(f"{data} is not a valid value for ShareableEntity enum.")

@dataclass
class EntityResult:
	modified: int
	success: Optional[bool] = None
	error: Optional['SharePatientDataError'] = None

	def __serialize__(self) -> object:
		return {
			"success": self.success,
			"error": serialize_share_patient_data_error(self.error) if self.error is not None else None,
			"modified": self.modified,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityResult':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			success = deserialized_dict.get("success"),
			error = deserialize_share_patient_data_error(deserialized_dict.get("error")) if deserialized_dict.get("error") is not None else None,
			modified = deserialized_dict["modified"],
		)

@dataclass
class Result:
	patient: 'Patient'
	statuses: Dict['ShareableEntity', 'EntityResult']

	def __serialize__(self) -> object:
		return {
			"patient": serialize_patient(self.patient),
			"statuses": {k0.__serialize__(): v0.__serialize__() for k0, v0 in self.statuses.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Result':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			patient = deserialize_patient(deserialized_dict["patient"]),
			statuses = dict(map(lambda kv0: (ShareableEntity._deserialize(kv0[0]), EntityResult._deserialize(kv0[1])), deserialized_dict["statuses"].items())),
		)

SharePatientDataError = Union['BulkShareFailure', 'FailedRequest']

def serialize_share_patient_data_error(share_patient_data_error: SharePatientDataError) -> object:
	if isinstance(share_patient_data_error, BulkShareFailure):
		serialized_entity = share_patient_data_error.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure"})
		return serialized_entity
	elif isinstance(share_patient_data_error, FailedRequest):
		serialized_entity = share_patient_data_error.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest"})
		return serialized_entity
	else:
		raise Exception(f"{type(share_patient_data_error)} is not a known subclass of SharePatientDataError")

def deserialize_share_patient_data_error(data: Union[str, Dict[str, object]]) -> 'SharePatientDataError':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure":
		BulkShareFailure._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest":
		FailedRequest._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SharePatientDataError")

@dataclass
class BulkShareFailure:
	errors: List['FailedRequestDetails']
	message: str

	def __serialize__(self) -> object:
		return {
			"errors": [x0.__serialize__() for x0 in self.errors],
			"message": self.message,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'BulkShareFailure':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			errors = [FailedRequestDetails._deserialize(x0) for x0 in deserialized_dict["errors"]],
			message = deserialized_dict["message"],
		)

@dataclass
class FailedRequest:
	exception: Exception

	def __serialize__(self) -> object:
		return {
			"exception": self.exception.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FailedRequest':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			exception = Exception._deserialize(deserialized_dict["exception"]),
		)

__all__ = ['Tag','ShareableEntity','EntityResult','Result','SharePatientDataError','serialize_share_patient_data_error','deserialize_share_patient_data_error','BulkShareFailure','FailedRequest']