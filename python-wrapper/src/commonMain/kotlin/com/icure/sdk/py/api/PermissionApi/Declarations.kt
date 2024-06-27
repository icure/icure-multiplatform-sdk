// auto-generated file
package com.icure.sdk.py.api.PermissionApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.model.security.Permission
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ModifyUserPermissionsParams(
	public val userId: String,
	public val permissions: Permission,
)

public fun modifyUserPermissionsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyUserPermissionsParams>(params)
	runBlocking {
		sdk.permission.modifyUserPermissions(
			decodedParams.userId,
			decodedParams.permissions,
		)
	}
}.toPyString(ListSerializer(Permission.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyUserPermissionsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyUserPermissionsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.permission.modifyUserPermissions(
				decodedParams.userId,
				decodedParams.permissions,
			)
		}.toPyStringAsyncCallback(ListSerializer(Permission.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
