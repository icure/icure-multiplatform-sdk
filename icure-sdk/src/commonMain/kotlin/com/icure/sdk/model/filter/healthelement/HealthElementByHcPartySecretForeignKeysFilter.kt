package com.icure.sdk.model.filter.healthelement

import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartySecretForeignKeysFilter")
@Serializable
data class HealthElementByHcPartySecretForeignKeysFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	@DefaultValue("emptySet()")
	public val patientSecretForeignKeys: Set<String> = emptySet(),
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartySecretForeignKeysFilter-HealthElementByHcPartySecretForeignKeysFilter

	// endregion
}
