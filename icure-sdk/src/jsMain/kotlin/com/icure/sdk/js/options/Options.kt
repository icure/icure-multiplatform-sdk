package com.icure.sdk.js.options

import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.adaptExternalCryptoService
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.EncryptedFieldsConfiguration

@JsExport
@JsName("ApiOptions")
external interface ApiOptionsJs {
	val encryptedFields: EncryptedFieldsConfigurationJs?
	val disableParentKeysInitialisation: Boolean?
	val createTransferKeys: Boolean?
	val cryptoService: XCryptoService?
}

@JsExport
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

fun ApiOptionsJs.toKt(): ApiOptions {
	val defaultApiOptions = ApiOptions()
	return ApiOptions(
		encryptedFields = this.encryptedFields?.toKt() ?: defaultApiOptions.encryptedFields,
		disableParentKeysInitialisation = this.disableParentKeysInitialisation ?: defaultApiOptions.disableParentKeysInitialisation,
		createTransferKeys = this.createTransferKeys ?: defaultApiOptions.createTransferKeys,
		cryptoService = this.cryptoService?.let { adaptExternalCryptoService(it) } ?: defaultApiOptions.cryptoService
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

