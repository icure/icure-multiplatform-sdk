package com.icure.sdk.crypto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveLength

class StrongRandomTest : StringSpec({
    "Generated UUIDs should respect specification format and be random" {
        // Can fail but probability should be very low if the random generator is good enough
        val count = 500
        val uuidStringLength = 36
        val allHexDigits = "0123456789abcdef".toSet()
        val uuids = (0 until count).map {
            strongRandom.randomUUID().also { it shouldHaveLength uuidStringLength }
        }
        uuids shouldHaveSize count
        val characters = (0 until uuidStringLength).map { mutableSetOf<Char>() }
        uuids.forEach { it.forEachIndexed { i, c -> characters[i] += c } }
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