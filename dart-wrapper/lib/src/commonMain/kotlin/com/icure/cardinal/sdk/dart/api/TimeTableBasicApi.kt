// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object TimeTableBasicApi {
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
      BaseFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.matchTimeTablesBy(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.matchTimeTablesBySorted(
        filter,
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
      BaseFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.filterTimeTablesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedTimeTable.serializer()
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.filterTimeTablesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedTimeTable.serializer()
      ))
    }
  }

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
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.deleteTimeTableById(
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
      ListSerializer(IdWithMandatoryRev.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.deleteTimeTablesByIds(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.purgeTimeTableById(
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
      PolymorphicSerializer(TimeTable::class),
      timeTableString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.deleteTimeTable(
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
      ListSerializer(PolymorphicSerializer(TimeTable::class)),
      timeTablesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.deleteTimeTables(
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
      PolymorphicSerializer(TimeTable::class),
      timeTableString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.purgeTimeTable(
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
      PolymorphicSerializer(TimeTable::class),
      timeTableString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(TimeTable::class)) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.undeleteTimeTable(
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
      EncryptedTimeTable.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.modifyTimeTable(
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
      EncryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.undeleteTimeTableById(
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
      EncryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.getTimeTable(
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
      ListSerializer(EncryptedTimeTable.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).timeTable.getTimeTables(
        timeTableIds,
      )
    }
  }
}
