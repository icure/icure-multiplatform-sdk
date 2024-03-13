package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.base.HasTags
import com.icure.sdk.model.base.Versionable
import com.icure.sdk.model.specializations.HexString
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class CryptoActorStub(
  override val id: String,
  override val rev: String,
  override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
  override val aesExchangeKeys: Map<String, Map<String, Map<String, String>>> = emptyMap(),
  override val transferKeys: Map<String, Map<String, String>> = emptyMap(),
  override val privateKeyShamirPartitions: Map<String, String> = emptyMap(),
  override val publicKey: String? = null,
  override val publicKeysForOaepWithSha256: Set<String> = emptySet(),
  override val tags: Set<CodeStub> = emptySet(),
) : Versionable<String>, CryptoActor, HasTags
