// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ParagraphAgreement")
public external class ParagraphAgreementJs(
	partial: dynamic,
) {
	public val timestamp: Double?

	public val paragraph: String?

	public val accepted: Boolean?

	public val inTreatment: Boolean?

	public val canceled: Boolean?

	public val careProviderReference: String?

	public val decisionReference: String?

	public val start: Double?

	public val end: Double?

	public val cancelationDate: Double?

	public val quantityValue: Double?

	public val quantityUnit: String?

	public val ioRequestReference: String?

	public val responseType: String?

	public val refusalJustification: dynamic

	public val verses: Array<Double>?

	public val coverageType: String?

	public val unitNumber: Double?

	public val strength: Double?

	public val strengthUnit: String?

	public val agreementAppendices: Array<AgreementAppendixJs>?

	public val documentId: String?
}
