package com.icure.cardinal.sdk.model.base

import org.taktik.icure.services.`external`.rest.v2.dto.DecryptedPropertyStubDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.AesExchangeKeyEncryptionKeypairIdentifierDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.AesExchangeKeyEntryKeyStringDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.HexStringDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.SpkiHexStringDto
import kotlin.String
import kotlin.collections.DecryptedSet
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import org.taktik.icure.services.`external`.rest.v2.dto.DecryptedPropertyStubDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.AesExchangeKeyEncryptionKeypairIdentifierDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.AesExchangeKeyEntryKeyStringDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.HexStringDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.SpkiHexStringDto
import kotlin.String
import kotlin.collections.DecryptedSet
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface CryptoActor : Versionable<String>, HasTags {
	public val hcPartyKeys: Map<String, List<HexStringDto>>

	public val aesExchangeKeys:
		Map<AesExchangeKeyEntryKeyStringDto, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifierDto, HexStringDto>>>

	public val transferKeys:
		Map<AesExchangeKeyEncryptionKeypairIdentifierDto, Map<AesExchangeKeyEncryptionKeypairIdentifierDto, HexStringDto>>

	public val privateKeyShamirPartitions: Map<String, HexStringDto>

	public val publicKey: SpkiHexStringDto?

	public val publicKeysForOaepWithSha256: Set<SpkiHexStringDto>

	public val parentId: String?

	public val cryptoActorProperties: DecryptedSet<DecryptedPropertyStubDto>?
	// region CryptoActor-CryptoActor

	// endregion
}
