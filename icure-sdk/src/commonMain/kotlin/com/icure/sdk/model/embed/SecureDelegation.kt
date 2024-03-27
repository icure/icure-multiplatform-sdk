package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class SecureDelegation(
    public val delegator: String? = null,
    public val `delegate`: String? = null,
    public val secretIds: Set<Base64String> = emptySet(),
    public val encryptionKeys: Set<Base64String> = emptySet(),
    public val owningEntityIds: Set<Base64String> = emptySet(),
    public val parentDelegations: Set<SecureDelegationKeyString> = emptySet(),
    public val exchangeDataId: String? = null,
    public val permissions: AccessLevel,
)
