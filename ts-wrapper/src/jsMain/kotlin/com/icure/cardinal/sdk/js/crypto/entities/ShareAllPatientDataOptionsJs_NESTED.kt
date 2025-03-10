// auto-generated file
@file:JsQualifier("crypto.ShareAllPatientDataOptions")

package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.js.model.EncryptedPatientJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("EntityResult")
public external class ShareAllPatientDataOptionsJs_EntityResultJs(
	partial: dynamic,
) {
	public val success: Boolean?

	public val error: ShareAllPatientDataOptionsJs_SharePatientDataErrorJs?

	public val modified: Double
}

@JsName("Result")
public external class ShareAllPatientDataOptionsJs_ResultJs(
	partial: dynamic,
) {
	public val patient: EncryptedPatientJs

	public val statuses: Record<String, ShareAllPatientDataOptionsJs_EntityResultJs>
}

@JsName("SharePatientDataError")
public sealed external interface ShareAllPatientDataOptionsJs_SharePatientDataErrorJs {
	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("BulkShareFailure")
public external class ShareAllPatientDataOptionsJs_BulkShareFailureJs(
	partial: dynamic,
) : ShareAllPatientDataOptionsJs_SharePatientDataErrorJs {
	public val errors: Array<FailedRequestDetailsJs>

	public val message: String

	override val ktClass: String
}

@JsName("FailedRequest")
public external class ShareAllPatientDataOptionsJs_FailedRequestJs(
	partial: dynamic,
) : ShareAllPatientDataOptionsJs_SharePatientDataErrorJs {
	public val description: String

	override val ktClass: String
}
