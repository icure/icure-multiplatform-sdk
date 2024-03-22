package com.icure.sdk.utils

import com.icure.sdk.model.embed.form.template.CheckBox
import com.icure.sdk.model.embed.form.template.DatePicker
import com.icure.sdk.model.embed.form.template.DateTimePicker
import com.icure.sdk.model.embed.form.template.DropdownField
import com.icure.sdk.model.embed.form.template.Group
import com.icure.sdk.model.embed.form.template.MeasureField
import com.icure.sdk.model.embed.form.template.MultipleChoice
import com.icure.sdk.model.embed.form.template.NumberField
import com.icure.sdk.model.embed.form.template.RadioButton
import com.icure.sdk.model.embed.form.template.StructureElement
import com.icure.sdk.model.embed.form.template.TextField
import com.icure.sdk.model.embed.form.template.TimePicker
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object Serialization {

	@OptIn(ExperimentalSerializationApi::class)
	val json = Json {
		encodeDefaults = false
		// TODO this is temporary, as long as I don't have the real models. Later we change
		println("Temporarily we are ignoring unknown keys")
		ignoreUnknownKeys = true
		explicitNulls = false
		serializersModule = ICureSerializerModule
	}

	val lenientJson = Json {
		encodeDefaults = false
		ignoreUnknownKeys = true
		serializersModule = ICureSerializerModule
	}

	private val ICureSerializerModule = SerializersModule {
		polymorphic(StructureElement::class) {
			subclass(TimePicker::class)
			subclass(TextField::class)
			subclass(RadioButton::class)
			subclass(NumberField::class)
			subclass(MultipleChoice::class)
			subclass(MeasureField::class)
			subclass(DropdownField::class)
			subclass(DateTimePicker::class)
			subclass(DatePicker::class)
			subclass(CheckBox::class)
			defaultDeserializer {
				Group.serializer()
			}
		}
	}
}