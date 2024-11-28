// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
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
}
