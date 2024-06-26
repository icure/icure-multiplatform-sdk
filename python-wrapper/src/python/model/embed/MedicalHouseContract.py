import json
from typing import Union, Dict, Optional
from model.embed.ContractChangeType import ContractChangeType
from model.embed.SuspensionReason import SuspensionReason
from model.embed.MhcSignatureType import MhcSignatureType
from dataclasses import field, dataclass
from model.specializations.Base64String import Base64String

MedicalHouseContract = Union['DecryptedMedicalHouseContract', 'EncryptedMedicalHouseContract']

def serialize_medical_house_contract(medical_house_contract: MedicalHouseContract) -> object:
	if instanceof(medical_house_contract, DecryptedMedicalHouseContract):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedMedicalHouseContract",
			"entity": medical_house_contract.__serialize__()
		}
	elif instanceof(medical_house_contract, EncryptedMedicalHouseContract):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedMedicalHouseContract",
			"entity": medical_house_contract.__serialize__()
		}
	else:
		raise Exception(f"{type(medical_house_contract)} is not a known subclass of MedicalHouseContract")

def deserialize_medical_house_contract(data: Union[str, Dict[str, object]]) -> 'MedicalHouseContract':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedMedicalHouseContract":
		DecryptedMedicalHouseContract._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedMedicalHouseContract":
		EncryptedMedicalHouseContract._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of MedicalHouseContract")

@dataclass
class DecryptedMedicalHouseContract:
	contract_id: Optional[str] = None
	valid_from: Optional[int] = None
	valid_to: Optional[int] = None
	mm_nihii: Optional[str] = None
	hcp_id: Optional[str] = None
	change_type: Optional['ContractChangeType'] = None
	parent_contract_id: Optional[str] = None
	changed_by: Optional[str] = None
	start_of_contract: Optional[int] = None
	start_of_coverage: Optional[int] = None
	end_of_contract: Optional[int] = None
	end_of_coverage: Optional[int] = None
	kine: bool = False
	gp: bool = False
	ptd: bool = False
	nurse: bool = False
	no_kine: bool = False
	no_gp: bool = False
	no_nurse: bool = False
	unsubscription_reason_id: Optional[int] = None
	ptd_start: Optional[int] = None
	ptd_end: Optional[int] = None
	ptd_last_invoiced: Optional[int] = None
	start_of_suspension: Optional[int] = None
	end_of_suspension: Optional[int] = None
	suspension_reason: Optional['SuspensionReason'] = None
	suspension_source: Optional[str] = None
	forced_suspension: bool = False
	signature_type: Optional['MhcSignatureType'] = None
	status: Optional[int] = None
	options: Dict[str, str] = field(default_factory=dict)
	receipts: Dict[str, str] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"contractId": self.contract_id,
			"validFrom": self.valid_from,
			"validTo": self.valid_to,
			"mmNihii": self.mm_nihii,
			"hcpId": self.hcp_id,
			"changeType": self.change_type.__serialize__() if self.change_type is not None else None,
			"parentContractId": self.parent_contract_id,
			"changedBy": self.changed_by,
			"startOfContract": self.start_of_contract,
			"startOfCoverage": self.start_of_coverage,
			"endOfContract": self.end_of_contract,
			"endOfCoverage": self.end_of_coverage,
			"kine": self.kine,
			"gp": self.gp,
			"ptd": self.ptd,
			"nurse": self.nurse,
			"noKine": self.no_kine,
			"noGp": self.no_gp,
			"noNurse": self.no_nurse,
			"unsubscriptionReasonId": self.unsubscription_reason_id,
			"ptdStart": self.ptd_start,
			"ptdEnd": self.ptd_end,
			"ptdLastInvoiced": self.ptd_last_invoiced,
			"startOfSuspension": self.start_of_suspension,
			"endOfSuspension": self.end_of_suspension,
			"suspensionReason": self.suspension_reason.__serialize__() if self.suspension_reason is not None else None,
			"suspensionSource": self.suspension_source,
			"forcedSuspension": self.forced_suspension,
			"signatureType": self.signature_type.__serialize__() if self.signature_type is not None else None,
			"status": self.status,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedMedicalHouseContract':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			contract_id = deserialized_dict.get("contractId"),
			valid_from = deserialized_dict.get("validFrom"),
			valid_to = deserialized_dict.get("validTo"),
			mm_nihii = deserialized_dict.get("mmNihii"),
			hcp_id = deserialized_dict.get("hcpId"),
			change_type = ContractChangeType._deserialize(deserialized_dict.get("changeType")) if deserialized_dict.get("changeType") is not None else None,
			parent_contract_id = deserialized_dict.get("parentContractId"),
			changed_by = deserialized_dict.get("changedBy"),
			start_of_contract = deserialized_dict.get("startOfContract"),
			start_of_coverage = deserialized_dict.get("startOfCoverage"),
			end_of_contract = deserialized_dict.get("endOfContract"),
			end_of_coverage = deserialized_dict.get("endOfCoverage"),
			kine = deserialized_dict["kine"],
			gp = deserialized_dict["gp"],
			ptd = deserialized_dict["ptd"],
			nurse = deserialized_dict["nurse"],
			no_kine = deserialized_dict["noKine"],
			no_gp = deserialized_dict["noGp"],
			no_nurse = deserialized_dict["noNurse"],
			unsubscription_reason_id = deserialized_dict.get("unsubscriptionReasonId"),
			ptd_start = deserialized_dict.get("ptdStart"),
			ptd_end = deserialized_dict.get("ptdEnd"),
			ptd_last_invoiced = deserialized_dict.get("ptdLastInvoiced"),
			start_of_suspension = deserialized_dict.get("startOfSuspension"),
			end_of_suspension = deserialized_dict.get("endOfSuspension"),
			suspension_reason = SuspensionReason._deserialize(deserialized_dict.get("suspensionReason")) if deserialized_dict.get("suspensionReason") is not None else None,
			suspension_source = deserialized_dict.get("suspensionSource"),
			forced_suspension = deserialized_dict["forcedSuspension"],
			signature_type = MhcSignatureType._deserialize(deserialized_dict.get("signatureType")) if deserialized_dict.get("signatureType") is not None else None,
			status = deserialized_dict.get("status"),
			options = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			receipts = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedMedicalHouseContract:
	contract_id: Optional[str] = None
	valid_from: Optional[int] = None
	valid_to: Optional[int] = None
	mm_nihii: Optional[str] = None
	hcp_id: Optional[str] = None
	change_type: Optional['ContractChangeType'] = None
	parent_contract_id: Optional[str] = None
	changed_by: Optional[str] = None
	start_of_contract: Optional[int] = None
	start_of_coverage: Optional[int] = None
	end_of_contract: Optional[int] = None
	end_of_coverage: Optional[int] = None
	kine: bool = False
	gp: bool = False
	ptd: bool = False
	nurse: bool = False
	no_kine: bool = False
	no_gp: bool = False
	no_nurse: bool = False
	unsubscription_reason_id: Optional[int] = None
	ptd_start: Optional[int] = None
	ptd_end: Optional[int] = None
	ptd_last_invoiced: Optional[int] = None
	start_of_suspension: Optional[int] = None
	end_of_suspension: Optional[int] = None
	suspension_reason: Optional['SuspensionReason'] = None
	suspension_source: Optional[str] = None
	forced_suspension: bool = False
	signature_type: Optional['MhcSignatureType'] = None
	status: Optional[int] = None
	options: Dict[str, str] = field(default_factory=dict)
	receipts: Dict[str, str] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"contractId": self.contract_id,
			"validFrom": self.valid_from,
			"validTo": self.valid_to,
			"mmNihii": self.mm_nihii,
			"hcpId": self.hcp_id,
			"changeType": self.change_type.__serialize__() if self.change_type is not None else None,
			"parentContractId": self.parent_contract_id,
			"changedBy": self.changed_by,
			"startOfContract": self.start_of_contract,
			"startOfCoverage": self.start_of_coverage,
			"endOfContract": self.end_of_contract,
			"endOfCoverage": self.end_of_coverage,
			"kine": self.kine,
			"gp": self.gp,
			"ptd": self.ptd,
			"nurse": self.nurse,
			"noKine": self.no_kine,
			"noGp": self.no_gp,
			"noNurse": self.no_nurse,
			"unsubscriptionReasonId": self.unsubscription_reason_id,
			"ptdStart": self.ptd_start,
			"ptdEnd": self.ptd_end,
			"ptdLastInvoiced": self.ptd_last_invoiced,
			"startOfSuspension": self.start_of_suspension,
			"endOfSuspension": self.end_of_suspension,
			"suspensionReason": self.suspension_reason.__serialize__() if self.suspension_reason is not None else None,
			"suspensionSource": self.suspension_source,
			"forcedSuspension": self.forced_suspension,
			"signatureType": self.signature_type.__serialize__() if self.signature_type is not None else None,
			"status": self.status,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedMedicalHouseContract':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			contract_id = deserialized_dict.get("contractId"),
			valid_from = deserialized_dict.get("validFrom"),
			valid_to = deserialized_dict.get("validTo"),
			mm_nihii = deserialized_dict.get("mmNihii"),
			hcp_id = deserialized_dict.get("hcpId"),
			change_type = ContractChangeType._deserialize(deserialized_dict.get("changeType")) if deserialized_dict.get("changeType") is not None else None,
			parent_contract_id = deserialized_dict.get("parentContractId"),
			changed_by = deserialized_dict.get("changedBy"),
			start_of_contract = deserialized_dict.get("startOfContract"),
			start_of_coverage = deserialized_dict.get("startOfCoverage"),
			end_of_contract = deserialized_dict.get("endOfContract"),
			end_of_coverage = deserialized_dict.get("endOfCoverage"),
			kine = deserialized_dict["kine"],
			gp = deserialized_dict["gp"],
			ptd = deserialized_dict["ptd"],
			nurse = deserialized_dict["nurse"],
			no_kine = deserialized_dict["noKine"],
			no_gp = deserialized_dict["noGp"],
			no_nurse = deserialized_dict["noNurse"],
			unsubscription_reason_id = deserialized_dict.get("unsubscriptionReasonId"),
			ptd_start = deserialized_dict.get("ptdStart"),
			ptd_end = deserialized_dict.get("ptdEnd"),
			ptd_last_invoiced = deserialized_dict.get("ptdLastInvoiced"),
			start_of_suspension = deserialized_dict.get("startOfSuspension"),
			end_of_suspension = deserialized_dict.get("endOfSuspension"),
			suspension_reason = SuspensionReason._deserialize(deserialized_dict.get("suspensionReason")) if deserialized_dict.get("suspensionReason") is not None else None,
			suspension_source = deserialized_dict.get("suspensionSource"),
			forced_suspension = deserialized_dict["forcedSuspension"],
			signature_type = MhcSignatureType._deserialize(deserialized_dict.get("signatureType")) if deserialized_dict.get("signatureType") is not None else None,
			status = deserialized_dict.get("status"),
			options = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			receipts = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['MedicalHouseContract','serialize_medical_house_contract','deserialize_medical_house_contract','DecryptedMedicalHouseContract','EncryptedMedicalHouseContract']