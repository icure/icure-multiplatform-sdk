package com.icure.kryptom.crypto

import com.icure.kryptom.crypto.asn.pkcs1ToPkcs8
import com.icure.kryptom.crypto.asn.pkcs1ToSpki
import com.icure.kryptom.crypto.asn.pkcs8ToPkcs1
import com.icure.kryptom.crypto.asn.spkiToPkcs1
import com.icure.kryptom.crypto.asn.toAsn1

/**
 * Converts a pkcs1-encoded private rsa key to pkcs8
 */
fun pkcs1ToPcks8(byteArray: ByteArray): ByteArray = byteArray.toAsn1().pkcs1ToPkcs8().pack()

/**
 * Converts a pkcs8-encoded private rsa key to pkcs1
 */
fun pkcs8ToPcks1(byteArray: ByteArray): ByteArray = byteArray.toAsn1().pkcs8ToPkcs1().pack()

/**
 * Converts a pkcs1-encoded public rsa key to spki
 */
fun pkcs1ToSpki(byteArray: ByteArray): ByteArray = byteArray.toAsn1().pkcs1ToSpki().pack()

/**
 * Converts a spki-encoded public rsa key to pkcs1
 */
fun spkiToPcks1(byteArray: ByteArray): ByteArray = byteArray.toAsn1().spkiToPkcs1().pack()
