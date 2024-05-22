package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.Partnership

public fun partnership_toJs(obj: Partnership): PartnershipJs {
	val type = obj.type?.let { nonNull1 ->
		partnershipType_toJs(nonNull1)
	}
	val status = obj.status?.let { nonNull1 ->
		partnershipStatus_toJs(nonNull1)
	}
	val partnerId = obj.partnerId
	val meToOtherRelationshipDescription = obj.meToOtherRelationshipDescription
	val otherToMeRelationshipDescription = obj.otherToMeRelationshipDescription
	return PartnershipJs(js("{" +
		"type:type," +
		"status:status," +
		"partnerId:partnerId," +
		"meToOtherRelationshipDescription:meToOtherRelationshipDescription," +
		"otherToMeRelationshipDescription:otherToMeRelationshipDescription" +
	"}"))
}

public fun partnership_fromJs(obj: PartnershipJs): Partnership {
	val type = obj.type?.let { nonNull1 ->
		partnershipType_fromJs(nonNull1)
	}
	val status = obj.status?.let { nonNull1 ->
		partnershipStatus_fromJs(nonNull1)
	}
	val partnerId = obj.partnerId
	val meToOtherRelationshipDescription = obj.meToOtherRelationshipDescription
	val otherToMeRelationshipDescription = obj.otherToMeRelationshipDescription
	return Partnership(
		type = type,
		status = status,
		partnerId = partnerId,
		meToOtherRelationshipDescription = meToOtherRelationshipDescription,
		otherToMeRelationshipDescription = otherToMeRelationshipDescription,
	)
}
