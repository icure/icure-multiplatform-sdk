package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.LinkQualification
import kotlin.Comparable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class Service(
  override val id: String,
  public val transactionId: String? = null,
  public val identifier: List<Identifier> = emptyList(),
  public val contactId: String? = null,
  public val subContactIds: Set<String>? = null,
  public val plansOfActionIds: Set<String>? = null,
  public val healthElementsIds: Set<String>? = null,
  public val formIds: Set<String>? = null,
  public val secretForeignKeys: Set<String>? = null,
  public val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  public val delegations: Map<String, Set<Delegation>> = emptyMap(),
  public val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  public val label: String? = null,
  public val index: Long? = null,
  public val content: Map<String, Content> = emptyMap(),
  public val encryptedContent: String? = null,
  public val textIndexes: Map<String, String> = emptyMap(),
  public val valueDate: Long? = null,
  public val openingDate: Long? = null,
  public val closingDate: Long? = null,
  public val formId: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val endOfLife: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  public val comment: String? = null,
  public val status: Int? = null,
  public val invoicingCodes: Set<String> = emptySet(),
  public val notes: List<Annotation> = emptyList(),
  public val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
  override val codes: Set<CodeStub> = emptySet(),
  override val tags: Set<CodeStub> = emptySet(),
  override val encryptedSelf: String? = null,
  public val securityMetadata: SecurityMetadata? = null,
) : Encrypted, ICureDocument<String>, Comparable<Service>
