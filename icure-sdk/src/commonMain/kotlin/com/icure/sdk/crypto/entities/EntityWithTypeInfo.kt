package com.icure.sdk.crypto.entities

import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.Article
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.Classification
import com.icure.sdk.model.Contact
import com.icure.sdk.model.Document
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
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.Serializable

@Serializable
data class EntityWithTypeInfo<T : HasEncryptionMetadata>(
	val entity: T,
	val type: EntityWithEncryptionMetadataTypeName
) : HasEncryptionMetadata by entity

@InternalIcureApi
@Serializable
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

@InternalIcureApi
fun <T:HasEncryptionMetadata> T.toEncryptionMetadataStub() = EntityWithEncryptionMetadataStub(
	id = id,
	rev = rev,
	secretForeignKeys = secretForeignKeys,
	cryptedForeignKeys = cryptedForeignKeys,
	delegations = delegations,
	encryptionKeys = encryptionKeys,
	securityMetadata = securityMetadata
)

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

