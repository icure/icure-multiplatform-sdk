package com.icure.sdk.crypto

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.IcureSdk
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initializeTestEnvironment
import com.icure.sdk.utils.RequestStatusException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class HierarchicalDataOwnerEncryptionAndConfidentialityTest : StringSpec({
	beforeAny {
		initializeTestEnvironment()
	}

	"Data shared with a parent hcp should be accessible to the parent and siblings, but not to the grandparent" {
		val grandparent = createHcpUser()
		val parent = createHcpUser(grandparent)
		val hcp = createHcpUser(parent)
		val sibling = createHcpUser(parent)
		val hcpApi = hcp.api()
		val note = "This will be encrypted"
		val patient = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = note
				),
				delegates = mapOf(parent.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		parent.api().patient.getPatient(patient.id).note shouldBe note
		sibling.api().patient.getPatient(patient.id).note shouldBe note
		shouldThrow<RequestStatusException> {
			grandparent.api().patient.getPatient(patient.id)
		}.statusCode shouldBe 403
	}

	"Data shared using non confidential sfk should be findable by siblings. Data shared with confidential sfk should not." {
		val parent = createHcpUser()
		val hcp = createHcpUser(parent)
		val sibling = createHcpUser(parent)
		val hcpApi = hcp.api()
		val patient = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = "This will be encrypted"
				),
				delegates = mapOf(parent.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull().let { hcpApi.patient.initializeConfidentialSecretId(it) }
		val confidentialSecretIds = hcpApi.patient.getConfidentialSecretIdsOf(patient)
		val allSecretIds = hcpApi.patient.getSecretIdsOf(patient)
		allSecretIds shouldHaveSize 2
		confidentialSecretIds shouldHaveSize 1
		allSecretIds shouldContain confidentialSecretIds.single()
		val nonConfidentialNote = "Encrypted - non confidential he"
		val nonConfidentialHe = hcpApi.healthElement.createHealthElement(
			hcpApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = nonConfidentialNote
				),
				patient,
				hcpApi.user.getCurrentUser(),
				mapOf(parent.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		val confidentialNote = "Encrypted - confidential he"
		val confidentialHe = hcpApi.healthElement.createHealthElement(
			hcpApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = confidentialNote
				),
				patient,
				hcpApi.user.getCurrentUser(),
				mapOf(parent.dataOwnerId to AccessLevel.Write),
				SecretIdOption.UseAnyConfidential
			)
		).shouldNotBeNull()

		suspend fun findHealthElementsFor(
			hcpIds: List<String>,
			api: IcureSdk
		): List<DecryptedHealthElement> {
			val hes = mutableListOf<DecryptedHealthElement>()

			hcpIds.forEach { hcpId ->
				val iterator = api.healthElement.findHealthElementsByHcPartyPatient(hcpId, patient)
				while (iterator.hasNext()) {
					val element = iterator.next()
					if (hes.all { it.id != element.id }) {
						hes.add(element)
					}
				}
			}

			return hes
		}



		findHealthElementsFor(listOf(hcp.dataOwnerId, parent.dataOwnerId), hcpApi).also { retrievedHes ->
			retrievedHes shouldHaveSize 2
			retrievedHes.map { it.id } shouldContainExactlyInAnyOrder listOf(nonConfidentialHe.id, confidentialHe.id)
			retrievedHes.single { it.id == nonConfidentialHe.id }.note shouldBe nonConfidentialNote
			retrievedHes.single { it.id == confidentialHe.id }.note shouldBe confidentialNote
		}
		listOf(
			Pair(parent.api(), listOf(parent.dataOwnerId)),
			Pair(sibling.api(), listOf(parent.dataOwnerId, sibling.dataOwnerId))
		).forEach { (relativeApi, ids) ->
			relativeApi.patient.getSecretIdsOf(patient) shouldBe (allSecretIds - confidentialSecretIds)
			findHealthElementsFor(ids, relativeApi).also { retrievedHes ->
				retrievedHes shouldHaveSize 1
				retrievedHes.single().id shouldBe nonConfidentialHe.id
				retrievedHes.single().note shouldBe nonConfidentialNote
			}
			// Entity was still shared, so it can still be retrieved by id (not a real use case, would not make sense to share an entity that is confidential)
			relativeApi.healthElement.getHealthElement(confidentialHe.id).shouldNotBeNull().note shouldBe confidentialNote
		}
	}
})