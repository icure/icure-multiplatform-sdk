// auto-generated file
package com.icure.sdk.py.api.ApplicationSettingsApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.model.ApplicationSettings
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

public fun getApplicationSettingsBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.applicationSettings.getApplicationSettings()
	}
}.toPyString(ListSerializer(ApplicationSettings.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getApplicationSettingsAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.applicationSettings.getApplicationSettings()
		}.toPyStringAsyncCallback(ListSerializer(ApplicationSettings.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateApplicationSettingsParams(
	public val applicationSettings: ApplicationSettings,
)

public fun createApplicationSettingsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateApplicationSettingsParams>(params)
	runBlocking {
		sdk.applicationSettings.createApplicationSettings(
			decodedParams.applicationSettings,
		)
	}
}.toPyString(ApplicationSettings.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createApplicationSettingsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateApplicationSettingsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.applicationSettings.createApplicationSettings(
				decodedParams.applicationSettings,
			)
		}.toPyStringAsyncCallback(ApplicationSettings.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UpdateApplicationSettingsParams(
	public val applicationSettings: ApplicationSettings,
)

public fun updateApplicationSettingsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateApplicationSettingsParams>(params)
	runBlocking {
		sdk.applicationSettings.updateApplicationSettings(
			decodedParams.applicationSettings,
		)
	}
}.toPyString(ApplicationSettings.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun updateApplicationSettingsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateApplicationSettingsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.applicationSettings.updateApplicationSettings(
				decodedParams.applicationSettings,
			)
		}.toPyStringAsyncCallback(ApplicationSettings.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
