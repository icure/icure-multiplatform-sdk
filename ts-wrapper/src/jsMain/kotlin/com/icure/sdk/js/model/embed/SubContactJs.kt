// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("SubContact")
public sealed external interface SubContactJs : EncryptableJs, ICureDocumentJs<String?> {
	public val descr: String?

	public val protocol: String?

	public val status: Double?

	public val formId: String?

	public val planOfActionId: String?

	public val healthElementId: String?

	public val classificationId: String?

	public val services: Array<out ServiceLinkJs>

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedSubContact")
public external class DecryptedSubContactJs(
	partial: dynamic,
) : SubContactJs {
	override val id: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val descr: String?

	override val protocol: String?

	override val status: Double?

	override val formId: String?

	override val planOfActionId: String?

	override val healthElementId: String?

	override val classificationId: String?

	override val services: Array<ServiceLinkJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedSubContact")
public external class EncryptedSubContactJs(
	partial: dynamic,
) : SubContactJs {
	override val id: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val descr: String?

	override val protocol: String?

	override val status: Double?

	override val formId: String?

	override val planOfActionId: String?

	override val healthElementId: String?

	override val classificationId: String?

	override val services: Array<ServiceLinkJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
