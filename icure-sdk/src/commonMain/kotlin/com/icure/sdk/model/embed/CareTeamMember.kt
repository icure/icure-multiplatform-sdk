package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface CareTeamMember : Encryptable, Identifiable<String> {
	override val id: String

	public val careTeamMemberType: CareTeamMemberType?

	public val healthcarePartyId: String?

	public val quality: CodeStub?

	override val encryptedSelf: Base64String?
	// region CareTeamMember-CareTeamMember

	// endregion
}

@Serializable
data class DecryptedCareTeamMember(
	override val id: String,
	override val careTeamMemberType: CareTeamMemberType? = null,
	override val healthcarePartyId: String? = null,
	override val quality: CodeStub? = null,
	override val encryptedSelf: Base64String? = null,
) : CareTeamMember {
	// region CareTeamMember-DecryptedCareTeamMember

	// endregion
}

@Serializable
data class EncryptedCareTeamMember(
	override val id: String,
	override val careTeamMemberType: CareTeamMemberType? = null,
	override val healthcarePartyId: String? = null,
	override val quality: CodeStub? = null,
	override val encryptedSelf: Base64String? = null,
) : CareTeamMember {
	// region CareTeamMember-EncryptedCareTeamMember

	// endregion
}
