// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object TimeTableFilters {
  public fun byAgendaId(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, agendaIdString: String) {
    val agendaId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      agendaIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(TimeTable::class))
    ) {
      com.icure.cardinal.sdk.filters.TimeTableFilters.byAgendaId(
        agendaId,
      )
    }
  }

  public fun byPeriodAndAgendaId(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(TimeTable::class))
    ) {
      com.icure.cardinal.sdk.filters.TimeTableFilters.byPeriodAndAgendaId(
        agendaId,
        from,
        to,
        descending,
      )
    }
  }
}
