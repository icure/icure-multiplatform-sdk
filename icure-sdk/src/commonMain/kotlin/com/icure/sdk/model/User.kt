package com.icure.sdk.model

data class User(
	override val id: String,
	override val rev: String? = null,
//	override val deletionDate: Long? = null,
//	val created: Long? = null,
//
//	val identifier: List<IdentifierDto> = listOf(),
//
//	override val name: String? = null,
//	override val properties: Set<PropertyStubDto> = emptySet(),
//	val permissions: Set<PermissionDto> = emptySet(),
//	val roles: Set<String> = emptySet(),
//	val type: Users.Type? = null,
//	val status: Users.Status? = null,
//	val login: String? = null,
//	val passwordHash: String? = null,
//	val groupId: String? = null,
//	val healthcarePartyId: String? = null,
//	val patientId: String? = null,
//	val deviceId: String? = null,
	val autoDelegations: Map<DelegationTag, Set<String>> = emptyMap(), //DelegationTagDto -> healthcarePartyIds
//
//	val createdDate: Instant? = null,
//
//	val termsOfUseDate: Instant? = null,
//	val email: String? = null,
//	val mobilePhone: String? = null,
//
//	val applicationTokens: Map<String, String> = emptyMap(),
//	val authenticationTokens: Map<String, AuthenticationTokenDto> = emptyMap(),
//
//	val systemMetadata: UserDto.SystemMetadata? = null,
) : Revisionable<String>