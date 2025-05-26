package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map
import com.icure.utils.InternalIcureApi

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EntitySharedMetadataUpdateRequest(
	public val metadataAccessControlHash: SecureDelegationKeyString,
	@DefaultValue("emptyMap()")
	public val secretIds: Map<Base64String, EntryUpdateType> = emptyMap(),
	@DefaultValue("emptyMap()")
	public val encryptionKeys: Map<Base64String, EntryUpdateType> = emptyMap(),
	@DefaultValue("emptyMap()")
	public val owningEntityIds: Map<Base64String, EntryUpdateType> = emptyMap(),
	internal val dtoSerialName: String,
) {
	// region EntitySharedMetadataUpdateRequest-EntitySharedMetadataUpdateRequest
	@InternalIcureApi
	fun wrap() = EntityShareOrMetadataUpdateRequest(update = this)
	// endregion
}
