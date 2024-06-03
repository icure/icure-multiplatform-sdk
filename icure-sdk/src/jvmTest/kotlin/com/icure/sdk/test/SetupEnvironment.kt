@file:OptIn(InternalIcureApi::class)

package com.icure.sdk.test

import baseUrl
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.AuthenticationMethod
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.storage.impl.VolatileStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.test.setup.ICureTestSetup
import defaultRoles
import io.kotest.common.runBlocking
import superadminAuth
import testGroupAdmin
import testGroupAdminAuth
import testGroupAdminPassword
import testGroupId
import testGroupName
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
		"file:///Users/vincenzoclaudiopierro/Documents/GitHub/icure-typescript-sdk/test/scratch/docker-compose-cloud-debuggable.yaml",
		listOf("mock"),
		"/Users/vincenzoclaudiopierro/Documents/GitHub/icure-typescript-sdk/test/scratch"
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
