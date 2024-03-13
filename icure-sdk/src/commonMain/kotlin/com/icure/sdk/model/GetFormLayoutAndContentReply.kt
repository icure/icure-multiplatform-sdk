package com.icure.sdk.model

import com.icure.sdk.model.`data`.FormContent
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public class GetFormLayoutAndContentReply(
  public val formContent: FormContent? = null,
  public val templates: List<FormTemplate>? = null,
)
