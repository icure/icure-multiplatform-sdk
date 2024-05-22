// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicFlavouredApi")
public external interface TopicFlavouredApiJs<E : TopicJs> {
	public fun shareWith(
		delegateId: String,
		topic: E,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<E>>

	public fun modifyTopic(entity: E): Promise<E>

	public fun getTopic(entityId: String): Promise<E>

	public fun getTopics(entityIds: Array<String>): Promise<Array<E>>

	public fun filterTopicsBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<EncryptedTopicJs>,
	): Promise<PaginatedListJs<E>>

	public fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<E>

	public fun removeParticipant(entityId: String, dataOwnerId: String): Promise<E>
}
