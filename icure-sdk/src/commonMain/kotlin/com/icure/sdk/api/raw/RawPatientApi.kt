package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.model.embed.Content
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.delete
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawPatientApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region common endpoints

    suspend fun findPatientsByNameBirthSsinAuto(
        healthcarePartyId: String? = null,
        filterValue: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        sortDirection: SortDirection = SortDirection.Asc,
    ): HttpResponse<PaginatedList<EncryptedPatient, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "byNameBirthSsinAuto")
                parameter("healthcarePartyId", healthcarePartyId)
                parameter("filterValue", filterValue)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("sortDirection", sortDirection)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listPatientsOfHcParty(
        hcPartyId: String,
        sortField: String = "name",
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        sortDirection: SortDirection = SortDirection.Asc,
    ): HttpResponse<PaginatedList<EncryptedPatient, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "ofHcParty", hcPartyId)
                parameter("sortField", sortField)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("sortDirection", sortDirection)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listOfMergesAfter(date: Long): HttpResponse<List<EncryptedPatient>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "merges", "$date")
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findPatientsModifiedAfter(
        date: Long,
        startKey: Long? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedPatient, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "modifiedAfter", "$date")
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listPatientsByHcParty(
        hcPartyId: String,
        sortField: String = "name",
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        sortDirection: SortDirection = SortDirection.Asc,
    ): HttpResponse<PaginatedList<EncryptedPatient, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "hcParty", hcPartyId)
                parameter("sortField", sortField)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("sortDirection", sortDirection)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getPatientHcPartyKeysForDelegate(patientId: String): HttpResponse<Map<String, String>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", patientId, "keys")
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getPatientAesExchangeKeysForDelegate(
        patientId: String,
    ): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", patientId, "aesExchangeKeys")
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun countOfPatients(hcPartyId: String): HttpResponse<Content> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "hcParty", hcPartyId, "count")
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findPatientsByHealthcareParty(
        hcPartyId: String? = null,
        sortField: String = "name",
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        sortDirection: SortDirection = SortDirection.Asc,
    ): HttpResponse<PaginatedList<EncryptedPatient, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient")
                parameter("hcPartyId", hcPartyId)
                parameter("sortField", sortField)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("sortDirection", sortDirection)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findPatientsIdsByHealthcareParty(
        hcPartyId: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<String, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "byHcPartyId")
                parameter("hcPartyId", hcPartyId)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getPatientByExternalId(externalId: String): HttpResponse<EncryptedPatient> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "byExternalId", externalId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findPatientsByAccessLogUserAfterDate(
        userId: String,
        accessType: String? = null,
        startDate: Long? = null,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedPatient, Long>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "byAccess", userId)
                parameter("accessType", accessType)
                parameter("startDate", startDate)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun filterPatientsBy(
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        skip: Int? = null,
        sort: String? = null,
        desc: Boolean? = null,
        filterChain: FilterChain<EncryptedPatient>,
    ): HttpResponse<PaginatedList<EncryptedPatient, *>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "filter")
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("skip", skip)
                parameter("sort", sort)
                parameter("desc", desc)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(filterChain)
        }.wrap()

    suspend fun matchPatientsBy(filter: AbstractFilter<EncryptedPatient>): HttpResponse<List<String>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "match")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(filter)
        }.wrap()

    suspend fun fuzzySearch(
        firstName: String,
        lastName: String,
        dateOfBirth: Int? = null,
    ): HttpResponse<List<EncryptedPatient>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "fuzzy")
                parameter("firstName", firstName)
                parameter("lastName", lastName)
                parameter("dateOfBirth", dateOfBirth)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun createPatient(p: EncryptedPatient): HttpResponse<EncryptedPatient> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(p)
        }.wrap()

    suspend fun deletePatients(patientIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "delete", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(patientIds)
        }.wrap()

    suspend fun deletePatient(patientId: String): HttpResponse<DocIdentifier> =
        delete {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", patientId)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findDeletedPatients(
        startDate: Long,
        endDate: Long? = null,
        desc: Boolean? = null,
        startKey: Long? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedPatient, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "deleted", "byDate")
                parameter("startDate", startDate)
                parameter("endDate", endDate)
                parameter("desc", desc)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listDeletedPatientsByName(
        firstName: String? = null,
        lastName: String? = null,
    ): HttpResponse<List<EncryptedPatient>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "deleted", "by_name")
                parameter("firstName", firstName)
                parameter("lastName", lastName)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun undeletePatient(patientIds: String): HttpResponse<List<DocIdentifier>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "undelete", patientIds)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
        }.wrap()

    suspend fun getPatients(patientIds: ListOfIds): HttpResponse<List<EncryptedPatient>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "byIds")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(patientIds)
        }.wrap()

    suspend fun getPatient(patientId: String): HttpResponse<EncryptedPatient> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", patientId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getPatientByHealthcarePartyAndIdentifier(
        hcPartyId: String,
        id: String,
        system: String? = null,
    ): HttpResponse<EncryptedPatient> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", hcPartyId, id)
                parameter("system", system)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun createPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(patientDtos)
        }.wrap()

    suspend fun modifyPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(patientDtos)
        }.wrap()

    suspend fun modifyPatient(patientDto: EncryptedPatient): HttpResponse<EncryptedPatient> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(patientDto)
        }.wrap()

    suspend fun modifyPatientReferral(
        patientId: String,
        referralId: String,
        start: Long? = null,
        end: Long? = null,
    ): HttpResponse<EncryptedPatient> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", patientId, "referral", referralId)
                parameter("start", start)
                parameter("end", end)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
        }.wrap()

    suspend fun findDuplicatesBySsin(
        hcPartyId: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedPatient, JsonString>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "duplicates", "ssin")
                parameter("hcPartyId", hcPartyId)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
        }.wrap()

    suspend fun findDuplicatesByName(
        hcPartyId: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedPatient, JsonString>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "duplicates", "name")
                parameter("hcPartyId", hcPartyId)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
        }.wrap()

    suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "bulkSharedMetadataUpdate")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(request)
        }.wrap()

    suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "bulkSharedMetadataUpdateMinimal")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(request)
        }.wrap()

    suspend fun mergePatients(
        intoId: String,
        fromId: String,
        expectedFromRev: String,
        updatedInto: EncryptedPatient,
    ): HttpResponse<EncryptedPatient> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "mergeInto", intoId, "from", fromId)
                parameter("expectedFromRev", expectedFromRev)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(updatedInto)
        }.wrap()

    // endregion

    // region cloud endpoints

    suspend fun registerPatient(
        hcPartyId: String,
        groupId: String,
        token: String? = null,
        useShortToken: Boolean? = null,
        createAutoDelegation: Boolean = true,
        p: EncryptedPatient,
    ): HttpResponse<DataOwnerRegistrationSuccess> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "patient", "register", "forHcp", hcPartyId, "inGroup", groupId)
                parameter("token", token)
                parameter("useShortToken", useShortToken)
                parameter("createAutoDelegation", createAutoDelegation)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(p)
        }.wrap()

    // endregion
}
