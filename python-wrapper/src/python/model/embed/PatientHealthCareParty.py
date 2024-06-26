import json
from typing import Union, Dict, Optional, List
from model.embed.PatientHealthCarePartyType import PatientHealthCarePartyType
from model.embed.TelecomType import TelecomType
from dataclasses import field, dataclass
from model.embed.ReferralPeriod import ReferralPeriod
from model.specializations.Base64String import Base64String

PatientHealthCareParty = Union['EncryptedPatientHealthCareParty', 'DecryptedPatientHealthCareParty']

def serialize_patient_health_care_party(patient_health_care_party: PatientHealthCareParty) -> object:
	if instanceof(patient_health_care_party, EncryptedPatientHealthCareParty):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedPatientHealthCareParty",
			"entity": patient_health_care_party.__serialize__()
		}
	elif instanceof(patient_health_care_party, DecryptedPatientHealthCareParty):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedPatientHealthCareParty",
			"entity": patient_health_care_party.__serialize__()
		}
	else:
		raise Exception(f"{type(patient_health_care_party)} is not a known subclass of PatientHealthCareParty")

def deserialize_patient_health_care_party(data: Union[str, Dict[str, object]]) -> 'PatientHealthCareParty':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedPatientHealthCareParty":
		EncryptedPatientHealthCareParty._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedPatientHealthCareParty":
		DecryptedPatientHealthCareParty._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of PatientHealthCareParty")

@dataclass
class EncryptedPatientHealthCareParty:
	type: Optional['PatientHealthCarePartyType'] = None
	healthcare_party_id: Optional[str] = None
	send_formats: Dict['TelecomType', str] = field(default_factory=dict)
	referral_periods: List['ReferralPeriod'] = field(default_factory=list)
	referral: bool = False
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"referralPeriods": [x0.__serialize__() for x0 in self.referral_periods],
			"referral": self.referral,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedPatientHealthCareParty':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type = PatientHealthCarePartyType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			send_formats = dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			referral_periods = [ReferralPeriod._deserialize(x0) for x0 in deserialized_dict["referralPeriods"]],
			referral = deserialized_dict["referral"],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedPatientHealthCareParty:
	type: Optional['PatientHealthCarePartyType'] = None
	healthcare_party_id: Optional[str] = None
	send_formats: Dict['TelecomType', str] = field(default_factory=dict)
	referral_periods: List['ReferralPeriod'] = field(default_factory=list)
	referral: bool = False
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"referralPeriods": [x0.__serialize__() for x0 in self.referral_periods],
			"referral": self.referral,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedPatientHealthCareParty':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type = PatientHealthCarePartyType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			send_formats = dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			referral_periods = [ReferralPeriod._deserialize(x0) for x0 in deserialized_dict["referralPeriods"]],
			referral = deserialized_dict["referral"],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['PatientHealthCareParty','serialize_patient_health_care_party','deserialize_patient_health_care_party','EncryptedPatientHealthCareParty','DecryptedPatientHealthCareParty']