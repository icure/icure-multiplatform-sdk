package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.CodeStubDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.CareTeamMemberTypeDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.Base64StringDto
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface CareTeamMember : Encryptable, Identifiable<String> {
	override val id: String

	public val careTeamMemberType: CareTeamMemberTypeDto?

	public val healthcarePartyId: String?

	public val quality: CodeStubDto?

	override val encryptedSelf: Base64StringDto?
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
