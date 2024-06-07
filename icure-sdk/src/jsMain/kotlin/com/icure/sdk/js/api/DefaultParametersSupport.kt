package com.icure.sdk.js.api

object DefaultParametersSupport {
	inline fun <T_JS, T_KT> convertingOptionOrDefault(
		option: T_JS?,
		defaultValue: T_KT,
		converter: (T_JS) -> T_KT
	): T_KT =
		if (option !== undefined) {
			converter(option)
		} else {
			defaultValue
		}
}