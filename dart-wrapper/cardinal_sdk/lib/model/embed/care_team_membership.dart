// auto-generated file
import 'package:cardinal_sdk/model/embed/membership_type.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/care_team_membership.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "care_team_membership.freezed.dart";


sealed class CareTeamMembership implements Encryptable {
	abstract final int? startDate;
	abstract final int? endDate;
	abstract final String? careTeamMemberId;
	abstract final MembershipType? membershipType;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(CareTeamMembership value) {
		switch (value) {
			case DecryptedCareTeamMembership entity:
				Map<String, dynamic> entityJson = DecryptedCareTeamMembership.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership";
				return entityJson;
			case EncryptedCareTeamMembership entity:
				Map<String, dynamic> entityJson = EncryptedCareTeamMembership.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership";
				return entityJson;
		}
	}

	static CareTeamMembership fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership":
				return DecryptedCareTeamMembership.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership":
				return EncryptedCareTeamMembership.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedCareTeamMembership with _$DecryptedCareTeamMembership implements CareTeamMembership {
	const factory DecryptedCareTeamMembership({
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) String? careTeamMemberId,
		@Default(null) MembershipType? membershipType,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedCareTeamMembership;


	static Map<String, dynamic> encode(DecryptedCareTeamMembership value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"careTeamMemberId" : value.careTeamMemberId,
			"membershipType" : value.membershipType == null ? null : MembershipType.encode(value.membershipType!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedCareTeamMembership fromJSON(Map<String, dynamic> data) {
		return DecryptedCareTeamMembership(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			careTeamMemberId: (data["careTeamMemberId"] as String?),
			membershipType: data["membershipType"] == null ? null : MembershipType.fromJSON(data["membershipType"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class EncryptedCareTeamMembership with _$EncryptedCareTeamMembership implements CareTeamMembership {
	const factory EncryptedCareTeamMembership({
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) String? careTeamMemberId,
		@Default(null) MembershipType? membershipType,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedCareTeamMembership;


	static Map<String, dynamic> encode(EncryptedCareTeamMembership value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"careTeamMemberId" : value.careTeamMemberId,
			"membershipType" : value.membershipType == null ? null : MembershipType.encode(value.membershipType!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedCareTeamMembership fromJSON(Map<String, dynamic> data) {
		return EncryptedCareTeamMembership(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			careTeamMemberId: (data["careTeamMemberId"] as String?),
			membershipType: data["membershipType"] == null ? null : MembershipType.fromJSON(data["membershipType"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}