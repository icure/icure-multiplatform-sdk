package com.icure.sdk.websocket

import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import com.icure.sdk.model.filter.message.MessageByHcPartyFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyFilter
import com.icure.sdk.model.filter.topic.TopicByHcPartyFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.test.DataOwnerDetails
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initialiseTestEnvironment
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.stringSpec
import io.kotest.matchers.should
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import java.util.UUID
import kotlin.time.Duration.Companion.seconds

fun <BaseType : Identifiable<String>, MaybeDecryptedType : BaseType> subscribableTests(
	name: String,
	subscribableApi: Subscribable<BaseType, MaybeDecryptedType>,
	createEntity: suspend () -> Any,
	filter: AbstractFilter<BaseType>,
) = stringSpec {
	name should {
		"Should subscribe to $name updates" {
			val completable = CompletableDeferred<Unit>()

			val connection = subscribableApi
				.subscribeToEvents(
					events = setOf(SubscriptionEventType.Create),
					filter = filter,
					onConnected = {
						println("Connected")
						completable.complete(Unit)
					},
				) {
					println(it.id)
				}

			withTimeoutOrNull(5.seconds) {
				completable.await()
				connection.close()

			} ?: fail("Didn't received OPEN event within 5 seconds")
		}

		"Should be able to listen to $name creation updates" {
			val completable = CompletableDeferred<Unit>()

			val connection = subscribableApi
				.subscribeToEvents(
					setOf(SubscriptionEventType.Create),
					filter,
				) {
					println("Received $name creation event for ${it.id}")
					completable.complete(Unit)
				}.also { connection ->
					connection.onReconnected {
						println("Connected")
					}
				}

			createEntity()

			withTimeoutOrNull(5.seconds) {
				completable.await()
				connection.close()
			} ?: fail("Didn't received MESSAGE event within 5 seconds")
		}
	}
}

class SubscriptionsTests : StringSpec(
	{
		runBlocking {
			initialiseTestEnvironment()
			val hcpUser = createHcpUser()

			include(
				subscribableTests(
					name = "HealthElement",
					subscribableApi = hcpUser.api().healthcareElement.encrypted,
					filter = HealthElementByHcPartyFilter(hcpId = hcpUser.dataOwnerId),
					createEntity =  {
						val patient = hcpUser
							.api()
							.patient
							.withEncryptionMetadata(
								DecryptedPatient(id = UUID.randomUUID().toString())
							).let {
								hcpUser.api().patient.createPatient(it)
							}

						val currentUser = hcpUser.api().user.getCurrentUser()

						hcpUser
							.api()
							.healthcareElement
							.withEncryptionMetadata(
								DecryptedHealthElement(id = UUID.randomUUID().toString()),
								patient,
								currentUser
							).let {
								hcpUser
									.api()
									.healthcareElement
									.createHealthcareElement(it)
							}
					}
				),
			)
			include(
				subscribableTests(
					name = "Patient",
					subscribableApi = hcpUser.api().patient.encrypted,
					filter = PatientByHcPartyFilter(healthcarePartyId = hcpUser.dataOwnerId),
					createEntity =  {
						hcpUser
							.api()
							.patient
							.withEncryptionMetadata(
								DecryptedPatient(id = UUID.randomUUID().toString())
							).let {
								hcpUser.api().patient.createPatient(it)
							}
					}
				),
			)
			include(
				subscribableTests(
					name = "Contact",
					subscribableApi = hcpUser.api().contact.encrypted,
					filter = ContactByHcPartyFilter(hcpId = hcpUser.dataOwnerId),
					createEntity =  {
						val patient = hcpUser
							.api()
							.patient
							.withEncryptionMetadata(
								DecryptedPatient(id = UUID.randomUUID().toString())
							).let {
								hcpUser.api().patient.createPatient(it)
							}

						val currentUser = hcpUser.api().user.getCurrentUser()

						hcpUser
							.api()
							.contact
							.withEncryptionMetadata(
								DecryptedContact(id = UUID.randomUUID().toString()),
								patient,
								currentUser

							).let {
								hcpUser.api().contact.createContact(it)
							}
					}
				),
			)

			val identifier = Identifier(UUID.randomUUID().toString())

			include(
				subscribableTests(
					name = "MaintenanceTask",
					subscribableApi = hcpUser.api().maintenanceTask.encrypted,
					filter = MaintenanceTaskByHcPartyAndIdentifiersFilter(healthcarePartyId = hcpUser.dataOwnerId, identifiers = listOf(identifier)),
					createEntity =  {
						val currentUser = hcpUser.api().user.getCurrentUser()

						hcpUser
							.api()
							.maintenanceTask
							.withEncryptionMetadata(
								DecryptedMaintenanceTask(id = UUID.randomUUID().toString(), identifier = listOf(identifier)),
								currentUser
							).let {
								hcpUser.api().maintenanceTask.createMaintenanceTask(it)
							}
					}
				),
			)

			include(
				subscribableTests(
					name = "Message",
					subscribableApi = hcpUser.api().message.encrypted,
					filter = MessageByHcPartyFilter(hcpId = hcpUser.dataOwnerId),
					createEntity =  {
						val patient = hcpUser
							.api()
							.patient
							.withEncryptionMetadata(
								DecryptedPatient(id = UUID.randomUUID().toString())
							).let {
								hcpUser.api().patient.createPatient(it)
							}

						val currentUser = hcpUser.api().user.getCurrentUser()

						hcpUser
							.api()
							.message
							.withEncryptionMetadata(
								DecryptedMessage(id = UUID.randomUUID().toString()),
								patient,
								currentUser
							).let {
								hcpUser.api().message.createMessage(it)
							}
					}
				),
			)

			include(
				subscribableTests(
					name = "Topic",
					subscribableApi = hcpUser.api().topic.encrypted,
					filter = TopicByHcPartyFilter(hcpId = hcpUser.dataOwnerId),
					createEntity =  {
						val patient = hcpUser
							.api()
							.patient
							.withEncryptionMetadata(
								DecryptedPatient(id = UUID.randomUUID().toString())
							).let {
								hcpUser.api().patient.createPatient(it)
							}

						val currentUser = hcpUser.api().user.getCurrentUser()

						hcpUser
							.api()
							.topic
							.withEncryptionMetadata(
								DecryptedTopic(id = UUID.randomUUID().toString()),
								patient,
								currentUser
							).let {
								hcpUser.api().topic.createTopic(it)
							}
					}
				),
			)
		}
	},
)
