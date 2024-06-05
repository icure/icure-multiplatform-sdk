// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.IdentifiableJs
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CareTeamMember")
public sealed external interface CareTeamMemberJs : EncryptableJs, IdentifiableJs<String> {
	public val careTeamMemberType: String?

	public val healthcarePartyId: String?

	public val quality: CodeStubJs?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedCareTeamMember")
public external class DecryptedCareTeamMemberJs(
	partial: dynamic,
) : CareTeamMemberJs {
	override val id: String

	override val careTeamMemberType: String?

	override val healthcarePartyId: String?

	override val quality: CodeStubJs?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedCareTeamMember")
public external class EncryptedCareTeamMemberJs(
	partial: dynamic,
) : CareTeamMemberJs {
	override val id: String

	override val careTeamMemberType: String?

	override val healthcarePartyId: String?

	override val quality: CodeStubJs?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
