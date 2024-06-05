// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.CryptoApi
import com.icure.sdk.js.api.CryptoApiJs
import com.icure.sdk.js.api.crypto.ShamirKeysManagerApiJs
import com.icure.sdk.js.crypto.entities.ShamirUpdateRequestJs
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.sdk.js.model.base.CryptoActorJs
import com.icure.sdk.js.model.cryptoActorStubWithType_toJs
import com.icure.sdk.js.model.specializations.keypairFingerprintV1String_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CryptoApiImplJs(
	private val cryptoApi: CryptoApi,
) : CryptoApiJs {
	override val shamirKeysManager: ShamirKeysManagerApiJs = object : ShamirKeysManagerApiJs {
		override fun getExistingSplitsInfo(dataOwner: CryptoActorJs): Record<String, Array<String>> =
				mapToObject(
			cryptoApi.shamirKeysManager.getExistingSplitsInfo(com.icure.sdk.js.model.base.cryptoActor_fromJs(dataOwner)),
			{ x1: KeypairFingerprintV1String ->
				keypairFingerprintV1String_toJs(x1)
			},
			{ x1: Set<String> ->
				setToArray(
					x1,
					{ x2: String ->
						x2
					},
				)
			},
		)

		override fun updateSelfSplits(keySplitsToUpdate: Record<String, ShamirUpdateRequestJs>,
				keySplitsToDelete: Array<String>): Promise<CryptoActorStubWithTypeJs> = GlobalScope.promise {
			cryptoActorStubWithType_toJs(cryptoApi.shamirKeysManager.updateSelfSplits(com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  keySplitsToUpdate,
			  "keySplitsToUpdate",
			  { x1: kotlin.String ->
			    com.icure.sdk.js.model.specializations.keypairFingerprintV1String_fromJs(x1)
			  },
			  { x1: com.icure.sdk.js.crypto.entities.ShamirUpdateRequestJs ->
			    com.icure.sdk.js.crypto.entities.shamirUpdateRequest_fromJs(x1)
			  },
			), com.icure.sdk.js.model.CheckedConverters.arrayToSet(
			  keySplitsToDelete,
			  "keySplitsToDelete",
			  { x1: kotlin.String ->
			    com.icure.sdk.js.model.specializations.keypairFingerprintV1String_fromJs(x1)
			  },
			)))}

	}

	override fun forceReload(): Promise<Unit> = GlobalScope.promise {
		cryptoApi.forceReload()}

}
