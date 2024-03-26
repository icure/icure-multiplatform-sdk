package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("PatientByIdsFilter")
@Serializable
public data class PatientByIdsFilter(
  override val ids: Set<String> = emptySet(),
  override val desc: String? = null,
) : AbstractFilter<Patient>, Filter.IdsFilter<String, Patient>
