// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.BooleanResponse
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object CodeApi {
  public fun listCodesByRegionTypeCodeVersion(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
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
      ListSerializer(Code.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.listCodesByRegionTypeCodeVersion(
        region,
        type,
        code,
        version,
      )
    }
  }

  public fun listCodeTypesBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    regionString: String,
    typeString: String,
  ) {
    val region = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      regionString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      typeString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.listCodeTypesBy(
        region,
        type,
      )
    }
  }

  public fun listTagTypesBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    regionString: String,
    typeString: String,
  ) {
    val region = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      regionString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      typeString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.listTagTypesBy(
        region,
        type,
      )
    }
  }

  public fun createCode(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    cString: String,
  ) {
    val c = fullLanguageInteropJson.decodeFromString(
      Code.serializer(),
      cString
    )
    ApiScope.execute(
      dartResultCallback,
      Code.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.createCode(
        c,
      )
    }
  }

  public fun createCodes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    codeBatchString: String,
  ) {
    val codeBatch = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Code.serializer()),
      codeBatchString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Code.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.createCodes(
        codeBatch,
      )
    }
  }

  public fun createCodesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    codeBatchString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val codeBatch = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Code.serializer()),
      codeBatchString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Code.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.createCodes(
        groupId,
        codeBatch,
      )
    }
  }

  public fun isCodeValid(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    typeString: String,
    codeString: String,
    versionString: String,
  ) {
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val code = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeString
    )
    val version = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      versionString
    )
    ApiScope.execute(
      dartResultCallback,
      BooleanResponse.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.isCodeValid(
        type,
        code,
        version,
      )
    }
  }

  public fun getCodeByRegionLanguageTypeLabel(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    regionString: String,
    labelString: String,
    typeString: String,
    languagesString: String,
  ) {
    val region = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      regionString
    )
    val label = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      labelString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val languages = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      languagesString
    )
    ApiScope.execute(
      dartResultCallback,
      Code.serializer().nullable) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.getCodeByRegionLanguageTypeLabel(
        region,
        label,
        type,
        languages,
      )
    }
  }

  public fun getCodes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    codeIdsString: String,
  ) {
    val codeIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      codeIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Code.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.getCodes(
        codeIds,
      )
    }
  }

  public fun getCodesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    codeIdsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val codeIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      codeIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Code.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.getCodes(
        groupId,
        codeIds,
      )
    }
  }

  public fun getCode(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    codeIdString: String,
  ) {
    val codeId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Code.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.getCode(
        codeId,
      )
    }
  }

  public fun getCodeWithParts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    typeString: String,
    codeString: String,
    versionString: String,
  ) {
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val code = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeString
    )
    val version = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      versionString
    )
    ApiScope.execute(
      dartResultCallback,
      Code.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.getCodeWithParts(
        type,
        code,
        version,
      )
    }
  }

  public fun modifyCode(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    codeDtoString: String,
  ) {
    val codeDto = fullLanguageInteropJson.decodeFromString(
      Code.serializer(),
      codeDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      Code.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.modifyCode(
        codeDto,
      )
    }
  }

  public fun modifyCodes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    codeBatchString: String,
  ) {
    val codeBatch = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Code.serializer()),
      codeBatchString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Code.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.modifyCodes(
        codeBatch,
      )
    }
  }

  public fun modifyCodesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    codeBatchString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val codeBatch = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Code.serializer()),
      codeBatchString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Code.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.modifyCodes(
        groupId,
        codeBatch,
      )
    }
  }

  public fun filterCodesBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(Code.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.filterCodesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        Code.serializer()
      ))
    }
  }

  public fun filterCodesBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(Code.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.filterCodesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        Code.serializer()
      ))
    }
  }

  public fun matchCodesBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(Code.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.matchCodesBy(
        filter,
      )
    }
  }

  public fun matchCodesBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(Code.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.matchCodesBySorted(
        filter,
      )
    }
  }

  public fun importCodes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    codeTypeString: String,
  ) {
    val codeType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeTypeString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).code.importCodes(
        codeType,
      )
    }
  }
}
