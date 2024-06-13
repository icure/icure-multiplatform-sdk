package com.icure.sdk.js.api

object DefaultParametersSupport {
	@Suppress("UNUSED_PARAMETER")
	inline fun <T_JS : Any, T_KT : Any> convertingOptionOrDefaultNonNull(
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

	@Suppress("UNUSED_PARAMETER")
	inline fun <T_JS, T_KT> convertingOptionOrDefaultNullable(
		options: dynamic,
		optionName: String,
		defaultValue: T_KT,
		converter: (T_JS) -> T_KT
	): T_KT =
		if (js("optionName in options")) {
			val option = js("options[optionName]") as T_JS
			converter(option)
		} else {
			defaultValue
		}
}