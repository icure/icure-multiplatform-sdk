package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.model.PaginatedList
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod

class RawExchangeDataApi(
    baseUrl: String,
    authService: AuthService
) : ApiClient(baseUrl, authService) {

    /**
     * Creates new exchange data
     * 
     * @param ExchangeData 
     * @return ExchangeData
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun createExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData> {

        val localVariableBody = exchangeData

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<Any?>(
            RequestMethod.POST,
            "/rest/v2/exchangedata",
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
     * Get exchange data with a specific delegator-delegate pair
     * 
     * @param delegatorId 
     * @param delegateId 
     * @return kotlin.collections.List<ExchangeData>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getExchangeDataByDelegatorDelegate(delegatorId: kotlin.String, delegateId: kotlin.String): HttpResponse<kotlin.collections.List<ExchangeData>> {
        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/rest/v2/exchangedata/byDelegatorDelegate/{delegatorId}/{delegateId}".replace("{" + "delegatorId" + "}", "$delegatorId").replace("{" + "delegateId" + "}", "$delegateId"),
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
     * Get exchange data with a specific id
     * 
     * @param exchangeDataId 
     * @return ExchangeData
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getExchangeDataById(exchangeDataId: kotlin.String): HttpResponse<ExchangeData> {
        val localVariableAuthNames = listOf<String>()

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/rest/v2/exchangedata/{exchangeDataId}".replace("{" + "exchangeDataId" + "}", "$exchangeDataId"),
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
     * Get exchange data with a specific participant
     * 
     * @param dataOwnerId 
     * @param startDocumentId  (optional)
     * @param limit  (optional)
     * @return PaginatedListExchangeData
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getExchangeDataByParticipant(dataOwnerId: kotlin.String, startDocumentId: kotlin.String? = null, limit: kotlin.Int? = null): HttpResponse<PaginatedList<ExchangeData, String>> {
        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        startDocumentId?.apply { localVariableQuery["startDocumentId"] = listOf("$startDocumentId") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/rest/v2/exchangedata/byParticipant/{dataOwnerId}".replace("{" + "dataOwnerId" + "}", "$dataOwnerId"),
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
     * Get the ids of all delegates in exchange data where the data owner is delegator and all delegators in exchange data where the data owner is delegate. Return only counterparts if that are data owners of the specified type.
     * 
     * @param dataOwnerId 
     * @param counterpartsTypes 
     * @return kotlin.collections.List<kotlin.String>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getParticipantCounterparts(dataOwnerId: kotlin.String, counterpartsTypes: kotlin.String): HttpResponse<kotlin.collections.List<kotlin.String>> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        counterpartsTypes?.apply { localVariableQuery["counterpartsTypes"] = listOf("$counterpartsTypes") }
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/rest/v2/exchangedata/byParticipant/{dataOwnerId}/counterparts".replace("{" + "dataOwnerId" + "}", "$dataOwnerId"),
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
     * Modifies existing exchange data
     * 
     * @param ExchangeData 
     * @return ExchangeData
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun modifyExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = ExchangeData

        val localVariableQuery = mutableMapOf<String, List<String>>()
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.PUT,
            "/rest/v2/exchangedata",
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
