package com.icure.sdk.websocket

import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.test.DataOwnerDetails
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initialiseTestEnvironment
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.withTimeoutOrNull
import java.util.UUID
import kotlin.time.Duration.Companion.seconds

class BasicWebSocketTest : StringSpec({

	lateinit var  hcpUser: DataOwnerDetails

	beforeAny {
		initialiseTestEnvironment()
		hcpUser = createHcpUser()
	}

	"Should subscribe to HealthElement updates" {
		val completable = CompletableDeferred<Unit>()

		val connection = hcpUser
			.api()
			.healthElement
			.encrypted
			.subscribeToEvents(
				events = setOf(SubscriptionEventType.Create),
				filter = HealthElementByHcPartyFilter(
					hcpId = hcpUser.dataOwnerId,
				),
				onConnected = {
					println("Connected")
					completable.complete(Unit)
				}
			) {
				println(it.id)
			}

		withTimeoutOrNull(5.seconds) {
			completable.await()
			connection.close()

		} ?: fail("Didn't received OPEN event within 5 seconds")
	}

	"Should be able to listen to HealthElement creation updates" {
		val completable = CompletableDeferred<Unit>()

		val connection = hcpUser
			.api()
			.healthElement
			.encrypted
			.subscribeToEvents(
				setOf(SubscriptionEventType.Create),
				HealthElementByHcPartyFilter(
					hcpId = hcpUser.dataOwnerId,
				),
			) {
				println("Received HealthElement creation event for ${it.id}")
				completable.complete(Unit)
			}.also { connection ->
				connection.onReconnected {
					println("Connected")
				}
			}

		val patient = hcpUser
			.api()
			.patient
			.initialiseEncryptionMetadata(
				DecryptedPatient(id = UUID.randomUUID().toString())
			).let {
				hcpUser.api().patient.encryptAndCreate(it)
			}

		val currentUser = hcpUser.api().user.getCurrentUser()

		hcpUser
			.api()
			.healthElement
			.initialiseEncryptionMetadata(
				DecryptedHealthElement(id = UUID.randomUUID().toString()),
				patient!!,
				currentUser
			).let {
				hcpUser
					.api()
					.healthElement
					.createHealthcareElement(it)
				println("Created HealthElement")
			}

		withTimeoutOrNull(5.seconds) {
			completable.await()
			connection.close()
		} ?: fail("Didn't received MESSAGE event within 5 seconds")
	}
})
