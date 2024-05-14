package com.icure.sdk.js.model.specializations

import com.icure.sdk.model.specializations.AccessControlKeyHexString
import com.icure.sdk.model.specializations.AccessControlSecret
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.model.specializations.Sha256HexString
import com.icure.sdk.model.specializations.SpkiHexString

fun aesExchangeKeyEncryptionKeypairIdentifier_fromJs(obj: String) = AesExchangeKeyEncryptionKeypairIdentifier(obj)
fun aesExchangeKeyEncryptionKeypairIdentifier_toJs(obj: AesExchangeKeyEncryptionKeypairIdentifier) = obj.s
fun base64String_fromJs(obj: String) = Base64String(obj)
fun base64String_toJs(obj: Base64String) = obj.s
fun hexString_fromJs(obj: String) = HexString(obj)
fun hexString_toJs(obj: HexString) = obj.s
fun sha256HexString_fromJs(obj: String) = Sha256HexString(obj)
fun sha256HexString_toJs(obj: Sha256HexString) = obj.s
fun accessControlSecret_fromJs(obj: String) = AccessControlSecret(obj)
fun accessControlSecret_toJs(obj: AccessControlSecret) = obj.s
fun accessControlKeyHexString_fromJs(obj: String) = AccessControlKeyHexString(obj)
fun accessControlKeyHexString_toJs(obj: AccessControlKeyHexString) = obj.s
fun secureDelegationKeyString_fromJs(obj: String) = SecureDelegationKeyString(obj)
fun secureDelegationKeyString_toJs(obj: SecureDelegationKeyString) = obj.s
fun spkiHexString_fromJs(obj: String) = SpkiHexString(obj)
fun spkiHexString_toJs(obj: SpkiHexString) = obj.s
fun keypairFingerprintV1String_fromJs(obj: String) = KeypairFingerprintV1String(obj)
fun keypairFingerprintV1String_toJs(obj: KeypairFingerprintV1String) = obj.s
fun keypairFingerprintV2String_fromJs(obj: String) = KeypairFingerprintV2String(obj)
fun keypairFingerprintV2String_toJs(obj: KeypairFingerprintV2String) = obj.s