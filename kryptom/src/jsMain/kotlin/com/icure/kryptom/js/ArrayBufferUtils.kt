package com.icure.kryptom.js

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array

/**
 * Convert an [ArrayBuffer] to a [ByteArray] (https://youtrack.jetbrains.com/issue/KT-30098).
 */
fun ArrayBuffer.toByteArray(): ByteArray = Int8Array(this).unsafeCast<ByteArray>()

/**
 * Convert an [ByteArray] to a [ArrayBuffer]
 */
fun ByteArray.toArrayBuffer(): ArrayBuffer = Int8Array(this.toTypedArray()).buffer
