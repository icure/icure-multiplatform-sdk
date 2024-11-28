// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object HealthcarePartyFilters {
  public fun all(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.all(
      )
    }
  }

  public fun byIdentifiers(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, identifiersString: String) {
    val identifiers = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Identifier.serializer()),
      identifiersString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.byIdentifiers(
        identifiers,
      )
    }
  }

  public fun byCode(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    codeTypeString: String,
    codeCodeString: String,
  ) {
    val codeType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeTypeString
    )
    val codeCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      codeCodeString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.byCode(
        codeType,
        codeCode,
      )
    }
  }

  public fun byTag(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    tagTypeString: String,
    tagCodeString: String,
  ) {
    val tagType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tagTypeString
    )
    val tagCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tagCodeString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.byTag(
        tagType,
        tagCode,
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
      SortableFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.byIds(
        ids,
      )
    }
  }

  public fun byName(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    searchStringString: String,
    descendingString: String,
  ) {
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.byName(
        searchString,
        descending,
      )
    }
  }

  public fun byNationalIdentifier(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    searchStringString: String,
    descendingString: String,
  ) {
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.byNationalIdentifier(
        searchString,
        descending,
      )
    }
  }

  public fun byParentId(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, parentIdString: String) {
    val parentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      parentIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.byParentId(
        parentId,
      )
    }
  }

  public fun byTypeSpecialtyPostCode(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    specialtyString: String,
    specCodeString: String,
    startPostCodeString: String,
    endPostCodeString: String,
  ) {
    val specialty = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      specialtyString
    )
    val specCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      specCodeString
    )
    val startPostCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      startPostCodeString
    )
    val endPostCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      endPostCodeString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(HealthcareParty.serializer())
    ) {
      com.icure.cardinal.sdk.filters.HealthcarePartyFilters.byTypeSpecialtyPostCode(
        specialty,
        specCode,
        startPostCode,
        endPostCode,
      )
    }
  }
}
