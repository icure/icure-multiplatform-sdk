package com.icure.sdk.crypto

/**
 * Exception thrown when aes decryption fails, for example due to an invalid key.
 */
class AesDecryptionException(message: String, cause: Throwable?) : Exception(message, cause)
