package com.icure.sdk.crypto

import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security

actual fun initCryptoProvider() {
    Security.addProvider(BouncyCastleProvider())
}