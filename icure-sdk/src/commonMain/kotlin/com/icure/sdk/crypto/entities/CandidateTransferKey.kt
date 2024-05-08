package com.icure.sdk.crypto.entities

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
internal data class CandidateTransferKey(
	val sources: List<SpkiHexString>,
	val target: IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
)