// auto-generated file
import 'package:cardinal_sdk/model/embed/membership_type.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/care_team_membership.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class CareTeamMembership implements Encryptable {
	abstract int? startDate;
	abstract int? endDate;
	abstract String? careTeamMemberId;
	abstract MembershipType? membershipType;
	@override abstract Base64String? encryptedSelf;

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

class DecryptedCareTeamMembership implements CareTeamMembership {
	@override int? startDate = null;
	@override int? endDate = null;
	@override String? careTeamMemberId = null;
	@override MembershipType? membershipType = null;
	@override Base64String? encryptedSelf = null;
	DecryptedCareTeamMembership({
			int? startDate,
			int? endDate,
			String? careTeamMemberId,
			MembershipType? membershipType,
			Base64String? encryptedSelf
		}) : startDate = startDate ?? null,
		endDate = endDate ?? null,
		careTeamMemberId = careTeamMemberId ?? null,
		membershipType = membershipType ?? null,
		encryptedSelf = encryptedSelf ?? null;

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

class EncryptedCareTeamMembership implements CareTeamMembership {
	@override int? startDate = null;
	@override int? endDate = null;
	@override String? careTeamMemberId = null;
	@override MembershipType? membershipType = null;
	@override Base64String? encryptedSelf = null;
	EncryptedCareTeamMembership({
			int? startDate,
			int? endDate,
			String? careTeamMemberId,
			MembershipType? membershipType,
			Base64String? encryptedSelf
		}) : startDate = startDate ?? null,
		endDate = endDate ?? null,
		careTeamMemberId = careTeamMemberId ?? null,
		membershipType = membershipType ?? null,
		encryptedSelf = encryptedSelf ?? null;

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