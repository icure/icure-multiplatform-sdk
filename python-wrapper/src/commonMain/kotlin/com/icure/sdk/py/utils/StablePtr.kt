package com.icure.sdk.py.utils

import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.asStableRef


@OptIn(ExperimentalForeignApi::class)
fun disposeStablePtr(ptr: COpaquePointer) {
	ptr.asStableRef<Any>().dispose()
}