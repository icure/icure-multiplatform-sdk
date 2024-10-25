// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object AgendaFilters {
  public fun all(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.all(
      )
    }
  }

  public fun byUser(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, userIdString: String) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.byUser(
        userId,
      )
    }
  }

  public fun readableByUser(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, userIdString: String) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.readableByUser(
        userId,
      )
    }
  }
}
