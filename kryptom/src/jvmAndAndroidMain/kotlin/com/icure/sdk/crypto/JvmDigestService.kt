package com.icure.sdk.crypto

import java.security.MessageDigest

object JvmDigestService : DigestService {
    override suspend fun sha256(data: ByteArray): ByteArray =
        MessageDigest.getInstance("SHA-256").digest(data)
}