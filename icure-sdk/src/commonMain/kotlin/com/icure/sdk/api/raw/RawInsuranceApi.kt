package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.Insurance
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.JsonString
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
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawInsuranceApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getAllInsurances(startDocumentId: String? = null, limit: Int? = null):
			HttpResponse<PaginatedList<Insurance, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","insurance")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createInsurance(insuranceDto: Insurance): HttpResponse<Insurance> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","insurance")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(insuranceDto)
		}.wrap()


	suspend fun deleteInsurance(insuranceId: String): HttpResponse<DocIdentifier> =
			httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","insurance",insuranceId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getInsurance(insuranceId: String): HttpResponse<Insurance> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","insurance",insuranceId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getInsurances(insuranceIds: ListOfIds): HttpResponse<List<Insurance>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","insurance","byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(insuranceIds)
		}.wrap()


	suspend fun listInsurancesByCode(insuranceCode: String): HttpResponse<List<Insurance>> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","insurance","byCode",insuranceCode)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listInsurancesByName(insuranceName: String): HttpResponse<List<Insurance>> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","insurance","byName",insuranceName)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyInsurance(insuranceDto: Insurance): HttpResponse<Insurance> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","insurance")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(insuranceDto)
		}.wrap()

	// endregion

}