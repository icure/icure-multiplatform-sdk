package com.icure.sdk.model.base

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class CodeStub(
    override val id: String? = null,
    override val context: String? = null,
    override val type: String? = null,
    override val code: String? = null,
    override val version: String? = null,
    public val contextLabel: String? = null,
    override val label: Map<String, String>? = null,
) : CodeIdentification<String?> {
	// region CodeStub-CodeStub

	// endregion
}
