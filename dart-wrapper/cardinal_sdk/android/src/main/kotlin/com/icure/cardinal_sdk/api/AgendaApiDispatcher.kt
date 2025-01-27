// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.AgendaApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object AgendaApiDispatcher {
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
    "createAgenda" -> createAgenda(parameters, resultCallback)
    "deleteAgendaById" -> deleteAgendaById(parameters, resultCallback)
    "deleteAgendasByIds" -> deleteAgendasByIds(parameters, resultCallback)
    "purgeAgendaById" -> purgeAgendaById(parameters, resultCallback)
    "undeleteAgendaById" -> undeleteAgendaById(parameters, resultCallback)
    "deleteAgenda" -> deleteAgenda(parameters, resultCallback)
    "deleteAgendas" -> deleteAgendas(parameters, resultCallback)
    "purgeAgenda" -> purgeAgenda(parameters, resultCallback)
    "undeleteAgenda" -> undeleteAgenda(parameters, resultCallback)
    "getAgenda" -> getAgenda(parameters, resultCallback)
    "getAgendas" -> getAgendas(parameters, resultCallback)
    "modifyAgenda" -> modifyAgenda(parameters, resultCallback)
    "matchAgendasBy" -> matchAgendasBy(parameters, resultCallback)
    "matchAgendasBySorted" -> matchAgendasBySorted(parameters, resultCallback)
    "filterAgendasBy" -> filterAgendasBy(parameters, resultCallback)
    "filterAgendasBySorted" -> filterAgendasBySorted(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createAgenda(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.createAgenda(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agendaDto"),
    )
  }

  private fun deleteAgendaById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.deleteAgendaById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteAgendasByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.deleteAgendasByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeAgendaById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.purgeAgendaById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteAgendaById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.undeleteAgendaById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteAgenda(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.deleteAgenda(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agenda"),
    )
  }

  private fun deleteAgendas(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.deleteAgendas(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agendas"),
    )
  }

  private fun purgeAgenda(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.purgeAgenda(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agenda"),
    )
  }

  private fun undeleteAgenda(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.undeleteAgenda(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agenda"),
    )
  }

  private fun getAgenda(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.getAgenda(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agendaId"),
    )
  }

  private fun getAgendas(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.getAgendas(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agendaIds"),
    )
  }

  private fun modifyAgenda(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.modifyAgenda(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agendaDto"),
    )
  }

  private fun matchAgendasBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.matchAgendasBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchAgendasBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.matchAgendasBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterAgendasBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.filterAgendasBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterAgendasBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaApi.filterAgendasBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }
}
