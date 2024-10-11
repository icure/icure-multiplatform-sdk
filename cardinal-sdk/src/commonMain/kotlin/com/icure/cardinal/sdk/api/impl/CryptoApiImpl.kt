package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.api.ShamirKeysManagerApi
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class CryptoApiImpl(
	override val shamirKeysManager: ShamirKeysManagerApi,
	internal val internal: InternalCryptoServices
) : CryptoApi {
	override suspend fun forceReload() {
		internal.forceReload()
	}
}