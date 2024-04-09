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
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.AnyAbstractFilterSerializer
import com.icure.sdk.model.filter.MaintenanceTaskAbstractFilterSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object Serialization {
	// Note: order matters, serializer module must be defined before the Json configurations
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

		contextual(AbstractFilter::class) {
			when (val serialName = it.single().descriptor.serialName) {
				"kotlinx.serialization.Polymorphic<MaintenanceTask>" -> MaintenanceTaskAbstractFilterSerializer.also { println("MT1") }
				"AbstractFilter<MaintenanceTask>" -> MaintenanceTaskAbstractFilterSerializer.also { println("MT2") }
				"kotlinx.serialization.Polymorphic<Identifiable>" -> AnyAbstractFilterSerializer.also { println("I1") }
				"AbstractFilter<Identifiable>" -> MaintenanceTaskAbstractFilterSerializer.also { println("I2") }
				"Code" -> TODO()
				else -> throw SerializationException("Unknown serial name $serialName for generic parameter of AbstractFilter")
			}
		}
	}

	@OptIn(ExperimentalSerializationApi::class)
	val json = Json {
		encodeDefaults = false
		explicitNulls = false
		ignoreUnknownKeys = false
		serializersModule = ICureSerializerModule
	}

	@OptIn(ExperimentalSerializationApi::class)
	val lenientJson = Json {
		encodeDefaults = false
		explicitNulls = false
		ignoreUnknownKeys = true
		serializersModule = ICureSerializerModule
	}
}
