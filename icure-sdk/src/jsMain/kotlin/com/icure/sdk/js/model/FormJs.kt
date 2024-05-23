// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.EncryptableJs
import com.icure.sdk.js.model.embed.SecurityMetadataJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Form")
public sealed external interface FormJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val openingDate: Double?

	public val status: String?

	public val version: Double?

	public val logicalUuid: String?

	public val descr: String?

	public val uniqueId: String?

	public val formTemplateId: String?

	public val contactId: String?

	public val healthElementId: String?

	public val planOfActionId: String?

	public val parent: String?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedForm")
public external class DecryptedFormJs(
	partial: dynamic,
) : FormJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val openingDate: Double?

	override val status: String?

	override val version: Double?

	override val logicalUuid: String?

	override val descr: String?

	override val uniqueId: String?

	override val formTemplateId: String?

	override val contactId: String?

	override val healthElementId: String?

	override val planOfActionId: String?

	override val parent: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedForm")
public external class EncryptedFormJs(
	partial: dynamic,
) : FormJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val openingDate: Double?

	override val status: String?

	override val version: Double?

	override val logicalUuid: String?

	override val descr: String?

	override val uniqueId: String?

	override val formTemplateId: String?

	override val contactId: String?

	override val healthElementId: String?

	override val planOfActionId: String?

	override val parent: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}
