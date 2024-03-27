package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.KeywordSubword
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Keyword(
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
    public val `value`: String? = null,
    public val subWords: Set<KeywordSubword> = emptySet(),
    public val userId: String? = null,
) : StoredDocument, ICureDocument<String> {
    // region Keyword-Keyword

    // endregion
}
