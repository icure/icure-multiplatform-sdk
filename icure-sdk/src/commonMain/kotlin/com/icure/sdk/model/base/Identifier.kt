package com.icure.sdk.model.base

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Identifier(
    public val id: String? = null,
    public val assigner: String? = null,
    public val start: String? = null,
    public val end: String? = null,
    public val system: String? = null,
    public val type: CodeStub? = null,
    public val use: String? = null,
    public val `value`: String? = null,
) {
    // region Identifier-Identifier

    // endregion
}
