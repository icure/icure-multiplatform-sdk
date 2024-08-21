package com.icure.sdk.test

import com.icure.kryptom.utils.toHexString
import io.kotest.matchers.shouldBe
import kotlin.random.Random

infix fun String.shouldBeNextRevOf(otherRev: String) {
	require("^\\d+-[a-fA-F0-9]{32}\$".toRegex().matches(this)) {
		"$this is not a valid rev"
	}
	require("^\\d+-[a-fA-F0-9]{32}\$".toRegex().matches(otherRev)) {
		"$otherRev is not a valid rev"
	}
	val thisVersion = split("-", limit = 2).first().toInt()
	val otherVersion = otherRev.split("-", limit = 2).first().toInt()
	thisVersion shouldBe (otherVersion + 1)
}

/**
 * Unsafe random uuid generation
 */
@OptIn(ExperimentalUnsignedTypes::class)
fun Random.nextUuid(): String {
	val bytes = nextBytes(16).toUByteArray()
	// Set version 4
	bytes[6] = (bytes[6] and 0x0fu) or 0x40u
	// Set IETF variant
	bytes[8] = (bytes[8] and 0x3fu) or 0x80u
	val s = bytes.toHexString()
	return "${s.substring(0, 8)}-${s.substring(8, 12)}-${s.substring(12, 16)}-${s.substring(16, 20)}-${
		s.substring(
			20
		)
	}"
}