package com.icure.sdk.utils

import com.icure.sdk.model.base.Identifiable
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
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.Subscription
import com.icure.sdk.serialization.AnyAbstractFilterSerializer
import com.icure.sdk.serialization.CodeAbstractFilterSerializer
import com.icure.sdk.serialization.ContactAbstractFilterSerializer
import com.icure.sdk.serialization.DeviceAbstractFilterSerializer
import com.icure.sdk.serialization.FilterChainSerializer
import com.icure.sdk.serialization.HealthElementAbstractFilterSerializer
import com.icure.sdk.serialization.HealthcarePartyAbstractFilterSerializer
import com.icure.sdk.serialization.InvoiceAbstractFilterSerializer
import com.icure.sdk.serialization.MaintenanceTaskAbstractFilterSerializer
import com.icure.sdk.serialization.MessageAbstractFilterSerializer
import com.icure.sdk.serialization.PatientAbstractFilterSerializer
import com.icure.sdk.serialization.ServiceAbstractFilterSerializer
import com.icure.sdk.serialization.SubscriptionSerializer
import com.icure.sdk.serialization.TopicAbstractFilterSerializer
import com.icure.sdk.serialization.UserAbstractFilterSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

@OptIn(ExperimentalSerializationApi::class)
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
			getContextualAbstractFilter<Identifiable<String>>(it)
		}

		contextual(FilterChain::class) {
			FilterChainSerializer(getContextualAbstractFilter(it))
		}

		contextual(Subscription::class) {
			SubscriptionSerializer(getContextualAbstractFilter(it))
		}
	}

	@Suppress("UNCHECKED_CAST")
	private fun <T : Identifiable<String>> getContextualAbstractFilter(genericSerializers: List<KSerializer<*>>): KSerializer<AbstractFilter<T>> =
		when (val serialName = genericSerializers.single().descriptor.serialName) {
			"AbstractFilter<Identifiable>", "kotlinx.serialization.Polymorphic<Identifiable>" -> AnyAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<MaintenanceTask>", "AbstractFilter<MaintenanceTask>", "com.icure.sdk.model.MaintenanceTask" -> MaintenanceTaskAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<Code>", "AbstractFilter<Code>", "com.icure.sdk.model.Code" -> CodeAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<Contact>", "AbstractFilter<Contact>", "com.icure.sdk.model.Contact" -> ContactAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<Device>", "AbstractFilter<Device>", "com.icure.sdk.model.Device" -> DeviceAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<HealthcareParty>", "AbstractFilter<HealthcareParty>", "com.icure.sdk.model.HealthcareParty" -> HealthcarePartyAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<HealthElement>", "AbstractFilter<HealthElement>", "com.icure.sdk.model.HealthElement" -> HealthElementAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<Invoice>", "AbstractFilter<Invoice>", "com.icure.sdk.model.Invoice" -> InvoiceAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<Message>", "AbstractFilter<Message>", "com.icure.sdk.model.Message" -> MessageAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<Patient>", "AbstractFilter<Patient>", "com.icure.sdk.model.Patient" -> PatientAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<Service>", "AbstractFilter<Service>", "com.icure.sdk.model.Service" -> ServiceAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<Topic>", "AbstractFilter<Topic>", "com.icure.sdk.model.Topic" -> TopicAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			"kotlinx.serialization.Polymorphic<User>", "AbstractFilter<User>", "com.icure.sdk.model.User" -> UserAbstractFilterSerializer as KSerializer<AbstractFilter<T>>
			else -> throw SerializationException("Unknown serial name $serialName for generic parameter of AbstractFilter")
		}

	val json = Json {
		encodeDefaults = false
		explicitNulls = true
		ignoreUnknownKeys = false
		serializersModule = ICureSerializerModule
	}

	val fullJson = Json {
		encodeDefaults = true
		explicitNulls = true
		ignoreUnknownKeys = false
		serializersModule = ICureSerializerModule
	}

	val lenientJson = Json {
		encodeDefaults = false
		explicitNulls = true
		ignoreUnknownKeys = true
		serializersModule = ICureSerializerModule
	}
}
