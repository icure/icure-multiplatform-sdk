package com.icure.sdk.model.requests

import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EntitySharedMetadataUpdateRequest(
	public val metadataAccessControlHash: SecureDelegationKeyString,
	public val secretIds: Map<Base64String, EntryUpdateType> = emptyMap(),
	public val encryptionKeys: Map<Base64String, EntryUpdateType> = emptyMap(),
	public val owningEntityIds: Map<Base64String, EntryUpdateType> = emptyMap(),
) {
	// region EntitySharedMetadataUpdateRequest-EntitySharedMetadataUpdateRequest
@InternalIcureApi
	fun wrap() = EntityShareOrMetadataUpdateRequest(update = this)
	// endregion
}
