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
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.js.model.embed.AnnotationJs
import com.icure.sdk.js.model.embed.DecryptedServiceJs
import com.icure.sdk.js.model.embed.DecryptedSubContactJs
import com.icure.sdk.js.model.embed.DelegationJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.EncryptedSubContactJs
import com.icure.sdk.js.model.embed.annotation_fromJs
import com.icure.sdk.js.model.embed.annotation_toJs
import com.icure.sdk.js.model.embed.delegation_fromJs
import com.icure.sdk.js.model.embed.delegation_toJs
import com.icure.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.sdk.js.model.embed.securityMetadata_toJs
import com.icure.sdk.js.model.embed.service_fromJs
import com.icure.sdk.js.model.embed.service_toJs
import com.icure.sdk.js.model.embed.subContact_fromJs
import com.icure.sdk.js.model.embed.subContact_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.DecryptedSubContact
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.EncryptedSubContact
import kotlin.Array
import kotlin.String
import kotlin.collections.Set

public fun contact_toJs(obj: DecryptedContact): DecryptedContactJs {
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
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val groupId = obj.groupId
	val openingDate = longToNumber(obj.openingDate)
	val closingDate = longToNumber(obj.closingDate)
	val descr = obj.descr
	val location = obj.location
	val externalId = obj.externalId
	val encounterType = obj.encounterType?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val subContacts = setToArray(
		obj.subContacts,
		{ x1: DecryptedSubContact ->
			subContact_toJs(x1)
		},
	)
	val services = setToArray(
		obj.services,
		{ x1: DecryptedService ->
			service_toJs(x1)
		},
	)
	val healthcarePartyId = obj.healthcarePartyId
	val modifiedContactId = obj.modifiedContactId
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
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	return DecryptedContactJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"identifier:identifier," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"groupId:groupId," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"descr:descr," +
		"location:location," +
		"externalId:externalId," +
		"encounterType:encounterType," +
		"subContacts:subContacts," +
		"services:services," +
		"healthcarePartyId:healthcarePartyId," +
		"modifiedContactId:modifiedContactId," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata," +
		"notes:notes" +
	"}"))
}

public fun contact_fromJs(obj: DecryptedContactJs): DecryptedContact {
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
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val groupId = obj.groupId
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val descr = obj.descr
	val location = obj.location
	val externalId = obj.externalId
	val encounterType = obj.encounterType?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val subContacts = arrayToSet(
		obj.subContacts,
		"obj.subContacts",
		{ x1: DecryptedSubContactJs ->
			subContact_fromJs(x1)
		},
	)
	val services = arrayToSet(
		obj.services,
		"obj.services",
		{ x1: DecryptedServiceJs ->
			service_fromJs(x1)
		},
	)
	val healthcarePartyId = obj.healthcarePartyId
	val modifiedContactId = obj.modifiedContactId
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
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	return DecryptedContact(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		identifier = identifier,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		groupId = groupId,
		openingDate = openingDate,
		closingDate = closingDate,
		descr = descr,
		location = location,
		externalId = externalId,
		encounterType = encounterType,
		subContacts = subContacts,
		services = services,
		healthcarePartyId = healthcarePartyId,
		modifiedContactId = modifiedContactId,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
		notes = notes,
	)
}

public fun contact_toJs(obj: EncryptedContact): EncryptedContactJs {
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
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val groupId = obj.groupId
	val openingDate = longToNumber(obj.openingDate)
	val closingDate = longToNumber(obj.closingDate)
	val descr = obj.descr
	val location = obj.location
	val externalId = obj.externalId
	val encounterType = obj.encounterType?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val subContacts = setToArray(
		obj.subContacts,
		{ x1: EncryptedSubContact ->
			subContact_toJs(x1)
		},
	)
	val services = setToArray(
		obj.services,
		{ x1: EncryptedService ->
			service_toJs(x1)
		},
	)
	val healthcarePartyId = obj.healthcarePartyId
	val modifiedContactId = obj.modifiedContactId
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
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	return EncryptedContactJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"identifier:identifier," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"groupId:groupId," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"descr:descr," +
		"location:location," +
		"externalId:externalId," +
		"encounterType:encounterType," +
		"subContacts:subContacts," +
		"services:services," +
		"healthcarePartyId:healthcarePartyId," +
		"modifiedContactId:modifiedContactId," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata," +
		"notes:notes" +
	"}"))
}

public fun contact_fromJs(obj: EncryptedContactJs): EncryptedContact {
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
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val groupId = obj.groupId
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val descr = obj.descr
	val location = obj.location
	val externalId = obj.externalId
	val encounterType = obj.encounterType?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val subContacts = arrayToSet(
		obj.subContacts,
		"obj.subContacts",
		{ x1: EncryptedSubContactJs ->
			subContact_fromJs(x1)
		},
	)
	val services = arrayToSet(
		obj.services,
		"obj.services",
		{ x1: EncryptedServiceJs ->
			service_fromJs(x1)
		},
	)
	val healthcarePartyId = obj.healthcarePartyId
	val modifiedContactId = obj.modifiedContactId
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
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	return EncryptedContact(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		identifier = identifier,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		groupId = groupId,
		openingDate = openingDate,
		closingDate = closingDate,
		descr = descr,
		location = location,
		externalId = externalId,
		encounterType = encounterType,
		subContacts = subContacts,
		services = services,
		healthcarePartyId = healthcarePartyId,
		modifiedContactId = modifiedContactId,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
		notes = notes,
	)
}

public fun contact_toJs(obj: Contact): ContactJs = when (obj) {
	is EncryptedContact -> contact_toJs(obj)
	is DecryptedContact -> contact_toJs(obj)
}

public fun contact_fromJs(obj: ContactJs): Contact = if (obj.isEncrypted) {
	contact_fromJs(obj as EncryptedContactJs)
} else {
	contact_fromJs(obj as DecryptedContactJs)
}
