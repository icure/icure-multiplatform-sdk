// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.sdk.js.model.DecryptedTopicJs
import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicApi")
public external interface TopicApiJs {
	public val encrypted: TopicFlavouredApiJs<EncryptedTopicJs>

	public val tryAndRecover: TopicFlavouredApiJs<TopicJs>

	public fun createTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs>

	public fun withEncryptionMetadata(
		base: DecryptedTopicJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedTopicJs>

	public fun getEncryptionKeysOf(topic: TopicJs): Promise<Array<String>>

	public fun hasWriteAccess(topic: TopicJs): Promise<Boolean>

	public fun decryptPatientIdOf(topic: TopicJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: TopicJs, delegates: Array<String>):
			Promise<Unit>

	public fun deleteTopic(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTopics(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun matchTopicsBy(filter: AbstractFilterJs<TopicJs>): Promise<Array<String>>

	public fun shareWith(
		delegateId: String,
		topic: DecryptedTopicJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedTopicJs>>

	public fun tryShareWithMany(topic: DecryptedTopicJs,
			delegates: Record<String, TopicShareOptionsJs>): Promise<SimpleShareResultJs<DecryptedTopicJs>>

	public fun shareWithMany(topic: DecryptedTopicJs, delegates: Record<String, TopicShareOptionsJs>):
			Promise<DecryptedTopicJs>

	public fun modifyTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs>

	public fun getTopic(entityId: String): Promise<DecryptedTopicJs>

	public fun getTopics(entityIds: Array<String>): Promise<Array<DecryptedTopicJs>>

	public fun filterTopicsBy(filterChain: FilterChainJs<TopicJs>, options: dynamic):
			Promise<PaginatedListJs<DecryptedTopicJs>>

	public fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<DecryptedTopicJs>

	public fun removeParticipant(entityId: String, dataOwnerId: String): Promise<DecryptedTopicJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<TopicJs>,
		eventFired: (DecryptedTopicJs) -> Promise<Unit>,
		options: dynamic,
	): Promise<ConnectionJs>
}
