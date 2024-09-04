// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.ReceiptShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.utils.Record
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
		options: dynamic,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(receipt: E, delegates: Record<String, ReceiptShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(receipt: E, delegates: Record<String, ReceiptShareOptionsJs>): Promise<E>

	public fun modifyReceipt(entity: E): Promise<E>

	public fun getReceipt(entityId: String): Promise<E>

	public fun listByReference(reference: String): Promise<Array<E>>
}
