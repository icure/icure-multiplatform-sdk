// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
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
public object CalendarItemFilters {
  public fun byPatientsStartTimeForDataOwner(
    dartResultCallback: (
      String?,
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
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPatientsStartTimeForDataOwner(
        dataOwnerId,
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsStartTimeForDataOwnerInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerString: String,
    patientsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwner = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      dataOwnerString
    )
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(GroupScoped.serializer(PolymorphicSerializer(Patient::class))),
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
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPatientsStartTimeForDataOwnerInGroup(
        dataOwner,
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsStartTimeForSelf(
    dartResultCallback: (
      String?,
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
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPatientsStartTimeForSelf(
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsStartTimeForDataOwner(
    dartResultCallback: (
      String?,
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
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner(
        dataOwnerId,
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsStartTimeForDataOwnerInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerString: String,
    secretIdsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwner = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      dataOwnerString
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
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwnerInGroup(
        dataOwner,
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsStartTimeForSelf(
    dartResultCallback: (
      String?,
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
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPatientSecretIdsStartTimeForSelf(
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPeriodAndAgenda(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    agendaIdString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val agendaId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      agendaIdString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPeriodAndAgenda(
        agendaId,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPeriodForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    fromString: String,
    toString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      toString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPeriodForDataOwner(
        dataOwnerId,
        from,
        to,
      )
    }
  }

  public fun byPeriodForDataOwnerInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerString: String,
    fromString: String,
    toString: String,
  ) {
    val dataOwner = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      dataOwnerString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      toString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPeriodForDataOwnerInGroup(
        dataOwner,
        from,
        to,
      )
    }
  }

  public fun byPeriodForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    fromString: String,
    toString: String,
  ) {
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      toString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byPeriodForSelf(
        from,
        to,
      )
    }
  }

  public fun byRecurrenceId(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, recurrenceIdString: String) {
    val recurrenceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      recurrenceIdString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.byRecurrenceId(
        recurrenceId,
      )
    }
  }

  public fun lifecycleBetweenForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    startTimestampString: String,
    endTimestampString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val startTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startTimestampString
    )
    val endTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endTimestampString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.lifecycleBetweenForDataOwner(
        dataOwnerId,
        startTimestamp,
        endTimestamp,
        descending,
      )
    }
  }

  public fun lifecycleBetweenForDataOwnerInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerString: String,
    startTimestampString: String,
    endTimestampString: String,
    descendingString: String,
  ) {
    val dataOwner = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      dataOwnerString
    )
    val startTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startTimestampString
    )
    val endTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endTimestampString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.lifecycleBetweenForDataOwnerInGroup(
        dataOwner,
        startTimestamp,
        endTimestamp,
        descending,
      )
    }
  }

  public fun lifecycleBetweenForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    startTimestampString: String,
    endTimestampString: String,
    descendingString: String,
  ) {
    val startTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startTimestampString
    )
    val endTimestamp = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endTimestampString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class))
    ) {
      com.icure.cardinal.sdk.filters.CalendarItemFilters.lifecycleBetweenForSelf(
        startTimestamp,
        endTimestamp,
        descending,
      )
    }
  }
}
