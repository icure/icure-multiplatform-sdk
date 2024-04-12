package com.icure.sdk.crypto.entities

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.model.specializations.HexString
import kotlin.jvm.JvmInline

@JvmInline
value class RecoveryDataKey(val hex: HexString) {
	internal suspend fun loadAesKey(cryptoService: CryptoService): AesKey =
		cryptoService.aes.loadKey(hex.decodedBytes())
}