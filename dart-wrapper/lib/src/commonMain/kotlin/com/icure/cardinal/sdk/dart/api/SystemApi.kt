// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.IndexingInfo
import com.icure.cardinal.sdk.model.ReplicationInfo
import com.icure.cardinal.sdk.model.couchdb.ReplicatorDocument
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object SystemApi {
  public fun getVersion(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.getVersion()
    }
  }

  public fun isReady(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.isReady()
    }
  }

  public fun getProcessInfo(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.getProcessInfo()
    }
  }

  public fun getIndexingInfo(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      IndexingInfo.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.getIndexingInfo()
    }
  }

  public fun getReplicationInfo(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ReplicationInfo.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.getReplicationInfo()
    }
  }

  public fun updateDesignDoc(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityNameString: String,
    warmupString: String,
  ) {
    val entityName = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityNameString
    )
    val warmup = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      warmupString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.updateDesignDoc(
        entityName,
        warmup,
      )
    }
  }

  public fun resolvePatientsConflicts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    limitString: String,
  ) {
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).system.resolvePatientsConflicts(
        limit,
      )
    }
  }

  public fun resolveContactsConflicts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    limitString: String,
  ) {
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).system.resolveContactsConflicts(
        limit,
      )
    }
  }

  public fun resolveFormsConflicts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    limitString: String,
  ) {
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).system.resolveFormsConflicts(
        limit,
      )
    }
  }

  public fun resolveHealthElementsConflicts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    limitString: String,
  ) {
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).system.resolveHealthElementsConflicts(
        limit,
      )
    }
  }

  public fun resolveInvoicesConflicts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    limitString: String,
  ) {
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).system.resolveInvoicesConflicts(
        limit,
      )
    }
  }

  public fun resolveMessagesConflicts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    limitString: String,
  ) {
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).system.resolveMessagesConflicts(
        limit,
      )
    }
  }

  public fun resolveDocumentsConflicts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idsString: String,
    limitString: String,
  ) {
    val ids = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      idsString
    )
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).system.resolveDocumentsConflicts(
        ids,
        limit,
      )
    }
  }

  public fun getIndexingInfoByGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    ApiScope.execute(
      dartResultCallback,
      IndexingInfo.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.getIndexingInfoByGroup(
        groupId,
      )
    }
  }

  public fun getReplicatorInfo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      ReplicatorDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.getReplicatorInfo(
        id,
      )
    }
  }

  public fun evictAllFromMap(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    mapNameString: String,
  ) {
    val mapName = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      mapNameString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).system.evictAllFromMap(
        mapName,
      )
    }
  }
}
