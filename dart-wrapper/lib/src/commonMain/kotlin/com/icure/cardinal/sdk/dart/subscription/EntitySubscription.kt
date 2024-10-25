@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.subscription

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

object EntitySubscription {

	fun close(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		sdkId: String
	) {
		ApiScope.execute(
			dartResultCallback,
			Unit.serializer()
		) {
			NativeReferences.get<EntitySubscriptionWithSerializer<*>>(sdkId).close()
		}
	}

	fun getCloseReason(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		sdkId: String
	) {
		ApiScope.execute(
			dartResultCallback,
			JsonElement.serializer()
		) {
			NativeReferences.get<EntitySubscriptionWithSerializer<*>>(sdkId).closeReason
		}
	}

	fun getEvent(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		sdkId: String
	) {
		ApiScope.execute(
			dartResultCallback,
			JsonElement.serializer()
		) {
			NativeReferences.get<EntitySubscriptionWithSerializer<*>>(sdkId).getEvent()
		}
	}

	fun waitForEvent(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		sdkId: String,
		timeoutString: String
	) {
		val timeout = fullLanguageInteropJson.decodeFromString(
			Int.serializer(),
			timeoutString
		)
		ApiScope.execute(
			dartResultCallback,
			JsonElement.serializer().nullable
		) {
			NativeReferences.get<EntitySubscriptionWithSerializer<*>>(sdkId).waitForEvent(timeout)
		}
	}

}