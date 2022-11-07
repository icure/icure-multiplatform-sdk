package com.icure.sdk.crypto

import com.icure.sdk.utils.base64Decode
import com.icure.sdk.utils.base64Encode
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.String
import io.ktor.utils.io.core.toByteArray

val data = listOf(
    "Jojo",
    "Giovanni Giorgio",
    "Lorem ipsum dolor sit amet",
    "The quick brown fox jumps over the lazy dog",
    """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
    aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur
    sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.    
    """.trimIndent(),
    "Exactly 16 bytes"
)

// Data is randomly generated for test purpose only

val encryptedDataSamplesIv = "Yfp9eibllZVoVBaznalQ8A=="

val encryptedDataSamplesKeys = listOf(
    "vNImq6i5ff6Y8UhhqhyGWw==",
    "LVuo1b0Wb5n+LESjPUaKhmTHD73WEMPPsqd6Jy3cU+s="
)

val encryptedDataSamples = mapOf(
    Pair(0, 0) to "Yfp9eibllZVoVBaznalQ8NtCJPfn/szzaDFwQ7fary0=",
    Pair(0, 1) to "Yfp9eibllZVoVBaznalQ8KOY61DvQiD4f/bqSn0ZCPA=",
    Pair(1, 0) to "Yfp9eibllZVoVBaznalQ8I7lYVDCKDfYuSjWcGqbGYc8WAC3WTJEeeZu1mIwLY4V",
    Pair(1, 1) to "Yfp9eibllZVoVBaznalQ8KeasfbPCmhO9ouO8hBKTAz1dKEHakS9DaT/NE5jH4he",
    Pair(2, 0) to "Yfp9eibllZVoVBaznalQ8BiSJpO2ac/mRMbq/67pTFHwBOkxoq/NhDIDq2aXeilB",
    Pair(2, 1) to "Yfp9eibllZVoVBaznalQ8FFfIK0+1Z+XcDX1tUQ87xBaKVTW0Ajc+Raf5kPPvYq2",
    Pair(3, 0) to "Yfp9eibllZVoVBaznalQ8F6jQtE/BTBI9cwVAvu0ZV3TqJhbOkCf1YIW1P21Gekl5hPN5uSE9Uj5LSWT7cp83Q==",
    Pair(3, 1) to "Yfp9eibllZVoVBaznalQ8LBeKF1pjdKp4CNIenI6BY53Tpu/dD3391cGaxQQKK/Of1+VHDjPpoaqc7HWwJq82A==",
    Pair(4, 0) to "Yfp9eibllZVoVBaznalQ8BiSJpO2ac/mRMbq/67pTFGQX+YwhAXZGEwb01/PWV1v3BTXN4KzSR2gmWhvBx2K+IbnGo26h1zAU85nNFcq0z3JClsjkakQmBMWwwcQbhBaGQM9Kk5aAULOoIx1KI4bsZqsAMly0mUPc+xwhYhWMz3kcHw3snF+GhwMVU8DpZ4MV2kEsE7WG0om7aKtBqmZ01lcfHmVEtoHIJNkfEvpHSGYzlG1hkgkeFNv32dOOLrTnXRWXW7ErfRyJXJtFggM03yqT7wwQQsrHVb0OiJ5+H84dt6pSy3ukBxyRT2rdfZ0vMa0RK+vVBban88+72vM4WlkYUhhYKEaQqT/IUqoH+g89jyZor24ENpac4Tp0SabuZ83307+xV5MJRycd6JVAhbdO173uC/KUXC4JOy22rY/RssT2RglSflZ9qsCauBIZcrldCA6lykiT/UAqGO1kB+bLjTSYT4y+Qg4PezOyPEpwuWfXcmi1DANEiXWoBjsdQBQeq664xpOl85tR8V0TiCbD9WwA9FGdnjnE2Z4mblI2obooqaNK3Wvd/iF9w1DY6ilnU6s7ExWd/BwONZnV+ZuEf/ced1+X/EwaU399ukMr7hUpmSJZnYs8qhsD3HT",
    Pair(4, 1) to "Yfp9eibllZVoVBaznalQ8FFfIK0+1Z+XcDX1tUQ87xAj3byLi0/kfgX9RUbpG6eaNOq2aC8KXu9g3aNDKRHruNUZTbWZUu1u23T07cUtmWlkaWaCBYxODY1HUJHC6pB9pOS9Q2W+Ch5rK6bqCvG2xVEwiZYTG6JTx2f003qvwXqZAvk3DNioBRsIMcs3RsXdf55vgdBtR9ANvHp0b2FCjHAQ3Fx2KuMSAr5kzwrv7kx9Khv6rKTsgq5xpaTtsrqlGwUyqNlY7Hx/L+wf+ikE3HW2J4ImzpfdAUMDkLzwKHme1a4oU0FAoUNDv/T0Yx4M9Ws2YLRBKnaHP0qFaZNomWX5fjtdQ8J+NHepBJ5PzjXhuv7y2e1/L+RcreSS4v/XCiWMsXNBzGvlIW7SKtFcG43e8Jq0/cAHboWOhsF6MmB5LCH+OLycMXNF4FpRf3/8JWFC0SulGgwtAtdAPV9EME/ePVKD5NaesdqNyKacaO5KPnWQoJ+w2be66paTapL3nt6DkQT/ko8/UcweBsiC+svuYz+zEcSf2PI0ZqfCfl309nPT+xU6fHrFAPzlwTC3UpgoZHyfDojRKfI7q449CcV4gqmR71V6fGA0FW3yYavuV3np6uKy27idXfmvL99A"
)

class AesCryptoServiceTest : StringSpec({
    "Encrypted data should start with iv" {
        AesCryptoService.KeySize.values().forEach { keySize ->
            val key = cryptoService.aes.generateKey(keySize)
            data.forEach { d ->
                val iv = strongRandom.randomBytes(AesCryptoService.IV_BYTE_LENGTH)
                val encrypted = cryptoService.aes.encrypt(d.toByteArray(Charsets.UTF_8), key, iv)
                encrypted.take(AesCryptoService.IV_BYTE_LENGTH) shouldBe iv.toList()
            }
        }
    }

    "Service should be able to encrypt and decrypt data with keys of any size" {
        AesCryptoService.KeySize.values().forEach { keySize ->
            val key = cryptoService.aes.generateKey(keySize)
            data.forEach { d ->
                val encrypted = cryptoService.aes.encrypt(d.toByteArray(Charsets.UTF_8), key)
                val decrypted = cryptoService.aes.decrypt(encrypted, key)
                String(decrypted, charset = Charsets.UTF_8) shouldBe d
            }
        }
    }

    "Encrypted data should match expected" {
        val iv = base64Decode(encryptedDataSamplesIv)
        encryptedDataSamples.forEach { (dataToKeyIndices, expectedEncryptedData) ->
            val d = data[dataToKeyIndices.first].toByteArray(Charsets.UTF_8)
            val key = cryptoService.aes.loadKey(base64Decode(encryptedDataSamplesKeys[dataToKeyIndices.second]))
            base64Encode(cryptoService.aes.encrypt(d, key, iv)) shouldBe expectedEncryptedData
        }
    }

    "Exported then re-imported key should be able to decrypt data encrypted with the original key" {
        AesCryptoService.KeySize.values().forEach { keySize ->
            val key = cryptoService.aes.generateKey(keySize)
            val reimportedKey = cryptoService.aes.loadKey(cryptoService.aes.exportKey(key))
            data.forEach { d ->
                val encrypted = cryptoService.aes.encrypt(d.toByteArray(Charsets.UTF_8), key)
                val decrypted = cryptoService.aes.decrypt(encrypted, reimportedKey)
                String(decrypted, charset = Charsets.UTF_8) shouldBe d
            }
        }
    }
})