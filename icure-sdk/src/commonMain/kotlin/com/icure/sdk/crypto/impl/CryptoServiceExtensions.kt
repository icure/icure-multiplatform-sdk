package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Encode
import com.icure.sdk.crypto.IcureKeyInfo
import com.icure.sdk.crypto.RsaSignatureKeysSet
import com.icure.sdk.crypto.VerifiedRsaEncryptionKeysSet
import com.icure.sdk.model.Base64String
import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.model.KeypairFingerprintV2String
import com.icure.sdk.model.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
sealed interface KeyIdentifierFormat<T> {
	fun format(key: IcureKeyInfo<*>): T

	data object FingerprintV1 : KeyIdentifierFormat<KeypairFingerprintV1String> {
		override fun format(key: IcureKeyInfo<*>) = key.pubSpkiHexString.fingerprintV1()
	}

	data object FingerprintV2 : KeyIdentifierFormat<KeypairFingerprintV2String> {
		override fun format(key: IcureKeyInfo<*>) = key.pubSpkiHexString.fingerprintV2()
	}
}

@InternalIcureApi
suspend fun <T> CryptoService.signDataWithKeys(
	data: ByteArray,
	signatureKeysSet: RsaSignatureKeysSet,
	keyIdentifierFormat: KeyIdentifierFormat<T>
): Map<T, Base64String> =
	signatureKeysSet.allKeys.associate { keyInfo ->
		keyIdentifierFormat.format(keyInfo) to base64Encode(rsa.sign(data, keyInfo.key))
	}

@InternalIcureApi
suspend fun <T> CryptoService.encryptDataWithKeys(
	data: ByteArray,
	encryptionKeysSet: VerifiedRsaEncryptionKeysSet,
	keyIdentifierFormat: KeyIdentifierFormat<T>,
): Map<T, Base64String> =
	encryptionKeysSet.allKeys.associate { keyInfo ->
		keyIdentifierFormat.format(keyInfo) to base64Encode(rsa.encrypt(data, keyInfo.key))
	}