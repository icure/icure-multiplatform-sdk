package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByHcPartyAndExternalIdFilter")
@Serializable
public data class PatientByHcPartyAndExternalIdFilter(
  override val desc: String? = null,
  public val externalId: String? = null,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
