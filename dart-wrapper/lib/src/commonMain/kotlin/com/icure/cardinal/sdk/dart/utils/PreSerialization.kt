package com.icure.cardinal.sdk.dart.utils

import com.icure.cardinal.sdk.model.specializations.Pkcs8Bytes
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService

suspend fun RsaKeypair<*>.toPkcs8Bytes(): Pkcs8Bytes =
	private.toPkcs8Bytes()
suspend fun PrivateRsaKey<*>.toPkcs8Bytes(): Pkcs8Bytes =
	Pkcs8Bytes(defaultCryptoService.rsa.exportPrivateKeyPkcs8(this))