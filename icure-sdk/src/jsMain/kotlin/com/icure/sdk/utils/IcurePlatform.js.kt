package com.icure.sdk.utils

import io.ktor.util.PlatformUtils

actual val currentPlatform: IcurePlatform
	get() = if (PlatformUtils.IS_NODE) IcurePlatform.Node else IcurePlatform.Browser