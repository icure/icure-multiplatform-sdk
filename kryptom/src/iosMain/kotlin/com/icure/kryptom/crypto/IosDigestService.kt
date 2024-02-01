package com.icure.kryptom.crypto

import kotlinx.cinterop.UByteVar
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.readBytes
import kotlinx.cinterop.toLong
import kotlinx.cinterop.usePinned
import platform.CoreCrypto.CC_SHA256

object IosDigestService : DigestService {
	private const val SHA256_DIGEST_LENGTH = 32

	// https://developer.apple.com/library/archive/documentation/System/Conceptual/ManPages_iPhoneOS/man3/CC_SHA256.3cc.html
	override suspend fun sha256(data: ByteArray): ByteArray = memScoped {
		val out = allocArray<UByteVar>(SHA256_DIGEST_LENGTH)
		data.usePinned { pinnedData ->
			val shaResult = CC_SHA256(pinnedData.addressOf(0), data.size.toUInt(), out)
			check(shaResult.toLong() == out.toLong()) {
				"CC_SHA256 should have returned the output address but got ${shaResult.toLong()} instead."
			}
		}
		out.readBytes(SHA256_DIGEST_LENGTH)
	}
}