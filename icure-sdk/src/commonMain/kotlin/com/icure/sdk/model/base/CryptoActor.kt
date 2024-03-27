package com.icure.sdk.model.base

import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.SpkiHexString
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

    public val transferKeys: Map<String, Map<String, String>>

    public val privateKeyShamirPartitions: Map<String, String>

    public val publicKey: SpkiHexString?

    public val publicKeysForOaepWithSha256: Set<SpkiHexString>
	// region CryptoActor-CryptoActor

	// endregion
}
