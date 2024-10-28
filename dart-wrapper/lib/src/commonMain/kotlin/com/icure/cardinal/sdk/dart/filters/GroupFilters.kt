// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object GroupFilters {
  public fun all(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Group.serializer())
    ) {
      com.icure.cardinal.sdk.filters.GroupFilters.all(
      )
    }
  }

  public fun bySuperGroup(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, superGroupIdString: String) {
    val superGroupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      superGroupIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Group.serializer())
    ) {
      com.icure.cardinal.sdk.filters.GroupFilters.bySuperGroup(
        superGroupId,
      )
    }
  }

  public fun withContent(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    superGroupIdString: String,
    searchStringString: String,
  ) {
    val superGroupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      superGroupIdString
    )
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(Group.serializer())
    ) {
      com.icure.cardinal.sdk.filters.GroupFilters.withContent(
        superGroupId,
        searchString,
      )
    }
  }
}
