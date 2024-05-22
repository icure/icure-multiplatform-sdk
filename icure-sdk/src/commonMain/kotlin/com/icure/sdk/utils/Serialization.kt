package com.icure.sdk.utils

import com.icure.sdk.model.Invoice
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
import com.icure.sdk.model.filter.CodeAbstractFilterSerializer
import com.icure.sdk.model.filter.ContactAbstractFilterSerializer
import com.icure.sdk.model.filter.DeviceAbstractFilterSerializer
import com.icure.sdk.model.filter.HealthElementAbstractFilterSerializer
import com.icure.sdk.model.filter.HealthcarePartyAbstractFilterSerializer
import com.icure.sdk.model.filter.InvoiceAbstractFilterSerializer
import com.icure.sdk.model.filter.MaintenanceTaskAbstractFilterSerializer
import com.icure.sdk.model.filter.MessageAbstractFilterSerializer
import com.icure.sdk.model.filter.PatientAbstractFilterSerializer
import com.icure.sdk.model.filter.ServiceAbstractFilterSerializer
import com.icure.sdk.model.filter.TopicAbstractFilterSerializer
import com.icure.sdk.model.filter.UserAbstractFilterSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object Serialization {
	// Note: order matters, serializer module must be defined before the Json configurations
	@OptIn(ExperimentalSerializationApi::class)
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
				"kotlinx.serialization.Polymorphic<MaintenanceTask>" -> MaintenanceTaskAbstractFilterSerializer
				"AbstractFilter<MaintenanceTask>" -> MaintenanceTaskAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Identifiable>" -> AnyAbstractFilterSerializer
				"AbstractFilter<Identifiable>" -> AnyAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Code>" -> CodeAbstractFilterSerializer
				"AbstractFilter<Code>" -> CodeAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Contact>" -> ContactAbstractFilterSerializer
				"AbstractFilter<Contact>" -> ContactAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Device>" -> DeviceAbstractFilterSerializer
				"AbstractFilter<Device>" -> DeviceAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<HealthcareParty>" -> HealthcarePartyAbstractFilterSerializer
				"AbstractFilter<HealthcareParty>" -> HealthcarePartyAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<HealthElement>" -> HealthElementAbstractFilterSerializer
				"AbstractFilter<HealthElement>" -> HealthElementAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Invoice>" -> InvoiceAbstractFilterSerializer
				"AbstractFilter<Invoice>" -> InvoiceAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Message>" -> MessageAbstractFilterSerializer
				"AbstractFilter<Message>" -> MessageAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Patient>" -> PatientAbstractFilterSerializer
				"AbstractFilter<Patient>" -> PatientAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Service>" -> ServiceAbstractFilterSerializer
				"AbstractFilter<Service>" -> ServiceAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Topic>" -> TopicAbstractFilterSerializer
				"AbstractFilter<Topic>" -> TopicAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<User>" -> UserAbstractFilterSerializer
				"AbstractFilter<User>" -> UserAbstractFilterSerializer
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
