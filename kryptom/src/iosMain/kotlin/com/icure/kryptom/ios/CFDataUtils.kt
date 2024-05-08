package com.icure.kryptom.ios

import com.icure.kryptom.utils.PlatformMethodException
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.CoreFoundation.CFDataCreate
import platform.CoreFoundation.CFDataGetBytes
import platform.CoreFoundation.CFDataGetLength
import platform.CoreFoundation.CFDataRef
import platform.CoreFoundation.CFRangeMake
import platform.CoreFoundation.CFRelease
import platform.CoreFoundation.kCFAllocatorDefault
import platform.darwin.UInt8Var

// Based on https://stackoverflow.com/questions/58521108/how-to-convert-kotlin-bytearray-to-nsdata-and-viceversa

/**
 * Creates CFData from a kotlin [ByteArray].
 * Warning: you will have to free the data afterwards.
 */
fun ByteArray.toCFData(): CFDataRef = this.usePinned {
	@Suppress("UNCHECKED_CAST") // Using raw bytes, no need to do "proper" conversions
	CFDataCreate(kCFAllocatorDefault, it.addressOf(0) as CPointer<UInt8Var>, size.toLong())
		?: throw PlatformMethodException("Could not create CFData from byte array, got null result", null)
}

/**
 * Converts [CFDataRef] to a kotlin [ByteArray] AND RELEASES THE DATA.
 */
fun CFDataRef.toByteArray(): ByteArray {
	val size = CFDataGetLength(this)
	val range = CFRangeMake(0, size)
	val bytes = ByteArray(size.toInt())
	@Suppress("UNCHECKED_CAST") // Using raw bytes, no need to do "proper" conversions
	bytes.usePinned { CFDataGetBytes(this, range, it.addressOf(0) as CPointer<UInt8Var>) }
	CFRelease(this)
	return bytes
}
