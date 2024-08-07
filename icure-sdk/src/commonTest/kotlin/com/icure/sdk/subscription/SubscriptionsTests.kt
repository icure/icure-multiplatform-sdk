package com.icure.sdk.subscription

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.IcureSdk
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Topic
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import com.icure.sdk.model.filter.message.MessageByHcPartyFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyFilter
import com.icure.sdk.model.filter.topic.TopicByHcPartyFilter
import com.icure.sdk.test.DataOwnerDetails
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initializeTestEnvironment
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.stringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.seconds

interface SubscribableTestContext<BaseType : Identifiable<String>, EntityEventType : BaseType> {
	val name: String
	val subscribableApi: Subscribable<BaseType, EntityEventType>
	suspend fun createEntity(): Identifiable<String>
	val filter: AbstractFilter<BaseType>
}

fun <BaseType : Identifiable<String>, MaybeDecryptedType : BaseType> subscribableTests(
	context: SubscribableTestContext<BaseType, MaybeDecryptedType>
) = with(context) {
	stringSpec {
		name should {
			"Should subscribe to $name updates" {
				val subscription = subscribableApi
					.subscribeToEvents(
						events = setOf(SubscriptionEventType.Create),
						filter = filter
					)

				withTimeoutOrNull(5.seconds) {
					subscription.eventChannel.receive() shouldBe EntitySubscriptionEvent.Connected
				} ?: fail("Didn't received OPEN event within 5 seconds")

				val created = createEntity()

				withTimeoutOrNull(5.seconds) {
					subscription.eventChannel.receive()
						.shouldBeInstanceOf<EntitySubscriptionEvent.EntityNotification<*>>()
						.entity.id shouldBe created.id
				} ?: fail("Didn't received ENTITY event within 5 seconds")
			}
		}
	}
}

class SubscriptionsTests : StringSpec({
	lateinit var hcpUser: DataOwnerDetails
	lateinit var hcpUserApi: IcureSdk

	beforeAny {
		initializeTestEnvironment()
		hcpUser = createHcpUser(
			roles = setOf(
				"PATIENT_USER_MANAGER",
				"BASIC_USER",
				"BASIC_DATA_OWNER",
				"HIERARCHICAL_DATA_OWNER",
				"TOPIC_MANAGER",
				"LEGACY_MESSAGE_MANAGER",
			)
		)
		hcpUserApi = hcpUser.api()
	}
			

	include(
		subscribableTests(
			object : SubscribableTestContext<HealthElement, EncryptedHealthElement> {
				override val name: String = "HealthElement"

				override val subscribableApi: Subscribable<HealthElement, EncryptedHealthElement>
					get() = hcpUserApi.healthElement

				override suspend fun createEntity(): Identifiable<String> {
					val patient = hcpUser
						.api()
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}

					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUser
						.api()
						.healthElement
						.withEncryptionMetadata(
							DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID()),
							patient,
							currentUser
						).let {
							hcpUser
								.api()
								.healthElement
								.createHealthElement(it)
						}
				}

				override val filter: AbstractFilter<HealthElement>
					get() = HealthElementByHcPartyFilter(hcpId = hcpUser.dataOwnerId)
			}
		),
	)
	include(
		subscribableTests(
			object : SubscribableTestContext<Patient, EncryptedPatient> {
				override val name: String = "Patient"
				override val subscribableApi: Subscribable<Patient, EncryptedPatient>
					get() = hcpUserApi.patient

				override suspend fun createEntity(): Identifiable<String> {
					return hcpUser
						.api()
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}
				}

				override val filter: AbstractFilter<Patient>
					get() = PatientByHcPartyFilter(healthcarePartyId = hcpUser.dataOwnerId)
			}
		),
	)
	include(
		subscribableTests(
			object : SubscribableTestContext<Contact, EncryptedContact> {
				override val name = "Contact"
				override val subscribableApi: Subscribable<Contact, EncryptedContact>
					get() = hcpUserApi.contact

				override suspend fun createEntity(): Identifiable<String> {
					val patient = hcpUser
						.api()
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}

					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUser
						.api()
						.contact
						.withEncryptionMetadata(
							DecryptedContact(id = defaultCryptoService.strongRandom.randomUUID()),
							patient,
							currentUser

						).let {
							hcpUserApi.contact.createContact(it)
						}
				}

				override val filter: AbstractFilter<Contact>
					get() = ContactByHcPartyFilter(hcpId = hcpUser.dataOwnerId)
			}
		),
	)

	val identifier = Identifier(defaultCryptoService.strongRandom.randomUUID())

	include(
		subscribableTests(
			object : SubscribableTestContext<MaintenanceTask, EncryptedMaintenanceTask> {
				override val name = "MaintenanceTask"
				override val subscribableApi: Subscribable<MaintenanceTask, EncryptedMaintenanceTask>
					get() = hcpUserApi.maintenanceTask

				override suspend fun createEntity(): Identifiable<String> {
					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUser
						.api()
						.maintenanceTask
						.withEncryptionMetadata(
							DecryptedMaintenanceTask(id = defaultCryptoService.strongRandom.randomUUID(), identifier = listOf(identifier)),
							currentUser
						).let {
							hcpUserApi.maintenanceTask.createMaintenanceTask(it)
						}
				}

				override val filter: AbstractFilter<MaintenanceTask>
					get() = MaintenanceTaskByHcPartyAndIdentifiersFilter(healthcarePartyId = hcpUser.dataOwnerId, identifiers = listOf(identifier))
			}
		),
	)

	include(
		subscribableTests(
			object : SubscribableTestContext<Message, EncryptedMessage> {
				override val name: String = "Message"
				override val subscribableApi: Subscribable<Message, EncryptedMessage>
					get() = hcpUserApi.message

				override suspend fun createEntity(): Identifiable<String> {
					val patient = hcpUser
						.api()
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}

					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUser
						.api()
						.message
						.withEncryptionMetadata(
							DecryptedMessage(id = defaultCryptoService.strongRandom.randomUUID()),
							patient,
							currentUser
						).let {
							hcpUserApi.message.createMessage(it)
						}
				}

				override val filter: AbstractFilter<Message>
					get() = MessageByHcPartyFilter(hcpId = hcpUser.dataOwnerId)
			}
		),
	)

	include(
		subscribableTests(
			object : SubscribableTestContext<Topic, EncryptedTopic> {
				override val name: String = "Topic"

				override val subscribableApi: Subscribable<Topic, EncryptedTopic>
					get() = hcpUserApi.topic

				override suspend fun createEntity(): Identifiable<String> {
					val patient = hcpUser
						.api()
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}

					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUser
						.api()
						.topic
						.withEncryptionMetadata(
							DecryptedTopic(id = defaultCryptoService.strongRandom.randomUUID()),
							patient,
							currentUser
						).let {
							hcpUserApi.topic.createTopic(it)
						}
				}

				override val filter: AbstractFilter<Topic>
					get() = TopicByHcPartyFilter(hcpId = hcpUser.dataOwnerId)
			}
		),
	)
}
)
