package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PartnershipType() {
  @SerialName("primary_contact")
  PrimaryContact,
  @SerialName("primary_contact_for")
  PrimaryContactFor,
  @SerialName("family")
  Family,
  @SerialName("friend")
  Friend,
  @SerialName("counselor")
  Counselor,
  @SerialName("contact")
  Contact,
  @SerialName("brother")
  Brother,
  @SerialName("brotherinlaw")
  Brotherinlaw,
  @SerialName("child")
  Child,
  @SerialName("daughter")
  Daughter,
  @SerialName("employer")
  Employer,
  @SerialName("father")
  Father,
  @SerialName("grandchild")
  Grandchild,
  @SerialName("grandparent")
  Grandparent,
  @SerialName("husband")
  Husband,
  @SerialName("lawyer")
  Lawyer,
  @SerialName("mother")
  Mother,
  @SerialName("neighbour")
  Neighbour,
  @SerialName("notary")
  Notary,
  @SerialName("partner")
  Partner,
  @SerialName("sister")
  Sister,
  @SerialName("sisterinlaw")
  Sisterinlaw,
  @SerialName("son")
  Son,
  @SerialName("spouse")
  Spouse,
  @SerialName("stepdaughter")
  Stepdaughter,
  @SerialName("stepfather")
  Stepfather,
  @SerialName("stepmother")
  Stepmother,
  @SerialName("stepson")
  Stepson,
  @SerialName("tutor")
  Tutor,
  @SerialName("next_of_kin")
  NextOfKin,
  @SerialName("federal_agency")
  FederalAgency,
  @SerialName("insurance_company")
  InsuranceCompany,
  @SerialName("state_agency")
  StateAgency,
  @SerialName("unknown")
  Unknown,
  @SerialName("seealso")
  Seealso,
  @SerialName("refer")
  Refer,

}