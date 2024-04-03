package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.base.DataOwner
import com.icure.sdk.model.base.HasCodes
import com.icure.sdk.model.base.HasTags
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.Named
import com.icure.sdk.model.base.Person
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Address
import com.icure.sdk.model.embed.FinancialInstitutionInformation
import com.icure.sdk.model.embed.FlatRateTarification
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.embed.HealthcarePartyHistoryStatus
import com.icure.sdk.model.embed.HealthcarePartyStatus
import com.icure.sdk.model.embed.PersonName
import com.icure.sdk.model.embed.TelecomType
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.model.specializations.SpkiHexString
import kotlinx.serialization.Serializable
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class HealthcareParty(
	override val id: String,
	override val rev: String? = null,
	public val created: Long? = null,
	public val modified: Long? = null,
	override val deletionDate: Long? = null,
	public val identifier: List<Identifier> = emptyList(),
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val name: String? = null,
	override val lastName: String? = null,
	override val firstName: String? = null,
	override val names: List<PersonName> = emptyList(),
	override val gender: Gender? = null,
	override val civility: String? = null,
	override val companyName: String? = null,
	public val speciality: String? = null,
	public val bankAccount: String? = null,
	public val bic: String? = null,
	public val proxyBankAccount: String? = null,
	public val proxyBic: String? = null,
	public val invoiceHeader: String? = null,
	public val cbe: String? = null,
	public val ehp: String? = null,
	public val userId: String? = null,
	public val parentId: String? = null,
	public val convention: Int? = null,
	public val nihii: String? = null,
	public val nihiiSpecCode: String? = null,
	public val ssin: String? = null,
	override val addresses: List<Address> = emptyList(),
	override val languages: List<String> = emptyList(),
	public val picture: ByteArray? = null,
	public val statuses: Set<HealthcarePartyStatus> = emptySet(),
	public val statusHistory: List<HealthcarePartyHistoryStatus> = emptyList(),
	public val specialityCodes: Set<CodeStub> = emptySet(),
	public val sendFormats: Map<TelecomType, String> = emptyMap(),
	public val notes: String? = null,
	public val financialInstitutionInformation: List<FinancialInstitutionInformation> = emptyList(),
	public val descr: Map<String, String>? = null,
	public val billingType: String? = null,
	public val type: String? = null,
	public val contactPerson: String? = null,
	public val contactPersonHcpId: String? = null,
	public val supervisorId: String? = null,
	public val flatRateTarifications: List<FlatRateTarification> = emptyList(),
	public val importedData: Map<String, String> = emptyMap(),
	public val options: Map<String, String> = emptyMap(),
	override val properties: Set<PropertyStub> = emptySet(),
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	override val aesExchangeKeys: Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	override val transferKeys: Map<KeypairFingerprintV1String, Map<KeypairFingerprintV1String, HexString>> = emptyMap(),
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	override val publicKey: SpkiHexString? = null,
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
) : StoredDocument, Named, Person, CryptoActor, DataOwner, HasCodes, HasTags {
	// region HealthcareParty-HealthcareParty

	// endregion
}
