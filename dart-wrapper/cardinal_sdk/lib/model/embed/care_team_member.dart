// This file is auto-generated
import 'package:cardinal_sdk/model/embed/care_team_member_type.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/care_team_member.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';


sealed class CareTeamMember implements Encryptable, Identifiable<String> {
	@override abstract String id;
	abstract CareTeamMemberType? careTeamMemberType;
	abstract String? healthcarePartyId;
	abstract CodeStub? quality;
	@override abstract Base64String? encryptedSelf;


	static Map<String, dynamic> encode(CareTeamMember value) {
		switch (value) {
			case EncryptedCareTeamMember entity:
				Map<String, dynamic> entityJson = EncryptedCareTeamMember.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember";
				return entityJson;
			case DecryptedCareTeamMember entity:
				Map<String, dynamic> entityJson = DecryptedCareTeamMember.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember";
				return entityJson;
		}
	}
}

class EncryptedCareTeamMember implements CareTeamMember {
	@override  String id;
	@override  CareTeamMemberType? careTeamMemberType;
	@override  String? healthcarePartyId;
	@override  CodeStub? quality;
	@override  Base64String? encryptedSelf;

	EncryptedCareTeamMember({
		required this.id,
		this.careTeamMemberType,
		this.healthcarePartyId,
		this.quality,
		this.encryptedSelf
	});

	static Map<String, dynamic> encode(EncryptedCareTeamMember value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"careTeamMemberType" : value.careTeamMemberType == null ? null : CareTeamMemberType.encode(value.careTeamMemberType!),
			"healthcarePartyId" : value.healthcarePartyId,
			"quality" : value.quality == null ? null : CodeStub.encode(value.quality!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedCareTeamMember implements CareTeamMember {
	@override  String id;
	@override  CareTeamMemberType? careTeamMemberType;
	@override  String? healthcarePartyId;
	@override  CodeStub? quality;
	@override  Base64String? encryptedSelf;

	DecryptedCareTeamMember({
		required this.id,
		this.careTeamMemberType,
		this.healthcarePartyId,
		this.quality,
		this.encryptedSelf
	});

	static Map<String, dynamic> encode(DecryptedCareTeamMember value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"careTeamMemberType" : value.careTeamMemberType == null ? null : CareTeamMemberType.encode(value.careTeamMemberType!),
			"healthcarePartyId" : value.healthcarePartyId,
			"quality" : value.quality == null ? null : CodeStub.encode(value.quality!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}