package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.embed.FlatRateTypeDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.ValorisationDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.Base64StringDto
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface FlatRateTarification : Encryptable {
	public val code: String?

	public val flatRateType: FlatRateTypeDto?

	public val label: Map<String, String>?

	public val valorisations: List<ValorisationDto>

	override val encryptedSelf: Base64StringDto?
	// region FlatRateTarification-FlatRateTarification

	// endregion
}

@Serializable
data class DecryptedFlatRateTarification(
	override val code: String? = null,
	override val flatRateType: FlatRateType? = null,
	override val label: Map<String, String>? = null,
	@DefaultValue("emptyList()")
	override val valorisations: List<DecryptedValorisation> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : FlatRateTarification {
	// region FlatRateTarification-DecryptedFlatRateTarification

	// endregion
}

@Serializable
data class EncryptedFlatRateTarification(
	override val code: String? = null,
	override val flatRateType: FlatRateType? = null,
	override val label: Map<String, String>? = null,
	@DefaultValue("emptyList()")
	override val valorisations: List<EncryptedValorisation> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : FlatRateTarification {
	// region FlatRateTarification-EncryptedFlatRateTarification

	// endregion
}
