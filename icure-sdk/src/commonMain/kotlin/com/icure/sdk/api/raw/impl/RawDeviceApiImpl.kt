package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawDeviceApi
import com.icure.sdk.api.raw.wrap
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
import com.icure.sdk.serialization.DeviceAbstractFilterSerializer
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawDeviceApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawDeviceApi {
	// region common endpoints

	override suspend fun getDevice(deviceId: String): HttpResponse<Device> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", deviceId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getDevices(deviceIds: ListOfIds): HttpResponse<List<Device>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun createDevice(p: Device): HttpResponse<Device> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(p)
		}.wrap()

	override suspend fun updateDevice(deviceDto: Device): HttpResponse<Device> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDto)
		}.wrap()

	override suspend fun createDevices(deviceDtos: List<Device>): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "bulk")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDtos)
		}.wrap()

	override suspend fun updateDevices(deviceDtos: List<Device>): HttpResponse<List<IdWithRev>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "bulk")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDtos)
		}.wrap()

	override suspend fun filterDevicesBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<Device>,
	): HttpResponse<PaginatedList<Device>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	override suspend fun getDeviceAesExchangeKeysForDelegate(
		deviceId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", deviceId, "aesExchangeKeys")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun matchDevicesBy(filter: AbstractFilter<Device>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBodyWithSerializer(DeviceAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun deleteDevice(deviceId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", deviceId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun deleteDevices(deviceIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceIds)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getDevicesInGroup(
		groupId: String,
		deviceIds: ListOfIds?,
	): HttpResponse<List<Device>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun modifyDeviceInGroup(
		groupId: String,
		deviceDto: Device,
	): HttpResponse<Device> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDto)
		}.wrap()

	override suspend fun createDeviceInGroup(
		groupId: String,
		deviceDto: Device,
	): HttpResponse<Device> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(deviceDto)
		}.wrap()

	override suspend fun deleteDevicesInGroup(
		groupId: String,
		deviceIds: String,
	): HttpResponse<List<DocIdentifier>> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, deviceIds)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion
}
