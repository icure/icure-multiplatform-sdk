package com.icure.sdk.crypto.entities

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class EntityEncryptionKeyDetails(
	val key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
	val raw: HexString
)