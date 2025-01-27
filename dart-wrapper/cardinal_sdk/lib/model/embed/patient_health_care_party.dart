// auto-generated file
import 'package:cardinal_sdk/model/embed/patient_health_care_party_type.dart';
import 'package:cardinal_sdk/model/embed/telecom_type.dart';
import 'package:cardinal_sdk/model/embed/referral_period.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/patient_health_care_party.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class PatientHealthCareParty implements Encryptable {
	abstract PatientHealthCarePartyType? type;
	abstract String? healthcarePartyId;
	abstract Map<TelecomType, String> sendFormats;
	abstract List<ReferralPeriod> referralPeriods;
	abstract bool referral;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(PatientHealthCareParty value) {
		switch (value) {
			case EncryptedPatientHealthCareParty entity:
				Map<String, dynamic> entityJson = EncryptedPatientHealthCareParty.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty";
				return entityJson;
			case DecryptedPatientHealthCareParty entity:
				Map<String, dynamic> entityJson = DecryptedPatientHealthCareParty.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty";
				return entityJson;
		}
	}

	static PatientHealthCareParty fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty":
				return EncryptedPatientHealthCareParty.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty":
				return DecryptedPatientHealthCareParty.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedPatientHealthCareParty implements PatientHealthCareParty {
	@override PatientHealthCarePartyType? type = null;
	@override String? healthcarePartyId = null;
	@override Map<TelecomType, String> sendFormats = {};
	@override List<ReferralPeriod> referralPeriods = [];
	@override bool referral = false;
	@override Base64String? encryptedSelf = null;
	EncryptedPatientHealthCareParty({
			PatientHealthCarePartyType? type,
			String? healthcarePartyId,
			Map<TelecomType, String>? sendFormats,
			List<ReferralPeriod>? referralPeriods,
			bool? referral,
			Base64String? encryptedSelf
		}) : type = type ?? null,
		healthcarePartyId = healthcarePartyId ?? null,
		sendFormats = sendFormats ?? {},
		referralPeriods = referralPeriods ?? [],
		referral = referral ?? false,
		encryptedSelf = encryptedSelf ?? null;

	static Map<String, dynamic> encode(EncryptedPatientHealthCareParty value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : PatientHealthCarePartyType.encode(value.type!),
			"healthcarePartyId" : value.healthcarePartyId,
			"sendFormats" : value.sendFormats.map((k0, v0) => MapEntry(TelecomType.encode(k0), v0)),
			"referralPeriods" : value.referralPeriods.map((x0) => ReferralPeriod.encode(x0)).toList(),
			"referral" : value.referral,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedPatientHealthCareParty fromJSON(Map<String, dynamic> data) {
		return EncryptedPatientHealthCareParty(
			type: data["type"] == null ? null : PatientHealthCarePartyType.fromJSON(data["type"]),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			sendFormats: (data["sendFormats"] as Map<String, dynamic>).map((k0, v0) => MapEntry(TelecomType.fromJSON(k0), (v0 as String))),
			referralPeriods: (data["referralPeriods"] as List<dynamic>).map((x0) => ReferralPeriod.fromJSON(x0) ).toList(),
			referral: (data["referral"] as bool),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

class DecryptedPatientHealthCareParty implements PatientHealthCareParty {
	@override PatientHealthCarePartyType? type = null;
	@override String? healthcarePartyId = null;
	@override Map<TelecomType, String> sendFormats = {};
	@override List<ReferralPeriod> referralPeriods = [];
	@override bool referral = false;
	@override Base64String? encryptedSelf = null;
	DecryptedPatientHealthCareParty({
			PatientHealthCarePartyType? type,
			String? healthcarePartyId,
			Map<TelecomType, String>? sendFormats,
			List<ReferralPeriod>? referralPeriods,
			bool? referral,
			Base64String? encryptedSelf
		}) : type = type ?? null,
		healthcarePartyId = healthcarePartyId ?? null,
		sendFormats = sendFormats ?? {},
		referralPeriods = referralPeriods ?? [],
		referral = referral ?? false,
		encryptedSelf = encryptedSelf ?? null;

	static Map<String, dynamic> encode(DecryptedPatientHealthCareParty value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : PatientHealthCarePartyType.encode(value.type!),
			"healthcarePartyId" : value.healthcarePartyId,
			"sendFormats" : value.sendFormats.map((k0, v0) => MapEntry(TelecomType.encode(k0), v0)),
			"referralPeriods" : value.referralPeriods.map((x0) => ReferralPeriod.encode(x0)).toList(),
			"referral" : value.referral,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedPatientHealthCareParty fromJSON(Map<String, dynamic> data) {
		return DecryptedPatientHealthCareParty(
			type: data["type"] == null ? null : PatientHealthCarePartyType.fromJSON(data["type"]),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			sendFormats: (data["sendFormats"] as Map<String, dynamic>).map((k0, v0) => MapEntry(TelecomType.fromJSON(k0), (v0 as String))),
			referralPeriods: (data["referralPeriods"] as List<dynamic>).map((x0) => ReferralPeriod.fromJSON(x0) ).toList(),
			referral: (data["referral"] as bool),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}