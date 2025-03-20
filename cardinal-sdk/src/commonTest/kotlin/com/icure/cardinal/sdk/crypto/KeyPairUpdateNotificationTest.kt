package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.filters.MaintenanceTaskFilters
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.forEach
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CoroutineScope

@OptIn(InternalIcureApi::class)
class KeyPairUpdateNotificationTest : StringSpec({
	beforeAny {
		initializeTestEnvironment()
	}

	val note = "Some secret note"
	val testStart = currentEpochMs()

	suspend fun CardinalSdk.createDataAndShareWith(
		owner: DataOwnerDetails
	): String =
		patient.createPatient(
			patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = note,
					firstName = "John",
					lastName = "Doe",
				),
				delegates = mapOf(owner.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull().id

	suspend fun CardinalSdk.verifyDataAccessible(
		dataId: String
	) =
		patient.getPatient(dataId).note shouldBe note

	suspend fun CardinalSdk.getMaintenanceTasks(): List<DecryptedMaintenanceTask> {
		val iterator = maintenanceTask.filterMaintenanceTasksBy(MaintenanceTaskFilters.afterDateForSelf(date = testStart - 1000L))
		val tasks = mutableListOf<DecryptedMaintenanceTask>()
		iterator.forEach {
			tasks.add(it)
		}
		return tasks
	}

	suspend fun DataOwnerDetails.checkReceivedMaintenanceTaskAndGiveAccessBack(
		scope: CoroutineScope,
		expectedNotification: KeyPairUpdateNotification
	) {
		val api = api(scope)
		val tasks = api.getMaintenanceTasks()
		tasks shouldHaveSize 1
		val request = KeyPairUpdateNotification.parseFromMaintenanceTask(tasks.first())
		request shouldBe expectedNotification
		api.cardinalMaintenanceTask.applyKeyPairUpdate(expectedNotification)
	}

	suspend fun DataOwnerDetails.checkNoReceivedMaintenanceTask(
		scope: CoroutineScope
	) {
		api(scope).getMaintenanceTasks().shouldBeEmpty()
	}

	"The api should allow to automatically create any necessary keypair update notifications and to use them to give access back to data" {
		val user = createHcpUser()
		val toNotifyAsDelegator = createHcpUser()
		val toNotifyAsDelegate = createHcpUser()
		val noNotifyBecauseAlreadyGaveAccessBack = createHcpUser()
		val noNotifyBecauseNoExchangeData = createHcpUser()
		val noNotifyBecausePatient = createPatientUser()
		val initialUserApi = user.api(this)
		val accessibleAfterGiveAccessBack = listOf(
			initialUserApi.createDataAndShareWith(toNotifyAsDelegator),
			toNotifyAsDelegate.api(this).createDataAndShareWith(user),
			initialUserApi.createDataAndShareWith(noNotifyBecauseAlreadyGaveAccessBack)
		)
		initialUserApi.createDataAndShareWith(noNotifyBecausePatient)
		val (apiWithLostKey, newKey) = user.apiWithLostKeys(this)
		val newKeySpki = defaultCryptoService.rsa.exportSpkiHex(newKey.public)
		val expectedNotification = KeyPairUpdateNotification(
			newPublicKey = newKeySpki,
			concernedDataOwnerId = user.dataOwnerId
		)
		noNotifyBecauseAlreadyGaveAccessBack.api(this).cardinalMaintenanceTask.applyKeyPairUpdate(expectedNotification)
		apiWithLostKey.cardinalMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(newKeySpki)
		toNotifyAsDelegate.checkReceivedMaintenanceTaskAndGiveAccessBack(this, expectedNotification)
		toNotifyAsDelegator.checkReceivedMaintenanceTaskAndGiveAccessBack(this, expectedNotification)
		noNotifyBecauseNoExchangeData.checkNoReceivedMaintenanceTask(this)
		noNotifyBecausePatient.checkNoReceivedMaintenanceTask(this)
		val apiAfterGiveAccessBack = user.apiWithKeys(this, newKey)
		accessibleAfterGiveAccessBack.forEach { apiAfterGiveAccessBack.verifyDataAccessible(it) }
	}
})