// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object FormFilters {
  public fun byParentIdForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    parentIdString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val parentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      parentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Form::class))
    ) {
      com.icure.cardinal.sdk.filters.FormFilters.byParentIdForDataOwner(
        dataOwnerId,
        parentId,
      )
    }
  }

  public fun byParentIdForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, parentIdString: String) {
    val parentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      parentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Form::class))
    ) {
      com.icure.cardinal.sdk.filters.FormFilters.byParentIdForSelf(
        parentId,
      )
    }
  }

  public fun byPatientsOpeningDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    patientsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    ApiScope.execute(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Form::class))
    ) {
      com.icure.cardinal.sdk.filters.FormFilters.byPatientsOpeningDateForDataOwner(
        dataOwnerId,
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsOpeningDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    patientsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    ApiScope.execute(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Form::class))
    ) {
      com.icure.cardinal.sdk.filters.FormFilters.byPatientsOpeningDateForSelf(
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsOpeningDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    secretIdsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Form::class))
    ) {
      com.icure.cardinal.sdk.filters.FormFilters.byPatientSecretIdsOpeningDateForDataOwner(
        dataOwnerId,
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsOpeningDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    secretIdsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    ApiScope.execute(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Form::class))
    ) {
      com.icure.cardinal.sdk.filters.FormFilters.byPatientSecretIdsOpeningDateForSelf(
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byLogicalUuid(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    logicalUuidString: String,
    descendingString: String,
  ) {
    val logicalUuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      logicalUuidString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Form::class))
    ) {
      com.icure.cardinal.sdk.filters.FormFilters.byLogicalUuid(
        logicalUuid,
        descending,
      )
    }
  }

  public fun byUniqueId(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    uniqueIdString: String,
    descendingString: String,
  ) {
    val uniqueId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      uniqueIdString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Form::class))
    ) {
      com.icure.cardinal.sdk.filters.FormFilters.byUniqueId(
        uniqueId,
        descending,
      )
    }
  }
}
