package com.icure.sdk.model

import com.icure.sdk.model.base.MimeAttachment
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class ImportResult(
  public val patient: Patient? = null,
  public val hes: List<HealthElement> = emptyList(),
  public val ctcs: List<Contact> = emptyList(),
  public val warnings: List<String> = emptyList(),
  public val errors: List<String> = emptyList(),
  public val forms: List<Form> = emptyList(),
  public val hcps: List<HealthcareParty> = emptyList(),
  public val documents: List<Document> = emptyList(),
  public val attachments: Map<String, MimeAttachment> = emptyMap(),
)
