// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object DeviceFilters {
  public fun all(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Device.serializer())
    ) {
      com.icure.cardinal.sdk.filters.DeviceFilters.all(
      )
    }
  }

  public fun byResponsible(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, responsibleIdString: String) {
    val responsibleId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      responsibleIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Device.serializer())
    ) {
      com.icure.cardinal.sdk.filters.DeviceFilters.byResponsible(
        responsibleId,
      )
    }
  }

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
      BaseSortableFilterOptions.serializer(Device.serializer())
    ) {
      com.icure.cardinal.sdk.filters.DeviceFilters.byIds(
        ids,
      )
    }
  }
}
