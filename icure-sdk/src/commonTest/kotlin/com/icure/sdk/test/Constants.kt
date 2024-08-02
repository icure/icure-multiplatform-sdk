package com.icure.sdk.test

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.options.getAuthProvider
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization

val baseUrl = "http://localhost:16044"
val testGroupName = "testgroup"
val testGroupId = testGroupName
val testGroupAdmin = "admin-{${uuid()}}@icure.com"
val testGroupAdminPassword = "admin-${uuid()}"

@OptIn(InternalIcureApi::class)
internal val testGroupAdminAuth =
	AuthenticationMethod.UsingCredentials(
		UsernamePassword(testGroupAdmin, testGroupAdminPassword)
	).getAuthProvider(
		RawAnonymousAuthApiImpl(baseUrl, IcureSdk.sharedHttpClient, json = Serialization.json),
		defaultCryptoService,
		null,
		ApiOptions(saltPasswordWithApplicationId = false)
	)

@OptIn(InternalIcureApi::class)
internal val superadminAuth =
	AuthenticationMethod.UsingCredentials(
		UsernamePassword("john", "LetMeIn"),
	).getAuthProvider(
		RawAnonymousAuthApiImpl(baseUrl, IcureSdk.sharedHttpClient, json = Serialization.json),
		defaultCryptoService,
		null,
		ApiOptions(saltPasswordWithApplicationId = false)
	)
