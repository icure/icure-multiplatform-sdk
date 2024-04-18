package com.icure.kryptom.utils

import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.String
import io.ktor.utils.io.core.toByteArray


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
	String(JavaBase64.encoder.encode(bytes, useUrlSafeAlphabet = false), charset = Charsets.UTF_8)

/**
 * Same as [base64UrlEncode] but uses the URL and filename safe alphabet (RFC 4648 table 2).
 */
fun base64UrlEncode(bytes: ByteArray): String =
	String(JavaBase64.encoder.encode(bytes, useUrlSafeAlphabet = true), charset = Charsets.UTF_8)

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
	JavaBase64.decoder.decode(base64String.toByteArray(Charsets.UTF_8), useUrlSafeAlphabet = false)

/**
 * Same as [base64Decode] but uses the URL and filename safe alphabet (RFC 4648 table 2).
 */
fun base64UrlDecode(base64String: String): ByteArray =
	JavaBase64.decoder.decode(base64String.toByteArray(Charsets.UTF_8), useUrlSafeAlphabet = true)
