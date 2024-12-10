// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
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
public object PatientApi {
  public fun getSecretIdsOf(
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
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.getSecretIdsOf(
        patient,
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
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.getEncryptionKeysOf(
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
      DecryptedPatient.serializer(),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.createPatient(
        patient,
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
    userString: String,
    delegatesString: String,
  ) {
    val base = fullLanguageInteropJson.decodeFromString(
      DecryptedPatient.serializer().nullable,
      baseString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer().nullable,
      userString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), AccessLevel.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.withEncryptionMetadata(
        base,
        user,
        delegates,
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
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.hasWriteAccess(
        patient,
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
      PolymorphicSerializer(Patient::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.createDelegationDeAnonymizationMetadata(
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
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      EncryptedPatient.serializer(),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.decrypt(
        patient,
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
    patientString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      EncryptedPatient.serializer(),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Patient::class)) {
      NativeReferences.get<CardinalApis>(sdkId).patient.tryDecrypt(
        patient,
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
    patientDtosString: String,
  ) {
    val patientDtos = fullLanguageInteropJson.decodeFromString(
      ListSerializer(DecryptedPatient.serializer()),
      patientDtosString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.createPatients(
        patientDtos,
      )
    }
  }

  public fun shareAllDataOfPatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientIdString: String,
    delegatesWithShareTypeString: String,
  ) {
    val patientId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      patientIdString
    )
    val delegatesWithShareType = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(),
          SetSerializer(ShareAllPatientDataOptions.Tag.serializer())),
      delegatesWithShareTypeString
    )
    ApiScope.execute(
      dartResultCallback,
      ShareAllPatientDataOptions.Result.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.shareAllDataOfPatient(
        patientId,
        delegatesWithShareType,
      )
    }
  }

  public fun getConfidentialSecretIdsOf(
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
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.getConfidentialSecretIdsOf(
        patient,
      )
    }
  }

  public fun forceInitializeExchangeDataToNewlyInvitedPatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    patientIdString: String,
  ) {
    val patientId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      patientIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.forceInitializeExchangeDataToNewlyInvitedPatient(
        patientId,
      )
    }
  }

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
      FilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.matchPatientsBy(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.matchPatientsBySorted(
        filter,
      )
    }
  }

  public fun ensureEncryptionMetadataForSelfIsInitialized(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    sharingWithString: String,
  ) {
    val sharingWith = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), AccessLevel.serializer()),
      sharingWithString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.ensureEncryptionMetadataForSelfIsInitialized(
        sharingWith,
      )
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
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.deletePatientById(
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
      ListSerializer(IdWithMandatoryRev.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.deletePatientsByIds(
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
      NativeReferences.get<CardinalApis>(sdkId).patient.purgePatientById(
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
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.deletePatient(
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
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.deletePatients(
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
      NativeReferences.get<CardinalApis>(sdkId).patient.purgePatient(
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
      NativeReferences.get<CardinalApis>(sdkId).patient.getDataOwnersWithAccessTo(
        patient,
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
    patientString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      DecryptedPatient.serializer(),
      patientString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      PatientShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.shareWith(
        delegateId,
        patient,
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
    patientString: String,
    delegatesString: String,
  ) {
    val patient = fullLanguageInteropJson.decodeFromString(
      DecryptedPatient.serializer(),
      patientString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), PatientShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.shareWithMany(
        patient,
        delegates,
      )
    }
  }

  public fun initializeConfidentialSecretId(
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
      DecryptedPatient.serializer(),
      patientString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.initializeConfidentialSecretId(
        patient,
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
      FilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).patient.filterPatientsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedPatient.serializer()
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).patient.filterPatientsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedPatient.serializer()
      ))
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
      NativeReferences.get<CardinalApis>(sdkId).patient.undeletePatient(
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
      DecryptedPatient.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.modifyPatient(
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
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.undeletePatientById(
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
      ListSerializer(IdWithMandatoryRev.serializer()),
      idsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedPatient.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.undeletePatients(
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
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.getPatient(
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
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.getPatientResolvingMerges(
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
      ListSerializer(DecryptedPatient.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.getPatients(
        patientIds,
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
    patientDtosString: String,
  ) {
    val patientDtos = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedPatient.serializer()),
      patientDtosString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).patient.modifyPatients(
        patientDtos,
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
      DecryptedPatient.serializer(),
      mergedIntoString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedPatient.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).patient.mergePatients(
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
      FilterOptions.serializer(PolymorphicSerializer(Patient::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).patient.subscribeToEvents(
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
      patientString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val patient = fullLanguageInteropJson.decodeFromString(
        EncryptedPatient.serializer(),
        patientString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        PatientShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedPatient.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.shareWith(
          delegateId,
          patient,
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
      patientString: String,
      delegatesString: String,
    ) {
      val patient = fullLanguageInteropJson.decodeFromString(
        EncryptedPatient.serializer(),
        patientString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), PatientShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedPatient.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.shareWithMany(
          patient,
          delegates,
        )
      }
    }

    public fun initializeConfidentialSecretId(
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
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.initializeConfidentialSecretId(
          patient,
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
        FilterOptions.serializer(PolymorphicSerializer(Patient::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.filterPatientsBy(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.filterPatientsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedPatient.serializer()
        ))
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
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.undeletePatient(
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
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.modifyPatient(
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
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.undeletePatientById(
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
        ListSerializer(IdWithMandatoryRev.serializer()),
        idsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedPatient.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.undeletePatients(
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
        EncryptedPatient.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.getPatient(
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
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.getPatientResolvingMerges(
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
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.getPatients(
          patientIds,
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
      patientDtosString: String,
    ) {
      val patientDtos = fullLanguageInteropJson.decodeFromString(
        ListSerializer(EncryptedPatient.serializer()),
        patientDtosString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(IdWithRev.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.modifyPatients(
          patientDtos,
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
        NativeReferences.get<CardinalApis>(sdkId).patient.encrypted.mergePatients(
          from,
          mergedInto,
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
      patientString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val patient = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Patient::class),
        patientString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        PatientShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Patient::class)) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.shareWith(
          delegateId,
          patient,
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
      patientString: String,
      delegatesString: String,
    ) {
      val patient = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Patient::class),
        patientString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), PatientShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Patient::class)) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.shareWithMany(
          patient,
          delegates,
        )
      }
    }

    public fun initializeConfidentialSecretId(
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
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.initializeConfidentialSecretId(
          patient,
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
        FilterOptions.serializer(PolymorphicSerializer(Patient::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.filterPatientsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Patient::class)
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.filterPatientsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Patient::class)
        ))
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
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.undeletePatient(
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
        PolymorphicSerializer(Patient::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Patient::class)) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.modifyPatient(
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
        PolymorphicSerializer(Patient::class)) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.undeletePatientById(
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
        ListSerializer(IdWithMandatoryRev.serializer()),
        idsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Patient::class))) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.undeletePatients(
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
        PolymorphicSerializer(Patient::class)) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.getPatient(
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
        PolymorphicSerializer(Patient::class)) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.getPatientResolvingMerges(
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
        ListSerializer(PolymorphicSerializer(Patient::class))) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.getPatients(
          patientIds,
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
      patientDtosString: String,
    ) {
      val patientDtos = fullLanguageInteropJson.decodeFromString(
        ListSerializer(EncryptedPatient.serializer()),
        patientDtosString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(IdWithRev.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.modifyPatients(
          patientDtos,
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
        PolymorphicSerializer(Patient::class),
        mergedIntoString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Patient::class)) {
        NativeReferences.get<CardinalApis>(sdkId).patient.tryAndRecover.mergePatients(
          from,
          mergedInto,
        )
      }
    }
  }
}
