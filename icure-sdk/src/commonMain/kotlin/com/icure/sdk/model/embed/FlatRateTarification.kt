package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface FlatRateTarification : Encryptable {
    public val code: String?

    public val flatRateType: FlatRateType?

    public val label: Map<String, String>?

    public val valorisations: List<Valorisation>

    override val encryptedSelf: Base64String?
	// region FlatRateTarification-FlatRateTarification

	// endregion
}

@Serializable
data class DecryptedFlatRateTarification(
    override val code: String? = null,
    override val flatRateType: FlatRateType? = null,
    override val label: Map<String, String>? = null,
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
    override val valorisations: List<EncryptedValorisation> = emptyList(),
    override val encryptedSelf: Base64String? = null,
) : FlatRateTarification {
	// region FlatRateTarification-EncryptedFlatRateTarification

	// endregion
}

public fun FlatRateTarification.copy(
    code: String? = this.code,
    flatRateType: FlatRateType? = this.flatRateType,
    label: Map<String, String>? = this.label,
    valorisations: List<Valorisation> = this.valorisations,
    encryptedSelf: Base64String? = this.encryptedSelf,
): FlatRateTarification {
    return when (this) {
        is DecryptedFlatRateTarification ->
            copy(
                code = code,
                flatRateType = flatRateType,
                label = label,
                valorisations = valorisations,
                encryptedSelf =
                encryptedSelf,
            )
        is EncryptedFlatRateTarification ->
            copy(
                code = code,
                flatRateType = flatRateType,
                label =
                label,
                valorisations = valorisations,
                encryptedSelf = encryptedSelf,
            )
    }
}
