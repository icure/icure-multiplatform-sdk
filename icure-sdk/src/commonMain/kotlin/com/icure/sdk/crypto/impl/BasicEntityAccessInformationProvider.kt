package com.icure.sdk.crypto.impl

import com.icure.sdk.crypto.EntityAccessInformationProvider
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.model.embed.AccessLevel

/**
 * Implementation of [EntityAccessInformationProvider] that does not attempt to de-anonymize any delegation, can be used
 * even with the basic/non-data-owner sdk.
 */
internal object BasicEntityAccessInformationProvider : EntityAccessInformationProvider {
	override suspend fun getDataOwnersWithAccessTo(entityWithType: EntityWithTypeInfo<*>): EntityAccessInformation {
		val infoFromLegacyDelegations = EntityAccessInformation(
			entityWithType.entity.delegations.keys.associateWith { AccessLevel.Write },
			false
		)
		val infoFromSecureDelegations = EntityAccessInformation(
			EntityAccessInformation.buildPermissionsMap(
				entityWithType.entity.securityMetadata?.secureDelegations?.values?.flatMap { d->
					listOfNotNull(
						d.delegate?.let { it to d.permissions },
						d.delegator?.let { it to d.permissions }
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