package com.icure.kryptom.ios

import kotlinx.cinterop.addressOf
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.create
import platform.posix.memcpy

// Based on https://stackoverflow.com/questions/58521108/how-to-convert-kotlin-bytearray-to-nsdata-and-viceversa

/**
 * Converts a kotlin [ByteArray] to [NSData], for interoperability with objective-c.
 */
fun ByteArray.toNSData(): NSData =
	// This `create` copies the bytes, so it if fine to return the NSData outside of the `memScoped`, even though the
	// allocated array is free
	memScoped { NSData.create(bytes = allocArrayOf(this@toNSData), length = this@toNSData.size.toULong()) }

/**
 * Converts [NSData] to a kotlin [ByteArray], for interoperability with objective-c.
 */
fun NSData.toByteArray(): ByteArray =
	ByteArray(length.toInt()).also { array -> array.usePinned { memcpy(it.addressOf(0), bytes, length) } }
