package com.icure.sdk.model.base

import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.SpkiHexString
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public interface CryptoActor : Versionable<String>, HasTags {
  public val hcPartyKeys: Map<String, List<HexString>>

  public val aesExchangeKeys:
      Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>

  public val transferKeys: Map<String, Map<String, String>>

  public val privateKeyShamirPartitions: Map<String, String>

  public val publicKey: SpkiHexString?

  public val publicKeysForOaepWithSha256: Set<SpkiHexString>
}
