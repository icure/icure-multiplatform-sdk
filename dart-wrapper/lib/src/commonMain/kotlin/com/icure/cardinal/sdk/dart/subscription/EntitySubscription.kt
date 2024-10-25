package com.icure.cardinal.sdk.dart.subscription

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.serialization.DurationAsMillisecondsSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionCloseReason
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement

@OptIn(InternalIcureApi::class)
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
			NativeReferences.get<EntitySubscription<Identifiable<String>>>(sdkId).close()
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
			EntitySubscriptionCloseReason.serializer().nullable
		) {
			NativeReferences.get<EntitySubscription<Identifiable<String>>>(sdkId).closeReason
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
			NativeReferences.get<EntitySubscription<Identifiable<String>>>(sdkId)
				.eventChannel
				.tryReceive()
				.getOrNull().let {
					fullLanguageInteropJson.encodeToJsonElement(it)
				}
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
			DurationAsMillisecondsSerializer,
			timeoutString
		)
		ApiScope.execute(
			dartResultCallback,
			JsonElement.serializer().nullable
		) {
			withTimeoutOrNull(timeout.inWholeMilliseconds) {
				NativeReferences.get<EntitySubscription<Identifiable<String>>>(sdkId)
					.eventChannel
					.receiveCatching()
					.getOrNull().let {
						fullLanguageInteropJson.encodeToJsonElement(it)
					}
			}
		}
	}

}