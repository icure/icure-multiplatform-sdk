package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.embed.DelegationJs
import com.icure.sdk.js.model.embed.delegation_fromJs
import com.icure.sdk.js.model.embed.delegation_toJs
import com.icure.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.sdk.js.model.embed.securityMetadata_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.Form
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Delegation
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun form_toJs(obj: DecryptedForm): DecryptedFormJs {
	val id = obj.id
	val rev = obj.rev
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
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
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val openingDate = longToNumber(obj.openingDate)
	val status = obj.status
	val version = intToNumber(obj.version)
	val logicalUuid = obj.logicalUuid
	val descr = obj.descr
	val uniqueId = obj.uniqueId
	val formTemplateId = obj.formTemplateId
	val contactId = obj.contactId
	val healthElementId = obj.healthElementId
	val planOfActionId = obj.planOfActionId
	val parent = obj.parent
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	return DecryptedFormJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"openingDate:openingDate," +
		"status:status," +
		"version:version," +
		"logicalUuid:logicalUuid," +
		"descr:descr," +
		"uniqueId:uniqueId," +
		"formTemplateId:formTemplateId," +
		"contactId:contactId," +
		"healthElementId:healthElementId," +
		"planOfActionId:planOfActionId," +
		"parent:parent," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun form_fromJs(obj: DecryptedFormJs): DecryptedForm {
	val id = obj.id
	val rev = obj.rev
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
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val status = obj.status
	val version = numberToInt(obj.version, "obj.version")
	val logicalUuid = obj.logicalUuid
	val descr = obj.descr
	val uniqueId = obj.uniqueId
	val formTemplateId = obj.formTemplateId
	val contactId = obj.contactId
	val healthElementId = obj.healthElementId
	val planOfActionId = obj.planOfActionId
	val parent = obj.parent
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return DecryptedForm(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		openingDate = openingDate,
		status = status,
		version = version,
		logicalUuid = logicalUuid,
		descr = descr,
		uniqueId = uniqueId,
		formTemplateId = formTemplateId,
		contactId = contactId,
		healthElementId = healthElementId,
		planOfActionId = planOfActionId,
		parent = parent,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun form_toJs(obj: EncryptedForm): EncryptedFormJs {
	val id = obj.id
	val rev = obj.rev
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
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
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val openingDate = longToNumber(obj.openingDate)
	val status = obj.status
	val version = intToNumber(obj.version)
	val logicalUuid = obj.logicalUuid
	val descr = obj.descr
	val uniqueId = obj.uniqueId
	val formTemplateId = obj.formTemplateId
	val contactId = obj.contactId
	val healthElementId = obj.healthElementId
	val planOfActionId = obj.planOfActionId
	val parent = obj.parent
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	return EncryptedFormJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"openingDate:openingDate," +
		"status:status," +
		"version:version," +
		"logicalUuid:logicalUuid," +
		"descr:descr," +
		"uniqueId:uniqueId," +
		"formTemplateId:formTemplateId," +
		"contactId:contactId," +
		"healthElementId:healthElementId," +
		"planOfActionId:planOfActionId," +
		"parent:parent," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun form_fromJs(obj: EncryptedFormJs): EncryptedForm {
	val id = obj.id
	val rev = obj.rev
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
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val status = obj.status
	val version = numberToInt(obj.version, "obj.version")
	val logicalUuid = obj.logicalUuid
	val descr = obj.descr
	val uniqueId = obj.uniqueId
	val formTemplateId = obj.formTemplateId
	val contactId = obj.contactId
	val healthElementId = obj.healthElementId
	val planOfActionId = obj.planOfActionId
	val parent = obj.parent
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return EncryptedForm(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		openingDate = openingDate,
		status = status,
		version = version,
		logicalUuid = logicalUuid,
		descr = descr,
		uniqueId = uniqueId,
		formTemplateId = formTemplateId,
		contactId = contactId,
		healthElementId = healthElementId,
		planOfActionId = planOfActionId,
		parent = parent,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun form_toJs(obj: Form): FormJs = when (obj) {
	is EncryptedForm -> form_toJs(obj)
	is DecryptedForm -> form_toJs(obj)
}

public fun form_fromJs(obj: FormJs): Form = if (obj.isEncrypted) {
	form_fromJs(obj as EncryptedFormJs)
} else {
	form_fromJs(obj as DecryptedFormJs)
}
