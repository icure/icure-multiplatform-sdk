package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ReferenceRange(
    public val low: Double? = null,
    public val high: Double? = null,
    public val stringValue: String? = null,
    public val tags: List<CodeStub> = emptyList(),
    public val codes: List<CodeStub> = emptyList(),
    public val notes: List<Annotation> = emptyList(),
    public val age: Range? = null,
) {
    // region ReferenceRange-ReferenceRange

    // endregion
}
