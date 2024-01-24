package com.icure.sdk.utils

import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.String
import io.ktor.utils.io.core.toByteArray


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

// TODO compare performances with native solutions making sure the native respect the contract

/**
 * Encode bytes as a base 64 string.
 * - Uses the encoding scheme as specified in RFC 4648 table 1 (with `+` and `/`).
 * - The output string uses UTF-8 encoding.
 * - Does not perform any line wrapping
 * - Inserts padding '=' if necessary.
 * @param bytes the bytes to encode
 * @return the base64 representation of the bytes.
 */
fun base64Encode(bytes: ByteArray): String =
    String(JavaBase64.encoder.encode(bytes), charset = Charsets.UTF_8)

/**
 * Decodes a base 64 string.
 * - Uses the encoding scheme as specified in RFC 4648 table 1 (with `+` and `/`).
 * - The input string uses UTF-8 encoding.
 * - Fails if there are invalid characters (including line wrappings)
 * - Does not require padding '=' but if they are present they must be in correct amount
 * @param base64String a base 64 string.
 * @return the bytes represented by the provided string.
 * @throws IllegalArgumentException if the input string is not a valid base64 string.
 */
fun base64Decode(base64String: String): ByteArray =
    JavaBase64.decoder.decode(base64String.toByteArray(Charsets.UTF_8))
