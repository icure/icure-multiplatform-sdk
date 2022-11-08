package com.icure.sdk.crypto

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.String
import io.ktor.utils.io.core.toByteArray
import kotlin.random.Random

class RsaCryptoServiceTest : StringSpec({
    fun List<String>.trimToKeySize(keySize: RsaCryptoService.KeySize) =
        map { it.take(keySize.maxOaepEncryptionSizeBytes) }

    "Service should be able to encrypt and decrypt data" {
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(keySize)
            data.trimToKeySize(keySize).forEach { d ->
                val encrypted = cryptoService.rsa.encrypt(d.toByteArray(Charsets.UTF_8), keys.public)
                val decrypted = cryptoService.rsa.decrypt(encrypted, keys.private)
                String(decrypted, charset = Charsets.UTF_8) shouldBe d
            }
        }
    }

    "Service should be able to use exported then re-imported keys" {
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(keySize)
            val exportedPrivate = cryptoService.rsa.exportPrivateKeyPkcs8(keys.private)
            val exportedPublic = cryptoService.rsa.exportPublicKeySpki(keys.public)
            val reimportedKeys = cryptoService.rsa.loadKeyPairPkcs8(exportedPrivate)
            val reimportedPublicOnly = cryptoService.rsa.loadPublicKeySpki(exportedPublic)

            data.trimToKeySize(keySize).forEach { d ->
                listOf(keys.public, reimportedKeys.public, reimportedPublicOnly).map { // Encrypt with each public key
                    cryptoService.rsa.encrypt(d.toByteArray(Charsets.UTF_8), it)
                }.flatMap { encrypted -> // Decrypt with each private keys
                    listOf(keys.private, reimportedKeys.private).map {
                        cryptoService.rsa.decrypt(encrypted, keys.private)
                    }
                }.forEach {  // Ensure content is valid
                    String(it, charset = Charsets.UTF_8) shouldBe d
                }
            }
        }
    }

    "Generated keys should have expected size" {
        // Checking size by verifying the maximum data size for encryption.
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(keySize)
            val dataOverMax = Random.nextBytes(keySize.maxOaepEncryptionSizeBytes + 1)
            val maxData = dataOverMax.sliceArray(0 until keySize.maxOaepEncryptionSizeBytes)
            cryptoService.rsa.encrypt(maxData, keys.public)
            shouldThrowAny { cryptoService.rsa.encrypt(dataOverMax, keys.public) }
        }
    }

    "Attempting to load invalid keys should result in an error" {
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(keySize)
            val exportedPrivate = cryptoService.rsa.exportPrivateKeyPkcs8(keys.private)
            val exportedPublic = cryptoService.rsa.exportPublicKeySpki(keys.public)
            shouldThrowAny { cryptoService.rsa.loadKeyPairPkcs8(exportedPublic) }
            shouldThrowAny { cryptoService.rsa.loadPublicKeySpki(exportedPrivate) }
        }
    }
})