package com.icure.sdk.model.js

import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.time.ZonedDateTime
import kotlinx.datetime.Instant
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromDynamic
import kotlinx.serialization.json.encodeToDynamic
import kotlin.math.floor

/**
 * Contains functions to convert from standard Kotlin to JavaScript types in a "checked" way.
 * If the conversion could cause loss of information, an exception is thrown.
 */
@OptIn(InternalIcureApi::class)
object CheckedConverters {
	private const val MAX_SAFE_INTEGER_D = 9007199254740991.0
	private const val MIN_SAFE_INTEGER_D = -9007199254740991.0
	private const val MAX_SAFE_INTEGER = 9007199254740991
	private const val MIN_SAFE_INTEGER = -9007199254740991
	private const val MIN_INT_32_D = Int.MIN_VALUE.toDouble()
	private const val MAX_INT_32_D = Int.MAX_VALUE.toDouble()

	fun numberToLong(number: Double, description: String): Long {
		require(
			!number.isNaN()
				&& number.isFinite()
				&& floor(number) == number
		) {
			"$description should be a 64bits integer - got $number"
		}
		require (number in MIN_SAFE_INTEGER_D..MAX_SAFE_INTEGER_D) {
			"$description is outside of the safe integer range for javascript numbers, conversion may cause loss of precision - got $number"
		}
		return number.toLong()
	}

	fun longToNumber(long: Long): Double {
		ensure(long in MIN_SAFE_INTEGER..MAX_SAFE_INTEGER) {
			"Number is not in safe integer range: $long"
		}
		return long.toDouble()
	}

	fun numberToInt(number: Double, description: String): Int {
		require(
			!number.isNaN()
				&& number.isFinite()
				&& floor(number) == number
		) {
			"$description should be a 32bits integer - got $number"
		}
		require (number in MIN_INT_32_D..MAX_INT_32_D) {
			"$description is outside of the safe integer range for javascript numbers, conversion may cause loss of precision - got $number"
		}
		return number.toInt()
	}

	fun intToNumber(int: Int): Int {
		return int
	}

	fun numberToInstant(number: Double, description: String): Instant {
		return Instant.fromEpochMilliseconds(numberToLong(number, description))
	}

	fun instantToNumber(instant: Instant): Double {
		return longToNumber(instant.toEpochMilliseconds())
	}

	fun <K, V> mapToObject(
		map: Map<K, V>,
		convertKey: (key: K) -> String,
		convertValue: (value: V) -> dynamic,
	): dynamic {
		val obj = js("{}")
		for ((key, value) in map) {
			obj[convertKey(key)] = convertValue(value)
		}
		return obj
	}

	fun <K, V> objectToMap(
		obj: dynamic,
		convertKey: (value: String) -> K,
		convertValue: (value: dynamic) -> V,
	): Map<K, V> {
		val map = mutableMapOf<K, V>()
		val entries = js("Object.entries(obj)") as Array<Array<dynamic>>
		for (keyValue in entries) {
			map[convertKey(keyValue[0] as String)] = convertValue(obj[keyValue[1]])
		}
		return map
	}

	fun <V> arrayToList(
		array: Array<dynamic>,
		convertValue: (value: dynamic) -> V,
	): List<V> {
		return array.map { convertValue(it) }
	}

	fun <V> listToArray(
		list: List<V>,
		convertValue: (value: V) -> dynamic,
	): Array<dynamic> {
		return list.map { convertValue(it) }.toTypedArray()
	}

	fun <V> arrayToSet(
		array: Array<dynamic>,
		description: String,
		convertValue: (value: dynamic) -> V,
	): Set<V> {
		return array.mapTo(mutableSetOf()) { convertValue(it) }.also {
			require(it.size == array.size) {
				"$description will be converted to a set but contains duplicate values"
			}
		}
	}

	fun <V> setToArray(
		set: Set<V>,
		convertValue: (value: V) -> dynamic,
	): Array<dynamic> {
		return set.map { convertValue(it) }.toTypedArray()
	}

	fun zonedDateTimeToString(
		zonedDateTime: ZonedDateTime,
	): String {
		return zonedDateTime.toIso8601String()
	}

	fun stringToZonedDateTime(
		string: String,
	): ZonedDateTime {
		return ZonedDateTime.fromIso8601String(string)
	}

	@OptIn(ExperimentalSerializationApi::class)
	fun toKotlinJson(obj: dynamic): JsonElement =
		Json.decodeFromDynamic<JsonElement>(obj)

	@OptIn(ExperimentalSerializationApi::class)
	fun fromKotlinJson(obj: JsonElement): dynamic =
		Json.encodeToDynamic<JsonElement>(obj)
}
