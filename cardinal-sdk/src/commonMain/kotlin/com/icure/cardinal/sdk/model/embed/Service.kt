package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.CodeStubDto
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifierDto
import org.taktik.icure.services.`external`.rest.v2.dto.base.LinkQualificationDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.AnnotationDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.ContentDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.SecurityMetadataDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.Base64StringDto
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Service : Encryptable, ICureDocument<String> {
	override val id: String

	public val transactionId: String?

	public val identifier: List<IdentifierDto>

	public val contactId: String?

	public val subContactIds: Set<String>?

	public val plansOfActionIds: Set<String>?

	public val healthElementsIds: Set<String>?

	public val formIds: Set<String>?

	public val secretForeignKeys: Set<String>?

	public val cryptedForeignKeys: Map<String, Set<DelegationDto>>

	public val delegations: Map<String, Set<DelegationDto>>

	public val encryptionKeys: Map<String, Set<DelegationDto>>

	public val label: String?

	public val index: Long?

	public val content: Map<String, ContentDto>

	public val encryptedContent: String?

	public val textIndexes: Map<String, String>

	public val valueDate: Long?

	public val openingDate: Long?

	public val closingDate: Long?

	public val formId: String?

	override val created: Long?

	override val modified: Long?

	override val endOfLife: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	public val comment: String?

	public val status: Int?

	public val invoicingCodes: Set<String>

	public val notes: List<AnnotationDto>

	public val qualifiedLinks: Map<LinkQualificationDto, Map<String, String>>

	override val codes: Set<CodeStubDto>

	override val tags: Set<CodeStubDto>

	override val encryptedSelf: Base64StringDto?

	public val securityMetadata: SecurityMetadataDto?
	// region Service-Service
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.embed.Service"
	}
	// endregion
}

@Serializable
data class DecryptedService(
	override val id: String,
	override val transactionId: String? = null,
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val contactId: String? = null,
	override val subContactIds: Set<String>? = null,
	override val plansOfActionIds: Set<String>? = null,
	override val healthElementsIds: Set<String>? = null,
	override val formIds: Set<String>? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String>? = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val label: String? = null,
	override val index: Long? = null,
	@DefaultValue("emptyMap()")
	override val content: Map<String, DecryptedContent> = emptyMap(),
	override val encryptedContent: String? = null,
	@DefaultValue("emptyMap()")
	override val textIndexes: Map<String, String> = emptyMap(),
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val formId: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val endOfLife: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val comment: String? = null,
	override val status: Int? = null,
	@DefaultValue("emptySet()")
	override val invoicingCodes: Set<String> = emptySet(),
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("emptyMap()")
	override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Service {
	// region Service-DecryptedService

	// endregion
}

@Serializable
data class EncryptedService(
	override val id: String,
	override val transactionId: String? = null,
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val contactId: String? = null,
	override val subContactIds: Set<String>? = null,
	override val plansOfActionIds: Set<String>? = null,
	override val healthElementsIds: Set<String>? = null,
	override val formIds: Set<String>? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String>? = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val label: String? = null,
	override val index: Long? = null,
	@DefaultValue("emptyMap()")
	override val content: Map<String, EncryptedContent> = emptyMap(),
	override val encryptedContent: String? = null,
	@DefaultValue("emptyMap()")
	override val textIndexes: Map<String, String> = emptyMap(),
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val formId: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val endOfLife: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val comment: String? = null,
	override val status: Int? = null,
	@DefaultValue("emptySet()")
	override val invoicingCodes: Set<String> = emptySet(),
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("emptyMap()")
	override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Service {
	// region Service-EncryptedService

	// endregion
}
