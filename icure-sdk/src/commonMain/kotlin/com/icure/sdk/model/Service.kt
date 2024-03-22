package com.icure.sdk.model

import kotlinx.serialization.Serializable

@Serializable
data class Service(
	override val id: String,
	val transactionId: String? = null,
//	val identifier: List<Identifier> = emptyList(),
	val contactId: String? = null,
	val subContactIds: Set<String>? = null, //Only used when the ServiceDto is emitted outside of its contact
	val plansOfActionIds: Set<String>? = null, //Only used when the ServiceDto is emitted outside of its contact
	val healthElementsIds: Set<String>? = null, //Only used when the ServiceDto is emitted outside of its contact
	val formIds: Set<String>? = null, //Only used when the ServiceDto is emitted outside of its contact
	val secretForeignKeys: Set<String> = emptySet(), //Only used when the ServiceDto is emitted outside of its contact
	val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(), //Only used when the ServiceDto is emitted outside of its contact
	val delegations: Map<String, Set<Delegation>> = emptyMap(), //Only used when the ServiceDto is emitted outside of its contact
	val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(), //Only used when the ServiceDto is emitted outside of its contact
	val label: String? = null,
	val index: Long? = null, //Used for sorting
	val content: Map<String, Content> = emptyMap(), //Localized, in the case when the service contains a document, the document id is the SerializableValue
	@get:Deprecated("use encryptedSelf instead") val encryptedContent: String? = null, //Crypted (AES+base64) version of the above, deprecated, use encryptedSelf instead
	val textIndexes: Map<String, String> = emptyMap(), //Same structure as content but used for full text indexation
	val valueDate: Long? = null, // YYYYMMDDHHMMSS if unknown, 00, ex:20010800000000. Note that to avoid all confusion: 2015/01/02 00:00:00 is encoded as 20140101235960.
	val openingDate: Long? = null, // YYYYMMDDHHMMSS if unknown, 00, ex:20010800000000. Note that to avoid all confusion: 2015/01/02 00:00:00 is encoded as 20140101235960.
	val closingDate: Long? = null, // YYYYMMDDHHMMSS if unknown, 00, ex:20010800000000. Note that to avoid all confusion: 2015/01/02 00:00:00 is encoded as 20140101235960.
	val formId: String? = null, //Used to group logically related services
	val created: Long? = null,
	val modified: Long? = null,
	val endOfLife: Long? = null,
	val author: String? = null, //userId
	val responsible: String? = null, //healthcarePartyId
	val medicalLocationId: String? = null,
	val comment: String? = null,
	val status: Int? = null, //bit 0: active/inactive, bit 1: relevant/irrelevant, bit2 : present/absent, ex: 0 = active,relevant and present
	val invoicingCodes: Set<String> = emptySet(),
//	val notes: List<AnnotationDto> = emptyList(),
//	val qualifiedLinks: Map<LinkQualificationDto, Map<String, String>> = emptyMap(), //Links towards related services (possibly in other contacts)
	val codes: Set<CodeStub> = emptySet(), //stub object of the CodeDto used to qualify the content of the ServiceDto
	val tags: Set<CodeStub> = emptySet(), //stub object of the tag used to qualify the type of the ServiceDto
	val encryptedSelf: String? = null,
	val securityMetadata: SecurityMetadata? = null
): Identifiable<String>