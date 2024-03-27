package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyDateOfBirthBetweenFilter")
@Serializable
data class PatientByHcPartyDateOfBirthBetweenFilter(
    override val desc: String? = null,
    public val minDateOfBirth: Int? = null,
    public val maxDateOfBirth: Int? = null,
    public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
