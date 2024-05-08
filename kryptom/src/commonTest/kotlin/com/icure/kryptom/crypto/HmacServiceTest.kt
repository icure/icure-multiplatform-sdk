package com.icure.kryptom.crypto

import com.icure.kryptom.utils.base64Decode
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray


private val keys = mapOf<HmacAlgorithm, List<String>>(
	HmacAlgorithm.HmacSha512 to listOf(
		"E8Kij04n2hg/j3y/d7M8RRmQLQHA+oCR7Uldec/f+kZH17nE0i7haenaM8tFrUljA+p0F/sHOLw+HPtmtcCl8xnqajmjcTtfImZZD67uaIt30UkoMUQqOb62oR3cQ/fdWgIZTMk811HfE91UweqfalT6kAg5yh5wTc+xY5FGkLk=",
		"AW4gGO9BKZCSxZ7sYUJHzuRBAJOawt+FE3geEik9dbQ0+Q9svc7jCXSKH9bHmeDfh+Wtuo+3GdKKZO8WzGLOMK470+scybPnEqV8eMpa2evV6moCrzUp4u2H+HpY8MTavSFSz/+V4ZWNQyJQ968bwlC7tSglNnoYBQi/4DQ8uzo="
	)
)

private val signatures = mapOf<HmacAlgorithm, List<Pair<Pair<Int, Int>, String>>>(
	HmacAlgorithm.HmacSha512 to listOf(
		Pair(0, 0) to "tuSBTthZtICyFCn6MePfHBq5Ai+MjkFYBAKxXbkBOOTe58+jixTh1dcgvgJ6YIeA1uFVLOkpcWxB2mBbF5AjEA==",
		Pair(1, 0) to "g52+8DTHo0PV1OAYrYVNwHpULEjVAoI6qTS5Zov0vT3QyZuPYCXpeEm3xyuE63aog9IphKGHLMlr3Ir80Hirqg==",
		Pair(2, 0) to "uUENcn0wIjGoHkOGZ6Bimpd4XEd5Sd9B8HmC0VlJpWDEQtEYtDCsNGk095C3EdphyWk4rLYjv30nEnqTsVjDMg==",
		Pair(3, 0) to "mCU9EWH5nXV58sDhUGfKYT45UGU5D3LyTtmsVqcobnbui2cg2e/muzegtDR3x5amAyb+4tpXXXPh/3M7ngblZA==",
		Pair(4, 0) to "TxwX8KSSlMK70zyHRBEu4ILRroQEDKKje9CnYxEDRvqRgp5ZhWdHY2nPm07a0WyLhHHIjU3euFdsMx1HMoVlRA==",
		Pair(5, 0) to "W3h75WaCNUU+7ZQM3wTKLeklxu5W9s09SVBNaTZlFwjfgitWeiFeB5G97qVaBDuMguW5V6pob4KNYiOaN8EZKA==",
		Pair(0, 1) to "wrXsV09J8DF6JmH0XM5ZbO///oDsOKe7MfAXpMFNTy4iwkGDkkrnecT3/LIBOD3eZl8TnotU4Uj+nuPg/TvjIg==",
		Pair(1, 1) to "4tLl7NJtMujA1A2CA5cmvs5s1GLJOXCeLuuzzVOSAzHqc1WSgl+LfuasJCZMk8zjpbi8SeYuUF/BRI+CtnTbEg==",
		Pair(2, 1) to "G0mUriNqa1Q+e80vMxsqufsXreaVfgHyAGuNEa1OcSffsGze35VTpd98LQAv1Wb2VNcGeCNl4+tbqg5ZwhgnrQ==",
		Pair(3, 1) to "qriWAQ10f5hsnWhSvsyyJnwJsDCLgAZmH/wZ2Xn8OFzijNERrnBI3F1aAhI5xxdg8AuHx/rjOnPu/ARd2OrawA==",
		Pair(4, 1) to "Dx1sK7dpbuNwFEkxi1hZULPQYQR29F/niMD8XsRF2Y/SuonDeYNPynnsqSCMvblihDmpyRDN1bH/gc21aAjKqw==",
		Pair(5, 1) to "Se2o/YDuil+CWDeAcM7Z8Vl3JSFtFFayAb1k84XvirS3fKNWp6N6PKs+tXC3qljx42ZLKax0eTG95UltL7ZxVA==",
	)
)

class HmacServiceTest : StringSpec({
	fun <A : HmacAlgorithm> doTest(algorithm: A) {
		"$algorithm -  key should have recommended size" {
			val key = defaultCryptoService.hmac.generateKey(algorithm)
			defaultCryptoService.hmac.exportKey(key).size shouldBe algorithm.recommendedKeySize
		}

		"$algorithm - Signature generation and verification should match expected" {
			val key = defaultCryptoService.hmac.generateKey(algorithm)
			val wrongKey = defaultCryptoService.hmac.generateKey(algorithm)
			data.forEach { data ->
				val dataBytes = data.toByteArray(Charsets.UTF_8)
				val signature = defaultCryptoService.hmac.sign(dataBytes, key)
				defaultCryptoService.hmac.verify(signature, dataBytes, key) shouldBe true
				defaultCryptoService.hmac.verify(signature, dataBytes, wrongKey) shouldBe false
				data.mutations().forEach { mutatedData ->
					defaultCryptoService.hmac.verify(
						signature,
						mutatedData.toByteArray(Charsets.UTF_8),
						key
					) shouldBe false
				}
			}
		}

		"$algorithm - Exported and reimported key should work" {
			val keyBytes = defaultCryptoService.hmac.exportKey(defaultCryptoService.hmac.generateKey(algorithm))
			val key = defaultCryptoService.hmac.loadKey(algorithm, keyBytes)
			data.forEach { data ->
				val dataBytes = data.toByteArray(Charsets.UTF_8)
				val signature = defaultCryptoService.hmac.sign(dataBytes, key)
				defaultCryptoService.hmac.verify(signature, dataBytes, key) shouldBe true
				data.mutations().forEach { mutatedData ->
					defaultCryptoService.hmac.verify(
						signature,
						mutatedData.toByteArray(Charsets.UTF_8),
						key
					) shouldBe false
				}
			}
		}

		"$algorithm - Signature verification should match expected - signature from other sources" {
			val importedKeys =
				keys.getValue(algorithm).map { defaultCryptoService.hmac.loadKey(algorithm, base64Decode(it)) }
			signatures.getValue(algorithm).forEach { (dataAndKeyIndex, signature) ->
				val (dataIndex, keyIndex) = dataAndKeyIndex
				val key = importedKeys[keyIndex]
				val dataString = data[dataIndex]
				val signatureBytes = base64Decode(signature)
				defaultCryptoService.hmac.verify(
					signatureBytes,
					dataString.toByteArray(Charsets.UTF_8),
					key
				) shouldBe true
				dataString.mutations().forEach { mutatedData ->
					defaultCryptoService.hmac.verify(
						signatureBytes,
						mutatedData.toByteArray(Charsets.UTF_8),
						key
					) shouldBe false
				}
				val wrongKey = importedKeys[(keyIndex + 1) % importedKeys.size]
				defaultCryptoService.hmac.verify(
					signatureBytes,
					dataString.toByteArray(Charsets.UTF_8),
					wrongKey
				) shouldBe false
			}
		}
	}

	doTest(HmacAlgorithm.HmacSha512)
})
