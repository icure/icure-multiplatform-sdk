package com.icure.sdk.api.impl

import com.icure.kryptom.crypto.StrongRandom
import com.icure.sdk.api.DataOwnerApi
import com.icure.sdk.api.IcureMaintenanceTaskApi
import com.icure.sdk.api.MaintenanceTaskApi
import com.icure.sdk.crypto.BaseExchangeKeysManager
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.PropertyTypeStub
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DecryptedTypedValue
import com.icure.sdk.model.embed.TaskStatus
import com.icure.sdk.model.embed.TypedValuesType
import com.icure.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.getLogger

@OptIn(InternalIcureApi::class)
class IcureMaintenanceTaskApiImpl(
	private val exchangeDataManager: ExchangeDataManager,
	private val baseExchangeKeysManager: BaseExchangeKeysManager,
	private val userKeysManager: UserEncryptionKeysManager,
	private val maintenanceTaskApi: MaintenanceTaskApi,
	private val dataOwnerApi: DataOwnerApi,
	private val strongRandom: StrongRandom
) : IcureMaintenanceTaskApi {
	companion object {
		private val log = getLogger("IcureMaintenanceTaskApi")
	}

	override suspend fun applyKeyPairUpdate(updateRequest: KeyPairUpdateNotification) {
		exchangeDataManager.giveAccessBackTo(
			updateRequest.concernedDataOwnerId,
			updateRequest.newPublicKey
		)
		baseExchangeKeysManager.giveAccessBackTo(
			updateRequest.concernedDataOwnerId,
			updateRequest.newPublicKey,
			userKeysManager.getDecryptionKeys()
		)
	}

	override suspend fun createKeyPairUpdateNotificationsToAllDelegationCounterparts(
		key: SpkiHexString,
		requestToOwnerTypes: Set<DataOwnerType>?
	) {
		val doRequestTo = requestToOwnerTypes ?: when (dataOwnerApi.getCurrentDataOwnerType()) {
			DataOwnerType.Device -> {
				log.w { "Current data owner is a device, no maintenance task for updated keypair will be created by default." }
				emptySet()
			}
			DataOwnerType.Patient -> setOf(DataOwnerType.Patient, DataOwnerType.Hcp)
			DataOwnerType.Hcp -> setOf(DataOwnerType.Hcp)
		}
		if (doRequestTo.isEmpty()) return
		doCreateKeyPairUpdateNotifications(getUpdateRequestCandidatesIdsFor(key, doRequestTo), key)
	}

	override suspend fun createKeyPairUpdateNotificationTo(
		dataOwnerId: String,
		key: SpkiHexString
	) = doCreateKeyPairUpdateNotifications(setOf(dataOwnerId), key)

	// TODO way to lookup key pair update maintenance tasks

	private suspend fun doCreateKeyPairUpdateNotifications(
		to: Set<String>,
		key: SpkiHexString
	) {
		requireNotNull(userKeysManager.getKeyPairForFingerprint(key.fingerprintV2())) {
			"Key ${key.fingerprintV1()} is not available to the current user: no reason to create a keypair notification."
		}
		if (to.isEmpty()) return
		val self = dataOwnerApi.getCurrentDataOwnerId()
		val tasks = to.map { initializeMaintenanceTaskTo(self, it, key) }
		// TODO bulk create
		tasks.forEach { maintenanceTaskApi.createMaintenanceTask(it) }
	}

	private suspend fun initializeMaintenanceTaskTo(
		self: String,
		other: String,
		key: SpkiHexString
	) =
		maintenanceTaskApi.withEncryptionMetadata(
			DecryptedMaintenanceTask(
				id = strongRandom.randomUUID(),
				taskType = KeyPairUpdateNotification.TASK_TYPE,
				status = TaskStatus.Pending,
				properties = setOf(
					DecryptedPropertyStub(
						id = KeyPairUpdateNotification.OWNER_ID_PROPERTY_ID,
						type = PropertyTypeStub(type = TypedValuesType.String),
						typedValue = DecryptedTypedValue(
							type = TypedValuesType.String,
							stringValue = self
						)
					),
					DecryptedPropertyStub(
						id = KeyPairUpdateNotification.OWNER_PUBLIC_KEY_PROPERTY_ID,
						type = PropertyTypeStub(type = TypedValuesType.String),
						typedValue = DecryptedTypedValue(
							type = TypedValuesType.String,
							stringValue = key.s
						)
					)
				)
			),
			null,
			mapOf(other to AccessLevel.Write)
		)

	// All data owners that have something shared with the current data owner and the new key does not provide access to at least one of the existing exchange keys.
	private suspend fun getUpdateRequestCandidatesIdsFor(
		key: SpkiHexString,
		requestToOwnerTypes: Set<DataOwnerType>
	): Set<String> {
		val self = dataOwnerApi.getCurrentDataOwnerId()
		val candidatesForExchangeData = exchangeDataManager.base.raw.getParticipantCounterparts(
			self,
			requestToOwnerTypes.joinToString(","),
			key.fingerprintV2().s
		).successBody().toSet()
		val fingerprintV1 = key.fingerprintV1()
		val exchangeKeysInfo = baseExchangeKeysManager.getAllExchangeKeysWith(self, requestToOwnerTypes)
		val candidatesForExchangeKeys =
			(exchangeKeysInfo.exchangeKeysByDataOwnerTo + exchangeKeysInfo.exchangeKeysToDataOwnerFrom).mapNotNullTo(
				mutableSetOf()
			) { (k, v) ->
				k.takeIf {
					v.any {
						!it.keys.mapNotNullTo(mutableSetOf()) { k -> k.toFingerprintV1OrNull() }.contains(fingerprintV1)
					}
				}
			}
		return candidatesForExchangeData + candidatesForExchangeKeys
	}
}