// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

public object CalendarItemApi {
  public fun createCalendarItem(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      DecryptedCalendarItem.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.createCalendarItem(
        entity,
      )
    }
  }

  public fun withEncryptionMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    baseString: String,
    patientString: String,
    userString: String,
    delegatesString: String,
    secretIdString: String,
  ) {
    val base = fullLanguageInteropJson.decodeFromString(
      DecryptedCalendarItem.serializer().nullable,
      baseString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer().nullable,
      userString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), AccessLevel.serializer()),
      delegatesString
    )
    val secretId = fullLanguageInteropJson.decodeFromString(
      SecretIdUseOption.serializer(),
      secretIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.withEncryptionMetadata(
        base,
        patient,
        user,
        delegates,
        secretId,
      )
    }
  }

  public fun getEncryptionKeysOf(
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
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.getEncryptionKeysOf(
        calendarItem,
      )
    }
  }

  public fun hasWriteAccess(
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
      Boolean.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.hasWriteAccess(
        calendarItem,
      )
    }
  }

  public fun decryptPatientIdOf(
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
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.decryptPatientIdOf(
        calendarItem,
      )
    }
  }

  public fun createDelegationDeAnonymizationMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
    delegatesString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.createDelegationDeAnonymizationMetadata(
        entity,
        delegates,
      )
    }
  }

  public fun decrypt(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      EncryptedCalendarItem.serializer(),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.decrypt(
        calendarItem,
      )
    }
  }

  public fun tryDecrypt(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      EncryptedCalendarItem.serializer(),
      calendarItemString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(CalendarItem::class)) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryDecrypt(
        calendarItem,
      )
    }
  }

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
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.matchCalendarItemsBy(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.matchCalendarItemsBySorted(
        filter,
      )
    }
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
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.deleteCalendarItemById(
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
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.deleteCalendarItemsByIds(
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
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.purgeCalendarItemById(
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
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.deleteCalendarItem(
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
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.deleteCalendarItems(
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
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.purgeCalendarItem(
        calendarItem,
      )
    }
  }

  public fun shareWith(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    delegateIdString: String,
    calendarItemString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      DecryptedCalendarItem.serializer(),
      calendarItemString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      CalendarItemShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.shareWith(
        delegateId,
        calendarItem,
        options,
      )
    }
  }

  public fun shareWithMany(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
    delegatesString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      DecryptedCalendarItem.serializer(),
      calendarItemString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), CalendarItemShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.shareWithMany(
        calendarItem,
        delegates,
      )
    }
  }

  public fun linkToPatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    calendarItemString: String,
    patientString: String,
    shareLinkWithDelegatesString: String,
  ) {
    val calendarItem = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(CalendarItem::class),
      calendarItemString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    val shareLinkWithDelegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      shareLinkWithDelegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.linkToPatient(
        calendarItem,
        patient,
        shareLinkWithDelegates,
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
      FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).calendarItem.filterCalendarItemsBy(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalSdk>(sdkId).calendarItem.filterCalendarItemsBySorted(
        filter,
      )
      NativeReferences.create(richResult)}
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
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.undeleteCalendarItemById(
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
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.undeleteCalendarItem(
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
      DecryptedCalendarItem.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.modifyCalendarItem(
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
      DecryptedCalendarItem.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.getCalendarItem(
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
      ListSerializer(DecryptedCalendarItem.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).calendarItem.getCalendarItems(
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
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).calendarItem.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(richResult)}
  }

  public object encrypted {
    public fun shareWith(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      calendarItemString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        EncryptedCalendarItem.serializer(),
        calendarItemString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        CalendarItemShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.shareWith(
          delegateId,
          calendarItem,
          options,
        )
      }
    }

    public fun shareWithMany(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
      delegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        EncryptedCalendarItem.serializer(),
        calendarItemString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), CalendarItemShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.shareWithMany(
          calendarItem,
          delegates,
        )
      }
    }

    public fun linkToPatient(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
      patientString: String,
      shareLinkWithDelegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      val patient = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Patient::class),
        patientString
      )
      val shareLinkWithDelegates = fullLanguageInteropJson.decodeFromString(
        SetSerializer(String.serializer()),
        shareLinkWithDelegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedCalendarItem.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.linkToPatient(
          calendarItem,
          patient,
          shareLinkWithDelegates,
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
        FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.filterCalendarItemsBy(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.filterCalendarItemsBySorted(
          filter,
        )
        NativeReferences.create(richResult)}
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
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.undeleteCalendarItemById(
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
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.undeleteCalendarItem(
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
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.modifyCalendarItem(
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
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.getCalendarItem(
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
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.encrypted.getCalendarItems(
          entityIds,
        )
      }
    }
  }

  public object tryAndRecover {
    public fun shareWith(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      calendarItemString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        CalendarItemShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.shareWith(
          delegateId,
          calendarItem,
          options,
        )
      }
    }

    public fun shareWithMany(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
      delegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), CalendarItemShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.shareWithMany(
          calendarItem,
          delegates,
        )
      }
    }

    public fun linkToPatient(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      calendarItemString: String,
      patientString: String,
      shareLinkWithDelegatesString: String,
    ) {
      val calendarItem = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(CalendarItem::class),
        calendarItemString
      )
      val patient = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Patient::class),
        patientString
      )
      val shareLinkWithDelegates = fullLanguageInteropJson.decodeFromString(
        SetSerializer(String.serializer()),
        shareLinkWithDelegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.linkToPatient(
          calendarItem,
          patient,
          shareLinkWithDelegates,
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
        FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.filterCalendarItemsBy(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.filterCalendarItemsBySorted(
          filter,
        )
        NativeReferences.create(richResult)}
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
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.undeleteCalendarItemById(
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
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.undeleteCalendarItem(
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
        PolymorphicSerializer(CalendarItem::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.modifyCalendarItem(
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
        PolymorphicSerializer(CalendarItem::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.getCalendarItem(
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
        ListSerializer(PolymorphicSerializer(CalendarItem::class))) {
        NativeReferences.get<CardinalSdk>(sdkId).calendarItem.tryAndRecover.getCalendarItems(
          entityIds,
        )
      }
    }
  }
}
