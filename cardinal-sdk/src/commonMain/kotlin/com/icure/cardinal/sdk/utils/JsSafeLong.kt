package com.icure.cardinal.sdk.utils

private const val MAX_SAFE_INTEGER =  9007199254740991L
private const val MIN_SAFE_INTEGER = -9007199254740991L

/**
 * Checks if the long is safe for use in javascript as a plain number.
 */
fun Long.isJsSafe(): Boolean {
	return this in MIN_SAFE_INTEGER..MAX_SAFE_INTEGER
}