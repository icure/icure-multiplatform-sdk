package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerWithType
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod

class RawDataownerApi(
	baseUrl: String,
	authService: AuthService
) : ApiClient(baseUrl, authService) {

	/**
	 * Get the data owner corresponding to the current user
	 * &lt;strong&gt;Access Control Policies&lt;/strong&gt;: CanAccessAsHcp OR CanAccessAsAdmin OR CanAccessAsLoggedUser&lt;br&gt;General information about the current data owner&lt;br&gt;
	 * @return GetDataOwner200Response
	 */
	suspend fun getCurrentDataOwner(): HttpResponse<DataOwnerWithType> {

		val localVariableAuthNames = listOf<String>()

		val localVariableBody =
			io.ktor.client.utils.EmptyContent

		val localVariableQuery = mutableMapOf<String, List<String>>()
		val localVariableHeaders = mutableMapOf<String, String>()

		val localVariableConfig = RequestConfig<kotlin.Any?>(
			RequestMethod.GET,
			"/rest/v2/dataowner/current",
			query = localVariableQuery,
			headers = localVariableHeaders,
			requiresAuthentication = false,
		)

		return request(
			localVariableConfig,
			localVariableBody
		).wrap()
	}


	/**
	 * Get a data owner by his ID
	 * &lt;strong&gt;Access Control Policies&lt;/strong&gt;: (() OR CanAccessAsLoggedPatient OR CanAccessAsDelegate) AND (CanAccessAsHcp OR CanAccessAsResponsible) AND (CanAccessAsUser OR CanAccessAsHcp OR CanAccessAsAdmin)&lt;br&gt;General information about the data owner&lt;br&gt;
	 * @param dataOwnerId
	 * @return GetDataOwner200Response
	 */
	@Suppress("UNCHECKED_CAST")
	open suspend fun getDataOwner(dataOwnerId: kotlin.String): HttpResponse<DataOwnerWithType> {

		val localVariableAuthNames = listOf<String>()

		val localVariableBody =
			io.ktor.client.utils.EmptyContent

		val localVariableQuery = mutableMapOf<String, List<String>>()
		val localVariableHeaders = mutableMapOf<String, String>()

		val localVariableConfig = RequestConfig<kotlin.Any?>(
			RequestMethod.GET,
			"/rest/v2/dataowner/{dataOwnerId}".replace("{" + "dataOwnerId" + "}", "$dataOwnerId"),
			query = localVariableQuery,
			headers = localVariableHeaders,
			requiresAuthentication = false,
		)

		return request(
			localVariableConfig,
			localVariableBody,
		).wrap()
	}


	/**
	 * Get a data owner stub by his ID
	 * Key-related information about the data owner&lt;br&gt;
	 * @param dataOwnerId
	 * @return CryptoActorStubWithTypeDto
	 */
	@Suppress("UNCHECKED_CAST")
	open suspend fun getDataOwnerStub(dataOwnerId: kotlin.String): HttpResponse<CryptoActorStubWithType> {

		val localVariableAuthNames = listOf<String>()

		val localVariableBody =
			io.ktor.client.utils.EmptyContent

		val localVariableQuery = mutableMapOf<String, List<String>>()
		val localVariableHeaders = mutableMapOf<String, String>()

		val localVariableConfig = RequestConfig<kotlin.Any?>(
			RequestMethod.GET,
			"/rest/v2/dataowner/stub/{dataOwnerId}".replace("{" + "dataOwnerId" + "}", "$dataOwnerId"),
			query = localVariableQuery,
			headers = localVariableHeaders,
			requiresAuthentication = false,
		)

		return request(
			localVariableConfig,
			localVariableBody,
		).wrap()
	}


	/**
	 * Update key-related information of a data owner
	 * Updates information such as the public keys of a data owner or aes exchange keys&lt;br&gt;
	 * @param cryptoActorStubWithTypeDto
	 * @return CryptoActorStubWithTypeDto
	 */
	@Suppress("UNCHECKED_CAST")
	open suspend fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): HttpResponse<CryptoActorStubWithType> {

		val localVariableAuthNames = listOf<String>()

		val localVariableBody = cryptoActorStubWithTypeDto

		val localVariableQuery = mutableMapOf<String, List<String>>()
		val localVariableHeaders = mutableMapOf<String, String>()

		val localVariableConfig = RequestConfig<kotlin.Any?>(
			RequestMethod.PUT,
			"/rest/v2/dataowner/stub",
			query = localVariableQuery,
			headers = localVariableHeaders,
			requiresAuthentication = false,
		)

		return jsonRequest(
			localVariableConfig,
			localVariableBody,
		).wrap()
	}


}
