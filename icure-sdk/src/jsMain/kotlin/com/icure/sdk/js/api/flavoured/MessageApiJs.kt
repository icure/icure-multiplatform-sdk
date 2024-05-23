// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedMessageJs
import com.icure.sdk.js.model.EncryptedMessageJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("MessageApi")
public external interface MessageApiJs {
	public val encrypted: MessageFlavouredApiJs<EncryptedMessageJs>

	public val tryAndRecover: MessageFlavouredApiJs<MessageJs>

	public fun createMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs>

	public fun withEncryptionMetadata(
		base: DecryptedMessageJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedMessageJs>

	public fun createMessageInTopic(entity: DecryptedMessageJs): Promise<DecryptedMessageJs>

	public fun matchMessagesBy(filter: AbstractFilterJs<EncryptedMessageJs>): Promise<Array<String>>

	public fun deleteMessage(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMessages(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		message: DecryptedMessageJs,
		shareSecretIds: Array<String>,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedMessageJs>>

	public fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedMessageJs>>
}
