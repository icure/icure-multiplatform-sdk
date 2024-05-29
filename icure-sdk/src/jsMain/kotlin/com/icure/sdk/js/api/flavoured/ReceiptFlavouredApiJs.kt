// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.ReceiptJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ReceiptFlavouredApi")
public external interface ReceiptFlavouredApiJs<E : ReceiptJs> {
	public fun shareWith(
		delegateId: String,
		receipt: E,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(receipt: E, delegates: dynamic): Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(receipt: E, delegates: dynamic): Promise<E>

	public fun modifyReceipt(entity: E): Promise<E>

	public fun getReceipt(entityId: String): Promise<E>

	public fun listByReference(reference: String): Promise<Array<E>>
}
