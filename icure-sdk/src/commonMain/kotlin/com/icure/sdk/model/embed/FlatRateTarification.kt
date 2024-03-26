package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface FlatRateTarification : Encryptable {
  public val code: String?

  public val flatRateType: FlatRateType?

  public val label: Map<String, String>?

  public val valorisations: List<Valorisation>

  override val encryptedSelf: String?
}

@SerialName
public data class DecryptedFlatRateTarification(
  override val code: String? = null,
  override val flatRateType: FlatRateType? = null,
  override val label: Map<String, String>? = null,
  override val valorisations: List<DecryptedValorisation> = emptyList(),
  override val encryptedSelf: String? = null,
) : FlatRateTarification

@SerialName
public data class EncryptedFlatRateTarification(
  override val code: String? = null,
  override val flatRateType: FlatRateType? = null,
  override val label: Map<String, String>? = null,
  override val valorisations: List<EncryptedValorisation> = emptyList(),
  override val encryptedSelf: String? = null,
) : FlatRateTarification

public fun FlatRateTarification.copy(
  code: String? = this.code,
  flatRateType: FlatRateType? = this.flatRateType,
  label: Map<String, String>? = this.label,
  valorisations: List<Valorisation> = this.valorisations,
  encryptedSelf: String? = this.encryptedSelf,
): FlatRateTarification {
                                      return when(this) {
                                          is DecryptedFlatRateTarification -> copy(code = code,
          flatRateType = flatRateType, label = label, valorisations = valorisations, encryptedSelf =
          encryptedSelf)
      is EncryptedFlatRateTarification -> copy(code = code, flatRateType = flatRateType, label =
          label, valorisations = valorisations, encryptedSelf = encryptedSelf)
                                          }
}
