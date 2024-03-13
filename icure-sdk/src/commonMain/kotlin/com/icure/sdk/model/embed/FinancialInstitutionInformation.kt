package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class FinancialInstitutionInformation(
  public val name: String? = null,
  public val key: String? = null,
  public val bankAccount: String? = null,
  public val bic: String? = null,
  public val proxyBankAccount: String? = null,
  public val proxyBic: String? = null,
  public val preferredFiiForPartners: Set<String> = emptySet(),
  override val encryptedSelf: String? = null,
) : Encrypted
