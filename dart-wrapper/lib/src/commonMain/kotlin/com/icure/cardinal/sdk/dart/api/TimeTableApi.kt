// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.TimeTableShareOptions
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTimeTable
import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
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

@OptIn(InternalIcureApi::class)
public object TimeTableApi {
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
      DecryptedTimeTable.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.createTimeTable(
        entity,
      )
    }
  }

  public fun withEncryptionMetadata(
    dartResultCallback: (
      String?,
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
      DecryptedTimeTable.serializer().nullable,
      baseString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class).nullable,
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
      DecryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.withEncryptionMetadata(
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
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.getEncryptionKeysOf(
        timeTable,
      )
    }
  }

  public fun hasWriteAccess(
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
      Boolean.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.hasWriteAccess(
        timeTable,
      )
    }
  }

  public fun decryptPatientIdOf(
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
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.decryptPatientIdOf(
        timeTable,
      )
    }
  }

  public fun createDelegationDeAnonymizationMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
    delegatesString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(TimeTable::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.createDelegationDeAnonymizationMetadata(
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
      String?,
    ) -> Unit,
    sdkId: String,
    timeTableString: String,
  ) {
    val timeTable = fullLanguageInteropJson.decodeFromString(
      EncryptedTimeTable.serializer(),
      timeTableString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.decrypt(
        timeTable,
      )
    }
  }

  public fun tryDecrypt(
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
      EncryptedTimeTable.serializer(),
      timeTableString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(TimeTable::class)) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryDecrypt(
        timeTable,
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
      FilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.matchTimeTablesBy(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.matchTimeTablesBySorted(
        filter,
      )
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
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.deleteTimeTableById(
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
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.deleteTimeTablesByIds(
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
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.purgeTimeTableById(
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
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.deleteTimeTable(
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
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.deleteTimeTables(
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
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.purgeTimeTable(
        timeTable,
      )
    }
  }

  public fun shareWith(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    delegateIdString: String,
    timeTableString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val timeTable = fullLanguageInteropJson.decodeFromString(
      DecryptedTimeTable.serializer(),
      timeTableString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      TimeTableShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.shareWith(
        delegateId,
        timeTable,
        options,
      )
    }
  }

  public fun shareWithMany(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    timeTableString: String,
    delegatesString: String,
  ) {
    val timeTable = fullLanguageInteropJson.decodeFromString(
      DecryptedTimeTable.serializer(),
      timeTableString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), TimeTableShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.shareWithMany(
        timeTable,
        delegates,
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
      FilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).timeTable.filterTimeTablesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedTimeTable.serializer()
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
      SortableFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).timeTable.filterTimeTablesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedTimeTable.serializer()
      ))
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
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.undeleteTimeTable(
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
      DecryptedTimeTable.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.modifyTimeTable(
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
      DecryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.undeleteTimeTableById(
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
      DecryptedTimeTable.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.getTimeTable(
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
      ListSerializer(DecryptedTimeTable.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).timeTable.getTimeTables(
        timeTableIds,
      )
    }
  }

  @OptIn(InternalIcureApi::class)
  public object encrypted {
    public fun shareWith(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      timeTableString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val timeTable = fullLanguageInteropJson.decodeFromString(
        EncryptedTimeTable.serializer(),
        timeTableString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        TimeTableShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTimeTable.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.shareWith(
          delegateId,
          timeTable,
          options,
        )
      }
    }

    public fun shareWithMany(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      timeTableString: String,
      delegatesString: String,
    ) {
      val timeTable = fullLanguageInteropJson.decodeFromString(
        EncryptedTimeTable.serializer(),
        timeTableString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), TimeTableShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTimeTable.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.shareWithMany(
          timeTable,
          delegates,
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
        FilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.filterTimeTablesBy(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.filterTimeTablesBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedTimeTable.serializer()
        ))
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
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.undeleteTimeTable(
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
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.modifyTimeTable(
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
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.undeleteTimeTableById(
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
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.getTimeTable(
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
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.encrypted.getTimeTables(
          timeTableIds,
        )
      }
    }
  }

  @OptIn(InternalIcureApi::class)
  public object tryAndRecover {
    public fun shareWith(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      timeTableString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val timeTable = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(TimeTable::class),
        timeTableString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        TimeTableShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(TimeTable::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.shareWith(
          delegateId,
          timeTable,
          options,
        )
      }
    }

    public fun shareWithMany(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      timeTableString: String,
      delegatesString: String,
    ) {
      val timeTable = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(TimeTable::class),
        timeTableString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), TimeTableShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(TimeTable::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.shareWithMany(
          timeTable,
          delegates,
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
        FilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.filterTimeTablesBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(TimeTable::class)
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
        SortableFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.filterTimeTablesBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(TimeTable::class)
        ))
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
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.undeleteTimeTable(
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
        PolymorphicSerializer(TimeTable::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(TimeTable::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.modifyTimeTable(
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
        PolymorphicSerializer(TimeTable::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.undeleteTimeTableById(
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
        PolymorphicSerializer(TimeTable::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.getTimeTable(
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
        ListSerializer(PolymorphicSerializer(TimeTable::class))) {
        NativeReferences.get<CardinalSdk>(sdkId).timeTable.tryAndRecover.getTimeTables(
          timeTableIds,
        )
      }
    }
  }
}
