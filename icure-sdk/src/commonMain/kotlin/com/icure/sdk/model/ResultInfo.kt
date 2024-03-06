package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Service
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public class ResultInfo(
  public val ssin: String? = null,
  public val lastName: String? = null,
  public val firstName: String? = null,
  public val dateOfBirth: Long? = null,
  public val sex: String? = null,
  public val documentId: String? = null,
  public val protocol: String? = null,
  public val complete: Boolean? = null,
  public val demandDate: Long? = null,
  public val labo: String? = null,
  public val engine: String? = null,
  public val codes: Set<CodeStub> = emptySet(),
  public val services: List<Service>? = null,
)
