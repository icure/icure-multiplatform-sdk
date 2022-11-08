package com.icure.sdk.crypto

import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.interfaces.RSAPrivateCrtKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.RSAPublicKeySpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher

object JvmRsaCryptoService : RsaCryptoService {
    private const val SPKI_FORMAT = "X.509"
    private const val PKCS8_FORMAT = "PKCS#8"

    private fun getCipher() = Cipher.getInstance("RSA/NONE/OAEPWithSHA-1AndMGF1Padding")

    override fun generateKeyPair(keySize: RsaCryptoService.KeySize): RsaKeypair {
        val rsaKeyGenerator: KeyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC")
        rsaKeyGenerator.initialize(keySize.bitSize)
        val pair = rsaKeyGenerator.generateKeyPair()
        return RsaKeypair(
            PrivateRsaKey(pair.private as RSAPrivateCrtKey).checkFormat(),
            PublicRsaKey(pair.public).checkFormat()
        )
    }

    override fun exportPrivateKeyPkcs8(key: PrivateRsaKey): ByteArray =
        key.checkFormat().encoded

    override fun exportPublicKeySpki(key: PublicRsaKey): ByteArray =
        key.checkFormat().encoded

    override fun loadKeyPairPkcs8(privateKeyPkcs8: ByteArray): RsaKeypair {
        val keyFactory = KeyFactory.getInstance("RSA")
        val privateKeySpec = PKCS8EncodedKeySpec(privateKeyPkcs8)
        val privateKey = PrivateRsaKey(keyFactory.generatePrivate(privateKeySpec) as RSAPrivateCrtKey)
        val publicKeySpec = RSAPublicKeySpec(privateKey.modulus, privateKey.publicExponent)
        val publicKey = PublicRsaKey(keyFactory.generatePublic(publicKeySpec))
        return RsaKeypair(privateKey, publicKey)
    }

    override fun loadPublicKeySpki(publicKeySpki: ByteArray): PublicRsaKey {
        val keyFactory = KeyFactory.getInstance("RSA")
        val publicKeySpec = X509EncodedKeySpec(publicKeySpki)
        return PublicRsaKey(keyFactory.generatePublic(publicKeySpec))
    }

    override fun encrypt(data: ByteArray, publicKey: PublicRsaKey): ByteArray =
        getCipher().apply { init(Cipher.ENCRYPT_MODE, publicKey.key) }.doFinal(data)

    override fun decrypt(data: ByteArray, privateKey: PrivateRsaKey): ByteArray =
        getCipher().apply { init(Cipher.DECRYPT_MODE, privateKey.key) }.doFinal(data)

    private fun PublicRsaKey.checkFormat() = this.also {
        check(format == SPKI_FORMAT) {
            """
            Generated public key should have format $SPKI_FORMAT but got $format.
            Make sure that the default security provider generates keys in the appropriate format.
            """.trimIndent()
        }
    }

    private fun PrivateRsaKey.checkFormat() = this.also {
        check(format == PKCS8_FORMAT) {
            """
            Generated private key should have format $PKCS8_FORMAT but got $format.
            Make sure that the default security provider generates keys in the appropriate format.
            """.trimIndent()
        }
    }
}
