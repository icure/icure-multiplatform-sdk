package com.icure.sdk.options

import kotlinx.serialization.json.JsonElement

/**
 * Allows patching the json value of decrypted entities before deserialization.
 */
interface JsonPatcher {
	fun patchAccessLog(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchCalendarItem(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchContact(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * This method is used only when a service is retrieved by itself, without the rest of the contact.
	 * Services retrieved as part of a contact should be patched with [patchContact]
	 */
	fun patchIndividualService(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchHealthElement(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchMaintenanceTask(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchPatient(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchMessage(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchTopic(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchDocument(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchForm(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchReceipt(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchClassification(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchTimeTable(decryptedJson: JsonElement): JsonElement = decryptedJson
	fun patchInvoice(decryptedJson: JsonElement): JsonElement = decryptedJson
}
 