package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.internal
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class ExchangeDataManagerTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"Exchange data created with different instances of the SDK should be reusable if still verifiable" {
		val hcp = createHcpUser()
		val patient = createPatientUser()
		val createdHcp = hcp.api(specJob).crypto.internal.exchangeDataManager.getOrCreateEncryptionDataTo(null, EntityReferenceInGroup(patient.dataOwnerId, null), false)
		val retrievedHcp = hcp.api(specJob).crypto.internal.exchangeDataManager.getOrCreateEncryptionDataTo(null, EntityReferenceInGroup(patient.dataOwnerId, null), false)
		createdHcp.exchangeData.id shouldBe retrievedHcp.exchangeData.id
		val createdPatient = patient.api(specJob).crypto.internal.exchangeDataManager.getOrCreateEncryptionDataTo(null, EntityReferenceInGroup(hcp.dataOwnerId, null), false)
		val retrievedPatient = patient.api(specJob).crypto.internal.exchangeDataManager.getOrCreateEncryptionDataTo(null, EntityReferenceInGroup(hcp.dataOwnerId, null), false)
		createdPatient.exchangeData.id shouldBe retrievedPatient.exchangeData.id
	}

	"Detailed tests like in typescript SDK" {
		TODO()
	}
})