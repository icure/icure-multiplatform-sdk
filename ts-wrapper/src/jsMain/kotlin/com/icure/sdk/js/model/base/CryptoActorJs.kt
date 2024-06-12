// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.base

import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CryptoActor")
public external interface CryptoActorJs : VersionableJs<String>, HasTagsJs {
	public val hcPartyKeys: Record<String, out Array<out String>>

	public val aesExchangeKeys: Record<String, out Record<String, out Record<String, out String>>>

	public val transferKeys: Record<String, out Record<String, out String>>

	public val privateKeyShamirPartitions: Record<String, out String>

	public val publicKey: String?

	public val publicKeysForOaepWithSha256: Array<out String>

	@JsName("${'$'}ktClass")
	public val ktClass: String
}
