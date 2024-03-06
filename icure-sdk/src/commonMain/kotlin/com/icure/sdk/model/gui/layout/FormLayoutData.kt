package com.icure.sdk.model.gui.layout

import com.icure.sdk.model.embed.Content
import com.icure.sdk.model.gui.Editor
import com.icure.sdk.model.gui.FormDataOption
import com.icure.sdk.model.gui.FormPlanning
import com.icure.sdk.model.gui.Formula
import com.icure.sdk.model.gui.GuiCode
import com.icure.sdk.model.gui.GuiCodeType
import com.icure.sdk.model.gui.Suggest
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public open class FormLayoutData(
  public val isSubForm: Boolean? = null,
  public val isIrrelevant: Boolean? = null,
  public val isDeterminesSscontactName: Boolean? = null,
  public val type: String? = null,
  public val name: String? = null,
  public val sortOrder: Double? = null,
  public val options: Map<String, FormDataOption>? = null,
  public val descr: String? = null,
  public val label: String? = null,
  public val editor: Editor? = null,
  public val defaultValue: List<Content>? = null,
  public val defaultStatus: Int? = null,
  public val suggest: List<Suggest>? = null,
  public val plannings: List<FormPlanning>? = null,
  public val tags: List<GuiCode>? = null,
  public val codes: List<GuiCode>? = null,
  public val codeTypes: List<GuiCodeType>? = null,
  public val formulas: List<Formula>? = null,
) : IoSerializable
