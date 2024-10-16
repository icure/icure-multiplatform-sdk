// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
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

public object TopicBasicApi {
  public fun matchTopicsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.matchTopicsBy(
        filter,
      )
    }
  }

  public fun matchTopicsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.matchTopicsBySorted(
        filter,
      )
    }
  }

  public fun filterTopicsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseSdk>(sdkId).topic.filterTopicsBy(
        filter,
      )
      NativeReferences.create(richResult)}
  }

  public fun filterTopicsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseSdk>(sdkId).topic.filterTopicsBySorted(
        filter,
      )
      NativeReferences.create(richResult)}
  }

  public fun deleteTopicById(
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
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.deleteTopicById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteTopicsByIds(
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
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.deleteTopicsByIds(
        entityIds,
      )
    }
  }

  public fun purgeTopicById(
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
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.purgeTopicById(
        id,
        rev,
      )
    }
  }

  public fun deleteTopic(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.deleteTopic(
        topic,
      )
    }
  }

  public fun deleteTopics(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    topicsString: String,
  ) {
    val topics = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Topic::class)),
      topicsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.deleteTopics(
        topics,
      )
    }
  }

  public fun purgeTopic(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.purgeTopic(
        topic,
      )
    }
  }

  public fun undeleteTopic(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Topic::class)) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.undeleteTopic(
        topic,
      )
    }
  }

  public fun modifyTopic(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      EncryptedTopic.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedTopic.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.modifyTopic(
        entity,
      )
    }
  }

  public fun undeleteTopicById(
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
      EncryptedTopic.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.undeleteTopicById(
        id,
        rev,
      )
    }
  }

  public fun getTopic(
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
      EncryptedTopic.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.getTopic(
        entityId,
      )
    }
  }

  public fun getTopics(
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
      ListSerializer(EncryptedTopic.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.getTopics(
        entityIds,
      )
    }
  }

  public fun addParticipant(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    dataOwnerIdString: String,
    topicRoleString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val topicRole = fullLanguageInteropJson.decodeFromString(
      TopicRole.serializer(),
      topicRoleString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedTopic.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.addParticipant(
        entityId,
        dataOwnerId,
        topicRole,
      )
    }
  }

  public fun removeParticipant(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    dataOwnerIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedTopic.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).topic.removeParticipant(
        entityId,
        dataOwnerId,
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseSdk>(sdkId).topic.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(richResult)}
  }
}
