package com.icure.sdk.crypto.entities

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.model.specializations.HexString
import kotlin.jvm.JvmInline

@JvmInline
value class RecoveryDataKey(val hex: HexString) {
	internal suspend fun loadAesKey(cryptoService: CryptoService): AesKey<AesAlgorithm.CbcWithPkcs7Padding> =
		cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, hex.decodedBytes())
}