package com.icure.cardinal.sdk.crypto.entities

/**
 * Configure how secret ids should be shared
 */
sealed interface SecretIdShareOptions {
	/**
	 * Share all available secret ids
	 * @param requireAtLeastOne if true the sharing will fail if the current user can't access any secret id of the entity
	 */
	data class AllAvailable(val requireAtLeastOne: Boolean) : SecretIdShareOptions
	/**
	 * Share exactly the provided secret ids.
	 * In case any of the provided secret ids is not known by the SDK (the current user can't extract that secret id
	 * from the entity):
	 * - If createUnknownSecretIds is false the sharing will fail
	 * - If createUnknownSecretIds is true the method will ignore unknown entries, effectively creating new secret ids.
	 * @param secretIds the secret ids that will be shared.
	 * @param createUnknownSecretIds true if unknown secret ids can be used
	 */
	data class UseExactly(
		val secretIds: Set<String>,
		val createUnknownSecretIds: Boolean
	) : SecretIdShareOptions
}