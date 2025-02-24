package com.icure.cardinal.sdk.utils

private val DIGITS_RANGE = '0'.code .. '9'.code
private val LOWERCASE_RANGE = 'a'.code .. 'f'.code
private val UPPERCASE_RANGE = 'A'.code .. 'F'.code

fun String.isValidHex() =
	length % 2 == 0 && all { c -> c.code.let { it in DIGITS_RANGE || it in LOWERCASE_RANGE || it in UPPERCASE_RANGE }  }