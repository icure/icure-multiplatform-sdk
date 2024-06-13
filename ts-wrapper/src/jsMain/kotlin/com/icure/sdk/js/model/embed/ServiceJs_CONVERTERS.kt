package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.LinkQualification
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.DecryptedContent
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun service_toJs(obj: DecryptedService): DecryptedServiceJs {
	val id = obj.id
	val transactionId = obj.transactionId
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val contactId = obj.contactId
	val subContactIds = setToArray(
		obj.subContactIds,
		{ x1: String ->
			x1
		},
	)
	val plansOfActionIds = setToArray(
		obj.plansOfActionIds,
		{ x1: String ->
			x1
		},
	)
	val healthElementsIds = setToArray(
		obj.healthElementsIds,
		{ x1: String ->
			x1
		},
	)
	val formIds = setToArray(
		obj.formIds,
		{ x1: String ->
			x1
		},
	)
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
	val label = obj.label
	val index = longToNumber(obj.index)
	val content = mapToObject(
		obj.content,
		{ x1: String ->
			x1
		},
		{ x1: DecryptedContent ->
			content_toJs(x1)
		},
	)
	val encryptedContent = obj.encryptedContent
	val textIndexes = mapToObject(
		obj.textIndexes,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val valueDate = longToNumber(obj.valueDate)
	val openingDate = longToNumber(obj.openingDate)
	val closingDate = longToNumber(obj.closingDate)
	val formId = obj.formId
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val endOfLife = longToNumber(obj.endOfLife)
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val comment = obj.comment
	val status = intToNumber(obj.status)
	val invoicingCodes = setToArray(
		obj.invoicingCodes,
		{ x1: String ->
			x1
		},
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val qualifiedLinks = mapToObject(
		obj.qualifiedLinks,
		{ x1: LinkQualification ->
			x1.name
		},
		{ x1: Map<String, String> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	return DecryptedServiceJs(js("{" +
		"id:id," +
		"transactionId:transactionId," +
		"identifier:identifier," +
		"contactId:contactId," +
		"subContactIds:subContactIds," +
		"plansOfActionIds:plansOfActionIds," +
		"healthElementsIds:healthElementsIds," +
		"formIds:formIds," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"label:label," +
		"index:index," +
		"content:content," +
		"encryptedContent:encryptedContent," +
		"textIndexes:textIndexes," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"formId:formId," +
		"created:created," +
		"modified:modified," +
		"endOfLife:endOfLife," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"comment:comment," +
		"status:status," +
		"invoicingCodes:invoicingCodes," +
		"notes:notes," +
		"qualifiedLinks:qualifiedLinks," +
		"codes:codes," +
		"tags:tags," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun service_fromJs(obj: DecryptedServiceJs): DecryptedService {
	val id = obj.id
	val transactionId = obj.transactionId
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val contactId = obj.contactId
	val subContactIds = arrayToSet(
		obj.subContactIds,
		"obj.subContactIds",
		{ x1: String ->
			x1
		},
	)
	val plansOfActionIds = arrayToSet(
		obj.plansOfActionIds,
		"obj.plansOfActionIds",
		{ x1: String ->
			x1
		},
	)
	val healthElementsIds = arrayToSet(
		obj.healthElementsIds,
		"obj.healthElementsIds",
		{ x1: String ->
			x1
		},
	)
	val formIds = arrayToSet(
		obj.formIds,
		"obj.formIds",
		{ x1: String ->
			x1
		},
	)
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
	val label = obj.label
	val index = numberToLong(obj.index, "obj.index")
	val content = objectToMap(
		obj.content,
		"obj.content",
		{ x1: String ->
			x1
		},
		{ x1: DecryptedContentJs ->
			content_fromJs(x1)
		},
	)
	val encryptedContent = obj.encryptedContent
	val textIndexes = objectToMap(
		obj.textIndexes,
		"obj.textIndexes",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val formId = obj.formId
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val comment = obj.comment
	val status = numberToInt(obj.status, "obj.status")
	val invoicingCodes = arrayToSet(
		obj.invoicingCodes,
		"obj.invoicingCodes",
		{ x1: String ->
			x1
		},
	)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val qualifiedLinks = objectToMap(
		obj.qualifiedLinks,
		"obj.qualifiedLinks",
		{ x1: String ->
			LinkQualification.valueOf(x1)
		},
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return DecryptedService(
		id = id,
		transactionId = transactionId,
		identifier = identifier,
		contactId = contactId,
		subContactIds = subContactIds,
		plansOfActionIds = plansOfActionIds,
		healthElementsIds = healthElementsIds,
		formIds = formIds,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		label = label,
		index = index,
		content = content,
		encryptedContent = encryptedContent,
		textIndexes = textIndexes,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		formId = formId,
		created = created,
		modified = modified,
		endOfLife = endOfLife,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		comment = comment,
		status = status,
		invoicingCodes = invoicingCodes,
		notes = notes,
		qualifiedLinks = qualifiedLinks,
		codes = codes,
		tags = tags,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun service_toJs(obj: EncryptedService): EncryptedServiceJs {
	val id = obj.id
	val transactionId = obj.transactionId
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val contactId = obj.contactId
	val subContactIds = setToArray(
		obj.subContactIds,
		{ x1: String ->
			x1
		},
	)
	val plansOfActionIds = setToArray(
		obj.plansOfActionIds,
		{ x1: String ->
			x1
		},
	)
	val healthElementsIds = setToArray(
		obj.healthElementsIds,
		{ x1: String ->
			x1
		},
	)
	val formIds = setToArray(
		obj.formIds,
		{ x1: String ->
			x1
		},
	)
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
	val label = obj.label
	val index = longToNumber(obj.index)
	val content = mapToObject(
		obj.content,
		{ x1: String ->
			x1
		},
		{ x1: EncryptedContent ->
			content_toJs(x1)
		},
	)
	val encryptedContent = obj.encryptedContent
	val textIndexes = mapToObject(
		obj.textIndexes,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val valueDate = longToNumber(obj.valueDate)
	val openingDate = longToNumber(obj.openingDate)
	val closingDate = longToNumber(obj.closingDate)
	val formId = obj.formId
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val endOfLife = longToNumber(obj.endOfLife)
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val comment = obj.comment
	val status = intToNumber(obj.status)
	val invoicingCodes = setToArray(
		obj.invoicingCodes,
		{ x1: String ->
			x1
		},
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val qualifiedLinks = mapToObject(
		obj.qualifiedLinks,
		{ x1: LinkQualification ->
			x1.name
		},
		{ x1: Map<String, String> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	return EncryptedServiceJs(js("{" +
		"id:id," +
		"transactionId:transactionId," +
		"identifier:identifier," +
		"contactId:contactId," +
		"subContactIds:subContactIds," +
		"plansOfActionIds:plansOfActionIds," +
		"healthElementsIds:healthElementsIds," +
		"formIds:formIds," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"label:label," +
		"index:index," +
		"content:content," +
		"encryptedContent:encryptedContent," +
		"textIndexes:textIndexes," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"formId:formId," +
		"created:created," +
		"modified:modified," +
		"endOfLife:endOfLife," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"comment:comment," +
		"status:status," +
		"invoicingCodes:invoicingCodes," +
		"notes:notes," +
		"qualifiedLinks:qualifiedLinks," +
		"codes:codes," +
		"tags:tags," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun service_fromJs(obj: EncryptedServiceJs): EncryptedService {
	val id = obj.id
	val transactionId = obj.transactionId
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val contactId = obj.contactId
	val subContactIds = arrayToSet(
		obj.subContactIds,
		"obj.subContactIds",
		{ x1: String ->
			x1
		},
	)
	val plansOfActionIds = arrayToSet(
		obj.plansOfActionIds,
		"obj.plansOfActionIds",
		{ x1: String ->
			x1
		},
	)
	val healthElementsIds = arrayToSet(
		obj.healthElementsIds,
		"obj.healthElementsIds",
		{ x1: String ->
			x1
		},
	)
	val formIds = arrayToSet(
		obj.formIds,
		"obj.formIds",
		{ x1: String ->
			x1
		},
	)
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
	val label = obj.label
	val index = numberToLong(obj.index, "obj.index")
	val content = objectToMap(
		obj.content,
		"obj.content",
		{ x1: String ->
			x1
		},
		{ x1: EncryptedContentJs ->
			content_fromJs(x1)
		},
	)
	val encryptedContent = obj.encryptedContent
	val textIndexes = objectToMap(
		obj.textIndexes,
		"obj.textIndexes",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val formId = obj.formId
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val comment = obj.comment
	val status = numberToInt(obj.status, "obj.status")
	val invoicingCodes = arrayToSet(
		obj.invoicingCodes,
		"obj.invoicingCodes",
		{ x1: String ->
			x1
		},
	)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val qualifiedLinks = objectToMap(
		obj.qualifiedLinks,
		"obj.qualifiedLinks",
		{ x1: String ->
			LinkQualification.valueOf(x1)
		},
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return EncryptedService(
		id = id,
		transactionId = transactionId,
		identifier = identifier,
		contactId = contactId,
		subContactIds = subContactIds,
		plansOfActionIds = plansOfActionIds,
		healthElementsIds = healthElementsIds,
		formIds = formIds,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		label = label,
		index = index,
		content = content,
		encryptedContent = encryptedContent,
		textIndexes = textIndexes,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		formId = formId,
		created = created,
		modified = modified,
		endOfLife = endOfLife,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		comment = comment,
		status = status,
		invoicingCodes = invoicingCodes,
		notes = notes,
		qualifiedLinks = qualifiedLinks,
		codes = codes,
		tags = tags,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun service_toJs(obj: Service): ServiceJs = when (obj) {
	is EncryptedService -> service_toJs(obj)
	is DecryptedService -> service_toJs(obj)
}

public fun service_fromJs(obj: ServiceJs): Service = if (obj.isEncrypted) {
	service_fromJs(obj as EncryptedServiceJs)
} else {
	service_fromJs(obj as DecryptedServiceJs)
}
