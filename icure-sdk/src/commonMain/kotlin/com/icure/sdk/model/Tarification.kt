package com.icure.sdk.model

import com.icure.sdk.model.base.AppendixType
import com.icure.sdk.model.base.CodeFlag
import com.icure.sdk.model.base.CodeIdentification
import com.icure.sdk.model.base.LinkQualification
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.DecryptedValorisation
import com.icure.sdk.model.embed.LetterValue
import com.icure.sdk.model.embed.Periodicity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.sdk.model.embed.Valorisation

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Tarification(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	override val label: Map<String, String>? = null,
	override val context: String? = null,
	override val type: String? = null,
	override val code: String? = null,
	override val version: String? = null,
	public val author: String? = null,
	public val regions: Set<String> = emptySet(),
	public val periodicity: List<Periodicity> = emptyList(),
	public val level: Int? = null,
	public val links: List<String> = emptyList(),
	public val qualifiedLinks: Map<LinkQualification, List<String>> = emptyMap(),
	public val flags: Set<CodeFlag> = emptySet(),
	public val searchTerms: Map<String, Set<String>> = emptyMap(),
	public val `data`: String? = null,
	public val appendices: Map<AppendixType, String> = emptyMap(),
	public val disabled: Boolean,
	public val valorisations: Set<DecryptedValorisation> = emptySet(),
	public val category: Map<String, String> = emptyMap(),
	public val consultationCode: Boolean? = null,
	public val hasRelatedCode: Boolean? = null,
	public val needsPrescriber: Boolean? = null,
	public val relatedCodes: Set<String> = emptySet(),
	@SerialName("nGroup")
	public val ngroup: String? = null,
	public val letterValues: List<LetterValue> = emptyList(),
) : StoredDocument, CodeIdentification<K> {
	// region Tarification-Tarification

	// endregion
}
