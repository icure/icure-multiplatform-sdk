package com.icure.sdk.model

import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class DatabaseInitialisation(
  public val users: List<User>? = null,
  public val healthcareParties: List<HealthcareParty>? = null,
  public val replication: Replication? = null,
  public val minimumKrakenVersion: String? = null,
) : IoSerializable
