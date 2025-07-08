package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AnonymousHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawAnonymousApi
import com.icure.cardinal.sdk.model.UserAndHealthcareParty
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class AnonymousHealthcarePartyApiImpl(
	val raw: RawAnonymousApi
): AnonymousHealthcarePartyApi {
	override suspend fun getPublicHealthcarePartiesInGroup(
		groupId: String
	): List<UserAndHealthcareParty> = raw.listHealthcarePartiesInGroup(
		groupId
	).successBody()
}