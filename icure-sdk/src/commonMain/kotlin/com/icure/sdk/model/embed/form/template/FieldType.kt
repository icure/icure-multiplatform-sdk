package com.icure.sdk.model.embed.form.template

import kotlin.reflect.KClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).

@Serializable
enum class FieldType(
  public val clazz: KClass<Field>,
) {
  @SerialName("clazz")
  Clazz,
  @SerialName("textfield")
  Textfield,
  @SerialName("measure-field")
  MeasureField,
  @SerialName("number-field")
  NumberField,
  @SerialName("date-picker")
  DatePicker,
  @SerialName("time-picker")
  TimePicker,
  @SerialName("date-time-picker")
  DateTimePicker,
  @SerialName("multiple-choice")
  MultipleChoice,
  @SerialName("dropdown")
  Dropdown,
  @SerialName("radio-button")
  RadioButton,
  @SerialName("checkbox")
  Checkbox,
  ;

}