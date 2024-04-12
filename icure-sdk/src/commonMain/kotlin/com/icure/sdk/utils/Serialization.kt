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
import com.icure.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyFilter
import kotlinx.serialization.ExperimentalSerializationApi
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
		polymorphic(AbstractFilter::class) {
			subclass(MaintenanceTaskAfterDateFilter::class)
			subclass(HealthElementByHcPartyFilter::class)
			subclass(PatientByHcPartyFilter::class)
			subclass(ContactByHcPartyFilter::class)
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
