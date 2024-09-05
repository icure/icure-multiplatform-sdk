package com.icure.cardinal.sdk.crypto.entities

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class EntityEncryptionKeyDetails(
	val key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
	val raw: HexString
)