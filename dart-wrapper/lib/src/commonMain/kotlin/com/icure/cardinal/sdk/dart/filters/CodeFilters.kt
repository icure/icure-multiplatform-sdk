// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object CodeFilters {
  public fun all(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(Code.serializer())
    ) {
      com.icure.cardinal.sdk.filters.CodeFilters.all(
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
    ApiScope.execute(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(Code.serializer())
    ) {
      com.icure.cardinal.sdk.filters.CodeFilters.byIds(
        ids,
      )
    }
  }

  public fun byQualifiedLink(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    linkTypeString: String,
    linkedIdString: String,
  ) {
    val linkType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      linkTypeString
    )
    val linkedId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      linkedIdString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(Code.serializer())
    ) {
      com.icure.cardinal.sdk.filters.CodeFilters.byQualifiedLink(
        linkType,
        linkedId,
      )
    }
  }

  public fun byRegionTypeCodeVersion(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    regionString: String,
    typeString: String,
    codeString: String,
    versionString: String,
  ) {
    val region = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      regionString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      typeString
    )
    val code = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      codeString
    )
    val version = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      versionString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(Code.serializer())
    ) {
      com.icure.cardinal.sdk.filters.CodeFilters.byRegionTypeCodeVersion(
        region,
        type,
        code,
        version,
      )
    }
  }

  public fun byLanguageTypeLabelRegion(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    languageString: String,
    typeString: String,
    labelString: String,
    regionString: String,
  ) {
    val language = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      languageString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val label = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      labelString
    )
    val region = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      regionString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(Code.serializer())
    ) {
      com.icure.cardinal.sdk.filters.CodeFilters.byLanguageTypeLabelRegion(
        language,
        type,
        label,
        region,
      )
    }
  }

  public fun byLanguageTypesLabelRegionVersion(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    languageString: String,
    typesString: String,
    labelString: String,
    regionString: String,
    versionString: String,
  ) {
    val language = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      languageString
    )
    val types = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      typesString
    )
    val label = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      labelString
    )
    val region = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      regionString
    )
    val version = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      versionString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(Code.serializer())
    ) {
      com.icure.cardinal.sdk.filters.CodeFilters.byLanguageTypesLabelRegionVersion(
        language,
        types,
        label,
        region,
        version,
      )
    }
  }
}
