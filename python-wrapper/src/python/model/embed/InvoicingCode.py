import json
from typing import Union, Dict, Optional
from model.embed.PaymentType import PaymentType
from model.specializations.Base64String import Base64String
from dataclasses import dataclass

InvoicingCode = Union['DecryptedInvoicingCode', 'EncryptedInvoicingCode']

def serialize_invoicing_code(invoicing_code: InvoicingCode) -> object:
	if isinstance(invoicing_code, DecryptedInvoicingCode):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedInvoicingCode",
			"entity": invoicing_code.__serialize__()
		}
	elif isinstance(invoicing_code, EncryptedInvoicingCode):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedInvoicingCode",
			"entity": invoicing_code.__serialize__()
		}
	else:
		raise Exception(f"{type(invoicing_code)} is not a known subclass of InvoicingCode")

def deserialize_invoicing_code(data: Union[str, Dict[str, object]]) -> 'InvoicingCode':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedInvoicingCode":
		DecryptedInvoicingCode._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedInvoicingCode":
		EncryptedInvoicingCode._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of InvoicingCode")

@dataclass
class DecryptedInvoicingCode:
	id: Optional[str]
	date_code: Optional[int] = None
	logical_id: Optional[str] = None
	label: Optional[str] = None
	user_id: Optional[str] = None
	contact_id: Optional[str] = None
	service_id: Optional[str] = None
	tarification_id: Optional[str] = None
	code: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	convention_amount: Optional[float] = None
	vat: Optional[float] = None
	error: Optional[str] = None
	contract: Optional[str] = None
	contract_date: Optional[int] = None
	units: Optional[int] = None
	side: Optional[int] = None
	time_of_day: Optional[int] = None
	eid_reading_hour: Optional[int] = None
	eid_reading_value: Optional[str] = None
	override3rd_payer_code: Optional[int] = None
	override3rd_payer_reason: Optional[str] = None
	transplantation_code: Optional[int] = None
	prescriber_norm: Optional[int] = None
	percent_norm: Optional[int] = None
	prescriber_nihii: Optional[str] = None
	related_code: Optional[str] = None
	prescription_date: Optional[int] = None
	derogation_max_number: Optional[int] = None
	prescriber_ssin: Optional[str] = None
	prescriber_last_name: Optional[str] = None
	prescriber_first_name: Optional[str] = None
	prescriber_cd_hc_party: Optional[str] = None
	location_nihii: Optional[str] = None
	location_cd_hc_party: Optional[str] = None
	location_service: Optional[int] = None
	admission_date: Optional[int] = None
	canceled: Optional[bool] = None
	accepted: Optional[bool] = None
	pending: Optional[bool] = None
	resent: Optional[bool] = None
	archived: Optional[bool] = None
	lost: Optional[bool] = None
	insurance_justification: Optional[int] = None
	cancel_patient_intervention_reason: Optional[int] = None
	status: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"dateCode": self.date_code,
			"logicalId": self.logical_id,
			"label": self.label,
			"userId": self.user_id,
			"contactId": self.contact_id,
			"serviceId": self.service_id,
			"tarificationId": self.tarification_id,
			"code": self.code,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"conventionAmount": self.convention_amount,
			"vat": self.vat,
			"error": self.error,
			"contract": self.contract,
			"contractDate": self.contract_date,
			"units": self.units,
			"side": self.side,
			"timeOfDay": self.time_of_day,
			"eidReadingHour": self.eid_reading_hour,
			"eidReadingValue": self.eid_reading_value,
			"override3rdPayerCode": self.override3rd_payer_code,
			"override3rdPayerReason": self.override3rd_payer_reason,
			"transplantationCode": self.transplantation_code,
			"prescriberNorm": self.prescriber_norm,
			"percentNorm": self.percent_norm,
			"prescriberNihii": self.prescriber_nihii,
			"relatedCode": self.related_code,
			"prescriptionDate": self.prescription_date,
			"derogationMaxNumber": self.derogation_max_number,
			"prescriberSsin": self.prescriber_ssin,
			"prescriberLastName": self.prescriber_last_name,
			"prescriberFirstName": self.prescriber_first_name,
			"prescriberCdHcParty": self.prescriber_cd_hc_party,
			"locationNihii": self.location_nihii,
			"locationCdHcParty": self.location_cd_hc_party,
			"locationService": self.location_service,
			"admissionDate": self.admission_date,
			"canceled": self.canceled,
			"accepted": self.accepted,
			"pending": self.pending,
			"resent": self.resent,
			"archived": self.archived,
			"lost": self.lost,
			"insuranceJustification": self.insurance_justification,
			"cancelPatientInterventionReason": self.cancel_patient_intervention_reason,
			"status": self.status,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedInvoicingCode':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict.get("id"),
			date_code = deserialized_dict.get("dateCode"),
			logical_id = deserialized_dict.get("logicalId"),
			label = deserialized_dict.get("label"),
			user_id = deserialized_dict.get("userId"),
			contact_id = deserialized_dict.get("contactId"),
			service_id = deserialized_dict.get("serviceId"),
			tarification_id = deserialized_dict.get("tarificationId"),
			code = deserialized_dict.get("code"),
			payment_type = PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid = deserialized_dict.get("paid"),
			total_amount = deserialized_dict.get("totalAmount"),
			reimbursement = deserialized_dict.get("reimbursement"),
			patient_intervention = deserialized_dict.get("patientIntervention"),
			doctor_supplement = deserialized_dict.get("doctorSupplement"),
			convention_amount = deserialized_dict.get("conventionAmount"),
			vat = deserialized_dict.get("vat"),
			error = deserialized_dict.get("error"),
			contract = deserialized_dict.get("contract"),
			contract_date = deserialized_dict.get("contractDate"),
			units = deserialized_dict.get("units"),
			side = deserialized_dict.get("side"),
			time_of_day = deserialized_dict.get("timeOfDay"),
			eid_reading_hour = deserialized_dict.get("eidReadingHour"),
			eid_reading_value = deserialized_dict.get("eidReadingValue"),
			override3rd_payer_code = deserialized_dict.get("override3rdPayerCode"),
			override3rd_payer_reason = deserialized_dict.get("override3rdPayerReason"),
			transplantation_code = deserialized_dict.get("transplantationCode"),
			prescriber_norm = deserialized_dict.get("prescriberNorm"),
			percent_norm = deserialized_dict.get("percentNorm"),
			prescriber_nihii = deserialized_dict.get("prescriberNihii"),
			related_code = deserialized_dict.get("relatedCode"),
			prescription_date = deserialized_dict.get("prescriptionDate"),
			derogation_max_number = deserialized_dict.get("derogationMaxNumber"),
			prescriber_ssin = deserialized_dict.get("prescriberSsin"),
			prescriber_last_name = deserialized_dict.get("prescriberLastName"),
			prescriber_first_name = deserialized_dict.get("prescriberFirstName"),
			prescriber_cd_hc_party = deserialized_dict.get("prescriberCdHcParty"),
			location_nihii = deserialized_dict.get("locationNihii"),
			location_cd_hc_party = deserialized_dict.get("locationCdHcParty"),
			location_service = deserialized_dict.get("locationService"),
			admission_date = deserialized_dict.get("admissionDate"),
			canceled = deserialized_dict.get("canceled"),
			accepted = deserialized_dict.get("accepted"),
			pending = deserialized_dict.get("pending"),
			resent = deserialized_dict.get("resent"),
			archived = deserialized_dict.get("archived"),
			lost = deserialized_dict.get("lost"),
			insurance_justification = deserialized_dict.get("insuranceJustification"),
			cancel_patient_intervention_reason = deserialized_dict.get("cancelPatientInterventionReason"),
			status = deserialized_dict.get("status"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedInvoicingCode:
	id: Optional[str]
	date_code: Optional[int] = None
	logical_id: Optional[str] = None
	label: Optional[str] = None
	user_id: Optional[str] = None
	contact_id: Optional[str] = None
	service_id: Optional[str] = None
	tarification_id: Optional[str] = None
	code: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	convention_amount: Optional[float] = None
	vat: Optional[float] = None
	error: Optional[str] = None
	contract: Optional[str] = None
	contract_date: Optional[int] = None
	units: Optional[int] = None
	side: Optional[int] = None
	time_of_day: Optional[int] = None
	eid_reading_hour: Optional[int] = None
	eid_reading_value: Optional[str] = None
	override3rd_payer_code: Optional[int] = None
	override3rd_payer_reason: Optional[str] = None
	transplantation_code: Optional[int] = None
	prescriber_norm: Optional[int] = None
	percent_norm: Optional[int] = None
	prescriber_nihii: Optional[str] = None
	related_code: Optional[str] = None
	prescription_date: Optional[int] = None
	derogation_max_number: Optional[int] = None
	prescriber_ssin: Optional[str] = None
	prescriber_last_name: Optional[str] = None
	prescriber_first_name: Optional[str] = None
	prescriber_cd_hc_party: Optional[str] = None
	location_nihii: Optional[str] = None
	location_cd_hc_party: Optional[str] = None
	location_service: Optional[int] = None
	admission_date: Optional[int] = None
	canceled: Optional[bool] = None
	accepted: Optional[bool] = None
	pending: Optional[bool] = None
	resent: Optional[bool] = None
	archived: Optional[bool] = None
	lost: Optional[bool] = None
	insurance_justification: Optional[int] = None
	cancel_patient_intervention_reason: Optional[int] = None
	status: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"dateCode": self.date_code,
			"logicalId": self.logical_id,
			"label": self.label,
			"userId": self.user_id,
			"contactId": self.contact_id,
			"serviceId": self.service_id,
			"tarificationId": self.tarification_id,
			"code": self.code,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"conventionAmount": self.convention_amount,
			"vat": self.vat,
			"error": self.error,
			"contract": self.contract,
			"contractDate": self.contract_date,
			"units": self.units,
			"side": self.side,
			"timeOfDay": self.time_of_day,
			"eidReadingHour": self.eid_reading_hour,
			"eidReadingValue": self.eid_reading_value,
			"override3rdPayerCode": self.override3rd_payer_code,
			"override3rdPayerReason": self.override3rd_payer_reason,
			"transplantationCode": self.transplantation_code,
			"prescriberNorm": self.prescriber_norm,
			"percentNorm": self.percent_norm,
			"prescriberNihii": self.prescriber_nihii,
			"relatedCode": self.related_code,
			"prescriptionDate": self.prescription_date,
			"derogationMaxNumber": self.derogation_max_number,
			"prescriberSsin": self.prescriber_ssin,
			"prescriberLastName": self.prescriber_last_name,
			"prescriberFirstName": self.prescriber_first_name,
			"prescriberCdHcParty": self.prescriber_cd_hc_party,
			"locationNihii": self.location_nihii,
			"locationCdHcParty": self.location_cd_hc_party,
			"locationService": self.location_service,
			"admissionDate": self.admission_date,
			"canceled": self.canceled,
			"accepted": self.accepted,
			"pending": self.pending,
			"resent": self.resent,
			"archived": self.archived,
			"lost": self.lost,
			"insuranceJustification": self.insurance_justification,
			"cancelPatientInterventionReason": self.cancel_patient_intervention_reason,
			"status": self.status,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedInvoicingCode':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict.get("id"),
			date_code = deserialized_dict.get("dateCode"),
			logical_id = deserialized_dict.get("logicalId"),
			label = deserialized_dict.get("label"),
			user_id = deserialized_dict.get("userId"),
			contact_id = deserialized_dict.get("contactId"),
			service_id = deserialized_dict.get("serviceId"),
			tarification_id = deserialized_dict.get("tarificationId"),
			code = deserialized_dict.get("code"),
			payment_type = PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid = deserialized_dict.get("paid"),
			total_amount = deserialized_dict.get("totalAmount"),
			reimbursement = deserialized_dict.get("reimbursement"),
			patient_intervention = deserialized_dict.get("patientIntervention"),
			doctor_supplement = deserialized_dict.get("doctorSupplement"),
			convention_amount = deserialized_dict.get("conventionAmount"),
			vat = deserialized_dict.get("vat"),
			error = deserialized_dict.get("error"),
			contract = deserialized_dict.get("contract"),
			contract_date = deserialized_dict.get("contractDate"),
			units = deserialized_dict.get("units"),
			side = deserialized_dict.get("side"),
			time_of_day = deserialized_dict.get("timeOfDay"),
			eid_reading_hour = deserialized_dict.get("eidReadingHour"),
			eid_reading_value = deserialized_dict.get("eidReadingValue"),
			override3rd_payer_code = deserialized_dict.get("override3rdPayerCode"),
			override3rd_payer_reason = deserialized_dict.get("override3rdPayerReason"),
			transplantation_code = deserialized_dict.get("transplantationCode"),
			prescriber_norm = deserialized_dict.get("prescriberNorm"),
			percent_norm = deserialized_dict.get("percentNorm"),
			prescriber_nihii = deserialized_dict.get("prescriberNihii"),
			related_code = deserialized_dict.get("relatedCode"),
			prescription_date = deserialized_dict.get("prescriptionDate"),
			derogation_max_number = deserialized_dict.get("derogationMaxNumber"),
			prescriber_ssin = deserialized_dict.get("prescriberSsin"),
			prescriber_last_name = deserialized_dict.get("prescriberLastName"),
			prescriber_first_name = deserialized_dict.get("prescriberFirstName"),
			prescriber_cd_hc_party = deserialized_dict.get("prescriberCdHcParty"),
			location_nihii = deserialized_dict.get("locationNihii"),
			location_cd_hc_party = deserialized_dict.get("locationCdHcParty"),
			location_service = deserialized_dict.get("locationService"),
			admission_date = deserialized_dict.get("admissionDate"),
			canceled = deserialized_dict.get("canceled"),
			accepted = deserialized_dict.get("accepted"),
			pending = deserialized_dict.get("pending"),
			resent = deserialized_dict.get("resent"),
			archived = deserialized_dict.get("archived"),
			lost = deserialized_dict.get("lost"),
			insurance_justification = deserialized_dict.get("insuranceJustification"),
			cancel_patient_intervention_reason = deserialized_dict.get("cancelPatientInterventionReason"),
			status = deserialized_dict.get("status"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['InvoicingCode','serialize_invoicing_code','deserialize_invoicing_code','DecryptedInvoicingCode','EncryptedInvoicingCode']