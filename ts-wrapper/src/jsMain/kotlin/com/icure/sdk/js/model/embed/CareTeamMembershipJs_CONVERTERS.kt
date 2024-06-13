package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.CareTeamMembership
import com.icure.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.sdk.model.embed.MembershipType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun careTeamMembership_toJs(obj: DecryptedCareTeamMembership):
		DecryptedCareTeamMembershipJs {
	val startDate = longToNumber(obj.startDate)
	val endDate = longToNumber(obj.endDate)
	val careTeamMemberId = obj.careTeamMemberId
	val membershipType = obj.membershipType?.let { nonNull1 ->
		nonNull1.name
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedCareTeamMembershipJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"careTeamMemberId:careTeamMemberId," +
		"membershipType:membershipType," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun careTeamMembership_fromJs(obj: DecryptedCareTeamMembershipJs):
		DecryptedCareTeamMembership {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val careTeamMemberId = obj.careTeamMemberId
	val membershipType = obj.membershipType?.let { nonNull1 ->
		MembershipType.valueOf(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedCareTeamMembership(
		startDate = startDate,
		endDate = endDate,
		careTeamMemberId = careTeamMemberId,
		membershipType = membershipType,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun careTeamMembership_toJs(obj: EncryptedCareTeamMembership):
		EncryptedCareTeamMembershipJs {
	val startDate = longToNumber(obj.startDate)
	val endDate = longToNumber(obj.endDate)
	val careTeamMemberId = obj.careTeamMemberId
	val membershipType = obj.membershipType?.let { nonNull1 ->
		nonNull1.name
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedCareTeamMembershipJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"careTeamMemberId:careTeamMemberId," +
		"membershipType:membershipType," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun careTeamMembership_fromJs(obj: EncryptedCareTeamMembershipJs):
		EncryptedCareTeamMembership {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val careTeamMemberId = obj.careTeamMemberId
	val membershipType = obj.membershipType?.let { nonNull1 ->
		MembershipType.valueOf(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedCareTeamMembership(
		startDate = startDate,
		endDate = endDate,
		careTeamMemberId = careTeamMemberId,
		membershipType = membershipType,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun careTeamMembership_toJs(obj: CareTeamMembership): CareTeamMembershipJs = when (obj) {
	is EncryptedCareTeamMembership -> careTeamMembership_toJs(obj)
	is DecryptedCareTeamMembership -> careTeamMembership_toJs(obj)
}

public fun careTeamMembership_fromJs(obj: CareTeamMembershipJs): CareTeamMembership = if
		(obj.isEncrypted) {
	careTeamMembership_fromJs(obj as EncryptedCareTeamMembershipJs)
} else {
	careTeamMembership_fromJs(obj as DecryptedCareTeamMembershipJs)
}
