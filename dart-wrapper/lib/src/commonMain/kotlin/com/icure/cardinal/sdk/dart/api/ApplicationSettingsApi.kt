// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.ApplicationSettings
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer

@OptIn(InternalIcureApi::class)
public object ApplicationSettingsApi {
  public fun getApplicationSettings(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(ApplicationSettings.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).applicationSettings.getApplicationSettings()
    }
  }

  public fun createApplicationSettings(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    applicationSettingsString: String,
  ) {
    val applicationSettings = fullLanguageInteropJson.decodeFromString(
      ApplicationSettings.serializer(),
      applicationSettingsString
    )
    ApiScope.execute(
      dartResultCallback,
      ApplicationSettings.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).applicationSettings.createApplicationSettings(
        applicationSettings,
      )
    }
  }

  public fun updateApplicationSettings(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    applicationSettingsString: String,
  ) {
    val applicationSettings = fullLanguageInteropJson.decodeFromString(
      ApplicationSettings.serializer(),
      applicationSettingsString
    )
    ApiScope.execute(
      dartResultCallback,
      ApplicationSettings.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).applicationSettings.updateApplicationSettings(
        applicationSettings,
      )
    }
  }
}
