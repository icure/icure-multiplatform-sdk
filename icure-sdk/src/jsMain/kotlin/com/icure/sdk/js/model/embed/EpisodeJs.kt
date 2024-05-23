// auto-generated file
package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.js.model.base.NamedJs
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Episode")
public sealed external interface EpisodeJs : EncryptableJs, IdentifiableJs<String>, NamedJs {
	public val comment: String?

	public val startDate: Double?

	public val endDate: Double?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedEpisode")
public external class DecryptedEpisodeJs(
	partial: dynamic,
) : EpisodeJs {
	override val id: String

	override val name: String?

	override val comment: String?

	override val startDate: Double?

	override val endDate: Double?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedEpisode")
public external class EncryptedEpisodeJs(
	partial: dynamic,
) : EpisodeJs {
	override val id: String

	override val name: String?

	override val comment: String?

	override val startDate: Double?

	override val endDate: Double?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
