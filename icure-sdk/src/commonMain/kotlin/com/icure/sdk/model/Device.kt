package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.base.DataOwner
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.Named
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.SpkiHexString
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class Device(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val identifiers: List<Identifier> = emptyList(),
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  override val medicalLocationId: String? = null,
  public val externalId: String? = null,
  override val name: String? = null,
  public val type: String? = null,
  public val brand: String? = null,
  public val model: String? = null,
  public val serialNumber: String? = null,
  public val parentId: String? = null,
  public val picture: ByteArray? = null,
  override val properties: Set<PropertyStub> = emptySet(),
  override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
  override val aesExchangeKeys:
      Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
      emptyMap(),
  override val transferKeys: Map<String, Map<String, String>> = emptyMap(),
  override val privateKeyShamirPartitions: Map<String, String> = emptyMap(),
  override val publicKey: SpkiHexString? = null,
  override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
) : StoredDocument, ICureDocument<String>, Named, CryptoActor, DataOwner
