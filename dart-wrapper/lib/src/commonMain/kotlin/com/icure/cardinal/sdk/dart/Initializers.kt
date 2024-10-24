package com.icure.cardinal.sdk.dart

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.auth.UsernameLongToken
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import kotlinx.serialization.builtins.serializer

object Initializers {
	fun initializeSdk(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		username: String,
		longToken: String
	) {
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val sdk = CardinalSdk.initialize(
				null,
				"https://api.icure.cloud",
				AuthenticationMethod.UsingCredentials(UsernameLongToken(username, longToken)),
				VolatileStorageFacade()
			)
			NativeReferences.create(sdk)
		}
	}
}