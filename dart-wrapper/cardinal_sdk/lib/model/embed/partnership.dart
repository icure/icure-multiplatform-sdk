// This file is auto-generated
import 'package:cardinal_sdk/model/embed/partnership_type.dart';
import 'package:cardinal_sdk/model/embed/partnership_status.dart';


class Partnership {
	PartnershipType? type;
	PartnershipStatus? status;
	String? partnerId;
	String? meToOtherRelationshipDescription;
	String? otherToMeRelationshipDescription;

	Partnership({
		this.type,
		this.status,
		this.partnerId,
		this.meToOtherRelationshipDescription,
		this.otherToMeRelationshipDescription
	});

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
}