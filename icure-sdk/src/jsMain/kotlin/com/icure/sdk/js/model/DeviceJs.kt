// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.CryptoActorJs
import com.icure.sdk.js.model.base.DataOwnerJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.NamedJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Device")
public external class DeviceJs(
	partial: dynamic,
) : StoredDocumentJs, ICureDocumentJs<String>, NamedJs, CryptoActorJs, DataOwnerJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val identifiers: Array<IdentifierJs>

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val medicalLocationId: String?

	public val externalId: String?

	override val name: String?

	public val type: String?

	public val brand: String?

	public val model: String?

	public val serialNumber: String?

	public val parentId: String?

	public val picture: ByteArray?

	override val properties: Array<DecryptedPropertyStubJs>

	override val hcPartyKeys: dynamic

	override val aesExchangeKeys: dynamic

	override val transferKeys: dynamic

	override val privateKeyShamirPartitions: dynamic

	override val publicKey: String?

	override val publicKeysForOaepWithSha256: Array<String>

	override val ktClass: String
}
