package com.icure.sdk.model

import com.icure.sdk.model.embed.Address
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AppointmentTypeAndPlace(
    public val calendarItemTypeId: String,
    public val name: String? = null,
    public val color: String? = null,
    public val duration: Int = 0,
    public val subjectByLanguage: Map<String, String>? = null,
    public val placeId: String? = null,
    public val address: Address? = null,
    public val acceptsNewPatients: Boolean,
)
