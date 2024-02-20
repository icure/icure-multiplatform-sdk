package com.icure.sdk.utils

import kotlin.js.Date

actual fun currentEpochMs(): Long = Date.now().toLong()
