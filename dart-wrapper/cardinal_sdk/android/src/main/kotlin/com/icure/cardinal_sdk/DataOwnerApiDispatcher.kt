package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.DataOwnerApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object DataOwnerApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getCurrentDataOwner" -> getCurrentDataOwner(parameters, resultCallback)
    "getCurrentDataOwnerStub" -> getCurrentDataOwnerStub(parameters, resultCallback)
    "getCurrentDataOwnerId" -> getCurrentDataOwnerId(parameters, resultCallback)
    "getCurrentDataOwnerHierarchyIds" -> getCurrentDataOwnerHierarchyIds(parameters, resultCallback)
    "getDataOwner" -> getDataOwner(parameters, resultCallback)
    "getCryptoActorStub" -> getCryptoActorStub(parameters, resultCallback)
    "getCurrentDataOwnerHierarchyIdsFrom" -> getCurrentDataOwnerHierarchyIdsFrom(parameters, resultCallback)
    "getCurrentDataOwnerHierarchy" -> getCurrentDataOwnerHierarchy(parameters, resultCallback)
    "modifyDataOwnerStub" -> modifyDataOwnerStub(parameters, resultCallback)
    "getCurrentDataOwnerType" -> getCurrentDataOwnerType(parameters, resultCallback)
    "clearCurrentDataOwnerIdsCache" -> clearCurrentDataOwnerIdsCache(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getCurrentDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getCurrentDataOwner(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getCurrentDataOwnerStub(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getCurrentDataOwnerStub(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getCurrentDataOwnerId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getCurrentDataOwnerId(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getCurrentDataOwnerHierarchyIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getCurrentDataOwnerHierarchyIds(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getDataOwner(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ownerId"),
    )
  }

  private fun getCryptoActorStub(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getCryptoActorStub(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ownerId"),
    )
  }

  private fun getCurrentDataOwnerHierarchyIdsFrom(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getCurrentDataOwnerHierarchyIdsFrom(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("parentId"),
    )
  }

  private fun getCurrentDataOwnerHierarchy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getCurrentDataOwnerHierarchy(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun modifyDataOwnerStub(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.modifyDataOwnerStub(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("cryptoActorStubWithTypeDto"),
    )
  }

  private fun getCurrentDataOwnerType(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.getCurrentDataOwnerType(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun clearCurrentDataOwnerIdsCache(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DataOwnerApi.clearCurrentDataOwnerIdsCache(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }
}
