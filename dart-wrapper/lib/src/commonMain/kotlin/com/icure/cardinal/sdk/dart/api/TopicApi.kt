// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
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

public object TopicApi {
  public fun createTopic(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      DecryptedTopic.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.createTopic(
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
      DecryptedTopic.serializer().nullable,
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
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.withEncryptionMetadata(
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.getEncryptionKeysOf(
        topic,
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.hasWriteAccess(
        topic,
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.decryptPatientIdOf(
        topic,
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
      PolymorphicSerializer(Topic::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.createDelegationDeAnonymizationMetadata(
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      EncryptedTopic.serializer(),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.decrypt(
        topic,
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      EncryptedTopic.serializer(),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Topic::class)) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.tryDecrypt(
        topic,
      )
    }
  }

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
      FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.matchTopicsBy(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.matchTopicsBySorted(
        filter,
      )
    }
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
      NativeReferences.get<CardinalSdk>(sdkId).topic.deleteTopicById(
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
      NativeReferences.get<CardinalSdk>(sdkId).topic.deleteTopicsByIds(
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
      NativeReferences.get<CardinalSdk>(sdkId).topic.purgeTopicById(
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
      NativeReferences.get<CardinalSdk>(sdkId).topic.deleteTopic(
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
      NativeReferences.get<CardinalSdk>(sdkId).topic.deleteTopics(
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
      NativeReferences.get<CardinalSdk>(sdkId).topic.purgeTopic(
        topic,
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
    topicString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val topic = fullLanguageInteropJson.decodeFromString(
      DecryptedTopic.serializer(),
      topicString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      TopicShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.shareWith(
        delegateId,
        topic,
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
    topicString: String,
    delegatesString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      DecryptedTopic.serializer(),
      topicString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), TopicShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.shareWithMany(
        topic,
        delegates,
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
      FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).topic.filterTopicsBy(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).topic.filterTopicsBySorted(
        filter,
      )
      NativeReferences.create(richResult)}
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
      NativeReferences.get<CardinalSdk>(sdkId).topic.undeleteTopic(
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
      DecryptedTopic.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.modifyTopic(
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
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.undeleteTopicById(
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
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.getTopic(
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
      ListSerializer(DecryptedTopic.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.getTopics(
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
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.addParticipant(
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
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).topic.removeParticipant(
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
      FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).topic.subscribeToEvents(
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
      topicString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val topic = fullLanguageInteropJson.decodeFromString(
        EncryptedTopic.serializer(),
        topicString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        TopicShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.shareWith(
          delegateId,
          topic,
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
      topicString: String,
      delegatesString: String,
    ) {
      val topic = fullLanguageInteropJson.decodeFromString(
        EncryptedTopic.serializer(),
        topicString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), TopicShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.shareWithMany(
          topic,
          delegates,
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
        FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult = NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.filterTopicsBy(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.filterTopicsBySorted(
          filter,
        )
        NativeReferences.create(richResult)}
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
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.undeleteTopic(
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
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.modifyTopic(
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
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.undeleteTopicById(
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
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.getTopic(
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
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.getTopics(
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
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.addParticipant(
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
        NativeReferences.get<CardinalSdk>(sdkId).topic.encrypted.removeParticipant(
          entityId,
          dataOwnerId,
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
      topicString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val topic = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Topic::class),
        topicString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        TopicShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.shareWith(
          delegateId,
          topic,
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
      topicString: String,
      delegatesString: String,
    ) {
      val topic = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Topic::class),
        topicString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), TopicShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.shareWithMany(
          topic,
          delegates,
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
        FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.filterTopicsBy(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.filterTopicsBySorted(
          filter,
        )
        NativeReferences.create(richResult)}
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
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.undeleteTopic(
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
        PolymorphicSerializer(Topic::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.modifyTopic(
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
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.undeleteTopicById(
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
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.getTopic(
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
        ListSerializer(PolymorphicSerializer(Topic::class))) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.getTopics(
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
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.addParticipant(
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
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).topic.tryAndRecover.removeParticipant(
          entityId,
          dataOwnerId,
        )
      }
    }
  }
}
