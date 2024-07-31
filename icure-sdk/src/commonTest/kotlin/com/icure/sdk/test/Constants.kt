package com.icure.sdk.test

import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthProvider
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization

val baseUrl = "http://localhost:16044"
val testGroupName = "testgroup"
val testGroupId = testGroupName
val testGroupAdmin = "admin-{${uuid()}}@icure.com"
val testGroupAdminPassword = "admin-${uuid()}"

@OptIn(InternalIcureApi::class)
val testGroupAdminAuth = JwtAuthProvider(
	RawAnonymousAuthApiImpl(baseUrl, IcureSdk.sharedHttpClient, json = Serialization.json),
	UsernamePassword(testGroupAdmin, testGroupAdminPassword),
)
@OptIn(InternalIcureApi::class)
val superadminAuth = JwtAuthProvider(
	RawAnonymousAuthApiImpl(baseUrl, IcureSdk.sharedHttpClient, json = Serialization.json),
	UsernamePassword("john", "LetMeIn"),
)
