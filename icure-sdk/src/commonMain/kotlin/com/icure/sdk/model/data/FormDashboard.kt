package com.icure.sdk.model.`data`

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class FormDashboard(
  public val dashboard: String? = null,
  public val dashboardGuid: String? = null,
) : FormItem, IoSerializable
