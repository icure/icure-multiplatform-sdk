package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.EntityAccessInformationProvider
import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.embed.AccessLevel

/**
 * Implementation of [EntityAccessInformationProvider] that doesn't attempt to de-anonymize any delegation, can be used
 * even with the basic/non-data-owner sdk.
 */
internal abstract class BasicEntityAccessInformationProvider : EntityAccessInformationProvider {
	override suspend fun getDataOwnersWithAccessTo(
		entityGroupId: String?,
		entityWithType: EntityWithTypeInfo<*>
	): EntityAccessInformation {
		val infoFromLegacyDelegations = EntityAccessInformation(
			entityWithType.entity.delegations.keys.associate {
				// Legacy delegations don't support inter-group sharing
				Pair(DataOwnerReferenceInGroup(it, null), AccessLevel.Write)
			},
			false
		)
		val boundGroupId = currentBoundGroupId()
		val infoFromSecureDelegations = EntityAccessInformation(
			EntityAccessInformation.buildPermissionsMap(
				entityWithType.entity.securityMetadata?.secureDelegations?.values?.flatMap { d->
					listOfNotNull(
						d.delegate?.let {
							DataOwnerReferenceInGroup.parse(it, entityGroupId, boundGroupId) to d.permissions
						},
						d.delegator?.let {
							DataOwnerReferenceInGroup.parse(it, entityGroupId, boundGroupId) to d.permissions
						}
					)
				} ?: emptyList()
			),
			entityWithType.entity.securityMetadata?.secureDelegations?.values?.any { v ->
				v.delegate == null || v.delegator == null
			} ?: false
		)
		return infoFromLegacyDelegations.merge(infoFromSecureDelegations)
	}

	/**
	 * On basic SDK this should give the (constant) bound group id
	 * On unbound SDK this should give the group id of the current request
	 */
	abstract suspend fun currentBoundGroupId(): SdkBoundGroup?
}