// auto-generated file
package com.icure.sdk.js.model.base

import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("CryptoActor")
public external interface CryptoActorJs : VersionableJs<String>, HasTagsJs {
	public val hcPartyKeys: dynamic

	public val aesExchangeKeys: dynamic

	public val transferKeys: dynamic

	public val privateKeyShamirPartitions: dynamic

	public val publicKey: String?

	public val publicKeysForOaepWithSha256: Array<out String>
}
