package com.icure.cardinal.sdk.dart.options

import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.dart.crypto.CryptoStrategiesBridge
import com.icure.cardinal.sdk.dart.utils.DartCallbackException
import com.icure.cardinal.sdk.dart.utils.DartCallbacksHandler
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.options.EncryptedFieldsConfiguration
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonObject

@Serializable
data class DartSdkOptions(
	val encryptedFields: EncryptedFieldsConfiguration,
	val saltPasswordWithApplicationId: Boolean,
	val useHierarchicalDataOwners: Boolean,
	val createTransferKeys: Boolean,
	val lenientJson: Boolean,
	val cryptoStrategies: DartCryptoStrategiesOptions?,
	val groupSelector: String?
) {
	@OptIn(InternalIcureApi::class)
	fun toMultiplatform(): SdkOptions = SdkOptions(
		encryptedFields = encryptedFields,
		saltPasswordWithApplicationId = saltPasswordWithApplicationId,
		useHierarchicalDataOwners = useHierarchicalDataOwners,
		createTransferKeys = createTransferKeys,
		lenientJson = lenientJson,
		cryptoStrategies = cryptoStrategies?.bridge(),
		groupSelector = groupSelector?.let { groupSelectorCallbackId ->
			{ availableGroups ->
				DartCallbacksHandler.registered.invoke(
					groupSelectorCallbackId,
					JsonObject(mapOf(
						"availableGroups" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
							ListSerializer(UserGroup.serializer()),
							availableGroups
						)
					))
				)
			}
		}
	)

	// Release resources used only during initialization (for example releases group selector but not crypto strategies)
	suspend fun releaseInitializationResources() {
		groupSelector?.also { DartCallbacksHandler.registered.delete(groupSelector) }
	}
}

@Serializable
data class DartCryptoStrategiesOptions(
	val recoverAndVerifySelfHierarchyKeys: String,
	val generateNewKeyForDataOwner: String,
	val verifyDelegatePublicKeys: String,
	val dataOwnerRequiresAnonymousDelegation: String,
	val notifyNewKeyCreated: String,
) {
	fun bridge(): CryptoStrategies = CryptoStrategiesBridge(
		recoverAndVerifySelfHierarchyKeysCallback = recoverAndVerifySelfHierarchyKeys,
		generateNewKeyForDataOwnerCallback = generateNewKeyForDataOwner,
		verifyDelegatePublicKeysCallback = verifyDelegatePublicKeys,
		dataOwnerRequiresAnonymousDelegationCallback = dataOwnerRequiresAnonymousDelegation,
		notifyNewKeyCreatedCallback = notifyNewKeyCreated,
	)

	suspend fun release(exception: Throwable?) {
		if (exception is DartCallbackException) {
			DartCallbacksHandler.registered.preventErrorAutoRemove(recoverAndVerifySelfHierarchyKeys, exception.referenceId)
			DartCallbacksHandler.registered.preventErrorAutoRemove(generateNewKeyForDataOwner, exception.referenceId)
			DartCallbacksHandler.registered.preventErrorAutoRemove(verifyDelegatePublicKeys, exception.referenceId)
			DartCallbacksHandler.registered.preventErrorAutoRemove(dataOwnerRequiresAnonymousDelegation, exception.referenceId)
			DartCallbacksHandler.registered.preventErrorAutoRemove(notifyNewKeyCreated, exception.referenceId)
		}
		DartCallbacksHandler.registered.delete(recoverAndVerifySelfHierarchyKeys)
		DartCallbacksHandler.registered.delete(generateNewKeyForDataOwner)
		DartCallbacksHandler.registered.delete(verifyDelegatePublicKeys)
		DartCallbacksHandler.registered.delete(dataOwnerRequiresAnonymousDelegation)
		DartCallbacksHandler.registered.delete(notifyNewKeyCreated)
	}

	suspend fun markUsed() {
		DartCallbacksHandler.registered.markUsed(recoverAndVerifySelfHierarchyKeys)
		DartCallbacksHandler.registered.markUsed(generateNewKeyForDataOwner)
		DartCallbacksHandler.registered.markUsed(verifyDelegatePublicKeys)
		DartCallbacksHandler.registered.markUsed(dataOwnerRequiresAnonymousDelegation)
		DartCallbacksHandler.registered.markUsed(notifyNewKeyCreated)
	}
}