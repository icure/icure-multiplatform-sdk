package com.icure.cardinal.sdk.utils.generation

/**
 * Supports code generation by specifying that a `Map` should be represented as an object array.
 * This should only be used for maps where the string is not a valid pojo key.
 *
 * `flattenKey` and `keyEntryName` specify how the key of the map should be represented in the objects, and are mutually
 * exclusive options: either you set `flattenKey` to true or you set a non-empty value for `keyEntryName` (must be a
 * valid js variable identifier).
 *
 * `flattenValue` and `valueEntryName` are the corresponding options for how to represent the values in the objects.
 *
 * # Example
 *
 * ```kotlin
 * data class Foo(val a: String, val b: Boolean)
 *
 * fun example(x: @JsMapAsObjectArray(flattenKey = true, valueEntryName = "c") Map<Foo, Int>) {}
 * ```
 *
 * Becomes equivalent to
 *
 * ```typescript
 * type Foo = { a: string, b: boolean }
 *
 * function example(x: { a: string, b: boolean, c: number }[]) {}
 * ```
 */
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.SOURCE)
annotation class JsMapAsObjectArray(
	val flattenKey: Boolean = false,
	val keyEntryName: String = "",
	val flattenValue: Boolean = false,
	val valueEntryName: String = ""
) {}
