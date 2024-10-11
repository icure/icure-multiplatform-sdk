// auto-generated file
package com.icure.cardinal.sdk.py.api.ContactApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonElement

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val contact: EncryptedContact,
	public val options: ContactShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.contact.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.contact,
			decodedParams.options,
		)
	}
}.toPyString(EncryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.contact,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(EncryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val contact: EncryptedContact,
	public val delegates: Map<String, ContactShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.contact.encrypted.shareWithMany(
			decodedParams.contact,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.shareWithMany(
				decodedParams.contact,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindContactsByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findContactsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.contact.encrypted.findContactsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedContact.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findContactsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.findContactsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterContactsByParams(
	public val filter: FilterOptions<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun filterContactsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsByParams>(params)
	runBlocking {
		sdk.contact.encrypted.filterContactsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedContact.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterContactsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.filterContactsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterServicesByParams(
	public val filter: FilterOptions<Service>,
)

@OptIn(InternalIcureApi::class)
public fun filterServicesByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesByParams>(params)
	runBlocking {
		sdk.contact.encrypted.filterServicesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedService.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterServicesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.filterServicesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedService.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterContactsBySortedParams(
	public val filter: SortableFilterOptions<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun filterContactsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsBySortedParams>(params)
	runBlocking {
		sdk.contact.encrypted.filterContactsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedContact.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterContactsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.filterContactsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterServicesBySortedParams(
	public val filter: SortableFilterOptions<Service>,
)

@OptIn(InternalIcureApi::class)
public fun filterServicesBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesBySortedParams>(params)
	runBlocking {
		sdk.contact.encrypted.filterServicesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedService.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterServicesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.filterServicesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedService.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class UndeleteContactByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteContactByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactByIdParams>(params)
	runBlocking {
		sdk.contact.encrypted.undeleteContactById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteContactByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.undeleteContactById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(EncryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteContactParams(
	public val contact: Contact,
)

@OptIn(InternalIcureApi::class)
public fun undeleteContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactParams>(params)
	runBlocking {
		sdk.contact.encrypted.undeleteContact(
			decodedParams.contact,
		)
	}
}.toPyString(EncryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.undeleteContact(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(EncryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyContactParams(
	public val entity: EncryptedContact,
)

@OptIn(InternalIcureApi::class)
public fun modifyContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactParams>(params)
	runBlocking {
		sdk.contact.encrypted.modifyContact(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.modifyContact(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyContactsParams(
	public val entities: List<EncryptedContact>,
)

@OptIn(InternalIcureApi::class)
public fun modifyContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactsParams>(params)
	runBlocking {
		sdk.contact.encrypted.modifyContacts(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.modifyContacts(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetContactParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactParams>(params)
	runBlocking {
		sdk.contact.encrypted.getContact(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.getContact(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetContactsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactsParams>(params)
	runBlocking {
		sdk.contact.encrypted.getContacts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.getContacts(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactByHCPartyServiceIdParams(
	public val hcPartyId: String,
	public val serviceId: String,
)

@OptIn(InternalIcureApi::class)
public fun listContactByHCPartyServiceIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	runBlocking {
		sdk.contact.encrypted.listContactByHCPartyServiceId(
			decodedParams.hcPartyId,
			decodedParams.serviceId,
		)
	}
}.toPyString(ListSerializer(EncryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactByHCPartyServiceIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.listContactByHCPartyServiceId(
				decodedParams.hcPartyId,
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByExternalIdParams(
	public val externalId: String,
)

@OptIn(InternalIcureApi::class)
public fun listContactsByExternalIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByExternalIdParams>(params)
	runBlocking {
		sdk.contact.encrypted.listContactsByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(ListSerializer(EncryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByExternalIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByExternalIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.listContactsByExternalId(
				decodedParams.externalId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndFormIdParams(
	public val hcPartyId: String,
	public val formId: String,
)

@OptIn(InternalIcureApi::class)
public fun listContactsByHCPartyAndFormIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	runBlocking {
		sdk.contact.encrypted.listContactsByHCPartyAndFormId(
			decodedParams.hcPartyId,
			decodedParams.formId,
		)
	}
}.toPyString(ListSerializer(EncryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByHCPartyAndFormIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.listContactsByHCPartyAndFormId(
				decodedParams.hcPartyId,
				decodedParams.formId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndFormIdsParams(
	public val hcPartyId: String,
	public val formIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listContactsByHCPartyAndFormIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	runBlocking {
		sdk.contact.encrypted.listContactsByHCPartyAndFormIds(
			decodedParams.hcPartyId,
			decodedParams.formIds,
		)
	}
}.toPyString(ListSerializer(EncryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByHCPartyAndFormIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.listContactsByHCPartyAndFormIds(
				decodedParams.hcPartyId,
				decodedParams.formIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndPatientSecretFKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
	public val planOfActionsIds: String? = null,
	public val skipClosedContacts: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun listContactsByHCPartyAndPatientSecretFKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndPatientSecretFKeysParams>(params)
	runBlocking {
		sdk.contact.encrypted.listContactsByHCPartyAndPatientSecretFKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
			decodedParams.planOfActionsIds,
			decodedParams.skipClosedContacts,
		)
	}
}.toPyString(ListSerializer(EncryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByHCPartyAndPatientSecretFKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndPatientSecretFKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.listContactsByHCPartyAndPatientSecretFKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
				decodedParams.planOfActionsIds,
				decodedParams.skipClosedContacts,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServiceParams(
	public val serviceId: String,
)

@OptIn(InternalIcureApi::class)
public fun getServiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServiceParams>(params)
	runBlocking {
		sdk.contact.encrypted.getService(
			decodedParams.serviceId,
		)
	}
}.toPyString(EncryptedService.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.getService(
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(EncryptedService.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServicesParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getServicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesParams>(params)
	runBlocking {
		sdk.contact.encrypted.getServices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedService.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.getServices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServicesLinkedToParams(
	public val linkType: String,
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getServicesLinkedToBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesLinkedToParams>(params)
	runBlocking {
		sdk.contact.encrypted.getServicesLinkedTo(
			decodedParams.linkType,
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(EncryptedService.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServicesLinkedToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesLinkedToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.getServicesLinkedTo(
				decodedParams.linkType,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListServicesByAssociationIdParams(
	public val associationId: String,
)

@OptIn(InternalIcureApi::class)
public fun listServicesByAssociationIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByAssociationIdParams>(params)
	runBlocking {
		sdk.contact.encrypted.listServicesByAssociationId(
			decodedParams.associationId,
		)
	}
}.toPyString(ListSerializer(EncryptedService.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listServicesByAssociationIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByAssociationIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.listServicesByAssociationId(
				decodedParams.associationId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListServicesByHealthElementIdParams(
	public val hcPartyId: String,
	public val healthElementId: String,
)

@OptIn(InternalIcureApi::class)
public fun listServicesByHealthElementIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByHealthElementIdParams>(params)
	runBlocking {
		sdk.contact.encrypted.listServicesByHealthElementId(
			decodedParams.hcPartyId,
			decodedParams.healthElementId,
		)
	}
}.toPyString(ListSerializer(EncryptedService.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listServicesByHealthElementIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByHealthElementIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.listServicesByHealthElementId(
				decodedParams.hcPartyId,
				decodedParams.healthElementId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedService.serializer()), resultCallback)
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

@OptIn(InternalIcureApi::class)
public fun findContactsByOpeningDateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByOpeningDateParams>(params)
	runBlocking {
		sdk.contact.encrypted.findContactsByOpeningDate(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findContactsByOpeningDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByOpeningDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.encrypted.findContactsByOpeningDate(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
