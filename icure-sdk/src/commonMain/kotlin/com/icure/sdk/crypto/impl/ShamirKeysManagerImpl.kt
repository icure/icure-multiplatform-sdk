package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.utils.hexToByteArray
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.crypto.ShamirKeysManagerApi
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.extensions.toStub
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ensure

