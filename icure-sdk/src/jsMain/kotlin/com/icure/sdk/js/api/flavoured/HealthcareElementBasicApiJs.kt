// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthcareElementBasicApi")
public external interface HealthcareElementBasicApiJs {
	public fun matchHealthcareElementsBy(filter: AbstractFilterJs<HealthElementJs>):
			Promise<Array<String>>

	public fun deleteHealthcareElement(entityId: String): Promise<DocIdentifierJs>

	public fun deleteHealthcareElements(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>>

	public fun modifyHealthcareElement(entity: EncryptedHealthElementJs):
			Promise<EncryptedHealthElementJs>

	public fun modifyHealthcareElements(entities: Array<EncryptedHealthElementJs>):
			Promise<Array<EncryptedHealthElementJs>>

	public fun getHealthcareElement(entityId: String): Promise<EncryptedHealthElementJs>

	public fun getHealthcareElements(entityIds: Array<String>):
			Promise<Array<EncryptedHealthElementJs>>

	public fun filterHealthcareElementsBy(
		filterChain: FilterChainJs<HealthElementJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedHealthElementJs>>

	public fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<EncryptedHealthElementJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<HealthElementJs>,
		onConnected: () -> Promise<Unit>,
		channelCapacity: Double,
		retryDelay: Double,
		retryDelayExponentFactor: Double,
		maxRetries: Double,
		eventFired: (EncryptedHealthElementJs) -> Promise<Unit>,
	): Promise<ConnectionJs>
}
