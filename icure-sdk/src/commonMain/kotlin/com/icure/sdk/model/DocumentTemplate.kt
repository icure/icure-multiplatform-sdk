package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.ReportVersion
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.DocumentGroup
import com.icure.sdk.model.embed.DocumentType
import kotlinx.serialization.Serializable
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DocumentTemplate(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	public val attachment: ByteArray? = null,
	public val documentType: DocumentType? = null,
	public val mainUti: String? = null,
	public val name: String? = null,
	public val otherUtis: Set<String> = emptySet(),
	public val attachmentId: String? = null,
	public val version: ReportVersion? = null,
	public val owner: String? = null,
	public val guid: String? = null,
	public val group: DocumentGroup? = null,
	public val descr: String? = null,
	public val disabled: String? = null,
	public val specialty: CodeStub? = null,
) : StoredDocument, ICureDocument<T> {
	// region DocumentTemplate-DocumentTemplate

	// endregion
}
