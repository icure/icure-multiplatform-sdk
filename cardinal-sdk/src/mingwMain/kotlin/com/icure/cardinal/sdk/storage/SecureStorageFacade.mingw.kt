package com.icure.cardinal.sdk.storage

import com.icure.kryptom.crypto.AesAlgorithm.CbcWithPkcs7Padding
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService

actual suspend fun getOrCreateSecretKey(storageFacade: StorageFacade, key: String, accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService): AesKey<CbcWithPkcs7Padding> {
    throw IllegalStateException("SecureStorageFacade is not supported on mingw platform")
}

