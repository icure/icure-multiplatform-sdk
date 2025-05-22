// auto-generated file
import 'package:cardinal_sdk/model/embed/care_team_member_type.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/care_team_member.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "care_team_member.freezed.dart";


sealed class CareTeamMember implements Encryptable, Identifiable<String> {
	@override abstract final String id;
	abstract final CareTeamMemberType? careTeamMemberType;
	abstract final String? healthcarePartyId;
	abstract final CodeStub? quality;
	@override abstract final Base64String? encryptedSelf;

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

	static CareTeamMember fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember":
				return EncryptedCareTeamMember.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember":
				return DecryptedCareTeamMember.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedCareTeamMember with _$EncryptedCareTeamMember implements CareTeamMember {
	const factory EncryptedCareTeamMember({
		required String id,
		@Default(null) CareTeamMemberType? careTeamMemberType,
		@Default(null) String? healthcarePartyId,
		@Default(null) CodeStub? quality,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedCareTeamMember;


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

	static EncryptedCareTeamMember fromJSON(Map<String, dynamic> data) {
		return EncryptedCareTeamMember(
			id: (data["id"] as String),
			careTeamMemberType: data["careTeamMemberType"] == null ? null : CareTeamMemberType.fromJSON(data["careTeamMemberType"]),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			quality: data["quality"] == null ? null : CodeStub.fromJSON(data["quality"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}

@freezed
abstract class DecryptedCareTeamMember with _$DecryptedCareTeamMember implements CareTeamMember {
	const factory DecryptedCareTeamMember({
		required String id,
		@Default(null) CareTeamMemberType? careTeamMemberType,
		@Default(null) String? healthcarePartyId,
		@Default(null) CodeStub? quality,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedCareTeamMember;


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

	static DecryptedCareTeamMember fromJSON(Map<String, dynamic> data) {
		return DecryptedCareTeamMember(
			id: (data["id"] as String),
			careTeamMemberType: data["careTeamMemberType"] == null ? null : CareTeamMemberType.fromJSON(data["careTeamMemberType"]),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			quality: data["quality"] == null ? null : CodeStub.fromJSON(data["quality"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}