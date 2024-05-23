// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.CryptoActorJs
import com.icure.sdk.js.model.base.HasTagsJs
import com.icure.sdk.js.model.base.VersionableJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("CryptoActorStub")
public external class CryptoActorStubJs(
	partial: dynamic,
) : VersionableJs<String>, CryptoActorJs, HasTagsJs {
	override val id: String

	override val rev: String

	override val hcPartyKeys: dynamic

	override val aesExchangeKeys: dynamic

	override val transferKeys: dynamic

	override val privateKeyShamirPartitions: dynamic

	override val publicKey: String?

	override val publicKeysForOaepWithSha256: Array<String>

	override val tags: Array<CodeStubJs>
}
