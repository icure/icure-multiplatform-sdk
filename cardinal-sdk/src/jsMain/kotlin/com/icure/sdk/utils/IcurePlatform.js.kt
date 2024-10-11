package com.icure.cardinal.sdk.utils

import io.ktor.util.PlatformUtils

actual val currentPlatform: CardinalPlatform
	get() = if (PlatformUtils.IS_NODE) CardinalPlatform.Node else CardinalPlatform.Browser