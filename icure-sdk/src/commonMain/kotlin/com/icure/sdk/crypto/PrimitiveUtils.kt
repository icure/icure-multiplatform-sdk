package com.icure.sdk.crypto

import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.model.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
suspend fun RsaService.exportSpkiHex(publicKey: PublicRsaKey<*>) =
	SpkiHexString(exportPublicKeySpki(publicKey).toHexString())
