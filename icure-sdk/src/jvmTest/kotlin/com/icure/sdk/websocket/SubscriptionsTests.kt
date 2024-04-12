package com.icure.sdk.websocket

import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
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
					println("Received HealthElement creation event for ${it.id}")
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

		lateinit var hcpUser: DataOwnerDetails

		runBlocking {
			initialiseTestEnvironment()
			hcpUser = createHcpUser()

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
								println("Created HealthElement")
							}
					}
				),
			)
		}
	},
)
