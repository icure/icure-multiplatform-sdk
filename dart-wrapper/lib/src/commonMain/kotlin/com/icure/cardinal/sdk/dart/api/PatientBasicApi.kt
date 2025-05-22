// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object PatientBasicApi {
  public fun matchPatientsBy(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.matchPatientsBy(
        filter,
      )
    }
  }

  public fun matchPatientsBySorted(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.matchPatientsBySorted(
        filter,
      )
    }
  }

  public fun filterPatientsBy(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).patient.filterPatientsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedPatient.serializer()
      ))
    }
  }

  public fun filterPatientsBySorted(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).patient.filterPatientsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedPatient.serializer()
      ))
    }
  }

  public fun deletePatientById(
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
      StoredDocumentIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.deletePatientById(
        entityId,
        rev,
      )
    }
  }

  public fun deletePatientsByIds(
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
      ListSerializer(StoredDocumentIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.deletePatientsByIds(
        entityIds,
      )
    }
  }

  public fun purgePatientById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.purgePatientById(
        id,
        rev,
      )
    }
  }

  public fun deletePatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      StoredDocumentIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.deletePatient(
        patient,
      )
    }
  }

  public fun deletePatients(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientsString: String,
  ) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(StoredDocumentIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.deletePatients(
        patients,
      )
    }
  }

  public fun purgePatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.purgePatient(
        patient,
      )
    }
  }

  public fun getDataOwnersWithAccessTo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      EntityAccessInformation.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.getDataOwnersWithAccessTo(
        patient,
      )
    }
  }

  public fun createPatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      EncryptedPatient.serializer(),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedPatient.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.createPatient(
        patient,
      )
    }
  }

  public fun createPatientsMinimal(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientsString: String,
  ) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedPatient.serializer()),
      patientsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(StoredDocumentIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.createPatientsMinimal(
        patients,
      )
    }
  }

  public fun createPatients(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientsString: String,
  ) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedPatient.serializer()),
      patientsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedPatient.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.createPatients(
        patients,
      )
    }
  }

  public fun undeletePatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Patient::class)) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.undeletePatient(
        patient,
      )
    }
  }

  public fun modifyPatient(
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
      EncryptedPatient.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedPatient.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.modifyPatient(
        entity,
      )
    }
  }

  public fun undeletePatientById(
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
      EncryptedPatient.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.undeletePatientById(
        id,
        rev,
      )
    }
  }

  public fun undeletePatients(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idsString: String,
  ) {
    val ids = fullLanguageInteropJson.decodeFromString(
      ListSerializer(StoredDocumentIdentifier.serializer()),
      idsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedPatient.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.undeletePatients(
        ids,
      )
    }
  }

  public fun getPatient(
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
      EncryptedPatient.serializer().nullable) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.getPatient(
        entityId,
      )
    }
  }

  public fun getPatientResolvingMerges(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientIdString: String,
    maxMergeDepthString: String,
  ) {
    val patientId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      patientIdString
    )
    val maxMergeDepth = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      maxMergeDepthString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedPatient.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.getPatientResolvingMerges(
        patientId,
        maxMergeDepth,
      )
    }
  }

  public fun getPatients(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientIdsString: String,
  ) {
    val patientIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      patientIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedPatient.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.getPatients(
        patientIds,
      )
    }
  }

  public fun modifyPatientsMinimal(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientsString: String,
  ) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedPatient.serializer()),
      patientsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(StoredDocumentIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.modifyPatientsMinimal(
        patients,
      )
    }
  }

  public fun modifyPatients(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientsString: String,
  ) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedPatient.serializer()),
      patientsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedPatient.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.modifyPatients(
        patients,
      )
    }
  }

  public fun mergePatients(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    fromString: String,
    mergedIntoString: String,
  ) {
    val from = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      fromString
    )
    val mergedInto = fullLanguageInteropJson.decodeFromString(
      EncryptedPatient.serializer(),
      mergedIntoString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedPatient.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).patient.mergePatients(
        from,
        mergedInto,
      )
    }
  }

  public fun subscribeToEvents(
    dartResultCallback: (
      String?,
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).patient.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedPatient.serializer()
      ))
    }
  }

  @OptIn(InternalIcureApi::class)
  public object inGroup {
    public fun matchPatientsBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.matchPatientsBy(
          groupId,
          filter,
        )
      }
    }

    public fun matchPatientsBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.matchPatientsBySorted(
          groupId,
          filter,
        )
      }
    }

    public fun filterPatientsBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.filterPatientsBy(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(EncryptedPatient.serializer())
        ))
      }
    }

    public fun filterPatientsBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.filterPatientsBySorted(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(EncryptedPatient.serializer())
        ))
      }
    }

    public fun getDataOwnersWithAccessTo(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      patientString: String,
    ) {
      val patient = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(PolymorphicSerializer(Patient::class)),
        patientString
      )
      ApiScope.execute(
        dartResultCallback,
        EntityAccessInformation.serializer()) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.getDataOwnersWithAccessTo(
          patient,
        )
      }
    }

    public fun createPatient(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      patientString: String,
    ) {
      val patient = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(EncryptedPatient.serializer()),
        patientString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(EncryptedPatient.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.createPatient(
          patient,
        )
      }
    }

    public fun createPatientsMinimal(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      patientsString: String,
    ) {
      val patients = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer())),
        patientsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.createPatientsMinimal(
          patients,
        )
      }
    }

    public fun createPatients(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      patientsString: String,
    ) {
      val patients = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer())),
        patientsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer()))) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.createPatients(
          patients,
        )
      }
    }

    public fun getPatient(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      entityIdString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(EncryptedPatient.serializer()).nullable) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.getPatient(
          groupId,
          entityId,
        )
      }
    }

    public fun getPatientResolvingMerges(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      patientIdString: String,
      maxMergeDepthString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val patientId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        patientIdString
      )
      val maxMergeDepth = fullLanguageInteropJson.decodeFromString(
        Int.serializer().nullable,
        maxMergeDepthString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(EncryptedPatient.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.getPatientResolvingMerges(
          groupId,
          patientId,
          maxMergeDepth,
        )
      }
    }

    public fun getPatients(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      patientIdsString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val patientIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        patientIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer()))) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.getPatients(
          groupId,
          patientIds,
        )
      }
    }

    public fun modifyPatientsMinimal(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      patientsString: String,
    ) {
      val patients = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer())),
        patientsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.modifyPatientsMinimal(
          patients,
        )
      }
    }

    public fun modifyPatients(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      patientsString: String,
    ) {
      val patients = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer())),
        patientsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer()))) {
        NativeReferences.get<CardinalBaseApis>(sdkId).patient.inGroup.modifyPatients(
          patients,
        )
      }
    }
  }
}
