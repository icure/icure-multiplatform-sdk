// auto-generated file
package com.icure.sdk.py.api.flavoured.InvoiceApi.tryAndRecover

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.InvoiceShareOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.py.serialization.InvoiceSerializer
import com.icure.sdk.py.serialization.PatientSerializer
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
	public val invoice: Invoice,
	public val shareEncryptionKeys: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val shareOwningEntityIds: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val requestedPermission: RequestedPermission =
			com.icure.sdk.model.requests.RequestedPermission.MaxWrite,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.invoice,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
		)
	}
}.toPyString(SimpleShareResult.serializer(InvoiceSerializer))

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
			sdk.invoice.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.invoice,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val invoice: Invoice,
	public val delegates: Map<String, InvoiceShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.tryShareWithMany(
			decodedParams.invoice,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(InvoiceSerializer))

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
			sdk.invoice.tryAndRecover.tryShareWithMany(
				decodedParams.invoice,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val invoice: Invoice,
	public val delegates: Map<String, InvoiceShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.shareWithMany(
			decodedParams.invoice,
			decodedParams.delegates,
		)
	}
}.toPyString(InvoiceSerializer)

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
			sdk.invoice.tryAndRecover.shareWithMany(
				decodedParams.invoice,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(InvoiceSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindInvoicesByHcPartyPatientParams(
	public val hcPartyId: String,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findInvoicesByHcPartyPatientBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.findInvoicesByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, InvoiceSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun findInvoicesByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.findInvoicesByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, InvoiceSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoiceParams(
	public val entity: Invoice,
)

public fun modifyInvoiceBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoiceParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.modifyInvoice(
			decodedParams.entity,
		)
	}
}.toPyString(InvoiceSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyInvoiceAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.modifyInvoice(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(InvoiceSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoicesParams(
	public val entities: List<Invoice>,
)

public fun modifyInvoicesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoicesParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.modifyInvoices(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun modifyInvoicesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.modifyInvoices(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInvoiceParams(
	public val entityId: String,
)

public fun getInvoiceBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoiceParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.getInvoice(
			decodedParams.entityId,
		)
	}
}.toPyString(InvoiceSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getInvoiceAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.getInvoice(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(InvoiceSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInvoicesParams(
	public val entityIds: List<String>,
)

public fun getInvoicesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoicesParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.getInvoices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getInvoicesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.getInvoices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterInvoicesByParams(
	public val filterChain: FilterChain<Invoice>,
)

public fun filterInvoicesByBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterInvoicesByParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.filterInvoicesBy(
			decodedParams.filterChain,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun filterInvoicesByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterInvoicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.filterInvoicesBy(
				decodedParams.filterChain,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindInvoicesByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findInvoicesByHcPartyPatientForeignKeysBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.findInvoicesByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findInvoicesByHcPartyPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.findInvoicesByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ReassignInvoiceParams(
	public val invoice: Invoice,
)

public fun reassignInvoiceBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ReassignInvoiceParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.reassignInvoice(
			decodedParams.invoice,
		)
	}
}.toPyString(InvoiceSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun reassignInvoiceAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ReassignInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.reassignInvoice(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(InvoiceSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MergeToParams(
	public val invoiceId: String,
	public val ids: List<String>,
)

public fun mergeToBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergeToParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.mergeTo(
			decodedParams.invoiceId,
			decodedParams.ids,
		)
	}
}.toPyString(InvoiceSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun mergeToAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergeToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.mergeTo(
				decodedParams.invoiceId,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(InvoiceSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ValidateParams(
	public val invoiceId: String,
	public val scheme: String,
	public val forcedValue: String,
)

public fun validateBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ValidateParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.validate(
			decodedParams.invoiceId,
			decodedParams.scheme,
			decodedParams.forcedValue,
		)
	}
}.toPyString(InvoiceSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun validateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ValidateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.validate(
				decodedParams.invoiceId,
				decodedParams.scheme,
				decodedParams.forcedValue,
			)
		}.toPyStringAsyncCallback(InvoiceSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AppendCodesParams(
	public val userId: String,
	public val type: String,
	public val sentMediumType: String,
	public val secretFKeys: String,
	public val insuranceId: String? = null,
	public val invoiceId: String? = null,
	public val gracePeriod: Int? = null,
	public val invoicingCodes: List<EncryptedInvoicingCode>,
)

public fun appendCodesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AppendCodesParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.appendCodes(
			decodedParams.userId,
			decodedParams.type,
			decodedParams.sentMediumType,
			decodedParams.secretFKeys,
			decodedParams.insuranceId,
			decodedParams.invoiceId,
			decodedParams.gracePeriod,
			decodedParams.invoicingCodes,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun appendCodesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AppendCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.appendCodes(
				decodedParams.userId,
				decodedParams.type,
				decodedParams.sentMediumType,
				decodedParams.secretFKeys,
				decodedParams.insuranceId,
				decodedParams.invoiceId,
				decodedParams.gracePeriod,
				decodedParams.invoicingCodes,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveCodesParams(
	public val userId: String,
	public val serviceId: String,
	public val secretFKeys: String,
	public val tarificationIds: List<String>,
)

public fun removeCodesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveCodesParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.removeCodes(
			decodedParams.userId,
			decodedParams.serviceId,
			decodedParams.secretFKeys,
			decodedParams.tarificationIds,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun removeCodesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.removeCodes(
				decodedParams.userId,
				decodedParams.serviceId,
				decodedParams.secretFKeys,
				decodedParams.tarificationIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindInvoicesByAuthorParams(
	public val hcPartyId: String,
	public val fromDate: Long? = null,
	public val toDate: Long? = null,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findInvoicesByAuthorBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByAuthorParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.findInvoicesByAuthor(
			decodedParams.hcPartyId,
			decodedParams.fromDate,
			decodedParams.toDate,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findInvoicesByAuthorAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByAuthorParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.findInvoicesByAuthor(
				decodedParams.hcPartyId,
				decodedParams.fromDate,
				decodedParams.toDate,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHCPartyAndPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun listInvoicesByHCPartyAndPatientForeignKeysBlocking(sdk: IcureApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHCPartyAndPatientForeignKeysParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listInvoicesByHCPartyAndPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHCPartyAndPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHCPartyAndPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listInvoicesByHCPartyAndPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHcPartyAndGroupIdParams(
	public val hcPartyId: String,
	public val groupId: String,
)

public fun listInvoicesByHcPartyAndGroupIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcPartyAndGroupIdParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listInvoicesByHcPartyAndGroupId(
			decodedParams.hcPartyId,
			decodedParams.groupId,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHcPartyAndGroupIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcPartyAndGroupIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listInvoicesByHcPartyAndGroupId(
				decodedParams.hcPartyId,
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams(
	public val hcPartyId: String,
	public val sentMediumType: MediumType,
	public val invoiceType: InvoiceType,
	public val sent: Boolean,
	public val from: Long? = null,
	public val to: Long? = null,
)

public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(sdk: IcureApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			decodedParams.hcPartyId,
			decodedParams.sentMediumType,
			decodedParams.invoiceType,
			decodedParams.sent,
			decodedParams.from,
			decodedParams.to,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
				decodedParams.hcPartyId,
				decodedParams.sentMediumType,
				decodedParams.invoiceType,
				decodedParams.sent,
				decodedParams.from,
				decodedParams.to,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByContactIdsParams(
	public val contactIds: List<String>,
)

public fun listInvoicesByContactIdsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByContactIdsParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listInvoicesByContactIds(
			decodedParams.contactIds,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByContactIdsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByContactIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listInvoicesByContactIds(
				decodedParams.contactIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByRecipientsIdsParams(
	public val recipientsIds: List<String>,
)

public fun listInvoicesByRecipientsIdsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByRecipientsIdsParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listInvoicesByRecipientsIds(
			decodedParams.recipientsIds,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByRecipientsIdsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByRecipientsIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listInvoicesByRecipientsIds(
				decodedParams.recipientsIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToInsurancesParams(
	public val userIds: List<String>,
)

public fun listToInsurancesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listToInsurances(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listToInsurancesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listToInsurances(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToInsurancesUnsentParams(
	public val userIds: List<String>,
)

public fun listToInsurancesUnsentBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesUnsentParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listToInsurancesUnsent(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listToInsurancesUnsentAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesUnsentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listToInsurancesUnsent(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToPatientsParams(
	public val hcPartyId: String,
)

public fun listToPatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listToPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listToPatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listToPatients(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToPatientsUnsentParams(
	public val hcPartyId: String?,
)

public fun listToPatientsUnsentBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsUnsentParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listToPatientsUnsent(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listToPatientsUnsentAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsUnsentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listToPatientsUnsent(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByIdsParams(
	public val ids: List<String>,
)

public fun listInvoicesByIdsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByIdsParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listInvoicesByIds(
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByIdsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listInvoicesByIds(
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHcpartySendingModeStatusDateParams(
	public val hcPartyId: String,
	public val sendingMode: String,
	public val status: String,
	public val from: Long,
	public val to: Long,
)

public fun listInvoicesByHcpartySendingModeStatusDateBlocking(sdk: IcureApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcpartySendingModeStatusDateParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
			decodedParams.hcPartyId,
			decodedParams.sendingMode,
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHcpartySendingModeStatusDateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcpartySendingModeStatusDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
				decodedParams.hcPartyId,
				decodedParams.sendingMode,
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByServiceIdsParams(
	public val serviceIds: List<String>,
)

public fun listInvoicesByServiceIdsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByServiceIdsParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listInvoicesByServiceIds(
			decodedParams.serviceIds,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByServiceIdsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByServiceIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listInvoicesByServiceIds(
				decodedParams.serviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListAllHcpsByStatusParams(
	public val status: String,
	public val from: Long? = null,
	public val to: Long? = null,
	public val hcpIds: List<String>,
)

public fun listAllHcpsByStatusBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListAllHcpsByStatusParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.listAllHcpsByStatus(
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
			decodedParams.hcpIds,
		)
	}
}.toPyString(ListSerializer(InvoiceSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listAllHcpsByStatusAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListAllHcpsByStatusParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.listAllHcpsByStatus(
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
				decodedParams.hcpIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(InvoiceSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
