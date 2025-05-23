package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.EntityAccessInformationProvider
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.utils.InternalIcureApi
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

/**
 * Implementation of [EntityAccessInformationProvider] that doesn't attempt to de-anonymize any delegation, can be used
 * even with the basic/non-data-owner sdk.
 */
@InternalIcureApi
internal class BasicEntityAccessInformationProvider(
	/**
	 * On basic SDK this should give the (constant) bound group id
	 * On unbound SDK this should give the group id of the current request
	 */
	private val currentBoundGroupId: (CoroutineContext) -> SdkBoundGroup?
) : EntityAccessInformationProvider {
	override suspend fun getDataOwnersWithAccessTo(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): EntityAccessInformation {
		val infoFromLegacyDelegations = EntityAccessInformation(
			entity.delegations.keys.associate {
				// Legacy delegations don't support inter-group sharing
				Pair(EntityReferenceInGroup(it, null), AccessLevel.Write)
			},
			false
		)
		val boundGroup = currentBoundGroupId(coroutineContext)
		val infoFromSecureDelegations = EntityAccessInformation(
			EntityAccessInformation.buildPermissionsMap(
				entity.securityMetadata?.secureDelegations?.values?.flatMap { d->
					listOfNotNull(
						d.delegate?.let {
							EntityReferenceInGroup.parse(it, entityGroupId, boundGroup) to d.permissions
						},
						d.delegator?.let {
							EntityReferenceInGroup.parse(it, entityGroupId, boundGroup) to d.permissions
						}
					)
				} ?: emptyList()
			),
			entity.securityMetadata?.secureDelegations?.values?.any { v ->
				v.delegate == null || v.delegator == null
			} ?: false
		)
		return infoFromLegacyDelegations.merge(infoFromSecureDelegations)
	}
}