@file:OptIn(InternalIcureApi::class)

package com.icure.sdk.test

import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.User
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.test.setup.ICureTestSetup
import java.util.UUID

private var initialised = false

@OptIn(InternalIcureApi::class)
suspend fun initialiseTestEnvironment() {
	if (initialised) {
		return
	}
	initialised = true
	println("Starting kraken")
	ICureTestSetup.startKrakenEnvironment(
		"file:///Users/trema/icure-typescript-sdk/test/scratch/docker-compose-cloud-debuggable.yaml",
		listOf("mock"),
		"/Users/trema/icure-typescript-sdk/test/scratch"
	)
	println("Bootstrap cloud")
	ICureTestSetup.bootstrapCloud(
		"xx",
		"xx",
		UUID.randomUUID().toString(),
		"john",
		couchDbUser = "icure",
		couchDbPassword = "icure",
		rootUserRoles = defaultRoles
	)
	println("Creating test group")
	val groupApi = RawGroupApiImpl(baseUrl, superadminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
	if (groupApi.getGroup(testGroupId).status.value == 200) {
		println("Group already exist")
	} else  {
		println("Creating group")
		groupApi.createGroup(
			testGroupId,
			testGroupName,
			password = UUID.randomUUID().toString(),
			initialisationData = DatabaseInitialisation(
				users = emptyList(),
				healthcareParties = emptyList(),
			)
		)
	}
	println("Creating admin user - $testGroupAdmin:$testGroupAdminPassword")
	RawUserApiImpl(baseUrl, superadminAuth, IcureSdk.sharedHttpClient, json = Serialization.json).createAdminUserInGroup(
		testGroupId,
		User(
			UUID.randomUUID().toString(),
			login = testGroupAdmin,
			email = testGroupAdmin,
			passwordHash = testGroupAdminPassword,
		)
	).successBody()
	println("Environment initialisation successful")
}
