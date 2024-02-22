package com.icure.sdk.crypto.entities

import com.icure.sdk.model.HexString
import com.icure.sdk.model.RequestedPermission
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class DelegateShareOptions(
	val shareSecretIds: Set<String>,
	val shareEncryptionKeys: Set<HexString>,
	val shareOwningEntityIds: Set<String>,
	val requestedPermissions: RequestedPermission
)