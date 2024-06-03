package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawTmpApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.EntityTemplate
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.ReplicatorDocument
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import kotlinx.serialization.json.Json
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawTmpApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawTmpApi {
	// region cloud endpoints

	override suspend fun createTmpDatabase(): HttpResponse<Unit> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun destroyTmpDatabase(): HttpResponse<Unit> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp")
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun replicateToTmpDatabase(
		from: String,
		ids: List<String>,
	): HttpResponse<ReplicatorDocument> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "replicate", "from", from)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun getTmpPatient(id: String): HttpResponse<EncryptedPatient> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpPatient(c: EncryptedPatient): HttpResponse<EncryptedPatient> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpPatient(patientDto: EncryptedPatient): HttpResponse<EncryptedPatient> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDto)
		}.wrap()

	override suspend fun getTmpPatients(ids: List<String>): HttpResponse<List<EncryptedPatient>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun createTmpPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun listTmpPatients(
		firstPatientId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "list")
				parameter("firstPatientId", firstPatientId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpHealthElement(id: String): HttpResponse<EncryptedHealthElement> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpHealthElement(c: EncryptedHealthElement): HttpResponse<EncryptedHealthElement> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpHealthElement(healthElementDto: EncryptedHealthElement): HttpResponse<EncryptedHealthElement> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDto)
		}.wrap()

	override suspend fun getTmpHealthElements(ids: List<String>): HttpResponse<List<EncryptedHealthElement>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpHealthElements(
		healthElementDtos: List<EncryptedHealthElement>,
	): HttpResponse<List<EncryptedHealthElement>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun createTmpHealthElements(
		healthElementDtos: List<EncryptedHealthElement>,
	): HttpResponse<List<EncryptedHealthElement>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun listTmpHealthElements(
		firstHealthElementId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedHealthElement>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "list")
				parameter("firstHealthElementId", firstHealthElementId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpForm(id: String): HttpResponse<EncryptedForm> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpForm(c: EncryptedForm): HttpResponse<EncryptedForm> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpForm(formDto: EncryptedForm): HttpResponse<EncryptedForm> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDto)
		}.wrap()

	override suspend fun getTmpForms(ids: List<String>): HttpResponse<List<EncryptedForm>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDtos)
		}.wrap()

	override suspend fun createTmpForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDtos)
		}.wrap()

	override suspend fun listTmpForms(
		firstFormId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedForm>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "list")
				parameter("firstFormId", firstFormId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpContact(id: String): HttpResponse<EncryptedContact> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpContact(c: EncryptedContact): HttpResponse<EncryptedContact> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpContact(contactDto: EncryptedContact): HttpResponse<EncryptedContact> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDto)
		}.wrap()

	override suspend fun getTmpContacts(ids: List<String>): HttpResponse<List<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun createTmpContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun listTmpContacts(
		firstContactId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "list")
				parameter("firstContactId", firstContactId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpMessage(id: String): HttpResponse<EncryptedMessage> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpMessage(c: EncryptedMessage): HttpResponse<EncryptedMessage> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun getTmpMessages(ids: List<String>): HttpResponse<List<EncryptedMessage>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpMessages(messageDtos: List<EncryptedMessage>): HttpResponse<List<EncryptedMessage>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDtos)
		}.wrap()

	override suspend fun createTmpMessages(messageDtos: List<EncryptedMessage>): HttpResponse<List<EncryptedMessage>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDtos)
		}.wrap()

	override suspend fun listTmpMessages(
		firstMessageId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "list")
				parameter("firstMessageId", firstMessageId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpInvoice(id: String): HttpResponse<EncryptedInvoice> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpInvoice(c: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDto)
		}.wrap()

	override suspend fun getTmpInvoices(ids: List<String>): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDtos)
		}.wrap()

	override suspend fun createTmpInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDtos)
		}.wrap()

	override suspend fun listTmpInvoices(
		firstInvoiceId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedInvoice>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "list")
				parameter("firstInvoiceId", firstInvoiceId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpDocument(id: String): HttpResponse<EncryptedDocument> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpDocumentAttachment(
		documentId: String,
		attachmentId: String,
		enckeys: String?,
		fileName: String?,
	): HttpResponse<ByteArray> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", documentId, "attachment", attachmentId)
				parameter("enckeys", enckeys)
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.OctetStream)
		}.wrap()

	override suspend fun deleteTmpDocumentAttachment(documentId: String): HttpResponse<EncryptedDocument> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", documentId, "attachment")
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun setTmpDocumentAttachment(
		documentId: String,
		enckeys: String?,
		payload: ByteArray,
	): HttpResponse<EncryptedDocument> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", documentId, "attachment")
				parameter("enckeys", enckeys)
			}
			setAuthorizationWith(authService)
			contentType(Application.OctetStream)
			accept(Application.Json)
			setBody(ByteReadChannel(payload))
		}.wrap()

	override suspend fun createTmpDocument(c: EncryptedDocument): HttpResponse<EncryptedDocument> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpDocument(documentDto: EncryptedDocument): HttpResponse<EncryptedDocument> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDto)
		}.wrap()

	override suspend fun getTmpDocuments(ids: List<String>): HttpResponse<List<EncryptedDocument>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun createTmpDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun listTmpDocuments(
		firstDocumentId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedDocument>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "list")
				parameter("firstDocumentId", firstDocumentId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpClassification(id: String): HttpResponse<EncryptedClassification> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpClassification(c: EncryptedClassification): HttpResponse<EncryptedClassification> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpClassification(classificationDto: EncryptedClassification): HttpResponse<EncryptedClassification> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationDto)
		}.wrap()

	override suspend fun getTmpClassifications(ids: List<String>): HttpResponse<List<EncryptedClassification>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpClassifications(
		classificationDtos: List<EncryptedClassification>,
	): HttpResponse<List<EncryptedClassification>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationDtos)
		}.wrap()

	override suspend fun createTmpClassifications(
		classificationDtos: List<EncryptedClassification>,
	): HttpResponse<List<EncryptedClassification>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationDtos)
		}.wrap()

	override suspend fun listTmpClassifications(
		firstClassificationId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedClassification>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "list")
				parameter("firstClassificationId", firstClassificationId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpEntityTemplate(id: String): HttpResponse<EntityTemplate> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpEntityTemplate(c: EntityTemplate): HttpResponse<EntityTemplate> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpEntityTemplate(entityTemplateDto: EntityTemplate): HttpResponse<EntityTemplate> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDto)
		}.wrap()

	override suspend fun getTmpEntityTemplates(ids: List<String>): HttpResponse<List<EntityTemplate>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "get")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyTmpEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()

	override suspend fun createTmpEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()

	override suspend fun listTmpEntityTemplates(
		firstEntityTemplateId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EntityTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "list")
				parameter("firstEntityTemplateId", firstEntityTemplateId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteTmpItems(ids: List<String>): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "batch", "delete")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun purgeTmpItems(ids: List<String>): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "batch", "purge")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	// endregion
}
