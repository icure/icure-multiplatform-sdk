package com.icure.sdk.api

import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.TopicShareOptions
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.subscription.Subscribable
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface TopicBasicFlavourlessApi {

	/**
	 * Deletes a topic. If you don't have write access to the topic the method will fail.
	 * @param entityId id of the topic.
	 * @return the id and revision of the deleted topic.
	 */
	suspend fun deleteTopic(entityId: String): DocIdentifier

	/**
	 * Deletes many topics. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the topics.
	 * @return the id and revision of the deleted topics. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteTopics(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface TopicBasicFlavouredApi<E : Topic> {
	/**
	 * Modifies a topic. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a topic with update content
	 * @return the topic updated with the provided content and a new revision.
	 */
	suspend fun modifyTopic(entity: E): E

	/**
	 * Get a topic by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a topic, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a topic id.
	 * @return the topic with id [entityId].
	 */
	suspend fun getTopic(entityId: String): E

	/**
	 * Get multiple topics by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a topic, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of topics ids
	 * @return all topics that you can access with one of the provided ids.
	 */
	suspend fun getTopics(entityIds: List<String>): List<E>

	/**
	 * Add a participant to the topic. The participant will be able to create messages associated to the topic.
	 * Any user with a [TopicRole.Admin] on the can use this method, even if they don't have direct write access
	 * to it through delegations.
	 * @param entityId id of the topic
	 * @param dataOwnerId id of the new participant
	 * @param topicRole the role that the participant will have in the topic
	 * @return the updated topic
	 */
	suspend fun addParticipant(entityId: String, dataOwnerId: String, topicRole: TopicRole): E

	/**
	 * Removes a participant from a topic. The participant will not be able anymore to search for messages of that topic.
	 * Any user with a [TopicRole.Admin] on the can use this method, even if they don't have direct write access
	 * to it through delegations.
	 * @param entityId id of the topic
	 * @param dataOwnerId id of the participant to remove
	 * @return the updated topic
	 */
	suspend fun removeParticipant(entityId: String, dataOwnerId: String): E
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface TopicFlavouredApi<E : Topic> : TopicBasicFlavouredApi<E> {
	/**
	 * Share a topic with another data owner. The topic must already exist in the database for this method to
	 * succeed. If you want to share the topic before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the topic
	 * @param topic the topic to share with [delegateId]
	 * @param options specifies how the topic will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the topic. Refer
	 * to the documentation of [TopicShareOptions] for more information.
	 * @return the updated topic if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		topic: E,
		@DefaultValue("null")
		options: TopicShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share a topic with multiple data owners. The topic must already exist in the database for this method to
	 * succeed. If you want to share the topic before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param topic the topic to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated topic if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		topic: E,
		delegates: Map<String, TopicShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a topic with multiple data owners. The topic must already exist in the database for this method to
	 * succeed. If you want to share the topic before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param topic the topic to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated topic.
	 */
	suspend fun shareWithMany(
		topic: E,
		delegates: Map<String, TopicShareOptions>
	): E

	/**
	 * Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterTopicsBySorted] instead.
	 *
	 * @param filter a topic filter
	 * @return an iterator that iterates over all topics matching the provided filter.
	 */
	suspend fun filterTopicsBy(
		filter: FilterOptions<Topic>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterTopicsBy].
	 *
	 * @param filter a topic filter
	 * @return an iterator that iterates over all topics matching the provided filter.
	 */
	suspend fun filterTopicsBySorted(
		filter: SortableFilterOptions<Topic>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface TopicApi : TopicBasicFlavourlessApi, TopicFlavouredApi<DecryptedTopic>, Subscribable<Topic, EncryptedTopic, FilterOptions<Topic>> {
	/**
	 * Create a new topic. The provided topic must have the encryption metadata initialized.
	 * @param entity a topic with initialized encryption metadata
	 * @return the created topic with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createTopic(entity: DecryptedTopic): DecryptedTopic

	/**
	 * Creates a new topic with initialized encryption metadata
	 * @param base a topic with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the topic.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new topic
	 * @return a topic with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedTopic?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedTopic

	/**
	 * Attempts to extract the encryption keys of a topic. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param topic a topic
	 * @return the encryption keys extracted from the provided topic.
	 */
	suspend fun getEncryptionKeysOf(topic: Topic): Set<HexString>

	/**
	 * Specifies if the current user has write access to a topic.
	 * @param topic a topic
	 * @return if the current user has write access to the provided topic
	 */
	suspend fun hasWriteAccess(topic: Topic): Boolean

	/**
	 * Attempts to extract the patient id linked to a topic.
	 * Note: topics usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param topic a topic
	 * @return the id of the patient linked to the topic, or empty if the current user can't access any patient id
	 * of the topic.
	 */
	suspend fun decryptPatientIdOf(topic: Topic): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a topic.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided topic. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the topic the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Topic,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a topic E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any topic that you have shared with P, H will be able to know that the topic was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a topic that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a topic
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Set<String>)

	/**
	 * Decrypts a topic, throwing an exception if it is not possible.
	 * @param topic a topic
	 * @return the decrypted topic
	 * @throws EntityEncryptionException if the topic could not be decrypted
	 */
	suspend fun decrypt(topic: EncryptedTopic): DecryptedTopic

	/**
	 * Tries to decrypt a topic, returns the input if it is not possible.
	 * @param topic an encrypted topic
	 * @return the decrypted topic if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(topic: EncryptedTopic): Topic
	
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: TopicFlavouredApi<EncryptedTopic>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: TopicFlavouredApi<Topic>

	/**
	 * Get the ids of all topics matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchTopicsBySorted] instead.
	 *
	 * @param filter a topic filter
	 * @return a list of topic ids
	 */
	suspend fun matchTopicsBy(filter: FilterOptions<Topic>): List<String>

	/**
	 * Get the ids of all topics matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchTopicsBy].
	 *
	 * @param filter a topic filter
	 * @return a list of topic ids
	 */
	suspend fun matchTopicsBySorted(filter: SortableFilterOptions<Topic>): List<String>
}

interface TopicBasicApi : TopicBasicFlavourlessApi, TopicBasicFlavouredApi<EncryptedTopic>, Subscribable<Topic, EncryptedTopic, BaseFilterOptions<Topic>> {
	/**
	 * Get the ids of all topics matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchTopicsBySorted] instead.
	 *
	 * @param filter a topic filter
	 * @return a list of topic ids
	 */
	suspend fun matchTopicsBy(filter: BaseFilterOptions<Topic>): List<String>

	/**
	 * Get the ids of all topics matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchTopicsBy].
	 *
	 * @param filter a topic filter
	 * @return a list of topic ids
	 */
	suspend fun matchTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): List<String>

	/**
	 * Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterTopicsBySorted] instead.
	 *
	 * @param filter a topic filter
	 * @return an iterator that iterates over all topics matching the provided filter.
	 */
	suspend fun filterTopicsBy(
		filter: BaseFilterOptions<Topic>
	): PaginatedListIterator<EncryptedTopic>

	/**
	 * Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterTopicsBy].
	 *
	 * @param filter a topic filter
	 * @return an iterator that iterates over all topics matching the provided filter.
	 */
	suspend fun filterTopicsBySorted(
		filter: BaseSortableFilterOptions<Topic>
	): PaginatedListIterator<EncryptedTopic>
}