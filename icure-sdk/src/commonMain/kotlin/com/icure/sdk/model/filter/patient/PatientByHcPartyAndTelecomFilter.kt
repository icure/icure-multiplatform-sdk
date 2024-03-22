package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByHcPartyAndTelecomFilter")
@Serializable
public data class PatientByHcPartyAndTelecomFilter(
  override val desc: String? = null,
  public val searchString: String? = null,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
