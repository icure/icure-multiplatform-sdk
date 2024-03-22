package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ParagraphAgreement(
  public val timestamp: Long? = null,
  public val paragraph: String? = null,
  public val accepted: Boolean? = null,
  public val inTreatment: Boolean? = null,
  public val canceled: Boolean? = null,
  public val careProviderReference: String? = null,
  public val decisionReference: String? = null,
  public val start: Long? = null,
  public val end: Long? = null,
  public val cancelationDate: Long? = null,
  public val quantityValue: Double? = null,
  public val quantityUnit: String? = null,
  public val ioRequestReference: String? = null,
  public val responseType: String? = null,
  public val refusalJustification: Map<String, String>? = null,
  public val verses: Set<Long>? = null,
  public val coverageType: String? = null,
  public val unitNumber: Double? = null,
  public val strength: Double? = null,
  public val strengthUnit: String? = null,
  public val agreementAppendices: List<AgreementAppendix>? = null,
  public val documentId: String? = null,
) {
	// region ParagraphAgreement-ParagraphAgreement
	// endregion
}