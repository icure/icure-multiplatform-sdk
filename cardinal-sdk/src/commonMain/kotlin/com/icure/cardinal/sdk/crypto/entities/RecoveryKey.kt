package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base32Decode
import com.icure.kryptom.utils.base32Encode
import com.icure.kryptom.utils.toHexString
import kotlinx.serialization.Serializable

@Serializable
class RecoveryDataKey private constructor(
	private val _hex: HexString
) {
	companion object {
		private const val BYTE_LENGTH = 32

		/**
		 * Load the recovery data key from its hexadecimal representation
		 */
		fun fromHexString(hex: String): RecoveryDataKey =
			HexString(hex).let {
				require(it.decodedBytes().size == BYTE_LENGTH) {
					"Invalid recovery data key: decoded size should be $BYTE_LENGTH bytes"
				}
				RecoveryDataKey(it)
			}

		/**
		 * Load the recovery data key from its raw bytes representation
		 */
		fun fromRawBytes(bytes: ByteArray): RecoveryDataKey {
			require(bytes.size == BYTE_LENGTH) {
				"Invalid recovery data key: decoded size should be $BYTE_LENGTH bytes"
			}
			return RecoveryDataKey(HexString(bytes.toHexString()))
		}

		/**
		 * Load the recovery data key from its base32 representation
		 */
		fun fromBase32(base32: String): RecoveryDataKey =
			fromRawBytes(base32Decode(base32))
	}

	/**
	 * Give a representation of this recovery data key as a hexadecimal string
	 */
	fun asHexString(): HexString = _hex

	/**
	 * Give a representation of this recovery data key as raw bytes
	 */
	fun asRawBytes(): ByteArray = _hex.decodedBytes()

	/**
	 * Give a representation of this recovery data key as a base32 string, excluding padding
	 */
	fun asBase32(): String = base32Encode(_hex.decodedBytes()).dropLastWhile { it == '=' }

	internal suspend fun loadAesKey(cryptoService: CryptoService): AesKey<AesAlgorithm.CbcWithPkcs7Padding> =
		cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, _hex.decodedBytes())
}