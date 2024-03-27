package com.icure.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AgreementAppendix(
    public val docSeq: Int? = null,
    public val verseSeq: Int? = null,
    public val documentId: String? = null,
    public val path: String? = null,
)
