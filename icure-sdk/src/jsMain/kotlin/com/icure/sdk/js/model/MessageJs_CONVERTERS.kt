package com.icure.sdk.js.model

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
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.embed.DelegationJs
import com.icure.sdk.js.model.embed.MessageAttachmentJs
import com.icure.sdk.js.model.embed.MessageReadStatusJs
import com.icure.sdk.js.model.embed.delegation_fromJs
import com.icure.sdk.js.model.embed.delegation_toJs
import com.icure.sdk.js.model.embed.messageAttachment_fromJs
import com.icure.sdk.js.model.embed.messageAttachment_toJs
import com.icure.sdk.js.model.embed.messageReadStatus_fromJs
import com.icure.sdk.js.model.embed.messageReadStatus_toJs
import com.icure.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.sdk.js.model.embed.securityMetadata_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.Message
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.MessageAttachment
import com.icure.sdk.model.embed.MessageReadStatus
import kotlin.Array
import kotlin.String
import kotlin.collections.Set

public fun message_toJs(obj: DecryptedMessage): DecryptedMessageJs {
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
	val fromAddress = obj.fromAddress
	val fromHealthcarePartyId = obj.fromHealthcarePartyId
	val formId = obj.formId
	val status = intToNumber(obj.status)
	val recipientsType = obj.recipientsType
	val recipients = setToArray(
		obj.recipients,
		{ x1: String ->
			x1
		},
	)
	val toAddresses = setToArray(
		obj.toAddresses,
		{ x1: String ->
			x1
		},
	)
	val received = longToNumber(obj.received)
	val sent = longToNumber(obj.sent)
	val metas = mapToObject(
		obj.metas,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val readStatus = mapToObject(
		obj.readStatus,
		{ x1: String ->
			x1
		},
		{ x1: MessageReadStatus ->
			messageReadStatus_toJs(x1)
		},
	)
	val messageAttachments = listToArray(
		obj.messageAttachments,
		{ x1: MessageAttachment ->
			messageAttachment_toJs(x1)
		},
	)
	val transportGuid = obj.transportGuid
	val remark = obj.remark
	val conversationGuid = obj.conversationGuid
	val subject = obj.subject
	val invoiceIds = setToArray(
		obj.invoiceIds,
		{ x1: String ->
			x1
		},
	)
	val parentId = obj.parentId
	val externalRef = obj.externalRef
	val unassignedResults = setToArray(
		obj.unassignedResults,
		{ x1: String ->
			x1
		},
	)
	val assignedResults = mapToObject(
		obj.assignedResults,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val senderReferences = mapToObject(
		obj.senderReferences,
		{ x1: String ->
			x1
		},
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
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	return DecryptedMessageJs(js("{" +
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
		"fromAddress:fromAddress," +
		"fromHealthcarePartyId:fromHealthcarePartyId," +
		"formId:formId," +
		"status:status," +
		"recipientsType:recipientsType," +
		"recipients:recipients," +
		"toAddresses:toAddresses," +
		"received:received," +
		"sent:sent," +
		"metas:metas," +
		"readStatus:readStatus," +
		"messageAttachments:messageAttachments," +
		"transportGuid:transportGuid," +
		"remark:remark," +
		"conversationGuid:conversationGuid," +
		"subject:subject," +
		"invoiceIds:invoiceIds," +
		"parentId:parentId," +
		"externalRef:externalRef," +
		"unassignedResults:unassignedResults," +
		"assignedResults:assignedResults," +
		"senderReferences:senderReferences," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun message_fromJs(obj: DecryptedMessageJs): DecryptedMessage {
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
	val fromAddress = obj.fromAddress
	val fromHealthcarePartyId = obj.fromHealthcarePartyId
	val formId = obj.formId
	val status = numberToInt(obj.status, "obj.status")
	val recipientsType = obj.recipientsType
	val recipients = arrayToSet(
		obj.recipients,
		"obj.recipients",
		{ x1: String ->
			x1
		},
	)
	val toAddresses = arrayToSet(
		obj.toAddresses,
		"obj.toAddresses",
		{ x1: String ->
			x1
		},
	)
	val received = numberToLong(obj.received, "obj.received")
	val sent = numberToLong(obj.sent, "obj.sent")
	val metas = objectToMap(
		obj.metas,
		"obj.metas",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val readStatus = objectToMap(
		obj.readStatus,
		"obj.readStatus",
		{ x1: String ->
			x1
		},
		{ x1: MessageReadStatusJs ->
			messageReadStatus_fromJs(x1)
		},
	)
	val messageAttachments = arrayToList(
		obj.messageAttachments,
		"obj.messageAttachments",
		{ x1: MessageAttachmentJs ->
			messageAttachment_fromJs(x1)
		},
	)
	val transportGuid = obj.transportGuid
	val remark = obj.remark
	val conversationGuid = obj.conversationGuid
	val subject = obj.subject
	val invoiceIds = arrayToSet(
		obj.invoiceIds,
		"obj.invoiceIds",
		{ x1: String ->
			x1
		},
	)
	val parentId = obj.parentId
	val externalRef = obj.externalRef
	val unassignedResults = arrayToSet(
		obj.unassignedResults,
		"obj.unassignedResults",
		{ x1: String ->
			x1
		},
	)
	val assignedResults = objectToMap(
		obj.assignedResults,
		"obj.assignedResults",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val senderReferences = objectToMap(
		obj.senderReferences,
		"obj.senderReferences",
		{ x1: String ->
			x1
		},
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
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return DecryptedMessage(
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
		fromAddress = fromAddress,
		fromHealthcarePartyId = fromHealthcarePartyId,
		formId = formId,
		status = status,
		recipientsType = recipientsType,
		recipients = recipients,
		toAddresses = toAddresses,
		received = received,
		sent = sent,
		metas = metas,
		readStatus = readStatus,
		messageAttachments = messageAttachments,
		transportGuid = transportGuid,
		remark = remark,
		conversationGuid = conversationGuid,
		subject = subject,
		invoiceIds = invoiceIds,
		parentId = parentId,
		externalRef = externalRef,
		unassignedResults = unassignedResults,
		assignedResults = assignedResults,
		senderReferences = senderReferences,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

public fun message_toJs(obj: EncryptedMessage): EncryptedMessageJs {
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
	val fromAddress = obj.fromAddress
	val fromHealthcarePartyId = obj.fromHealthcarePartyId
	val formId = obj.formId
	val status = intToNumber(obj.status)
	val recipientsType = obj.recipientsType
	val recipients = setToArray(
		obj.recipients,
		{ x1: String ->
			x1
		},
	)
	val toAddresses = setToArray(
		obj.toAddresses,
		{ x1: String ->
			x1
		},
	)
	val received = longToNumber(obj.received)
	val sent = longToNumber(obj.sent)
	val metas = mapToObject(
		obj.metas,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val readStatus = mapToObject(
		obj.readStatus,
		{ x1: String ->
			x1
		},
		{ x1: MessageReadStatus ->
			messageReadStatus_toJs(x1)
		},
	)
	val messageAttachments = listToArray(
		obj.messageAttachments,
		{ x1: MessageAttachment ->
			messageAttachment_toJs(x1)
		},
	)
	val transportGuid = obj.transportGuid
	val remark = obj.remark
	val conversationGuid = obj.conversationGuid
	val subject = obj.subject
	val invoiceIds = setToArray(
		obj.invoiceIds,
		{ x1: String ->
			x1
		},
	)
	val parentId = obj.parentId
	val externalRef = obj.externalRef
	val unassignedResults = setToArray(
		obj.unassignedResults,
		{ x1: String ->
			x1
		},
	)
	val assignedResults = mapToObject(
		obj.assignedResults,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val senderReferences = mapToObject(
		obj.senderReferences,
		{ x1: String ->
			x1
		},
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
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	return EncryptedMessageJs(js("{" +
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
		"fromAddress:fromAddress," +
		"fromHealthcarePartyId:fromHealthcarePartyId," +
		"formId:formId," +
		"status:status," +
		"recipientsType:recipientsType," +
		"recipients:recipients," +
		"toAddresses:toAddresses," +
		"received:received," +
		"sent:sent," +
		"metas:metas," +
		"readStatus:readStatus," +
		"messageAttachments:messageAttachments," +
		"transportGuid:transportGuid," +
		"remark:remark," +
		"conversationGuid:conversationGuid," +
		"subject:subject," +
		"invoiceIds:invoiceIds," +
		"parentId:parentId," +
		"externalRef:externalRef," +
		"unassignedResults:unassignedResults," +
		"assignedResults:assignedResults," +
		"senderReferences:senderReferences," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun message_fromJs(obj: EncryptedMessageJs): EncryptedMessage {
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
	val fromAddress = obj.fromAddress
	val fromHealthcarePartyId = obj.fromHealthcarePartyId
	val formId = obj.formId
	val status = numberToInt(obj.status, "obj.status")
	val recipientsType = obj.recipientsType
	val recipients = arrayToSet(
		obj.recipients,
		"obj.recipients",
		{ x1: String ->
			x1
		},
	)
	val toAddresses = arrayToSet(
		obj.toAddresses,
		"obj.toAddresses",
		{ x1: String ->
			x1
		},
	)
	val received = numberToLong(obj.received, "obj.received")
	val sent = numberToLong(obj.sent, "obj.sent")
	val metas = objectToMap(
		obj.metas,
		"obj.metas",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val readStatus = objectToMap(
		obj.readStatus,
		"obj.readStatus",
		{ x1: String ->
			x1
		},
		{ x1: MessageReadStatusJs ->
			messageReadStatus_fromJs(x1)
		},
	)
	val messageAttachments = arrayToList(
		obj.messageAttachments,
		"obj.messageAttachments",
		{ x1: MessageAttachmentJs ->
			messageAttachment_fromJs(x1)
		},
	)
	val transportGuid = obj.transportGuid
	val remark = obj.remark
	val conversationGuid = obj.conversationGuid
	val subject = obj.subject
	val invoiceIds = arrayToSet(
		obj.invoiceIds,
		"obj.invoiceIds",
		{ x1: String ->
			x1
		},
	)
	val parentId = obj.parentId
	val externalRef = obj.externalRef
	val unassignedResults = arrayToSet(
		obj.unassignedResults,
		"obj.unassignedResults",
		{ x1: String ->
			x1
		},
	)
	val assignedResults = objectToMap(
		obj.assignedResults,
		"obj.assignedResults",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val senderReferences = objectToMap(
		obj.senderReferences,
		"obj.senderReferences",
		{ x1: String ->
			x1
		},
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
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return EncryptedMessage(
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
		fromAddress = fromAddress,
		fromHealthcarePartyId = fromHealthcarePartyId,
		formId = formId,
		status = status,
		recipientsType = recipientsType,
		recipients = recipients,
		toAddresses = toAddresses,
		received = received,
		sent = sent,
		metas = metas,
		readStatus = readStatus,
		messageAttachments = messageAttachments,
		transportGuid = transportGuid,
		remark = remark,
		conversationGuid = conversationGuid,
		subject = subject,
		invoiceIds = invoiceIds,
		parentId = parentId,
		externalRef = externalRef,
		unassignedResults = unassignedResults,
		assignedResults = assignedResults,
		senderReferences = senderReferences,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

public fun message_toJs(obj: Message): MessageJs = when (obj) {
	is EncryptedMessage -> message_toJs(obj)
	is DecryptedMessage -> message_toJs(obj)
}

public fun message_fromJs(obj: MessageJs): Message = if (obj.isEncrypted) {
	message_fromJs(obj as EncryptedMessageJs)
} else {
	message_fromJs(obj as DecryptedMessageJs)
}
