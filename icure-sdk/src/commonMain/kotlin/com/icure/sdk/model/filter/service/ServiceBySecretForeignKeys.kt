package com.icure.sdk.model.filter.service

import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("ServiceBySecretForeignKeys")
@Serializable
public data class ServiceBySecretForeignKeys(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val patientSecretForeignKeys: Set<String> = emptySet(),
) : AbstractFilter<Service>
