package com.icure.sdk.py.options.PyJsonPatcher

import com.icure.sdk.options.JsonPatcher
import com.icure.sdk.py.utils.withResultHolder
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.cstr
import kotlinx.cinterop.invoke
import kotlinx.serialization.json.JsonElement

@OptIn(ExperimentalForeignApi::class)
fun createJsonPatcher(
	pyPatchAccessLog: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchCalendarItem: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchContact: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchIndividualService: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchHealthElement: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchMaintenanceTask: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchPatient: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchMessage: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchTopic: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchDocument: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchForm: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchReceipt: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchClassification: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchTimeTable: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
	pyPatchInvoice: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?,
): COpaquePointer {
	val patcher: JsonPatcher = object : JsonPatcher {
		private val ktPatchAccessLog = pyPatchToKt(pyPatchAccessLog)
		private val ktPatchCalendarItem = pyPatchToKt(pyPatchCalendarItem)
		private val ktPatchContact = pyPatchToKt(pyPatchContact)
		private val ktPatchIndividualService = pyPatchToKt(pyPatchIndividualService)
		private val ktPatchHealthElement = pyPatchToKt(pyPatchHealthElement)
		private val ktPatchMaintenanceTask = pyPatchToKt(pyPatchMaintenanceTask)
		private val ktPatchPatient = pyPatchToKt(pyPatchPatient)
		private val ktPatchMessage = pyPatchToKt(pyPatchMessage)
		private val ktPatchTopic = pyPatchToKt(pyPatchTopic)
		private val ktPatchDocument = pyPatchToKt(pyPatchDocument)
		private val ktPatchForm = pyPatchToKt(pyPatchForm)
		private val ktPatchReceipt = pyPatchToKt(pyPatchReceipt)
		private val ktPatchClassification = pyPatchToKt(pyPatchClassification)
		private val ktPatchTimeTable = pyPatchToKt(pyPatchTimeTable)
		private val ktPatchInvoice = pyPatchToKt(pyPatchInvoice)

		override fun patchAccessLog(decryptedJson: JsonElement): JsonElement =
			ktPatchAccessLog(decryptedJson)

		override fun patchCalendarItem(decryptedJson: JsonElement): JsonElement =
			ktPatchCalendarItem(decryptedJson)

		override fun patchContact(decryptedJson: JsonElement): JsonElement =
			ktPatchContact(decryptedJson)

		override fun patchIndividualService(decryptedJson: JsonElement): JsonElement =
			ktPatchIndividualService(decryptedJson)

		override fun patchHealthElement(decryptedJson: JsonElement): JsonElement =
			ktPatchHealthElement(decryptedJson)

		override fun patchMaintenanceTask(decryptedJson: JsonElement): JsonElement =
			ktPatchMaintenanceTask(decryptedJson)

		override fun patchPatient(decryptedJson: JsonElement): JsonElement =
			ktPatchPatient(decryptedJson)

		override fun patchMessage(decryptedJson: JsonElement): JsonElement =
			ktPatchMessage(decryptedJson)

		override fun patchTopic(decryptedJson: JsonElement): JsonElement =
			ktPatchTopic(decryptedJson)

		override fun patchDocument(decryptedJson: JsonElement): JsonElement =
			ktPatchDocument(decryptedJson)

		override fun patchForm(decryptedJson: JsonElement): JsonElement =
			ktPatchForm(decryptedJson)

		override fun patchReceipt(decryptedJson: JsonElement): JsonElement =
			ktPatchReceipt(decryptedJson)

		override fun patchClassification(decryptedJson: JsonElement): JsonElement =
			ktPatchClassification(decryptedJson)

		override fun patchTimeTable(decryptedJson: JsonElement): JsonElement =
			ktPatchTimeTable(decryptedJson)

		override fun patchInvoice(decryptedJson: JsonElement): JsonElement =
			ktPatchInvoice(decryptedJson)
	}
	return StableRef.create(patcher).asCPointer()
}

private val unchanged: (JsonElement) -> JsonElement = { it }

@OptIn(ExperimentalForeignApi::class)
private fun pyPatchToKt(
	pyPatch: CPointer<CFunction<(resultHolder: COpaquePointer, json: CValues<ByteVar>) -> Unit>>?
): (JsonElement) -> JsonElement = if (pyPatch == null) {
	unchanged
} else {
	{ ktJson ->
		withResultHolder(JsonElement.serializer()) { resultHolder ->
			pyPatch.invoke(resultHolder, ktJson.toString().cstr)
		}
	}
}