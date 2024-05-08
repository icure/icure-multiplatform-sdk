package com.icure.kryptom.crypto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveLength

class StrongRandomTest : StringSpec({
	"Random bytes should have the requested length" {
		listOf(
			1,
			10,
			256,
			100,
			1000,
			1024
		).forEach { size ->
			defaultCryptoService.strongRandom.randomBytes(size).size shouldBe size
		}
	}

	"Generated UUIDs should respect specification format and be random" {
		// Can theoretically fail but is realistically impossible
		val count = 500
		val uuidStringLength = 36
		val allHexDigits = "0123456789abcdef".toSet()
		val uuids = (0 until count).map {
			defaultCryptoService.strongRandom.randomUUID().also { it shouldHaveLength uuidStringLength }
		}
		// Checks all ids are different
		uuids shouldHaveSize count
		val characters = (0 until uuidStringLength).map { mutableSetOf<Char>() }
		uuids.forEach { it.forEachIndexed { i, c -> characters[i] += c } }
		// Checks for the correct format AND that we cover the full range of possible half bytes in each position.
		characters.forEachIndexed { index, chars ->
			when (index) {
				8, 13, 18, 23 -> chars shouldBe setOf('-')
				14 -> chars shouldBe setOf('4')
				19 -> chars shouldBe setOf('8', '9', 'a', 'b')
				else -> chars shouldBe allHexDigits
			}
		}
	}
})