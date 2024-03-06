package com.icure.sdk.model.filter.service

import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class ServiceByHcPartyTagCodeDateFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val patientSecretForeignKey: String? = null,
  public val tagType: String? = null,
  public val tagCode: String? = null,
  public val codeType: String? = null,
  public val codeCode: String? = null,
  public val startValueDate: Long? = null,
  public val endValueDate: Long? = null,
  public val descending: Boolean,
) : AbstractFilter<Service>
