package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByHcPartyAndIdentifiersFilter")
@Serializable
public data class PatientByHcPartyAndIdentifiersFilter(
  public val healthcarePartyId: String? = null,
  public val identifiers: List<Identifier> = emptyList(),
  override val desc: String? = null,
) : AbstractFilter<Patient>
