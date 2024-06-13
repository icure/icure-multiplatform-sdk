package com.icure.sdk.js.api

object DefaultParametersSupport {
	@Suppress("UNUSED_PARAMETER")
	fun <T_JS : Any, T_KT : Any> convertingOptionOrDefaultNonNull(
		options: dynamic,
		optionName: String,
		defaultValue: T_KT,
		converter: (T_JS) -> T_KT
	): T_KT {
		val option = js("options[optionName]") as T_JS?
		return if (option != null) {
			converter(option)
		} else {
			defaultValue
		}
	}

	@Suppress("UNUSED_PARAMETER", "USELESS_ELVIS_RIGHT_IS_NULL", "UNCHECKED_CAST")
	fun <T_JS, T_KT> convertingOptionOrDefaultNullable(
		options: dynamic,
		optionName: String,
		defaultValue: T_KT,
		converter: (T_JS) -> T_KT
	): T_KT =
		if (js("optionName in options")) {
			val option = js("options[optionName]") as T_JS
			converter((option ?: null) as T_JS)
		} else {
			defaultValue
		}
}