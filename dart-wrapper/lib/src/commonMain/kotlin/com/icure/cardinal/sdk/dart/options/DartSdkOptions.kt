package com.icure.cardinal.sdk.dart.options

import com.icure.cardinal.sdk.options.EncryptedFieldsConfiguration
import com.icure.cardinal.sdk.options.SdkOptions
import kotlinx.serialization.Serializable

@Serializable
data class DartSdkOptions(
	val encryptedFields: EncryptedFieldsConfiguration,
	val saltPasswordWithApplicationId: Boolean,
	val useHierarchicalDataOwners: Boolean,
	val createTransferKeys: Boolean,
	val lenientJson: Boolean,
) {
	fun toMultiplatform(): SdkOptions = SdkOptions(
		encryptedFields = encryptedFields,
		saltPasswordWithApplicationId = saltPasswordWithApplicationId,
		useHierarchicalDataOwners = useHierarchicalDataOwners,
		createTransferKeys = createTransferKeys,
		lenientJson = lenientJson,
	)
}