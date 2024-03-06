package com.icure.sdk.model.embed

import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Valorisation(
  public val startOfValidity: Long? = null,
  public val endOfValidity: Long? = null,
  public val predicate: String? = null,
  public val reference: List<Int>? = null,
  public val totalAmount: Double? = null,
  public val reimbursement: Double? = null,
  public val patientIntervention: Double? = null,
  public val doctorSupplement: Double? = null,
  public val vat: Double? = null,
  public val label: Map<String, String>? = null,
  override val encryptedSelf: String? = null,
) : Encrypted, IoSerializable
