package com.icure.sdk.model.filter.healthelement

import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class HealthElementByHcPartySecretForeignKeysFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val patientSecretForeignKeys: Set<String> = emptySet(),
) : AbstractFilter<HealthElement>
