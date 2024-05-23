package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
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
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Delegation
import kotlin.Array
import kotlin.String
import kotlin.collections.Set

public fun topic_toJs(obj: DecryptedTopic): DecryptedTopicJs {
	val id = obj.id
	val rev = obj.rev
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val healthElementId = obj.healthElementId
	val contactId = obj.contactId
	val description = obj.description
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
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val activeParticipants = mapToObject<_, _, String>(
		obj.activeParticipants,
		{ x1: String ->
			x1
		},
		{ x1: TopicRole ->
			topicRole_toJs(x1)
		},
	)
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
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
	val linkedHealthElements = setToArray(
		obj.linkedHealthElements,
		{ x1: String ->
			x1
		},
	)
	val linkedServices = setToArray(
		obj.linkedServices,
		{ x1: String ->
			x1
		},
	)
	return DecryptedTopicJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"healthElementId:healthElementId," +
		"contactId:contactId," +
		"description:description," +
		"codes:codes," +
		"tags:tags," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"activeParticipants:activeParticipants," +
		"securityMetadata:securityMetadata," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"linkedHealthElements:linkedHealthElements," +
		"linkedServices:linkedServices" +
	"}"))
}

public fun topic_fromJs(obj: DecryptedTopicJs): DecryptedTopic {
	val id = obj.id
	val rev = obj.rev
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val healthElementId = obj.healthElementId
	val contactId = obj.contactId
	val description = obj.description
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
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val activeParticipants = objectToMap(
		obj.activeParticipants,
		"obj.activeParticipants",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			topicRole_fromJs(x1)
		},
	)
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
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
	val linkedHealthElements = arrayToSet(
		obj.linkedHealthElements,
		"obj.linkedHealthElements",
		{ x1: String ->
			x1
		},
	)
	val linkedServices = arrayToSet(
		obj.linkedServices,
		"obj.linkedServices",
		{ x1: String ->
			x1
		},
	)
	return DecryptedTopic(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		healthElementId = healthElementId,
		contactId = contactId,
		description = description,
		codes = codes,
		tags = tags,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		activeParticipants = activeParticipants,
		securityMetadata = securityMetadata,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		linkedHealthElements = linkedHealthElements,
		linkedServices = linkedServices,
	)
}

public fun topic_toJs(obj: EncryptedTopic): EncryptedTopicJs {
	val id = obj.id
	val rev = obj.rev
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val healthElementId = obj.healthElementId
	val contactId = obj.contactId
	val description = obj.description
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
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val activeParticipants = mapToObject<_, _, String>(
		obj.activeParticipants,
		{ x1: String ->
			x1
		},
		{ x1: TopicRole ->
			topicRole_toJs(x1)
		},
	)
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
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
	val linkedHealthElements = setToArray(
		obj.linkedHealthElements,
		{ x1: String ->
			x1
		},
	)
	val linkedServices = setToArray(
		obj.linkedServices,
		{ x1: String ->
			x1
		},
	)
	return EncryptedTopicJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"healthElementId:healthElementId," +
		"contactId:contactId," +
		"description:description," +
		"codes:codes," +
		"tags:tags," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"activeParticipants:activeParticipants," +
		"securityMetadata:securityMetadata," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"linkedHealthElements:linkedHealthElements," +
		"linkedServices:linkedServices" +
	"}"))
}

public fun topic_fromJs(obj: EncryptedTopicJs): EncryptedTopic {
	val id = obj.id
	val rev = obj.rev
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val healthElementId = obj.healthElementId
	val contactId = obj.contactId
	val description = obj.description
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
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val activeParticipants = objectToMap(
		obj.activeParticipants,
		"obj.activeParticipants",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			topicRole_fromJs(x1)
		},
	)
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
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
	val linkedHealthElements = arrayToSet(
		obj.linkedHealthElements,
		"obj.linkedHealthElements",
		{ x1: String ->
			x1
		},
	)
	val linkedServices = arrayToSet(
		obj.linkedServices,
		"obj.linkedServices",
		{ x1: String ->
			x1
		},
	)
	return EncryptedTopic(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		healthElementId = healthElementId,
		contactId = contactId,
		description = description,
		codes = codes,
		tags = tags,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		activeParticipants = activeParticipants,
		securityMetadata = securityMetadata,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		linkedHealthElements = linkedHealthElements,
		linkedServices = linkedServices,
	)
}

public fun topic_toJs(obj: Topic): TopicJs = when (obj) {
	is EncryptedTopic -> topic_toJs(obj)
	is DecryptedTopic -> topic_toJs(obj)
}

public fun topic_fromJs(obj: TopicJs): Topic = if (obj.isEncrypted) {
	topic_fromJs(obj as EncryptedTopicJs)
} else {
	topic_fromJs(obj as DecryptedTopicJs)
}
