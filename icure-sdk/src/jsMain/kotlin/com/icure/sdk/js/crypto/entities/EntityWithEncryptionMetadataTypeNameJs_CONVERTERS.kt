package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import kotlin.String

public fun entityWithEncryptionMetadataTypeName_toJs(obj: EntityWithEncryptionMetadataTypeName):
		String = obj.name

public fun entityWithEncryptionMetadataTypeName_fromJs(obj: String):
		EntityWithEncryptionMetadataTypeName = when (obj) {
	"Article" -> EntityWithEncryptionMetadataTypeName.Article
	"AccessLog" -> EntityWithEncryptionMetadataTypeName.AccessLog
	"CalendarItem" -> EntityWithEncryptionMetadataTypeName.CalendarItem
	"Classification" -> EntityWithEncryptionMetadataTypeName.Classification
	"ClassificationTemplate" -> EntityWithEncryptionMetadataTypeName.ClassificationTemplate
	"Contact" -> EntityWithEncryptionMetadataTypeName.Contact
	"Service" -> EntityWithEncryptionMetadataTypeName.Service
	"Document" -> EntityWithEncryptionMetadataTypeName.Document
	"Form" -> EntityWithEncryptionMetadataTypeName.Form
	"HealthElement" -> EntityWithEncryptionMetadataTypeName.HealthElement
	"Invoice" -> EntityWithEncryptionMetadataTypeName.Invoice
	"MaintenanceTask" -> EntityWithEncryptionMetadataTypeName.MaintenanceTask
	"Message" -> EntityWithEncryptionMetadataTypeName.Message
	"Patient" -> EntityWithEncryptionMetadataTypeName.Patient
	"Receipt" -> EntityWithEncryptionMetadataTypeName.Receipt
	"TimeTable" -> EntityWithEncryptionMetadataTypeName.TimeTable
	"Topic" -> EntityWithEncryptionMetadataTypeName.Topic
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName: $obj""")
}
