package com.icure.kryptom.utils


/**
 * Represents the byte array as a hexadecimal string.
 * @return hex representation of the array
 */
@OptIn(ExperimentalStdlibApi::class)
fun ByteArray.toHexString(): String =
	toHexString(HexFormat.Default)

/**
 * Represents the byte array as a hexadecimal string.
 * @return hex representation of the array
 */
@OptIn(ExperimentalStdlibApi::class, ExperimentalUnsignedTypes::class)
fun UByteArray.toHexString(): String =
	toHexString(HexFormat.Default)

@OptIn(ExperimentalStdlibApi::class)
fun hexToByteArray(hexString: String): ByteArray =
	hexString.hexToByteArray(HexFormat.Default)
