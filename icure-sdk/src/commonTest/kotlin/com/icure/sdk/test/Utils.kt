package com.icure.sdk.test

import io.kotest.matchers.shouldBe

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
