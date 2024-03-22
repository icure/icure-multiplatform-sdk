package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Address : Encrypted {
  public val addressType: AddressType?

  public val descr: String?

  public val street: String?

  public val houseNumber: String?

  public val postboxNumber: String?

  public val postalCode: String?

  public val city: String?

  public val state: String?

  public val country: String?

  public val note: String?

  public val notes: List<Annotation>

  public val telecoms: List<Telecom>

  override val encryptedSelf: String?
}

public data class DecryptedAddress(
  override val addressType: AddressType? = null,
  override val descr: String? = null,
  override val street: String? = null,
  override val houseNumber: String? = null,
  override val postboxNumber: String? = null,
  override val postalCode: String? = null,
  override val city: String? = null,
  override val state: String? = null,
  override val country: String? = null,
  override val note: String? = null,
  override val notes: List<Annotation> = emptyList(),
  override val telecoms: List<DecryptedTelecom> = emptyList(),
  override val encryptedSelf: String? = null,
) : Address

public data class EncryptedAddress(
  override val addressType: AddressType? = null,
  override val descr: String? = null,
  override val street: String? = null,
  override val houseNumber: String? = null,
  override val postboxNumber: String? = null,
  override val postalCode: String? = null,
  override val city: String? = null,
  override val state: String? = null,
  override val country: String? = null,
  override val note: String? = null,
  override val notes: List<Annotation> = emptyList(),
  override val telecoms: List<EncryptedTelecom> = emptyList(),
  override val encryptedSelf: String? = null,
) : Address

public fun Address.copy(
  addressType: AddressType? = this.addressType,
  descr: String? = this.descr,
  street: String? = this.street,
  houseNumber: String? = this.houseNumber,
  postboxNumber: String? = this.postboxNumber,
  postalCode: String? = this.postalCode,
  city: String? = this.city,
  state: String? = this.state,
  country: String? = this.country,
  note: String? = this.note,
  notes: List<Annotation> = this.notes,
  telecoms: List<Telecom> = this.telecoms,
  encryptedSelf: String? = this.encryptedSelf,
): Address {
                                      return when(this) {
                                          is DecryptedAddress -> copy(addressType = addressType,
          descr = descr, street = street, houseNumber = houseNumber, postboxNumber = postboxNumber,
          postalCode = postalCode, city = city, state = state, country = country, note = note, notes
          = notes, telecoms = telecoms, encryptedSelf = encryptedSelf)
      is EncryptedAddress -> copy(addressType = addressType, descr = descr, street = street,
          houseNumber = houseNumber, postboxNumber = postboxNumber, postalCode = postalCode, city =
          city, state = state, country = country, note = note, notes = notes, telecoms = telecoms,
          encryptedSelf = encryptedSelf)
                                          }
}
