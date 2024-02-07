package com.icure.sdk.api.raw

import com.icure.sdk.model.ExchangeDataMap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.model.ExchangeDataMapCreationBatch
import com.icure.sdk.model.ListOfIds
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod

class RawExchangeDataMapApi(
    baseUrl: String,
    authService: AuthService<*>
) : ApiClient(baseUrl, authService) {

    /**
     * 
     * Creates a new Exchange Data Map&lt;br&gt;
     * @param exchangeDataMapDto 
     * @return ExchangeDataMap
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun createExchangeDataMap(exchangeDataMapDto: ExchangeDataMap): HttpResponse<ExchangeDataMap> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = exchangeDataMapDto

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<Any?>(
            RequestMethod.POST,
            "/rest/v2/exchangedatamap",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
        ).wrap()
    }



    /**
     * 
     * Creates a new Exchange Data Map batch, updating the ones that already exist&lt;br&gt;
     * @param exchangeDataMapCreationBatch 
     * @return kotlin.String
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun createOrUpdateExchangeDataMapBatch(exchangeDataMapCreationBatch: ExchangeDataMapCreationBatch): HttpResponse<kotlin.String> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = exchangeDataMapCreationBatch

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.PUT,
            "/rest/v2/exchangedatamap/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
        ).wrap()
    }



    /**
     * 
     * Retrieves an existing Exchange Data Map&lt;br&gt;
     * @param exchangeDataMapId 
     * @return ExchangeDataMap
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getExchangeDataMap(exchangeDataMapId: kotlin.String): HttpResponse<ExchangeDataMap> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/rest/v2/exchangedatamap/{exchangeDataMapId}".replace("{" + "exchangeDataMapId" + "}", "$exchangeDataMapId"),
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
     * 
     * Gets an Exchange Data Map batch by ids&lt;br&gt;
     * @param listOfIdsDto 
     * @return kotlin.collections.List<ExchangeDataMap>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getExchangeDataMapBatch(listOfIdsDto: ListOfIds): HttpResponse<kotlin.collections.List<ExchangeDataMap>> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = listOfIdsDto

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.POST,
            "/rest/v2/exchangedatamap/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
        ).wrap()
    }

    /**
     * 
     * Modifies an existing Exchange Data Map&lt;br&gt;
     * @param accessControlKey 
     * @param exchangeDataMapDto 
     * @return ExchangeDataMap
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun modifyExchangeDataMap(accessControlKey: kotlin.String, exchangeDataMapDto: ExchangeDataMap): HttpResponse<ExchangeDataMap> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = exchangeDataMapDto

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.PUT,
            "/rest/v2/exchangedatamap/forKey/{accessControlKey}".replace("{" + "accessControlKey" + "}", "$accessControlKey"),
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
