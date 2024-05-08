package com.icure.kryptom.crypto

import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.String
import io.ktor.utils.io.core.toByteArray

// The keys and are generated for test purpose only, they are not real secrets

private const val encryptedDataSamplesIv = "Yfp9eibllZVoVBaznalQ8A=="

private val encryptedDataSamplesKeys = listOf(
	"vNImq6i5ff6Y8UhhqhyGWw==",
	"LVuo1b0Wb5n+LESjPUaKhmTHD73WEMPPsqd6Jy3cU+s="
)

private val encryptedDataSamples = mapOf(
	Pair(0, 0) to "Yfp9eibllZVoVBaznalQ8NtCJPfn/szzaDFwQ7fary0=",
	Pair(0, 1) to "Yfp9eibllZVoVBaznalQ8KOY61DvQiD4f/bqSn0ZCPA=",
	Pair(1, 0) to "Yfp9eibllZVoVBaznalQ8I7lYVDCKDfYuSjWcGqbGYc8WAC3WTJEeeZu1mIwLY4V",
	Pair(1, 1) to "Yfp9eibllZVoVBaznalQ8KeasfbPCmhO9ouO8hBKTAz1dKEHakS9DaT/NE5jH4he",
	Pair(2, 0) to "Yfp9eibllZVoVBaznalQ8BiSJpO2ac/mRMbq/67pTFHwBOkxoq/NhDIDq2aXeilB",
	Pair(2, 1) to "Yfp9eibllZVoVBaznalQ8FFfIK0+1Z+XcDX1tUQ87xBaKVTW0Ajc+Raf5kPPvYq2",
	Pair(3, 0) to "Yfp9eibllZVoVBaznalQ8F6jQtE/BTBI9cwVAvu0ZV3TqJhbOkCf1YIW1P21Gekl5hPN5uSE9Uj5LSWT7cp83Q==",
	Pair(3, 1) to "Yfp9eibllZVoVBaznalQ8LBeKF1pjdKp4CNIenI6BY53Tpu/dD3391cGaxQQKK/Of1+VHDjPpoaqc7HWwJq82A==",
	Pair(4, 0) to (
		"Yfp9eibllZVoVBaznalQ8BiSJpO2ac/mRMbq/67pTFGQX+YwhAXZGEwb01/PWV1v3BTXN4KzSR2gmWhvBx2K+IbnGo26h1zAU85nNFcq0z3J" +
			"ClsjkakQmBMWwwcQbhBaGQM9Kk5aAULOoIx1KI4bsZqsAMly0mUPc+xwhYhWMz3kcHw3snF+GhwMVU8DpZ4MV2kEsE7WG0om7aKtBqmZ" +
			"01lcfHmVEtoHIJNkfEvpHSGYzlG1hkgkeFNv32dOOLrTnXRWXW7ErfRyJXJtFggM03yqT7wwQQsrHVb0OiJ5+H84dt6pSy3ukBxyRT2r" +
			"dfZ0vMa0RK+vVBban88+72vM4WlkYUhhYKEaQqT/IUqoH+g89jyZor24ENpac4Tp0SabuZ83307+xV5MJRycd6JVAhbdO173uC/KUXC4" +
			"JOy22rY/RssT2RglSflZ9qsCauBIZcrldCA6lykiT/UAqGO1kB+bLjTSYT4y+Qg4PezOyPEpwuWfXcmi1DANEiXWoBjsdQBQeq664xpO" +
			"l85tR8V0TiCbD9WwA9FGdnjnE2Z4mblI2obooqaNK3Wvd/iF9w1DY6ilnU6s7ExWd/BwONZnV+ZuEf/ced1+X/EwaU399ukMr7hUpmSJ" +
			"ZnYs8qhsD3HT"
		),
	Pair(4, 1) to (
		"Yfp9eibllZVoVBaznalQ8FFfIK0+1Z+XcDX1tUQ87xAj3byLi0/kfgX9RUbpG6eaNOq2aC8KXu9g3aNDKRHruNUZTbWZUu1u23T07cUtmWlk" +
			"aWaCBYxODY1HUJHC6pB9pOS9Q2W+Ch5rK6bqCvG2xVEwiZYTG6JTx2f003qvwXqZAvk3DNioBRsIMcs3RsXdf55vgdBtR9ANvHp0b2FC" +
			"jHAQ3Fx2KuMSAr5kzwrv7kx9Khv6rKTsgq5xpaTtsrqlGwUyqNlY7Hx/L+wf+ikE3HW2J4ImzpfdAUMDkLzwKHme1a4oU0FAoUNDv/T0" +
			"Yx4M9Ws2YLRBKnaHP0qFaZNomWX5fjtdQ8J+NHepBJ5PzjXhuv7y2e1/L+RcreSS4v/XCiWMsXNBzGvlIW7SKtFcG43e8Jq0/cAHboWO" +
			"hsF6MmB5LCH+OLycMXNF4FpRf3/8JWFC0SulGgwtAtdAPV9EME/ePVKD5NaesdqNyKacaO5KPnWQoJ+w2be66paTapL3nt6DkQT/ko8/" +
			"UcweBsiC+svuYz+zEcSf2PI0ZqfCfl309nPT+xU6fHrFAPzlwTC3UpgoZHyfDojRKfI7q449CcV4gqmR71V6fGA0FW3yYavuV3np6uKy" +
			"27idXfmvL99A"
		)
)

class AesServiceTest : StringSpec({
	"Encrypted data should start with iv" {
		AesService.KeySize.entries.forEach { keySize ->
			val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding, keySize)
			data.forEach { d ->
				val iv = defaultCryptoService.strongRandom.randomBytes(AesService.IV_BYTE_LENGTH)
				val encrypted = defaultCryptoService.aes.encrypt(d.toByteArray(Charsets.UTF_8), key, iv)
				encrypted.take(AesService.IV_BYTE_LENGTH) shouldBe iv.toList()
			}
		}
	}

	"Service should be able to encrypt and decrypt data with keys of any size" {
		AesService.KeySize.entries.forEach { keySize ->
			val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding, keySize)
			data.forEach { d ->
				val encrypted = defaultCryptoService.aes.encrypt(d.toByteArray(Charsets.UTF_8), key)
				val decrypted = defaultCryptoService.aes.decrypt(encrypted, key)
				String(decrypted, charset = Charsets.UTF_8) shouldBe d
			}
		}
	}

	"Encrypted data should match expected" {
		val iv = base64Decode(encryptedDataSamplesIv)
		encryptedDataSamples.forEach { (dataAndKeyIndices, expectedEncryptedData) ->
			val d = data[dataAndKeyIndices.first].toByteArray(Charsets.UTF_8)
			val key = defaultCryptoService.aes.loadKey(
				AesAlgorithm.CbcWithPkcs7Padding,
				base64Decode(encryptedDataSamplesKeys[dataAndKeyIndices.second])
			)
			base64Encode(defaultCryptoService.aes.encrypt(d, key, iv)) shouldBe expectedEncryptedData
		}
	}

	"Exported then re-imported key should be able to decrypt data encrypted with the original key" {
		AesService.KeySize.values().forEach { keySize ->
			val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding, keySize)
			val reimportedKey = defaultCryptoService.aes.loadKey(
				AesAlgorithm.CbcWithPkcs7Padding,
				defaultCryptoService.aes.exportKey(key)
			)
			data.forEach { d ->
				val encrypted = defaultCryptoService.aes.encrypt(d.toByteArray(Charsets.UTF_8), key)
				val decrypted = defaultCryptoService.aes.decrypt(encrypted, reimportedKey)
				String(decrypted, charset = Charsets.UTF_8) shouldBe d
			}
		}
	}

	"Generated keys should have the requested size" {
		AesService.KeySize.entries.forEach { keySize ->
			val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding, keySize)
			defaultCryptoService.aes.exportKey(key).size shouldBe keySize.byteSize
		}
	}
})