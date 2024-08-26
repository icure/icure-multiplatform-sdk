package com.icure.sdk.py

import com.icure.sdk.IcureBaseSdk
import com.icure.sdk.IcureSdk
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.options.BasicApiOptions
import com.icure.sdk.options.EncryptedFieldsConfiguration
import com.icure.sdk.storage.impl.FileStorageFacade
import com.icure.sdk.utils.Serialization
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.asStableRef
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

@Serializable
private data class PySdkParams(
	val baseUrl: String,
	val username: String,
	val password: String,
	val storagePath: String,
	val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	val disableParentKeysInitialisation: Boolean = false,
	val createTransferKeys: Boolean = true,
) {
	fun asApiOptions() = ApiOptions(
		encryptedFields = encryptedFields,
		disableParentKeysInitialisation = disableParentKeysInitialisation,
		createTransferKeys = createTransferKeys
	)
}

class SdkInitializationResult internal constructor(
	val success: IcureSdk?,
	val failure: String?
)

@OptIn(ExperimentalForeignApi::class)
fun initializeSdk(
	dataParams: String,
	cryptoStrategies: COpaquePointer?
): SdkInitializationResult = runBlocking {
	kotlin.runCatching {
		val decodedParams = Serialization.json.decodeFromString<PySdkParams>(dataParams)
		IcureSdk.initialize(
			null,
			decodedParams.baseUrl,
			AuthenticationMethod.UsingCredentials(
				UsernamePassword(
					decodedParams.username,
					decodedParams.password
				)
			),
			FileStorageFacade(decodedParams.storagePath),
			decodedParams.asApiOptions().copy(
				cryptoStrategies = cryptoStrategies?.asStableRef<CryptoStrategies>()?.get()
			)
		)
	}.fold(
		onSuccess = { SdkInitializationResult(it, null) },
		onFailure = { SdkInitializationResult(null, it.stackTraceToString()) }
	)
}

@Serializable
private data class PyBaseSdkParams(
	val baseUrl: String,
	val username: String,
	val password: String,
	val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration()
) {
	fun asApiOptions() = BasicApiOptions(
		encryptedFields = encryptedFields
	)
}

fun initializeBaseSdk(
	dataParams: String,
): IcureBaseSdk = runBlocking {
	val decodedParams = Serialization.json.decodeFromString<PyBaseSdkParams>(dataParams)
	IcureBaseSdk.initialize(
		null,
		decodedParams.baseUrl,
		AuthenticationMethod.UsingCredentials(UsernamePassword(decodedParams.username, decodedParams.password)),
		decodedParams.asApiOptions()
	)
}