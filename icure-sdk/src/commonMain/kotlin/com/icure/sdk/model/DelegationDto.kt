package com.icure.sdk.model

import kotlinx.serialization.Serializable

@Serializable
data class Delegation(
	//This is not the owner of a piece of date (patient, contact). It is the owner of the delegation.
	val owner: String? = null, // owner id
	val delegatedTo: String? = null, // delegatedTo id
	val key: String? = null, // An arbitrary key (generated, patientId, any ID, etc.), usually prefixed with the entity ID followed by ":", encrypted using an exchange AES key.
	val tags: List<String> = emptyList() // Used for rights
)