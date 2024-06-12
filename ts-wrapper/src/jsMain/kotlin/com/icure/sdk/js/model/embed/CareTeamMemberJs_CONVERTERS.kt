package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.CareTeamMember
import com.icure.sdk.model.embed.CareTeamMemberType
import com.icure.sdk.model.embed.DecryptedCareTeamMember
import com.icure.sdk.model.embed.EncryptedCareTeamMember

public fun careTeamMember_toJs(obj: DecryptedCareTeamMember): DecryptedCareTeamMemberJs {
	val id = obj.id
	val careTeamMemberType = obj.careTeamMemberType?.let { nonNull1 ->
		obj.careTeamMemberType?.name
	}
	val healthcarePartyId = obj.healthcarePartyId
	val quality = obj.quality?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedCareTeamMemberJs(js("{" +
		"id:id," +
		"careTeamMemberType:careTeamMemberType," +
		"healthcarePartyId:healthcarePartyId," +
		"quality:quality," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun careTeamMember_fromJs(obj: DecryptedCareTeamMemberJs): DecryptedCareTeamMember {
	val id = obj.id
	val careTeamMemberType = obj.careTeamMemberType?.let { nonNull1 ->
		CareTeamMemberType.valueOf(nonNull1)
	}
	val healthcarePartyId = obj.healthcarePartyId
	val quality = obj.quality?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedCareTeamMember(
		id = id,
		careTeamMemberType = careTeamMemberType,
		healthcarePartyId = healthcarePartyId,
		quality = quality,
		encryptedSelf = encryptedSelf,
	)
}

public fun careTeamMember_toJs(obj: EncryptedCareTeamMember): EncryptedCareTeamMemberJs {
	val id = obj.id
	val careTeamMemberType = obj.careTeamMemberType?.let { nonNull1 ->
		obj.careTeamMemberType?.name
	}
	val healthcarePartyId = obj.healthcarePartyId
	val quality = obj.quality?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedCareTeamMemberJs(js("{" +
		"id:id," +
		"careTeamMemberType:careTeamMemberType," +
		"healthcarePartyId:healthcarePartyId," +
		"quality:quality," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun careTeamMember_fromJs(obj: EncryptedCareTeamMemberJs): EncryptedCareTeamMember {
	val id = obj.id
	val careTeamMemberType = obj.careTeamMemberType?.let { nonNull1 ->
		CareTeamMemberType.valueOf(nonNull1)
	}
	val healthcarePartyId = obj.healthcarePartyId
	val quality = obj.quality?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedCareTeamMember(
		id = id,
		careTeamMemberType = careTeamMemberType,
		healthcarePartyId = healthcarePartyId,
		quality = quality,
		encryptedSelf = encryptedSelf,
	)
}

public fun careTeamMember_toJs(obj: CareTeamMember): CareTeamMemberJs = when (obj) {
	is EncryptedCareTeamMember -> careTeamMember_toJs(obj)
	is DecryptedCareTeamMember -> careTeamMember_toJs(obj)
}

public fun careTeamMember_fromJs(obj: CareTeamMemberJs): CareTeamMember = if (obj.isEncrypted) {
	careTeamMember_fromJs(obj as EncryptedCareTeamMemberJs)
} else {
	careTeamMember_fromJs(obj as DecryptedCareTeamMemberJs)
}
