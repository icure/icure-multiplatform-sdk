// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CareTeamMembership")
public sealed external interface CareTeamMembershipJs : EncryptableJs {
	public val startDate: Double?

	public val endDate: Double?

	public val careTeamMemberId: String?

	public val membershipType: String?

	public val isEncrypted: Boolean
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
}
