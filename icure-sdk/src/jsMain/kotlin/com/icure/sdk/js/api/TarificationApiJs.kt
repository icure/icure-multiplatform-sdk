// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TarificationJs
import kotlin.Array
import kotlin.Double
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

	public fun findTarificationsByLabel(options: TarificationApi_findTarificationsByLabel_Options?):
			Promise<PaginatedListJs<TarificationJs>>

	public fun findTarificationsBy(options: TarificationApi_findTarificationsBy_Options?):
			Promise<PaginatedListJs<TarificationJs>>

	public fun getTarificationWithParts(
		type: String,
		tarification: String,
		version: String,
	): Promise<TarificationJs>
}

public external interface TarificationApi_findTarificationsByLabel_Options {
	public val region: String?

	public val types: String?

	public val language: String?

	public val label: String?

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface TarificationApi_findTarificationsBy_Options {
	public val region: String?

	public val type: String?

	public val tarification: String?

	public val version: String?

	public val startDocumentId: String?

	public val startKey: String?

	public val limit: Double?
}
