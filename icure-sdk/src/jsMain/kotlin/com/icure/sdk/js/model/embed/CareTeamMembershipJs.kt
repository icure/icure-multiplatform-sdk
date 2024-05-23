// auto-generated file
package com.icure.sdk.js.model.embed

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("CareTeamMembership")
public sealed external interface CareTeamMembershipJs : EncryptableJs {
	public val startDate: Double?

	public val endDate: Double?

	public val careTeamMemberId: String?

	public val membershipType: String?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedCareTeamMembership")
public external class DecryptedCareTeamMembershipJs(
	partial: dynamic,
) : CareTeamMembershipJs {
	override val startDate: Double?

	override val endDate: Double?

	override val careTeamMemberId: String?

	override val membershipType: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedCareTeamMembership")
public external class EncryptedCareTeamMembershipJs(
	partial: dynamic,
) : CareTeamMembershipJs {
	override val startDate: Double?

	override val endDate: Double?

	override val careTeamMemberId: String?

	override val membershipType: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
