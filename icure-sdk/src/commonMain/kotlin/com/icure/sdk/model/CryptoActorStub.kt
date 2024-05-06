package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.base.HasTags
import com.icure.sdk.model.base.Versionable
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.SpkiHexString
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class CryptoActorStub(
	override val id: String,
	override val rev: String,
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	override val aesExchangeKeys: Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	override val publicKey: SpkiHexString? = null,
	override val publicKeysForOaepWithSha256: Set<SpkiHexString>,
	override val tags: Set<CodeStub> = emptySet(),
) : Versionable<T>, CryptoActor, HasTags {
	// region CryptoActorStub-CryptoActorStub

	// endregion
}
