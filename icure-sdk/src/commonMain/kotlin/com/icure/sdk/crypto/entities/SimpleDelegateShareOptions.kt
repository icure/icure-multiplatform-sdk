package com.icure.sdk.crypto.entities

import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class SimpleDelegateShareOptions(
	val shareSecretIds: Set<String>?,
	val shareEncryptionKeys: ShareMetadataBehaviour,
	val shareOwningEntityIds: ShareMetadataBehaviour,
	val requestedPermissions: RequestedPermission
)