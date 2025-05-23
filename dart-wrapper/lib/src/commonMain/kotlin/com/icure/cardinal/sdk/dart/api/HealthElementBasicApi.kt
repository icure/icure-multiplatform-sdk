// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
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

@OptIn(InternalIcureApi::class)
public object HealthElementBasicApi {
  public fun matchHealthElementsBy(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.matchHealthElementsBy(
        filter,
      )
    }
  }

  public fun matchHealthElementsBySorted(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.matchHealthElementsBySorted(
        filter,
      )
    }
  }

  public fun filterHealthElementsBy(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.filterHealthElementsBy(
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
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.filterHealthElementsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedHealthElement.serializer()
      ))
    }
  }

  public fun deleteHealthElementById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.deleteHealthElementById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.deleteHealthElementsByIds(
        entityIds,
      )
    }
  }

  public fun purgeHealthElementById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.purgeHealthElementById(
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
      StoredDocumentIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.deleteHealthElement(
        healthElement,
      )
    }
  }

  public fun deleteHealthElements(
    dartResultCallback: (
      String?,
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
      ListSerializer(StoredDocumentIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.deleteHealthElements(
        healthElements,
      )
    }
  }

  public fun purgeHealthElement(
    dartResultCallback: (
      String?,
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
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.purgeHealthElement(
        healthElement,
      )
    }
  }

  public fun createHealthElement(
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
      EncryptedHealthElement.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.createHealthElement(
        entity,
      )
    }
  }

  public fun createHealthElements(
    dartResultCallback: (
      String?,
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
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.createHealthElements(
        entities,
      )
    }
  }

  public fun undeleteHealthElementById(
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
      EncryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.undeleteHealthElementById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.undeleteHealthElement(
        healthElement,
      )
    }
  }

  public fun modifyHealthElement(
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
      EncryptedHealthElement.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedHealthElement.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.modifyHealthElement(
        entity,
      )
    }
  }

  public fun modifyHealthElements(
    dartResultCallback: (
      String?,
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
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.modifyHealthElements(
        entities,
      )
    }
  }

  public fun getHealthElement(
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
      EncryptedHealthElement.serializer().nullable) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.getHealthElement(
        entityId,
      )
    }
  }

  public fun getHealthElements(
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
      ListSerializer(String.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedHealthElement.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.getHealthElements(
        entityIds,
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
      BaseFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.subscribeToEvents(
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
  public object inGroup {
    public fun createHealthElement(
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
        GroupScoped.serializer(EncryptedHealthElement.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(EncryptedHealthElement.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.inGroup.createHealthElement(
          entity,
        )
      }
    }

    public fun modifyHealthElement(
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
        GroupScoped.serializer(EncryptedHealthElement.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(EncryptedHealthElement.serializer())) {
        NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.inGroup.modifyHealthElement(
          entity,
        )
      }
    }

    public fun getHealthElement(
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
        GroupScoped.serializer(EncryptedHealthElement.serializer()).nullable) {
        NativeReferences.get<CardinalBaseApis>(sdkId).healthElement.inGroup.getHealthElement(
          groupId,
          entityId,
        )
      }
    }
  }
}
