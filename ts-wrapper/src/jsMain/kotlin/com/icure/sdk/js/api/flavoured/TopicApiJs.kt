// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.sdk.js.model.DecryptedTopicJs
import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
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
		options: TopicApi_withEncryptionMetadata_Options?,
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
		options: TopicApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedTopicJs>>

	public fun tryShareWithMany(topic: DecryptedTopicJs,
			delegates: Record<String, TopicShareOptionsJs>): Promise<SimpleShareResultJs<DecryptedTopicJs>>

	public fun shareWithMany(topic: DecryptedTopicJs, delegates: Record<String, TopicShareOptionsJs>):
			Promise<DecryptedTopicJs>

	public fun modifyTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs>

	public fun getTopic(entityId: String): Promise<DecryptedTopicJs>

	public fun getTopics(entityIds: Array<String>): Promise<Array<DecryptedTopicJs>>

	public fun filterTopicsBy(filterChain: FilterChainJs<TopicJs>,
			options: TopicApi_filterTopicsBy_Options?): Promise<PaginatedListJs<DecryptedTopicJs>>

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
		options: TopicApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface TopicApi_withEncryptionMetadata_Options {
	public val user: UserJs?

	public val delegates: Record<String, String>

	public val secretId: SecretIdOptionJs
}

public external interface TopicApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface TopicApi_filterTopicsBy_Options {
	public val startDocumentId: String?

	public val limit: Double?
}

public external interface TopicApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
