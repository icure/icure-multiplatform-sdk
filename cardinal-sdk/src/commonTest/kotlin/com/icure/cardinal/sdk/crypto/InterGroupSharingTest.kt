package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.superadminAuth
import com.icure.cardinal.sdk.test.uuid
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class InterGroupSharingTest : StringSpec({
	val grandparentGroupId = "grandparent-${uuid()}"
	val parentGroupId = "parent-${uuid()}"
	val childGroupId = "child-${uuid()}"
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
		val groupApi = RawGroupApiImpl(baseUrl, superadminAuth, DefaultRawApiConfig)
		groupApi.createGroup(
			grandparentGroupId,
			name = "grandparent",
			password = uuid(),
			initialisationData = DatabaseInitialisation()
		).successBody().id
		groupApi.createGroup(
			parentGroupId,
			name = "parent",
			password = uuid(),
			initialisationData = DatabaseInitialisation(),
			superGroup = grandparentGroupId
		).successBody().id
		groupApi.createGroup(
			childGroupId,
			name = "child",
			password = uuid(),
			initialisationData = DatabaseInitialisation(),
			superGroup = parentGroupId
		).successBody().id
	}

	suspend fun createDataOwner(
		explicit: Boolean,
		groupId: String,
	): DataOwnerDetails =
		if (explicit) {
			createHcpUser(inGroup = groupId, inheritsPermissions = groupId != childGroupId)
		} else {
			createPatientUser(inGroup = groupId, inheritsPermissions = groupId != childGroupId)
		}

	suspend fun testCreateSharedData(
		explicitDelegator: Boolean,
		delegatorGroupId: String,
		explicitDelegate: Boolean,
		delegateGroupId: String
	) {
		val delegator = createDataOwner(explicitDelegator, delegatorGroupId)
		val delegate = createDataOwner(explicitDelegate, delegateGroupId)
		val delegatorApi = delegator.api(specJob)
		val delegateApi = delegate.api(specJob)
		suspend fun doTest(useFullReferences: Boolean) {
			val basePatient = DecryptedPatient(
				id = uuid(),
				firstName = "Gino",
				lastName = "Pino",
				note = "super secret note in patient"
			)
			val delegateReference = if (useFullReferences) delegate.fullReference else delegate.normalizedReferenceForGroup(delegator.groupId)
			val createdPatient = delegatorApi.patient.createPatient(
				delegatorApi.patient.withEncryptionMetadataForGroup(
					if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null,
					base = basePatient,
					delegates = mapOf(delegateReference to AccessLevel.Write)
				),
				if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null
			)
			val baseHe = DecryptedHealthElement(
				id = uuid(),
				descr = "super secret note in he"
			)
			delegatorApi.healthElement.createHealthElement(
				delegatorApi.healthElement.withEncryptionMetadataForGroup(
					if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null,
					base = baseHe,
					patient = createdPatient,
					delegates = mapOf(delegateReference to AccessLevel.Write)
				),
				if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null
			)
			delegateApi.crypto.forceReload()
			delegateApi.patient.getPatient(
				basePatient.id,
				groupId = if (useFullReferences || delegate.groupId != childGroupId) childGroupId else null
			).note shouldBe basePatient.note
			delegateApi.healthElement.getHealthElement(
				baseHe.id,
				groupId = if (useFullReferences || delegate.groupId != childGroupId) childGroupId else null
			).descr shouldBe baseHe.descr
			delegatorApi.patient.getPatient(
				basePatient.id,
				groupId = if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null
			).note shouldBe basePatient.note
			delegatorApi.healthElement.getHealthElement(
				baseHe.id,
				groupId = if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null
			).descr shouldBe baseHe.descr
		}
		doTest(true)
		doTest(false)
	}

	suspend fun testShareExistingData(
		explicitDelegator: Boolean,
		delegatorGroupId: String,
		explicitDelegate: Boolean,
		delegateGroupId: String
	) {
		val delegator = createDataOwner(explicitDelegator, delegatorGroupId)
		val delegate = createDataOwner(explicitDelegate, delegateGroupId)
		val delegatorApi = delegator.api(specJob)
		val delegateApi = delegate.api(specJob)
		suspend fun doTest(useFullReferences: Boolean) {
			val basePatient = DecryptedPatient(
				id = uuid(),
				firstName = "Gino",
				lastName = "Pino",
				note = "super secret note in patient"
			)
			val delegateReference = if (useFullReferences) delegate.fullReference else delegate.normalizedReferenceForGroup(delegator.groupId)
			val patient = delegatorApi.patient.createPatient(
				delegatorApi.patient.withEncryptionMetadataForGroup(
					if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null,
					basePatient
				),
				if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null
			).shouldNotBeNull()
			val sfk = delegatorApi.patient.getSecretIdsOf(patient, childGroupId).also { it shouldHaveSize 1 }
			val baseHe = DecryptedHealthElement(
				id = uuid(),
				descr = "super secret note in he"
			)
			val he = delegatorApi.healthElement.createHealthElement(
				delegatorApi.healthElement.withEncryptionMetadataForGroup(
					entityGroupId = if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null,
					base = baseHe,
					user = delegatorApi.user.getCurrentUser(),
					patient = patient
				),
				if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null
			).shouldNotBeNull()
			delegatorApi.patient.shareInGroup(
				patient,
				if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null,
				mapOf(delegateReference to PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(sfk, false)))
			).shouldNotBeNull()
			delegatorApi.healthElement.shareInGroup(
				he,
				if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null,
				mapOf(delegateReference to HealthElementShareOptions())
			).shouldNotBeNull()
			delegateApi.crypto.forceReload()
			delegateApi.patient.getPatient(
				patient.id,
				if (useFullReferences || delegate.groupId != childGroupId) childGroupId else null
			)
			delegateApi.healthElement.getHealthElement(
				he.id,
				if (useFullReferences || delegate.groupId != childGroupId) childGroupId else null
			)
			delegatorApi.patient.getPatient(
				patient.id,
				if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null
			)
			delegatorApi.healthElement.getHealthElement(
				he.id,
				if (useFullReferences || delegator.groupId != childGroupId) childGroupId else null
			)
		}
		doTest(true)
		doTest(false)
	}


	listOf(
		Pair(Pair("groupE", childGroupId), Pair("groupE", childGroupId)),
		Pair(Pair("groupE", childGroupId), Pair("groupX", parentGroupId)),
		Pair(Pair("groupX", parentGroupId), Pair("groupE", childGroupId)),
		Pair(Pair("groupX", parentGroupId), Pair("groupX", parentGroupId)),
		Pair(Pair("groupX", parentGroupId), Pair("groupY", grandparentGroupId)),
	).forEach { (delegatorGroupInfo, delegateGroupInfo) ->
		listOf(
			Pair(Pair("explicit", true), Pair("explicit", true)),
			Pair(Pair("explicit", true), Pair("anonymous", false)),
			Pair(Pair("anonymous", false), Pair("explicit", true)),
			Pair(Pair("anonymous", false), Pair("anonymous", false)),
		).forEach { (delegatorType, delegateType) ->
			"Test create shared data ${delegatorGroupInfo.first}/${delegatorType.first} -> ${delegateGroupInfo.first}/${delegateType.first}" {
				testCreateSharedData(
					delegatorType.second,
					delegatorGroupInfo.second,
					delegateType.second,
					delegateGroupInfo.second
				)
			}

			"Test share existing data ${delegatorGroupInfo.first}/${delegatorType.first} -> ${delegateGroupInfo.first}/${delegateType.first}" {
				testShareExistingData(
					delegatorType.second,
					delegatorGroupInfo.second,
					delegateType.second,
					delegateGroupInfo.second
				)
			}
		}
	}
})