// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.TarificationJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TarificationApi")
public external interface TarificationApiJs {
	public fun getTarification(tarificationId: String): Promise<TarificationJs>

	public fun createTarification(tarification: TarificationJs): Promise<TarificationJs>

	public fun getTarifications(tarificationIds: Array<String>): Promise<Array<TarificationJs>>

	public fun modifyTarification(tarification: TarificationJs): Promise<TarificationJs>

	public fun findTarificationsByLabel(options: dynamic): Promise<PaginatedListJs<TarificationJs>>

	public fun findTarificationsBy(options: dynamic): Promise<PaginatedListJs<TarificationJs>>

	public fun getTarificationWithParts(
		type: String,
		tarification: String,
		version: String,
	): Promise<TarificationJs>
}
