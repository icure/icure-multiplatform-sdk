// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

public object InsuranceApi {
  public fun getInsurance(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceIdString: String,
  ) {
    val insuranceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      insuranceIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Insurance.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).insurance.getInsurance(
        insuranceId,
      )
    }
  }

  public fun getInsurances(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceIdsString: String,
  ) {
    val insuranceIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      insuranceIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).insurance.getInsurances(
        insuranceIds,
      )
    }
  }

  public fun createInsurance(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceString: String,
  ) {
    val insurance = fullLanguageInteropJson.decodeFromString(
      Insurance.serializer(),
      insuranceString
    )
    ApiScope.execute(
      dartResultCallback,
      Insurance.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).insurance.createInsurance(
        insurance,
      )
    }
  }

  public fun deleteInsurance(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceIdString: String,
  ) {
    val insuranceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      insuranceIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).insurance.deleteInsurance(
        insuranceId,
      )
    }
  }

  public fun getAllInsurances(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    startDocumentIdString: String,
    limitString: String,
  ) {
    val startDocumentId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      startDocumentIdString
    )
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      PaginatedList.serializer(Insurance.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).insurance.getAllInsurances(
        startDocumentId,
        limit,
      )
    }
  }

  public fun listInsurancesByCode(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceCodeString: String,
  ) {
    val insuranceCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      insuranceCodeString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).insurance.listInsurancesByCode(
        insuranceCode,
      )
    }
  }

  public fun listInsurancesByName(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceNameString: String,
  ) {
    val insuranceName = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      insuranceNameString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Insurance.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).insurance.listInsurancesByName(
        insuranceName,
      )
    }
  }

  public fun modifyInsurance(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    insuranceString: String,
  ) {
    val insurance = fullLanguageInteropJson.decodeFromString(
      Insurance.serializer(),
      insuranceString
    )
    ApiScope.execute(
      dartResultCallback,
      Insurance.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).insurance.modifyInsurance(
        insurance,
      )
    }
  }
}
