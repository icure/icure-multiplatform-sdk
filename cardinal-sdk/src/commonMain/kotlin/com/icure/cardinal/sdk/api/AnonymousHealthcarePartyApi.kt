package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.HealthcareParty

interface AnonymousHealthcarePartyApi {
	suspend fun getPublicHealthcarePartiesInGroup(groupId: String): List<HealthcareParty>
}