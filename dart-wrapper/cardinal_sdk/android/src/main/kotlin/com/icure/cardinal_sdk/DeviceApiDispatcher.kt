package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.DeviceApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object DeviceApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getDevice" -> getDevice(parameters, resultCallback)
    "getDevices" -> getDevices(parameters, resultCallback)
    "createDevice" -> createDevice(parameters, resultCallback)
    "modifyDevice" -> modifyDevice(parameters, resultCallback)
    "createDevices" -> createDevices(parameters, resultCallback)
    "modifyDevices" -> modifyDevices(parameters, resultCallback)
    "filterDevicesBy" -> filterDevicesBy(parameters, resultCallback)
    "filterDevicesBySorted" -> filterDevicesBySorted(parameters, resultCallback)
    "matchDevicesBy" -> matchDevicesBy(parameters, resultCallback)
    "matchDevicesBySorted" -> matchDevicesBySorted(parameters, resultCallback)
    "deleteDeviceById" -> deleteDeviceById(parameters, resultCallback)
    "deleteDevicesByIds" -> deleteDevicesByIds(parameters, resultCallback)
    "purgeDeviceById" -> purgeDeviceById(parameters, resultCallback)
    "undeleteDeviceById" -> undeleteDeviceById(parameters, resultCallback)
    "deleteDevice" -> deleteDevice(parameters, resultCallback)
    "deleteDevices" -> deleteDevices(parameters, resultCallback)
    "purgeDevice" -> purgeDevice(parameters, resultCallback)
    "undeleteDevice" -> undeleteDevice(parameters, resultCallback)
    "getDevicesInGroup" -> getDevicesInGroup(parameters, resultCallback)
    "modifyDeviceInGroup" -> modifyDeviceInGroup(parameters, resultCallback)
    "createDeviceInGroup" -> createDeviceInGroup(parameters, resultCallback)
    "deleteDevicesInGroup" -> deleteDevicesInGroup(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getDevice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.getDevice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("deviceId"),
    )
  }

  private fun getDevices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.getDevices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("deviceIds"),
    )
  }

  private fun createDevice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.createDevice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("p"),
    )
  }

  private fun modifyDevice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.modifyDevice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("device"),
    )
  }

  private fun createDevices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.createDevices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("devices"),
    )
  }

  private fun modifyDevices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.modifyDevices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("devices"),
    )
  }

  private fun filterDevicesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.filterDevicesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterDevicesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.filterDevicesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchDevicesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.matchDevicesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchDevicesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.matchDevicesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteDeviceById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.deleteDeviceById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteDevicesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.deleteDevicesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeDeviceById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.purgeDeviceById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteDeviceById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.undeleteDeviceById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteDevice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.deleteDevice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("device"),
    )
  }

  private fun deleteDevices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.deleteDevices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("devices"),
    )
  }

  private fun purgeDevice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.purgeDevice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("device"),
    )
  }

  private fun undeleteDevice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.undeleteDevice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("device"),
    )
  }

  private fun getDevicesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.getDevicesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("deviceIds"),
    )
  }

  private fun modifyDeviceInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.modifyDeviceInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("device"),
    )
  }

  private fun createDeviceInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.createDeviceInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("device"),
    )
  }

  private fun deleteDevicesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.deleteDevicesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("deviceIds"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DeviceApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }
}
