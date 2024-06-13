package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.DecryptedSubContact
import com.icure.sdk.model.embed.EncryptedSubContact
import com.icure.sdk.model.embed.ServiceLink
import com.icure.sdk.model.embed.SubContact
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun subContact_toJs(obj: DecryptedSubContact): DecryptedSubContactJs {
	val id = obj.id ?: undefined
	val created = longToNumber(obj.created) ?: undefined
	val modified = longToNumber(obj.modified) ?: undefined
	val author = obj.author ?: undefined
	val responsible = obj.responsible ?: undefined
	val medicalLocationId = obj.medicalLocationId ?: undefined
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife) ?: undefined
	val descr = obj.descr ?: undefined
	val protocol = obj.protocol ?: undefined
	val status = intToNumber(obj.status) ?: undefined
	val formId = obj.formId ?: undefined
	val planOfActionId = obj.planOfActionId ?: undefined
	val healthElementId = obj.healthElementId ?: undefined
	val classificationId = obj.classificationId ?: undefined
	val services = listToArray(
		obj.services,
		{ x1: ServiceLink ->
			serviceLink_toJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	} ?: undefined
	return DecryptedSubContactJs(js("{" +
		"id:id," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"descr:descr," +
		"protocol:protocol," +
		"status:status," +
		"formId:formId," +
		"planOfActionId:planOfActionId," +
		"healthElementId:healthElementId," +
		"classificationId:classificationId," +
		"services:services," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun subContact_fromJs(obj: DecryptedSubContactJs): DecryptedSubContact {
	val id = obj.id
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val descr = obj.descr
	val protocol = obj.protocol
	val status = numberToInt(obj.status, "obj.status")
	val formId = obj.formId
	val planOfActionId = obj.planOfActionId
	val healthElementId = obj.healthElementId
	val classificationId = obj.classificationId
	val services = arrayToList(
		obj.services,
		"obj.services",
		{ x1: ServiceLinkJs ->
			serviceLink_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedSubContact(
		id = id,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		descr = descr,
		protocol = protocol,
		status = status,
		formId = formId,
		planOfActionId = planOfActionId,
		healthElementId = healthElementId,
		classificationId = classificationId,
		services = services,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun subContact_toJs(obj: EncryptedSubContact): EncryptedSubContactJs {
	val id = obj.id ?: undefined
	val created = longToNumber(obj.created) ?: undefined
	val modified = longToNumber(obj.modified) ?: undefined
	val author = obj.author ?: undefined
	val responsible = obj.responsible ?: undefined
	val medicalLocationId = obj.medicalLocationId ?: undefined
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife) ?: undefined
	val descr = obj.descr ?: undefined
	val protocol = obj.protocol ?: undefined
	val status = intToNumber(obj.status) ?: undefined
	val formId = obj.formId ?: undefined
	val planOfActionId = obj.planOfActionId ?: undefined
	val healthElementId = obj.healthElementId ?: undefined
	val classificationId = obj.classificationId ?: undefined
	val services = listToArray(
		obj.services,
		{ x1: ServiceLink ->
			serviceLink_toJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	} ?: undefined
	return EncryptedSubContactJs(js("{" +
		"id:id," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"descr:descr," +
		"protocol:protocol," +
		"status:status," +
		"formId:formId," +
		"planOfActionId:planOfActionId," +
		"healthElementId:healthElementId," +
		"classificationId:classificationId," +
		"services:services," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun subContact_fromJs(obj: EncryptedSubContactJs): EncryptedSubContact {
	val id = obj.id
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val descr = obj.descr
	val protocol = obj.protocol
	val status = numberToInt(obj.status, "obj.status")
	val formId = obj.formId
	val planOfActionId = obj.planOfActionId
	val healthElementId = obj.healthElementId
	val classificationId = obj.classificationId
	val services = arrayToList(
		obj.services,
		"obj.services",
		{ x1: ServiceLinkJs ->
			serviceLink_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedSubContact(
		id = id,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		descr = descr,
		protocol = protocol,
		status = status,
		formId = formId,
		planOfActionId = planOfActionId,
		healthElementId = healthElementId,
		classificationId = classificationId,
		services = services,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun subContact_toJs(obj: SubContact): SubContactJs = when (obj) {
	is EncryptedSubContact -> subContact_toJs(obj)
	is DecryptedSubContact -> subContact_toJs(obj)
}

public fun subContact_fromJs(obj: SubContactJs): SubContact = if (obj.isEncrypted) {
	subContact_fromJs(obj as EncryptedSubContactJs)
} else {
	subContact_fromJs(obj as DecryptedSubContactJs)
}
