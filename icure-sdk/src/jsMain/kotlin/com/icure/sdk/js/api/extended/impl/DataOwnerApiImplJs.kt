// auto-generated file
package com.icure.sdk.js.api.extended.`impl`

import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.js.api.extended.DataOwnerApiJs
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.sdk.js.model.DataOwnerWithTypeJs
import com.icure.sdk.js.model.cryptoActorStubWithType_toJs
import com.icure.sdk.js.model.dataOwnerType_toJs
import com.icure.sdk.js.model.dataOwnerWithType_toJs
import com.icure.sdk.model.DataOwnerWithType
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class DataOwnerApiImplJs private constructor(
	private val dataOwnerApi: DataOwnerApi,
) : DataOwnerApiJs {
	override fun getCurrentDataOwner(): Promise<DataOwnerWithTypeJs> = GlobalScope.promise {
		dataOwnerWithType_toJs(dataOwnerApi.getCurrentDataOwner())}


	override fun getCurrentDataOwnerStub(): Promise<CryptoActorStubWithTypeJs> = GlobalScope.promise {
		cryptoActorStubWithType_toJs(dataOwnerApi.getCurrentDataOwnerStub())}


	override fun getCurrentDataOwnerId(): Promise<String> = GlobalScope.promise {
		dataOwnerApi.getCurrentDataOwnerId()}


	override fun getCurrentDataOwnerHierarchyIds(): Promise<Array<String>> = GlobalScope.promise {
		listToArray(
			dataOwnerApi.getCurrentDataOwnerHierarchyIds(),
			{ x1: String ->
				x1
			},
		)}


	override fun getDataOwner(ownerId: String): Promise<DataOwnerWithTypeJs> = GlobalScope.promise {
		dataOwnerWithType_toJs(dataOwnerApi.getDataOwner(ownerId))}


	override fun getDataOwnerStub(ownerId: String): Promise<CryptoActorStubWithTypeJs> =
			GlobalScope.promise {
		cryptoActorStubWithType_toJs(dataOwnerApi.getDataOwnerStub(ownerId))}


	override fun getCurrentDataOwnerHierarchyIdsFrom(parentId: String): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			dataOwnerApi.getCurrentDataOwnerHierarchyIdsFrom(parentId),
			{ x1: String ->
				x1
			},
		)}


	override fun getCurrentDataOwnerHierarchy(): Promise<Array<DataOwnerWithTypeJs>> =
			GlobalScope.promise {
		listToArray(
			dataOwnerApi.getCurrentDataOwnerHierarchy(),
			{ x1: DataOwnerWithType ->
				dataOwnerWithType_toJs(x1)
			},
		)}


	override fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithTypeJs):
			Promise<CryptoActorStubWithTypeJs> = GlobalScope.promise {
		cryptoActorStubWithType_toJs(dataOwnerApi.modifyDataOwnerStub(com.icure.sdk.js.model.cryptoActorStubWithType_fromJs(cryptoActorStubWithTypeDto)))}


	override fun getCurrentDataOwnerType(): Promise<String> = GlobalScope.promise {
		dataOwnerType_toJs(dataOwnerApi.getCurrentDataOwnerType())}


	override fun getCryptoActorStub(ownerId: String): Promise<CryptoActorStubWithTypeJs> =
			GlobalScope.promise {
		cryptoActorStubWithType_toJs(dataOwnerApi.getCryptoActorStub(ownerId))}


	override fun clearCurrentDataOwnerIdsCache(): Unit = dataOwnerApi.clearCurrentDataOwnerIdsCache()
}
