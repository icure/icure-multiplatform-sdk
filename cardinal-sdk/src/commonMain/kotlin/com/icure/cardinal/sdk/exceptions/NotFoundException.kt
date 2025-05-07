@file:OptIn(ExperimentalJsExport::class)

package com.icure.cardinal.sdk.exceptions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
class NotFoundException(msg: String) : Throwable(message = msg)
