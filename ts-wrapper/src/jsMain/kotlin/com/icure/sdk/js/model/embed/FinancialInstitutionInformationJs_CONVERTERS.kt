package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.FinancialInstitutionInformation
import kotlin.String

public fun financialInstitutionInformation_toJs(obj: DecryptedFinancialInstitutionInformation):
		DecryptedFinancialInstitutionInformationJs {
	val name = obj.name
	val key = obj.key
	val bankAccount = obj.bankAccount
	val bic = obj.bic
	val proxyBankAccount = obj.proxyBankAccount
	val proxyBic = obj.proxyBic
	val preferredFiiForPartners = setToArray(
		obj.preferredFiiForPartners,
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedFinancialInstitutionInformationJs(js("{" +
		"name:name," +
		"key:key," +
		"bankAccount:bankAccount," +
		"bic:bic," +
		"proxyBankAccount:proxyBankAccount," +
		"proxyBic:proxyBic," +
		"preferredFiiForPartners:preferredFiiForPartners," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun financialInstitutionInformation_fromJs(obj: DecryptedFinancialInstitutionInformationJs):
		DecryptedFinancialInstitutionInformation {
	val name = obj.name
	val key = obj.key
	val bankAccount = obj.bankAccount
	val bic = obj.bic
	val proxyBankAccount = obj.proxyBankAccount
	val proxyBic = obj.proxyBic
	val preferredFiiForPartners = arrayToSet(
		obj.preferredFiiForPartners,
		"obj.preferredFiiForPartners",
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedFinancialInstitutionInformation(
		name = name,
		key = key,
		bankAccount = bankAccount,
		bic = bic,
		proxyBankAccount = proxyBankAccount,
		proxyBic = proxyBic,
		preferredFiiForPartners = preferredFiiForPartners,
		encryptedSelf = encryptedSelf,
	)
}

public fun financialInstitutionInformation_toJs(obj: EncryptedFinancialInstitutionInformation):
		EncryptedFinancialInstitutionInformationJs {
	val name = obj.name
	val key = obj.key
	val bankAccount = obj.bankAccount
	val bic = obj.bic
	val proxyBankAccount = obj.proxyBankAccount
	val proxyBic = obj.proxyBic
	val preferredFiiForPartners = setToArray(
		obj.preferredFiiForPartners,
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedFinancialInstitutionInformationJs(js("{" +
		"name:name," +
		"key:key," +
		"bankAccount:bankAccount," +
		"bic:bic," +
		"proxyBankAccount:proxyBankAccount," +
		"proxyBic:proxyBic," +
		"preferredFiiForPartners:preferredFiiForPartners," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun financialInstitutionInformation_fromJs(obj: EncryptedFinancialInstitutionInformationJs):
		EncryptedFinancialInstitutionInformation {
	val name = obj.name
	val key = obj.key
	val bankAccount = obj.bankAccount
	val bic = obj.bic
	val proxyBankAccount = obj.proxyBankAccount
	val proxyBic = obj.proxyBic
	val preferredFiiForPartners = arrayToSet(
		obj.preferredFiiForPartners,
		"obj.preferredFiiForPartners",
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedFinancialInstitutionInformation(
		name = name,
		key = key,
		bankAccount = bankAccount,
		bic = bic,
		proxyBankAccount = proxyBankAccount,
		proxyBic = proxyBic,
		preferredFiiForPartners = preferredFiiForPartners,
		encryptedSelf = encryptedSelf,
	)
}

public fun financialInstitutionInformation_toJs(obj: FinancialInstitutionInformation):
		FinancialInstitutionInformationJs = when (obj) {
	is EncryptedFinancialInstitutionInformation -> financialInstitutionInformation_toJs(obj)
	is DecryptedFinancialInstitutionInformation -> financialInstitutionInformation_toJs(obj)
}

public fun financialInstitutionInformation_fromJs(obj: FinancialInstitutionInformationJs):
		FinancialInstitutionInformation = if (obj.isEncrypted) {
	financialInstitutionInformation_fromJs(obj as EncryptedFinancialInstitutionInformationJs)
} else {
	financialInstitutionInformation_fromJs(obj as DecryptedFinancialInstitutionInformationJs)
}
