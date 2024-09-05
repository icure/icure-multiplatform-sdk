package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.Article
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.utils.InternalIcureApi

data class EntityWithTypeInfo<T : HasEncryptionMetadata>(
	val entity: T,
	val type: EntityWithEncryptionMetadataTypeName
) : HasEncryptionMetadata by entity

@InternalIcureApi
data class EntityWithEncryptionMetadataStub(
	override val id: String,
	override val rev: String?,
	override val secretForeignKeys: Set<String>,
	override val cryptedForeignKeys: Map<String, Set<Delegation>>,
	override val delegations: Map<String, Set<Delegation>>,
	override val encryptionKeys: Map<String, Set<Delegation>>,
	override val securityMetadata: SecurityMetadata?,
) : HasEncryptionMetadata {
	override fun copyWithSecurityMetadata(
		securityMetadata: SecurityMetadata,
		secretForeignKeys: Set<String>
	): HasEncryptionMetadata = throw UnsupportedOperationException(
		"EntityWithEncryptionMetadataStub security metadata should not be updated, as the changes won't be saved"
	)
}

fun <T:Article> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Article)
fun <T:AccessLog> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.AccessLog)
fun <T:CalendarItem> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.CalendarItem)
fun <T:Classification> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Classification)
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

