package com.icure.sdk.auth

import com.icure.sdk.utils.InternalIcureApi

/**
 * Contains information about an authentication process request, result of the [executeProcess] method.
 * You are not supposed to initialize this class yourself or use its content directly.
 */
class AuthenticationProcessRequest @InternalIcureApi constructor(
	@InternalIcureApi
	val messageGwUrl: String,
	@InternalIcureApi
	val specId: String,
	@InternalIcureApi
	val requestId: String
)