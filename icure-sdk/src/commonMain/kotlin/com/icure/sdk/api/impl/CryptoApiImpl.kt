package com.icure.sdk.api.impl

import com.icure.sdk.api.CryptoApi
import com.icure.sdk.api.ShamirKeysManagerApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
internal class CryptoApiImpl(
	override val shamirKeysManager: ShamirKeysManagerApi,
	internal val internal: InternalCryptoServices
) : CryptoApi {
	override suspend fun forceReload() {
		internal.forceReload()
	}
}