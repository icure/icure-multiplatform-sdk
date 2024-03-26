package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByHcPartyAndAddressFilter")
@Serializable
public data class PatientByHcPartyAndAddressFilter(
  override val desc: String? = null,
  public val searchString: String? = null,
  public val healthcarePartyId: String? = null,
  public val postalCode: String? = null,
  public val houseNumber: String? = null,
) : AbstractFilter<Patient>
