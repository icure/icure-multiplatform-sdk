// auto-generated file
package com.icure.sdk.py.api.ContactApi.tryAndRecover

import com.icure.sdk.CardinalApis
import com.icure.sdk.crypto.entities.ContactShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Contact
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.embed.Service
import com.icure.sdk.py.serialization.ContactSerializer
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.serialization.ServiceSerializer
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
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
	public val contact: Contact,
	public val options: ContactShareOptions? = null,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.contact,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.contact,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val contact: Contact,
	public val delegates: Map<String, ContactShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.tryShareWithMany(
			decodedParams.contact,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.tryShareWithMany(
				decodedParams.contact,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val contact: Contact,
	public val delegates: Map<String, ContactShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.shareWithMany(
			decodedParams.contact,
			decodedParams.delegates,
		)
	}
}.toPyString(ContactSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.shareWithMany(
				decodedParams.contact,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(ContactSerializer, resultCallback)
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

public fun findContactsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindContactsByHcPartyPatientParams>(params)
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
	PaginatedListIteratorAndSerializer(it, ContactSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun findContactsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindContactsByHcPartyPatientParams>(params)
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
			PaginatedListIteratorAndSerializer(it, ContactSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterContactsByParams(
	public val filter: FilterOptions<Contact>,
)

public fun filterContactsByBlocking(sdk: CardinalApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterContactsByParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.filterContactsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, ContactSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterContactsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterContactsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.filterContactsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, ContactSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterServicesByParams(
	public val filter: FilterOptions<Service>,
)

public fun filterServicesByBlocking(sdk: CardinalApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterServicesByParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.filterServicesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, ServiceSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterServicesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterServicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.filterServicesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, ServiceSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterContactsBySortedParams(
	public val filter: SortableFilterOptions<Contact>,
)

public fun filterContactsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterContactsBySortedParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.filterContactsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, ContactSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterContactsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterContactsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.filterContactsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, ContactSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterServicesBySortedParams(
	public val filter: SortableFilterOptions<Service>,
)

public fun filterServicesBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterServicesBySortedParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.filterServicesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, ServiceSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterServicesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterServicesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.filterServicesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, ServiceSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyContactParams(
	public val entity: Contact,
)

public fun modifyContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyContactParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.modifyContact(
			decodedParams.entity,
		)
	}
}.toPyString(ContactSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.modifyContact(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(ContactSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyContactsParams(
	public val entities: List<Contact>,
)

public fun modifyContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyContactsParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.modifyContacts(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun modifyContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.modifyContacts(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetContactParams(
	public val entityId: String,
)

public fun getContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetContactParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.getContact(
			decodedParams.entityId,
		)
	}
}.toPyString(ContactSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getContact(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(ContactSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetContactsParams(
	public val entityIds: List<String>,
)

public fun getContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetContactsParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.getContacts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getContacts(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactByHCPartyServiceIdParams(
	public val hcPartyId: String,
	public val serviceId: String,
)

public fun listContactByHCPartyServiceIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.listContactByHCPartyServiceId(
			decodedParams.hcPartyId,
			decodedParams.serviceId,
		)
	}
}.toPyString(ListSerializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listContactByHCPartyServiceIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactByHCPartyServiceId(
				decodedParams.hcPartyId,
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(ListSerializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByExternalIdParams(
	public val externalId: String,
)

public fun listContactsByExternalIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByExternalIdParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.listContactsByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(ListSerializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listContactsByExternalIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByExternalIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactsByExternalId(
				decodedParams.externalId,
			)
		}.toPyStringAsyncCallback(ListSerializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndFormIdParams(
	public val hcPartyId: String,
	public val formId: String,
)

public fun listContactsByHCPartyAndFormIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.listContactsByHCPartyAndFormId(
			decodedParams.hcPartyId,
			decodedParams.formId,
		)
	}
}.toPyString(ListSerializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listContactsByHCPartyAndFormIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactsByHCPartyAndFormId(
				decodedParams.hcPartyId,
				decodedParams.formId,
			)
		}.toPyStringAsyncCallback(ListSerializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndFormIdsParams(
	public val hcPartyId: String,
	public val formIds: List<String>,
)

public fun listContactsByHCPartyAndFormIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.listContactsByHCPartyAndFormIds(
			decodedParams.hcPartyId,
			decodedParams.formIds,
		)
	}
}.toPyString(ListSerializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listContactsByHCPartyAndFormIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactsByHCPartyAndFormIds(
				decodedParams.hcPartyId,
				decodedParams.formIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndPatientSecretFKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
	public val planOfActionsIds: String? = null,
	public val skipClosedContacts: Boolean? = null,
)

public fun listContactsByHCPartyAndPatientSecretFKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndPatientSecretFKeysParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.listContactsByHCPartyAndPatientSecretFKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
			decodedParams.planOfActionsIds,
			decodedParams.skipClosedContacts,
		)
	}
}.toPyString(ListSerializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listContactsByHCPartyAndPatientSecretFKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListContactsByHCPartyAndPatientSecretFKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listContactsByHCPartyAndPatientSecretFKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
				decodedParams.planOfActionsIds,
				decodedParams.skipClosedContacts,
			)
		}.toPyStringAsyncCallback(ListSerializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServiceParams(
	public val serviceId: String,
)

public fun getServiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServiceParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.getService(
			decodedParams.serviceId,
		)
	}
}.toPyString(ServiceSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getServiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getService(
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(ServiceSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServicesParams(
	public val entityIds: List<String>,
)

public fun getServicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServicesParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.getServices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(ServiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getServicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getServices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(ServiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServicesLinkedToParams(
	public val linkType: String,
	public val ids: List<String>,
)

public fun getServicesLinkedToBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServicesLinkedToParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.getServicesLinkedTo(
			decodedParams.linkType,
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(ServiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getServicesLinkedToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetServicesLinkedToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.getServicesLinkedTo(
				decodedParams.linkType,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(ServiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListServicesByAssociationIdParams(
	public val associationId: String,
)

public fun listServicesByAssociationIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListServicesByAssociationIdParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.listServicesByAssociationId(
			decodedParams.associationId,
		)
	}
}.toPyString(ListSerializer(ServiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listServicesByAssociationIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListServicesByAssociationIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listServicesByAssociationId(
				decodedParams.associationId,
			)
		}.toPyStringAsyncCallback(ListSerializer(ServiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListServicesByHealthElementIdParams(
	public val hcPartyId: String,
	public val healthElementId: String,
)

public fun listServicesByHealthElementIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListServicesByHealthElementIdParams>(params)
	runBlocking {
		sdk.contact.tryAndRecover.listServicesByHealthElementId(
			decodedParams.hcPartyId,
			decodedParams.healthElementId,
		)
	}
}.toPyString(ListSerializer(ServiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listServicesByHealthElementIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListServicesByHealthElementIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryAndRecover.listServicesByHealthElementId(
				decodedParams.hcPartyId,
				decodedParams.healthElementId,
			)
		}.toPyStringAsyncCallback(ListSerializer(ServiceSerializer), resultCallback)
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

public fun findContactsByOpeningDateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindContactsByOpeningDateParams>(params)
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
}.toPyString(PaginatedList.serializer(ContactSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findContactsByOpeningDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindContactsByOpeningDateParams>(params)
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(ContactSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
