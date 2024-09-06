package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface CryptoActor : Versionable<String>, HasTags {
	public val hcPartyKeys: Map<String, List<HexString>>

	public val aesExchangeKeys:
		Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>

	public val transferKeys:
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>

	public val privateKeyShamirPartitions: Map<String, HexString>

	public val publicKey: SpkiHexString?

	public val publicKeysForOaepWithSha256: Set<SpkiHexString>
	// region CryptoActor-CryptoActor

	// endregion
}