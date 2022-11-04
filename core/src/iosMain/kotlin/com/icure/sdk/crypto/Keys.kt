package com.icure.sdk.crypto

import platform.Foundation.NSData

// TODO
actual class PrivateRsaKey

// TODO
actual class PublicRsaKey

/**
 * Represents an aes key.
 * On CommonCrypto there is no specific class to represent an AesKey, any form of byte array is fine, however
 * representing the key as NSData should make the key more compatible to use with platform-specific functions, which
 * could be useful for example if the user needs to save it.
 */
actual typealias AesKey = NSData
