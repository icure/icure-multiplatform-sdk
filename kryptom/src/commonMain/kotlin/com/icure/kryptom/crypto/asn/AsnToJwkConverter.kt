package com.icure.kryptom.crypto.asn

import com.icure.kryptom.crypto.PrivateRsaKeyJwk
import com.icure.kryptom.crypto.PublicRsaKeyJwk
import com.icure.kryptom.crypto.RsaAlgorithm

object AsnToJwkConverter {
	fun spkiToJwk(algorithm: RsaAlgorithm, spki: ByteArray): PublicRsaKeyJwk {
		TODO()
	}

	fun jwkToSpki(jwk: PublicRsaKeyJwk): ByteArray {
		TODO()
	}

	fun pkcs8ToJwk(algorithm: RsaAlgorithm, pkcs8: ByteArray): PrivateRsaKeyJwk {
		TODO()
	}

	fun jwkToPkcs8(jwk: PrivateRsaKeyJwk): ByteArray {
		TODO()
	}
}