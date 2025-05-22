// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object DeviceApi {
  public fun getDevice(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    deviceIdString: String,
  ) {
    val deviceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      deviceIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Device.serializer().nullable) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.getDevice(
        deviceId,
      )
    }
  }

  public fun getDevices(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    deviceIdsString: String,
  ) {
    val deviceIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      deviceIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Device.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.getDevices(
        deviceIds,
      )
    }
  }

  public fun createDevice(
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
      Device.serializer(),
      pString
    )
    ApiScope.execute(
      dartResultCallback,
      Device.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.createDevice(
        p,
      )
    }
  }

  public fun modifyDevice(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    deviceString: String,
  ) {
    val device = fullLanguageInteropJson.decodeFromString(
      Device.serializer(),
      deviceString
    )
    ApiScope.execute(
      dartResultCallback,
      Device.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.modifyDevice(
        device,
      )
    }
  }

  public fun createDevices(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    devicesString: String,
  ) {
    val devices = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Device.serializer()),
      devicesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.createDevices(
        devices,
      )
    }
  }

  public fun modifyDevices(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    devicesString: String,
  ) {
    val devices = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Device.serializer()),
      devicesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.modifyDevices(
        devices,
      )
    }
  }

  public fun filterDevicesBy(
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
      BaseFilterOptions.serializer(Device.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.filterDevicesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        Device.serializer()
      ))
    }
  }

  public fun filterDevicesBySorted(
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
      BaseSortableFilterOptions.serializer(Device.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.filterDevicesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        Device.serializer()
      ))
    }
  }

  public fun matchDevicesBy(
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
      BaseFilterOptions.serializer(Device.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.matchDevicesBy(
        filter,
      )
    }
  }

  public fun matchDevicesBySorted(
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
      BaseSortableFilterOptions.serializer(Device.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.matchDevicesBySorted(
        filter,
      )
    }
  }

  public fun deleteDeviceById(
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.deleteDeviceById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteDevicesByIds(
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
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.deleteDevicesByIds(
        entityIds,
      )
    }
  }

  public fun purgeDeviceById(
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.purgeDeviceById(
        id,
        rev,
      )
    }
  }

  public fun undeleteDeviceById(
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
      Device.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.undeleteDeviceById(
        id,
        rev,
      )
    }
  }

  public fun deleteDevice(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    deviceString: String,
  ) {
    val device = fullLanguageInteropJson.decodeFromString(
      Device.serializer(),
      deviceString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.deleteDevice(
        device,
      )
    }
  }

  public fun deleteDevices(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    devicesString: String,
  ) {
    val devices = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Device.serializer()),
      devicesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.deleteDevices(
        devices,
      )
    }
  }

  public fun purgeDevice(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    deviceString: String,
  ) {
    val device = fullLanguageInteropJson.decodeFromString(
      Device.serializer(),
      deviceString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.purgeDevice(
        device,
      )
    }
  }

  public fun undeleteDevice(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    deviceString: String,
  ) {
    val device = fullLanguageInteropJson.decodeFromString(
      Device.serializer(),
      deviceString
    )
    ApiScope.execute(
      dartResultCallback,
      Device.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.undeleteDevice(
        device,
      )
    }
  }

  public fun getDevicesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    deviceIdsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val deviceIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()).nullable,
      deviceIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Device.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.getDevicesInGroup(
        groupId,
        deviceIds,
      )
    }
  }

  public fun modifyDeviceInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    deviceString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val device = fullLanguageInteropJson.decodeFromString(
      Device.serializer(),
      deviceString
    )
    ApiScope.execute(
      dartResultCallback,
      Device.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.modifyDeviceInGroup(
        groupId,
        device,
      )
    }
  }

  public fun createDeviceInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    deviceString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val device = fullLanguageInteropJson.decodeFromString(
      Device.serializer(),
      deviceString
    )
    ApiScope.execute(
      dartResultCallback,
      Device.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.createDeviceInGroup(
        groupId,
        device,
      )
    }
  }

  public fun deleteDevicesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    deviceIdsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val deviceIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(IdWithRev.serializer()),
      deviceIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.deleteDevicesInGroup(
        groupId,
        deviceIds,
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
      FilterOptions.serializer(Device.serializer()),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).device.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        Device.serializer()
      ))
    }
  }
}
