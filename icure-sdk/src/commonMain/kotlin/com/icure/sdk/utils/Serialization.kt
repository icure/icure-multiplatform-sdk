package com.icure.sdk.utils

import com.icure.sdk.model.embed.form.template.CheckBox
import com.icure.sdk.model.embed.form.template.DatePicker
import com.icure.sdk.model.embed.form.template.DateTimePicker
import com.icure.sdk.model.embed.form.template.DropdownField
import com.icure.sdk.model.embed.form.template.FieldsGroup
import com.icure.sdk.model.embed.form.template.MeasureField
import com.icure.sdk.model.embed.form.template.MultipleChoice
import com.icure.sdk.model.embed.form.template.NumberField
import com.icure.sdk.model.embed.form.template.RadioButton
import com.icure.sdk.model.embed.form.template.StructureElement
import com.icure.sdk.model.embed.form.template.TextField
import com.icure.sdk.model.embed.form.template.TimePicker
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.serialization.AnyAbstractFilterSerializer
import com.icure.sdk.serialization.CodeAbstractFilterSerializer
import com.icure.sdk.serialization.ContactAbstractFilterSerializer
import com.icure.sdk.serialization.DeviceAbstractFilterSerializer
import com.icure.sdk.serialization.HealthElementAbstractFilterSerializer
import com.icure.sdk.serialization.HealthcarePartyAbstractFilterSerializer
import com.icure.sdk.serialization.InvoiceAbstractFilterSerializer
import com.icure.sdk.serialization.MaintenanceTaskAbstractFilterSerializer
import com.icure.sdk.serialization.MessageAbstractFilterSerializer
import com.icure.sdk.serialization.PatientAbstractFilterSerializer
import com.icure.sdk.serialization.ServiceAbstractFilterSerializer
import com.icure.sdk.serialization.TopicAbstractFilterSerializer
import com.icure.sdk.serialization.UserAbstractFilterSerializer
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
				FieldsGroup.serializer()
			}
		}

		/**
		 * Examples:
		 * kotlinx.serialization.Polymorphic<Identifiable> happens when using a filter<*> inside another filter
		 * AbstractFilter<T> happens when using for example a union filter inside a filter chain
		 * com.icure.sdk.model.T happens when using the filter<T> directly as contextual
		 */
		contextual(AbstractFilter::class) {
			when (val serialName = it.single().descriptor.serialName) {
				"AbstractFilter<MaintenanceTask>", "com.icure.sdk.model.MaintenanceTask" -> MaintenanceTaskAbstractFilterSerializer
				"AbstractFilter<Identifiable>", "kotlinx.serialization.Polymorphic<Identifiable>" -> AnyAbstractFilterSerializer
				"AbstractFilter<Code>", "com.icure.sdk.model.Code" -> CodeAbstractFilterSerializer
				"AbstractFilter<Contact>", "com.icure.sdk.model.Contact" -> ContactAbstractFilterSerializer
				"AbstractFilter<Device>", "com.icure.sdk.model.Device" -> DeviceAbstractFilterSerializer
				"AbstractFilter<HealthcareParty>", "com.icure.sdk.model.HealthcareParty" -> HealthcarePartyAbstractFilterSerializer
				"AbstractFilter<HealthElement>", "com.icure.sdk.model.HealthElement" -> HealthElementAbstractFilterSerializer
				"AbstractFilter<Invoice>", "com.icure.sdk.model.Invoice" -> InvoiceAbstractFilterSerializer
				"AbstractFilter<Message>", "com.icure.sdk.model.Message" -> MessageAbstractFilterSerializer
				"AbstractFilter<Patient>", "com.icure.sdk.model.Patient" -> PatientAbstractFilterSerializer
				"AbstractFilter<Service>", "com.icure.sdk.model.Service" -> ServiceAbstractFilterSerializer
				"AbstractFilter<Topic>", "com.icure.sdk.model.Topic" -> TopicAbstractFilterSerializer
				"AbstractFilter<User>", "com.icure.sdk.model.User" -> UserAbstractFilterSerializer
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
