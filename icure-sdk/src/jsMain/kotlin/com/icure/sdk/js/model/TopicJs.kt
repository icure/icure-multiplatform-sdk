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

@JsName("Topic")
public sealed external interface TopicJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val healthElementId: String?

	public val contactId: String?

	public val description: String?

	public val activeParticipants: dynamic

	public val linkedHealthElements: Array<out String>

	public val linkedServices: Array<out String>

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedTopic")
public external class DecryptedTopicJs(
	partial: dynamic,
) : TopicJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val healthElementId: String?

	override val contactId: String?

	override val description: String?

	override val codes: Array<CodeStubJs>

	override val tags: Array<CodeStubJs>

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val activeParticipants: dynamic

	override val securityMetadata: SecurityMetadataJs?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val linkedHealthElements: Array<String>

	override val linkedServices: Array<String>

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedTopic")
public external class EncryptedTopicJs(
	partial: dynamic,
) : TopicJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val healthElementId: String?

	override val contactId: String?

	override val description: String?

	override val codes: Array<CodeStubJs>

	override val tags: Array<CodeStubJs>

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val activeParticipants: dynamic

	override val securityMetadata: SecurityMetadataJs?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val linkedHealthElements: Array<String>

	override val linkedServices: Array<String>

	override val isEncrypted: Boolean

	override val ktClass: String
}
