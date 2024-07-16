package com.icure.sdk.crypto.entities

import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import kotlinx.serialization.Serializable

@Serializable
data class DelegateShareOptions(
	val shareSecretIds: Set<String>,
	val shareEncryptionKeys: Set<HexString>,
	val shareOwningEntityIds: Set<String>,
	val requestedPermissions: RequestedPermission
)