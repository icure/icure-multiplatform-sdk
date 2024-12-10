// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object ContactBasicApi {
  public fun matchContactsBy(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.matchContactsBy(
        filter,
      )
    }
  }

  public fun matchServicesBy(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.matchServicesBy(
        filter,
      )
    }
  }

  public fun matchContactsBySorted(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.matchContactsBySorted(
        filter,
      )
    }
  }

  public fun matchServicesBySorted(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.matchServicesBySorted(
        filter,
      )
    }
  }

  public fun filterContactsBy(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).contact.filterContactsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedContact.serializer()
      ))
    }
  }

  public fun filterServicesBy(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).contact.filterServicesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedService.serializer()
      ))
    }
  }

  public fun filterContactsBySorted(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).contact.filterContactsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedContact.serializer()
      ))
    }
  }

  public fun filterServicesBySorted(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).contact.filterServicesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedService.serializer()
      ))
    }
  }

  public fun subscribeToServiceCreateOrUpdateEvents(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
    subscriptionConfigString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)),
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
          NativeReferences.get<CardinalBaseApis>(sdkId).contact.subscribeToServiceCreateOrUpdateEvents(
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedService.serializer()
      ))
    }
  }

  public fun deleteContactById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.deleteContactById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteContactsByIds(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.deleteContactsByIds(
        entityIds,
      )
    }
  }

  public fun purgeContactById(
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
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.purgeContactById(
        id,
        rev,
      )
    }
  }

  public fun deleteContact(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.deleteContact(
        contact,
      )
    }
  }

  public fun deleteContacts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactsString: String,
  ) {
    val contacts = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Contact::class)),
      contactsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.deleteContacts(
        contacts,
      )
    }
  }

  public fun purgeContact(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.purgeContact(
        contact,
      )
    }
  }

  public fun getServiceCodesOccurrences(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    codeTypeString: String,
    minOccurrencesString: String,
  ) {
    val codeType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeTypeString
    )
    val minOccurrences = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      minOccurrencesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(LabelledOccurence.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.getServiceCodesOccurrences(
        codeType,
        minOccurrences,
      )
    }
  }

  public fun undeleteContactById(
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
      EncryptedContact.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.undeleteContactById(
        id,
        rev,
      )
    }
  }

  public fun undeleteContact(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedContact.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.undeleteContact(
        contact,
      )
    }
  }

  public fun modifyContact(
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
      EncryptedContact.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedContact.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.modifyContact(
        entity,
      )
    }
  }

  public fun modifyContacts(
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
      ListSerializer(EncryptedContact.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedContact.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.modifyContacts(
        entities,
      )
    }
  }

  public fun getContact(
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
      EncryptedContact.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.getContact(
        entityId,
      )
    }
  }

  public fun getContacts(
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
      ListSerializer(EncryptedContact.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.getContacts(
        entityIds,
      )
    }
  }

  public fun getService(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    serviceIdString: String,
  ) {
    val serviceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      serviceIdString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedService.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.getService(
        serviceId,
      )
    }
  }

  public fun getServices(
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
      ListSerializer(EncryptedService.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).contact.getServices(
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).contact.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedContact.serializer()
      ))
    }
  }
}
