package com.icure.sdk.crypto.entities

import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.RequestedPermission

data class DelegateShareOptions(
	val shareSecretIds: Set<String>,
	val shareEncryptionKeys: Set<HexString>,
	val shareOwningEntityIds: Set<String>,
	val requestedPermissions: RequestedPermission
)