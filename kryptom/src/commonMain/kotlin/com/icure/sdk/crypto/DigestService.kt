package com.icure.sdk.crypto

interface DigestService {
    suspend fun sha256(data: ByteArray): ByteArray
}