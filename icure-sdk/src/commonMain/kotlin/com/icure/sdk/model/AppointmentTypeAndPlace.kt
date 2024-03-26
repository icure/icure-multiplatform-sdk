package com.icure.sdk.model

import com.icure.sdk.model.embed.Address
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class AppointmentTypeAndPlace(
  public val calendarItemTypeId: String,
  public val name: String? = null,
  public val color: String? = null,
  public val duration: Int = 0,
  public val subjectByLanguage: Map<String, String>? = null,
  public val placeId: String? = null,
  public val address: Address? = null,
  public val acceptsNewPatients: Boolean,
)
