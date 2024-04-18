package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawInvoiceApi(
	private val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout) {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Invoice)

	// region common endpoints

	suspend fun createInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceDto)
		}.wrap()

	suspend fun deleteInvoice(invoiceId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", invoiceId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getInvoice(invoiceId: String): HttpResponse<EncryptedInvoice> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", invoiceId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getInvoices(invoiceIds: ListOfIds): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceIds)
		}.wrap()

	suspend fun modifyInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceDto)
		}.wrap()

	suspend fun reassignInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "reassign")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceDto)
		}.wrap()

	suspend fun mergeTo(
		invoiceId: String,
		ids: ListOfIds,
	): HttpResponse<EncryptedInvoice> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "mergeTo", invoiceId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()

	suspend fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): HttpResponse<EncryptedInvoice> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "validate", invoiceId)
				parameter("scheme", scheme)
				parameter("forcedValue", forcedValue)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String? = null,
		invoiceId: String? = null,
		gracePeriod: Int? = null,
		invoicingCodes: List<EncryptedInvoicingCode>,
	): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byauthor", userId, "append", type, sentMediumType)
				parameter("secretFKeys", secretFKeys)
				parameter("insuranceId", insuranceId)
				parameter("invoiceId", invoiceId)
				parameter("gracePeriod", gracePeriod)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoicingCodes)
		}.wrap()

	suspend fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: List<String>,
	): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byauthor", userId, "service", serviceId)
				parameter("secretFKeys", secretFKeys)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(tarificationIds)
		}.wrap()

	suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long? = null,
		toDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byauthor", hcPartyId)
				parameter("fromDate", fromDate)
				parameter("toDate", toDate)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listInvoicesByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun findInvoicesByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	suspend fun listInvoicesDelegationsStubsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<IcureStub>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listInvoiceIdsByDataOwnerPatientInvoiceDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byDataOwnerPatientInvoiceDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	suspend fun findInvoicesDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	suspend fun listInvoicesByHcPartyAndGroupId(
		hcPartyId: String,
		groupId: String,
	): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartyGroupId", hcPartyId, groupId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long? = null,
		to: Long? = null,
	): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments(
					"rest",
					"v2",
					"invoice",
					"byHcParty",
					hcPartyId,
					"mediumType",
					"$sentMediumType",
					"invoiceType",
					"$invoiceType",
					"sent",
					"$sent",
				)
				parameter("from", from)
				parameter("to", to)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listInvoicesByContactIds(contactIds: ListOfIds): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byContacts")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactIds)
		}.wrap()

	suspend fun listInvoicesByRecipientsIds(recipientIds: String): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "to", recipientIds)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listToInsurances(userIds: String? = null): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "toInsurances")
				parameter("userIds", userIds)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listToInsurancesUnsent(userIds: String? = null): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "toInsurances", "unsent")
				parameter("userIds", userIds)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listToPatients(hcPartyId: String? = null): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "toPatients")
				parameter("hcPartyId", hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listToPatientsUnsent(hcPartyId: String? = null): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "toPatients", "unsent")
				parameter("hcPartyId", hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listInvoicesByIds(invoiceIds: String): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byIds", invoiceIds)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String? = null,
		status: String? = null,
		from: Long? = null,
		to: Long? = null,
	): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcpartySendingModeStatusDate", hcPartyId)
				parameter("sendingMode", sendingMode)
				parameter("status", status)
				parameter("from", from)
				parameter("to", to)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listInvoicesByServiceIds(serviceIds: String): HttpResponse<List<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byServiceIds", serviceIds)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listAllHcpsByStatus(
		status: String,
		from: Long? = null,
		to: Long? = null,
		hcpIds: ListOfIds,
	): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "allHcpsByStatus", status)
				parameter("from", from)
				parameter("to", to)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(hcpIds)
		}.wrap()

	suspend fun getTarificationsCodesOccurrences(minOccurrences: Long): HttpResponse<List<LabelledOccurence>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "codes", "$minOccurrences")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun filterInvoicesBy(filterChain: FilterChain<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "filter")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	suspend fun modifyInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceDtos)
		}.wrap()

	suspend fun createInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceDtos)
		}.wrap()

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedInvoice>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedInvoice>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
