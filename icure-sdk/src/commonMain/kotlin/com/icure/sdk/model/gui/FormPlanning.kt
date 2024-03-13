package com.icure.sdk.model.gui

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class FormPlanning(
  public val planninfForAnyDoctor: Boolean? = null,
  public val planningForDelegate: Boolean? = null,
  public val planningForPatientDoctor: Boolean? = null,
  public val planningForMe: Boolean? = null,
  public val codedDelayInDays: Int? = null,
  public val repetitions: Int? = null,
  public val repetitionsUnit: Int? = null,
  public val descr: String? = null,
)
