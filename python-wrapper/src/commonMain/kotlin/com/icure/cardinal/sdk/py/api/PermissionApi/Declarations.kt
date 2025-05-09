// auto-generated file
package com.icure.cardinal.sdk.py.api.PermissionApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.security.Permission
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
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

@OptIn(InternalIcureApi::class)
public fun modifyUserPermissionsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserPermissionsParams>(params)
	runBlocking {
		sdk.permission.modifyUserPermissions(
			decodedParams.userId,
			decodedParams.permissions,
		)
	}
}.toPyString(ListSerializer(Permission.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyUserPermissionsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserPermissionsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.permission.modifyUserPermissions(
				decodedParams.userId,
				decodedParams.permissions,
			)
		}.toPyStringAsyncCallback(ListSerializer(Permission.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
