import json
from typing import List
from typing import Union
from typing import Dict
from dataclasses import dataclass
from enum import Enum
from typing import Optional

@dataclass
class ShamirUpdateRequest:
	notaries_ids: List[str]
	min_shares: int

	def __serialize__(self) -> object:
		return {
			"notariesIds": [x0 for x0 in self.notaries_ids],
			"minShares": self.min_shares,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShamirUpdateRequest':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			notaries_ids = [x0 for x0 in deserialized_dict["notariesIds"]],
			min_shares = deserialized_dict["minShares"],
		)

RecoveryDataKey = 'HexString'

RecoveryResult = Union['RecoveryResultSuccess', 'RecoveryResultFailure']

@dataclass
class RecoveryResultSuccess:
	data: object

	def __serialize__(self) -> object:
		return {
			"data": self.data.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryResultSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data = deserialized_dict["data"],
		)

@dataclass
class RecoveryResultFailure:
	reason: 'RecoveryDataUseFailureReason'

	def __serialize__(self) -> object:
		return {
			"reason": self.reason.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryResultFailure':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			reason = RecoveryDataUseFailureReason._deserialize(deserialized_dict["reason"]),
		)

def serialize_recovery_result(recovery_result: RecoveryResult) -> object:
	if isinstance(recovery_result, RecoveryResultSuccess):
		serialized_entity = recovery_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.RecoveryResult.Success"})
		return serialized_entity
	elif isinstance(recovery_result, RecoveryResultFailure):
		serialized_entity = recovery_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.RecoveryResult.Failure"})
		return serialized_entity
	else:
		raise Exception(f"{type(recovery_result)} is not a known subclass of RecoveryResult")

def deserialize_recovery_result(data: Union[str, Dict[str, object]]) -> 'RecoveryResult':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.RecoveryResult.Success":
		RecoveryResultSuccess._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.RecoveryResult.Failure":
		RecoveryResultFailure._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of RecoveryResult")

class RecoveryDataUseFailureReason(Enum):
	Missing = "Missing"
	Unauthorized = "Unauthorized"
	InvalidType = "InvalidType"
	InvalidContent = "InvalidContent"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryDataUseFailureReason':
		if data == "Missing":
			return RecoveryDataUseFailureReason.Missing
		elif data == "Unauthorized":
			return RecoveryDataUseFailureReason.Unauthorized
		elif data == "InvalidType":
			return RecoveryDataUseFailureReason.InvalidType
		elif data == "InvalidContent":
			return RecoveryDataUseFailureReason.InvalidContent
		else:
			raise Exception(f"{data} is not a valid value for RecoveryDataUseFailureReason enum.")

SecretIdOption = Union['SecretIdOptionUseAnyConfidential', 'SecretIdOptionUseAnySharedWithParent', 'SecretIdOptionUse']

@dataclass
class SecretIdOptionUse:
	secret_ids: List[str]

	def __serialize__(self) -> object:
		return {
			"secretIds": [x0 for x0 in self.secret_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SecretIdOptionUse':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secret_ids = [x0 for x0 in deserialized_dict["secretIds"]],
		)

def serialize_secret_id_option(secret_id_option: SecretIdOption) -> object:
	if isinstance(secret_id_option, SecretIdOptionUseAnyConfidential):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential"})
		return serialized_entity
	elif isinstance(secret_id_option, SecretIdOptionUseAnySharedWithParent):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent"})
		return serialized_entity
	elif isinstance(secret_id_option, SecretIdOptionUse):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.Use"})
		return serialized_entity
	else:
		raise Exception(f"{type(secret_id_option)} is not a known subclass of SecretIdOption")

def deserialize_secret_id_option(data: Union[str, Dict[str, object]]) -> 'SecretIdOption':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential":
		SecretIdOptionUseAnyConfidential._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent":
		SecretIdOptionUseAnySharedWithParent._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.Use":
		SecretIdOptionUse._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SecretIdOption")

SimpleShareResult = Union['SimpleShareResultSuccess', 'SimpleShareResultFailure']

@dataclass
class SimpleShareResultSuccess:
	updated_entity: object

	def __serialize__(self) -> object:
		return {
			"updatedEntity": self.updated_entity.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SimpleShareResultSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			updated_entity = deserialized_dict["updatedEntity"],
		)

@dataclass
class SimpleShareResultFailure:
	errors_details: List['FailedRequestDetails']

	def __serialize__(self) -> object:
		return {
			"errorsDetails": [x0.__serialize__() for x0 in self.errors_details],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SimpleShareResultFailure':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			errors_details = [FailedRequestDetails._deserialize(x0) for x0 in deserialized_dict["errorsDetails"]],
		)

def serialize_simple_share_result(simple_share_result: SimpleShareResult) -> object:
	if isinstance(simple_share_result, SimpleShareResultSuccess):
		serialized_entity = simple_share_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SimpleShareResult.Success"})
		return serialized_entity
	elif isinstance(simple_share_result, SimpleShareResultFailure):
		serialized_entity = simple_share_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SimpleShareResult.Failure"})
		return serialized_entity
	else:
		raise Exception(f"{type(simple_share_result)} is not a known subclass of SimpleShareResult")

def deserialize_simple_share_result(data: Union[str, Dict[str, object]]) -> 'SimpleShareResult':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.SimpleShareResult.Success":
		SimpleShareResultSuccess._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SimpleShareResult.Failure":
		SimpleShareResultFailure._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SimpleShareResult")

class ShareMetadataBehaviour(Enum):
	Required = "REQUIRED"
	IfAvailable = "IF_AVAILABLE"
	Never = "NEVER"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareMetadataBehaviour':
		if data == "REQUIRED":
			return ShareMetadataBehaviour.Required
		elif data == "IF_AVAILABLE":
			return ShareMetadataBehaviour.IfAvailable
		elif data == "NEVER":
			return ShareMetadataBehaviour.Never
		else:
			raise Exception(f"{data} is not a valid value for ShareMetadataBehaviour enum.")

@dataclass
class TimeTableShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimeTableShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
		)

@dataclass
class EntityAccessInformation:
	permissions_by_data_owner_id: Dict[str, 'AccessLevel']
	has_unknown_anonymous_data_owners: bool

	def __serialize__(self) -> object:
		return {
			"permissionsByDataOwnerId": {k0: v0.__serialize__() for k0, v0 in self.permissions_by_data_owner_id.items()},
			"hasUnknownAnonymousDataOwners": self.has_unknown_anonymous_data_owners,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityAccessInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			permissions_by_data_owner_id = dict(map(lambda kv0: (kv0[0], AccessLevel._deserialize(kv0[1])), deserialized_dict["permissionsByDataOwnerId"].items())),
			has_unknown_anonymous_data_owners = deserialized_dict["hasUnknownAnonymousDataOwners"],
		)

@dataclass
class ClassificationShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ClassificationShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class MaintenanceTaskShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MaintenanceTaskShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
		)

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
	description: str

	def __serialize__(self) -> object:
		return {
			"description": self.description,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FailedRequest':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			description = deserialized_dict["description"],
		)

@dataclass
class EntityWithTypeInfo:
	entity: object
	type: 'EntityWithEncryptionMetadataTypeName'

	def __serialize__(self) -> object:
		return {
			"entity": self.entity.__serialize__(),
			"type": self.type.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityWithTypeInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity = deserialized_dict["entity"],
			type = EntityWithEncryptionMetadataTypeName._deserialize(deserialized_dict["type"]),
		)

@dataclass
class PatientShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_secret_ids: List[str]

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareSecretIds": [x0 for x0 in self.share_secret_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_secret_ids = [x0 for x0 in deserialized_dict["shareSecretIds"]],
		)

@dataclass
class ContactShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class ReceiptShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReceiptShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
		)

@dataclass
class HealthElementShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class AccessLogShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AccessLogShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class TopicShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TopicShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class CalendarItemShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CalendarItemShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class DocumentShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_message_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareMessageId": self.share_message_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_message_id = ShareMetadataBehaviour._deserialize(deserialized_dict["shareMessageId"]),
		)

@dataclass
class FormShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FormShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class InvoiceShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'InvoiceShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class MessageShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key = ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id = ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class FailedRequestDetails:
	entity_id: str
	delegate_id: str
	updated_for_migration: bool
	code: Optional[int]
	reason: Optional[str]
	request: Optional['DelegateShareOptions']

	def __serialize__(self) -> object:
		return {
			"entityId": self.entity_id,
			"delegateId": self.delegate_id,
			"updatedForMigration": self.updated_for_migration,
			"code": self.code,
			"reason": self.reason,
			"request": self.request.__serialize__() if self.request is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FailedRequestDetails':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity_id = deserialized_dict["entityId"],
			delegate_id = deserialized_dict["delegateId"],
			updated_for_migration = deserialized_dict["updatedForMigration"],
			code = deserialized_dict.get("code"),
			reason = deserialized_dict.get("reason"),
			request = DelegateShareOptions._deserialize(deserialized_dict.get("request")) if deserialized_dict.get("request") is not None else None,
		)

class EntityWithEncryptionMetadataTypeName(Enum):
	Article = "Article"
	AccessLog = "AccessLog"
	CalendarItem = "CalendarItem"
	Classification = "Classification"
	ClassificationTemplate = "ClassificationTemplate"
	Contact = "Contact"
	Service = "Service"
	Document = "Document"
	Form = "Form"
	HealthElement = "HealthElement"
	Invoice = "Invoice"
	MaintenanceTask = "MaintenanceTask"
	Message = "Message"
	Patient = "Patient"
	Receipt = "Receipt"
	TimeTable = "TimeTable"
	Topic = "Topic"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityWithEncryptionMetadataTypeName':
		if data == "Article":
			return EntityWithEncryptionMetadataTypeName.Article
		elif data == "AccessLog":
			return EntityWithEncryptionMetadataTypeName.AccessLog
		elif data == "CalendarItem":
			return EntityWithEncryptionMetadataTypeName.CalendarItem
		elif data == "Classification":
			return EntityWithEncryptionMetadataTypeName.Classification
		elif data == "ClassificationTemplate":
			return EntityWithEncryptionMetadataTypeName.ClassificationTemplate
		elif data == "Contact":
			return EntityWithEncryptionMetadataTypeName.Contact
		elif data == "Service":
			return EntityWithEncryptionMetadataTypeName.Service
		elif data == "Document":
			return EntityWithEncryptionMetadataTypeName.Document
		elif data == "Form":
			return EntityWithEncryptionMetadataTypeName.Form
		elif data == "HealthElement":
			return EntityWithEncryptionMetadataTypeName.HealthElement
		elif data == "Invoice":
			return EntityWithEncryptionMetadataTypeName.Invoice
		elif data == "MaintenanceTask":
			return EntityWithEncryptionMetadataTypeName.MaintenanceTask
		elif data == "Message":
			return EntityWithEncryptionMetadataTypeName.Message
		elif data == "Patient":
			return EntityWithEncryptionMetadataTypeName.Patient
		elif data == "Receipt":
			return EntityWithEncryptionMetadataTypeName.Receipt
		elif data == "TimeTable":
			return EntityWithEncryptionMetadataTypeName.TimeTable
		elif data == "Topic":
			return EntityWithEncryptionMetadataTypeName.Topic
		else:
			raise Exception(f"{data} is not a valid value for EntityWithEncryptionMetadataTypeName enum.")

@dataclass
class DelegateShareOptions:
	share_secret_ids: List[str]
	share_encryption_keys: List['HexString']
	share_owning_entity_ids: List[str]
	requested_permissions: 'RequestedPermission'

	def __serialize__(self) -> object:
		return {
			"shareSecretIds": [x0 for x0 in self.share_secret_ids],
			"shareEncryptionKeys": [x0.__serialize__() for x0 in self.share_encryption_keys],
			"shareOwningEntityIds": [x0 for x0 in self.share_owning_entity_ids],
			"requestedPermissions": self.requested_permissions.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DelegateShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			share_secret_ids = [x0 for x0 in deserialized_dict["shareSecretIds"]],
			share_encryption_keys = [HexString._deserialize(x0) for x0 in deserialized_dict["shareEncryptionKeys"]],
			share_owning_entity_ids = [x0 for x0 in deserialized_dict["shareOwningEntityIds"]],
			requested_permissions = RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
		)
