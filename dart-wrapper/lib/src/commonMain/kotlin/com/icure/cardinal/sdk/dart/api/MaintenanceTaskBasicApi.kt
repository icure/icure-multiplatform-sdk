// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object MaintenanceTaskBasicApi {
  public fun matchMaintenanceTasksBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.matchMaintenanceTasksBy(
        filter,
      )
    }
  }

  public fun matchMaintenanceTasksBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.matchMaintenanceTasksBySorted(
        filter,
      )
    }
  }

  public fun filterMaintenanceTasksBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.filterMaintenanceTasksBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedMaintenanceTask.serializer()
      ))
    }
  }

  public fun filterMaintenanceTasksBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.filterMaintenanceTasksBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedMaintenanceTask.serializer()
      ))
    }
  }

  public fun deleteMaintenanceTaskById(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.deleteMaintenanceTaskById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteMaintenanceTasksByIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(IdWithMandatoryRev.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.deleteMaintenanceTasksByIds(
        entityIds,
      )
    }
  }

  public fun purgeMaintenanceTaskById(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.purgeMaintenanceTaskById(
        id,
        rev,
      )
    }
  }

  public fun deleteMaintenanceTask(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.deleteMaintenanceTask(
        maintenanceTask,
      )
    }
  }

  public fun deleteMaintenanceTasks(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTasksString: String,
  ) {
    val maintenanceTasks = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(MaintenanceTask::class)),
      maintenanceTasksString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.deleteMaintenanceTasks(
        maintenanceTasks,
      )
    }
  }

  public fun purgeMaintenanceTask(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.purgeMaintenanceTask(
        maintenanceTask,
      )
    }
  }

  public fun undeleteMaintenanceTask(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    maintenanceTaskString: String,
  ) {
    val maintenanceTask = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(MaintenanceTask::class),
      maintenanceTaskString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(MaintenanceTask::class)) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.undeleteMaintenanceTask(
        maintenanceTask,
      )
    }
  }

  public fun undeleteMaintenanceTaskById(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.undeleteMaintenanceTaskById(
        id,
        rev,
      )
    }
  }

  public fun modifyMaintenanceTask(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      EncryptedMaintenanceTask.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.modifyMaintenanceTask(
        entity,
      )
    }
  }

  public fun getMaintenanceTask(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedMaintenanceTask.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.getMaintenanceTask(
        entityId,
      )
    }
  }

  public fun getMaintenanceTasks(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedMaintenanceTask.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.getMaintenanceTasks(
        entityIds,
      )
    }
  }

  public fun subscribeToEvents(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    eventsString: String,
    filterString: String,
    subscriptionConfigString: String,
  ) {
    val events = fullLanguageInteropJson.decodeFromString(
      SetSerializer(SubscriptionEventType.serializer()),
      eventsString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseSdk>(sdkId).maintenanceTask.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedMaintenanceTask.serializer()
      ))
    }
  }
}
