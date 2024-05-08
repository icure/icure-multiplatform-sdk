package com.icure.kryptom.crypto.asn

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.base64UrlEncode
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AsnToJwkConverterTest : StringSpec({
	"Converting from pkcs8/spki to jwk and back should give the same result" {
		listOf(
			RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
		).forEach { algorithm ->
			RsaService.KeySize.entries.forEach { keySize ->
				val generatedKey = defaultCryptoService.rsa.generateKeyPair(algorithm, keySize)
				val exportedPkcs8 = defaultCryptoService.rsa.exportPrivateKeyPkcs8(generatedKey.private)
				val exportedSpki = defaultCryptoService.rsa.exportPublicKeySpki(generatedKey.public)
				val privJwk = AsnToJwkConverter.pkcs8ToJwk(algorithm, exportedPkcs8)
				val pubJwk = AsnToJwkConverter.spkiToJwk(algorithm, exportedSpki)
				base64UrlEncode(AsnToJwkConverter.jwkToPkcs8(privJwk)) shouldBe base64UrlEncode(exportedPkcs8)
				base64UrlEncode(AsnToJwkConverter.jwkToSpki(pubJwk)) shouldBe base64UrlEncode(exportedSpki)
			}
		}
	}
})