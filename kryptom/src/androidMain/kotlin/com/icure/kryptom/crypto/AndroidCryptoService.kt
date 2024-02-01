package com.icure.kryptom.crypto

import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security

actual fun initCryptoProvider() {
	/*
	 * The android documentation mentions that some algorithms of bouncy castle are deprecated (https://developer.android.com/privacy-and-security/cryptography#bc-algorithms),
	 * but this only applies to algorithms that are also implemented by the android libraries, and in any case as long as
	 * we don't explicitly request the bouncy castle provider there is no issue.
	 */
	Security.addProvider(BouncyCastleProvider())
}