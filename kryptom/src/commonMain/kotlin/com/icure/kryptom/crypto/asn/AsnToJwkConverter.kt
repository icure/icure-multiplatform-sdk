package com.icure.kryptom.crypto.asn

import com.icure.kryptom.crypto.PrivateRsaKeyJwk
import com.icure.kryptom.crypto.PublicRsaKeyJwk
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.asn.Asn1Object.Asn1BitString
import com.icure.kryptom.crypto.asn.Asn1Object.Asn1Integer
import com.icure.kryptom.crypto.asn.Asn1Object.Asn1Null
import com.icure.kryptom.crypto.asn.Asn1Object.Asn1OctetString
import com.icure.kryptom.crypto.asn.Asn1Object.Asn1Oid
import com.icure.kryptom.crypto.asn.Asn1Object.Asn1Sequence
import com.icure.kryptom.utils.base64UrlDecode
import com.icure.kryptom.utils.base64UrlEncode

object AsnToJwkConverter {
	fun spkiToJwk(algorithm: RsaAlgorithm, spki: ByteArray): PublicRsaKeyJwk {
		val asn1 = spki.toAsn1()
		val (modulus, exponent) = when {
			asn1 is Asn1Sequence && (asn1.value[0] as? Asn1Sequence)?.let { childSequence ->
				(childSequence.value[0] as? Asn1Oid)?.let {
					it.value == "1.2.840.113549.1.1.1" // rsaEncryption
				}
			} == true -> {
				val nested = ((asn1.value[1] as Asn1BitString).nested as? Asn1Sequence)
					?: throw IllegalArgumentException("Invalid spki format - expected a nested sequence")
				Pair(
					(nested.value[0] as Asn1Integer),
					(nested.value[1] as Asn1Integer)
				)
			}
			asn1 is Asn1Sequence && asn1.value[0] is Asn1Integer && asn1.value[1] is Asn1Integer -> {
				Pair(
					(asn1.value[0] as Asn1Integer),
					(asn1.value[1] as Asn1Integer)
				)
			}
			else -> throw IllegalArgumentException("Invalid spki format")
		}
		return PublicRsaKeyJwk(
			alg = algorithm.jwkIdentifier,
			key_ops = if (algorithm is RsaAlgorithm.RsaSignatureAlgorithm) setOf("verify") else setOf("encrypt"),
			ext = true,
			n = modulus.encodeForJwk(),
			e = exponent.encodeForJwk()
		)
	}

	fun jwkToSpki(jwk: PublicRsaKeyJwk): ByteArray =
		Asn1Sequence(listOf(
			Asn1Sequence(listOf(
				Asn1Oid("1.2.840.113549.1.1.1"),
				Asn1Null()
			)),
			Asn1BitString(
				byteArrayOf(0) + Asn1Sequence(listOf(
					jwk.n.decodeToAsn1Integer(),
					jwk.e.decodeToAsn1Integer()
				)).pack()
			)
		)).pack()

	fun pkcs8ToJwk(algorithm: RsaAlgorithm, pkcs8: ByteArray): PrivateRsaKeyJwk {
		val asn1 = pkcs8.toAsn1()
		val seq = ((asn1 as? Asn1Sequence) ?: throw IllegalArgumentException("Invalid pkcs8 format - expected a sequence")).let { seq ->
			if (
				seq.value.size == 3 && (seq.value[2] as? Asn1OctetString)?.let {
					(it.nested as? Asn1Sequence)?.value?.size == 9
				} == true
			) {
				(seq.value[2] as? Asn1OctetString)?.nested as Asn1Sequence
			} else seq
		}
		return PrivateRsaKeyJwk(
			n = (seq.value[1] as Asn1Integer).encodeForJwk(),
			e = (seq.value[2] as Asn1Integer).encodeForJwk(),
			d = (seq.value[3] as Asn1Integer).encodeForJwk(),
			p = (seq.value[4] as Asn1Integer).encodeForJwk(),
			q = (seq.value[5] as Asn1Integer).encodeForJwk(),
			dp = (seq.value[6] as Asn1Integer).encodeForJwk(),
			dq = (seq.value[7] as Asn1Integer).encodeForJwk(),
			qi = (seq.value[8] as Asn1Integer).encodeForJwk(),
			alg = algorithm.jwkIdentifier,
			key_ops = if (algorithm is RsaAlgorithm.RsaSignatureAlgorithm) setOf("sign") else setOf("decrypt"),
			ext = true
		)
	}

	fun jwkToPkcs8(jwk: PrivateRsaKeyJwk): ByteArray =
		Asn1Sequence(listOf(
			Asn1Integer(byteArrayOf(0x00)),
			Asn1Sequence(listOf(
				Asn1Oid("1.2.840.113549.1.1.1"),
				Asn1Null()
			)),
			Asn1OctetString(Asn1Sequence(listOf(
				Asn1Integer(byteArrayOf(0x00)),
				jwk.n.decodeToAsn1Integer( ),
				jwk.e.decodeToAsn1Integer(),
				jwk.d.decodeToAsn1Integer(),
				jwk.p.decodeToAsn1Integer(),
				jwk.q.decodeToAsn1Integer(),
				jwk.dp.decodeToAsn1Integer(),
				jwk.dq.decodeToAsn1Integer(),
				jwk.qi.decodeToAsn1Integer()
			)).pack())
		)).pack()

	private fun Asn1Integer.encodeForJwk(): String =
		base64UrlEncode(
			if (value[0] == 0.toByte()) {
				value.sliceArray(1 ..< value.size)
			} else value
		).dropLastWhile { it == '=' }

	private fun String.decodeToAsn1Integer(): Asn1Integer {
		val data = base64UrlDecode(this)
		// If the first bit starts with a 1 then we need to add a 0 byte to the beginning, otherwise the asn1 integer
		// would be negative (all integers in a rsa keys are positive and in the jwk representation we removed the
		// leading 0 byte)
		val paddingNeeded = data[0] < 0
		val paddedData = if (paddingNeeded) {
			byteArrayOf(0) + data
		} else data
		return Asn1Integer(paddedData)
	}
}