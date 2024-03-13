package com.icure.sdk.model.embed

import kotlin.Comparable
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class Address(
  public val addressType: AddressType? = null,
  public val descr: String? = null,
  public val street: String? = null,
  public val houseNumber: String? = null,
  public val postboxNumber: String? = null,
  public val postalCode: String? = null,
  public val city: String? = null,
  public val state: String? = null,
  public val country: String? = null,
  public val note: String? = null,
  public val notes: List<Annotation> = emptyList(),
  public val telecoms: List<Telecom> = emptyList(),
  override val encryptedSelf: String? = null,
) : Encrypted, Comparable<Address>
