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
		 * TODO check which entities require polymorphic and which not
		 */
		contextual(AbstractFilter::class) {
			when (val serialName = it.single().descriptor.serialName) {
				"AbstractFilter<Identifiable>", "kotlinx.serialization.Polymorphic<Identifiable>" -> AnyAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<MaintenanceTask>", "AbstractFilter<MaintenanceTask>", "com.icure.sdk.model.MaintenanceTask" -> MaintenanceTaskAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Code>", "AbstractFilter<Code>", "com.icure.sdk.model.Code" -> CodeAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Contact>", "AbstractFilter<Contact>", "com.icure.sdk.model.Contact" -> ContactAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Device>", "AbstractFilter<Device>", "com.icure.sdk.model.Device" -> DeviceAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<HealthcareParty>", "AbstractFilter<HealthcareParty>", "com.icure.sdk.model.HealthcareParty" -> HealthcarePartyAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<HealthElement>", "AbstractFilter<HealthElement>", "com.icure.sdk.model.HealthElement" -> HealthElementAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Invoice>", "AbstractFilter<Invoice>", "com.icure.sdk.model.Invoice" -> InvoiceAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Message>", "AbstractFilter<Message>", "com.icure.sdk.model.Message" -> MessageAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Patient>", "AbstractFilter<Patient>", "com.icure.sdk.model.Patient" -> PatientAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Service>", "AbstractFilter<Service>", "com.icure.sdk.model.Service" -> ServiceAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<Topic>", "AbstractFilter<Topic>", "com.icure.sdk.model.Topic" -> TopicAbstractFilterSerializer
				"kotlinx.serialization.Polymorphic<User>", "AbstractFilter<User>", "com.icure.sdk.model.User" -> UserAbstractFilterSerializer
				else -> throw SerializationException("Unknown serial name $serialName for generic parameter of AbstractFilter")
			}
		}
	}

	@OptIn(ExperimentalSerializationApi::class)
	val json = Json {
		encodeDefaults = false
		explicitNulls = true
		ignoreUnknownKeys = false
		serializersModule = ICureSerializerModule
	}


	@OptIn(ExperimentalSerializationApi::class)
	val fullJson = Json {
		encodeDefaults = true
		explicitNulls = true
		ignoreUnknownKeys = false
		serializersModule = ICureSerializerModule
	}

	@OptIn(ExperimentalSerializationApi::class)
	val lenientJson = Json {
		encodeDefaults = false
		explicitNulls = true
		ignoreUnknownKeys = true
		serializersModule = ICureSerializerModule
	}
}
