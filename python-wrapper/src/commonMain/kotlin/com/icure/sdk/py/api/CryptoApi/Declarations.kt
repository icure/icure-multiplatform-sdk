// auto-generated file
package com.icure.sdk.py.api.CryptoApi

import com.icure.sdk.CardinalApis
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.builtins.serializer

public fun forceReloadBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.crypto.forceReload()
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun forceReloadAsync(sdk: CardinalApis,
                            resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.crypto.forceReload()
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
