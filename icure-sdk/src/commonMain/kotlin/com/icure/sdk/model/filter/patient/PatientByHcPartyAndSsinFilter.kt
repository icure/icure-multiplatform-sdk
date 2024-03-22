package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByHcPartyAndSsinFilter")
@Serializable
public data class PatientByHcPartyAndSsinFilter(
  override val desc: String? = null,
  public val ssin: String,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
