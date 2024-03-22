package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyAndSsinsFilter")
@Serializable
data class PatientByHcPartyAndSsinsFilter(
  override val desc: String? = null,
  public val ssins: List<String>? = null,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndSsinsFilter-PatientByHcPartyAndSsinsFilter
	// endregion
}