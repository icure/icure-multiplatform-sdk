@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.User
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.Serialization

private var initialized = false

@OptIn(InternalIcureApi::class)
suspend fun initializeTestEnvironment() {
	if (initialized) {
		return
	}
	initialized = true
	println("Creating test group")
	val groupApi = RawGroupApiImpl(baseUrl, superadminAuth, CardinalSdk.sharedHttpClient, json = Serialization.json)
	if (groupApi.getGroup(testGroupId).status.value == 200) {
		println("Group already exist")
	} else  {
		println("Creating group")
		groupApi.createGroup(
			testGroupId,
			testGroupName,
			password = uuid(),
			initialisationData = DatabaseInitialisation(
				users = emptyList(),
				healthcareParties = emptyList(),
			)
		)
	}
	println("Creating admin user - $testGroupAdmin:$testGroupAdminPassword")
	RawUserApiImpl(baseUrl, superadminAuth, CardinalSdk.sharedHttpClient, json = Serialization.json).createAdminUserInGroup(
		testGroupId,
		User(
			uuid(),
			login = testGroupAdmin,
			email = testGroupAdmin,
			passwordHash = testGroupAdminPassword,
		)
	).successBody()
	println("Environment initialisation successful")
}
