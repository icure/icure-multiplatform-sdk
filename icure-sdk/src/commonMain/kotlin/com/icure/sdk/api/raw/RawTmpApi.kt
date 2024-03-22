package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.Classification
import com.icure.sdk.model.Contact
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.EntityTemplate
import com.icure.sdk.model.Form
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.Message
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.ReplicatorDocument
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.delete
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import kotlin.ByteArray
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawTmpApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region cloud endpoints

	suspend fun createTmpDatabase(): HttpResponse<Unit> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun destroyTmpDatabase(): HttpResponse<Unit> = httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp")
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun replicateToTmpDatabase(from: String, ids: List<String>):
			HttpResponse<ReplicatorDocument> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","replicate","from",from)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun getTmpPatient(id: String): HttpResponse<EncryptedPatient> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","patient","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createTmpPatient(c: Patient): HttpResponse<EncryptedPatient> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","patient")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpPatient(patientDto: Patient): HttpResponse<EncryptedPatient> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","patient")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientDto)
		}.wrap()


	suspend fun getTmpPatients(ids: List<String>): HttpResponse<List<EncryptedPatient>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","patient","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpPatients(patientDtos: List<Patient>):
			HttpResponse<List<EncryptedPatient>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","patient","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientDtos)
		}.wrap()


	suspend fun createTmpPatients(patientDtos: List<Patient>):
			HttpResponse<List<EncryptedPatient>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","patient","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientDtos)
		}.wrap()


	suspend fun listTmpPatients(firstPatientId: String? = null, pageSize: Int? = null):
			HttpResponse<PaginatedList<EncryptedPatient, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","patient","list")
				parameter("firstPatientId", firstPatientId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpHealthElement(id: String): HttpResponse<EncryptedHealthElement> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","healthElement","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createTmpHealthElement(c: HealthElement): HttpResponse<EncryptedHealthElement> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","healthElement")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpHealthElement(healthElementDto: HealthElement):
			HttpResponse<EncryptedHealthElement> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","healthElement")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthElementDto)
		}.wrap()


	suspend fun getTmpHealthElements(ids: List<String>):
			HttpResponse<List<EncryptedHealthElement>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","healthElement","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpHealthElements(healthElementDtos: List<HealthElement>):
			HttpResponse<List<EncryptedHealthElement>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","healthElement","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthElementDtos)
		}.wrap()


	suspend fun createTmpHealthElements(healthElementDtos: List<HealthElement>):
			HttpResponse<List<EncryptedHealthElement>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","healthElement","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthElementDtos)
		}.wrap()


	suspend fun listTmpHealthElements(firstHealthElementId: String? = null, pageSize: Int? =
			null): HttpResponse<PaginatedList<EncryptedHealthElement, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","healthElement","list")
				parameter("firstHealthElementId", firstHealthElementId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpForm(id: String): HttpResponse<EncryptedForm> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","form","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createTmpForm(c: Form): HttpResponse<EncryptedForm> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","form")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpForm(formDto: Form): HttpResponse<EncryptedForm> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","form")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formDto)
		}.wrap()


	suspend fun getTmpForms(ids: List<String>): HttpResponse<List<EncryptedForm>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","form","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpForms(formDtos: List<Form>): HttpResponse<List<EncryptedForm>> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","form","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formDtos)
		}.wrap()


	suspend fun createTmpForms(formDtos: List<Form>): HttpResponse<List<EncryptedForm>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","form","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formDtos)
		}.wrap()


	suspend fun listTmpForms(firstFormId: String? = null, pageSize: Int? = null):
			HttpResponse<PaginatedList<EncryptedForm, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","form","list")
				parameter("firstFormId", firstFormId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpContact(id: String): HttpResponse<EncryptedContact> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","contact","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createTmpContact(c: Contact): HttpResponse<EncryptedContact> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","contact")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpContact(contactDto: Contact): HttpResponse<EncryptedContact> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","contact")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDto)
		}.wrap()


	suspend fun getTmpContacts(ids: List<String>): HttpResponse<List<EncryptedContact>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","contact","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpContacts(contactDtos: List<Contact>):
			HttpResponse<List<EncryptedContact>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","contact","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDtos)
		}.wrap()


	suspend fun createTmpContacts(contactDtos: List<Contact>):
			HttpResponse<List<EncryptedContact>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","contact","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDtos)
		}.wrap()


	suspend fun listTmpContacts(firstContactId: String? = null, pageSize: Int? = null):
			HttpResponse<PaginatedList<EncryptedContact, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","contact","list")
				parameter("firstContactId", firstContactId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpMessage(id: String): HttpResponse<EncryptedMessage> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","message","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createTmpMessage(c: Message): HttpResponse<EncryptedMessage> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","message")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpMessage(messageDto: Message): HttpResponse<EncryptedMessage> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","message")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(messageDto)
		}.wrap()


	suspend fun getTmpMessages(ids: List<String>): HttpResponse<List<EncryptedMessage>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","message","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpMessages(messageDtos: List<Message>):
			HttpResponse<List<EncryptedMessage>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","message","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(messageDtos)
		}.wrap()


	suspend fun createTmpMessages(messageDtos: List<Message>):
			HttpResponse<List<EncryptedMessage>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","message","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(messageDtos)
		}.wrap()


	suspend fun listTmpMessages(firstMessageId: String? = null, pageSize: Int? = null):
			HttpResponse<PaginatedList<EncryptedInvoice, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","message","list")
				parameter("firstMessageId", firstMessageId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpInvoice(id: String): HttpResponse<EncryptedInvoice> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","invoice","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createTmpInvoice(c: Invoice): HttpResponse<EncryptedInvoice> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","invoice")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpInvoice(invoiceDto: Invoice): HttpResponse<EncryptedInvoice> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","invoice")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceDto)
		}.wrap()


	suspend fun getTmpInvoices(ids: List<String>): HttpResponse<List<EncryptedInvoice>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","invoice","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpInvoices(invoiceDtos: List<Invoice>):
			HttpResponse<List<EncryptedInvoice>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","invoice","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceDtos)
		}.wrap()


	suspend fun createTmpInvoices(invoiceDtos: List<Invoice>):
			HttpResponse<List<EncryptedInvoice>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","invoice","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(invoiceDtos)
		}.wrap()


	suspend fun listTmpInvoices(firstInvoiceId: String? = null, pageSize: Int? = null):
			HttpResponse<PaginatedList<EncryptedInvoice, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","invoice","list")
				parameter("firstInvoiceId", firstInvoiceId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpDocument(id: String): HttpResponse<EncryptedDocument> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpDocumentAttachment(
		documentId: String,
		attachmentId: String,
		enckeys: String? = null,
		fileName: String? = null,
	): HttpResponse<ByteArray> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document",documentId,"attachment",attachmentId)
				parameter("enckeys", enckeys)
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun deleteTmpDocumentAttachment(documentId: String): HttpResponse<EncryptedDocument>
			= httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document",documentId,"attachment")
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun setTmpDocumentAttachment(
		documentId: String,
		enckeys: String? = null,
		payload: ByteArray,
	): HttpResponse<EncryptedDocument> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document",documentId,"attachment")
				parameter("enckeys", enckeys)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.OctetStream)
			setBody(ByteReadChannel(payload))
		}.wrap()


	suspend fun createTmpDocument(c: Document): HttpResponse<EncryptedDocument> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpDocument(documentDto: Document): HttpResponse<EncryptedDocument> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentDto)
		}.wrap()


	suspend fun getTmpDocuments(ids: List<String>): HttpResponse<List<EncryptedDocument>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpDocuments(documentDtos: List<Document>):
			HttpResponse<List<EncryptedDocument>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentDtos)
		}.wrap()


	suspend fun createTmpDocuments(documentDtos: List<Document>):
			HttpResponse<List<EncryptedDocument>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentDtos)
		}.wrap()


	suspend fun listTmpDocuments(firstDocumentId: String? = null, pageSize: Int? = null):
			HttpResponse<PaginatedList<EncryptedDocument, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","document","list")
				parameter("firstDocumentId", firstDocumentId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpClassification(id: String): HttpResponse<EncryptedClassification> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","classification","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createTmpClassification(c: Classification):
			HttpResponse<EncryptedClassification> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","classification")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpClassification(classificationDto: Classification):
			HttpResponse<EncryptedClassification> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","classification")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(classificationDto)
		}.wrap()


	suspend fun getTmpClassifications(ids: List<String>):
			HttpResponse<List<EncryptedClassification>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","classification","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpClassifications(classificationDtos: List<Classification>):
			HttpResponse<List<EncryptedClassification>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","classification","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(classificationDtos)
		}.wrap()


	suspend fun createTmpClassifications(classificationDtos: List<Classification>):
			HttpResponse<List<EncryptedClassification>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","classification","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(classificationDtos)
		}.wrap()


	suspend fun listTmpClassifications(firstClassificationId: String? = null, pageSize: Int? =
			null): HttpResponse<PaginatedList<EncryptedClassification, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","classification","list")
				parameter("firstClassificationId", firstClassificationId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTmpEntityTemplate(id: String): HttpResponse<EntityTemplate> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","entityTemplate","byId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createTmpEntityTemplate(c: EntityTemplate): HttpResponse<EntityTemplate> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","entityTemplate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun modifyTmpEntityTemplate(entityTemplateDto: EntityTemplate):
			HttpResponse<EntityTemplate> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","entityTemplate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(entityTemplateDto)
		}.wrap()


	suspend fun getTmpEntityTemplates(ids: List<String>): HttpResponse<List<EntityTemplate>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","entityTemplate","get")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun modifyTmpEntityTemplates(entityTemplateDtos: List<EntityTemplate>):
			HttpResponse<List<EntityTemplate>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","entityTemplate","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()


	suspend fun createTmpEntityTemplates(entityTemplateDtos: List<EntityTemplate>):
			HttpResponse<List<EntityTemplate>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","entityTemplate","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()


	suspend fun listTmpEntityTemplates(firstEntityTemplateId: String? = null, pageSize: Int? =
			null): HttpResponse<PaginatedList<EntityTemplate, Nothing>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","entityTemplate","list")
				parameter("firstEntityTemplateId", firstEntityTemplateId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun deleteTmpItems(ids: List<String>): HttpResponse<List<DocIdentifier>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","batch","delete")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun purgeTmpItems(ids: List<String>): HttpResponse<List<DocIdentifier>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","tmp","batch","purge")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()

	// endregion

}
