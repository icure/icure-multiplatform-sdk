import json
from typing import Optional, Dict, List, Union
from model.embed.AgreementAppendix import AgreementAppendix
from dataclasses import dataclass

@dataclass
class ParagraphAgreement:
	timestamp: Optional[int] = None
	paragraph: Optional[str] = None
	accepted: Optional[bool] = None
	in_treatment: Optional[bool] = None
	canceled: Optional[bool] = None
	care_provider_reference: Optional[str] = None
	decision_reference: Optional[str] = None
	start: Optional[int] = None
	end: Optional[int] = None
	cancelation_date: Optional[int] = None
	quantity_value: Optional[float] = None
	quantity_unit: Optional[str] = None
	io_request_reference: Optional[str] = None
	response_type: Optional[str] = None
	refusal_justification: Optional[Dict[str, str]] = None
	verses: Optional[List[int]] = None
	coverage_type: Optional[str] = None
	unit_number: Optional[float] = None
	strength: Optional[float] = None
	strength_unit: Optional[str] = None
	agreement_appendices: Optional[List['AgreementAppendix']] = None
	document_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"timestamp": self.timestamp,
			"paragraph": self.paragraph,
			"accepted": self.accepted,
			"inTreatment": self.in_treatment,
			"canceled": self.canceled,
			"careProviderReference": self.care_provider_reference,
			"decisionReference": self.decision_reference,
			"start": self.start,
			"end": self.end,
			"cancelationDate": self.cancelation_date,
			"quantityValue": self.quantity_value,
			"quantityUnit": self.quantity_unit,
			"ioRequestReference": self.io_request_reference,
			"responseType": self.response_type,
			"refusalJustification": {k0: v0 for k0, v0 in self.refusal_justification.items()} if self.refusal_justification is not None else None,
			"verses": [x0 for x0 in self.verses] if self.verses is not None else None,
			"coverageType": self.coverage_type,
			"unitNumber": self.unit_number,
			"strength": self.strength,
			"strengthUnit": self.strength_unit,
			"agreementAppendices": [x0.__serialize__() for x0 in self.agreement_appendices] if self.agreement_appendices is not None else None,
			"documentId": self.document_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ParagraphAgreement':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			timestamp = deserialized_dict.get("timestamp"),
			paragraph = deserialized_dict.get("paragraph"),
			accepted = deserialized_dict.get("accepted"),
			in_treatment = deserialized_dict.get("inTreatment"),
			canceled = deserialized_dict.get("canceled"),
			care_provider_reference = deserialized_dict.get("careProviderReference"),
			decision_reference = deserialized_dict.get("decisionReference"),
			start = deserialized_dict.get("start"),
			end = deserialized_dict.get("end"),
			cancelation_date = deserialized_dict.get("cancelationDate"),
			quantity_value = deserialized_dict.get("quantityValue"),
			quantity_unit = deserialized_dict.get("quantityUnit"),
			io_request_reference = deserialized_dict.get("ioRequestReference"),
			response_type = deserialized_dict.get("responseType"),
			refusal_justification = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("refusalJustification").items())) if deserialized_dict.get("refusalJustification") is not None else None,
			verses = [x0 for x0 in deserialized_dict.get("verses")] if deserialized_dict.get("verses") is not None else None,
			coverage_type = deserialized_dict.get("coverageType"),
			unit_number = deserialized_dict.get("unitNumber"),
			strength = deserialized_dict.get("strength"),
			strength_unit = deserialized_dict.get("strengthUnit"),
			agreement_appendices = [AgreementAppendix._deserialize(x0) for x0 in deserialized_dict.get("agreementAppendices")] if deserialized_dict.get("agreementAppendices") is not None else None,
			document_id = deserialized_dict.get("documentId"),
		)

__all__ = ['ParagraphAgreement']