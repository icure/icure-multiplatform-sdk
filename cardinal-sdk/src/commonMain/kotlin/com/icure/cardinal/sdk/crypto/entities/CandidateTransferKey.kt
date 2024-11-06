package com.icure.cardinal.sdk.crypto.entities

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal data class CandidateTransferKey(
	val sources: List<SpkiHexString>,
	val target: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
)