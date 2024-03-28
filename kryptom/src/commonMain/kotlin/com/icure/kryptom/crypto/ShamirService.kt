package com.icure.kryptom.crypto

class ShamirService(
	private val random: StrongRandom
) {
	private companion object {
		private const val bits = 8 // default number of bits
		private const val radix = 16 // work with HEX by default
		private const val size = 2.shl(bits - 1) // 2^bits
		private const val max = 2.shl(bits - 1) - 1 // 2^bits - 1
		private const val minBits = 3
		private const val maxBits = 16 // this permits up to 65,535 shares
		private const val bytesPerChar = 2
		private const val maxBytesPerChar = 6 // Math.pow(256,7) > Math.pow(2,53)

		// Primitive polynomials (in decimal form) for Galois Fields GF(2^n), for 2 <= n <= 30
		// The index of each term in the array corresponds to the n for that polynomial
		// i.e. to get the polynomial for n=16, use primitivePolynomials[16]
		private val primitivePolynomials = arrayOf(
			null,
			null,
			1,
			3,
			3,
			5,
			3,
			3,
			29,
			17,
			9,
			5,
			83,
			27,
			43,
			3,
			45,
			9,
			39,
			39,
			9,
			5,
			3,
			33,
			27,
			9,
			71,
			39,
			9,
			5,
			83
		)
		private val logs = IntArray(size)
		private val exps = IntArray(size)

		init {
			val primitive = primitivePolynomials[bits]!!

			var x = 1
			for (i in 0 until size) {
				exps[i] = x
				logs[x] = i
				x = x.shl(1)
				if (x >= size) {
					x = x.xor(primitive)
					x = x.and(max)
				}
			}
		}
	}

	/**
	 * Splits a number string `bits`-length segments, after first
	 * optionally zero-padding it to a length that is a multiple of `padLength.
	 * Returns array of integers (each less than 2^bits-1), with each element
	 * representing a `bits`-length segment of the input string from right to left,
	 * i.e. parts[0] represents the right-most `bits`-length segment of the input string.
	 */
	private fun split(str: String, padLength: Int = 0): List<Int> {
		val paddedStr = if (padLength != 0) {
			padLeft(str, padLength)
		} else str
		val parts = mutableListOf<Int>()
		var i = paddedStr.length
		while (i > bits) {
			parts.add(paddedStr.substring(i - bits, i).toInt(2))
			i -= bits
		}
		parts.add(paddedStr.substring(0, i).toInt(2))
		return parts
	}

	private fun padLeft(str: String, bits: Int = ShamirService.bits): String {
		val missing = str.length % bits
		return if (missing > 0) {
			"0".repeat(bits - missing) + str
		} else str
	}

	private fun bin2hex(str: String): String {
		val hexSb = StringBuilder()
		val paddedStr = padLeft(str, 4)
		for (i in 4..paddedStr.length step 4) {
			hexSb.append(
				when (paddedStr.substring(i - 4, i)) {
					"0000" -> "0"
					"0001" -> "1"
					"0010" -> "2"
					"0011" -> "3"
					"0100" -> "4"
					"0101" -> "5"
					"0110" -> "6"
					"0111" -> "7"
					"1000" -> "8"
					"1001" -> "9"
					"1010" -> "a"
					"1011" -> "b"
					"1100" -> "c"
					"1101" -> "d"
					"1110" -> "e"
					"1111" -> "f"
					else -> throw IllegalArgumentException("Invalid binary string")
				}
			)
		}
		return hexSb.toString()
	}

	private fun hex2bin(str: String): String {
		val binSb = StringBuilder()
		for (i in str.indices) {
			binSb.append(
				when (val it = str[i]) {
					'0' -> "0000"
					'1' -> "0001"
					'2' -> "0010"
					'3' -> "0011"
					'4' -> "0100"
					'5' -> "0101"
					'6' -> "0110"
					'7' -> "0111"
					'8' -> "1000"
					'9' -> "1001"
					'a' -> "1010"
					'b' -> "1011"
					'c' -> "1100"
					'd' -> "1101"
					'e' -> "1110"
					'f' -> "1111"
					else -> throw IllegalArgumentException("Invalid hex character $it")
				}
			)
		}
		return binSb.toString()
	}

	private fun random(bits: Int): String {
		fun construct(bits: Int, arr: ByteArray, size: Int): String? {
			var str = ""
			var i = 0
			val len = arr.size - 1
			while (i < len || str.length < bits) {
				str += padLeft(arr[i].toUByte().toString(radix), size)
				i++
			}
			str = str.substring(str.length - bits / 4)
			return if (str.any { it != '0' }) str else null
		}

		val elems = if (bits % 32 == 0) bits / 32 else (bits / 32) + 1
		val arr = ByteArray(elems)
		while (true) {
			random.fill(arr)
			val str = construct(bits, arr, 8)
			if (str != null) {
				return str
			}
		}
	}

	fun share(secretString: String, numShares: Int, threshold: Int): List<String> {
		if (numShares < 2 || numShares > max) {
			throw IllegalArgumentException("Number of shares must be an integer between 2 and 2^bits-1 ($max), inclusive.")
		}
		if (threshold > numShares || threshold < 2) {
			throw IllegalArgumentException("Threshold number of shares must be less than or equal to the number of shares and must be at least 2.")
		}
		val secret = split("1" + hex2bin(secretString), 0)
		val x = Array(numShares) { "" }
		val y = Array(numShares) { "" }
		for (i in secret.indices) {
			val subShares = getShares(secret[i], numShares, threshold)
			for (j in 0 until numShares) {
				x[j] = x[j].takeIf { it.isNotEmpty() } ?: subShares[j].x.toString(radix)
				y[j] = padLeft(subShares[j].y.toString(2)) + (if (y[j].isNotEmpty()) y[j] else "")
			}
		}
		val padding = max.toString(radix).length
		return y.mapIndexed { idx, b -> bits.toString(radix) + padLeft(x[idx], padding) + bin2hex(b) }
	}

	private data class Point(val x: Int, val y: Int)

	private fun getShares(secret: Int, numShares: Int, threshold: Int): List<Point> {
		val shares = mutableListOf<Point>()
		val coeffs = mutableListOf(secret)
		for (i in 1 until threshold) {
			coeffs.add(random(bits).toInt(radix))
		}
		for (i in 1..numShares) {
			shares.add(
				Point(
					i,
					horner(i, coeffs)
				)
			)
		}
		return shares
	}

	private fun horner(x: Int, coeffs: List<Int>): Int {
		var fx = 0
		for (i in (coeffs.size - 1) downTo 0) {
			if (fx == 0) {
				fx = coeffs[i]
				continue
			}
			fx = exps[(logs[x] + logs[fx]) % max] xor coeffs[i]
		}
		return fx
	}

	private data class ShareInfo(
		val bits: Int,
		val id: Int,
		val value: String
	)

	private fun processShare(share: String): ShareInfo {
		val bits = when (val it = share[0]) {
			'3' -> 3
			'4' -> 4
			'5' -> 5
			'6' -> 6
			'7' -> 7
			'8' -> 8
			'9' -> 9
			'a' -> 10
			'b' -> 11
			'c' -> 12
			'd' -> 13
			'e' -> 14
			'f' -> 15
			else -> throw IllegalArgumentException("Invalid share: invalid number of bits $it.")
		}
		val max = 2.shl(bits - 1) - 1
		val idLength = max.toString(radix).length

		val id = share.drop(1).take(idLength).toInt(radix)
		if (id < 1 || id > max) {
			throw IllegalArgumentException("Share id must be an integer between 1 and $max, inclusive.")
		}
		val shareValue = share.substring(idLength + 1)
		if (shareValue.isEmpty()) {
			throw IllegalArgumentException("Invalid share: zero-length share.")
		}
		return ShareInfo(bits, id, shareValue)
	}

	fun combine(shares: List<String>) =
		combineAt(0, shares)

	private fun combineAt(at: Int, shares: List<String>): String {
		require(shares.all { it.length == shares.first().length }) {
			"Shares should have the same length."
		}
		val x = mutableListOf<Int>()
		val y = mutableListOf<MutableList<Int>>()
		var result = ""
		var idx: Int
		for (share in shares) {
			val shareInfo = processShare(share)
			if (x.contains(shareInfo.id)) {
				continue
			}
			x.add(shareInfo.id)
			val shareValues = split(hex2bin(shareInfo.value))
			for (j in shareValues.indices) {
				val curr = y.getOrNull(j) ?: if (j == y.size) mutableListOf<Int>().also { y.add(it) } else throw AssertionError("Something unexpected occurred: invalid index.")
				curr.add(shareValues[j])
			}
		}

		for (i in y.indices) {
			result = padLeft(lagrange(at, x, y[i]).toString(2)) + result
		}

		if (at == 0) {
			// reconstructing the secret
			return bin2hex(result.drop(result.indexOf('1') + 1))
		} else {
			// generating a new share
			return bin2hex(result)
		}
	}

	private fun lagrange(at: Int, x: List<Int>, y: List<Int>): Int {
		var sum = 0
		var product: Int
		for (i in x.indices) {
			if (y[i] == 0) {
				continue
			}
			product = logs[y[i]]
			for (j in x.indices) {
				if (i == j) {
					continue
				}
				if (at == x[j]) {
					// happens when computing a share that is in the list of shares used to compute it
					product = -1 // fix for a zero product term, after which the sum should be sum^0 = sum, not sum^1
					break
				}
				product =
					(product + logs[at xor x[j]] - logs[x[i] xor x[j]] + max) % max
			}

			sum = if (product == -1) sum else sum xor exps[product]
		}
		return sum
	}
}