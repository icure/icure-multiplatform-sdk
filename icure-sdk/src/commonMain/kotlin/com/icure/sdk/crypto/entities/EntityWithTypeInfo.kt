package com.icure.sdk.crypto.entities

import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.Article
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.Classification
import com.icure.sdk.model.ClassificationTemplate
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedAccessLog
import com.icure.sdk.model.DecryptedArticle
import com.icure.sdk.model.DecryptedCalendarItem
import com.icure.sdk.model.DecryptedClassification
import com.icure.sdk.model.DecryptedClassificationTemplate
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedInvoice
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.DecryptedReceipt
import com.icure.sdk.model.DecryptedTimeTable
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.EncryptedArticle
import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.EncryptedClassificationTemplate
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Form
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Receipt
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.Topic
import com.icure.sdk.model.base.HasEncryptionMetadata

data class EntityWithTypeInfo<T : HasEncryptionMetadata>(
	val entity: T,
	val type: EntityWithEncryptionMetadataTypeName
) : HasEncryptionMetadata by entity

fun Article.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Article)
fun AccessLog.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.AccessLog)
fun CalendarItem.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.CalendarItem)
fun Classification.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Classification)
fun ClassificationTemplate.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.ClassificationTemplate)
fun Contact.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Contact)
fun Document.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Document)
fun Form.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Form)
fun HealthElement.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.HealthElement)
fun Invoice.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Invoice)
fun MaintenanceTask.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.MaintenanceTask)
fun Message.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Message)
fun Patient.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Patient)
fun Receipt.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Receipt)
fun TimeTable.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.TimeTable)
fun Topic.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Topic)
fun EncryptedArticle.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Article)
fun EncryptedAccessLog.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.AccessLog)
fun EncryptedCalendarItem.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.CalendarItem)
fun EncryptedClassification.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Classification)
fun EncryptedClassificationTemplate.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.ClassificationTemplate)
fun EncryptedContact.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Contact)
fun EncryptedDocument.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Document)
fun EncryptedForm.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Form)
fun EncryptedHealthElement.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.HealthElement)
fun EncryptedInvoice.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Invoice)
fun EncryptedMaintenanceTask.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.MaintenanceTask)
fun EncryptedMessage.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Message)
fun EncryptedPatient.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Patient)
fun EncryptedReceipt.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Receipt)
fun EncryptedTimeTable.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.TimeTable)
fun EncryptedTopic.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Topic)
fun DecryptedArticle.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Article)
fun DecryptedAccessLog.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.AccessLog)
fun DecryptedCalendarItem.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.CalendarItem)
fun DecryptedClassification.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Classification)
fun DecryptedClassificationTemplate.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.ClassificationTemplate)
fun DecryptedContact.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Contact)
fun DecryptedDocument.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Document)
fun DecryptedForm.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Form)
fun DecryptedHealthElement.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.HealthElement)
fun DecryptedInvoice.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Invoice)
fun DecryptedMaintenanceTask.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.MaintenanceTask)
fun DecryptedMessage.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Message)
fun DecryptedPatient.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Patient)
fun DecryptedReceipt.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Receipt)
fun DecryptedTimeTable.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.TimeTable)
fun DecryptedTopic.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Topic)
