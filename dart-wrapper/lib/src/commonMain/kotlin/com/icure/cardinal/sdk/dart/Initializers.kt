package com.icure.cardinal.sdk.dart

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.cardinal.sdk.auth.AuthenticationProcessTemplateParameters
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.dart.auth.CaptchaOptions
import com.icure.cardinal.sdk.dart.options.DartSdkOptions
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
object Initializers {
	fun initializeSdk(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		applicationIdString: String,
		baseUrlString: String,
		authenticationMethodString: String,
		storageFacade: StorageFacade,
		optionsString: String
	) {
		val applicationId = fullLanguageInteropJson.decodeFromString(
			String.serializer().nullable,
			applicationIdString,
		)
		val baseUrl = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			baseUrlString,
		)
		val authenticationMethod = fullLanguageInteropJson.decodeFromString(
			com.icure.cardinal.sdk.dart.auth.AuthenticationMethod.serializer(),
			authenticationMethodString
		)
		val options = fullLanguageInteropJson.decodeFromString(
			DartSdkOptions.serializer(),
			optionsString
		)
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			var didCreateNewKey = false
			val sdk = CardinalSdk.initialize(
				applicationId,
				baseUrl,
				authenticationMethod.toMultiplatform(),
				storageFacade,
				options.toMultiplatform().copy(
					cryptoStrategies = object : CryptoStrategies {
						override suspend fun notifyNewKeyCreated(
							apis: CardinalApis,
							key: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>,
							cryptoPrimitives: CryptoService
						) {
							didCreateNewKey = true
						}
					}
				)
			)
			// TODO remove this and crypto strategies
			println("Sdk initialized - didCreateNewKey=$didCreateNewKey")
			NativeReferences.create(sdk)
		}
	}

	fun initializeWithAuthProcess(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		applicationIdString: String,
		baseUrlString: String,
		messageGatewayUrlString: String,
		externalServicesSpecIdString: String,
		processIdString: String,
		userTelecomTypeString: String,
		userTelecomString: String,
		captchaOptionsString: String,
		baseStorage: StorageFacade,
		authenticationProcessTemplateParametersString: String,
		optionsString: String
	) {
		val applicationId = fullLanguageInteropJson.decodeFromString(
			String.serializer().nullable,
			applicationIdString,
		)
		val baseUrl = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			baseUrlString,
		)
		val messageGatewayUrl = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			messageGatewayUrlString,
		)
		val externalServicesSpecId = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			externalServicesSpecIdString,
		)
		val processId = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			processIdString,
		)
		val userTelecomType = fullLanguageInteropJson.decodeFromString(
			AuthenticationProcessTelecomType.serializer(),
			userTelecomTypeString
		)
		val userTelecom = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			userTelecomString,
		)
		val captchaOptions = fullLanguageInteropJson.decodeFromString(
			CaptchaOptions.serializer(),
			captchaOptionsString
		)
		val authenticationProcessTemplateParameters = fullLanguageInteropJson.decodeFromString(
			AuthenticationProcessTemplateParameters.serializer(),
			authenticationProcessTemplateParametersString
		)
		val options = fullLanguageInteropJson.decodeFromString(
			DartSdkOptions.serializer(),
			optionsString
		)
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val authStep = CardinalSdk.initializeWithProcess(
				applicationId,
				baseUrl,
				messageGatewayUrl,
				externalServicesSpecId,
				processId,
				userTelecomType,
				userTelecom,
				captchaOptions.toMultiplatform(),
				baseStorage,
				authenticationProcessTemplateParameters,
				options.toMultiplatform()
			)
			NativeReferences.create(authStep)
		}
	}

	fun completeAuthentication(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		authenticationStepId: String,
		validationCodeString: String,
	) {
		val authStep = NativeReferences.get<CardinalSdk.AuthenticationWithProcessStep>(authenticationStepId)
		val validationCode = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			validationCodeString,
		)
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val sdk = authStep.completeAuthentication(validationCode)
			NativeReferences.create(sdk)
		}
	}
}