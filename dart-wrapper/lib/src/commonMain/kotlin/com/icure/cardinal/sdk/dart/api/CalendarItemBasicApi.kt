// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

public object CalendarItemBasicApi {
  public fun matchCalendarItemsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.matchCalendarItemsBy(
        filter,
      )
    }
  }

  public fun matchCalendarItemsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.matchCalendarItemsBySorted(
        filter,
      )
    }
  }

  public fun filterCalendarItemsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.filterCalendarItemsBy(
        filter,
      )
      NativeReferences.create(richResult)}
  }

  public fun filterCalendarItemsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.filterCalendarItemsBySorted(
        filter,
      )
      NativeReferences.create(richResult)}
  }

  public fun deleteCalendarItemById(
    dartResultCallback: (
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
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.deleteCalendarItemById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteCalendarItemsByIds(
    dartResultCallback: (
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
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.deleteCalendarItemsByIds(
        entityIds,
      )
    }
  }

  public fun purgeCalendarItemById(
    dartResultCallback: (
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
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.purgeCalendarItemById(
        id,
        rev,
      )
    }
  }

  public fun deleteCalendarItem(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.deleteCalendarItem(
        calendarItem,
      )
    }
  }

  public fun deleteCalendarItems(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemsString: String,
  ) {
    val calendarItems = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(CalendarItem::class)),
      calendarItemsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.deleteCalendarItems(
        calendarItems,
      )
    }
  }

  public fun purgeCalendarItem(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.purgeCalendarItem(
        calendarItem,
      )
    }
  }

  public fun undeleteCalendarItemById(
    dartResultCallback: (
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
      EncryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.undeleteCalendarItemById(
        id,
        rev,
      )
    }
  }

  public fun undeleteCalendarItem(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.undeleteCalendarItem(
        calendarItem,
      )
    }
  }

  public fun modifyCalendarItem(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      EncryptedCalendarItem.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.modifyCalendarItem(
        entity,
      )
    }
  }

  public fun getCalendarItem(
    dartResultCallback: (
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
      EncryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.getCalendarItem(
        entityId,
      )
    }
  }

  public fun getCalendarItems(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedCalendarItem.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.getCalendarItems(
        entityIds,
      )
    }
  }

  public fun subscribeToEvents(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    eventsString: String,
    filterString: String,
    subscriptionConfigString: String,
  ) {
    val events = fullLanguageInteropJson.decodeFromString(
      SetSerializer(SubscriptionEventType.serializer()),
      eventsString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseSdk>(sdkId).calendarItem.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(richResult)}
  }
}
