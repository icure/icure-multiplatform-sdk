package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class OperationToken(
	public val tokenHash: String,
	public val creationTime: Long,
	public val validity: Long,
	public val operation: Operation,
	public val description: String? = null,
) {
	// region OperationToken-OperationToken

	// endregion
}
