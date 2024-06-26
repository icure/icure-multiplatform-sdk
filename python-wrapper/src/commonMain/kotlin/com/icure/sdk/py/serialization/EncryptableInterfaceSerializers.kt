package com.icure.sdk.py.serialization

import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.Classification
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedAccessLog
import com.icure.sdk.model.DecryptedCalendarItem
import com.icure.sdk.model.DecryptedClassification
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedInvoice
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.DecryptedReceipt
import com.icure.sdk.model.DecryptedTimeTable
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Form
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Receipt
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.Topic
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.reflect.KClass

private const val TYPE_KEY = "type"
private const val ENTITY_KEY = "entity"
internal abstract class AbstractEncryptableSerializer<I : Any, E : I, D : I>(
	private val iClass: KClass<I>,
	private val eClass: KClass<E>,
	private val dClass: KClass<D>,
	private val eSerializer: KSerializer<E>,
	private val dSerializer: KSerializer<D>
) : KSerializer<I> {
	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Encryptable<${iClass.simpleName}>") {
		element<String>(TYPE_KEY)
		element(ENTITY_KEY, eSerializer.descriptor)
	}

	override fun deserialize(decoder: Decoder): I {
		decoder as JsonDecoder
		val obj = decoder.decodeJsonElement().jsonObject
		return when (val typeName = obj.getValue(TYPE_KEY).jsonPrimitive.content) {
			eClass.qualifiedName!! -> decoder.json.decodeFromJsonElement(eSerializer, obj.getValue(ENTITY_KEY))
			dClass.qualifiedName!! -> decoder.json.decodeFromJsonElement(dSerializer, obj.getValue(ENTITY_KEY))
			else -> throw SerializationException("Invalid type for ${iClass.simpleName}: $typeName")
		}
	}

	override fun serialize(encoder: Encoder, value: I) {
		encoder as JsonEncoder
		@Suppress("UNCHECKED_CAST")
		val encodedEntity = when {
			eClass.isInstance(value) -> encoder.json.encodeToJsonElement(eSerializer, value as E)
			dClass.isInstance(value) -> encoder.json.encodeToJsonElement(dSerializer, value as D)
			else -> throw SerializationException("Invalid type for ${iClass.simpleName}: $value")
		}
		encoder.encodeJsonElement(JsonObject(mapOf(
			TYPE_KEY to JsonPrimitive(value::class.qualifiedName!!),
			ENTITY_KEY to encodedEntity
		)))
	}
}

internal object AccessLogSerializer : AbstractEncryptableSerializer<AccessLog, EncryptedAccessLog, DecryptedAccessLog>(
	AccessLog::class,
	EncryptedAccessLog::class,
	DecryptedAccessLog::class,
	EncryptedAccessLog.serializer(),
	DecryptedAccessLog.serializer()
)

internal object CalendarItemSerializer : AbstractEncryptableSerializer<CalendarItem, EncryptedCalendarItem, DecryptedCalendarItem>(
	CalendarItem::class,
	EncryptedCalendarItem::class,
	DecryptedCalendarItem::class,
	EncryptedCalendarItem.serializer(),
	DecryptedCalendarItem.serializer()
)

internal object ClassificationSerializer : AbstractEncryptableSerializer<Classification, EncryptedClassification, DecryptedClassification>(
	Classification::class,
	EncryptedClassification::class,
	DecryptedClassification::class,
	EncryptedClassification.serializer(),
	DecryptedClassification.serializer()
)

internal object ContactSerializer : AbstractEncryptableSerializer<Contact, EncryptedContact, DecryptedContact>(
	Contact::class,
	EncryptedContact::class,
	DecryptedContact::class,
	EncryptedContact.serializer(),
	DecryptedContact.serializer()
)

internal object ServiceSerializer : AbstractEncryptableSerializer<Service, EncryptedService, DecryptedService>(
	Service::class,
	EncryptedService::class,
	DecryptedService::class,
	EncryptedService.serializer(),
	DecryptedService.serializer()
)

internal object DocumentSerializer : AbstractEncryptableSerializer<Document, EncryptedDocument, DecryptedDocument>(
	Document::class,
	EncryptedDocument::class,
	DecryptedDocument::class,
	EncryptedDocument.serializer(),
	DecryptedDocument.serializer()
)

internal object FormSerializer : AbstractEncryptableSerializer<Form, EncryptedForm, DecryptedForm>(
	Form::class,
	EncryptedForm::class,
	DecryptedForm::class,
	EncryptedForm.serializer(),
	DecryptedForm.serializer()
)

internal object HealthElementSerializer : AbstractEncryptableSerializer<HealthElement, EncryptedHealthElement, DecryptedHealthElement>(
	HealthElement::class,
	EncryptedHealthElement::class,
	DecryptedHealthElement::class,
	EncryptedHealthElement.serializer(),
	DecryptedHealthElement.serializer()
)

internal object InvoiceSerializer : AbstractEncryptableSerializer<Invoice, EncryptedInvoice, DecryptedInvoice>(
	Invoice::class,
	EncryptedInvoice::class,
	DecryptedInvoice::class,
	EncryptedInvoice.serializer(),
	DecryptedInvoice.serializer()
)

internal object MaintenanceTaskSerializer : AbstractEncryptableSerializer<MaintenanceTask, EncryptedMaintenanceTask, DecryptedMaintenanceTask>(
	MaintenanceTask::class,
	EncryptedMaintenanceTask::class,
	DecryptedMaintenanceTask::class,
	EncryptedMaintenanceTask.serializer(),
	DecryptedMaintenanceTask.serializer()
)

internal object MessageSerializer : AbstractEncryptableSerializer<Message, EncryptedMessage, DecryptedMessage>(
	Message::class,
	EncryptedMessage::class,
	DecryptedMessage::class,
	EncryptedMessage.serializer(),
	DecryptedMessage.serializer()
)

internal object PatientSerializer : AbstractEncryptableSerializer<Patient, EncryptedPatient, DecryptedPatient>(
	Patient::class,
	EncryptedPatient::class,
	DecryptedPatient::class,
	EncryptedPatient.serializer(),
	DecryptedPatient.serializer()
)

internal object ReceiptSerializer : AbstractEncryptableSerializer<Receipt, EncryptedReceipt, DecryptedReceipt>(
	Receipt::class,
	EncryptedReceipt::class,
	DecryptedReceipt::class,
	EncryptedReceipt.serializer(),
	DecryptedReceipt.serializer()
)

internal object TimeTableSerializer : AbstractEncryptableSerializer<TimeTable, EncryptedTimeTable, DecryptedTimeTable>(
	TimeTable::class,
	EncryptedTimeTable::class,
	DecryptedTimeTable::class,
	EncryptedTimeTable.serializer(),
	DecryptedTimeTable.serializer()
)

internal object TopicSerializer : AbstractEncryptableSerializer<Topic, EncryptedTopic, DecryptedTopic>(
	Topic::class,
	EncryptedTopic::class,
	DecryptedTopic::class,
	EncryptedTopic.serializer(),
	DecryptedTopic.serializer()
)
