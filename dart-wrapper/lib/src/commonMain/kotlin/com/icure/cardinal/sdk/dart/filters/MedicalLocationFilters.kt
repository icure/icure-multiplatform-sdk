// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.model.MedicalLocation
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object MedicalLocationFilters {
  public fun all(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(MedicalLocation.serializer())
    ) {
      com.icure.cardinal.sdk.filters.MedicalLocationFilters.all(
      )
    }
  }

  public fun byPostCode(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, postCodeString: String) {
    val postCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      postCodeString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(MedicalLocation.serializer())
    ) {
      com.icure.cardinal.sdk.filters.MedicalLocationFilters.byPostCode(
        postCode,
      )
    }
  }
}
