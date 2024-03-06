package com.icure.sdk.model.requests

import com.icure.sdk.model.specializations.AccessControlKeyString
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.KeypairFingerprintV2String
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class EntityShareRequest(
  public val explicitDelegator: String? = null,
  public val explicitDelegate: String? = null,
  public val accessControlKeys: Set<AccessControlKeyString> = emptySet(),
  public val secretIds: Set<Base64String> = emptySet(),
  public val encryptionKeys: Set<Base64String> = emptySet(),
  public val owningEntityIds: Set<Base64String> = emptySet(),
  public val exchangeDataId: String? = null,
  public val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
  public val requestedPermissions: EntityShareRequest.RequestedPermission,
)
