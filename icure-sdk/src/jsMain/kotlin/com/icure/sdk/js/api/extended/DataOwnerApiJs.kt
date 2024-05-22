// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.extended

import com.icure.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.sdk.js.model.DataOwnerWithTypeJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DataOwnerApi")
public external interface DataOwnerApiJs {
	public fun getCurrentDataOwner(): Promise<DataOwnerWithTypeJs>

	public fun getCurrentDataOwnerStub(): Promise<CryptoActorStubWithTypeJs>

	public fun getCurrentDataOwnerId(): Promise<String>

	public fun getCurrentDataOwnerHierarchyIds(): Promise<Array<String>>

	public fun getDataOwner(ownerId: String): Promise<DataOwnerWithTypeJs>

	public fun getDataOwnerStub(ownerId: String): Promise<CryptoActorStubWithTypeJs>

	public fun getCurrentDataOwnerHierarchyIdsFrom(parentId: String): Promise<Array<String>>

	public fun getCurrentDataOwnerHierarchy(): Promise<Array<DataOwnerWithTypeJs>>

	public fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithTypeJs):
			Promise<CryptoActorStubWithTypeJs>

	public fun getCurrentDataOwnerType(): Promise<String>

	public fun getCryptoActorStub(ownerId: String): Promise<CryptoActorStubWithTypeJs>

	public fun clearCurrentDataOwnerIdsCache()
}
