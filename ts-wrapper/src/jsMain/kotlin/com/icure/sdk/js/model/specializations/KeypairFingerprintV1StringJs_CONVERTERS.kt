package com.icure.sdk.js.model.specializations

import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun keypairFingerprintV1String_toJs(obj: KeypairFingerprintV1String): String = obj.s

public fun keypairFingerprintV1String_fromJs(obj: String): KeypairFingerprintV1String =
		KeypairFingerprintV1String(obj)
