// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeySize
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.py.serialization.RsaEncryptionAlgorithmSerializer
import com.icure.cardinal.sdk.py.serialization.RsaKeypairSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object RecoveryApi {
  public fun createRecoveryInfoForAvailableKeyPairs(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    includeParentsKeysString: String,
    lifetimeSecondsString: String,
    recoveryKeyOptionsString: String,
  ) {
    val includeParentsKeys = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      includeParentsKeysString
    )
    val lifetimeSeconds = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      lifetimeSecondsString
    )
    val recoveryKeyOptions = fullLanguageInteropJson.decodeFromString(
      RecoveryKeyOptions.serializer().nullable,
      recoveryKeyOptionsString
    )
    ApiScope.execute(
      dartResultCallback,
      RecoveryDataKey.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.createRecoveryInfoForAvailableKeyPairs(
        includeParentsKeys,
        lifetimeSeconds,
        recoveryKeyOptions,
      )
    }
  }

  public fun recoverKeyPairs(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    recoveryKeyString: String,
    autoDeleteString: String,
  ) {
    val recoveryKey = fullLanguageInteropJson.decodeFromString(
      RecoveryDataKey.serializer(),
      recoveryKeyString
    )
    val autoDelete = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      autoDeleteString
    )
    ApiScope.execute(
      dartResultCallback,
      RecoveryResult.serializer(MapSerializer(String.serializer(),
          MapSerializer(SpkiHexString.serializer(),
          RsaKeypairSerializer(RsaEncryptionAlgorithmSerializer))))) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.recoverKeyPairs(
        recoveryKey,
        autoDelete,
      )
    }
  }

  public fun recoverKeyPairsWaitingForCreation(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    cancellationToken: Long,
    sdkId: String,
    recoveryKeyString: String,
    autoDeleteString: String,
    waitSecondsString: String,
  ) {
    val recoveryKey = fullLanguageInteropJson.decodeFromString(
      RecoveryDataKey.serializer(),
      recoveryKeyString
    )
    val autoDelete = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      autoDeleteString
    )
    val waitSeconds = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      waitSecondsString
    )
    ApiScope.executeCancellable(
      dartResultCallback,
      cancellationToken,
      RecoveryResult.serializer(MapSerializer(String.serializer(),
          MapSerializer(SpkiHexString.serializer(),
          RsaKeypairSerializer(RsaEncryptionAlgorithmSerializer))))) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.recoverKeyPairsWaitingForCreation(
        recoveryKey,
        autoDelete,
        waitSeconds,
      )
    }
  }

  public fun createExchangeDataRecoveryInfo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    delegateIdString: String,
    lifetimeSecondsString: String,
    recoveryKeyOptionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val lifetimeSeconds = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      lifetimeSecondsString
    )
    val recoveryKeyOptions = fullLanguageInteropJson.decodeFromString(
      RecoveryKeyOptions.serializer().nullable,
      recoveryKeyOptionsString
    )
    ApiScope.execute(
      dartResultCallback,
      RecoveryDataKey.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.createExchangeDataRecoveryInfo(
        delegateId,
        lifetimeSeconds,
        recoveryKeyOptions,
      )
    }
  }

  public fun recoverExchangeData(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    recoveryKeyString: String,
  ) {
    val recoveryKey = fullLanguageInteropJson.decodeFromString(
      RecoveryDataKey.serializer(),
      recoveryKeyString
    )
    ApiScope.execute(
      dartResultCallback,
      RecoveryDataUseFailureReason.serializer().nullable) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.recoverExchangeData(
        recoveryKey,
      )
    }
  }

  public fun purgeRecoveryInfo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    recoveryKeyString: String,
  ) {
    val recoveryKey = fullLanguageInteropJson.decodeFromString(
      RecoveryDataKey.serializer(),
      recoveryKeyString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.purgeRecoveryInfo(
        recoveryKey,
      )
    }
  }

  public fun purgeAllRecoveryInfoFor(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    dataOwnerIdString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Int.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.purgeAllRecoveryInfoFor(
        dataOwnerId,
      )
    }
  }

  public fun purgeAllKeyPairRecoveryInfoFor(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    dataOwnerIdString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Int.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.purgeAllKeyPairRecoveryInfoFor(
        dataOwnerId,
      )
    }
  }

  public fun purgeAllExchangeDataRecoveryInfoFor(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    dataOwnerIdString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Int.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.purgeAllExchangeDataRecoveryInfoFor(
        dataOwnerId,
      )
    }
  }

  public fun preGenerateRecoveryKey(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    keySizeString: String,
  ) {
    val keySize = fullLanguageInteropJson.decodeFromString(
      RecoveryKeySize.serializer(),
      keySizeString
    )
    ApiScope.execute(
      dartResultCallback,
      RecoveryDataKey.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).recovery.preGenerateRecoveryKey(
        keySize,
      )
    }
  }
}
