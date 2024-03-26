package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByHcPartyDateOfBirthBetweenFilter")
@Serializable
public data class PatientByHcPartyDateOfBirthBetweenFilter(
  override val desc: String? = null,
  public val minDateOfBirth: Int? = null,
  public val maxDateOfBirth: Int? = null,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
