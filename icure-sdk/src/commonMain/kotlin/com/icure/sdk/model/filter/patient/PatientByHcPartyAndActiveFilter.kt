package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyAndActiveFilter")
@Serializable
data class PatientByHcPartyAndActiveFilter(
    override val desc: String? = null,
    public val active: Boolean,
    public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
