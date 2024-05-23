// auto-generated file
package com.icure.sdk.js.api

import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TarificationJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("TarificationApi")
public external interface TarificationApiJs {
	public fun getTarification(tarificationId: String): Promise<TarificationJs>

	public fun createTarification(tarification: TarificationJs): Promise<TarificationJs>

	public fun getTarifications(tarificationIds: Array<String>): Promise<Array<TarificationJs>>

	public fun modifyTarification(tarification: TarificationJs): Promise<TarificationJs>

	public fun findTarificationsByLabel(
		region: String?,
		types: String?,
		language: String?,
		label: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<TarificationJs>>

	public fun findTarificationsBy(
		region: String?,
		type: String?,
		tarification: String?,
		version: String?,
		startDocumentId: String?,
		startKey: String?,
		limit: Double?,
	): Promise<PaginatedListJs<TarificationJs>>

	public fun getTarificationWithParts(
		type: String,
		tarification: String,
		version: String,
	): Promise<TarificationJs>
}
