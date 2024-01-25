package com.icure.sdk.crypto

object IosDigestService : DigestService {
    override suspend fun sha256(data: ByteArray): ByteArray =
        TODO()
}