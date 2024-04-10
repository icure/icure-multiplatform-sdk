package com.icure.sdk.crypto

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.api.IcureSdk
import com.icure.sdk.api.raw.RawSecureDelegationKeyMapApi
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.test.baseUrl
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.createPatientUser
import com.icure.sdk.test.initialiseTestEnvironment
import com.icure.sdk.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class DelegationsDeAnonymizationTest : StringSpec({
	beforeAny { initialiseTestEnvironment() }

	suspend fun IcureSdk.createSamplePatient() =
		patient.createPatient(
			patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
				),
				user = user.getCurrentUser()
			)
		).shouldNotBeNull()

	"without de-anonymisation metadata the data owners should be able to identify anonymous delegates only if they are part of the delegation with that delegate." {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api() }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api() }
		val (userInfoP1, apiP1) = createPatientUser().let { it to it.api() }
		val (userInfoP2, apiP2) = createPatientUser().let { it to it.api() }
		var entity = apiA.createSamplePatient()
		/*
		 * A->A
		 */
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe false
		}
		/*
		 * A->A  A->B
		 */
		entity = apiA.patient.shareWith(userInfoB.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe false
		}
		/*
		 * A->A  A->B
		 *       A->P1
		 */
		entity = apiA.patient.shareWith(userInfoP1.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		apiP1.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe false
		}
		/*
		 * A->A  A->B  B->P1
		 *       A->P1
		 */
		entity = apiB.patient.shareWith(userInfoP1.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullRead).updatedEntityOrThrow()
		apiP1.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe false
		}
		/*
		 * A->A  A->B   B->P1
		 *       A->P1  P1->P2
		 */
		entity = apiP1.patient.shareWith(userInfoP2.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullRead).updatedEntityOrThrow()
		apiP2.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write,
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write,
				userInfoP2.dataOwnerId to AccessLevel.Read
			)
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiP2.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read, // P2 is only aware of the P1->P2 delegation
				userInfoP2.dataOwnerId to AccessLevel.Read
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		/*
		 * A->A  A->B   B->P1
		 *       A->P1  P1->P2
		 *       A->P2
		 */
		entity = apiA.patient.shareWith(userInfoP2.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		apiP2.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write,
				userInfoP2.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write,
				userInfoP2.dataOwnerId to AccessLevel.Read
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP2.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read, // P2 is only aware of the P1->P2 delegation
				userInfoP2.dataOwnerId to AccessLevel.Write
			)
			hasUnknownAnonymousDataOwners shouldBe true
		}
	}

	"Even without de-anonymization metadata the data owners should be able to identify anonymous delegates if their parent is part of the delegation with that delegate." {
		val (parentUserInfo, parentApi) = createHcpUser().let { it to it.api() }
		val (_, childApi) = createHcpUser(parentUserInfo).let { it to it.api() }
		val (patientInfo, patientApi) = createPatientUser().let { it to it.api() }
		var entity = parentApi.createSamplePatient()
		entity = parentApi.patient.shareWith(patientInfo.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		patientApi.crypto.forceReload()
		val expectedAccessInfo = EntityAccessInformation(
			permissionsByDataOwnerId = mapOf(
				// No child user: has no direct access, only access through parent delegation
				parentUserInfo.dataOwnerId to AccessLevel.Write,
				patientInfo.dataOwnerId to AccessLevel.Write
			),
			hasUnknownAnonymousDataOwners = false
		)
		childApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccessInfo
		parentApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccessInfo
		patientApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccessInfo
	}

	"De-anonymization metadata should allow data owners that are not part of a delegation to figure out the members of that delegation." {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api() }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api() }
		val (userInfoP1, apiP1) = createPatientUser().let { it to it.api() }
		val (userInfoP2, apiP2) = createPatientUser().let { it to it.api() }
		var entity = apiA.createSamplePatient()
		entity = apiA.patient.shareWith(userInfoB.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = apiA.patient.shareWith(userInfoP1.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = apiB.patient.shareWith(userInfoP1.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullRead).updatedEntityOrThrow()
		apiP1.crypto.forceReload()
		entity = apiP1.patient.shareWith(userInfoP2.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullRead).updatedEntityOrThrow()
		entity = apiA.patient.shareWith(userInfoP2.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		/*
		 * A->A  A->B    B->?P1
		 *       A->?P1  P1->?P2
		 *       A->?P2
		 */
		apiA.patient.createDelegationsDeAnonymizationMetadata(
			entity,
			setOf(userInfoB.dataOwnerId, userInfoP1.dataOwnerId, userInfoP2.dataOwnerId)
		)
		/*
		 * A can create de-anonymization metadata for his delegations.
		 * A->A  A->B    B->?P1
		 *       A->P1  P1->?P2
		 *       A->P2
		 */
		val expectedAccessByDataOwnerId = mapOf(
			userInfoA.dataOwnerId to AccessLevel.Write,
			userInfoB.dataOwnerId to AccessLevel.Write,
			userInfoP1.dataOwnerId to AccessLevel.Write,
			userInfoP2.dataOwnerId to AccessLevel.Write
		)
		apiP1.crypto.forceReload()
		apiP2.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiP2.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.createDelegationsDeAnonymizationMetadata(
			entity,
			setOf(userInfoA.dataOwnerId, userInfoB.dataOwnerId, userInfoP2.dataOwnerId)
		)
		/* Both delegator and delegate can create de-anonymization metadata for a delegation.
		 * A->A  A->B   B->P1
		 *       A->P1  P1->P2
		 *       A->P2
		 */
		apiP2.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiP2.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
	}

	"Hcp should be able to use de-anonymization metadata for parent" {
		val (grandUserInfo, grandApi) = createHcpUser().let { it to it.api() }
		val (parentUserInfo, parentApi) = createHcpUser(grandUserInfo).let { it to it.api() }
		val (child1UserInfo, child1Api) = createHcpUser(parentUserInfo).let { it to it.api() }
		val (child2UserInfo, child2Api) = createHcpUser(grandUserInfo).let { it to it.api() }
		val (patientInfo, patientApi) = createPatientUser().let { it to it.api() }
		var entity = parentApi.createSamplePatient() // Auto-shared with grandApi, but no de-anonymization metadata
		entity = parentApi.patient.shareWith(patientInfo.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		parentApi.patient.createDelegationsDeAnonymizationMetadata(entity, setOf(grandUserInfo.dataOwnerId))
		patientApi.crypto.forceReload()
		val expectedAccess = EntityAccessInformation(
			mapOf(
				parentUserInfo.dataOwnerId to AccessLevel.Write,
				grandUserInfo.dataOwnerId to AccessLevel.Write,
				patientInfo.dataOwnerId to AccessLevel.Write
			),
			false
		)
		child1Api.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		grandApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		child2Api.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		patientApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		parentApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
	}

	"De-anonymization metadata should encrypt delegator and delegate, and its creation should be optimised" {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api() }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api() }
		val (userInfoP, apiP) = createPatientUser().let { it to it.api() }
		var entity = apiA.createSamplePatient()
		entity = apiA.patient.shareWith(userInfoB.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = apiA.patient.shareWith(userInfoP.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		apiA.patient.createDelegationsDeAnonymizationMetadata(entity, setOf(userInfoB.dataOwnerId, userInfoP.dataOwnerId))
		val secureDelegationKeyMapApi = RawSecureDelegationKeyMapApi(baseUrl, userInfoA.authService(), IcureSdk.sharedHttpClient)
		val secureDelegationKeyMaps = secureDelegationKeyMapApi.findByDelegationKeys(
			ListOfIds(entity.securityMetadata?.secureDelegations?.keys?.map { it.s }.shouldNotBeNull().also { it.shouldNotBeEmpty() }),
			emptyList()
		).successBody()
		secureDelegationKeyMaps.shouldHaveSize(1)
		secureDelegationKeyMaps.single().also {
			it.delegator shouldBe null
			it.delegate shouldBe null
		}
		val delegationKeysToAnonymous = entity.securityMetadata?.secureDelegations?.filter { it.value.delegate == null }.shouldNotBeNull() // would be patient
		delegationKeysToAnonymous.shouldHaveSize(1)
		secureDelegationKeyMaps.single().delegationKey shouldBe delegationKeysToAnonymous.keys.single().s
	}

	"De-anonymization metadata should be usable for different entities of the same type" {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api() }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api() }
		val (userInfoP1, apiP1) = createPatientUser().let { it to it.api() }
		var entity1 = apiA.createSamplePatient()
		entity1 = apiA.patient.shareWith(userInfoB.dataOwnerId, entity1, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity1 = apiA.patient.shareWith(userInfoP1.dataOwnerId, entity1, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		var entity2 = apiA.createSamplePatient()
		entity2 = apiA.patient.shareWith(userInfoB.dataOwnerId, entity2, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity2 = apiA.patient.shareWith(userInfoP1.dataOwnerId, entity2, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		apiA.patient.createDelegationsDeAnonymizationMetadata(entity1, setOf(userInfoB.dataOwnerId, userInfoP1.dataOwnerId))
		val expectedAccess = EntityAccessInformation(
			mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			),
			false
		)
		apiP1.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity1) shouldBe expectedAccess
		apiB.patient.getDataOwnersWithAccessTo(entity1) shouldBe expectedAccess
		apiP1.patient.getDataOwnersWithAccessTo(entity1) shouldBe expectedAccess
		apiA.patient.getDataOwnersWithAccessTo(entity2) shouldBe expectedAccess
		apiB.patient.getDataOwnersWithAccessTo(entity2) shouldBe expectedAccess
		apiP1.patient.getDataOwnersWithAccessTo(entity2) shouldBe expectedAccess
	}

	"De-anonymization metadata optimization: the metadata should not be re-shared with the anonymous delegator/delegate by third parties" {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api() }
		val (userInfoP1, apiP1) = createPatientUser().let { it to it.api() }
		val (userInfoP2, apiP2) = createPatientUser().let { it to it.api() }
		val delegationMapApi = RawSecureDelegationKeyMapApi(baseUrl, userInfoA.authService(), IcureSdk.sharedHttpClient) // Use raw api from A as it does not require access control keys
		var entity = apiP1.createSamplePatient()
		entity = apiP1.patient.shareWith(userInfoA.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = apiP1.patient.shareWith(userInfoP2.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		apiP1.patient.createDelegationsDeAnonymizationMetadata(entity, setOf(userInfoA.dataOwnerId, userInfoP2.dataOwnerId))
		val p1ToP2DelegationKey = entity.securityMetadata?.secureDelegations?.filter { (_ ,v) ->
			v.delegate == null && v.delegator == null && v.parentDelegations.isNotEmpty()
		}.shouldNotBeNull().keys.single().s
		val delegationMapBeforeAttemptedResharingByA = delegationMapApi.findByDelegationKeys(ListOfIds(listOf(p1ToP2DelegationKey)), emptyList()).successBody().single()
		delegationMapBeforeAttemptedResharingByA.securityMetadata?.secureDelegations.shouldNotBeNull().shouldHaveSize(3)
		apiA.patient.createDelegationsDeAnonymizationMetadata(entity, setOf(userInfoP2.dataOwnerId, userInfoP1.dataOwnerId))
		val delegationMapAfterAttemptedResharingByA = delegationMapApi.findByDelegationKeys(ListOfIds(listOf(p1ToP2DelegationKey)), emptyList()).successBody().single()
		delegationMapAfterAttemptedResharingByA.securityMetadata?.secureDelegations.shouldNotBeNull().shouldHaveSize(3)
		delegationMapAfterAttemptedResharingByA.rev shouldBe delegationMapBeforeAttemptedResharingByA.rev
	}

	"De-anonymization metadata should be shared only with selected data owners" {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api() }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api() }
		val (userInfoC, apiC) = createHcpUser().let { it to it.api() }
		val (userInfoP, apiP) = createPatientUser().let { it to it.api() }
		var entity = apiA.createSamplePatient()
		entity = apiA.patient.shareWith(userInfoB.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = apiA.patient.shareWith(userInfoC.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = apiA.patient.shareWith(userInfoP.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		apiA.patient.createDelegationsDeAnonymizationMetadata(entity, setOf(userInfoB.dataOwnerId))
		val expectedFullAccess = EntityAccessInformation(
			mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoC.dataOwnerId to AccessLevel.Write,
				userInfoP.dataOwnerId to AccessLevel.Write
			),
			false
		)
		apiP.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedFullAccess
		apiB.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedFullAccess
		apiP.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedFullAccess
		// Except C does not know about P, because he was not given access to the relevant metadata.
		apiC.patient.getDataOwnersWithAccessTo(entity) shouldBe EntityAccessInformation(
			mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoC.dataOwnerId to AccessLevel.Write
			),
			true
		)
	}

	"A member of a delegation should be able to update the corresponding de-anonymization metadata even if he was not the original creator" {
		val (userInfoA, apiA) = createHcpUser().let{ it to it.api() }
		val (userInfoB, apiB) = createHcpUser().let{ it to it.api() }
		val (userInfoC, apiC) = createHcpUser().let{ it to it.api() }
		val (userInfoP, apiP) = createPatientUser().let{ it to it.api() }
		val (grandUserInfo, parentApi) = createHcpUser().let{ it to it.api() }
		val (parentUserInfo, childApi) = createHcpUser(grandUserInfo).let{ it to it.api() }
		var entity = parentApi.createSamplePatient()
		entity = parentApi.patient.shareWith(userInfoA.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = parentApi.patient.shareWith(userInfoB.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = parentApi.patient.shareWith(userInfoC.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		entity = parentApi.patient.shareWith(userInfoP.dataOwnerId, entity, emptySet(), requestedPermission = RequestedPermission.FullWrite).updatedEntityOrThrow()
		// Child shares de-anonymization info with A
		childApi.patient.createDelegationsDeAnonymizationMetadata(
			entity,
			setOf(userInfoA.dataOwnerId)
		)
		// P shares with B
		apiP.crypto.forceReload()
		apiP.patient.createDelegationsDeAnonymizationMetadata(
			entity,
			setOf(userInfoB.dataOwnerId)
		)
		// Parent shares with C
		parentApi.patient.createDelegationsDeAnonymizationMetadata(
			entity,
			setOf(userInfoC.dataOwnerId)
		)
		val expectedAccess = EntityAccessInformation(
			mapOf(
				grandUserInfo.dataOwnerId to AccessLevel.Write,
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoC.dataOwnerId to AccessLevel.Write,
				userInfoP.dataOwnerId to AccessLevel.Write
			),
			false
		)
		parentApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		childApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		apiA.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		apiB.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		apiC.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		apiP.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		val delegationKeyMapApi = RawSecureDelegationKeyMapApi(baseUrl, userInfoA.authService(), IcureSdk.sharedHttpClient)
		val delegationKeyToP = entity.securityMetadata?.secureDelegations?.filter { it.value.delegate == null }?.keys?.map { it.s }.shouldNotBeNull().single()
		delegationKeyMapApi.findByDelegationKeys(
			ListOfIds(listOf(delegationKeyToP)),
			emptyList()
		).successBody().shouldHaveSize(1)
	}
})