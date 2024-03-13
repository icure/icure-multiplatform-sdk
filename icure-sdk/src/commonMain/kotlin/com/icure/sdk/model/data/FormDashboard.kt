package com.icure.sdk.model.`data`

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class FormDashboard(
  public val dashboard: String? = null,
  public val dashboardGuid: String? = null,
) : FormItem
