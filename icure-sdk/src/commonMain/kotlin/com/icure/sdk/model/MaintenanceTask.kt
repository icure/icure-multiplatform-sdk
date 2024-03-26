package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.embed.TaskStatus
import com.icure.sdk.model.specializations.Base64String
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface MaintenanceTask : StoredDocument, ICureDocument<String>,
    HasEncryptionMetadata, Encryptable {
  override val id: String

  override val rev: String?

  public val identifier: List<Identifier>

  override val created: Long?

  override val modified: Long?

  override val author: String?

  override val responsible: String?

  override val medicalLocationId: String?

  override val tags: Set<CodeStub>

  override val codes: Set<CodeStub>

  override val endOfLife: Long?

  override val deletionDate: Long?

  public val taskType: String?

  public val properties: Set<PropertyStub>

  public val status: TaskStatus

  override val secretForeignKeys: Set<String>

  override val cryptedForeignKeys: Map<String, Set<Delegation>>

  override val delegations: Map<String, Set<Delegation>>

  override val encryptionKeys: Map<String, Set<Delegation>>

  override val encryptedSelf: Base64String?

  override val securityMetadata: SecurityMetadata?
}

@SerialName
public data class DecryptedMaintenanceTask(
  override val id: String,
  override val rev: String? = null,
  override val identifier: List<Identifier> = emptyList(),
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  override val deletionDate: Long? = null,
  override val taskType: String? = null,
  override val properties: Set<DecryptedPropertyStub> = emptySet(),
  override val status: TaskStatus,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
) : MaintenanceTask

@SerialName
public data class EncryptedMaintenanceTask(
  override val id: String,
  override val rev: String? = null,
  override val identifier: List<Identifier> = emptyList(),
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  override val deletionDate: Long? = null,
  override val taskType: String? = null,
  override val properties: Set<EncryptedPropertyStub> = emptySet(),
  override val status: TaskStatus,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
) : MaintenanceTask

public fun MaintenanceTask.copy(
  id: String = this.id,
  rev: String? = this.rev,
  identifier: List<Identifier> = this.identifier,
  created: Long? = this.created,
  modified: Long? = this.modified,
  author: String? = this.author,
  responsible: String? = this.responsible,
  medicalLocationId: String? = this.medicalLocationId,
  tags: Set<CodeStub> = this.tags,
  codes: Set<CodeStub> = this.codes,
  endOfLife: Long? = this.endOfLife,
  deletionDate: Long? = this.deletionDate,
  taskType: String? = this.taskType,
  properties: Set<PropertyStub> = this.properties,
  status: TaskStatus = this.status,
  secretForeignKeys: Set<String> = this.secretForeignKeys,
  cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
  delegations: Map<String, Set<Delegation>> = this.delegations,
  encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
  encryptedSelf: Base64String? = this.encryptedSelf,
  securityMetadata: SecurityMetadata? = this.securityMetadata,
): MaintenanceTask {
                                      return when(this) {
                                          is DecryptedMaintenanceTask -> copy(id = id, rev = rev,
          identifier = identifier, created = created, modified = modified, author = author,
          responsible = responsible, medicalLocationId = medicalLocationId, tags = tags, codes =
          codes, endOfLife = endOfLife, deletionDate = deletionDate, taskType = taskType, properties
          = properties, status = status, secretForeignKeys = secretForeignKeys, cryptedForeignKeys =
          cryptedForeignKeys, delegations = delegations, encryptionKeys = encryptionKeys,
          encryptedSelf = encryptedSelf, securityMetadata = securityMetadata)
      is EncryptedMaintenanceTask -> copy(id = id, rev = rev, identifier = identifier, created =
          created, modified = modified, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, tags = tags, codes = codes, endOfLife = endOfLife,
          deletionDate = deletionDate, taskType = taskType, properties = properties, status =
          status, secretForeignKeys = secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys,
          delegations = delegations, encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf,
          securityMetadata = securityMetadata)
                                          }
}
