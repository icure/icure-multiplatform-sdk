// auto-generated file
package com.icure.sdk.py.api.RoleApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.model.Role
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
import kotlinx.serialization.builtins.ListSerializer

public fun getAllRolesBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.role.getAllRoles()
	}
}.toPyString(ListSerializer(Role.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getAllRolesAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.getAllRoles()
		}.toPyStringAsyncCallback(ListSerializer(Role.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
