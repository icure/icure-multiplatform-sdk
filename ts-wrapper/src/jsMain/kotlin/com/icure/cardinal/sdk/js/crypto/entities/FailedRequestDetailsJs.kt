// auto-generated file
@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

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

	public val shouldRetry: Boolean
}
