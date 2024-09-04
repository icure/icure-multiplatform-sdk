// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("FinancialInstitutionInformation")
public sealed external interface FinancialInstitutionInformationJs : EncryptableJs {
	public val name: String?

	public val key: String?

	public val bankAccount: String?

	public val bic: String?

	public val proxyBankAccount: String?

	public val proxyBic: String?

	public val preferredFiiForPartners: Array<out String>

	public val isEncrypted: Boolean
}

@JsName("DecryptedFinancialInstitutionInformation")
public external class DecryptedFinancialInstitutionInformationJs(
	partial: dynamic,
) : FinancialInstitutionInformationJs {
	override val name: String?

	override val key: String?

	override val bankAccount: String?

	override val bic: String?

	override val proxyBankAccount: String?

	override val proxyBic: String?

	override val preferredFiiForPartners: Array<String>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedFinancialInstitutionInformation")
public external class EncryptedFinancialInstitutionInformationJs(
	partial: dynamic,
) : FinancialInstitutionInformationJs {
	override val name: String?

	override val key: String?

	override val bankAccount: String?

	override val bic: String?

	override val proxyBankAccount: String?

	override val proxyBic: String?

	override val preferredFiiForPartners: Array<String>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
