// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.DecryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementInGroupApi")
public external interface HealthElementInGroupApiJs {
	public val encrypted: HealthElementFlavouredInGroupApiJs<EncryptedHealthElementJs>

	public val tryAndRecover: HealthElementFlavouredInGroupApiJs<HealthElementJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedHealthElementJs?,
		patient: GroupScopedJs<PatientJs>,
		alternateRootDataOwnerReference: EntityReferenceInGroupJs?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun getEncryptionKeysOf(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<Array<String>>

	public fun hasWriteAccess(healthElement: GroupScopedJs<HealthElementJs>): Promise<Boolean>

	public fun decryptPatientIdOf(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<HealthElementJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(healthElements: Array<GroupScopedJs<EncryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>>

	public fun tryDecrypt(healthElements: Array<GroupScopedJs<EncryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<HealthElementJs>>>

	public fun encryptOrValidate(healthElements: Array<GroupScopedJs<HealthElementJs>>):
			Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>>

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		healthElement: GroupScopedJs<DecryptedHealthElementJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun shareWithMany(healthElement: GroupScopedJs<DecryptedHealthElementJs>,
			delegates: Array<EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun createHealthElement(entity: GroupScopedJs<DecryptedHealthElementJs>):
			Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun modifyHealthElement(entity: GroupScopedJs<DecryptedHealthElementJs>):
			Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun getHealthElement(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedHealthElementJs>?>
}
