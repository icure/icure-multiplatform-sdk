// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedTopicJs
import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("TopicApi")
public external interface TopicApiJs {
	public val encrypted: TopicFlavouredApiJs<EncryptedTopicJs>

	public val tryAndRecover: TopicFlavouredApiJs<TopicJs>

	public fun createTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs>

	public fun withEncryptionMetadata(
		base: DecryptedTopicJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedTopicJs>

	public fun deleteTopic(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTopics(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun matchTopicsBy(filter: AbstractFilterJs<EncryptedTopicJs>): Promise<Array<String>>

	public fun shareWith(
		delegateId: String,
		topic: DecryptedTopicJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedTopicJs>>
}
