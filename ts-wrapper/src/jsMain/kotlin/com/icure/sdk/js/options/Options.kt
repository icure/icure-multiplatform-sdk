package com.icure.sdk.js.options

import com.icure.kryptom.crypto.external.adaptCryptoServiceForExternal
import com.icure.kryptom.crypto.external.adaptExternalCryptoService
import com.icure.sdk.js.crypto.CryptoStrategiesBridge
import com.icure.sdk.js.model.userGroup_toJs
import com.icure.sdk.js.options.external.ApiOptionsJs
import com.icure.sdk.js.options.external.EncryptedFieldsConfigurationJs
import com.icure.sdk.js.storage.loadKeyStorageOptions
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.EncryptedFieldsConfiguration
import kotlinx.coroutines.await

suspend fun ApiOptionsJs.toKt(): ApiOptions {
	val defaultApiOptions = ApiOptions()
	return ApiOptions(
		encryptedFields = this.encryptedFields?.toKt() ?: defaultApiOptions.encryptedFields,
		disableParentKeysInitialisation = this.disableParentKeysInitialisation ?: defaultApiOptions.disableParentKeysInitialisation,
		createTransferKeys = this.createTransferKeys ?: defaultApiOptions.createTransferKeys,
		cryptoService = this.cryptoService?.let { adaptExternalCryptoService(it) } ?: defaultApiOptions.cryptoService,
		saltPasswordWithApplicationId = this.saltPasswordWithApplicationId ?: defaultApiOptions.saltPasswordWithApplicationId,
		groupSelector = this.groupSelector?.let { groupSelectorJs ->
			{ ktGroups ->
				groupSelectorJs(ktGroups.map { userGroup_toJs(it) }.toTypedArray()).await()
			}
		} ?: defaultApiOptions.groupSelector,
		autoCreateEncryptionKeyForExistingLegacyData = this.autoCreateEncryptionKeyForExistingLegacyData ?: defaultApiOptions.autoCreateEncryptionKeyForExistingLegacyData,
		keyStorage = this.keyStorage?.let { loadKeyStorageOptions(it) } ?: defaultApiOptions.keyStorage,
		cryptoStrategies = this.cryptoStrategies?.let {
			CryptoStrategiesBridge(it, this.cryptoService ?: adaptCryptoServiceForExternal(defaultApiOptions.cryptoService))
		} ?: defaultApiOptions.cryptoStrategies
	)
}

private fun EncryptedFieldsConfigurationJs.toKt(): EncryptedFieldsConfiguration {
	val defaultConfig = EncryptedFieldsConfiguration()
	return EncryptedFieldsConfiguration(
		accessLog = this.accessLog?.toSet() ?: defaultConfig.accessLog,
		calendarItem = this.calendarItem?.toSet() ?: defaultConfig.calendarItem,
		contact = this.contact?.toSet() ?: defaultConfig.contact,
		service = this.service?.toSet() ?: defaultConfig.service,
		healthElement = this.healthElement?.toSet() ?: defaultConfig.healthElement,
		maintenanceTask = this.maintenanceTask?.toSet() ?: defaultConfig.maintenanceTask,
		patient = this.patient?.toSet() ?: defaultConfig.patient,
		message = this.message?.toSet() ?: defaultConfig.message,
		topic = this.topic?.toSet() ?: defaultConfig.topic,
		document = this.document?.toSet() ?: defaultConfig.document,
		form = this.form?.toSet() ?: defaultConfig.form,
		receipt = this.receipt?.toSet() ?: defaultConfig.receipt,
		classification = this.classification?.toSet() ?: defaultConfig.classification,
		timeTable = this.timeTable?.toSet() ?: defaultConfig.timeTable,
		invoice = this.invoice?.toSet() ?: defaultConfig.invoice
	)
}

