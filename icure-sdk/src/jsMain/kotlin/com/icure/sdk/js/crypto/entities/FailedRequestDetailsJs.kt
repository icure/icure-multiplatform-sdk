// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.crypto.entities

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("FailedRequestDetails")
public external class FailedRequestDetailsJs(
	partial: dynamic,
) {
	public val entityId: String

	public val delegateId: String

	public val updatedForMigration: Boolean

	public val code: Double?

	public val reason: String?

	public val request: DelegateShareOptionsJs?
}
