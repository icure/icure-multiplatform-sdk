// auto-generated file
package com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.py.serialization.PatientSerializer
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.json
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
	public val invoice: EncryptedInvoice,
	public val options: InvoiceShareOptions? = null,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.invoice.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.invoice,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedInvoice.serializer()))

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
			sdk.invoice.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.invoice,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedInvoice.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val invoice: EncryptedInvoice,
	public val delegates: Map<String, InvoiceShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.invoice.encrypted.tryShareWithMany(
			decodedParams.invoice,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedInvoice.serializer()))

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
			sdk.invoice.encrypted.tryShareWithMany(
				decodedParams.invoice,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedInvoice.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val invoice: EncryptedInvoice,
	public val delegates: Map<String, InvoiceShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.invoice.encrypted.shareWithMany(
			decodedParams.invoice,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

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
			sdk.invoice.encrypted.shareWithMany(
				decodedParams.invoice,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedInvoice.serializer(), resultCallback)
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

public fun findInvoicesByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientParams>(params)
	runBlocking {
		sdk.invoice.encrypted.findInvoicesByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedInvoice.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun findInvoicesByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.findInvoicesByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedInvoice.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoiceParams(
	public val entity: EncryptedInvoice,
)

public fun modifyInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoiceParams>(params)
	runBlocking {
		sdk.invoice.encrypted.modifyInvoice(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.modifyInvoice(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoicesParams(
	public val entities: List<EncryptedInvoice>,
)

public fun modifyInvoicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoicesParams>(params)
	runBlocking {
		sdk.invoice.encrypted.modifyInvoices(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyInvoicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.modifyInvoices(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInvoiceParams(
	public val entityId: String,
)

public fun getInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoiceParams>(params)
	runBlocking {
		sdk.invoice.encrypted.getInvoice(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.getInvoice(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInvoicesParams(
	public val entityIds: List<String>,
)

public fun getInvoicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoicesParams>(params)
	runBlocking {
		sdk.invoice.encrypted.getInvoices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getInvoicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.getInvoices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindInvoicesByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findInvoicesByHcPartyPatientForeignKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.invoice.encrypted.findInvoicesByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findInvoicesByHcPartyPatientForeignKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.findInvoicesByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ReassignInvoiceParams(
	public val invoice: EncryptedInvoice,
)

public fun reassignInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ReassignInvoiceParams>(params)
	runBlocking {
		sdk.invoice.encrypted.reassignInvoice(
			decodedParams.invoice,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun reassignInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ReassignInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.reassignInvoice(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(EncryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MergeToParams(
	public val invoiceId: String,
	public val ids: List<String>,
)

public fun mergeToBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergeToParams>(params)
	runBlocking {
		sdk.invoice.encrypted.mergeTo(
			decodedParams.invoiceId,
			decodedParams.ids,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun mergeToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergeToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.mergeTo(
				decodedParams.invoiceId,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(EncryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ValidateParams(
	public val invoiceId: String,
	public val scheme: String,
	public val forcedValue: String,
)

public fun validateBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ValidateParams>(params)
	runBlocking {
		sdk.invoice.encrypted.validate(
			decodedParams.invoiceId,
			decodedParams.scheme,
			decodedParams.forcedValue,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun validateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ValidateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.validate(
				decodedParams.invoiceId,
				decodedParams.scheme,
				decodedParams.forcedValue,
			)
		}.toPyStringAsyncCallback(EncryptedInvoice.serializer(), resultCallback)
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

public fun appendCodesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AppendCodesParams>(params)
	runBlocking {
		sdk.invoice.encrypted.appendCodes(
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
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun appendCodesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AppendCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.appendCodes(
				decodedParams.userId,
				decodedParams.type,
				decodedParams.sentMediumType,
				decodedParams.secretFKeys,
				decodedParams.insuranceId,
				decodedParams.invoiceId,
				decodedParams.gracePeriod,
				decodedParams.invoicingCodes,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveCodesParams(
	public val userId: String,
	public val serviceId: String,
	public val secretFKeys: String,
	public val tarificationIds: List<String>,
)

public fun removeCodesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveCodesParams>(params)
	runBlocking {
		sdk.invoice.encrypted.removeCodes(
			decodedParams.userId,
			decodedParams.serviceId,
			decodedParams.secretFKeys,
			decodedParams.tarificationIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun removeCodesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.removeCodes(
				decodedParams.userId,
				decodedParams.serviceId,
				decodedParams.secretFKeys,
				decodedParams.tarificationIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
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

public fun findInvoicesByAuthorBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByAuthorParams>(params)
	runBlocking {
		sdk.invoice.encrypted.findInvoicesByAuthor(
			decodedParams.hcPartyId,
			decodedParams.fromDate,
			decodedParams.toDate,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findInvoicesByAuthorAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByAuthorParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.findInvoicesByAuthor(
				decodedParams.hcPartyId,
				decodedParams.fromDate,
				decodedParams.toDate,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHCPartyAndPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun listInvoicesByHCPartyAndPatientForeignKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHCPartyAndPatientForeignKeysParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listInvoicesByHCPartyAndPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHCPartyAndPatientForeignKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHCPartyAndPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listInvoicesByHCPartyAndPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHcPartyAndGroupIdParams(
	public val hcPartyId: String,
	public val groupId: String,
)

public fun listInvoicesByHcPartyAndGroupIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcPartyAndGroupIdParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listInvoicesByHcPartyAndGroupId(
			decodedParams.hcPartyId,
			decodedParams.groupId,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHcPartyAndGroupIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcPartyAndGroupIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listInvoicesByHcPartyAndGroupId(
				decodedParams.hcPartyId,
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
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

public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(sdk: CardinalApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			decodedParams.hcPartyId,
			decodedParams.sentMediumType,
			decodedParams.invoiceType,
			decodedParams.sent,
			decodedParams.from,
			decodedParams.to,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
				decodedParams.hcPartyId,
				decodedParams.sentMediumType,
				decodedParams.invoiceType,
				decodedParams.sent,
				decodedParams.from,
				decodedParams.to,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByContactIdsParams(
	public val contactIds: List<String>,
)

public fun listInvoicesByContactIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByContactIdsParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listInvoicesByContactIds(
			decodedParams.contactIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByContactIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByContactIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listInvoicesByContactIds(
				decodedParams.contactIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByRecipientsIdsParams(
	public val recipientsIds: List<String>,
)

public fun listInvoicesByRecipientsIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByRecipientsIdsParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listInvoicesByRecipientsIds(
			decodedParams.recipientsIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByRecipientsIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByRecipientsIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listInvoicesByRecipientsIds(
				decodedParams.recipientsIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToInsurancesParams(
	public val userIds: List<String>,
)

public fun listToInsurancesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listToInsurances(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listToInsurancesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listToInsurances(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToInsurancesUnsentParams(
	public val userIds: List<String>,
)

public fun listToInsurancesUnsentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesUnsentParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listToInsurancesUnsent(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listToInsurancesUnsentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesUnsentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listToInsurancesUnsent(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToPatientsParams(
	public val hcPartyId: String,
)

public fun listToPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listToPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listToPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listToPatients(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToPatientsUnsentParams(
	public val hcPartyId: String?,
)

public fun listToPatientsUnsentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsUnsentParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listToPatientsUnsent(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listToPatientsUnsentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsUnsentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listToPatientsUnsent(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByIdsParams(
	public val ids: List<String>,
)

public fun listInvoicesByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByIdsParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listInvoicesByIds(
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listInvoicesByIds(
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
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

public fun listInvoicesByHcpartySendingModeStatusDateBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcpartySendingModeStatusDateParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listInvoicesByHcpartySendingModeStatusDate(
			decodedParams.hcPartyId,
			decodedParams.sendingMode,
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHcpartySendingModeStatusDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcpartySendingModeStatusDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listInvoicesByHcpartySendingModeStatusDate(
				decodedParams.hcPartyId,
				decodedParams.sendingMode,
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByServiceIdsParams(
	public val serviceIds: List<String>,
)

public fun listInvoicesByServiceIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByServiceIdsParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listInvoicesByServiceIds(
			decodedParams.serviceIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByServiceIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByServiceIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listInvoicesByServiceIds(
				decodedParams.serviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListAllHcpsByStatusParams(
	public val status: String,
	public val from: Long? = null,
	public val to: Long? = null,
	public val hcpIds: List<String>,
)

public fun listAllHcpsByStatusBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListAllHcpsByStatusParams>(params)
	runBlocking {
		sdk.invoice.encrypted.listAllHcpsByStatus(
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
			decodedParams.hcpIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listAllHcpsByStatusAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListAllHcpsByStatusParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.encrypted.listAllHcpsByStatus(
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
				decodedParams.hcpIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
