package com.icure.sdk.utils


/**
 * Represents the byte array as a hexadecimal string.
 * @return hex representation of the array
 */
@OptIn(ExperimentalUnsignedTypes::class)
fun ByteArray.toHexString(): String =
    asUByteArray().toHexString()

/**
 * Represents the byte array as a hexadecimal string.
 * @return hex representation of the array
 */
@OptIn(ExperimentalUnsignedTypes::class)
fun UByteArray.toHexString(): String =
    joinToString("") { it.toString(radix = 16).padStart(2, '0') }
