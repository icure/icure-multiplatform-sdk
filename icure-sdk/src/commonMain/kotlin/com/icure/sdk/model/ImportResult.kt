package com.icure.sdk.model

import com.icure.sdk.model.base.MimeAttachment
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ImportResult(
	public val patient: Patient? = null,
	public val hes: List<HealthElement> = emptyList(),
	public val ctcs: List<Contact> = emptyList(),
	public val warnings: List<String> = emptyList(),
	public val errors: List<String> = emptyList(),
	public val forms: List<Form> = emptyList(),
	public val hcps: List<HealthcareParty> = emptyList(),
	public val documents: List<Document> = emptyList(),
	public val attachments: Map<String, MimeAttachment> = emptyMap(),
) {
	// region ImportResult-ImportResult

	// endregion
}
