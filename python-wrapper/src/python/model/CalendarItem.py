import json
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.Address import DecryptedAddress, EncryptedAddress
from model.embed.CalendarItemTag import CalendarItemTag
from model.embed.FlowItem import FlowItem
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata

CalendarItem = Union['DecryptedCalendarItem', 'EncryptedCalendarItem']

def serialize_calendar_item(calendar_item: CalendarItem) -> object:
	if isinstance(calendar_item, DecryptedCalendarItem):
		return {
			"type": "com.icure.sdk.model.DecryptedCalendarItem",
			"entity": calendar_item.__serialize__()
		}
	elif isinstance(calendar_item, EncryptedCalendarItem):
		return {
			"type": "com.icure.sdk.model.EncryptedCalendarItem",
			"entity": calendar_item.__serialize__()
		}
	else:
		raise Exception(f"{type(calendar_item)} is not a known subclass of CalendarItem")

def deserialize_calendar_item(data: Union[str, Dict[str, object]]) -> 'CalendarItem':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedCalendarItem":
		DecryptedCalendarItem._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedCalendarItem":
		EncryptedCalendarItem._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of CalendarItem")

@dataclass
class DecryptedCalendarItem:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	title: Optional[str] = None
	calendar_item_type_id: Optional[str] = None
	master_calendar_item_id: Optional[str] = None
	patient_id: Optional[str] = None
	important: Optional[bool] = None
	home_visit: Optional[bool] = None
	phone_number: Optional[str] = None
	place_id: Optional[str] = None
	address: Optional['DecryptedAddress'] = None
	address_text: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	confirmation_time: Optional[int] = None
	cancellation_timestamp: Optional[int] = None
	confirmation_id: Optional[str] = None
	duration: Optional[int] = None
	all_day: Optional[bool] = None
	details: Optional[str] = None
	was_migrated: Optional[bool] = None
	agenda_id: Optional[str] = None
	hcp_id: Optional[str] = None
	recurrence_id: Optional[str] = None
	meeting_tags: List['CalendarItemTag'] = field(default_factory=list)
	flow_item: Optional['FlowItem'] = None
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"title": self.title,
			"calendarItemTypeId": self.calendar_item_type_id,
			"masterCalendarItemId": self.master_calendar_item_id,
			"patientId": self.patient_id,
			"important": self.important,
			"homeVisit": self.home_visit,
			"phoneNumber": self.phone_number,
			"placeId": self.place_id,
			"address": self.address.__serialize__() if self.address is not None else None,
			"addressText": self.address_text,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"confirmationTime": self.confirmation_time,
			"cancellationTimestamp": self.cancellation_timestamp,
			"confirmationId": self.confirmation_id,
			"duration": self.duration,
			"allDay": self.all_day,
			"details": self.details,
			"wasMigrated": self.was_migrated,
			"agendaId": self.agenda_id,
			"hcpId": self.hcp_id,
			"recurrenceId": self.recurrence_id,
			"meetingTags": [x0.__serialize__() for x0 in self.meeting_tags],
			"flowItem": self.flow_item.__serialize__() if self.flow_item is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedCalendarItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			title = deserialized_dict.get("title"),
			calendar_item_type_id = deserialized_dict.get("calendarItemTypeId"),
			master_calendar_item_id = deserialized_dict.get("masterCalendarItemId"),
			patient_id = deserialized_dict.get("patientId"),
			important = deserialized_dict.get("important"),
			home_visit = deserialized_dict.get("homeVisit"),
			phone_number = deserialized_dict.get("phoneNumber"),
			place_id = deserialized_dict.get("placeId"),
			address = DecryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
			address_text = deserialized_dict.get("addressText"),
			start_time = deserialized_dict.get("startTime"),
			end_time = deserialized_dict.get("endTime"),
			confirmation_time = deserialized_dict.get("confirmationTime"),
			cancellation_timestamp = deserialized_dict.get("cancellationTimestamp"),
			confirmation_id = deserialized_dict.get("confirmationId"),
			duration = deserialized_dict.get("duration"),
			all_day = deserialized_dict.get("allDay"),
			details = deserialized_dict.get("details"),
			was_migrated = deserialized_dict.get("wasMigrated"),
			agenda_id = deserialized_dict.get("agendaId"),
			hcp_id = deserialized_dict.get("hcpId"),
			recurrence_id = deserialized_dict.get("recurrenceId"),
			meeting_tags = [CalendarItemTag._deserialize(x0) for x0 in deserialized_dict["meetingTags"]],
			flow_item = FlowItem._deserialize(deserialized_dict.get("flowItem")) if deserialized_dict.get("flowItem") is not None else None,
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedCalendarItem:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	title: Optional[str] = None
	calendar_item_type_id: Optional[str] = None
	master_calendar_item_id: Optional[str] = None
	patient_id: Optional[str] = None
	important: Optional[bool] = None
	home_visit: Optional[bool] = None
	phone_number: Optional[str] = None
	place_id: Optional[str] = None
	address: Optional['EncryptedAddress'] = None
	address_text: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	confirmation_time: Optional[int] = None
	cancellation_timestamp: Optional[int] = None
	confirmation_id: Optional[str] = None
	duration: Optional[int] = None
	all_day: Optional[bool] = None
	details: Optional[str] = None
	was_migrated: Optional[bool] = None
	agenda_id: Optional[str] = None
	hcp_id: Optional[str] = None
	recurrence_id: Optional[str] = None
	meeting_tags: List['CalendarItemTag'] = field(default_factory=list)
	flow_item: Optional['FlowItem'] = None
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"title": self.title,
			"calendarItemTypeId": self.calendar_item_type_id,
			"masterCalendarItemId": self.master_calendar_item_id,
			"patientId": self.patient_id,
			"important": self.important,
			"homeVisit": self.home_visit,
			"phoneNumber": self.phone_number,
			"placeId": self.place_id,
			"address": self.address.__serialize__() if self.address is not None else None,
			"addressText": self.address_text,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"confirmationTime": self.confirmation_time,
			"cancellationTimestamp": self.cancellation_timestamp,
			"confirmationId": self.confirmation_id,
			"duration": self.duration,
			"allDay": self.all_day,
			"details": self.details,
			"wasMigrated": self.was_migrated,
			"agendaId": self.agenda_id,
			"hcpId": self.hcp_id,
			"recurrenceId": self.recurrence_id,
			"meetingTags": [x0.__serialize__() for x0 in self.meeting_tags],
			"flowItem": self.flow_item.__serialize__() if self.flow_item is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedCalendarItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			title = deserialized_dict.get("title"),
			calendar_item_type_id = deserialized_dict.get("calendarItemTypeId"),
			master_calendar_item_id = deserialized_dict.get("masterCalendarItemId"),
			patient_id = deserialized_dict.get("patientId"),
			important = deserialized_dict.get("important"),
			home_visit = deserialized_dict.get("homeVisit"),
			phone_number = deserialized_dict.get("phoneNumber"),
			place_id = deserialized_dict.get("placeId"),
			address = EncryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
			address_text = deserialized_dict.get("addressText"),
			start_time = deserialized_dict.get("startTime"),
			end_time = deserialized_dict.get("endTime"),
			confirmation_time = deserialized_dict.get("confirmationTime"),
			cancellation_timestamp = deserialized_dict.get("cancellationTimestamp"),
			confirmation_id = deserialized_dict.get("confirmationId"),
			duration = deserialized_dict.get("duration"),
			all_day = deserialized_dict.get("allDay"),
			details = deserialized_dict.get("details"),
			was_migrated = deserialized_dict.get("wasMigrated"),
			agenda_id = deserialized_dict.get("agendaId"),
			hcp_id = deserialized_dict.get("hcpId"),
			recurrence_id = deserialized_dict.get("recurrenceId"),
			meeting_tags = [CalendarItemTag._deserialize(x0) for x0 in deserialized_dict["meetingTags"]],
			flow_item = FlowItem._deserialize(deserialized_dict.get("flowItem")) if deserialized_dict.get("flowItem") is not None else None,
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

__all__ = ['CalendarItem','serialize_calendar_item','deserialize_calendar_item','DecryptedCalendarItem','EncryptedCalendarItem']