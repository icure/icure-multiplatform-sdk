// auto-generated file
package com.icure.sdk.py.api.flavoured.ContactApi

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.ContactShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.py.serialization.ContactSerializer
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.serialization.ServiceSerializer
import com.icure.sdk.py.subscription.EntitySubscription.EntitySubscriptionWithSerializer
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

@Serializable
private class CreateContactParams(
	public val entity: DecryptedContact,
)

public fun createContactBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateContactParams>(params)
	runBlocking {
		sdk.contact.createContact(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createContactAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.createContact(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateContactsParams(
	public val entities: List<DecryptedContact>,
)

public fun createContactsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateContactsParams>(params)
	runBlocking {
		sdk.contact.createContacts(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun createContactsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.createContacts(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedContact?,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val secretId: SecretIdOption =
			com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent,
)

public fun withEncryptionMetadataBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.contact.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun withEncryptionMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	@Serializable(ContactSerializer::class)
	public val contact: Contact,
)

public fun getEncryptionKeysOfBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.contact.getEncryptionKeysOf(
			decodedParams.contact,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getEncryptionKeysOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getEncryptionKeysOf(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	@Serializable(ContactSerializer::class)
	public val contact: Contact,
)

public fun hasWriteAccessBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.contact.hasWriteAccess(
			decodedParams.contact,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun hasWriteAccessAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.hasWriteAccess(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	@Serializable(ContactSerializer::class)
	public val contact: Contact,
)

public fun decryptPatientIdOfBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.contact.decryptPatientIdOf(
			decodedParams.contact,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun decryptPatientIdOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.decryptPatientIdOf(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	@Serializable(ContactSerializer::class)
	public val entity: Contact,
	public val delegates: Set<String>,
)

public fun createDelegationDeAnonymizationMetadataBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.contact.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val contact: EncryptedContact,
)

public fun decryptBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.contact.decrypt(
			decodedParams.contact,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun decryptAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.decrypt(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val contact: EncryptedContact,
)

public fun tryDecryptBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.contact.tryDecrypt(
			decodedParams.contact,
		)
	}
}.toPyString(ContactSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun tryDecryptAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryDecrypt(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(ContactSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptServiceParams(
	public val service: EncryptedService,
)

public fun decryptServiceBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptServiceParams>(params)
	runBlocking {
		sdk.contact.decryptService(
			decodedParams.service,
		)
	}
}.toPyString(DecryptedService.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun decryptServiceAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.decryptService(
				decodedParams.service,
			)
		}.toPyStringAsyncCallback(DecryptedService.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptServiceParams(
	public val service: EncryptedService,
)

public fun tryDecryptServiceBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptServiceParams>(params)
	runBlocking {
		sdk.contact.tryDecryptService(
			decodedParams.service,
		)
	}
}.toPyString(ServiceSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun tryDecryptServiceAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryDecryptService(
				decodedParams.service,
			)
		}.toPyStringAsyncCallback(ServiceSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchContactsByParams(
	@Contextual
	public val filter: AbstractFilter<Contact>,
)

public fun matchContactsByBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchContactsByParams>(params)
	runBlocking {
		sdk.contact.matchContactsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchContactsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchContactsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.matchContactsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchServicesByParams(
	@Contextual
	public val filter: AbstractFilter<Service>,
)

public fun matchServicesByBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchServicesByParams>(params)
	runBlocking {
		sdk.contact.matchServicesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchServicesByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchServicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.matchServicesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteContactParams(
	public val entityId: String,
)

public fun deleteContactBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteContactParams>(params)
	runBlocking {
		sdk.contact.deleteContact(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteContactAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.deleteContact(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteContactsParams(
	public val entityIds: List<String>,
)

public fun deleteContactsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteContactsParams>(params)
	runBlocking {
		sdk.contact.deleteContacts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteContactsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.deleteContacts(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindContactsDelegationsStubsByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findContactsDelegationsStubsByHcPartyPatientForeignKeysBlocking(sdk: IcureApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindContactsDelegationsStubsByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.contact.findContactsDelegationsStubsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(IcureStub.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findContactsDelegationsStubsByHcPartyPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindContactsDelegationsStubsByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.findContactsDelegationsStubsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(IcureStub.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServiceCodesOccurrencesParams(
	public val codeType: String,
	public val minOccurrences: Long,
)

public fun getServiceCodesOccurrencesBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServiceCodesOccurrencesParams>(params)
	runBlocking {
		sdk.contact.getServiceCodesOccurrences(
			decodedParams.codeType,
			decodedParams.minOccurrences,
		)
	}
}.toPyString(ListSerializer(LabelledOccurence.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getServiceCodesOccurrencesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServiceCodesOccurrencesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getServiceCodesOccurrences(
				decodedParams.codeType,
				decodedParams.minOccurrences,
			)
		}.toPyStringAsyncCallback(ListSerializer(LabelledOccurence.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToServiceEventsParams(
	public val events: Set<SubscriptionEventType>,
	@Contextual
	public val filter: AbstractFilter<Service>,
	public val subscriptionConfig: EntitySubscriptionConfiguration,
)

public fun subscribeToServiceEventsBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToServiceEventsParams>(params)
	runBlocking {
		sdk.contact.subscribeToServiceEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedService.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun subscribeToServiceEventsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToServiceEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.subscribeToServiceEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedService.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	@Contextual
	public val filter: AbstractFilter<Contact>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.contact.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedContact.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun subscribeToEventsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val contact: DecryptedContact,
	public val options: ContactShareOptions? = null,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.contact.shareWith(
			decodedParams.delegateId,
			decodedParams.contact,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.shareWith(
				decodedParams.delegateId,
				decodedParams.contact,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedContact.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val contact: DecryptedContact,
	public val delegates: Map<String, ContactShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.contact.tryShareWithMany(
			decodedParams.contact,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryShareWithMany(
				decodedParams.contact,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedContact.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val contact: DecryptedContact,
	public val delegates: Map<String, ContactShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.contact.shareWithMany(
			decodedParams.contact,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.shareWithMany(
				decodedParams.contact,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindContactsByHcPartyPatientParams(
	public val hcPartyId: String,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findContactsByHcPartyPatientBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindContactsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.contact.findContactsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedContact.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun findContactsByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindContactsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.findContactsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyContactParams(
	public val entity: DecryptedContact,
)

public fun modifyContactBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyContactParams>(params)
	runBlocking {
		sdk.contact.modifyContact(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyContactAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.modifyContact(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyContactsParams(
	public val entities: List<DecryptedContact>,
)

public fun modifyContactsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyContactsParams>(params)
	runBlocking {
		sdk.contact.modifyContacts(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyContactsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.modifyContacts(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetContactParams(
	public val entityId: String,
)

public fun getContactBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetContactParams>(params)
	runBlocking {
		sdk.contact.getContact(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getContactAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getContact(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetContactsParams(
	public val entityIds: List<String>,
)

public fun getContactsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetContactsParams>(params)
	runBlocking {
		sdk.contact.getContacts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getContactsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getContacts(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterContactsByParams(
	@Contextual
	public val filter: AbstractFilter<Contact>,
)

public fun filterContactsByBlocking(sdk: IcureApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterContactsByParams>(params)
	runBlocking {
		sdk.contact.filterContactsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedContact.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterContactsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterContactsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.filterContactsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ListContactByHCPartyServiceIdParams(
	public val hcPartyId: String,
	public val serviceId: String,
)

public fun listContactByHCPartyServiceIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	runBlocking {
		sdk.contact.listContactByHCPartyServiceId(
			decodedParams.hcPartyId,
			decodedParams.serviceId,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listContactByHCPartyServiceIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactByHCPartyServiceId(
				decodedParams.hcPartyId,
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByExternalIdParams(
	public val externalId: String,
)

public fun listContactsByExternalIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByExternalIdParams>(params)
	runBlocking {
		sdk.contact.listContactsByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listContactsByExternalIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByExternalIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactsByExternalId(
				decodedParams.externalId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndFormIdParams(
	public val hcPartyId: String,
	public val formId: String,
)

public fun listContactsByHCPartyAndFormIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	runBlocking {
		sdk.contact.listContactsByHCPartyAndFormId(
			decodedParams.hcPartyId,
			decodedParams.formId,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listContactsByHCPartyAndFormIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactsByHCPartyAndFormId(
				decodedParams.hcPartyId,
				decodedParams.formId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndFormIdsParams(
	public val hcPartyId: String,
	public val formIds: List<String>,
)

public fun listContactsByHCPartyAndFormIdsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	runBlocking {
		sdk.contact.listContactsByHCPartyAndFormIds(
			decodedParams.hcPartyId,
			decodedParams.formIds,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listContactsByHCPartyAndFormIdsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactsByHCPartyAndFormIds(
				decodedParams.hcPartyId,
				decodedParams.formIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndPatientSecretFKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
	public val planOfActionsIds: String? = null,
	public val skipClosedContacts: Boolean? = null,
)

public fun listContactsByHCPartyAndPatientSecretFKeysBlocking(sdk: IcureApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndPatientSecretFKeysParams>(params)
	runBlocking {
		sdk.contact.listContactsByHCPartyAndPatientSecretFKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
			decodedParams.planOfActionsIds,
			decodedParams.skipClosedContacts,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listContactsByHCPartyAndPatientSecretFKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndPatientSecretFKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactsByHCPartyAndPatientSecretFKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
				decodedParams.planOfActionsIds,
				decodedParams.skipClosedContacts,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CloseForHCPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun closeForHCPartyPatientForeignKeysBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CloseForHCPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.contact.closeForHCPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun closeForHCPartyPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CloseForHCPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.closeForHCPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServiceParams(
	public val serviceId: String,
)

public fun getServiceBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServiceParams>(params)
	runBlocking {
		sdk.contact.getService(
			decodedParams.serviceId,
		)
	}
}.toPyString(DecryptedService.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getServiceAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getService(
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(DecryptedService.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServicesParams(
	public val entityIds: List<String>,
)

public fun getServicesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServicesParams>(params)
	runBlocking {
		sdk.contact.getServices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedService.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getServicesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getServices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServicesLinkedToParams(
	public val linkType: String,
	public val ids: List<String>,
)

public fun getServicesLinkedToBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServicesLinkedToParams>(params)
	runBlocking {
		sdk.contact.getServicesLinkedTo(
			decodedParams.linkType,
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(DecryptedService.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getServicesLinkedToAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServicesLinkedToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getServicesLinkedTo(
				decodedParams.linkType,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListServicesByAssociationIdParams(
	public val associationId: String,
)

public fun listServicesByAssociationIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListServicesByAssociationIdParams>(params)
	runBlocking {
		sdk.contact.listServicesByAssociationId(
			decodedParams.associationId,
		)
	}
}.toPyString(ListSerializer(DecryptedService.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listServicesByAssociationIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListServicesByAssociationIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listServicesByAssociationId(
				decodedParams.associationId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListServicesByHealthElementIdParams(
	public val hcPartyId: String,
	public val healthElementId: String,
)

public fun listServicesByHealthElementIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListServicesByHealthElementIdParams>(params)
	runBlocking {
		sdk.contact.listServicesByHealthElementId(
			decodedParams.hcPartyId,
			decodedParams.healthElementId,
		)
	}
}.toPyString(ListSerializer(DecryptedService.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listServicesByHealthElementIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListServicesByHealthElementIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listServicesByHealthElementId(
				decodedParams.hcPartyId,
				decodedParams.healthElementId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindContactsByOpeningDateParams(
	public val startDate: Long,
	public val endDate: Long,
	public val hcPartyId: String,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findContactsByOpeningDateBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindContactsByOpeningDateParams>(params)
	runBlocking {
		sdk.contact.findContactsByOpeningDate(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedContact.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findContactsByOpeningDateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindContactsByOpeningDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.findContactsByOpeningDate(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterServicesByParams(
	@Contextual
	public val filter: AbstractFilter<Service>,
)

public fun filterServicesByBlocking(sdk: IcureApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterServicesByParams>(params)
	runBlocking {
		sdk.contact.filterServicesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedService.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterServicesByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterServicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.filterServicesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedService.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
