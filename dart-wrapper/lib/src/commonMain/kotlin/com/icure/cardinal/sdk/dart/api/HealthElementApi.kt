// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
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
public object HealthElementApi {
  public fun createHealthElement(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      DecryptedHealthElement.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.createHealthElement(
        entity,
      )
    }
  }

  public fun createHealthElements(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entitiesString: String,
  ) {
    val entities = fullLanguageInteropJson.decodeFromString(
      ListSerializer(DecryptedHealthElement.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedHealthElement.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.createHealthElements(
        entities,
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
      DecryptedHealthElement.serializer().nullable,
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
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.withEncryptionMetadata(
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
    healthElementString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(HealthElement::class),
      healthElementString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.getEncryptionKeysOf(
        healthElement,
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
    healthElementString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(HealthElement::class),
      healthElementString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.hasWriteAccess(
        healthElement,
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
    healthElementString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(HealthElement::class),
      healthElementString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.decryptPatientIdOf(
        healthElement,
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
      PolymorphicSerializer(HealthElement::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.createDelegationDeAnonymizationMetadata(
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
    healthElementString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      EncryptedHealthElement.serializer(),
      healthElementString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.decrypt(
        healthElement,
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
    healthElementString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      EncryptedHealthElement.serializer(),
      healthElementString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(HealthElement::class)) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryDecrypt(
        healthElement,
      )
    }
  }

  public fun matchHealthElementsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.matchHealthElementsBy(
        filter,
      )
    }
  }

  public fun matchHealthElementsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.matchHealthElementsBySorted(
        filter,
      )
    }
  }

  public fun deleteHealthElementById(
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
      String.serializer().nullable,
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.deleteHealthElementById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteHealthElementsByIds(
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
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.deleteHealthElementsByIds(
        entityIds,
      )
    }
  }

  public fun purgeHealthElementById(
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
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.purgeHealthElementById(
        id,
        rev,
      )
    }
  }

  public fun deleteHealthElement(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthElementString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(HealthElement::class),
      healthElementString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.deleteHealthElement(
        healthElement,
      )
    }
  }

  public fun deleteHealthElements(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthElementsString: String,
  ) {
    val healthElements = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(HealthElement::class)),
      healthElementsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.deleteHealthElements(
        healthElements,
      )
    }
  }

  public fun purgeHealthElement(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthElementString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(HealthElement::class),
      healthElementString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.purgeHealthElement(
        healthElement,
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
    healthElementString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val healthElement = fullLanguageInteropJson.decodeFromString(
      DecryptedHealthElement.serializer(),
      healthElementString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      HealthElementShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.shareWith(
        delegateId,
        healthElement,
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
    healthElementString: String,
    delegatesString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      DecryptedHealthElement.serializer(),
      healthElementString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), HealthElementShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.shareWithMany(
        healthElement,
        delegates,
      )
    }
  }

  public fun filterHealthElementsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalSdk>(sdkId).healthElement.filterHealthElementsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedHealthElement.serializer()
      ))
    }
  }

  public fun filterHealthElementsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalSdk>(sdkId).healthElement.filterHealthElementsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedHealthElement.serializer()
      ))
    }
  }

  public fun undeleteHealthElementById(
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
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.undeleteHealthElementById(
        id,
        rev,
      )
    }
  }

  public fun undeleteHealthElement(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthElementString: String,
  ) {
    val healthElement = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(HealthElement::class),
      healthElementString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.undeleteHealthElement(
        healthElement,
      )
    }
  }

  public fun modifyHealthElement(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      DecryptedHealthElement.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.modifyHealthElement(
        entity,
      )
    }
  }

  public fun modifyHealthElements(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entitiesString: String,
  ) {
    val entities = fullLanguageInteropJson.decodeFromString(
      ListSerializer(DecryptedHealthElement.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedHealthElement.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.modifyHealthElements(
        entities,
      )
    }
  }

  public fun getHealthElement(
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
      DecryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.getHealthElement(
        entityId,
      )
    }
  }

  public fun getHealthElements(
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
      ListSerializer(DecryptedHealthElement.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthElement.getHealthElements(
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
      FilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).healthElement.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedHealthElement.serializer()
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
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      healthElementString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val healthElement = fullLanguageInteropJson.decodeFromString(
        EncryptedHealthElement.serializer(),
        healthElementString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        HealthElementShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedHealthElement.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.shareWith(
          delegateId,
          healthElement,
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
      healthElementString: String,
      delegatesString: String,
    ) {
      val healthElement = fullLanguageInteropJson.decodeFromString(
        EncryptedHealthElement.serializer(),
        healthElementString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), HealthElementShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedHealthElement.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.shareWithMany(
          healthElement,
          delegates,
        )
      }
    }

    public fun filterHealthElementsBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      filterString: String,
    ) {
      val filter = fullLanguageInteropJson.decodeFromString(
        FilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.filterHealthElementsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedHealthElement.serializer()
        ))
      }
    }

    public fun filterHealthElementsBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      filterString: String,
    ) {
      val filter = fullLanguageInteropJson.decodeFromString(
        SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.filterHealthElementsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedHealthElement.serializer()
        ))
      }
    }

    public fun undeleteHealthElementById(
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
        EncryptedHealthElement.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.undeleteHealthElementById(
          id,
          rev,
        )
      }
    }

    public fun undeleteHealthElement(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      healthElementString: String,
    ) {
      val healthElement = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(HealthElement::class),
        healthElementString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedHealthElement.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.undeleteHealthElement(
          healthElement,
        )
      }
    }

    public fun modifyHealthElement(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        EncryptedHealthElement.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedHealthElement.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.modifyHealthElement(
          entity,
        )
      }
    }

    public fun modifyHealthElements(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entitiesString: String,
    ) {
      val entities = fullLanguageInteropJson.decodeFromString(
        ListSerializer(EncryptedHealthElement.serializer()),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedHealthElement.serializer())) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.modifyHealthElements(
          entities,
        )
      }
    }

    public fun getHealthElement(
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
        EncryptedHealthElement.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.getHealthElement(
          entityId,
        )
      }
    }

    public fun getHealthElements(
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
        ListSerializer(EncryptedHealthElement.serializer())) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.encrypted.getHealthElements(
          entityIds,
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
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      healthElementString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val healthElement = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(HealthElement::class),
        healthElementString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        HealthElementShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(HealthElement::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.shareWith(
          delegateId,
          healthElement,
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
      healthElementString: String,
      delegatesString: String,
    ) {
      val healthElement = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(HealthElement::class),
        healthElementString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), HealthElementShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(HealthElement::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.shareWithMany(
          healthElement,
          delegates,
        )
      }
    }

    public fun filterHealthElementsBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      filterString: String,
    ) {
      val filter = fullLanguageInteropJson.decodeFromString(
        FilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.filterHealthElementsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(HealthElement::class)
        ))
      }
    }

    public fun filterHealthElementsBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      filterString: String,
    ) {
      val filter = fullLanguageInteropJson.decodeFromString(
        SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.filterHealthElementsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(HealthElement::class)
        ))
      }
    }

    public fun undeleteHealthElementById(
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
        PolymorphicSerializer(HealthElement::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.undeleteHealthElementById(
          id,
          rev,
        )
      }
    }

    public fun undeleteHealthElement(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      healthElementString: String,
    ) {
      val healthElement = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(HealthElement::class),
        healthElementString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(HealthElement::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.undeleteHealthElement(
          healthElement,
        )
      }
    }

    public fun modifyHealthElement(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(HealthElement::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(HealthElement::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.modifyHealthElement(
          entity,
        )
      }
    }

    public fun modifyHealthElements(
      dartResultCallback: (
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entitiesString: String,
    ) {
      val entities = fullLanguageInteropJson.decodeFromString(
        ListSerializer(PolymorphicSerializer(HealthElement::class)),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(HealthElement::class))) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.modifyHealthElements(
          entities,
        )
      }
    }

    public fun getHealthElement(
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
        PolymorphicSerializer(HealthElement::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.getHealthElement(
          entityId,
        )
      }
    }

    public fun getHealthElements(
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
        ListSerializer(PolymorphicSerializer(HealthElement::class))) {
        NativeReferences.get<CardinalSdk>(sdkId).healthElement.tryAndRecover.getHealthElements(
          entityIds,
        )
      }
    }
  }
}
