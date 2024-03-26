package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByHcPartyAndActiveFilter")
@Serializable
public data class PatientByHcPartyAndActiveFilter(
  override val desc: String? = null,
  public val active: Boolean,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
