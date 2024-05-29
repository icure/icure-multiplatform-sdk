package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.embed.DataAttachmentJs
import com.icure.sdk.js.model.embed.DelegationJs
import com.icure.sdk.js.model.embed.DeletedAttachmentJs
import com.icure.sdk.js.model.embed.dataAttachment_fromJs
import com.icure.sdk.js.model.embed.dataAttachment_toJs
import com.icure.sdk.js.model.embed.delegation_fromJs
import com.icure.sdk.js.model.embed.delegation_toJs
import com.icure.sdk.js.model.embed.deletedAttachment_fromJs
import com.icure.sdk.js.model.embed.deletedAttachment_toJs
import com.icure.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.sdk.js.model.embed.securityMetadata_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.DataAttachment
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.DeletedAttachment
import com.icure.sdk.model.embed.DocumentLocation
import com.icure.sdk.model.embed.DocumentStatus
import com.icure.sdk.model.embed.DocumentType
import kotlin.Array
import kotlin.String
import kotlin.collections.Set

public fun document_toJs(obj: DecryptedDocument): DecryptedDocumentJs {
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
	val documentLocation = obj.documentLocation?.let { nonNull1 ->
		obj.documentLocation?.name
	}
	val documentType = obj.documentType?.let { nonNull1 ->
		obj.documentType?.name
	}
	val documentStatus = obj.documentStatus?.let { nonNull1 ->
		obj.documentStatus?.name
	}
	val externalUri = obj.externalUri
	val name = obj.name
	val version = obj.version
	val storedICureDocumentId = obj.storedICureDocumentId
	val externalUuid = obj.externalUuid
	val size = longToNumber(obj.size)
	val hash = obj.hash
	val openingContactId = obj.openingContactId
	val attachmentId = obj.attachmentId
	val objectStoreReference = obj.objectStoreReference
	val mainUti = obj.mainUti
	val otherUtis = setToArray(
		obj.otherUtis,
		{ x1: String ->
			x1
		},
	)
	val secondaryAttachments = mapToObject<_, _, DataAttachmentJs>(
		obj.secondaryAttachments,
		{ x1: String ->
			x1
		},
		{ x1: DataAttachment ->
			dataAttachment_toJs(x1)
		},
	)
	val deletedAttachments = listToArray(
		obj.deletedAttachments,
		{ x1: DeletedAttachment ->
			deletedAttachment_toJs(x1)
		},
	)
	val encryptedAttachment = obj.encryptedAttachment
	val decryptedAttachment = obj.decryptedAttachment
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject<_, _, Array<DelegationJs>>(
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
	val delegations = mapToObject<_, _, Array<DelegationJs>>(
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
	val encryptionKeys = mapToObject<_, _, Array<DelegationJs>>(
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
	return DecryptedDocumentJs(js("{" +
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
		"documentLocation:documentLocation," +
		"documentType:documentType," +
		"documentStatus:documentStatus," +
		"externalUri:externalUri," +
		"name:name," +
		"version:version," +
		"storedICureDocumentId:storedICureDocumentId," +
		"externalUuid:externalUuid," +
		"size:size," +
		"hash:hash," +
		"openingContactId:openingContactId," +
		"attachmentId:attachmentId," +
		"objectStoreReference:objectStoreReference," +
		"mainUti:mainUti," +
		"otherUtis:otherUtis," +
		"secondaryAttachments:secondaryAttachments," +
		"deletedAttachments:deletedAttachments," +
		"encryptedAttachment:encryptedAttachment," +
		"decryptedAttachment:decryptedAttachment," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun document_fromJs(obj: DecryptedDocumentJs): DecryptedDocument {
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
	val documentLocation = obj.documentLocation?.let { nonNull1 ->
		DocumentLocation.valueOf(nonNull1)
	}
	val documentType = obj.documentType?.let { nonNull1 ->
		DocumentType.valueOf(nonNull1)
	}
	val documentStatus = obj.documentStatus?.let { nonNull1 ->
		DocumentStatus.valueOf(nonNull1)
	}
	val externalUri = obj.externalUri
	val name = obj.name
	val version = obj.version
	val storedICureDocumentId = obj.storedICureDocumentId
	val externalUuid = obj.externalUuid
	val size = numberToLong(obj.size, "obj.size")
	val hash = obj.hash
	val openingContactId = obj.openingContactId
	val attachmentId = obj.attachmentId
	val objectStoreReference = obj.objectStoreReference
	val mainUti = obj.mainUti
	val otherUtis = arrayToSet(
		obj.otherUtis,
		"obj.otherUtis",
		{ x1: String ->
			x1
		},
	)
	val secondaryAttachments = objectToMap(
		obj.secondaryAttachments,
		"obj.secondaryAttachments",
		{ x1: String ->
			x1
		},
		{ x1: DataAttachmentJs ->
			dataAttachment_fromJs(x1)
		},
	)
	val deletedAttachments = arrayToList(
		obj.deletedAttachments,
		"obj.deletedAttachments",
		{ x1: DeletedAttachmentJs ->
			deletedAttachment_fromJs(x1)
		},
	)
	val encryptedAttachment = obj.encryptedAttachment
	val decryptedAttachment = obj.decryptedAttachment
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
	return DecryptedDocument(
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
		documentLocation = documentLocation,
		documentType = documentType,
		documentStatus = documentStatus,
		externalUri = externalUri,
		name = name,
		version = version,
		storedICureDocumentId = storedICureDocumentId,
		externalUuid = externalUuid,
		size = size,
		hash = hash,
		openingContactId = openingContactId,
		attachmentId = attachmentId,
		objectStoreReference = objectStoreReference,
		mainUti = mainUti,
		otherUtis = otherUtis,
		secondaryAttachments = secondaryAttachments,
		deletedAttachments = deletedAttachments,
		encryptedAttachment = encryptedAttachment,
		decryptedAttachment = decryptedAttachment,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

public fun document_toJs(obj: EncryptedDocument): EncryptedDocumentJs {
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
	val documentLocation = obj.documentLocation?.let { nonNull1 ->
		obj.documentLocation?.name
	}
	val documentType = obj.documentType?.let { nonNull1 ->
		obj.documentType?.name
	}
	val documentStatus = obj.documentStatus?.let { nonNull1 ->
		obj.documentStatus?.name
	}
	val externalUri = obj.externalUri
	val name = obj.name
	val version = obj.version
	val storedICureDocumentId = obj.storedICureDocumentId
	val externalUuid = obj.externalUuid
	val size = longToNumber(obj.size)
	val hash = obj.hash
	val openingContactId = obj.openingContactId
	val attachmentId = obj.attachmentId
	val objectStoreReference = obj.objectStoreReference
	val mainUti = obj.mainUti
	val otherUtis = setToArray(
		obj.otherUtis,
		{ x1: String ->
			x1
		},
	)
	val secondaryAttachments = mapToObject<_, _, DataAttachmentJs>(
		obj.secondaryAttachments,
		{ x1: String ->
			x1
		},
		{ x1: DataAttachment ->
			dataAttachment_toJs(x1)
		},
	)
	val deletedAttachments = listToArray(
		obj.deletedAttachments,
		{ x1: DeletedAttachment ->
			deletedAttachment_toJs(x1)
		},
	)
	val encryptedAttachment = obj.encryptedAttachment
	val decryptedAttachment = obj.decryptedAttachment
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject<_, _, Array<DelegationJs>>(
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
	val delegations = mapToObject<_, _, Array<DelegationJs>>(
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
	val encryptionKeys = mapToObject<_, _, Array<DelegationJs>>(
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
	return EncryptedDocumentJs(js("{" +
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
		"documentLocation:documentLocation," +
		"documentType:documentType," +
		"documentStatus:documentStatus," +
		"externalUri:externalUri," +
		"name:name," +
		"version:version," +
		"storedICureDocumentId:storedICureDocumentId," +
		"externalUuid:externalUuid," +
		"size:size," +
		"hash:hash," +
		"openingContactId:openingContactId," +
		"attachmentId:attachmentId," +
		"objectStoreReference:objectStoreReference," +
		"mainUti:mainUti," +
		"otherUtis:otherUtis," +
		"secondaryAttachments:secondaryAttachments," +
		"deletedAttachments:deletedAttachments," +
		"encryptedAttachment:encryptedAttachment," +
		"decryptedAttachment:decryptedAttachment," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun document_fromJs(obj: EncryptedDocumentJs): EncryptedDocument {
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
	val documentLocation = obj.documentLocation?.let { nonNull1 ->
		DocumentLocation.valueOf(nonNull1)
	}
	val documentType = obj.documentType?.let { nonNull1 ->
		DocumentType.valueOf(nonNull1)
	}
	val documentStatus = obj.documentStatus?.let { nonNull1 ->
		DocumentStatus.valueOf(nonNull1)
	}
	val externalUri = obj.externalUri
	val name = obj.name
	val version = obj.version
	val storedICureDocumentId = obj.storedICureDocumentId
	val externalUuid = obj.externalUuid
	val size = numberToLong(obj.size, "obj.size")
	val hash = obj.hash
	val openingContactId = obj.openingContactId
	val attachmentId = obj.attachmentId
	val objectStoreReference = obj.objectStoreReference
	val mainUti = obj.mainUti
	val otherUtis = arrayToSet(
		obj.otherUtis,
		"obj.otherUtis",
		{ x1: String ->
			x1
		},
	)
	val secondaryAttachments = objectToMap(
		obj.secondaryAttachments,
		"obj.secondaryAttachments",
		{ x1: String ->
			x1
		},
		{ x1: DataAttachmentJs ->
			dataAttachment_fromJs(x1)
		},
	)
	val deletedAttachments = arrayToList(
		obj.deletedAttachments,
		"obj.deletedAttachments",
		{ x1: DeletedAttachmentJs ->
			deletedAttachment_fromJs(x1)
		},
	)
	val encryptedAttachment = obj.encryptedAttachment
	val decryptedAttachment = obj.decryptedAttachment
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
	return EncryptedDocument(
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
		documentLocation = documentLocation,
		documentType = documentType,
		documentStatus = documentStatus,
		externalUri = externalUri,
		name = name,
		version = version,
		storedICureDocumentId = storedICureDocumentId,
		externalUuid = externalUuid,
		size = size,
		hash = hash,
		openingContactId = openingContactId,
		attachmentId = attachmentId,
		objectStoreReference = objectStoreReference,
		mainUti = mainUti,
		otherUtis = otherUtis,
		secondaryAttachments = secondaryAttachments,
		deletedAttachments = deletedAttachments,
		encryptedAttachment = encryptedAttachment,
		decryptedAttachment = decryptedAttachment,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

public fun document_toJs(obj: Document): DocumentJs = when (obj) {
	is EncryptedDocument -> document_toJs(obj)
	is DecryptedDocument -> document_toJs(obj)
}

public fun document_fromJs(obj: DocumentJs): Document = if (obj.isEncrypted) {
	document_fromJs(obj as EncryptedDocumentJs)
} else {
	document_fromJs(obj as DecryptedDocumentJs)
}
