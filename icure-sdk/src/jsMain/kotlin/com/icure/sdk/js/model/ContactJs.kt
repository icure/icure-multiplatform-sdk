// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.AnnotationJs
import com.icure.sdk.js.model.embed.DecryptedServiceJs
import com.icure.sdk.js.model.embed.DecryptedSubContactJs
import com.icure.sdk.js.model.embed.EncryptableJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.EncryptedSubContactJs
import com.icure.sdk.js.model.embed.SecurityMetadataJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.embed.SubContactJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Contact")
public sealed external interface ContactJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val identifier: Array<out IdentifierJs>

	public val groupId: String?

	public val openingDate: Double?

	public val closingDate: Double?

	public val descr: String?

	public val location: String?

	public val externalId: String?

	public val encounterType: CodeStubJs?

	public val subContacts: Array<out SubContactJs>

	public val services: Array<out ServiceJs>

	public val healthcarePartyId: String?

	public val modifiedContactId: String?

	public val notes: Array<out AnnotationJs>

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedContact")
public external class DecryptedContactJs(
	partial: dynamic,
) : ContactJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val identifier: Array<IdentifierJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val groupId: String?

	override val openingDate: Double?

	override val closingDate: Double?

	override val descr: String?

	override val location: String?

	override val externalId: String?

	override val encounterType: CodeStubJs?

	override val subContacts: Array<DecryptedSubContactJs>

	override val services: Array<DecryptedServiceJs>

	override val healthcarePartyId: String?

	override val modifiedContactId: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val notes: Array<AnnotationJs>

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedContact")
public external class EncryptedContactJs(
	partial: dynamic,
) : ContactJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val identifier: Array<IdentifierJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val groupId: String?

	override val openingDate: Double?

	override val closingDate: Double?

	override val descr: String?

	override val location: String?

	override val externalId: String?

	override val encounterType: CodeStubJs?

	override val subContacts: Array<EncryptedSubContactJs>

	override val services: Array<EncryptedServiceJs>

	override val healthcarePartyId: String?

	override val modifiedContactId: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val notes: Array<AnnotationJs>

	override val isEncrypted: Boolean

	override val ktClass: String
}
