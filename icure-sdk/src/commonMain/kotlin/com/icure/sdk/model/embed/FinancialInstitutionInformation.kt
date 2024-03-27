package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface FinancialInstitutionInformation : Encryptable {
    public val name: String?

    public val key: String?

    public val bankAccount: String?

    public val bic: String?

    public val proxyBankAccount: String?

    public val proxyBic: String?

    public val preferredFiiForPartners: Set<String>

    override val encryptedSelf: Base64String?
	// region FinancialInstitutionInformation-FinancialInstitutionInformation

	// endregion
}

@Serializable
data class DecryptedFinancialInstitutionInformation(
    override val name: String? = null,
    override val key: String? = null,
    override val bankAccount: String? = null,
    override val bic: String? = null,
    override val proxyBankAccount: String? = null,
    override val proxyBic: String? = null,
    override val preferredFiiForPartners: Set<String> = emptySet(),
    override val encryptedSelf: Base64String? = null,
) : FinancialInstitutionInformation {
	// region FinancialInstitutionInformation-DecryptedFinancialInstitutionInformation

	// endregion
}

@Serializable
data class EncryptedFinancialInstitutionInformation(
    override val name: String? = null,
    override val key: String? = null,
    override val bankAccount: String? = null,
    override val bic: String? = null,
    override val proxyBankAccount: String? = null,
    override val proxyBic: String? = null,
    override val preferredFiiForPartners: Set<String> = emptySet(),
    override val encryptedSelf: Base64String? = null,
) : FinancialInstitutionInformation {
	// region FinancialInstitutionInformation-EncryptedFinancialInstitutionInformation

	// endregion
}

public fun FinancialInstitutionInformation.copy(
    name: String? = this.name,
    key: String? = this.key,
    bankAccount: String? = this.bankAccount,
    bic: String? = this.bic,
    proxyBankAccount: String? = this.proxyBankAccount,
    proxyBic: String? = this.proxyBic,
    preferredFiiForPartners: Set<String> = this.preferredFiiForPartners,
    encryptedSelf: Base64String? = this.encryptedSelf,
): FinancialInstitutionInformation {
    return when (this) {
        is DecryptedFinancialInstitutionInformation ->
            copy(
                name =
                name,
                key = key,
                bankAccount = bankAccount,
                bic = bic,
                proxyBankAccount =
                proxyBankAccount,
                proxyBic = proxyBic,
                preferredFiiForPartners = preferredFiiForPartners,
                encryptedSelf = encryptedSelf,
            )
        is EncryptedFinancialInstitutionInformation ->
            copy(
                name = name,
                key = key,
                bankAccount =
                bankAccount,
                bic = bic,
                proxyBankAccount = proxyBankAccount,
                proxyBic = proxyBic,
                preferredFiiForPartners = preferredFiiForPartners,
                encryptedSelf = encryptedSelf,
            )
    }
}
