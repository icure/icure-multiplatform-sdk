// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.EncryptableJs
import com.icure.sdk.js.model.embed.SecurityMetadataJs
import com.icure.sdk.js.model.embed.TimeTableItemJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("TimeTable")
public sealed external interface TimeTableJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val name: String?

	public val agendaId: String?

	public val startTime: Double?

	public val endTime: Double?

	public val items: Array<out TimeTableItemJs>

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedTimeTable")
public external class DecryptedTimeTableJs(
	partial: dynamic,
) : TimeTableJs {
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

	override val name: String?

	override val agendaId: String?

	override val startTime: Double?

	override val endTime: Double?

	override val items: Array<TimeTableItemJs>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedTimeTable")
public external class EncryptedTimeTableJs(
	partial: dynamic,
) : TimeTableJs {
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

	override val name: String?

	override val agendaId: String?

	override val startTime: Double?

	override val endTime: Double?

	override val items: Array<TimeTableItemJs>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}
