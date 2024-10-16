// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.MedicalLocation
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

public object MedicalLocationApi {
  public fun createMedicalLocation(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    medicalLocationDtoString: String,
  ) {
    val medicalLocationDto = fullLanguageInteropJson.decodeFromString(
      MedicalLocation.serializer(),
      medicalLocationDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      MedicalLocation.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.createMedicalLocation(
        medicalLocationDto,
      )
    }
  }

  public fun deleteMedicalLocations(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    locationIdsString: String,
  ) {
    val locationIds = fullLanguageInteropJson.decodeFromString(
      ListOfIds.serializer(),
      locationIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.deleteMedicalLocations(
        locationIds,
      )
    }
  }

  public fun getMedicalLocation(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    locationIdString: String,
  ) {
    val locationId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      locationIdString
    )
    ApiScope.execute(
      dartResultCallback,
      MedicalLocation.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.getMedicalLocation(
        locationId,
      )
    }
  }

  public fun modifyMedicalLocation(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    medicalLocationDtoString: String,
  ) {
    val medicalLocationDto = fullLanguageInteropJson.decodeFromString(
      MedicalLocation.serializer(),
      medicalLocationDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      MedicalLocation.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.modifyMedicalLocation(
        medicalLocationDto,
      )
    }
  }

  public fun getMedicalLocations(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    medicalLocationIdsString: String,
  ) {
    val medicalLocationIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      medicalLocationIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(MedicalLocation.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.getMedicalLocations(
        medicalLocationIds,
      )
    }
  }

  public fun matchMedicalLocationsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(MedicalLocation.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.matchMedicalLocationsBy(
        filter,
      )
    }
  }

  public fun matchMedicalLocationsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(MedicalLocation.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.matchMedicalLocationsBySorted(
        filter,
      )
    }
  }

  public fun filterMedicalLocationsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(MedicalLocation.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.filterMedicalLocationsBy(
        filter,
      )
      NativeReferences.create(richResult)}
  }

  public fun filterMedicalLocationsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(MedicalLocation.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalSdk>(sdkId).medicalLocation.filterMedicalLocationsBySorted(
        filter,
      )
      NativeReferences.create(richResult)}
  }
}
