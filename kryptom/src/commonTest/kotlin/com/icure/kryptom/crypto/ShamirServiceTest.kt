package com.icure.kryptom.crypto

import com.icure.kryptom.utils.hexToByteArray
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.core.toByteArray

@OptIn(ExperimentalStdlibApi::class)
class ShamirServiceTest : StringSpec({
	"Should be able to split and recombine" {
		repeat(100) {
			val secret = "This is a secret message."
			val shares = defaultCryptoService.shamirService.generateKeys(
				secret.toByteArray(),
				5,
				2
			).toList().shuffled()
			println(shares)
			val regenerated = defaultCryptoService.shamirService.getSecret(
				shares.drop(3).toMap()
			)
			println(regenerated.decodeToString())
		}
	}

	"Test" {
		val shares = mapOf(
			1 to hexToByteArray("0b3247caf8a5c28a384d8aa1ef7ce36eaeb4d9f20e72db254daa98ef8c45a2484d2c521519d54af8b6c69284ff9d7938d408523baad1830a2796328d19c4fc777453dd943f4034e7fbcfd8b5711ff97cea06979de5fa4cac1c0675dc9d05663ce6e2471f2a2f6b02742acd4de22022c9d0aa232ccaa1c73117e715fbab97c7cc"),
			2 to hexToByteArray("e76256dfcfcb4fce076d689774489838a1fe78adda01f9bbe547c69dcefdd87f84eb8149226431d7d5380152621e0988e7ce90a72036117900109a35425c8f62ea34c96dd48a26fb940fd401b2e7263dd6b4286c25ab3c24868000a21a6b1f3685d45ddb39717faf61cfeb40b1825519708dc0b34631f3397102a5f4941ac617"),
			3 to hexToByteArray("ec501115376e8d443f20e2369b347b560f4aa15fd473229ea8ed5e7242b87a37c9c7d35c3bb17b2f63fe93d69d8370b033c6c29c8ae792732786a8b85b9873159e6714f9ebca121c6fc00cb4c3f8df413cb2bff0c03070e19ae5751d870f796363421ab7133b14cf15c5266853ca77b3a007e3fa8cfe34696686b0603fe4019f"),
			4 to hexToByteArray("30dcebe60bc1e1bacf2149340e6a3cc7f8f78b0a96b1ba8836b61a428a2693656d3d8b0304a3cc5b1deee2a5fad8d9ca86deed30f9720a5b25a4f6a259bbb6cec11a2aa72721694bd4144cc724904f49cdaf3ce6a54bd2bcd31c8f4ec05a55245a57d1e3db7760d1dc2866e6c254ee5bf3cdbfd997876616836c51c66efdd887"),
			5 to hexToByteArray("3beeac2cf3642330f76cc395e116dfa9564352f898c361ad7b1c82ad0663312d2011d9161d7686a3ab2870210545a0f252d6bf0b53a389510232c42f407f4ab9b549f73318615dac2fdb9472558fb63527a9ab7a40d09e79cf79faf15d3e3371bcc1968ff13d0bb1a822abce201cccf123479c905d48a14694e84452c5031f0f"),
		)
		val regenerated = defaultCryptoService.shamirService.getSecret(
			shares
		)
		println(regenerated.decodeToString())
	}
})