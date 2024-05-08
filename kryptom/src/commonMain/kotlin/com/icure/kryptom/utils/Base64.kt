/*
* Copyright 2014-2021 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
*/
package com.icure.kryptom.utils

import io.ktor.utils.io.core.buildPacket
import io.ktor.utils.io.core.readAvailable
import io.ktor.utils.io.core.readBytes
import io.ktor.utils.io.core.writeText

// Encoding implementation comes from ktor utils https://raw.githubusercontent.com/ktorio/ktor/5f27f303bd26a361430b45fe173434d35986f52a/ktor-utils/common/src/io/ktor/util/Base64.kt
// with minimal changes to allow for custom alphabet
// Decoding is also based on ktor but with added strong validation of the input.

private const val BASE64_ALPHABET_STANDARD = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
private const val BASE64_ALPHABET_URL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_"
private const val BASE64_MASK_INT: Int = 0x3f
private const val BASE64_PAD = '='


private val BASE64_INVERSE_ALPHABET_STANDARD = IntArray(256) {
	BASE64_ALPHABET_STANDARD.indexOf(it.toChar())
}


private val BASE64_INVERSE_ALPHABET_URL = IntArray(256) {
	BASE64_ALPHABET_URL.indexOf(it.toChar())
}

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
	encodeBase64(bytes, BASE64_ALPHABET_STANDARD)

/**
 * Same as [base64UrlEncode] but uses the URL and filename safe alphabet (RFC 4648 table 2).
 */
fun base64UrlEncode(bytes: ByteArray): String =
	encodeBase64(bytes, BASE64_ALPHABET_URL)

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
	decodeBase64(base64String, BASE64_INVERSE_ALPHABET_STANDARD)

/**
 * Same as [base64Decode] but uses the URL and filename safe alphabet (RFC 4648 table 2).
 */
fun base64UrlDecode(base64String: String): ByteArray =
	decodeBase64(base64String, BASE64_INVERSE_ALPHABET_URL)

/**
 * Encode [ByteArray] in base64 format
 */
private fun encodeBase64(data: ByteArray, alphabet: String): String {
	var position = 0
	var writeOffset = 0
	val charArray = CharArray(data.size * 8 / 6 + 3)

	while (position + 3 <= data.size) {
		val first = data[position].toInt()
		val second = data[position + 1].toInt()
		val third = data[position + 2].toInt()
		position += 3

		val chunk = ((first and 0xFF) shl 16) or ((second and 0xFF) shl 8) or (third and 0xFF)
		for (index in 3 downTo 0) {
			val char = (chunk shr (6 * index)) and BASE64_MASK_INT
			charArray[writeOffset++] = alphabet[char]
		}
	}

	val remaining = data.size - position
	if (remaining == 0) return charArray.concatToString(0, writeOffset)

	val chunk = if (remaining == 1) {
		((data[position].toInt() and 0xFF) shl 16) or ((0 and 0xFF) shl 8) or (0 and 0xFF)
	} else {
		((data[position].toInt() and 0xFF) shl 16) or ((data[position + 1].toInt() and 0xFF) shl 8) or (0 and 0xFF)
	}

	val padSize = (3 - remaining) * 8 / 6
	for (index in 3 downTo padSize) {
		val char = (chunk shr (6 * index)) and BASE64_MASK_INT
		charArray[writeOffset++] = alphabet[char]
	}

	repeat(padSize) { charArray[writeOffset++] = BASE64_PAD }

	return charArray.concatToString(0, writeOffset)
}

private fun decodeBase64(input: String, lookupTable: IntArray): ByteArray {
	val unpaddedData = if (input[input.length - 1] == BASE64_PAD) {
		require(input.length % 4 == 0) { "Invalid padded base64 string length: ${input.length}" }
		require(input[input.length - 3] != BASE64_PAD) { "Too much padding" }
		if (input[input.length - 2] == BASE64_PAD) {
			// technically should still validate that last 4 bits of the last non-pad byte are zero
			input.substring(0, input.length - 2)
		} else {
			// technically should still validate that last 2 bits of the last non-pad byte are zero
			input.substring(0, input.length - 1)
		}
	} else input
	val packet = buildPacket {
		writeText(unpaddedData)
	}
	val data = ByteArray(4)
	return buildPacket {
		while (packet.remaining > 0) {
			val read = packet.readAvailable(data)

			val chunk = data.foldIndexed(0) { index, result, current ->
				val found = lookupTable.getOrNull(current.toInt())?.takeIf { it >= 0 }
					?: throw IllegalArgumentException("Invalid base64 character: $current")
				result or (found shl ((3 - index) * 6))
			}

			for (index in data.size - 2 downTo (data.size - read)) {
				val origin = (chunk shr (8 * index)) and 0xff
				writeByte(origin.toByte())
			}
		}
	}.readBytes()
}
