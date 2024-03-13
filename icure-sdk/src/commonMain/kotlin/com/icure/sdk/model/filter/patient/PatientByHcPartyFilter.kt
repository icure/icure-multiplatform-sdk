package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class PatientByHcPartyFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
