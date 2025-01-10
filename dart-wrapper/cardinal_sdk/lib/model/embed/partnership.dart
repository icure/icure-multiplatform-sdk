// auto-generated file
import 'package:cardinal_sdk/model/embed/partnership_type.dart';
import 'package:cardinal_sdk/model/embed/partnership_status.dart';


class Partnership {
	PartnershipType? type = null;
	PartnershipStatus? status = null;
	String? partnerId = null;
	String? meToOtherRelationshipDescription = null;
	String? otherToMeRelationshipDescription = null;
	Partnership({
			PartnershipType? type,
			PartnershipStatus? status,
			String? partnerId,
			String? meToOtherRelationshipDescription,
			String? otherToMeRelationshipDescription
		}) : type = type ?? null,
		status = status ?? null,
		partnerId = partnerId ?? null,
		meToOtherRelationshipDescription = meToOtherRelationshipDescription ?? null,
		otherToMeRelationshipDescription = otherToMeRelationshipDescription ?? null;

	static Map<String, dynamic> encode(Partnership value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : PartnershipType.encode(value.type!),
			"status" : value.status == null ? null : PartnershipStatus.encode(value.status!),
			"partnerId" : value.partnerId,
			"meToOtherRelationshipDescription" : value.meToOtherRelationshipDescription,
			"otherToMeRelationshipDescription" : value.otherToMeRelationshipDescription
		};
		return entityAsMap;
	}

	static Partnership fromJSON(Map<String, dynamic> data) {
		return Partnership(
			type: data["type"] == null ? null : PartnershipType.fromJSON(data["type"]),
			status: data["status"] == null ? null : PartnershipStatus.fromJSON(data["status"]),
			partnerId: (data["partnerId"] as String?),
			meToOtherRelationshipDescription: (data["meToOtherRelationshipDescription"] as String?),
			otherToMeRelationshipDescription: (data["otherToMeRelationshipDescription"] as String?)
		);
	}
}