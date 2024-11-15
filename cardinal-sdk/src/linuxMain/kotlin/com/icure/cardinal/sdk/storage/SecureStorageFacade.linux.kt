package com.icure.cardinal.sdk.storage

import com.icure.kryptom.crypto.AesAlgorithm.CbcWithPkcs7Padding
import com.icure.kryptom.crypto.AesKey

actual suspend fun getOrCreateSecretKey(storageFacade: StorageFacade, key: String): AesKey<CbcWithPkcs7Padding> {
	throw IllegalStateException("SecureStorageFacade is not supported on linux platform")
}

