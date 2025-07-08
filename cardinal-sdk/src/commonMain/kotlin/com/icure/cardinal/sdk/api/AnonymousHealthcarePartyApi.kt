package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.UserAndHealthcareParty

interface AnonymousHealthcarePartyApi {
	suspend fun getPublicHealthcarePartiesInGroup(groupId: String): List<UserAndHealthcareParty>
}