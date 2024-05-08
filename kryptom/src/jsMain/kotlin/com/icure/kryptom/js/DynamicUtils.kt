package com.icure.kryptom.js

import com.icure.kryptom.utils.PlatformMethodException

fun <T> parsingDynamic(
	obj: dynamic,
	block: DynamicParser.() -> T
): T =
	block(DynamicParser(obj))

class DynamicParser(
	val obj: dynamic
) {
	/**
	 * Expect to have a non-nullable field [name] of type [T].
	 * @throws PlatformMethodException If the field is not present or is not of the given type.
	 */
	inline fun <reified T : Any> expect(name: String): T =
		(obj[name] ?: throw PlatformMethodException("Field $name is missing")) as? T
			?: throw PlatformMethodException("Field $name is not of the expected type")

	/**
	 * Expect to have a non-nullable field [name] containing an array of [T].
	 * @throws PlatformMethodException If the field is not present or is not an array of [T].
	 */
	inline fun <reified T : Any> expectArray(name: String): Array<T> = (
		(obj[name] ?: throw PlatformMethodException("Field $name is missing")) as? Array<T>
			?: throw PlatformMethodException("Field $name is not of the expected type")
	).also {
		for (i in it.indices) {
			(it[i] as? T) ?: throw PlatformMethodException("Field $name[$i] is not of the expected type")
		}
	}
}