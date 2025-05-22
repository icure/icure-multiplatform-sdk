// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
public object TimeTableApi {
  public fun deleteTimeTableById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.deleteTimeTableById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteTimeTablesByIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(StoredDocumentIdentifier.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.deleteTimeTablesByIds(
        entityIds,
      )
    }
  }

  public fun purgeTimeTableById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.purgeTimeTableById(
        id,
        rev,
      )
    }
  }

  public fun deleteTimeTable(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    timeTableString: String,
  ) {
    val timeTable = fullLanguageInteropJson.decodeFromString(
      TimeTable.serializer(),
      timeTableString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.deleteTimeTable(
        timeTable,
      )
    }
  }

  public fun deleteTimeTables(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    timeTablesString: String,
  ) {
    val timeTables = fullLanguageInteropJson.decodeFromString(
      ListSerializer(TimeTable.serializer()),
      timeTablesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.deleteTimeTables(
        timeTables,
      )
    }
  }

  public fun purgeTimeTable(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    timeTableString: String,
  ) {
    val timeTable = fullLanguageInteropJson.decodeFromString(
      TimeTable.serializer(),
      timeTableString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.purgeTimeTable(
        timeTable,
      )
    }
  }

  public fun undeleteTimeTable(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    timeTableString: String,
  ) {
    val timeTable = fullLanguageInteropJson.decodeFromString(
      TimeTable.serializer(),
      timeTableString
    )
    ApiScope.execute(
      dartResultCallback,
      TimeTable.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.undeleteTimeTable(
        timeTable,
      )
    }
  }

  public fun modifyTimeTable(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      TimeTable.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      TimeTable.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.modifyTimeTable(
        entity,
      )
    }
  }

  public fun undeleteTimeTableById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      TimeTable.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.undeleteTimeTableById(
        id,
        rev,
      )
    }
  }

  public fun getTimeTable(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    ApiScope.execute(
      dartResultCallback,
      TimeTable.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.getTimeTable(
        entityId,
      )
    }
  }

  public fun getTimeTables(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    timeTableIdsString: String,
  ) {
    val timeTableIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      timeTableIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(TimeTable.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.getTimeTables(
        timeTableIds,
      )
    }
  }

  public fun filterTimeTablesBy(
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
      BaseFilterOptions.serializer(TimeTable.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).timeTable.filterTimeTablesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        TimeTable.serializer()
      ))
    }
  }

  public fun filterTimeTablesBySorted(
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
      BaseSortableFilterOptions.serializer(TimeTable.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).timeTable.filterTimeTablesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        TimeTable.serializer()
      ))
    }
  }

  public fun createTimeTable(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      TimeTable.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      TimeTable.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.createTimeTable(
        entity,
      )
    }
  }

  public fun matchTimeTablesBy(
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
      BaseFilterOptions.serializer(TimeTable.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.matchTimeTablesBy(
        filter,
      )
    }
  }

  public fun matchTimeTablesBySorted(
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
      BaseSortableFilterOptions.serializer(TimeTable.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).timeTable.matchTimeTablesBySorted(
        filter,
      )
    }
  }
}
