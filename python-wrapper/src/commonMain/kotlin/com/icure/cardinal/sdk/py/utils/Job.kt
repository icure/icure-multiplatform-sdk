package com.icure.cardinal.sdk.py.utils

import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.asStableRef
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalForeignApi::class)
fun cancelJob(ptr: COpaquePointer) {
	runBlocking { ptr.asStableRef<Job>().get().cancelAndJoin() }
}