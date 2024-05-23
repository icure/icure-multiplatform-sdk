// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ContactByHcPartyPatientTagCodeDateFilter")
public external class ContactByHcPartyPatientTagCodeDateFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ContactJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val patientSecretForeignKey: String?

	public val patientSecretForeignKeys: Array<String>?

	public val tagType: String?

	public val tagCode: String?

	public val codeType: String?

	public val codeCode: String?

	public val startOfContactOpeningDate: Double?

	public val endOfContactOpeningDate: Double?

	override val ktClass: String
}
