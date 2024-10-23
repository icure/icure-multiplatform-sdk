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
	@override int? startDate;
	@override int? endDate;
	@override String? careTeamMemberId;
	@override MembershipType? membershipType;
	@override Base64String? encryptedSelf;
	DecryptedCareTeamMembership({
			this.startDate,
			this.endDate,
			this.careTeamMemberId,
			this.membershipType,
			this.encryptedSelf
		});

	factory DecryptedCareTeamMembership.fromJSON(Map<String, dynamic> data) {
		return DecryptedCareTeamMembership(
			startDate: data["startDate"],
			endDate: data["endDate"],
			careTeamMemberId: data["careTeamMemberId"],
			membershipType: data["membershipType"] == null ? null : MembershipType.fromJSON(data["membershipType"]),
			encryptedSelf: data["encryptedSelf"]
		);
	}

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
}

class EncryptedCareTeamMembership implements CareTeamMembership {
	@override int? startDate;
	@override int? endDate;
	@override String? careTeamMemberId;
	@override MembershipType? membershipType;
	@override Base64String? encryptedSelf;
	EncryptedCareTeamMembership({
			this.startDate,
			this.endDate,
			this.careTeamMemberId,
			this.membershipType,
			this.encryptedSelf
		});

	factory EncryptedCareTeamMembership.fromJSON(Map<String, dynamic> data) {
		return EncryptedCareTeamMembership(
			startDate: data["startDate"],
			endDate: data["endDate"],
			careTeamMemberId: data["careTeamMemberId"],
			membershipType: data["membershipType"] == null ? null : MembershipType.fromJSON(data["membershipType"]),
			encryptedSelf: data["encryptedSelf"]
		);
	}

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
}