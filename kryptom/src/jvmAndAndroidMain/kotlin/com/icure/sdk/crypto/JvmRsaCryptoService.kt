package com.icure.sdk.crypto

import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.Signature
import java.security.interfaces.RSAPrivateCrtKey
import java.security.spec.MGF1ParameterSpec
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.PSSParameterSpec
import java.security.spec.RSAPublicKeySpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher

object JvmRsaCryptoService : RsaCryptoService {
    private const val SPKI_FORMAT = "X.509"
    private const val PKCS8_FORMAT = "PKCS#8"

    private fun getCipher(algorithm: RsaAlgorithm.RsaEncryptionAlgorithm): Cipher = when (algorithm) {
        RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 -> Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding")
        RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 -> Cipher.getInstance("RSA/NONE/OAEPWithSHA256AndMGF1Padding")
        else -> throw IllegalStateException("Algorithm not yet supported $algorithm")
    }

    private fun getSignature(algorithm: RsaAlgorithm.RsaSignatureAlgorithm): Signature = when (algorithm) {
        RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256 -> Signature.getInstance("SHA256withRSA/PSS").also {
            it.setParameter(PSSParameterSpec(
                "SHA-256",
                "MGF1",
                MGF1ParameterSpec.SHA256,
                32,
                1 // From PSSParameterSpec.TRAILER_FIELD_BC
            ))
        }
    }

    override suspend fun <A : RsaAlgorithm> generateKeyPair(
        algorithm: A,
        keySize: RsaCryptoService.KeySize
    ): RsaKeypair<A> {
        val rsaKeyGenerator: KeyPairGenerator = KeyPairGenerator.getInstance("RSA")
        rsaKeyGenerator.initialize(keySize.bitSize)
        val pair = rsaKeyGenerator.generateKeyPair()
        return RsaKeypair(
            PrivateRsaKey(pair.private as RSAPrivateCrtKey, algorithm).checkFormat(),
            PublicRsaKey(pair.public, algorithm).checkFormat()
        )
    }

    override suspend fun exportPrivateKeyPkcs8(key: PrivateRsaKey<*>): ByteArray =
        key.checkFormat().encoded

    override suspend fun exportPublicKeySpki(key: PublicRsaKey<*>): ByteArray =
        key.checkFormat().encoded

    override suspend fun <A : RsaAlgorithm> loadKeyPairPkcs8(algorithm: A, privateKeyPkcs8: ByteArray): RsaKeypair<A> {
        val keyFactory = KeyFactory.getInstance("RSA")
        val privateKeySpec = PKCS8EncodedKeySpec(privateKeyPkcs8)
        val privateKey = PrivateRsaKey(keyFactory.generatePrivate(privateKeySpec) as RSAPrivateCrtKey, algorithm)
        val publicKeySpec = RSAPublicKeySpec(privateKey.modulus, privateKey.publicExponent)
        val publicKey = PublicRsaKey(keyFactory.generatePublic(publicKeySpec), algorithm)
        return RsaKeypair(privateKey, publicKey)
    }

    override suspend fun <A : RsaAlgorithm> loadPublicKeySpki(algorithm: A, publicKeySpki: ByteArray): PublicRsaKey<A> {
        val keyFactory = KeyFactory.getInstance("RSA")
        val publicKeySpec = X509EncodedKeySpec(publicKeySpki)
        return PublicRsaKey(keyFactory.generatePublic(publicKeySpec), algorithm)
    }

    override suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> encrypt(
        algorithm: A,
        data: ByteArray,
        publicKey: PublicRsaKey<A>
    ): ByteArray =
        getCipher(algorithm).apply { init(Cipher.ENCRYPT_MODE, publicKey.key) }.doFinal(data)

    override suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> decrypt(
        algorithm: A,
        data: ByteArray,
        privateKey: PrivateRsaKey<A>
    ): ByteArray =
        getCipher(algorithm).apply { init(Cipher.DECRYPT_MODE, privateKey.key) }.doFinal(data)

    override suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> sign(
        algorithm: A,
        data: ByteArray,
        privateKey: PrivateRsaKey<A>
    ): ByteArray =
        getSignature(algorithm).apply {
            initSign(privateKey.key)
            update(data)
        }.sign()

    override suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> verifySignature(
        algorithm: A,
        signature: ByteArray,
        data: ByteArray,
        publicKey: PublicRsaKey<A>
    ): Boolean =
        getSignature(algorithm).apply {
            initVerify(publicKey.key)
            update(data)
        }.verify(signature)

    private fun <A : RsaAlgorithm> PublicRsaKey<A>.checkFormat() = this.also {
        check(format == SPKI_FORMAT) {
            """
            Generated public key should have format $SPKI_FORMAT but got $format.
            Make sure that the default security provider generates keys in the appropriate format.
            """.trimIndent()
        }
    }

    private fun <A : RsaAlgorithm> PrivateRsaKey<A>.checkFormat() = this.also {
        check(format == PKCS8_FORMAT) {
            """
            Generated private key should have format $PKCS8_FORMAT but got $format.
            Make sure that the default security provider generates keys in the appropriate format.
            """.trimIndent()
        }
    }
}
