@file:JsQualifier("options")
package com.icure.sdk.js.options.external

import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.sdk.js.crypto.CryptoStrategiesJs
import com.icure.sdk.js.model.UserGroupJs
import com.icure.sdk.js.storage.KeyStorageFacadeJs
import kotlin.js.Promise

@JsName("AuthenticationMethod")
external interface AuthenticationMethodJs

@JsName("SecretProviderAuthenticationOptions")
external interface SecretProviderAuthenticationOptionsJs {
	val loginUsername: String?
	val initialSecret: InitialSecretJs?
	val existingJwt: String?
	val existingRefreshJwt: String?
	val cacheSecrets: Boolean?
}

@JsName("AuthSecretProvider")
external interface AuthSecretProviderJs {
	fun getSecret(
		acceptedSecrets: Array<String>,
		previousAttempts: Array<AuthSecretDetailsJs>,
		authProcessApi: AuthenticationProcessApiJs
	): Promise<AuthSecretDetailsJs>
}

@JsName("AuthenticationProcessRequest")
external class AuthenticationProcessRequestJs(
	messageGwUrl: String,
	specId: String,
	requestId: String
) {
	val messageGwUrl: String
	val specId: String
	val requestId: String
}

@JsName("AuthSecretDetails")
external interface AuthSecretDetailsJs

@JsName("AuthenticationProcessApi")
external interface AuthenticationProcessApiJs {
	fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: String,
		userTelecom: String,
		captchaType: String,
		captchaKey: String,
		processTemplateParameters: AuthenticationProcessTemplateParametersJs?
	): Promise<AuthenticationProcessRequestJs>
}

@JsName("AuthenticationProcessTemplateParameters")
external interface AuthenticationProcessTemplateParametersJs {
	val firstName: String?
	val lastName: String?
}

@JsName("ApiOptions")
external interface ApiOptionsJs {
	val encryptedFields: EncryptedFieldsConfigurationJs?
	val disableParentKeysInitialisation: Boolean?
	val createTransferKeys: Boolean?
	val cryptoService: XCryptoService?
	val saltPasswordWithApplicationId: Boolean?
	val groupSelector: ((availableGroups: Array<UserGroupJs>) -> Promise<String>)?
	val autoCreateEncryptionKeyForExistingLegacyData: Boolean?
	val keyStorage: KeyStorageFacadeJs?
	val cryptoStrategies: CryptoStrategiesJs?
}

@JsName("BasicApiOptions")
external interface BasicApiOptionsJs {
	val encryptedFields: EncryptedFieldsConfigurationJs?
	val cryptoService: XCryptoService?
	val saltPasswordWithApplicationId: Boolean?
	val groupSelector: ((availableGroups: Array<UserGroupJs>) -> Promise<String>)?
}

@JsName("EncryptedFieldsConfiguration")
external interface EncryptedFieldsConfigurationJs {
	val accessLog: Array<String>?
	val calendarItem: Array<String>?
	val contact: Array<String>?
	val service: Array<String>?
	val healthElement: Array<String>?
	val maintenanceTask: Array<String>?
	val patient: Array<String>?
	val message: Array<String>?
	val topic: Array<String>?
	val document: Array<String>?
	val form: Array<String>?
	val receipt: Array<String>?
	val classification: Array<String>?
	val timeTable: Array<String>?
	val invoice: Array<String>?
}
