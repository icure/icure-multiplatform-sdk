package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class PatientByHcPartyGenderEducationProfession(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val gender: Gender? = null,
  public val education: String? = null,
  public val profession: String? = null,
) : AbstractFilter<Patient>
