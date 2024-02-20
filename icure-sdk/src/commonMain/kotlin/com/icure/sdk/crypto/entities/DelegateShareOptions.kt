package com.icure.sdk.crypto.entities

import com.icure.sdk.model.HexString
import com.icure.sdk.model.RequestedPermission
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class DelegateShareOptions(
	val shareSecretIds: List<String>,
	val shareEncryptionKeys: List<HexString>,
	val shareOwningEntityIds: List<String>,
	val requestedPermissions: RequestedPermission
)