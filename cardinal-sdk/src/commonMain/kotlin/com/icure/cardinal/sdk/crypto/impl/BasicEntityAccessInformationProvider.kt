package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.EntityAccessInformationProvider
import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.model.embed.AccessLevel

/**
 * Implementation of [EntityAccessInformationProvider] that does not attempt to de-anonymize any delegation, can be used
 * even with the basic/non-data-owner sdk.
 */
internal object BasicEntityAccessInformationProvider : EntityAccessInformationProvider {
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
		val infoFromSecureDelegations = EntityAccessInformation(
			EntityAccessInformation.buildPermissionsMap(
				entityWithType.entity.securityMetadata?.secureDelegations?.values?.flatMap { d->
					listOfNotNull(
						d.delegate?.let { DataOwnerReferenceInGroup.parse(it) to d.permissions },
						d.delegator?.let { DataOwnerReferenceInGroup.parse(it) to d.permissions }
					)
				} ?: emptyList()
			),
			entityWithType.entity.securityMetadata?.secureDelegations?.values?.any { v ->
				v.delegate == null || v.delegator == null
			} ?: false
		)
		return infoFromLegacyDelegations.merge(infoFromSecureDelegations)
	}
}