package com.icure.sdk.test

import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization

val baseUrl = "http://localhost:16043"
val testGroupName = "testgroup"
val testGroupId = testGroupName
val testGroupAdmin = "admin-12345@icure.com"
val testGroupAdminPassword = "admin-12345"

@OptIn(InternalIcureApi::class)
val testGroupAdminAuth = JwtAuthService(
	RawAnonymousAuthApiImpl(baseUrl, IcureSdk.sharedHttpClient, json = Serialization.json),
	UsernamePassword(testGroupAdmin, testGroupAdminPassword),
)
@OptIn(InternalIcureApi::class)
val superadminAuth = JwtAuthService(
	RawAnonymousAuthApiImpl(baseUrl, IcureSdk.sharedHttpClient, json = Serialization.json),
	UsernamePassword("john", "LetMeIn"),
)
val defaultRoles = mapOf(
	"PATIENT" to "BASIC_USER\", \"BASIC_DATA_OWNER",
	"HCP" to "BASIC_USER\", \"BASIC_DATA_OWNER\", \"PATIENT_USER_MANAGER\", \"LEGACY_MESSAGE_MANAGER\", \"HIERARCHICAL_DATA_OWNER",
	"DEVICE" to "BASIC_USER\", \"BASIC_DATA_OWNER",
	"USER" to "BASIC_USER"
)
