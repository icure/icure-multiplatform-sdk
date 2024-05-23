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
import com.icure.sdk.js.model.embed.DecryptedInvoicingCodeJs
import com.icure.sdk.js.model.embed.DelegationJs
import com.icure.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.sdk.js.model.embed.PaymentJs
import com.icure.sdk.js.model.embed.delegation_fromJs
import com.icure.sdk.js.model.embed.delegation_toJs
import com.icure.sdk.js.model.embed.identityDocumentReader_fromJs
import com.icure.sdk.js.model.embed.identityDocumentReader_toJs
import com.icure.sdk.js.model.embed.invoiceInterventionType_fromJs
import com.icure.sdk.js.model.embed.invoiceInterventionType_toJs
import com.icure.sdk.js.model.embed.invoiceType_fromJs
import com.icure.sdk.js.model.embed.invoiceType_toJs
import com.icure.sdk.js.model.embed.invoicingCode_fromJs
import com.icure.sdk.js.model.embed.invoicingCode_toJs
import com.icure.sdk.js.model.embed.mediumType_fromJs
import com.icure.sdk.js.model.embed.mediumType_toJs
import com.icure.sdk.js.model.embed.paymentType_fromJs
import com.icure.sdk.js.model.embed.paymentType_toJs
import com.icure.sdk.js.model.embed.payment_fromJs
import com.icure.sdk.js.model.embed.payment_toJs
import com.icure.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.sdk.js.model.embed.securityMetadata_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.DecryptedInvoice
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.DecryptedInvoicingCode
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.Payment
import kotlin.Array
import kotlin.String
import kotlin.collections.Set

public fun invoice_toJs(obj: DecryptedInvoice): DecryptedInvoiceJs {
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
	val invoiceDate = longToNumber(obj.invoiceDate)
	val sentDate = longToNumber(obj.sentDate)
	val printedDate = longToNumber(obj.printedDate)
	val invoicingCodes = listToArray(
		obj.invoicingCodes,
		{ x1: DecryptedInvoicingCode ->
			invoicingCode_toJs(x1)
		},
	)
	val receipts = mapToObject<_, _, String>(
		obj.receipts,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val recipientType = obj.recipientType
	val recipientId = obj.recipientId
	val invoiceReference = obj.invoiceReference
	val thirdPartyReference = obj.thirdPartyReference
	val thirdPartyPaymentJustification = obj.thirdPartyPaymentJustification
	val thirdPartyPaymentReason = obj.thirdPartyPaymentReason
	val reason = obj.reason
	val invoiceType = obj.invoiceType?.let { nonNull1 ->
		invoiceType_toJs(nonNull1)
	}
	val sentMediumType = obj.sentMediumType?.let { nonNull1 ->
		mediumType_toJs(nonNull1)
	}
	val interventionType = obj.interventionType?.let { nonNull1 ->
		invoiceInterventionType_toJs(nonNull1)
	}
	val groupId = obj.groupId
	val paymentType = obj.paymentType?.let { nonNull1 ->
		paymentType_toJs(nonNull1)
	}
	val paid = obj.paid
	val payments = listToArray(
		obj.payments,
		{ x1: Payment ->
			payment_toJs(x1)
		},
	)
	val gnotionNihii = obj.gnotionNihii
	val gnotionSsin = obj.gnotionSsin
	val gnotionLastName = obj.gnotionLastName
	val gnotionFirstName = obj.gnotionFirstName
	val gnotionCdHcParty = obj.gnotionCdHcParty
	val invoicePeriod = intToNumber(obj.invoicePeriod)
	val careProviderType = obj.careProviderType
	val internshipNihii = obj.internshipNihii
	val internshipSsin = obj.internshipSsin
	val internshipLastName = obj.internshipLastName
	val internshipFirstName = obj.internshipFirstName
	val internshipCdHcParty = obj.internshipCdHcParty
	val internshipCbe = obj.internshipCbe
	val supervisorNihii = obj.supervisorNihii
	val supervisorSsin = obj.supervisorSsin
	val supervisorLastName = obj.supervisorLastName
	val supervisorFirstName = obj.supervisorFirstName
	val supervisorCdHcParty = obj.supervisorCdHcParty
	val supervisorCbe = obj.supervisorCbe
	val error = obj.error
	val encounterLocationName = obj.encounterLocationName
	val encounterLocationNihii = obj.encounterLocationNihii
	val encounterLocationNorm = intToNumber(obj.encounterLocationNorm)
	val longDelayJustification = intToNumber(obj.longDelayJustification)
	val correctiveInvoiceId = obj.correctiveInvoiceId
	val correctedInvoiceId = obj.correctedInvoiceId
	val creditNote = obj.creditNote
	val creditNoteRelatedInvoiceId = obj.creditNoteRelatedInvoiceId
	val idDocument = obj.idDocument?.let { nonNull1 ->
		identityDocumentReader_toJs(nonNull1)
	}
	val admissionDate = longToNumber(obj.admissionDate)
	val locationNihii = obj.locationNihii
	val locationService = intToNumber(obj.locationService)
	val cancelReason = obj.cancelReason
	val cancelDate = longToNumber(obj.cancelDate)
	val options = mapToObject<_, _, String>(
		obj.options,
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
	return DecryptedInvoiceJs(js("{" +
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
		"invoiceDate:invoiceDate," +
		"sentDate:sentDate," +
		"printedDate:printedDate," +
		"invoicingCodes:invoicingCodes," +
		"receipts:receipts," +
		"recipientType:recipientType," +
		"recipientId:recipientId," +
		"invoiceReference:invoiceReference," +
		"thirdPartyReference:thirdPartyReference," +
		"thirdPartyPaymentJustification:thirdPartyPaymentJustification," +
		"thirdPartyPaymentReason:thirdPartyPaymentReason," +
		"reason:reason," +
		"invoiceType:invoiceType," +
		"sentMediumType:sentMediumType," +
		"interventionType:interventionType," +
		"groupId:groupId," +
		"paymentType:paymentType," +
		"paid:paid," +
		"payments:payments," +
		"gnotionNihii:gnotionNihii," +
		"gnotionSsin:gnotionSsin," +
		"gnotionLastName:gnotionLastName," +
		"gnotionFirstName:gnotionFirstName," +
		"gnotionCdHcParty:gnotionCdHcParty," +
		"invoicePeriod:invoicePeriod," +
		"careProviderType:careProviderType," +
		"internshipNihii:internshipNihii," +
		"internshipSsin:internshipSsin," +
		"internshipLastName:internshipLastName," +
		"internshipFirstName:internshipFirstName," +
		"internshipCdHcParty:internshipCdHcParty," +
		"internshipCbe:internshipCbe," +
		"supervisorNihii:supervisorNihii," +
		"supervisorSsin:supervisorSsin," +
		"supervisorLastName:supervisorLastName," +
		"supervisorFirstName:supervisorFirstName," +
		"supervisorCdHcParty:supervisorCdHcParty," +
		"supervisorCbe:supervisorCbe," +
		"error:error," +
		"encounterLocationName:encounterLocationName," +
		"encounterLocationNihii:encounterLocationNihii," +
		"encounterLocationNorm:encounterLocationNorm," +
		"longDelayJustification:longDelayJustification," +
		"correctiveInvoiceId:correctiveInvoiceId," +
		"correctedInvoiceId:correctedInvoiceId," +
		"creditNote:creditNote," +
		"creditNoteRelatedInvoiceId:creditNoteRelatedInvoiceId," +
		"idDocument:idDocument," +
		"admissionDate:admissionDate," +
		"locationNihii:locationNihii," +
		"locationService:locationService," +
		"cancelReason:cancelReason," +
		"cancelDate:cancelDate," +
		"options:options," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun invoice_fromJs(obj: DecryptedInvoiceJs): DecryptedInvoice {
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
	val invoiceDate = numberToLong(obj.invoiceDate, "obj.invoiceDate")
	val sentDate = numberToLong(obj.sentDate, "obj.sentDate")
	val printedDate = numberToLong(obj.printedDate, "obj.printedDate")
	val invoicingCodes = arrayToList(
		obj.invoicingCodes,
		"obj.invoicingCodes",
		{ x1: DecryptedInvoicingCodeJs ->
			invoicingCode_fromJs(x1)
		},
	)
	val receipts = objectToMap(
		obj.receipts,
		"obj.receipts",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val recipientType = obj.recipientType
	val recipientId = obj.recipientId
	val invoiceReference = obj.invoiceReference
	val thirdPartyReference = obj.thirdPartyReference
	val thirdPartyPaymentJustification = obj.thirdPartyPaymentJustification
	val thirdPartyPaymentReason = obj.thirdPartyPaymentReason
	val reason = obj.reason
	val invoiceType = obj.invoiceType?.let { nonNull1 ->
		invoiceType_fromJs(nonNull1)
	}
	val sentMediumType = obj.sentMediumType?.let { nonNull1 ->
		mediumType_fromJs(nonNull1)
	}
	val interventionType = obj.interventionType?.let { nonNull1 ->
		invoiceInterventionType_fromJs(nonNull1)
	}
	val groupId = obj.groupId
	val paymentType = obj.paymentType?.let { nonNull1 ->
		paymentType_fromJs(nonNull1)
	}
	val paid = obj.paid
	val payments = arrayToList(
		obj.payments,
		"obj.payments",
		{ x1: PaymentJs ->
			payment_fromJs(x1)
		},
	)
	val gnotionNihii = obj.gnotionNihii
	val gnotionSsin = obj.gnotionSsin
	val gnotionLastName = obj.gnotionLastName
	val gnotionFirstName = obj.gnotionFirstName
	val gnotionCdHcParty = obj.gnotionCdHcParty
	val invoicePeriod = numberToInt(obj.invoicePeriod, "obj.invoicePeriod")
	val careProviderType = obj.careProviderType
	val internshipNihii = obj.internshipNihii
	val internshipSsin = obj.internshipSsin
	val internshipLastName = obj.internshipLastName
	val internshipFirstName = obj.internshipFirstName
	val internshipCdHcParty = obj.internshipCdHcParty
	val internshipCbe = obj.internshipCbe
	val supervisorNihii = obj.supervisorNihii
	val supervisorSsin = obj.supervisorSsin
	val supervisorLastName = obj.supervisorLastName
	val supervisorFirstName = obj.supervisorFirstName
	val supervisorCdHcParty = obj.supervisorCdHcParty
	val supervisorCbe = obj.supervisorCbe
	val error = obj.error
	val encounterLocationName = obj.encounterLocationName
	val encounterLocationNihii = obj.encounterLocationNihii
	val encounterLocationNorm = numberToInt(obj.encounterLocationNorm, "obj.encounterLocationNorm")
	val longDelayJustification = numberToInt(obj.longDelayJustification, "obj.longDelayJustification")
	val correctiveInvoiceId = obj.correctiveInvoiceId
	val correctedInvoiceId = obj.correctedInvoiceId
	val creditNote = obj.creditNote
	val creditNoteRelatedInvoiceId = obj.creditNoteRelatedInvoiceId
	val idDocument = obj.idDocument?.let { nonNull1 ->
		identityDocumentReader_fromJs(nonNull1)
	}
	val admissionDate = numberToLong(obj.admissionDate, "obj.admissionDate")
	val locationNihii = obj.locationNihii
	val locationService = numberToInt(obj.locationService, "obj.locationService")
	val cancelReason = obj.cancelReason
	val cancelDate = numberToLong(obj.cancelDate, "obj.cancelDate")
	val options = objectToMap(
		obj.options,
		"obj.options",
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
	return DecryptedInvoice(
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
		invoiceDate = invoiceDate,
		sentDate = sentDate,
		printedDate = printedDate,
		invoicingCodes = invoicingCodes,
		receipts = receipts,
		recipientType = recipientType,
		recipientId = recipientId,
		invoiceReference = invoiceReference,
		thirdPartyReference = thirdPartyReference,
		thirdPartyPaymentJustification = thirdPartyPaymentJustification,
		thirdPartyPaymentReason = thirdPartyPaymentReason,
		reason = reason,
		invoiceType = invoiceType,
		sentMediumType = sentMediumType,
		interventionType = interventionType,
		groupId = groupId,
		paymentType = paymentType,
		paid = paid,
		payments = payments,
		gnotionNihii = gnotionNihii,
		gnotionSsin = gnotionSsin,
		gnotionLastName = gnotionLastName,
		gnotionFirstName = gnotionFirstName,
		gnotionCdHcParty = gnotionCdHcParty,
		invoicePeriod = invoicePeriod,
		careProviderType = careProviderType,
		internshipNihii = internshipNihii,
		internshipSsin = internshipSsin,
		internshipLastName = internshipLastName,
		internshipFirstName = internshipFirstName,
		internshipCdHcParty = internshipCdHcParty,
		internshipCbe = internshipCbe,
		supervisorNihii = supervisorNihii,
		supervisorSsin = supervisorSsin,
		supervisorLastName = supervisorLastName,
		supervisorFirstName = supervisorFirstName,
		supervisorCdHcParty = supervisorCdHcParty,
		supervisorCbe = supervisorCbe,
		error = error,
		encounterLocationName = encounterLocationName,
		encounterLocationNihii = encounterLocationNihii,
		encounterLocationNorm = encounterLocationNorm,
		longDelayJustification = longDelayJustification,
		correctiveInvoiceId = correctiveInvoiceId,
		correctedInvoiceId = correctedInvoiceId,
		creditNote = creditNote,
		creditNoteRelatedInvoiceId = creditNoteRelatedInvoiceId,
		idDocument = idDocument,
		admissionDate = admissionDate,
		locationNihii = locationNihii,
		locationService = locationService,
		cancelReason = cancelReason,
		cancelDate = cancelDate,
		options = options,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

public fun invoice_toJs(obj: EncryptedInvoice): EncryptedInvoiceJs {
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
	val invoiceDate = longToNumber(obj.invoiceDate)
	val sentDate = longToNumber(obj.sentDate)
	val printedDate = longToNumber(obj.printedDate)
	val invoicingCodes = listToArray(
		obj.invoicingCodes,
		{ x1: EncryptedInvoicingCode ->
			invoicingCode_toJs(x1)
		},
	)
	val receipts = mapToObject<_, _, String>(
		obj.receipts,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val recipientType = obj.recipientType
	val recipientId = obj.recipientId
	val invoiceReference = obj.invoiceReference
	val thirdPartyReference = obj.thirdPartyReference
	val thirdPartyPaymentJustification = obj.thirdPartyPaymentJustification
	val thirdPartyPaymentReason = obj.thirdPartyPaymentReason
	val reason = obj.reason
	val invoiceType = obj.invoiceType?.let { nonNull1 ->
		invoiceType_toJs(nonNull1)
	}
	val sentMediumType = obj.sentMediumType?.let { nonNull1 ->
		mediumType_toJs(nonNull1)
	}
	val interventionType = obj.interventionType?.let { nonNull1 ->
		invoiceInterventionType_toJs(nonNull1)
	}
	val groupId = obj.groupId
	val paymentType = obj.paymentType?.let { nonNull1 ->
		paymentType_toJs(nonNull1)
	}
	val paid = obj.paid
	val payments = listToArray(
		obj.payments,
		{ x1: Payment ->
			payment_toJs(x1)
		},
	)
	val gnotionNihii = obj.gnotionNihii
	val gnotionSsin = obj.gnotionSsin
	val gnotionLastName = obj.gnotionLastName
	val gnotionFirstName = obj.gnotionFirstName
	val gnotionCdHcParty = obj.gnotionCdHcParty
	val invoicePeriod = intToNumber(obj.invoicePeriod)
	val careProviderType = obj.careProviderType
	val internshipNihii = obj.internshipNihii
	val internshipSsin = obj.internshipSsin
	val internshipLastName = obj.internshipLastName
	val internshipFirstName = obj.internshipFirstName
	val internshipCdHcParty = obj.internshipCdHcParty
	val internshipCbe = obj.internshipCbe
	val supervisorNihii = obj.supervisorNihii
	val supervisorSsin = obj.supervisorSsin
	val supervisorLastName = obj.supervisorLastName
	val supervisorFirstName = obj.supervisorFirstName
	val supervisorCdHcParty = obj.supervisorCdHcParty
	val supervisorCbe = obj.supervisorCbe
	val error = obj.error
	val encounterLocationName = obj.encounterLocationName
	val encounterLocationNihii = obj.encounterLocationNihii
	val encounterLocationNorm = intToNumber(obj.encounterLocationNorm)
	val longDelayJustification = intToNumber(obj.longDelayJustification)
	val correctiveInvoiceId = obj.correctiveInvoiceId
	val correctedInvoiceId = obj.correctedInvoiceId
	val creditNote = obj.creditNote
	val creditNoteRelatedInvoiceId = obj.creditNoteRelatedInvoiceId
	val idDocument = obj.idDocument?.let { nonNull1 ->
		identityDocumentReader_toJs(nonNull1)
	}
	val admissionDate = longToNumber(obj.admissionDate)
	val locationNihii = obj.locationNihii
	val locationService = intToNumber(obj.locationService)
	val cancelReason = obj.cancelReason
	val cancelDate = longToNumber(obj.cancelDate)
	val options = mapToObject<_, _, String>(
		obj.options,
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
	return EncryptedInvoiceJs(js("{" +
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
		"invoiceDate:invoiceDate," +
		"sentDate:sentDate," +
		"printedDate:printedDate," +
		"invoicingCodes:invoicingCodes," +
		"receipts:receipts," +
		"recipientType:recipientType," +
		"recipientId:recipientId," +
		"invoiceReference:invoiceReference," +
		"thirdPartyReference:thirdPartyReference," +
		"thirdPartyPaymentJustification:thirdPartyPaymentJustification," +
		"thirdPartyPaymentReason:thirdPartyPaymentReason," +
		"reason:reason," +
		"invoiceType:invoiceType," +
		"sentMediumType:sentMediumType," +
		"interventionType:interventionType," +
		"groupId:groupId," +
		"paymentType:paymentType," +
		"paid:paid," +
		"payments:payments," +
		"gnotionNihii:gnotionNihii," +
		"gnotionSsin:gnotionSsin," +
		"gnotionLastName:gnotionLastName," +
		"gnotionFirstName:gnotionFirstName," +
		"gnotionCdHcParty:gnotionCdHcParty," +
		"invoicePeriod:invoicePeriod," +
		"careProviderType:careProviderType," +
		"internshipNihii:internshipNihii," +
		"internshipSsin:internshipSsin," +
		"internshipLastName:internshipLastName," +
		"internshipFirstName:internshipFirstName," +
		"internshipCdHcParty:internshipCdHcParty," +
		"internshipCbe:internshipCbe," +
		"supervisorNihii:supervisorNihii," +
		"supervisorSsin:supervisorSsin," +
		"supervisorLastName:supervisorLastName," +
		"supervisorFirstName:supervisorFirstName," +
		"supervisorCdHcParty:supervisorCdHcParty," +
		"supervisorCbe:supervisorCbe," +
		"error:error," +
		"encounterLocationName:encounterLocationName," +
		"encounterLocationNihii:encounterLocationNihii," +
		"encounterLocationNorm:encounterLocationNorm," +
		"longDelayJustification:longDelayJustification," +
		"correctiveInvoiceId:correctiveInvoiceId," +
		"correctedInvoiceId:correctedInvoiceId," +
		"creditNote:creditNote," +
		"creditNoteRelatedInvoiceId:creditNoteRelatedInvoiceId," +
		"idDocument:idDocument," +
		"admissionDate:admissionDate," +
		"locationNihii:locationNihii," +
		"locationService:locationService," +
		"cancelReason:cancelReason," +
		"cancelDate:cancelDate," +
		"options:options," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun invoice_fromJs(obj: EncryptedInvoiceJs): EncryptedInvoice {
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
	val invoiceDate = numberToLong(obj.invoiceDate, "obj.invoiceDate")
	val sentDate = numberToLong(obj.sentDate, "obj.sentDate")
	val printedDate = numberToLong(obj.printedDate, "obj.printedDate")
	val invoicingCodes = arrayToList(
		obj.invoicingCodes,
		"obj.invoicingCodes",
		{ x1: EncryptedInvoicingCodeJs ->
			invoicingCode_fromJs(x1)
		},
	)
	val receipts = objectToMap(
		obj.receipts,
		"obj.receipts",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val recipientType = obj.recipientType
	val recipientId = obj.recipientId
	val invoiceReference = obj.invoiceReference
	val thirdPartyReference = obj.thirdPartyReference
	val thirdPartyPaymentJustification = obj.thirdPartyPaymentJustification
	val thirdPartyPaymentReason = obj.thirdPartyPaymentReason
	val reason = obj.reason
	val invoiceType = obj.invoiceType?.let { nonNull1 ->
		invoiceType_fromJs(nonNull1)
	}
	val sentMediumType = obj.sentMediumType?.let { nonNull1 ->
		mediumType_fromJs(nonNull1)
	}
	val interventionType = obj.interventionType?.let { nonNull1 ->
		invoiceInterventionType_fromJs(nonNull1)
	}
	val groupId = obj.groupId
	val paymentType = obj.paymentType?.let { nonNull1 ->
		paymentType_fromJs(nonNull1)
	}
	val paid = obj.paid
	val payments = arrayToList(
		obj.payments,
		"obj.payments",
		{ x1: PaymentJs ->
			payment_fromJs(x1)
		},
	)
	val gnotionNihii = obj.gnotionNihii
	val gnotionSsin = obj.gnotionSsin
	val gnotionLastName = obj.gnotionLastName
	val gnotionFirstName = obj.gnotionFirstName
	val gnotionCdHcParty = obj.gnotionCdHcParty
	val invoicePeriod = numberToInt(obj.invoicePeriod, "obj.invoicePeriod")
	val careProviderType = obj.careProviderType
	val internshipNihii = obj.internshipNihii
	val internshipSsin = obj.internshipSsin
	val internshipLastName = obj.internshipLastName
	val internshipFirstName = obj.internshipFirstName
	val internshipCdHcParty = obj.internshipCdHcParty
	val internshipCbe = obj.internshipCbe
	val supervisorNihii = obj.supervisorNihii
	val supervisorSsin = obj.supervisorSsin
	val supervisorLastName = obj.supervisorLastName
	val supervisorFirstName = obj.supervisorFirstName
	val supervisorCdHcParty = obj.supervisorCdHcParty
	val supervisorCbe = obj.supervisorCbe
	val error = obj.error
	val encounterLocationName = obj.encounterLocationName
	val encounterLocationNihii = obj.encounterLocationNihii
	val encounterLocationNorm = numberToInt(obj.encounterLocationNorm, "obj.encounterLocationNorm")
	val longDelayJustification = numberToInt(obj.longDelayJustification, "obj.longDelayJustification")
	val correctiveInvoiceId = obj.correctiveInvoiceId
	val correctedInvoiceId = obj.correctedInvoiceId
	val creditNote = obj.creditNote
	val creditNoteRelatedInvoiceId = obj.creditNoteRelatedInvoiceId
	val idDocument = obj.idDocument?.let { nonNull1 ->
		identityDocumentReader_fromJs(nonNull1)
	}
	val admissionDate = numberToLong(obj.admissionDate, "obj.admissionDate")
	val locationNihii = obj.locationNihii
	val locationService = numberToInt(obj.locationService, "obj.locationService")
	val cancelReason = obj.cancelReason
	val cancelDate = numberToLong(obj.cancelDate, "obj.cancelDate")
	val options = objectToMap(
		obj.options,
		"obj.options",
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
	return EncryptedInvoice(
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
		invoiceDate = invoiceDate,
		sentDate = sentDate,
		printedDate = printedDate,
		invoicingCodes = invoicingCodes,
		receipts = receipts,
		recipientType = recipientType,
		recipientId = recipientId,
		invoiceReference = invoiceReference,
		thirdPartyReference = thirdPartyReference,
		thirdPartyPaymentJustification = thirdPartyPaymentJustification,
		thirdPartyPaymentReason = thirdPartyPaymentReason,
		reason = reason,
		invoiceType = invoiceType,
		sentMediumType = sentMediumType,
		interventionType = interventionType,
		groupId = groupId,
		paymentType = paymentType,
		paid = paid,
		payments = payments,
		gnotionNihii = gnotionNihii,
		gnotionSsin = gnotionSsin,
		gnotionLastName = gnotionLastName,
		gnotionFirstName = gnotionFirstName,
		gnotionCdHcParty = gnotionCdHcParty,
		invoicePeriod = invoicePeriod,
		careProviderType = careProviderType,
		internshipNihii = internshipNihii,
		internshipSsin = internshipSsin,
		internshipLastName = internshipLastName,
		internshipFirstName = internshipFirstName,
		internshipCdHcParty = internshipCdHcParty,
		internshipCbe = internshipCbe,
		supervisorNihii = supervisorNihii,
		supervisorSsin = supervisorSsin,
		supervisorLastName = supervisorLastName,
		supervisorFirstName = supervisorFirstName,
		supervisorCdHcParty = supervisorCdHcParty,
		supervisorCbe = supervisorCbe,
		error = error,
		encounterLocationName = encounterLocationName,
		encounterLocationNihii = encounterLocationNihii,
		encounterLocationNorm = encounterLocationNorm,
		longDelayJustification = longDelayJustification,
		correctiveInvoiceId = correctiveInvoiceId,
		correctedInvoiceId = correctedInvoiceId,
		creditNote = creditNote,
		creditNoteRelatedInvoiceId = creditNoteRelatedInvoiceId,
		idDocument = idDocument,
		admissionDate = admissionDate,
		locationNihii = locationNihii,
		locationService = locationService,
		cancelReason = cancelReason,
		cancelDate = cancelDate,
		options = options,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

public fun invoice_toJs(obj: Invoice): InvoiceJs = when (obj) {
	is EncryptedInvoice -> invoice_toJs(obj)
	is DecryptedInvoice -> invoice_toJs(obj)
}

public fun invoice_fromJs(obj: InvoiceJs): Invoice = if (obj.isEncrypted) {
	invoice_fromJs(obj as EncryptedInvoiceJs)
} else {
	invoice_fromJs(obj as DecryptedInvoiceJs)
}
