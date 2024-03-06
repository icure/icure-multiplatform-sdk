package com.icure.sdk.model

import com.icure.sdk.model.`data`.FormContent
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class GetFormLayoutAndContentReply(
  public val formContent: FormContent? = null,
  public val templates: List<FormTemplate>? = null,
) : IoSerializable
