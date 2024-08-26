// auto-generated file
package com.icure.sdk.py.api.InvoiceBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
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
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
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
private class DeleteInvoiceParams(
	public val entityId: String,
)

public fun deleteInvoiceBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteInvoiceParams>(params)
	runBlocking {
		sdk.invoice.deleteInvoice(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteInvoiceAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.deleteInvoice(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindInvoicesDelegationsStubsByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeysBlocking(sdk: IcureBaseApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindInvoicesDelegationsStubsByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.invoice.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(IcureStub.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeysAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindInvoicesDelegationsStubsByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(IcureStub.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTarificationsCodesOccurrencesParams(
	public val minOccurrence: Int,
)

public fun getTarificationsCodesOccurrencesBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTarificationsCodesOccurrencesParams>(params)
	runBlocking {
		sdk.invoice.getTarificationsCodesOccurrences(
			decodedParams.minOccurrence,
		)
	}
}.toPyString(ListSerializer(LabelledOccurence.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getTarificationsCodesOccurrencesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTarificationsCodesOccurrencesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.getTarificationsCodesOccurrences(
				decodedParams.minOccurrence,
			)
		}.toPyStringAsyncCallback(ListSerializer(LabelledOccurence.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoiceParams(
	public val entity: EncryptedInvoice,
)

public fun modifyInvoiceBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoiceParams>(params)
	runBlocking {
		sdk.invoice.modifyInvoice(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyInvoiceAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.modifyInvoice(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoicesParams(
	public val entities: List<EncryptedInvoice>,
)

public fun modifyInvoicesBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoicesParams>(params)
	runBlocking {
		sdk.invoice.modifyInvoices(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyInvoicesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.modifyInvoices(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInvoiceParams(
	public val entityId: String,
)

public fun getInvoiceBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoiceParams>(params)
	runBlocking {
		sdk.invoice.getInvoice(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getInvoiceAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.getInvoice(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInvoicesParams(
	public val entityIds: List<String>,
)

public fun getInvoicesBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoicesParams>(params)
	runBlocking {
		sdk.invoice.getInvoices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getInvoicesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.getInvoices(
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

public fun findInvoicesByHcPartyPatientForeignKeysBlocking(sdk: IcureBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.invoice.findInvoicesByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findInvoicesByHcPartyPatientForeignKeysAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.findInvoicesByHcPartyPatientForeignKeys(
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

public fun reassignInvoiceBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ReassignInvoiceParams>(params)
	runBlocking {
		sdk.invoice.reassignInvoice(
			decodedParams.invoice,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun reassignInvoiceAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ReassignInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.reassignInvoice(
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

public fun mergeToBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergeToParams>(params)
	runBlocking {
		sdk.invoice.mergeTo(
			decodedParams.invoiceId,
			decodedParams.ids,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun mergeToAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergeToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.mergeTo(
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

public fun validateBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ValidateParams>(params)
	runBlocking {
		sdk.invoice.validate(
			decodedParams.invoiceId,
			decodedParams.scheme,
			decodedParams.forcedValue,
		)
	}
}.toPyString(EncryptedInvoice.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun validateAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ValidateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.validate(
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

public fun appendCodesBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AppendCodesParams>(params)
	runBlocking {
		sdk.invoice.appendCodes(
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
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AppendCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.appendCodes(
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

public fun removeCodesBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveCodesParams>(params)
	runBlocking {
		sdk.invoice.removeCodes(
			decodedParams.userId,
			decodedParams.serviceId,
			decodedParams.secretFKeys,
			decodedParams.tarificationIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun removeCodesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.removeCodes(
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

public fun findInvoicesByAuthorBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByAuthorParams>(params)
	runBlocking {
		sdk.invoice.findInvoicesByAuthor(
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
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindInvoicesByAuthorParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.findInvoicesByAuthor(
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

public fun listInvoicesByHCPartyAndPatientForeignKeysBlocking(sdk: IcureBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHCPartyAndPatientForeignKeysParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByHCPartyAndPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHCPartyAndPatientForeignKeysAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHCPartyAndPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByHCPartyAndPatientForeignKeys(
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

public fun listInvoicesByHcPartyAndGroupIdBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcPartyAndGroupIdParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByHcPartyAndGroupId(
			decodedParams.hcPartyId,
			decodedParams.groupId,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByHcPartyAndGroupIdAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcPartyAndGroupIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByHcPartyAndGroupId(
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

public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(sdk: IcureBaseApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
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
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
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

public fun listInvoicesByContactIdsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByContactIdsParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByContactIds(
			decodedParams.contactIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByContactIdsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByContactIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByContactIds(
				decodedParams.contactIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByRecipientsIdsParams(
	public val recipientsIds: List<String>,
)

public fun listInvoicesByRecipientsIdsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByRecipientsIdsParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByRecipientsIds(
			decodedParams.recipientsIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByRecipientsIdsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByRecipientsIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByRecipientsIds(
				decodedParams.recipientsIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToInsurancesParams(
	public val userIds: List<String>,
)

public fun listToInsurancesBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesParams>(params)
	runBlocking {
		sdk.invoice.listToInsurances(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listToInsurancesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listToInsurances(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToInsurancesUnsentParams(
	public val userIds: List<String>,
)

public fun listToInsurancesUnsentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesUnsentParams>(params)
	runBlocking {
		sdk.invoice.listToInsurancesUnsent(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listToInsurancesUnsentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToInsurancesUnsentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listToInsurancesUnsent(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToPatientsParams(
	public val hcPartyId: String,
)

public fun listToPatientsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsParams>(params)
	runBlocking {
		sdk.invoice.listToPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listToPatientsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listToPatients(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToPatientsUnsentParams(
	public val hcPartyId: String?,
)

public fun listToPatientsUnsentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsUnsentParams>(params)
	runBlocking {
		sdk.invoice.listToPatientsUnsent(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listToPatientsUnsentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListToPatientsUnsentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listToPatientsUnsent(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByIdsParams(
	public val ids: List<String>,
)

public fun listInvoicesByIdsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByIdsParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByIds(
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByIdsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByIds(
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

public fun listInvoicesByHcpartySendingModeStatusDateBlocking(sdk: IcureBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcpartySendingModeStatusDateParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByHcpartySendingModeStatusDate(
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
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByHcpartySendingModeStatusDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByHcpartySendingModeStatusDate(
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

public fun listInvoicesByServiceIdsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByServiceIdsParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByServiceIds(
			decodedParams.serviceIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listInvoicesByServiceIdsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListInvoicesByServiceIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByServiceIds(
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

public fun listAllHcpsByStatusBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListAllHcpsByStatusParams>(params)
	runBlocking {
		sdk.invoice.listAllHcpsByStatus(
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
			decodedParams.hcpIds,
		)
	}
}.toPyString(ListSerializer(EncryptedInvoice.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listAllHcpsByStatusAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListAllHcpsByStatusParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listAllHcpsByStatus(
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
				decodedParams.hcpIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
