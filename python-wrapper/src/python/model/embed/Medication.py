import json
from typing import Optional, List, Dict, Union
from model.embed.Substanceproduct import Substanceproduct
from model.embed.Medicinalproduct import Medicinalproduct
from model.base.CodeStub import CodeStub
from model.embed.Duration import Duration
from model.embed.Renewal import Renewal
from model.embed.RegimenItem import RegimenItem
from model.embed.ParagraphAgreement import ParagraphAgreement
from model.embed.Suspension import Suspension
from dataclasses import dataclass

@dataclass
class Medication:
	compound_prescription: Optional[str] = None
	substance_product: Optional['Substanceproduct'] = None
	medicinal_product: Optional['Medicinalproduct'] = None
	number_of_packages: Optional[int] = None
	batch: Optional[str] = None
	expiration_date: Optional[int] = None
	instruction_for_patient: Optional[str] = None
	instruction_for_reimbursement: Optional[str] = None
	comment_for_delivery: Optional[str] = None
	drug_route: Optional[str] = None
	temporality: Optional[str] = None
	frequency: Optional['CodeStub'] = None
	reimbursement_reason: Optional['CodeStub'] = None
	substitution_allowed: Optional[bool] = None
	begin_moment: Optional[int] = None
	end_moment: Optional[int] = None
	delivery_moment: Optional[int] = None
	end_execution_moment: Optional[int] = None
	duration: Optional['Duration'] = None
	renewal: Optional['Renewal'] = None
	known_usage: Optional[bool] = None
	regimen: Optional[List['RegimenItem']] = None
	posology: Optional[str] = None
	agreements: Optional[Dict[str, 'ParagraphAgreement']] = None
	medication_scheme_id_on_safe: Optional[str] = None
	medication_scheme_safe_version: Optional[int] = None
	medication_scheme_time_stamp_on_safe: Optional[int] = None
	medication_scheme_document_id: Optional[str] = None
	safe_id_name: Optional[str] = None
	id_on_safes: Optional[str] = None
	timestamp_on_safe: Optional[int] = None
	change_validated: Optional[bool] = None
	new_safe_medication: Optional[bool] = None
	medication_use: Optional[str] = None
	begin_condition: Optional[str] = None
	end_condition: Optional[str] = None
	origin: Optional[str] = None
	medication_changed: Optional[bool] = None
	posology_changed: Optional[bool] = None
	suspension: Optional[List['Suspension']] = None
	prescription_rid: Optional[str] = None
	status: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"compoundPrescription": self.compound_prescription,
			"substanceProduct": self.substance_product.__serialize__() if self.substance_product is not None else None,
			"medicinalProduct": self.medicinal_product.__serialize__() if self.medicinal_product is not None else None,
			"numberOfPackages": self.number_of_packages,
			"batch": self.batch,
			"expirationDate": self.expiration_date,
			"instructionForPatient": self.instruction_for_patient,
			"instructionForReimbursement": self.instruction_for_reimbursement,
			"commentForDelivery": self.comment_for_delivery,
			"drugRoute": self.drug_route,
			"temporality": self.temporality,
			"frequency": self.frequency.__serialize__() if self.frequency is not None else None,
			"reimbursementReason": self.reimbursement_reason.__serialize__() if self.reimbursement_reason is not None else None,
			"substitutionAllowed": self.substitution_allowed,
			"beginMoment": self.begin_moment,
			"endMoment": self.end_moment,
			"deliveryMoment": self.delivery_moment,
			"endExecutionMoment": self.end_execution_moment,
			"duration": self.duration.__serialize__() if self.duration is not None else None,
			"renewal": self.renewal.__serialize__() if self.renewal is not None else None,
			"knownUsage": self.known_usage,
			"regimen": [x0.__serialize__() for x0 in self.regimen] if self.regimen is not None else None,
			"posology": self.posology,
			"agreements": {k0: v0.__serialize__() for k0, v0 in self.agreements.items()} if self.agreements is not None else None,
			"medicationSchemeIdOnSafe": self.medication_scheme_id_on_safe,
			"medicationSchemeSafeVersion": self.medication_scheme_safe_version,
			"medicationSchemeTimeStampOnSafe": self.medication_scheme_time_stamp_on_safe,
			"medicationSchemeDocumentId": self.medication_scheme_document_id,
			"safeIdName": self.safe_id_name,
			"idOnSafes": self.id_on_safes,
			"timestampOnSafe": self.timestamp_on_safe,
			"changeValidated": self.change_validated,
			"newSafeMedication": self.new_safe_medication,
			"medicationUse": self.medication_use,
			"beginCondition": self.begin_condition,
			"endCondition": self.end_condition,
			"origin": self.origin,
			"medicationChanged": self.medication_changed,
			"posologyChanged": self.posology_changed,
			"suspension": [x0.__serialize__() for x0 in self.suspension] if self.suspension is not None else None,
			"prescriptionRID": self.prescription_rid,
			"status": self.status,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Medication':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			compound_prescription = deserialized_dict.get("compoundPrescription"),
			substance_product = Substanceproduct._deserialize(deserialized_dict.get("substanceProduct")) if deserialized_dict.get("substanceProduct") is not None else None,
			medicinal_product = Medicinalproduct._deserialize(deserialized_dict.get("medicinalProduct")) if deserialized_dict.get("medicinalProduct") is not None else None,
			number_of_packages = deserialized_dict.get("numberOfPackages"),
			batch = deserialized_dict.get("batch"),
			expiration_date = deserialized_dict.get("expirationDate"),
			instruction_for_patient = deserialized_dict.get("instructionForPatient"),
			instruction_for_reimbursement = deserialized_dict.get("instructionForReimbursement"),
			comment_for_delivery = deserialized_dict.get("commentForDelivery"),
			drug_route = deserialized_dict.get("drugRoute"),
			temporality = deserialized_dict.get("temporality"),
			frequency = CodeStub._deserialize(deserialized_dict.get("frequency")) if deserialized_dict.get("frequency") is not None else None,
			reimbursement_reason = CodeStub._deserialize(deserialized_dict.get("reimbursementReason")) if deserialized_dict.get("reimbursementReason") is not None else None,
			substitution_allowed = deserialized_dict.get("substitutionAllowed"),
			begin_moment = deserialized_dict.get("beginMoment"),
			end_moment = deserialized_dict.get("endMoment"),
			delivery_moment = deserialized_dict.get("deliveryMoment"),
			end_execution_moment = deserialized_dict.get("endExecutionMoment"),
			duration = Duration._deserialize(deserialized_dict.get("duration")) if deserialized_dict.get("duration") is not None else None,
			renewal = Renewal._deserialize(deserialized_dict.get("renewal")) if deserialized_dict.get("renewal") is not None else None,
			known_usage = deserialized_dict.get("knownUsage"),
			regimen = [RegimenItem._deserialize(x0) for x0 in deserialized_dict.get("regimen")] if deserialized_dict.get("regimen") is not None else None,
			posology = deserialized_dict.get("posology"),
			agreements = dict(map(lambda kv0: (kv0[0], ParagraphAgreement._deserialize(kv0[1])), deserialized_dict.get("agreements").items())) if deserialized_dict.get("agreements") is not None else None,
			medication_scheme_id_on_safe = deserialized_dict.get("medicationSchemeIdOnSafe"),
			medication_scheme_safe_version = deserialized_dict.get("medicationSchemeSafeVersion"),
			medication_scheme_time_stamp_on_safe = deserialized_dict.get("medicationSchemeTimeStampOnSafe"),
			medication_scheme_document_id = deserialized_dict.get("medicationSchemeDocumentId"),
			safe_id_name = deserialized_dict.get("safeIdName"),
			id_on_safes = deserialized_dict.get("idOnSafes"),
			timestamp_on_safe = deserialized_dict.get("timestampOnSafe"),
			change_validated = deserialized_dict.get("changeValidated"),
			new_safe_medication = deserialized_dict.get("newSafeMedication"),
			medication_use = deserialized_dict.get("medicationUse"),
			begin_condition = deserialized_dict.get("beginCondition"),
			end_condition = deserialized_dict.get("endCondition"),
			origin = deserialized_dict.get("origin"),
			medication_changed = deserialized_dict.get("medicationChanged"),
			posology_changed = deserialized_dict.get("posologyChanged"),
			suspension = [Suspension._deserialize(x0) for x0 in deserialized_dict.get("suspension")] if deserialized_dict.get("suspension") is not None else None,
			prescription_rid = deserialized_dict.get("prescriptionRID"),
			status = deserialized_dict.get("status"),
		)

__all__ = ['Medication']