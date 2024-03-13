package com.icure.sdk.model.gui

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class FormLifecycle() {
  @SerialName("OnCreate")
  OnCreate,
  @SerialName("OnLoad")
  OnLoad,
  @SerialName("OnChange")
  OnChange,
  @SerialName("OnSave")
  OnSave,
  @SerialName("OnDestroy")
  OnDestroy,
  @SerialName("OnLoadPropertiesEditor")
  OnLoadPropertiesEditor,
}
