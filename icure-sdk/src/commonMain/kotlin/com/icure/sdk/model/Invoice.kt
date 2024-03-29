package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.DecryptedInvoicingCode
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.IdentityDocumentReader
import com.icure.sdk.model.embed.InvoiceInterventionType
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.InvoicingCode
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.model.embed.Payment
import com.icure.sdk.model.embed.PaymentType
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface Invoice :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	override val id: String

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	override val deletionDate: Long?

	public val invoiceDate: Long?

	public val sentDate: Long?

	public val printedDate: Long?

	public val invoicingCodes: List<InvoicingCode>

	public val receipts: Map<String, String>

	public val recipientType: String?

	public val recipientId: String?

	public val invoiceReference: String?

	public val thirdPartyReference: String?

	public val thirdPartyPaymentJustification: String?

	public val thirdPartyPaymentReason: String?

	public val reason: String?

	public val invoiceType: InvoiceType?

	public val sentMediumType: MediumType?

	public val interventionType: InvoiceInterventionType?

	public val groupId: String?

	public val paymentType: PaymentType?

	public val paid: Double?

	public val payments: List<Payment>?

	public val gnotionNihii: String?

	public val gnotionSsin: String?

	public val gnotionLastName: String?

	public val gnotionFirstName: String?

	public val gnotionCdHcParty: String?

	public val invoicePeriod: Int?

	public val careProviderType: String?

	public val internshipNihii: String?

	public val internshipSsin: String?

	public val internshipLastName: String?

	public val internshipFirstName: String?

	public val internshipCdHcParty: String?

	public val internshipCbe: String?

	public val supervisorNihii: String?

	public val supervisorSsin: String?

	public val supervisorLastName: String?

	public val supervisorFirstName: String?

	public val supervisorCdHcParty: String?

	public val supervisorCbe: String?

	public val error: String?

	public val encounterLocationName: String?

	public val encounterLocationNihii: String?

	public val encounterLocationNorm: Int?

	public val longDelayJustification: Int?

	public val correctiveInvoiceId: String?

	public val correctedInvoiceId: String?

	public val creditNote: Boolean?

	public val creditNoteRelatedInvoiceId: String?

	public val idDocument: IdentityDocumentReader?

	public val admissionDate: Long?

	public val locationNihii: String?

	public val locationService: Int?

	public val cancelReason: String?

	public val cancelDate: Long?

	public val options: Map<String, String>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?
	// region Invoice-Invoice

	// endregion
}

@Serializable
data class DecryptedInvoice(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val invoiceDate: Long? = null,
	override val sentDate: Long? = null,
	override val printedDate: Long? = null,
	override val invoicingCodes: List<DecryptedInvoicingCode> = emptyList(),
	override val receipts: Map<String, String> = emptyMap(),
	override val recipientType: String? = null,
	override val recipientId: String? = null,
	override val invoiceReference: String? = null,
	override val thirdPartyReference: String? = null,
	override val thirdPartyPaymentJustification: String? = null,
	override val thirdPartyPaymentReason: String? = null,
	override val reason: String? = null,
	override val invoiceType: InvoiceType? = null,
	override val sentMediumType: MediumType? = null,
	override val interventionType: InvoiceInterventionType? = null,
	override val groupId: String? = null,
	override val paymentType: PaymentType? = null,
	override val paid: Double? = null,
	override val payments: List<Payment>? = null,
	override val gnotionNihii: String? = null,
	override val gnotionSsin: String? = null,
	override val gnotionLastName: String? = null,
	override val gnotionFirstName: String? = null,
	override val gnotionCdHcParty: String? = null,
	override val invoicePeriod: Int? = null,
	override val careProviderType: String? = null,
	override val internshipNihii: String? = null,
	override val internshipSsin: String? = null,
	override val internshipLastName: String? = null,
	override val internshipFirstName: String? = null,
	override val internshipCdHcParty: String? = null,
	override val internshipCbe: String? = null,
	override val supervisorNihii: String? = null,
	override val supervisorSsin: String? = null,
	override val supervisorLastName: String? = null,
	override val supervisorFirstName: String? = null,
	override val supervisorCdHcParty: String? = null,
	override val supervisorCbe: String? = null,
	override val error: String? = null,
	override val encounterLocationName: String? = null,
	override val encounterLocationNihii: String? = null,
	override val encounterLocationNorm: Int? = null,
	override val longDelayJustification: Int? = null,
	override val correctiveInvoiceId: String? = null,
	override val correctedInvoiceId: String? = null,
	override val creditNote: Boolean? = null,
	override val creditNoteRelatedInvoiceId: String? = null,
	override val idDocument: IdentityDocumentReader? = null,
	override val admissionDate: Long? = null,
	override val locationNihii: String? = null,
	override val locationService: Int? = null,
	override val cancelReason: String? = null,
	override val cancelDate: Long? = null,
	override val options: Map<String, String> = emptyMap(),
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Invoice {
	// region Invoice-DecryptedInvoice
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedInvoice =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedInvoice(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val invoiceDate: Long? = null,
	override val sentDate: Long? = null,
	override val printedDate: Long? = null,
	override val invoicingCodes: List<EncryptedInvoicingCode> = emptyList(),
	override val receipts: Map<String, String> = emptyMap(),
	override val recipientType: String? = null,
	override val recipientId: String? = null,
	override val invoiceReference: String? = null,
	override val thirdPartyReference: String? = null,
	override val thirdPartyPaymentJustification: String? = null,
	override val thirdPartyPaymentReason: String? = null,
	override val reason: String? = null,
	override val invoiceType: InvoiceType? = null,
	override val sentMediumType: MediumType? = null,
	override val interventionType: InvoiceInterventionType? = null,
	override val groupId: String? = null,
	override val paymentType: PaymentType? = null,
	override val paid: Double? = null,
	override val payments: List<Payment>? = null,
	override val gnotionNihii: String? = null,
	override val gnotionSsin: String? = null,
	override val gnotionLastName: String? = null,
	override val gnotionFirstName: String? = null,
	override val gnotionCdHcParty: String? = null,
	override val invoicePeriod: Int? = null,
	override val careProviderType: String? = null,
	override val internshipNihii: String? = null,
	override val internshipSsin: String? = null,
	override val internshipLastName: String? = null,
	override val internshipFirstName: String? = null,
	override val internshipCdHcParty: String? = null,
	override val internshipCbe: String? = null,
	override val supervisorNihii: String? = null,
	override val supervisorSsin: String? = null,
	override val supervisorLastName: String? = null,
	override val supervisorFirstName: String? = null,
	override val supervisorCdHcParty: String? = null,
	override val supervisorCbe: String? = null,
	override val error: String? = null,
	override val encounterLocationName: String? = null,
	override val encounterLocationNihii: String? = null,
	override val encounterLocationNorm: Int? = null,
	override val longDelayJustification: Int? = null,
	override val correctiveInvoiceId: String? = null,
	override val correctedInvoiceId: String? = null,
	override val creditNote: Boolean? = null,
	override val creditNoteRelatedInvoiceId: String? = null,
	override val idDocument: IdentityDocumentReader? = null,
	override val admissionDate: Long? = null,
	override val locationNihii: String? = null,
	override val locationService: Int? = null,
	override val cancelReason: String? = null,
	override val cancelDate: Long? = null,
	override val options: Map<String, String> = emptyMap(),
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Invoice {
	// region Invoice-EncryptedInvoice
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedInvoice =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

public fun Invoice.copy(
	id: String = this.id,
	rev: String? = this.rev,
	created: Long? = this.created,
	modified: Long? = this.modified,
	author: String? = this.author,
	responsible: String? = this.responsible,
	medicalLocationId: String? = this.medicalLocationId,
	tags: Set<CodeStub> = this.tags,
	codes: Set<CodeStub> = this.codes,
	endOfLife: Long? = this.endOfLife,
	deletionDate: Long? = this.deletionDate,
	invoiceDate: Long? = this.invoiceDate,
	sentDate: Long? = this.sentDate,
	printedDate: Long? = this.printedDate,
	invoicingCodes: List<InvoicingCode> = this.invoicingCodes,
	receipts: Map<String, String> = this.receipts,
	recipientType: String? = this.recipientType,
	recipientId: String? = this.recipientId,
	invoiceReference: String? = this.invoiceReference,
	thirdPartyReference: String? = this.thirdPartyReference,
	thirdPartyPaymentJustification: String? = this.thirdPartyPaymentJustification,
	thirdPartyPaymentReason: String? = this.thirdPartyPaymentReason,
	reason: String? = this.reason,
	invoiceType: InvoiceType? = this.invoiceType,
	sentMediumType: MediumType? = this.sentMediumType,
	interventionType: InvoiceInterventionType? = this.interventionType,
	groupId: String? = this.groupId,
	paymentType: PaymentType? = this.paymentType,
	paid: Double? = this.paid,
	payments: List<Payment>? = this.payments,
	gnotionNihii: String? = this.gnotionNihii,
	gnotionSsin: String? = this.gnotionSsin,
	gnotionLastName: String? = this.gnotionLastName,
	gnotionFirstName: String? = this.gnotionFirstName,
	gnotionCdHcParty: String? = this.gnotionCdHcParty,
	invoicePeriod: Int? = this.invoicePeriod,
	careProviderType: String? = this.careProviderType,
	internshipNihii: String? = this.internshipNihii,
	internshipSsin: String? = this.internshipSsin,
	internshipLastName: String? = this.internshipLastName,
	internshipFirstName: String? = this.internshipFirstName,
	internshipCdHcParty: String? = this.internshipCdHcParty,
	internshipCbe: String? = this.internshipCbe,
	supervisorNihii: String? = this.supervisorNihii,
	supervisorSsin: String? = this.supervisorSsin,
	supervisorLastName: String? = this.supervisorLastName,
	supervisorFirstName: String? = this.supervisorFirstName,
	supervisorCdHcParty: String? = this.supervisorCdHcParty,
	supervisorCbe: String? = this.supervisorCbe,
	error: String? = this.error,
	encounterLocationName: String? = this.encounterLocationName,
	encounterLocationNihii: String? = this.encounterLocationNihii,
	encounterLocationNorm: Int? = this.encounterLocationNorm,
	longDelayJustification: Int? = this.longDelayJustification,
	correctiveInvoiceId: String? = this.correctiveInvoiceId,
	correctedInvoiceId: String? = this.correctedInvoiceId,
	creditNote: Boolean? = this.creditNote,
	creditNoteRelatedInvoiceId: String? = this.creditNoteRelatedInvoiceId,
	idDocument: IdentityDocumentReader? = this.idDocument,
	admissionDate: Long? = this.admissionDate,
	locationNihii: String? = this.locationNihii,
	locationService: Int? = this.locationService,
	cancelReason: String? = this.cancelReason,
	cancelDate: Long? = this.cancelDate,
	options: Map<String, String> = this.options,
	secretForeignKeys: Set<String> = this.secretForeignKeys,
	cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
	delegations: Map<String, Set<Delegation>> = this.delegations,
	encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
	encryptedSelf: Base64String? = this.encryptedSelf,
	securityMetadata: SecurityMetadata? = this.securityMetadata,
): Invoice {
	return when (this) {
		is DecryptedInvoice ->
			copy(
				id = id,
				rev = rev,
				created =
				created,
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
				printedDate =
				printedDate,
				invoicingCodes = invoicingCodes,
				receipts = receipts,
				recipientType =
				recipientType,
				recipientId = recipientId,
				invoiceReference = invoiceReference,
				thirdPartyReference = thirdPartyReference,
				thirdPartyPaymentJustification =
				thirdPartyPaymentJustification,
				thirdPartyPaymentReason = thirdPartyPaymentReason,
				reason =
				reason,
				invoiceType = invoiceType,
				sentMediumType = sentMediumType,
				interventionType =
				interventionType,
				groupId = groupId,
				paymentType = paymentType,
				paid = paid,
				payments =
				payments,
				gnotionNihii = gnotionNihii,
				gnotionSsin = gnotionSsin,
				gnotionLastName =
				gnotionLastName,
				gnotionFirstName = gnotionFirstName,
				gnotionCdHcParty = gnotionCdHcParty,
				invoicePeriod = invoicePeriod,
				careProviderType = careProviderType,
				internshipNihii =
				internshipNihii,
				internshipSsin = internshipSsin,
				internshipLastName = internshipLastName,
				internshipFirstName = internshipFirstName,
				internshipCdHcParty = internshipCdHcParty,
				internshipCbe = internshipCbe,
				supervisorNihii = supervisorNihii,
				supervisorSsin =
				supervisorSsin,
				supervisorLastName = supervisorLastName,
				supervisorFirstName =
				supervisorFirstName,
				supervisorCdHcParty = supervisorCdHcParty,
				supervisorCbe =
				supervisorCbe,
				error = error,
				encounterLocationName = encounterLocationName,
				encounterLocationNihii = encounterLocationNihii,
				encounterLocationNorm =
				encounterLocationNorm,
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
				cryptedForeignKeys =
				cryptedForeignKeys,
				delegations = delegations,
				encryptionKeys = encryptionKeys,
				encryptedSelf = encryptedSelf,
				securityMetadata = securityMetadata,
			)
		is EncryptedInvoice ->
			copy(
				id = id,
				rev = rev,
				created = created,
				modified = modified,
				author =
				author,
				responsible = responsible,
				medicalLocationId = medicalLocationId,
				tags = tags,
				codes = codes,
				endOfLife = endOfLife,
				deletionDate = deletionDate,
				invoiceDate =
				invoiceDate,
				sentDate = sentDate,
				printedDate = printedDate,
				invoicingCodes =
				invoicingCodes,
				receipts = receipts,
				recipientType = recipientType,
				recipientId =
				recipientId,
				invoiceReference = invoiceReference,
				thirdPartyReference =
				thirdPartyReference,
				thirdPartyPaymentJustification = thirdPartyPaymentJustification,
				thirdPartyPaymentReason = thirdPartyPaymentReason,
				reason = reason,
				invoiceType =
				invoiceType,
				sentMediumType = sentMediumType,
				interventionType = interventionType,
				groupId =
				groupId,
				paymentType = paymentType,
				paid = paid,
				payments = payments,
				gnotionNihii =
				gnotionNihii,
				gnotionSsin = gnotionSsin,
				gnotionLastName = gnotionLastName,
				gnotionFirstName = gnotionFirstName,
				gnotionCdHcParty = gnotionCdHcParty,
				invoicePeriod =
				invoicePeriod,
				careProviderType = careProviderType,
				internshipNihii = internshipNihii,
				internshipSsin = internshipSsin,
				internshipLastName = internshipLastName,
				internshipFirstName = internshipFirstName,
				internshipCdHcParty = internshipCdHcParty,
				internshipCbe = internshipCbe,
				supervisorNihii = supervisorNihii,
				supervisorSsin =
				supervisorSsin,
				supervisorLastName = supervisorLastName,
				supervisorFirstName =
				supervisorFirstName,
				supervisorCdHcParty = supervisorCdHcParty,
				supervisorCbe =
				supervisorCbe,
				error = error,
				encounterLocationName = encounterLocationName,
				encounterLocationNihii = encounterLocationNihii,
				encounterLocationNorm =
				encounterLocationNorm,
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
				cryptedForeignKeys =
				cryptedForeignKeys,
				delegations = delegations,
				encryptionKeys = encryptionKeys,
				encryptedSelf = encryptedSelf,
				securityMetadata = securityMetadata,
			)
	}
}
