// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Address")
public sealed external interface AddressJs : EncryptableJs {
	public val addressType: String?

	public val descr: String?

	public val street: String?

	public val houseNumber: String?

	public val postboxNumber: String?

	public val postalCode: String?

	public val city: String?

	public val state: String?

	public val country: String?

	public val note: String?

	public val notes: Array<out AnnotationJs>

	public val telecoms: Array<out TelecomJs>

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedAddress")
public external class DecryptedAddressJs(
	partial: dynamic,
) : AddressJs {
	override val addressType: String?

	override val descr: String?

	override val street: String?

	override val houseNumber: String?

	override val postboxNumber: String?

	override val postalCode: String?

	override val city: String?

	override val state: String?

	override val country: String?

	override val note: String?

	override val notes: Array<AnnotationJs>

	override val telecoms: Array<DecryptedTelecomJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedAddress")
public external class EncryptedAddressJs(
	partial: dynamic,
) : AddressJs {
	override val addressType: String?

	override val descr: String?

	override val street: String?

	override val houseNumber: String?

	override val postboxNumber: String?

	override val postalCode: String?

	override val city: String?

	override val state: String?

	override val country: String?

	override val note: String?

	override val notes: Array<AnnotationJs>

	override val telecoms: Array<EncryptedTelecomJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
