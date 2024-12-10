package com.icure.cardinal.sdk.dart.crypto

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import kotlinx.serialization.Serializable

@Serializable
data class DartRecoveredKeyData(
	val recoveredKeys: Map<KeypairFingerprintV1String, Base64String>,
	val keyAuthenticity: Map<KeypairFingerprintV1String, Boolean>
)