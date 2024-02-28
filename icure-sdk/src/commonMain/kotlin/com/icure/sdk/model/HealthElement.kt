package com.icure.sdk.model

import kotlinx.serialization.Serializable

@Serializable
data class HealthElement(
	override val id: String,
	override val rev: String? = null,
//	val identifiers: List<Identifier> = emptyList(),
	val created: Long? = null,
	val modified: Long? = null,
	val author: String? = null,
	val responsible: String? = null,
	val medicalLocationId: String? = null,
	val tags: Set<CodeStub> = emptySet(),
	val codes: Set<CodeStub> = emptySet(),
	val endOfLife: Long? = null,
	val deletionDate: Long? = null,

	val healthElementId: String? = null, //Several versions of the same healthcare element share the same healthElementId while having different ids
	//Usually one of the following is used (either valueDate or openingDate and closingDate)
	val valueDate: Long? = null, // YYYYMMDDHHMMSS if unknown, 00, ex:20010800000000. Note that to avoid all confusion: 2015/01/02 00:00:00 is encoded as 20150101235960.
	val openingDate: Long? = null, // YYYYMMDDHHMMSS if unknown, 00, ex:20010800000000. Note that to avoid all confusion: 2015/01/02 00:00:00 is encoded as 20150101235960.
	val closingDate: Long? = null, // YYYYMMDDHHMMSS if unknown, 00, ex:20010800000000. Note that to avoid all confusion: 2015/01/02 00:00:00 is encoded as 20150101235960.
	val descr: String? = null,
	val note: String? = null,
	val notes: List<Annotation> = emptyList(),
	val relevant: Boolean = true,
	val idOpeningContact: String? = null,
	val idClosingContact: String? = null,
	val idService: String? = null, //When a service is used to create the healthElement
	val status: Int = 0, //bit 0: active/inactive, bit 1: relevant/irrelevant, bit 2 : present/absent, ex: 0 = active,relevant and present
//	val laterality: Laterality? = null,
//	val plansOfAction: List<PlanOfAction> = emptyList(),
//	val episodes: List<Episode> = emptyList(),
//	val careTeam: List<CareTeamMember> = emptyList(),

	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,

): Encryptable {
	override val type: EntityWithDelegationTypeName get() = EntityWithDelegationTypeName.HealthElement

	override fun copyWithSecurityMetadata(
		securityMetadata: SecurityMetadata,
		secretForeignKeys: Set<String>
	) = copy(
		secretForeignKeys = secretForeignKeys,
		securityMetadata = securityMetadata
	)
}