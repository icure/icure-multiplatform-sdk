package com.icure.kryptom.crypto

import com.icure.kryptom.utils.toHexString
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray

private val dataHashes = listOf(
	"b4b7ccdb3223f407fa3bd0a6451453d774a14bf3208111a6e523ec6dce2af64c",
	"55fc641a0b2729692a7f3ffe84ef9b60c0ec6f29cbd91d96c52f7d1ae2046848",
	"16aba5393ad72c0041f5600ad3c2c52ec437a2f0c7fc08fadfc3c0fe9641d7a3",
	"d7a8fbb307d7809469ca9abcb0082e4f8d5651e46d3cdb762d02d0bf37c9e592",
	"b51ebfba6018c0e9c4700da49b0db9b398de89ad0613e2031a1bb3b0eb351bea",
	"bc762c3f9118e2b024676ec9ca6b2f264ac97dd2ccd026efef829fa2b1bd1a7b"
)

class DigestServiceTest : StringSpec({
	"Sha256 digest should match expected" {
		data.zip(dataHashes).forEach { (data, hash) ->
			defaultCryptoService.digest.sha256(data.toByteArray(Charsets.UTF_8)).toHexString() shouldBe hash
		}
	}
})