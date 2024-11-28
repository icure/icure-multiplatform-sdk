// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.ContactBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ContactBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "matchContactsBy" -> matchContactsBy(parameters, resultCallback)
    "matchServicesBy" -> matchServicesBy(parameters, resultCallback)
    "matchContactsBySorted" -> matchContactsBySorted(parameters, resultCallback)
    "matchServicesBySorted" -> matchServicesBySorted(parameters, resultCallback)
    "filterContactsBy" -> filterContactsBy(parameters, resultCallback)
    "filterServicesBy" -> filterServicesBy(parameters, resultCallback)
    "filterContactsBySorted" -> filterContactsBySorted(parameters, resultCallback)
    "filterServicesBySorted" -> filterServicesBySorted(parameters, resultCallback)
    "subscribeToServiceCreateOrUpdateEvents" -> subscribeToServiceCreateOrUpdateEvents(parameters, resultCallback)
    "deleteContactById" -> deleteContactById(parameters, resultCallback)
    "deleteContactsByIds" -> deleteContactsByIds(parameters, resultCallback)
    "purgeContactById" -> purgeContactById(parameters, resultCallback)
    "deleteContact" -> deleteContact(parameters, resultCallback)
    "deleteContacts" -> deleteContacts(parameters, resultCallback)
    "purgeContact" -> purgeContact(parameters, resultCallback)
    "getServiceCodesOccurrences" -> getServiceCodesOccurrences(parameters, resultCallback)
    "undeleteContactById" -> undeleteContactById(parameters, resultCallback)
    "undeleteContact" -> undeleteContact(parameters, resultCallback)
    "modifyContact" -> modifyContact(parameters, resultCallback)
    "modifyContacts" -> modifyContacts(parameters, resultCallback)
    "getContact" -> getContact(parameters, resultCallback)
    "getContacts" -> getContacts(parameters, resultCallback)
    "getService" -> getService(parameters, resultCallback)
    "getServices" -> getServices(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchContactsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.matchContactsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchServicesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.matchServicesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchContactsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.matchContactsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchServicesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.matchServicesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterContactsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.filterContactsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterServicesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.filterServicesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterContactsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.filterContactsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterServicesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.filterServicesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun subscribeToServiceCreateOrUpdateEvents(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.subscribeToServiceCreateOrUpdateEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun deleteContactById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.deleteContactById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteContactsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.deleteContactsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeContactById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.purgeContactById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.deleteContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun deleteContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.deleteContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contacts"),
    )
  }

  private fun purgeContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.purgeContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun getServiceCodesOccurrences(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.getServiceCodesOccurrences(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("codeType"),
      parameters.getValue("minOccurrences"),
    )
  }

  private fun undeleteContactById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.undeleteContactById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.undeleteContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contact"),
    )
  }

  private fun modifyContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.modifyContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.modifyContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun getContact(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.getContact(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getContacts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.getContacts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun getService(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.getService(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("serviceId"),
    )
  }

  private fun getServices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.getServices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactBasicApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }
}
