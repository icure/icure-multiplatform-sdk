package com.icure.kryptom.crypto

import com.icure.kryptom.utils.PlatformMethodException
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Security.SecRandomCopyBytes
import platform.Security.errSecSuccess
import platform.Security.kSecRandomDefault

object IosStrongRandom : StrongRandom {
	override fun fill(array: ByteArray) {
		val returnCode = array.usePinned {
			SecRandomCopyBytes(kSecRandomDefault, array.size.toULong(), it.addressOf(0))
		}
		if (returnCode != errSecSuccess) throw PlatformMethodException(
			"Random bytes generation failed with code $returnCode",
			null
		)
	}

	// Not sure if UUID is cryptographically strong in iOS: not specified in the documentation.
	// Use default implementation based on randomBytes.
}
