package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.HexString
import kotlinx.serialization.Serializable

@Serializable
data class DelegateShareOptions(
	val shareSecretIds: Set<String>,
	val shareEncryptionKeys: Set<HexString>,
	val shareOwningEntityIds: Set<String>,
	val requestedPermissions: RequestedPermission
)