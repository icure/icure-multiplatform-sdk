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
		private val BYTE_LENGTH_OPTIONS = setOf(16, 32)

		/**
		 * Load the recovery data key from its hexadecimal representation
		 */
		fun fromHexString(hex: String): RecoveryDataKey =
			HexString(hex).let {
				require(it.decodedBytes().size in BYTE_LENGTH_OPTIONS) {
					"Invalid recovery data key: decoded size should be in $BYTE_LENGTH_OPTIONS bytes"
				}
				RecoveryDataKey(it)
			}

		/**
		 * Load the recovery data key from its raw bytes representation
		 */
		fun fromRawBytes(bytes: ByteArray): RecoveryDataKey {
			require(bytes.size in BYTE_LENGTH_OPTIONS) {
				"Invalid recovery data key: decoded size should be in $BYTE_LENGTH_OPTIONS bytes"
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

/**
 * Allows to configure which recovery key to use when creating recovery data.
 */
@Serializable
sealed interface RecoveryKeyOptions {
	/**
	 * Generate a new key for the recovery data. This is the default behavior, and should be used in most cases.
	 * @param recoveryKeySize specifies the size of the recovery key to generate
	 */
	@Serializable
	data class Generate(
		val recoveryKeySize: RecoveryKeySize = RecoveryKeySize.Bytes32
	): RecoveryKeyOptions

	/**
	 * Specifies to use a pre-created recovery key.
	 */
	@Serializable
	class Use(
		val key: RecoveryDataKey
	): RecoveryKeyOptions {
		init {
			require(key.asRawBytes().let { it.size == 16 || it.size == 32 }) {
				"Recovery key should be 16 or 32 bytes"
			}
		}
	}
}

/**
 * Possible sizes for a recovery key.
 */
@Serializable
enum class RecoveryKeySize {
	/**
	 * The recovery key is 16 bytes long.
	 * We recommend using this only with one-use recovery data of limited duration in cases where the user needs to
	 * input the recovery key manually.
	 */
	Bytes16,
	/**
	 * The recovery key is 32 bytes long.
	 * This is the default recovery key length.
	 */
	Bytes32
}
