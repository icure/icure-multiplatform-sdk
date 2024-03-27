package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PatientHealthCarePartyType() {
    @SerialName("doctor")
    Doctor,

    @SerialName("referral")
    Referral,

    @SerialName("medicalhouse")
    Medicalhouse,

    @SerialName("retirementhome")
    Retirementhome,

    @SerialName("hospital")
    Hospital,

    @SerialName("other")
    Other,

    @SerialName("referringphysician")
    Referringphysician,

    @SerialName("managingorganization")
    Managingorganization,
}
