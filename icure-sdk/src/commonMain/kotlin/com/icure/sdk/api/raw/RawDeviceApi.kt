package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.Device
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
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
class RawDeviceApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getDevice(deviceId: String): HttpResponse<Device> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device",deviceId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getDevices(deviceIds: ListOfIds): HttpResponse<List<Device>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceIds)
		}.wrap()


	suspend fun createDevice(p: Device): HttpResponse<Device> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(p)
		}.wrap()


	suspend fun updateDevice(deviceDto: Device): HttpResponse<Device> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDto)
		}.wrap()


	suspend fun createDevices(deviceDtos: List<Device>): HttpResponse<List<IdWithRev>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","bulk")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDtos)
		}.wrap()


	suspend fun updateDevices(deviceDtos: List<Device>): HttpResponse<List<IdWithRev>> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","bulk")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDtos)
		}.wrap()


	suspend fun filterDevicesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Device>,
	): HttpResponse<PaginatedList<Device, *>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()


	suspend fun getDeviceAesExchangeKeysForDelegate(deviceId: String):
			HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>
			= httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device",deviceId,"aesExchangeKeys")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun matchDevicesBy(filter: AbstractFilter<Device>): HttpResponse<List<String>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()


	suspend fun deleteDevice(deviceId: String): HttpResponse<DocIdentifier> =
			httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device",deviceId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun deleteDevices(deviceIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceIds)
		}.wrap()

	// endregion

	// region cloud endpoints

	suspend fun getDevicesInGroup(groupId: String, deviceIds: ListOfIds? = null):
			HttpResponse<List<Device>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","inGroup",groupId,"byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceIds)
		}.wrap()


	suspend fun modifyDeviceInGroup(groupId: String, deviceDto: Device): HttpResponse<Device> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","inGroup",groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDto)
		}.wrap()


	suspend fun createDeviceInGroup(groupId: String, deviceDto: Device): HttpResponse<Device> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","inGroup",groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDto)
		}.wrap()


	suspend fun deleteDevicesInGroup(groupId: String, deviceIds: String):
			HttpResponse<List<DocIdentifier>> = httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","device","inGroup",groupId,deviceIds)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion

}
