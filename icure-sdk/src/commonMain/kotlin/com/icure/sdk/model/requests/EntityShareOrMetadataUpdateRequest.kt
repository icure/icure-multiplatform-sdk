package com.icure.sdk.model.requests

import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EntityShareOrMetadataUpdateRequest(
    public val share: EntityShareRequest? = null,
    public val update: EntitySharedMetadataUpdateRequest? = null,
) {
    // region EntityShareOrMetadataUpdateRequest-EntityShareOrMetadataUpdateRequest

    // endregion
}
