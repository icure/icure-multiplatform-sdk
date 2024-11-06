package com.icure.cardinal.sdk.model.objectstorage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface StoredObjectInformation {
	@Serializable
	@SerialName("Available")
	public data class Available(
		public val md5HashHexString: String,
	) : StoredObjectInformation

	@Serializable
	@SerialName("Storing")
	public data class Storing(
		public val nextByte: Long,
		public val md5HashHexString: String?,
	) : StoredObjectInformation

	@Serializable
	@SerialName("NotStored")
	public data object NotStored : StoredObjectInformation
	// region StoredObjectInformation-StoredObjectInformation

	// endregion
}
