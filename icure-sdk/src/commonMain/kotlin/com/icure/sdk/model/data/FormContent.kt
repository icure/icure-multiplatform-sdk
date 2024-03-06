package com.icure.sdk.model.`data`

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v1.dto.CodeDto

@Serializable
public class FormContent(
  override val id: String? = null,
  override val entityClass: String? = null,
  override val entityId: String? = null,
  override val label: String? = null,
  override val index: Int? = null,
  override val guid: String? = null,
  override val tags: List<CodeDto>? = null,
  public val formTemplateGuid: String? = null,
  public val dashboardGuid: String? = null,
  public val dataJXPath: String? = null,
  public val descr: String? = null,
  public val isAllowMultiple: Boolean,
  public val isDeleted: Boolean,
  public val items: MutableList<FormItem>,
) : FormItem, DisplayableContent
