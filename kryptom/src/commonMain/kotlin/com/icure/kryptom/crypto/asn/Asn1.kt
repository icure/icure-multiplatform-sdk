package com.icure.kryptom.crypto.asn

import com.icure.kryptom.crypto.asn.AsnUtils.prependTagAndLength
import com.icure.kryptom.crypto.asn.AsnUtils.toByteArray
import com.icure.kryptom.crypto.asn.AsnUtils.toInt
import com.icure.kryptom.crypto.asn.AsnUtils.toOidByteArray

// Collection of utilities to parse and generate ASN.1 objects. We may generalise them in future if needed, but for
// now they are very specific for this use case and should not be used elsewhere.
object AsnUtils {
	fun ByteArray.toInt() = this.toLong().toInt()
	fun ByteArray.toLong() = this.fold(0L) { acc, byte -> (acc shl 8) or byte.toUByte().toLong() }

	fun String.toOidByteArray(): ByteArray {
		val oidParts = this.split('.').map { it.toInt() }
		val firstByte = (oidParts[0] * 40 + oidParts[1]).toByte()
		val otherBytes = oidParts.drop(2).flatMap { it.toBase128() }
		return byteArrayOf(firstByte) + otherBytes.toByteArray()
	}

	fun Int.toBase128(): List<Byte> {
		var value = this
		val bytes = mutableListOf<Byte>()
		do {
			var byte = (value and 0x7F)
			if (bytes.isNotEmpty()) byte = byte or 0x80
			bytes.add(0, byte.toByte())
			value = value shr 7
		} while (value != 0)
		return bytes
	}

	fun Int.toAsn1Length(): ByteArray {
		return if (this < 0x80) {
			byteArrayOf(this.toByte())
		} else {
			val lengthBytes = this.toByteArray().dropWhile { it == 0.toByte() }
			byteArrayOf((0x80 or lengthBytes.size).toByte()) + lengthBytes
		}
	}

	fun ByteArray.prependTagAndLength(tag: Int): ByteArray {
		return byteArrayOf(tag.toByte()) + this.size.toAsn1Length() + this
	}

	fun Int.toByteArray(): ByteArray {
		if (this == 0) return byteArrayOf(0)
		var i = this
		val result = ByteArray(4)
		for (index in 3 downTo 0) {
			result[index] = (i and 0xFF).toByte()
			i = i shr 8
		}
		return result.dropWhile { it == 0.toByte() }.toByteArray()
	}
}

sealed interface Asn1Object {
	fun pack(): ByteArray
	fun getTag(): Int = when (this) {
		is Asn1Integer -> 0x02
		is Asn1OctetString -> 0x04
		is Asn1Sequence -> 0x30
		is Asn1Enumerated -> 0x0A
		is Asn1Null -> 0x05
		is Asn1Oid -> 0x06
		is Asn1Boolean -> 0x01
		is Asn1BitString -> 0x03
	}

	// Note: does not automatically prepend 0 byte if the first bit is 1
	data class Asn1Integer(val value: ByteArray) : Asn1Object {
		override fun pack() = value.prependTagAndLength(getTag())
	}

	data class Asn1OctetString(val value: ByteArray) : Asn1Object {
		val nested: Asn1Object?
			get() = try {
				this.value.toAsn1()
			} catch (e: Exception) {
				null
			}

		override fun pack() = value.prependTagAndLength(getTag())
	}

	data class Asn1Sequence(val value: List<Asn1Object>) : Asn1Object {
		override fun pack() = value.fold(ByteArray(0)) { acc, asn1Object ->
			acc + asn1Object.pack()
		}.prependTagAndLength(getTag())
	}

	data class Asn1Enumerated(val value: Int) : Asn1Object {
		override fun pack() = value.toByteArray().prependTagAndLength(getTag())
	}

	class Asn1Null : Asn1Object {
		override fun pack() = byteArrayOf(getTag().toByte(), 0)
	}

	data class Asn1Oid(val value: String) : Asn1Object {
		override fun pack() = value.toOidByteArray().prependTagAndLength(getTag())
	}

	data class Asn1Boolean(val value: Boolean) : Asn1Object {
		override fun pack() = byteArrayOf(getTag().toByte(), 1, if (value) 0xFF.toByte() else 0)
	}

	data class Asn1BitString(val value: ByteArray) : Asn1Object {
		val nested: Asn1Object?
			get() = try {
				(this.value.takeIf { it[0] == 0.toByte() }
					?: throw IllegalArgumentException("Bit strings with non zero bit masks are not supported")).drop(1)
					.toByteArray().toAsn1()
			} catch (e: Exception) {
				null
			}

		override fun pack() = value.prependTagAndLength(getTag())
	}
}

fun ByteArray.toAsn1(): Asn1Object {
	var offset = 0

	fun next(): UByte = this[offset++].toUByte()
	fun readLength(): Int {
		var length = next().toInt()
		if (length and 0x80 != 0) {
			val numOctets = length and 0x7F
			length = 0
			repeat(numOctets) { length = (length shl 8) or next().toInt() }
		}
		return length
	}

	fun readContent(length: Int): ByteArray {
		return this.copyOfRange(offset, offset + length).also { offset += length }
	}

	fun parseOid(length: Int): String {
		val oidBytes = readContent(length)
		val firstByte = oidBytes[0]
		val oid = mutableListOf(firstByte / 40, firstByte % 40)
		var value = 0
		for (b in oidBytes.drop(1)) {
			value = (value shl 7) or (b.toInt() and 0x7F)
			if (b.toInt() and 0x80 == 0) {
				oid.add(value)
				value = 0
			}
		}
		return oid.joinToString(".")
	}

	fun parse(): Asn1Object {
		val tag = next().toInt()
		val length = readLength()
		return when (tag) {
			0x01 -> Asn1Object.Asn1Boolean(readContent(1).first() != 0.toByte())
			0x02 -> Asn1Object.Asn1Integer(readContent(length))
			0x03 -> Asn1Object.Asn1BitString(readContent(length))
			0x04 -> Asn1Object.Asn1OctetString(readContent(length))
			0x05 -> Asn1Object.Asn1Null()
			0x0A -> Asn1Object.Asn1Enumerated(readContent(length).toInt())
			0x06 -> Asn1Object.Asn1Oid(parseOid(length))
			0x30 -> {
				val end = offset + length
				val sequence = mutableListOf<Asn1Object>()
				while (offset < end) {
					sequence.add(parse())
				}
				Asn1Object.Asn1Sequence(sequence)
			}

			else -> throw IllegalArgumentException("Unsupported tag: $tag")
		}
	}

	return parse()
}

fun Asn1Object.pkcs1ToPkcs8() = Asn1Object.Asn1Sequence(
	listOf(
		Asn1Object.Asn1Integer(0.toByteArray()),
		Asn1Object.Asn1Sequence(
			listOf(
				Asn1Object.Asn1Oid("1.2.840.113549.1.1.1"),
				Asn1Object.Asn1Null()
			)
		),
		Asn1Object.Asn1OctetString(((this as? Asn1Object.Asn1Sequence)?.takeIf { it.value.size == 9 }
			?: throw IllegalArgumentException("PKCS1 is a sequence of 9 integers")).pack())
	)
)

fun Asn1Object.pkcs8ToPkcs1(): Asn1Object.Asn1Sequence = ((((this as? Asn1Object.Asn1Sequence)?.takeIf {
	it.value.size == 3 &&
		it.value[0] is Asn1Object.Asn1Integer &&
		it.value[1] is Asn1Object.Asn1Sequence &&
		(it.value[1] as Asn1Object.Asn1Sequence).let {
			it.value.size == 2 &&
				it.value[0] is Asn1Object.Asn1Oid &&
				(it.value[0] as Asn1Object.Asn1Oid).let { it.value == "1.2.840.113549.1.1.1" }
			it.value[1] is Asn1Object.Asn1Null
		} &&
		it.value[2] is Asn1Object.Asn1OctetString
}
	?: throw IllegalArgumentException("This is not a PKCS8")).value[2] as Asn1Object.Asn1OctetString).nested as? Asn1Object.Asn1Sequence)
	?: throw IllegalArgumentException("Octet string is not a PKCS1")

fun Asn1Object.pkcs1ToSpki() = Asn1Object.Asn1Sequence(
	listOf(
		Asn1Object.Asn1Sequence(
			listOf(
				Asn1Object.Asn1Oid("1.2.840.113549.1.1.1"),
				Asn1Object.Asn1Null()
			)
		),
		Asn1Object.Asn1BitString(((this as? Asn1Object.Asn1Sequence)?.takeIf { it.value.size == 2 }
			?: throw IllegalArgumentException("PKCS1 is a sequence of 2 integers")).pack().let { byteArrayOf(0) + it })
	)
)

fun Asn1Object.pkcs8PrivateToSpkiPublic() = Asn1Object.Asn1Sequence(
	listOf(
		Asn1Object.Asn1Sequence(
			listOf(
				Asn1Object.Asn1Oid("1.2.840.113549.1.1.1"),
				Asn1Object.Asn1Null()
			)
		),
		Asn1Object.Asn1BitString(
			(
				requireNotNull((this as? Asn1Object.Asn1Sequence)) { "Pksc8 should be a sequence" }
					.also { require (it.value.size == 3) { "Pkcs8 should have 3 elements" } }
					.value[2].let { requireNotNull(it as? Asn1Object.Asn1OctetString) { "3rd element of pkcs8 should be an octet string" } }
					.let { requireNotNull(it.nested as? Asn1Object.Asn1Sequence) { "3rd element of pkcs8 should represent a nested sequence" } }
					.also { require(it.value.size == 9) { "3rd element of pkcs8 should have 9 elements" } }
					.let { Asn1Object.Asn1Sequence(listOf(it.value[1], it.value[2])) }
			).pack().let { byteArrayOf(0) + it }
		)
	)
)


fun Asn1Object.spkiToPkcs1(): Asn1Object.Asn1Sequence = ((((this as? Asn1Object.Asn1Sequence)?.takeIf {
	it.value.size == 2 &&
		it.value[0] is Asn1Object.Asn1Sequence &&
		(it.value[0] as Asn1Object.Asn1Sequence).let {
			it.value.size == 2 &&
				it.value[0] is Asn1Object.Asn1Oid &&
				(it.value[0] as Asn1Object.Asn1Oid).let { it.value == "1.2.840.113549.1.1.1" }
			it.value[1] is Asn1Object.Asn1Null
		} &&
		it.value[1] is Asn1Object.Asn1BitString
}
	?: throw IllegalArgumentException("This is not a PKCS8")).value[1] as Asn1Object.Asn1BitString).nested as? Asn1Object.Asn1Sequence)
	?: throw IllegalArgumentException("Octet string is not a PKCS1")