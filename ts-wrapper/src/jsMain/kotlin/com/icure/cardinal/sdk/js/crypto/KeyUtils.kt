package com.icure.cardinal.sdk.js.crypto

import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString

@JsExport
fun spkiHexKeyToFingerprintV1(key: String) =
	SpkiHexString(key).fingerprintV1().s

@JsExport
fun spkiHexKeyToFingerprintV2(key: String) =
	SpkiHexString(key).fingerprintV2().s

@JsExport
fun fingerprintV1ToFingerprintV2(fingerprint: String) =
	KeypairFingerprintV1String(fingerprint).toV2().s