package com.icure.sdk.py

import com.icure.sdk.IcureSdk
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.storage.impl.VolatileStorageFacade
import kotlinx.coroutines.runBlocking

fun initializeSdk(
	baseUrl: String,
	username: String,
	password: String
): IcureSdk = runBlocking {
	IcureSdk.initialise(
		baseUrl,
		AuthenticationMethod.UsingCredentials(UsernamePassword(username, password)),
		VolatileStorageFacade(),
		BasicCryptoStrategies
	)
}