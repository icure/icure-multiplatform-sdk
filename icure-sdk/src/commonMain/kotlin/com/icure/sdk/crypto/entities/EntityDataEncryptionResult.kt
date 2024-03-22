package com.icure.sdk.crypto.entities

import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
class EntityDataEncryptionResult<T : Encryptable>(
	val updatedEntity: T?,
	val encryptedData: ByteArray
)