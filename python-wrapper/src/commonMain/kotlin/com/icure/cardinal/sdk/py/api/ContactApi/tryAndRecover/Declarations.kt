// auto-generated file
package com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
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
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonElement

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val contact: Contact,
	public val options: ContactShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.contact,
			decodedParams.options,
		)
	}
}.toPyString(PolymorphicSerializer(Contact::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.contact,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Contact::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val contact: Contact,
	public val delegates: Map<String, ContactShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.shareWithMany(
			decodedParams.contact,
			decodedParams.delegates,
		)
	}
}.toPyString(PolymorphicSerializer(Contact::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.shareWithMany(
				decodedParams.contact,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Contact::class), resultCallback)
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
		sdk.contact.tryAndRecover.findContactsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Contact::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findContactsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.findContactsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Contact::class))}
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
		sdk.contact.tryAndRecover.filterContactsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Contact::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterContactsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.filterContactsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Contact::class))}
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
		sdk.contact.tryAndRecover.filterServicesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Service::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterServicesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.filterServicesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Service::class))}
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
		sdk.contact.tryAndRecover.filterContactsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Contact::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterContactsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.filterContactsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Contact::class))}
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
		sdk.contact.tryAndRecover.filterServicesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Service::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterServicesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.filterServicesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Service::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateContactParams(
	public val entity: Contact,
)

@OptIn(InternalIcureApi::class)
public fun createContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateContactParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.createContact(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(Contact::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.createContact(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Contact::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateContactsParams(
	public val entities: List<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun createContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateContactsParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.createContacts(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Contact::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.createContacts(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Contact::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

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
		sdk.contact.tryAndRecover.undeleteContactById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(PolymorphicSerializer(Contact::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteContactByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.undeleteContactById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Contact::class), resultCallback)
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
		sdk.contact.tryAndRecover.undeleteContact(
			decodedParams.contact,
		)
	}
}.toPyString(PolymorphicSerializer(Contact::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.undeleteContact(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Contact::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyContactParams(
	public val entity: Contact,
)

@OptIn(InternalIcureApi::class)
public fun modifyContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.modifyContact(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(Contact::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.modifyContact(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Contact::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyContactsParams(
	public val entities: List<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun modifyContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactsParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.modifyContacts(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Contact::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.modifyContacts(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Contact::class)), resultCallback)
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
		sdk.contact.tryAndRecover.getContact(
			decodedParams.entityId,
		)
	}
}.toPyString(PolymorphicSerializer(Contact::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getContact(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Contact::class), resultCallback)
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
		sdk.contact.tryAndRecover.getContacts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Contact::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getContacts(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Contact::class)), resultCallback)
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
		sdk.contact.tryAndRecover.listContactByHCPartyServiceId(
			decodedParams.hcPartyId,
			decodedParams.serviceId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Contact::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactByHCPartyServiceIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactByHCPartyServiceId(
				decodedParams.hcPartyId,
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Contact::class)), resultCallback)
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
		sdk.contact.tryAndRecover.listContactsByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Contact::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByExternalIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByExternalIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactsByExternalId(
				decodedParams.externalId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Contact::class)), resultCallback)
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
		sdk.contact.tryAndRecover.listContactsByHCPartyAndFormId(
			decodedParams.hcPartyId,
			decodedParams.formId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Contact::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByHCPartyAndFormIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactsByHCPartyAndFormId(
				decodedParams.hcPartyId,
				decodedParams.formId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Contact::class)), resultCallback)
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
		sdk.contact.tryAndRecover.listContactsByHCPartyAndFormIds(
			decodedParams.hcPartyId,
			decodedParams.formIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Contact::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByHCPartyAndFormIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactsByHCPartyAndFormIds(
				decodedParams.hcPartyId,
				decodedParams.formIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Contact::class)), resultCallback)
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
		sdk.contact.tryAndRecover.getService(
			decodedParams.serviceId,
		)
	}
}.toPyString(PolymorphicSerializer(Service::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getService(
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Service::class), resultCallback)
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
		sdk.contact.tryAndRecover.getServices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Service::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getServices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Service::class)), resultCallback)
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
		sdk.contact.tryAndRecover.getServicesLinkedTo(
			decodedParams.linkType,
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Service::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServicesLinkedToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesLinkedToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getServicesLinkedTo(
				decodedParams.linkType,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Service::class)), resultCallback)
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
		sdk.contact.tryAndRecover.listServicesByAssociationId(
			decodedParams.associationId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Service::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listServicesByAssociationIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByAssociationIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listServicesByAssociationId(
				decodedParams.associationId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Service::class)), resultCallback)
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
		sdk.contact.tryAndRecover.listServicesByHealthElementId(
			decodedParams.hcPartyId,
			decodedParams.healthElementId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Service::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listServicesByHealthElementIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByHealthElementIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listServicesByHealthElementId(
				decodedParams.hcPartyId,
				decodedParams.healthElementId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Service::class)), resultCallback)
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
		sdk.contact.tryAndRecover.findContactsByOpeningDate(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Contact::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findContactsByOpeningDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByOpeningDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.findContactsByOpeningDate(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Contact::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
