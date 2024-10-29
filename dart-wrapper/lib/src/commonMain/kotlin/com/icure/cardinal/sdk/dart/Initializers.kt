package com.icure.cardinal.sdk.dart

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.auth.UsernameLongToken
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
object Initializers {
	fun initializeSdk(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		authenticationMethodString: String
	) {
		val authenticationMethod = fullLanguageInteropJson.decodeFromString(
			com.icure.cardinal.sdk.dart.auth.AuthenticationMethod.serializer(),
			authenticationMethodString
		)
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val sdk = CardinalSdk.initialize(
				null,
				"https://api.icure.cloud",
				authenticationMethod.toKt(),
				VolatileStorageFacade()
			)
			NativeReferences.create(sdk)
		}
	}
}