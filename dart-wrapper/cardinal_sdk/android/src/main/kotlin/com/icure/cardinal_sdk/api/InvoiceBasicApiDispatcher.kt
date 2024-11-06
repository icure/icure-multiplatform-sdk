// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.InvoiceBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object InvoiceBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "deleteInvoice" -> deleteInvoice(parameters, resultCallback)
    "getTarificationsCodesOccurrences" -> getTarificationsCodesOccurrences(parameters, resultCallback)
    "modifyInvoice" -> modifyInvoice(parameters, resultCallback)
    "modifyInvoices" -> modifyInvoices(parameters, resultCallback)
    "getInvoice" -> getInvoice(parameters, resultCallback)
    "getInvoices" -> getInvoices(parameters, resultCallback)
    "reassignInvoice" -> reassignInvoice(parameters, resultCallback)
    "mergeTo" -> mergeTo(parameters, resultCallback)
    "validate" -> validate(parameters, resultCallback)
    "appendCodes" -> appendCodes(parameters, resultCallback)
    "removeCodes" -> removeCodes(parameters, resultCallback)
    "listInvoicesByHcPartyAndGroupId" -> listInvoicesByHcPartyAndGroupId(parameters, resultCallback)
    "listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate" -> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters, resultCallback)
    "listInvoicesByContactIds" -> listInvoicesByContactIds(parameters, resultCallback)
    "listInvoicesByRecipientsIds" -> listInvoicesByRecipientsIds(parameters, resultCallback)
    "listToInsurances" -> listToInsurances(parameters, resultCallback)
    "listToInsurancesUnsent" -> listToInsurancesUnsent(parameters, resultCallback)
    "listToPatients" -> listToPatients(parameters, resultCallback)
    "listToPatientsUnsent" -> listToPatientsUnsent(parameters, resultCallback)
    "listInvoicesByIds" -> listInvoicesByIds(parameters, resultCallback)
    "listInvoicesByHcpartySendingModeStatusDate" -> listInvoicesByHcpartySendingModeStatusDate(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun deleteInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.deleteInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getTarificationsCodesOccurrences(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.getTarificationsCodesOccurrences(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("minOccurrence"),
    )
  }

  private fun modifyInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.modifyInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.modifyInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun getInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.getInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getInvoices(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.getInvoices(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun reassignInvoice(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.reassignInvoice(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoice"),
    )
  }

  private fun mergeTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.mergeTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("ids"),
    )
  }

  private fun validate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.validate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("scheme"),
      parameters.getValue("forcedValue"),
    )
  }

  private fun appendCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.appendCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("type"),
      parameters.getValue("sentMediumType"),
      parameters.getValue("secretFKeys"),
      parameters.getValue("insuranceId"),
      parameters.getValue("invoiceId"),
      parameters.getValue("gracePeriod"),
      parameters.getValue("invoicingCodes"),
    )
  }

  private fun removeCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.removeCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("serviceId"),
      parameters.getValue("secretFKeys"),
      parameters.getValue("tarificationIds"),
    )
  }

  private fun listInvoicesByHcPartyAndGroupId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listInvoicesByHcPartyAndGroupId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("groupId"),
    )
  }

  private
      fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("sentMediumType"),
      parameters.getValue("invoiceType"),
      parameters.getValue("sent"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun listInvoicesByContactIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listInvoicesByContactIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("contactIds"),
    )
  }

  private fun listInvoicesByRecipientsIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listInvoicesByRecipientsIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("recipientsIds"),
    )
  }

  private fun listToInsurances(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listToInsurances(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun listToInsurancesUnsent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listToInsurancesUnsent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun listToPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listToPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
    )
  }

  private fun listToPatientsUnsent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listToPatientsUnsent(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
    )
  }

  private fun listInvoicesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listInvoicesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun listInvoicesByHcpartySendingModeStatusDate(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    InvoiceBasicApi.listInvoicesByHcpartySendingModeStatusDate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("hcPartyId"),
      parameters.getValue("sendingMode"),
      parameters.getValue("status"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }
}
