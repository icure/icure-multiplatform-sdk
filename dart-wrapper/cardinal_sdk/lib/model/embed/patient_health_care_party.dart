// This file is auto-generated
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
}

class EncryptedPatientHealthCareParty implements PatientHealthCareParty {
	@override  PatientHealthCarePartyType? type;
	@override  String? healthcarePartyId;
	@override  Map<TelecomType, String> sendFormats = {};
	@override  List<ReferralPeriod> referralPeriods = [];
	@override  bool referral = false;
	@override  Base64String? encryptedSelf;

	EncryptedPatientHealthCareParty({
		this.type,
		this.healthcarePartyId,
		this.encryptedSelf,
		Map<TelecomType, String>? sendFormats,
		List<ReferralPeriod>? referralPeriods,
		bool? referral
	}) : sendFormats = sendFormats ?? {},
		referralPeriods = referralPeriods ?? [],
		referral = referral ?? false;

	static Map<String, dynamic> encode(EncryptedPatientHealthCareParty value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : PatientHealthCarePartyType.encode(value.type!),
			"healthcarePartyId" : value.healthcarePartyId,
			"sendFormats" : value.sendFormats.map((k0, v0) => MapEntry(TelecomType.encode(k0), v0)),
			"referralPeriods" : value.referralPeriods.map((x0) => ReferralPeriod.encode(x0)),
			"referral" : value.referral,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedPatientHealthCareParty implements PatientHealthCareParty {
	@override  PatientHealthCarePartyType? type;
	@override  String? healthcarePartyId;
	@override  Map<TelecomType, String> sendFormats = {};
	@override  List<ReferralPeriod> referralPeriods = [];
	@override  bool referral = false;
	@override  Base64String? encryptedSelf;

	DecryptedPatientHealthCareParty({
		this.type,
		this.healthcarePartyId,
		this.encryptedSelf,
		Map<TelecomType, String>? sendFormats,
		List<ReferralPeriod>? referralPeriods,
		bool? referral
	}) : sendFormats = sendFormats ?? {},
		referralPeriods = referralPeriods ?? [],
		referral = referral ?? false;

	static Map<String, dynamic> encode(DecryptedPatientHealthCareParty value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : PatientHealthCarePartyType.encode(value.type!),
			"healthcarePartyId" : value.healthcarePartyId,
			"sendFormats" : value.sendFormats.map((k0, v0) => MapEntry(TelecomType.encode(k0), v0)),
			"referralPeriods" : value.referralPeriods.map((x0) => ReferralPeriod.encode(x0)),
			"referral" : value.referral,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}