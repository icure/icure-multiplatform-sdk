import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class FlowItem:
	id: Optional[str] = None
	title: Optional[str] = None
	comment: Optional[str] = None
	reception_date: Optional[int] = None
	processing_date: Optional[int] = None
	processer: Optional[str] = None
	cancellation_date: Optional[int] = None
	canceller: Optional[str] = None
	cancellation_reason: Optional[str] = None
	cancellation_note: Optional[str] = None
	status: Optional[str] = None
	home_visit: Optional[bool] = None
	municipality: Optional[str] = None
	town: Optional[str] = None
	zip_code: Optional[str] = None
	street: Optional[str] = None
	building: Optional[str] = None
	building_number: Optional[str] = None
	doorbell_name: Optional[str] = None
	floor: Optional[str] = None
	letter_box: Optional[str] = None
	notes_ops: Optional[str] = None
	notes_contact: Optional[str] = None
	latitude: Optional[str] = None
	longitude: Optional[str] = None
	type: Optional[str] = None
	emergency: Optional[bool] = None
	phone_number: Optional[str] = None
	patient_id: Optional[str] = None
	patient_last_name: Optional[str] = None
	patient_first_name: Optional[str] = None
	description: Optional[str] = None
	intervention_code: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"title": self.title,
			"comment": self.comment,
			"receptionDate": self.reception_date,
			"processingDate": self.processing_date,
			"processer": self.processer,
			"cancellationDate": self.cancellation_date,
			"canceller": self.canceller,
			"cancellationReason": self.cancellation_reason,
			"cancellationNote": self.cancellation_note,
			"status": self.status,
			"homeVisit": self.home_visit,
			"municipality": self.municipality,
			"town": self.town,
			"zipCode": self.zip_code,
			"street": self.street,
			"building": self.building,
			"buildingNumber": self.building_number,
			"doorbellName": self.doorbell_name,
			"floor": self.floor,
			"letterBox": self.letter_box,
			"notesOps": self.notes_ops,
			"notesContact": self.notes_contact,
			"latitude": self.latitude,
			"longitude": self.longitude,
			"type": self.type,
			"emergency": self.emergency,
			"phoneNumber": self.phone_number,
			"patientId": self.patient_id,
			"patientLastName": self.patient_last_name,
			"patientFirstName": self.patient_first_name,
			"description": self.description,
			"interventionCode": self.intervention_code,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FlowItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict.get("id"),
			title = deserialized_dict.get("title"),
			comment = deserialized_dict.get("comment"),
			reception_date = deserialized_dict.get("receptionDate"),
			processing_date = deserialized_dict.get("processingDate"),
			processer = deserialized_dict.get("processer"),
			cancellation_date = deserialized_dict.get("cancellationDate"),
			canceller = deserialized_dict.get("canceller"),
			cancellation_reason = deserialized_dict.get("cancellationReason"),
			cancellation_note = deserialized_dict.get("cancellationNote"),
			status = deserialized_dict.get("status"),
			home_visit = deserialized_dict.get("homeVisit"),
			municipality = deserialized_dict.get("municipality"),
			town = deserialized_dict.get("town"),
			zip_code = deserialized_dict.get("zipCode"),
			street = deserialized_dict.get("street"),
			building = deserialized_dict.get("building"),
			building_number = deserialized_dict.get("buildingNumber"),
			doorbell_name = deserialized_dict.get("doorbellName"),
			floor = deserialized_dict.get("floor"),
			letter_box = deserialized_dict.get("letterBox"),
			notes_ops = deserialized_dict.get("notesOps"),
			notes_contact = deserialized_dict.get("notesContact"),
			latitude = deserialized_dict.get("latitude"),
			longitude = deserialized_dict.get("longitude"),
			type = deserialized_dict.get("type"),
			emergency = deserialized_dict.get("emergency"),
			phone_number = deserialized_dict.get("phoneNumber"),
			patient_id = deserialized_dict.get("patientId"),
			patient_last_name = deserialized_dict.get("patientLastName"),
			patient_first_name = deserialized_dict.get("patientFirstName"),
			description = deserialized_dict.get("description"),
			intervention_code = deserialized_dict.get("interventionCode"),
		)

__all__ = ['FlowItem']