package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.CalendarItemApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CalendarItemApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "createCalendarItem" -> createCalendarItem(parameters, resultCallback)
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptPatientIdOf" -> decryptPatientIdOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "matchCalendarItemsBy" -> matchCalendarItemsBy(parameters, resultCallback)
    "matchCalendarItemsBySorted" -> matchCalendarItemsBySorted(parameters, resultCallback)
    "deleteCalendarItemById" -> deleteCalendarItemById(parameters, resultCallback)
    "deleteCalendarItemsByIds" -> deleteCalendarItemsByIds(parameters, resultCallback)
    "purgeCalendarItemById" -> purgeCalendarItemById(parameters, resultCallback)
    "deleteCalendarItem" -> deleteCalendarItem(parameters, resultCallback)
    "deleteCalendarItems" -> deleteCalendarItems(parameters, resultCallback)
    "purgeCalendarItem" -> purgeCalendarItem(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "linkToPatient" -> linkToPatient(parameters, resultCallback)
    "filterCalendarItemsBy" -> filterCalendarItemsBy(parameters, resultCallback)
    "filterCalendarItemsBySorted" -> filterCalendarItemsBySorted(parameters, resultCallback)
    "undeleteCalendarItemById" -> undeleteCalendarItemById(parameters, resultCallback)
    "undeleteCalendarItem" -> undeleteCalendarItem(parameters, resultCallback)
    "modifyCalendarItem" -> modifyCalendarItem(parameters, resultCallback)
    "getCalendarItem" -> getCalendarItem(parameters, resultCallback)
    "getCalendarItems" -> getCalendarItems(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.linkToPatient" -> encrypted_linkToPatient(parameters, resultCallback)
    "encrypted.filterCalendarItemsBy" -> encrypted_filterCalendarItemsBy(parameters, resultCallback)
    "encrypted.filterCalendarItemsBySorted" -> encrypted_filterCalendarItemsBySorted(parameters, resultCallback)
    "encrypted.undeleteCalendarItemById" -> encrypted_undeleteCalendarItemById(parameters, resultCallback)
    "encrypted.undeleteCalendarItem" -> encrypted_undeleteCalendarItem(parameters, resultCallback)
    "encrypted.modifyCalendarItem" -> encrypted_modifyCalendarItem(parameters, resultCallback)
    "encrypted.getCalendarItem" -> encrypted_getCalendarItem(parameters, resultCallback)
    "encrypted.getCalendarItems" -> encrypted_getCalendarItems(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.linkToPatient" -> tryAndRecover_linkToPatient(parameters, resultCallback)
    "tryAndRecover.filterCalendarItemsBy" -> tryAndRecover_filterCalendarItemsBy(parameters, resultCallback)
    "tryAndRecover.filterCalendarItemsBySorted" -> tryAndRecover_filterCalendarItemsBySorted(parameters, resultCallback)
    "tryAndRecover.undeleteCalendarItemById" -> tryAndRecover_undeleteCalendarItemById(parameters, resultCallback)
    "tryAndRecover.undeleteCalendarItem" -> tryAndRecover_undeleteCalendarItem(parameters, resultCallback)
    "tryAndRecover.modifyCalendarItem" -> tryAndRecover_modifyCalendarItem(parameters, resultCallback)
    "tryAndRecover.getCalendarItem" -> tryAndRecover_getCalendarItem(parameters, resultCallback)
    "tryAndRecover.getCalendarItems" -> tryAndRecover_getCalendarItems(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.createCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.withEncryptionMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("base"),
      parameters.getValue("patient"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
      parameters.getValue("secretId"),
    )
  }

  private fun getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.createDelegationDeAnonymizationMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
      parameters.getValue("delegates"),
    )
  }

  private fun decrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun matchCalendarItemsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.matchCalendarItemsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchCalendarItemsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.matchCalendarItemsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteCalendarItemById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.deleteCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteCalendarItemsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.deleteCalendarItemsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeCalendarItemById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.purgeCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.deleteCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun deleteCalendarItems(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.deleteCalendarItems(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItems"),
    )
  }

  private fun purgeCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.purgeCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("delegates"),
    )
  }

  private fun linkToPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.linkToPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("patient"),
      parameters.getValue("shareLinkWithDelegates"),
    )
  }

  private fun filterCalendarItemsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.filterCalendarItemsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterCalendarItemsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.filterCalendarItemsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun undeleteCalendarItemById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.undeleteCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.undeleteCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun modifyCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.modifyCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.getCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getCalendarItems(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.getCalendarItems(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_linkToPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.linkToPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("patient"),
      parameters.getValue("shareLinkWithDelegates"),
    )
  }

  private fun encrypted_filterCalendarItemsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.filterCalendarItemsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterCalendarItemsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.filterCalendarItemsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_undeleteCalendarItemById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.undeleteCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_undeleteCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.undeleteCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun encrypted_modifyCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.modifyCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_getCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.getCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getCalendarItems(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.encrypted.getCalendarItems(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_linkToPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.linkToPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
      parameters.getValue("patient"),
      parameters.getValue("shareLinkWithDelegates"),
    )
  }

  private fun tryAndRecover_filterCalendarItemsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.filterCalendarItemsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterCalendarItemsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.filterCalendarItemsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_undeleteCalendarItemById(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.undeleteCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_undeleteCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.undeleteCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun tryAndRecover_modifyCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.modifyCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_getCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.getCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getCalendarItems(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemApi.tryAndRecover.getCalendarItems(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }
}
