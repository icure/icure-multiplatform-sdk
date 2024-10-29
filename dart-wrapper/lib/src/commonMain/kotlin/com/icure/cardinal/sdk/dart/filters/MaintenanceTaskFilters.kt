// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object MaintenanceTaskFilters {
  public fun byIds(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, idsString: String) {
    val ids = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      idsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class))
    ) {
      com.icure.cardinal.sdk.filters.MaintenanceTaskFilters.byIds(
        ids,
      )
    }
  }

  public fun byIdentifiersForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    identifiersString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val identifiers = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Identifier.serializer()),
      identifiersString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class))
    ) {
      com.icure.cardinal.sdk.filters.MaintenanceTaskFilters.byIdentifiersForDataOwner(
        dataOwnerId,
        identifiers,
      )
    }
  }

  public fun byIdentifiersForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, identifiersString: String) {
    val identifiers = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Identifier.serializer()),
      identifiersString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class))
    ) {
      com.icure.cardinal.sdk.filters.MaintenanceTaskFilters.byIdentifiersForSelf(
        identifiers,
      )
    }
  }

  public fun byTypeForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    typeString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class))
    ) {
      com.icure.cardinal.sdk.filters.MaintenanceTaskFilters.byTypeForDataOwner(
        dataOwnerId,
        type,
      )
    }
  }

  public fun byTypeForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, typeString: String) {
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class))
    ) {
      com.icure.cardinal.sdk.filters.MaintenanceTaskFilters.byTypeForSelf(
        type,
      )
    }
  }

  public fun afterDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    dateString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val date = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      dateString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class))
    ) {
      com.icure.cardinal.sdk.filters.MaintenanceTaskFilters.afterDateForDataOwner(
        dataOwnerId,
        date,
      )
    }
  }

  public fun afterDateForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, dateString: String) {
    val date = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      dateString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(MaintenanceTask::class))
    ) {
      com.icure.cardinal.sdk.filters.MaintenanceTaskFilters.afterDateForSelf(
        date,
      )
    }
  }
}
