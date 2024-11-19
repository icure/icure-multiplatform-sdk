package com.icure.cardinal.sdk.storage

import android.os.Build
import android.security.keystore.KeyProperties
import androidx.annotation.RequiresApi
import com.icure.kryptom.crypto.AesAlgorithm.CbcWithPkcs7Padding
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService

actual suspend fun getOrCreateSecretKey(storageFacade: StorageFacade, key: String, accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService): AesKey<CbcWithPkcs7Padding> {
    TODO()
}

@RequiresApi(Build.VERSION_CODES.R)
private fun SecureKeyAccessLevel.toKeyProperties(): Int {
	return when (this) {
		SecureKeyAccessLevel.DevicePasscode -> KeyProperties.AUTH_DEVICE_CREDENTIAL
		SecureKeyAccessLevel.Biometric -> KeyProperties.AUTH_BIOMETRIC_STRONG
	}
}
