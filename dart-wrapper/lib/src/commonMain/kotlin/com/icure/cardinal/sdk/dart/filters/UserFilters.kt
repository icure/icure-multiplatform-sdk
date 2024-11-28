// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object UserFilters {
  public fun all(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(User.serializer())
    ) {
      com.icure.cardinal.sdk.filters.UserFilters.all(
      )
    }
  }

  public fun byIds(dartResultCallback: (
    String?,
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
      BaseSortableFilterOptions.serializer(User.serializer())
    ) {
      com.icure.cardinal.sdk.filters.UserFilters.byIds(
        ids,
      )
    }
  }

  public fun byPatientId(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, patientIdString: String) {
    val patientId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      patientIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(User.serializer())
    ) {
      com.icure.cardinal.sdk.filters.UserFilters.byPatientId(
        patientId,
      )
    }
  }

  public fun byHealthcarePartyId(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, healthcarePartyIdString: String) {
    val healthcarePartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      healthcarePartyIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(User.serializer())
    ) {
      com.icure.cardinal.sdk.filters.UserFilters.byHealthcarePartyId(
        healthcarePartyId,
      )
    }
  }

  public fun byNameEmailOrPhone(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, searchStringString: String) {
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(User.serializer())
    ) {
      com.icure.cardinal.sdk.filters.UserFilters.byNameEmailOrPhone(
        searchString,
      )
    }
  }
}
