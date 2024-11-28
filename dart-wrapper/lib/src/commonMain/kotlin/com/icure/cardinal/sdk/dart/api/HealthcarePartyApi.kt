// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.DataOwnerRegistrationSuccess
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.PublicKey
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object HealthcarePartyApi {
  public fun getHealthcareParty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartyIdString: String,
  ) {
    val healthcarePartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      healthcarePartyIdString
    )
    ApiScope.execute(
      dartResultCallback,
      HealthcareParty.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.getHealthcareParty(
        healthcarePartyId,
      )
    }
  }

  public fun createHealthcareParty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    pString: String,
  ) {
    val p = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      pString
    )
    ApiScope.execute(
      dartResultCallback,
      HealthcareParty.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.createHealthcareParty(
        p,
      )
    }
  }

  public fun modifyHealthcarePartyInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    healthcarePartyString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val healthcareParty = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      healthcarePartyString
    )
    ApiScope.execute(
      dartResultCallback,
      HealthcareParty.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.modifyHealthcarePartyInGroup(
        groupId,
        healthcareParty,
      )
    }
  }

  public fun createHealthcarePartyInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    healthcarePartyString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val healthcareParty = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      healthcarePartyString
    )
    ApiScope.execute(
      dartResultCallback,
      HealthcareParty.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.createHealthcarePartyInGroup(
        groupId,
        healthcareParty,
      )
    }
  }

  public fun getCurrentHealthcareParty(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      HealthcareParty.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.getCurrentHealthcareParty()
    }
  }

  public fun listHealthcarePartiesByName(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    nameString: String,
  ) {
    val name = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      nameString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(HealthcareParty.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.listHealthcarePartiesByName(
        name,
      )
    }
  }

  public fun getHealthcareParties(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartyIdsString: String,
  ) {
    val healthcarePartyIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      healthcarePartyIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(HealthcareParty.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.getHealthcareParties(
        healthcarePartyIds,
      )
    }
  }

  public fun listHealthcarePartiesByParentId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    parentIdString: String,
  ) {
    val parentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      parentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(HealthcareParty.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.listHealthcarePartiesByParentId(
        parentId,
      )
    }
  }

  public fun getPublicKey(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartyIdString: String,
  ) {
    val healthcarePartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      healthcarePartyIdString
    )
    ApiScope.execute(
      dartResultCallback,
      PublicKey.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.getPublicKey(
        healthcarePartyId,
      )
    }
  }

  public fun modifyHealthcareParty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartyString: String,
  ) {
    val healthcareParty = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      healthcarePartyString
    )
    ApiScope.execute(
      dartResultCallback,
      HealthcareParty.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.modifyHealthcareParty(
        healthcareParty,
      )
    }
  }

  public fun matchHealthcarePartiesBy(
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
      BaseFilterOptions.serializer(HealthcareParty.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.matchHealthcarePartiesBy(
        filter,
      )
    }
  }

  public fun filterHealthPartiesBy(
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
      BaseFilterOptions.serializer(HealthcareParty.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.filterHealthPartiesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        HealthcareParty.serializer()
      ))
    }
  }

  public fun matchHealthcarePartiesBySorted(
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
      BaseSortableFilterOptions.serializer(HealthcareParty.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.matchHealthcarePartiesBySorted(
        filter,
      )
    }
  }

  public fun filterHealthPartiesBySorted(
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
      BaseSortableFilterOptions.serializer(HealthcareParty.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.filterHealthPartiesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        HealthcareParty.serializer()
      ))
    }
  }

  public fun getHealthcarePartiesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    healthcarePartyIdsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val healthcarePartyIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()).nullable,
      healthcarePartyIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(HealthcareParty.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.getHealthcarePartiesInGroup(
        groupId,
        healthcarePartyIds,
      )
    }
  }

  public fun registerPatient(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    parentHcPartyIdString: String,
    tokenString: String,
    useShortTokenString: String,
    hcpString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val parentHcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      parentHcPartyIdString
    )
    val token = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tokenString
    )
    val useShortToken = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      useShortTokenString
    )
    val hcp = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      hcpString
    )
    ApiScope.execute(
      dartResultCallback,
      DataOwnerRegistrationSuccess.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.registerPatient(
        groupId,
        parentHcPartyId,
        token,
        useShortToken,
        hcp,
      )
    }
  }

  public fun deleteHealthcarePartyById(
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
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.deleteHealthcarePartyById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteHealthcarePartiesByIds(
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
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.deleteHealthcarePartiesByIds(
        entityIds,
      )
    }
  }

  public fun deleteHealthcarePartyInGroupById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    entityIdString: String,
    revString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
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
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.deleteHealthcarePartyInGroupById(
        groupId,
        entityId,
        rev,
      )
    }
  }

  public fun deleteHealthcarePartiesInGroupByIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    entityIdsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(IdWithMandatoryRev.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.deleteHealthcarePartiesInGroupByIds(
        groupId,
        entityIds,
      )
    }
  }

  public fun purgeHealthcarePartyById(
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
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.purgeHealthcarePartyById(
        id,
        rev,
      )
    }
  }

  public fun undeleteHealthcarePartyById(
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
      HealthcareParty.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.undeleteHealthcarePartyById(
        id,
        rev,
      )
    }
  }

  public fun deleteHealthcareParty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartyString: String,
  ) {
    val healthcareParty = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      healthcarePartyString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.deleteHealthcareParty(
        healthcareParty,
      )
    }
  }

  public fun deleteHealthcareParties(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartiesString: String,
  ) {
    val healthcareParties = fullLanguageInteropJson.decodeFromString(
      ListSerializer(HealthcareParty.serializer()),
      healthcarePartiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.deleteHealthcareParties(
        healthcareParties,
      )
    }
  }

  public fun purgeHealthcareParty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartyString: String,
  ) {
    val healthcareParty = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      healthcarePartyString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.purgeHealthcareParty(
        healthcareParty,
      )
    }
  }

  public fun undeleteHealthcareParty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartyString: String,
  ) {
    val healthcareParty = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      healthcarePartyString
    )
    ApiScope.execute(
      dartResultCallback,
      HealthcareParty.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.undeleteHealthcareParty(
        healthcareParty,
      )
    }
  }

  public fun deleteHealthcarePartyInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    hcpString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val hcp = fullLanguageInteropJson.decodeFromString(
      HealthcareParty.serializer(),
      hcpString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.deleteHealthcarePartyInGroup(
        groupId,
        hcp,
      )
    }
  }

  public fun deleteHealthcarePartiesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    healthcarePartiesString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val healthcareParties = fullLanguageInteropJson.decodeFromString(
      ListSerializer(HealthcareParty.serializer()),
      healthcarePartiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.deleteHealthcarePartiesInGroup(
        groupId,
        healthcareParties,
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
      FilterOptions.serializer(HealthcareParty.serializer()),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).healthcareParty.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        HealthcareParty.serializer()
      ))
    }
  }
}
