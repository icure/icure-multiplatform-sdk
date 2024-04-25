package com.icure.kryptom.crypto

import com.icure.kryptom.crypto.asn.pkcs8PrivateToSpkiPublic
import com.icure.kryptom.crypto.asn.toAsn1
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.Signature
import java.security.spec.MGF1ParameterSpec
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.PSSParameterSpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher

object JvmRsaService : RsaService {
	private const val SPKI_FORMAT = "X.509"
	private const val PKCS8_FORMAT = "PKCS#8"

	private fun getCipher(algorithm: RsaAlgorithm.RsaEncryptionAlgorithm): Cipher = when (algorithm) {
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 -> Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding")
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 -> Cipher.getInstance("RSA/NONE/OAEPWithSHA256AndMGF1Padding")
	}

	private fun getSignature(algorithm: RsaAlgorithm.RsaSignatureAlgorithm): Signature = when (algorithm) {
		RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256 -> Signature.getInstance("SHA256withRSA/PSS").also {
			it.setParameter(
				PSSParameterSpec(
					"SHA-256",
					"MGF1",
					MGF1ParameterSpec.SHA256,
					32,
					1 // From PSSParameterSpec.TRAILER_FIELD_BC
				)
			)
		}
	}

	override suspend fun <A : RsaAlgorithm> generateKeyPair(
		algorithm: A,
		keySize: RsaService.KeySize
	): RsaKeypair<A> {
		val rsaKeyGenerator: KeyPairGenerator = KeyPairGenerator.getInstance("RSA")
		rsaKeyGenerator.initialize(keySize.bitSize)
		val pair = rsaKeyGenerator.generateKeyPair()
		return RsaKeypair(
			PrivateRsaKey(pair.private, algorithm).checkFormat(),
			PublicRsaKey(pair.public, algorithm).checkFormat()
		)
	}

	override suspend fun exportPrivateKeyPkcs8(key: PrivateRsaKey<*>): ByteArray =
		key.checkFormat().key.encoded

	override suspend fun exportPublicKeySpki(key: PublicRsaKey<*>): ByteArray =
		key.checkFormat().key.encoded

	override suspend fun <A : RsaAlgorithm> loadKeyPairPkcs8(algorithm: A, privateKeyPkcs8: ByteArray): RsaKeypair<A> {
		val keyFactory = KeyFactory.getInstance("RSA")
		val privateKeySpec = PKCS8EncodedKeySpec(privateKeyPkcs8)
		val privateKey = PrivateRsaKey(keyFactory.generatePrivate(privateKeySpec), algorithm)
		val publicKeySpec = X509EncodedKeySpec(privateKeyPkcs8.toAsn1().pkcs8PrivateToSpkiPublic().pack())
		val publicKey = PublicRsaKey(keyFactory.generatePublic(publicKeySpec), algorithm)
		return RsaKeypair(privateKey, publicKey)
	}

	override suspend fun <A : RsaAlgorithm> loadPrivateKeyPkcs8(
		algorithm: A,
		privateKeyPkcs8: ByteArray
	): PrivateRsaKey<A> {
		val keyFactory = KeyFactory.getInstance("RSA")
		val privateKeySpec = PKCS8EncodedKeySpec(privateKeyPkcs8)
		return PrivateRsaKey(keyFactory.generatePrivate(privateKeySpec), algorithm)
	}

	override suspend fun <A : RsaAlgorithm> loadPublicKeySpki(algorithm: A, publicKeySpki: ByteArray): PublicRsaKey<A> {
		val keyFactory = KeyFactory.getInstance("RSA")
		val publicKeySpec = X509EncodedKeySpec(publicKeySpki)
		return PublicRsaKey(keyFactory.generatePublic(publicKeySpec), algorithm)
	}

	override suspend fun encrypt(
		data: ByteArray,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): ByteArray {
		return getCipher(publicKey.algorithm).apply { init(Cipher.ENCRYPT_MODE, publicKey.key) }.doFinal(data)
	}

	override suspend fun decrypt(
		data: ByteArray,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): ByteArray {
		return getCipher(privateKey.algorithm).apply { init(Cipher.DECRYPT_MODE, privateKey.key) }.doFinal(data)
	}

	override suspend fun sign(
		data: ByteArray,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaSignatureAlgorithm>
	): ByteArray {
		return getSignature(privateKey.algorithm).apply {
			initSign(privateKey.key)
			update(data)
		}.sign()
	}

	override suspend fun verifySignature(
		signature: ByteArray,
		data: ByteArray,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm>
	): Boolean {
		return getSignature(publicKey.algorithm).apply {
			initVerify(publicKey.key)
			update(data)
		}.verify(signature)
	}

	private fun <A : RsaAlgorithm> PublicRsaKey<A>.checkFormat() = this.also {
		assert(key.format == SPKI_FORMAT) {
			"""
			Generated public key should have format $SPKI_FORMAT but got ${key.format}.
			Make sure that the default security provider generates keys in the appropriate format.
			""".trimIndent()
		}
	}

	private fun <A : RsaAlgorithm> PrivateRsaKey<A>.checkFormat() = this.also {
		assert(key.format == PKCS8_FORMAT) {
			"""
			Generated private key should have format $PKCS8_FORMAT but got ${key.format}.
			Make sure that the default security provider generates keys in the appropriate format.
			""".trimIndent()
		}
	}
}
