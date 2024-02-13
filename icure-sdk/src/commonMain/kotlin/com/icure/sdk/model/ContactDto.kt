package com.icure.sdk.model

data class Contact(
	override val id: String,
	override val rev: String? = null,
	val created: Long? = null,
	val modified: Long? = null,
	val author: String? = null,
	val responsible: String? = null,
	val medicalLocationId: String? = null,
	val tags: Set<CodeStub> = emptySet(),
	val codes: Set<CodeStub> = emptySet(),
//	val identifier: List<IdentifierDto> = emptyList(),
	val endOfLife: Long? = null,
	val deletionDate: Long? = null,

	val groupId: String? = null, // Several contacts can be combined in a logical contact if they share the same groupId
	val openingDate: Long? = null, // YYYYMMDDHHMMSS if unknown, 00, ex:20010800000000. Note that to avoid all confusion: 2015/01/02 00:00:00 is encoded as 20150101235960.
	val closingDate: Long? = null, // YYYYMMDDHHMMSS if unknown, 00, ex:20010800000000. Note that to avoid all confusion: 2015/01/02 00:00:00 is encoded as 20150101235960.
	val descr: String? = null,
	val location: String? = null,
	val externalId: String? = null,
//	val encounterType: CodeStubDto? = null,
//	val subContacts: Set<SubContactDto> = emptySet(),
//	val services: Set<ServiceDto> = emptySet(),

	@get:Deprecated("Use responsible") val healthcarePartyId: String? = null, //Redundant... Should be responsible
	@get:Deprecated("Use groupId") val modifiedContactId: String? = null,

	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null
) : Revisionable<String>, Encryptable {
	override val type: EntityWithDelegationTypeName
		get() = EntityWithDelegationTypeName.Contact

	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata): Contact =
		copy(securityMetadata = securityMetadata)
}