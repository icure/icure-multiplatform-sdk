package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface FinancialInstitutionInformation : Encryptable {
  public val name: String?

  public val key: String?

  public val bankAccount: String?

  public val bic: String?

  public val proxyBankAccount: String?

  public val proxyBic: String?

  public val preferredFiiForPartners: Set<String>

  override val encryptedSelf: String?
}

@SerialName
public data class DecryptedFinancialInstitutionInformation(
  override val name: String? = null,
  override val key: String? = null,
  override val bankAccount: String? = null,
  override val bic: String? = null,
  override val proxyBankAccount: String? = null,
  override val proxyBic: String? = null,
  override val preferredFiiForPartners: Set<String> = emptySet(),
  override val encryptedSelf: String? = null,
) : FinancialInstitutionInformation

@SerialName
public data class EncryptedFinancialInstitutionInformation(
  override val name: String? = null,
  override val key: String? = null,
  override val bankAccount: String? = null,
  override val bic: String? = null,
  override val proxyBankAccount: String? = null,
  override val proxyBic: String? = null,
  override val preferredFiiForPartners: Set<String> = emptySet(),
  override val encryptedSelf: String? = null,
) : FinancialInstitutionInformation

public fun FinancialInstitutionInformation.copy(
  name: String? = this.name,
  key: String? = this.key,
  bankAccount: String? = this.bankAccount,
  bic: String? = this.bic,
  proxyBankAccount: String? = this.proxyBankAccount,
  proxyBic: String? = this.proxyBic,
  preferredFiiForPartners: Set<String> = this.preferredFiiForPartners,
  encryptedSelf: String? = this.encryptedSelf,
): FinancialInstitutionInformation {
                                      return when(this) {
                                          is DecryptedFinancialInstitutionInformation -> copy(name =
          name, key = key, bankAccount = bankAccount, bic = bic, proxyBankAccount =
          proxyBankAccount, proxyBic = proxyBic, preferredFiiForPartners = preferredFiiForPartners,
          encryptedSelf = encryptedSelf)
      is EncryptedFinancialInstitutionInformation -> copy(name = name, key = key, bankAccount =
          bankAccount, bic = bic, proxyBankAccount = proxyBankAccount, proxyBic = proxyBic,
          preferredFiiForPartners = preferredFiiForPartners, encryptedSelf = encryptedSelf)
                                          }
}
