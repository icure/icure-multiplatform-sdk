import json
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.InvoicingCode import DecryptedInvoicingCode, EncryptedInvoicingCode
from model.embed.InvoiceType import InvoiceType
from model.embed.MediumType import MediumType
from model.embed.InvoiceInterventionType import InvoiceInterventionType
from model.embed.PaymentType import PaymentType
from model.embed.Payment import Payment
from model.embed.IdentityDocumentReader import IdentityDocumentReader
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata

Invoice = Union['DecryptedInvoice', 'EncryptedInvoice']

def serialize_invoice(invoice: Invoice) -> object:
	if isinstance(invoice, DecryptedInvoice):
		return {
			"type": "com.icure.sdk.model.DecryptedInvoice",
			"entity": invoice.__serialize__()
		}
	elif isinstance(invoice, EncryptedInvoice):
		return {
			"type": "com.icure.sdk.model.EncryptedInvoice",
			"entity": invoice.__serialize__()
		}
	else:
		raise Exception(f"{type(invoice)} is not a known subclass of Invoice")

def deserialize_invoice(data: Union[str, Dict[str, object]]) -> 'Invoice':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedInvoice":
		DecryptedInvoice._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedInvoice":
		EncryptedInvoice._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Invoice")

@dataclass
class DecryptedInvoice:
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
	invoice_date: Optional[int] = None
	sent_date: Optional[int] = None
	printed_date: Optional[int] = None
	invoicing_codes: List['DecryptedInvoicingCode'] = field(default_factory=list)
	receipts: Dict[str, str] = field(default_factory=dict)
	recipient_type: Optional[str] = None
	recipient_id: Optional[str] = None
	invoice_reference: Optional[str] = None
	third_party_reference: Optional[str] = None
	third_party_payment_justification: Optional[str] = None
	third_party_payment_reason: Optional[str] = None
	reason: Optional[str] = None
	invoice_type: Optional['InvoiceType'] = None
	sent_medium_type: Optional['MediumType'] = None
	intervention_type: Optional['InvoiceInterventionType'] = None
	group_id: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	payments: Optional[List['Payment']] = None
	gnotion_nihii: Optional[str] = None
	gnotion_ssin: Optional[str] = None
	gnotion_last_name: Optional[str] = None
	gnotion_first_name: Optional[str] = None
	gnotion_cd_hc_party: Optional[str] = None
	invoice_period: Optional[int] = None
	care_provider_type: Optional[str] = None
	internship_nihii: Optional[str] = None
	internship_ssin: Optional[str] = None
	internship_last_name: Optional[str] = None
	internship_first_name: Optional[str] = None
	internship_cd_hc_party: Optional[str] = None
	internship_cbe: Optional[str] = None
	supervisor_nihii: Optional[str] = None
	supervisor_ssin: Optional[str] = None
	supervisor_last_name: Optional[str] = None
	supervisor_first_name: Optional[str] = None
	supervisor_cd_hc_party: Optional[str] = None
	supervisor_cbe: Optional[str] = None
	error: Optional[str] = None
	encounter_location_name: Optional[str] = None
	encounter_location_nihii: Optional[str] = None
	encounter_location_norm: Optional[int] = None
	long_delay_justification: Optional[int] = None
	corrective_invoice_id: Optional[str] = None
	corrected_invoice_id: Optional[str] = None
	credit_note: Optional[bool] = None
	credit_note_related_invoice_id: Optional[str] = None
	id_document: Optional['IdentityDocumentReader'] = None
	admission_date: Optional[int] = None
	location_nihii: Optional[str] = None
	location_service: Optional[int] = None
	cancel_reason: Optional[str] = None
	cancel_date: Optional[int] = None
	options: Dict[str, str] = field(default_factory=dict)
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
			"invoiceDate": self.invoice_date,
			"sentDate": self.sent_date,
			"printedDate": self.printed_date,
			"invoicingCodes": [x0.__serialize__() for x0 in self.invoicing_codes],
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"recipientType": self.recipient_type,
			"recipientId": self.recipient_id,
			"invoiceReference": self.invoice_reference,
			"thirdPartyReference": self.third_party_reference,
			"thirdPartyPaymentJustification": self.third_party_payment_justification,
			"thirdPartyPaymentReason": self.third_party_payment_reason,
			"reason": self.reason,
			"invoiceType": self.invoice_type.__serialize__() if self.invoice_type is not None else None,
			"sentMediumType": self.sent_medium_type.__serialize__() if self.sent_medium_type is not None else None,
			"interventionType": self.intervention_type.__serialize__() if self.intervention_type is not None else None,
			"groupId": self.group_id,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"payments": [x0.__serialize__() for x0 in self.payments] if self.payments is not None else None,
			"gnotionNihii": self.gnotion_nihii,
			"gnotionSsin": self.gnotion_ssin,
			"gnotionLastName": self.gnotion_last_name,
			"gnotionFirstName": self.gnotion_first_name,
			"gnotionCdHcParty": self.gnotion_cd_hc_party,
			"invoicePeriod": self.invoice_period,
			"careProviderType": self.care_provider_type,
			"internshipNihii": self.internship_nihii,
			"internshipSsin": self.internship_ssin,
			"internshipLastName": self.internship_last_name,
			"internshipFirstName": self.internship_first_name,
			"internshipCdHcParty": self.internship_cd_hc_party,
			"internshipCbe": self.internship_cbe,
			"supervisorNihii": self.supervisor_nihii,
			"supervisorSsin": self.supervisor_ssin,
			"supervisorLastName": self.supervisor_last_name,
			"supervisorFirstName": self.supervisor_first_name,
			"supervisorCdHcParty": self.supervisor_cd_hc_party,
			"supervisorCbe": self.supervisor_cbe,
			"error": self.error,
			"encounterLocationName": self.encounter_location_name,
			"encounterLocationNihii": self.encounter_location_nihii,
			"encounterLocationNorm": self.encounter_location_norm,
			"longDelayJustification": self.long_delay_justification,
			"correctiveInvoiceId": self.corrective_invoice_id,
			"correctedInvoiceId": self.corrected_invoice_id,
			"creditNote": self.credit_note,
			"creditNoteRelatedInvoiceId": self.credit_note_related_invoice_id,
			"idDocument": self.id_document.__serialize__() if self.id_document is not None else None,
			"admissionDate": self.admission_date,
			"locationNihii": self.location_nihii,
			"locationService": self.location_service,
			"cancelReason": self.cancel_reason,
			"cancelDate": self.cancel_date,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedInvoice':
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
			invoice_date = deserialized_dict.get("invoiceDate"),
			sent_date = deserialized_dict.get("sentDate"),
			printed_date = deserialized_dict.get("printedDate"),
			invoicing_codes = [DecryptedInvoicingCode._deserialize(x0) for x0 in deserialized_dict["invoicingCodes"]],
			receipts = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			recipient_type = deserialized_dict.get("recipientType"),
			recipient_id = deserialized_dict.get("recipientId"),
			invoice_reference = deserialized_dict.get("invoiceReference"),
			third_party_reference = deserialized_dict.get("thirdPartyReference"),
			third_party_payment_justification = deserialized_dict.get("thirdPartyPaymentJustification"),
			third_party_payment_reason = deserialized_dict.get("thirdPartyPaymentReason"),
			reason = deserialized_dict.get("reason"),
			invoice_type = InvoiceType._deserialize(deserialized_dict.get("invoiceType")) if deserialized_dict.get("invoiceType") is not None else None,
			sent_medium_type = MediumType._deserialize(deserialized_dict.get("sentMediumType")) if deserialized_dict.get("sentMediumType") is not None else None,
			intervention_type = InvoiceInterventionType._deserialize(deserialized_dict.get("interventionType")) if deserialized_dict.get("interventionType") is not None else None,
			group_id = deserialized_dict.get("groupId"),
			payment_type = PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid = deserialized_dict.get("paid"),
			payments = [Payment._deserialize(x0) for x0 in deserialized_dict.get("payments")] if deserialized_dict.get("payments") is not None else None,
			gnotion_nihii = deserialized_dict.get("gnotionNihii"),
			gnotion_ssin = deserialized_dict.get("gnotionSsin"),
			gnotion_last_name = deserialized_dict.get("gnotionLastName"),
			gnotion_first_name = deserialized_dict.get("gnotionFirstName"),
			gnotion_cd_hc_party = deserialized_dict.get("gnotionCdHcParty"),
			invoice_period = deserialized_dict.get("invoicePeriod"),
			care_provider_type = deserialized_dict.get("careProviderType"),
			internship_nihii = deserialized_dict.get("internshipNihii"),
			internship_ssin = deserialized_dict.get("internshipSsin"),
			internship_last_name = deserialized_dict.get("internshipLastName"),
			internship_first_name = deserialized_dict.get("internshipFirstName"),
			internship_cd_hc_party = deserialized_dict.get("internshipCdHcParty"),
			internship_cbe = deserialized_dict.get("internshipCbe"),
			supervisor_nihii = deserialized_dict.get("supervisorNihii"),
			supervisor_ssin = deserialized_dict.get("supervisorSsin"),
			supervisor_last_name = deserialized_dict.get("supervisorLastName"),
			supervisor_first_name = deserialized_dict.get("supervisorFirstName"),
			supervisor_cd_hc_party = deserialized_dict.get("supervisorCdHcParty"),
			supervisor_cbe = deserialized_dict.get("supervisorCbe"),
			error = deserialized_dict.get("error"),
			encounter_location_name = deserialized_dict.get("encounterLocationName"),
			encounter_location_nihii = deserialized_dict.get("encounterLocationNihii"),
			encounter_location_norm = deserialized_dict.get("encounterLocationNorm"),
			long_delay_justification = deserialized_dict.get("longDelayJustification"),
			corrective_invoice_id = deserialized_dict.get("correctiveInvoiceId"),
			corrected_invoice_id = deserialized_dict.get("correctedInvoiceId"),
			credit_note = deserialized_dict.get("creditNote"),
			credit_note_related_invoice_id = deserialized_dict.get("creditNoteRelatedInvoiceId"),
			id_document = IdentityDocumentReader._deserialize(deserialized_dict.get("idDocument")) if deserialized_dict.get("idDocument") is not None else None,
			admission_date = deserialized_dict.get("admissionDate"),
			location_nihii = deserialized_dict.get("locationNihii"),
			location_service = deserialized_dict.get("locationService"),
			cancel_reason = deserialized_dict.get("cancelReason"),
			cancel_date = deserialized_dict.get("cancelDate"),
			options = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedInvoice:
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
	invoice_date: Optional[int] = None
	sent_date: Optional[int] = None
	printed_date: Optional[int] = None
	invoicing_codes: List['EncryptedInvoicingCode'] = field(default_factory=list)
	receipts: Dict[str, str] = field(default_factory=dict)
	recipient_type: Optional[str] = None
	recipient_id: Optional[str] = None
	invoice_reference: Optional[str] = None
	third_party_reference: Optional[str] = None
	third_party_payment_justification: Optional[str] = None
	third_party_payment_reason: Optional[str] = None
	reason: Optional[str] = None
	invoice_type: Optional['InvoiceType'] = None
	sent_medium_type: Optional['MediumType'] = None
	intervention_type: Optional['InvoiceInterventionType'] = None
	group_id: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	payments: Optional[List['Payment']] = None
	gnotion_nihii: Optional[str] = None
	gnotion_ssin: Optional[str] = None
	gnotion_last_name: Optional[str] = None
	gnotion_first_name: Optional[str] = None
	gnotion_cd_hc_party: Optional[str] = None
	invoice_period: Optional[int] = None
	care_provider_type: Optional[str] = None
	internship_nihii: Optional[str] = None
	internship_ssin: Optional[str] = None
	internship_last_name: Optional[str] = None
	internship_first_name: Optional[str] = None
	internship_cd_hc_party: Optional[str] = None
	internship_cbe: Optional[str] = None
	supervisor_nihii: Optional[str] = None
	supervisor_ssin: Optional[str] = None
	supervisor_last_name: Optional[str] = None
	supervisor_first_name: Optional[str] = None
	supervisor_cd_hc_party: Optional[str] = None
	supervisor_cbe: Optional[str] = None
	error: Optional[str] = None
	encounter_location_name: Optional[str] = None
	encounter_location_nihii: Optional[str] = None
	encounter_location_norm: Optional[int] = None
	long_delay_justification: Optional[int] = None
	corrective_invoice_id: Optional[str] = None
	corrected_invoice_id: Optional[str] = None
	credit_note: Optional[bool] = None
	credit_note_related_invoice_id: Optional[str] = None
	id_document: Optional['IdentityDocumentReader'] = None
	admission_date: Optional[int] = None
	location_nihii: Optional[str] = None
	location_service: Optional[int] = None
	cancel_reason: Optional[str] = None
	cancel_date: Optional[int] = None
	options: Dict[str, str] = field(default_factory=dict)
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
			"invoiceDate": self.invoice_date,
			"sentDate": self.sent_date,
			"printedDate": self.printed_date,
			"invoicingCodes": [x0.__serialize__() for x0 in self.invoicing_codes],
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"recipientType": self.recipient_type,
			"recipientId": self.recipient_id,
			"invoiceReference": self.invoice_reference,
			"thirdPartyReference": self.third_party_reference,
			"thirdPartyPaymentJustification": self.third_party_payment_justification,
			"thirdPartyPaymentReason": self.third_party_payment_reason,
			"reason": self.reason,
			"invoiceType": self.invoice_type.__serialize__() if self.invoice_type is not None else None,
			"sentMediumType": self.sent_medium_type.__serialize__() if self.sent_medium_type is not None else None,
			"interventionType": self.intervention_type.__serialize__() if self.intervention_type is not None else None,
			"groupId": self.group_id,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"payments": [x0.__serialize__() for x0 in self.payments] if self.payments is not None else None,
			"gnotionNihii": self.gnotion_nihii,
			"gnotionSsin": self.gnotion_ssin,
			"gnotionLastName": self.gnotion_last_name,
			"gnotionFirstName": self.gnotion_first_name,
			"gnotionCdHcParty": self.gnotion_cd_hc_party,
			"invoicePeriod": self.invoice_period,
			"careProviderType": self.care_provider_type,
			"internshipNihii": self.internship_nihii,
			"internshipSsin": self.internship_ssin,
			"internshipLastName": self.internship_last_name,
			"internshipFirstName": self.internship_first_name,
			"internshipCdHcParty": self.internship_cd_hc_party,
			"internshipCbe": self.internship_cbe,
			"supervisorNihii": self.supervisor_nihii,
			"supervisorSsin": self.supervisor_ssin,
			"supervisorLastName": self.supervisor_last_name,
			"supervisorFirstName": self.supervisor_first_name,
			"supervisorCdHcParty": self.supervisor_cd_hc_party,
			"supervisorCbe": self.supervisor_cbe,
			"error": self.error,
			"encounterLocationName": self.encounter_location_name,
			"encounterLocationNihii": self.encounter_location_nihii,
			"encounterLocationNorm": self.encounter_location_norm,
			"longDelayJustification": self.long_delay_justification,
			"correctiveInvoiceId": self.corrective_invoice_id,
			"correctedInvoiceId": self.corrected_invoice_id,
			"creditNote": self.credit_note,
			"creditNoteRelatedInvoiceId": self.credit_note_related_invoice_id,
			"idDocument": self.id_document.__serialize__() if self.id_document is not None else None,
			"admissionDate": self.admission_date,
			"locationNihii": self.location_nihii,
			"locationService": self.location_service,
			"cancelReason": self.cancel_reason,
			"cancelDate": self.cancel_date,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedInvoice':
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
			invoice_date = deserialized_dict.get("invoiceDate"),
			sent_date = deserialized_dict.get("sentDate"),
			printed_date = deserialized_dict.get("printedDate"),
			invoicing_codes = [EncryptedInvoicingCode._deserialize(x0) for x0 in deserialized_dict["invoicingCodes"]],
			receipts = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			recipient_type = deserialized_dict.get("recipientType"),
			recipient_id = deserialized_dict.get("recipientId"),
			invoice_reference = deserialized_dict.get("invoiceReference"),
			third_party_reference = deserialized_dict.get("thirdPartyReference"),
			third_party_payment_justification = deserialized_dict.get("thirdPartyPaymentJustification"),
			third_party_payment_reason = deserialized_dict.get("thirdPartyPaymentReason"),
			reason = deserialized_dict.get("reason"),
			invoice_type = InvoiceType._deserialize(deserialized_dict.get("invoiceType")) if deserialized_dict.get("invoiceType") is not None else None,
			sent_medium_type = MediumType._deserialize(deserialized_dict.get("sentMediumType")) if deserialized_dict.get("sentMediumType") is not None else None,
			intervention_type = InvoiceInterventionType._deserialize(deserialized_dict.get("interventionType")) if deserialized_dict.get("interventionType") is not None else None,
			group_id = deserialized_dict.get("groupId"),
			payment_type = PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid = deserialized_dict.get("paid"),
			payments = [Payment._deserialize(x0) for x0 in deserialized_dict.get("payments")] if deserialized_dict.get("payments") is not None else None,
			gnotion_nihii = deserialized_dict.get("gnotionNihii"),
			gnotion_ssin = deserialized_dict.get("gnotionSsin"),
			gnotion_last_name = deserialized_dict.get("gnotionLastName"),
			gnotion_first_name = deserialized_dict.get("gnotionFirstName"),
			gnotion_cd_hc_party = deserialized_dict.get("gnotionCdHcParty"),
			invoice_period = deserialized_dict.get("invoicePeriod"),
			care_provider_type = deserialized_dict.get("careProviderType"),
			internship_nihii = deserialized_dict.get("internshipNihii"),
			internship_ssin = deserialized_dict.get("internshipSsin"),
			internship_last_name = deserialized_dict.get("internshipLastName"),
			internship_first_name = deserialized_dict.get("internshipFirstName"),
			internship_cd_hc_party = deserialized_dict.get("internshipCdHcParty"),
			internship_cbe = deserialized_dict.get("internshipCbe"),
			supervisor_nihii = deserialized_dict.get("supervisorNihii"),
			supervisor_ssin = deserialized_dict.get("supervisorSsin"),
			supervisor_last_name = deserialized_dict.get("supervisorLastName"),
			supervisor_first_name = deserialized_dict.get("supervisorFirstName"),
			supervisor_cd_hc_party = deserialized_dict.get("supervisorCdHcParty"),
			supervisor_cbe = deserialized_dict.get("supervisorCbe"),
			error = deserialized_dict.get("error"),
			encounter_location_name = deserialized_dict.get("encounterLocationName"),
			encounter_location_nihii = deserialized_dict.get("encounterLocationNihii"),
			encounter_location_norm = deserialized_dict.get("encounterLocationNorm"),
			long_delay_justification = deserialized_dict.get("longDelayJustification"),
			corrective_invoice_id = deserialized_dict.get("correctiveInvoiceId"),
			corrected_invoice_id = deserialized_dict.get("correctedInvoiceId"),
			credit_note = deserialized_dict.get("creditNote"),
			credit_note_related_invoice_id = deserialized_dict.get("creditNoteRelatedInvoiceId"),
			id_document = IdentityDocumentReader._deserialize(deserialized_dict.get("idDocument")) if deserialized_dict.get("idDocument") is not None else None,
			admission_date = deserialized_dict.get("admissionDate"),
			location_nihii = deserialized_dict.get("locationNihii"),
			location_service = deserialized_dict.get("locationService"),
			cancel_reason = deserialized_dict.get("cancelReason"),
			cancel_date = deserialized_dict.get("cancelDate"),
			options = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

__all__ = ['Invoice','serialize_invoice','deserialize_invoice','DecryptedInvoice','EncryptedInvoice']