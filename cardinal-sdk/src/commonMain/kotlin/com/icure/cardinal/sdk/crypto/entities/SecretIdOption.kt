package com.icure.cardinal.sdk.crypto.entities

import kotlinx.serialization.Serializable

/**
 * Configuration for which secret id to use for linking to a owning entity (e.g. which secret id of patient to use
 * when linking a contact to the patient)
 */
@Serializable
sealed interface SecretIdOption {
	/**
	 * This will use any secret id that is not known by any parent hcp of the current data owner. If the api is
	 * initialized in a mode where the parent hcp keys are unused this will just mean "use any available secret id".
	 */
	@Serializable
	data object UseAnyConfidential : SecretIdOption

	/**
	 * This will use any secret id that is known by the topmost ancestor in the current data owner hierarchy. If the api
	 * is initialized in a mode where the parent hcp keys are unused this will just mean "use any available secret id".
	 */
	@Serializable
	data object UseAnySharedWithParent : SecretIdOption

	/**
	 * Specify explicitly which secret ids to use
	 */
	@Serializable
	data class Use(val secretIds: Set<String>) : SecretIdOption
}