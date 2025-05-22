// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object CalendarItemTypeApi {
  public fun createCalendarItemType(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemTypeDtoString: String,
  ) {
    val calendarItemTypeDto = fullLanguageInteropJson.decodeFromString(
      CalendarItemType.serializer(),
      calendarItemTypeDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      CalendarItemType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItemType.createCalendarItemType(
        calendarItemTypeDto,
      )
    }
  }

  public fun deleteCalendarItemTypes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemTypeIdsString: String,
  ) {
    val calendarItemTypeIds = fullLanguageInteropJson.decodeFromString(
      ListOfIds.serializer(),
      calendarItemTypeIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItemType.deleteCalendarItemTypes(
        calendarItemTypeIds,
      )
    }
  }

  public fun getCalendarItemType(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemTypeIdString: String,
  ) {
    val calendarItemTypeId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      calendarItemTypeIdString
    )
    ApiScope.execute(
      dartResultCallback,
      CalendarItemType.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItemType.getCalendarItemType(
        calendarItemTypeId,
      )
    }
  }

  public fun modifyCalendarItemType(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemTypeDtoString: String,
  ) {
    val calendarItemTypeDto = fullLanguageInteropJson.decodeFromString(
      CalendarItemType.serializer(),
      calendarItemTypeDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      CalendarItemType.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItemType.modifyCalendarItemType(
        calendarItemTypeDto,
      )
    }
  }

  public fun listCalendarItemTypesByAgendaId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendaIdString: String,
  ) {
    val agendaId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      agendaIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(CalendarItemType.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).calendarItemType.listCalendarItemTypesByAgendaId(
        agendaId,
      )
    }
  }
}
