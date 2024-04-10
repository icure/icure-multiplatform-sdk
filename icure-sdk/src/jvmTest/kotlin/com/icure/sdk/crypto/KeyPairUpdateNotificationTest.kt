@file:OptIn(InternalIcureApi::class)

package com.icure.sdk.crypto

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.api.IcureSdk
import com.icure.sdk.crypto.impl.exportSpkiHex
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.sdk.test.DataOwnerDetails
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.createPatientUser
import com.icure.sdk.test.initialiseTestEnvironment
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.currentEpochMs
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class KeyPairUpdateNotificationTest : StringSpec({
	beforeAny {
		initialiseTestEnvironment()
	}

	val note: String = "Some secret note"
	val testStart = currentEpochMs()

	suspend fun IcureSdk.createDataAndShareWith(
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

	suspend fun IcureSdk.verifyDataAccessible(
		dataId: String
	) =
		patient.getPatient(dataId).note shouldBe note

	suspend fun IcureSdk.getMaintenanceTasks() =
		maintenanceTask.filterMaintenanceTasksBy(
			null,
			100,
			FilterChain(
				filter = MaintenanceTaskAfterDateFilter(
					date = testStart - 1000L
				)
			)
		).rows

	suspend fun DataOwnerDetails.checkReceivedMaintenanceTaskAndGiveAccessBack(
		expectedNotification: KeyPairUpdateNotification
	) {
		val api = api()
		val tasks = api.getMaintenanceTasks()
		tasks shouldHaveSize 1
		val request = KeyPairUpdateNotification.parseFromMaintenanceTask(tasks.first())
		request shouldBe expectedNotification
		api.icureMaintenanceTask.applyKeyPairUpdate(expectedNotification)
	}

	suspend fun DataOwnerDetails.checkNoReceivedMaintenanceTask() {
		api().getMaintenanceTasks().shouldBeEmpty()
	}

	"The api should allow to automatically create any necessary keypair update notifications and to use them to give access back to data" {
		val user = createHcpUser()
		val toNotifyAsDelegator = createHcpUser()
		val toNotifyAsDelegate = createHcpUser()
		val noNotifyBecauseAlreadyGaveAccessBack = createHcpUser()
		val noNotifyBecauseNoExchangeData = createHcpUser()
		val noNotifyBecausePatient = createPatientUser()
		val initialUserApi = user.api()
		val accessibleAfterGiveAccessBack = listOf(
			initialUserApi.createDataAndShareWith(toNotifyAsDelegator),
			toNotifyAsDelegate.api().createDataAndShareWith(user),
			initialUserApi.createDataAndShareWith(noNotifyBecauseAlreadyGaveAccessBack)
		)
		initialUserApi.createDataAndShareWith(noNotifyBecausePatient)
		val (apiWithLostKey, newKey) = user.apiWithLostKeys()
		val newKeySpki = defaultCryptoService.rsa.exportSpkiHex(newKey.public)
		val expectedNotification = KeyPairUpdateNotification(
			newPublicKey = newKeySpki,
			concernedDataOwnerId = user.dataOwnerId
		)
		noNotifyBecauseAlreadyGaveAccessBack.api().icureMaintenanceTask.applyKeyPairUpdate(expectedNotification)
		apiWithLostKey.icureMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(newKeySpki)
		toNotifyAsDelegate.checkReceivedMaintenanceTaskAndGiveAccessBack(expectedNotification)
		toNotifyAsDelegator.checkReceivedMaintenanceTaskAndGiveAccessBack(expectedNotification)
		noNotifyBecauseNoExchangeData.checkNoReceivedMaintenanceTask()
		noNotifyBecausePatient.checkNoReceivedMaintenanceTask()
		val apiAfterGiveAccessBack = user.apiWithKeys(newKey)
		accessibleAfterGiveAccessBack.forEach { apiAfterGiveAccessBack.verifyDataAccessible(it) }
	}
})
