package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByHcPartyDateOfBirthFilter")
@Serializable
public data class PatientByHcPartyDateOfBirthFilter(
  override val desc: String? = null,
  public val dateOfBirth: Int,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
