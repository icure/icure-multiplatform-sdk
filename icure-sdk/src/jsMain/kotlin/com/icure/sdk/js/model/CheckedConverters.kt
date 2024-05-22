package com.icure.sdk.js.model

import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.isJsSafe
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

	fun tryNumberToLong(number: Double): Long? {
		if (number.isNaN() || !number.isFinite() || floor(number) != number) {
			return null
		}
		if (number in MIN_SAFE_INTEGER_D..MAX_SAFE_INTEGER_D) {
			return number.toLong()
		}
		return null
	}

	fun numberToLong(number: Double?, description: String): Long? = number?.let { numberToLong(it, description) }

	fun longToNumber(long: Long): Double {
		ensure(long.isJsSafe()) {
			"Number is not in safe integer range: $long"
		}
		return long.toDouble()
	}

	fun longToNumber(long: Long?): Double? = long?.let { longToNumber(it) }

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

	fun numberToInt(number: Double?, description: String): Int? = number?.let { numberToInt(it, description) }

	fun intToNumber(int: Int): Int {
		return int
	}

	fun intToNumber(int: Int?): Int? = int

	fun numberToInstant(number: Double, description: String): Instant {
		return Instant.fromEpochMilliseconds(numberToLong(number, description))
	}

	fun numberToInstant(number: Double?, description: String): Instant? = number?.let { numberToInstant(it, description) }

	fun instantToNumber(instant: Instant): Double {
		return longToNumber(instant.toEpochMilliseconds())
	}

	fun instantToNumber(instant: Instant?): Double? = instant?.let { instantToNumber(it) }

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

	fun <K, V> mapToObject(
		map: Map<K, V>?,
		convertKey: (key: K) -> String,
		convertValue: (value: V) -> dynamic,
	): dynamic = map?.let { mapToObject(it, convertKey, convertValue) }

	fun <K, V> objectToMap(
		obj: dynamic,
		description: String,
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

	fun <K, V> objectToMapNullsafe(
		obj: dynamic,
		description: String,
		convertKey: (value: String) -> K,
		convertValue: (value: dynamic) -> V,
	): Map<K, V>? = if (obj == null) null else objectToMap(obj, description, convertKey, convertValue) // Can't use let on dynamic

	fun <KT, JS> arrayToList(
		array: Array<JS>,
		description: String,
		convertValue: (value: JS) -> KT,
	): List<KT> {
		return array.map { convertValue(it) }
	}

	fun <KT, JS> arrayToList(
		array: Array<JS>?,
		description: String,
		convertValue: (value: JS) -> KT,
	): List<KT>? = array?.let { arrayToList(it, description, convertValue) }

	fun <KT, JS> listToArray(
		list: List<KT>,
		convertValue: (value: KT) -> JS,
	): Array<JS> {
		return list.map { convertValue(it) }.toTypedArray()
	}

	fun <KT, JS> listToArray(
		list: List<KT>?,
		convertValue: (value: KT) -> JS,
	): Array<JS>? = list?.let { listToArray(it, convertValue) }

	fun <KT, JS> arrayToSet(
		array: Array<JS>,
		description: String,
		convertValue: (value: JS) -> KT,
	): Set<KT> {
		return array.mapTo(mutableSetOf()) { convertValue(it) }.also {
			require(it.size == array.size) {
				"$description will be converted to a set but contains duplicate values"
			}
		}
	}

	fun <KT, JS> arrayToSet(
		array: Array<JS>?,
		description: String,
		convertValue: (value: JS) -> KT,
	): Set<KT>? = array?.let { arrayToSet(it, description, convertValue) }

	fun <KT, JS> setToArray(
		set: Set<KT>,
		convertValue: (value: KT) -> JS,
	): Array<JS> {
		return set.map { convertValue(it) }.toTypedArray()
	}

	fun <KT, JS> setToArray(
		set: Set<KT>?,
		convertValue: (value: KT) -> JS,
	): Array<JS>? = set?.let { setToArray(it, convertValue) }

	fun zonedDateTimeToString(
		zonedDateTime: ZonedDateTime,
	): String {
		return zonedDateTime.toIso8601String()
	}

	fun zonedDateTimeToString(
		zonedDateTime: ZonedDateTime?,
	): String? = zonedDateTime?.let { zonedDateTimeToString(it) }

	fun stringToZonedDateTime(
		string: String,
		description: String
	): ZonedDateTime {
		return try {
			ZonedDateTime.fromIso8601String(string)
		} catch (e: Exception) {
			throw IllegalArgumentException("Invalid zoned date time $string @ $description", e)
		}
	}

	fun stringToZonedDateTime(
		string: String?,
		description: String
	): ZonedDateTime? = string?.let { stringToZonedDateTime(it, description) }

	@OptIn(ExperimentalSerializationApi::class)
	fun dynamicToJson(obj: dynamic, description: String): JsonElement =
		try {
			Json.decodeFromDynamic<JsonElement>(obj)
		} catch (e: Exception) {
			throw IllegalArgumentException("Invalid JSON object @ $description", e)
		}

	fun dynamicToJsonNullsafe(obj: dynamic, description: String): JsonElement? =
		// Note: can't use let on dynamic
		if (obj != null) dynamicToJson(obj, description) else null

	@OptIn(ExperimentalSerializationApi::class)
	fun jsonToDynamic(obj: JsonElement): dynamic =
		Json.encodeToDynamic<JsonElement>(obj)

	fun jsonToDynamic(obj: JsonElement?): dynamic =
		obj?.let { jsonToDynamic(it) }
}