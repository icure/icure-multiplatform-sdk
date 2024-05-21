package com.icure.kryptom.crypto

import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.toHexString
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldMatch

class RsaServiceKeyFormatTest : StringSpec({
	val public2048Format = Regex("^30820122300d06092a864886f70d01010105000382010f003082010a0282010100[0-9a-f]{512}0203010001\$")
	val public4096Format = Regex("^30820222300d06092a864886f70d01010105000382020f003082020a0282020100[0-9a-f]{1024}0203010001\$")
	val private2048Format = Regex("^308204b[0-9a-f]020100300d06092a864886f70d0101010500048204a[0-9a-f]308204a[0-9a-f]0201000282010100[0-9a-f]+\$")
	val private4096Format = Regex("^3082094[0-9a-f]020100300d06092a864886f70d01010105000482092[0-9a-f]3082092[0-9a-f]0201000282020100[0-9a-f]+\$")
	val algorithms = listOf(
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256,
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1,
		RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256
	)

	// Tests both the export and the generation parameters
	"Generated 2048 keys should follow expected format" {
		algorithms.forEach {
			val keypair = defaultCryptoService.rsa.generateKeyPair(it, RsaService.KeySize.Rsa2048)
			defaultCryptoService.rsa.exportPrivateKeyPkcs8(keypair.private).toHexString() shouldMatch private2048Format
			defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString() shouldMatch public2048Format
		}
	}

	"Generated 4096 keys should follow expected format" {
		algorithms.forEach {
			val keypair = defaultCryptoService.rsa.generateKeyPair(it, RsaService.KeySize.Rsa4096)
			defaultCryptoService.rsa.exportPrivateKeyPkcs8(keypair.private).toHexString() shouldMatch private4096Format
			defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString() shouldMatch public4096Format
		}
	}

	"Should be capable of importing public key by itself" {
		sampleRsaKeys.map { it.second }.zip(sampleRsaKeysPublic).forEach { (private, public) ->
			val importedPair = defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, base64Decode(private))
			val importedPublic = defaultCryptoService.rsa.loadPublicKeySpki(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, base64Decode(public))
			val bytes = defaultCryptoService.strongRandom.randomBytes(29)
			val encrypted = defaultCryptoService.rsa.encrypt(bytes, importedPublic)
			val decrypted = defaultCryptoService.rsa.decrypt(encrypted, importedPair.private)
			decrypted.toList() shouldBe bytes.toList()
		}
	}
})
