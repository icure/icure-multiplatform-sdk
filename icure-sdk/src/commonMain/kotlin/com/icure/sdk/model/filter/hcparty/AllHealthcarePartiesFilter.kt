package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class AllHealthcarePartiesFilter(
  override val desc: String? = null,
) : AbstractFilter<HealthcareParty>, Filter.AllFilter<HealthcareParty>
