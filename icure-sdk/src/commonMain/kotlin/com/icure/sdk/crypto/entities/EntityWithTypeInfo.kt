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

fun <T:Article> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Article)
fun <T:AccessLog> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.AccessLog)
fun <T:CalendarItem> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.CalendarItem)
fun <T:Classification> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Classification)
fun <T:ClassificationTemplate> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.ClassificationTemplate)
fun <T:Contact> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Contact)
fun <T:Document> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Document)
fun <T:Form> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Form)
fun <T:HealthElement> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.HealthElement)
fun <T:Invoice> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Invoice)
fun <T:MaintenanceTask> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.MaintenanceTask)
fun <T:Message> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Message)
fun <T:Patient> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Patient)
fun <T:Receipt> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Receipt)
fun <T:TimeTable> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.TimeTable)
fun <T:Topic> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Topic)

