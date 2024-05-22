package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.PartnershipType
import kotlin.String

public fun partnershipType_toJs(obj: PartnershipType): String = obj.name

public fun partnershipType_fromJs(obj: String): PartnershipType = when (obj) {
	"PrimaryContact" -> PartnershipType.PrimaryContact
	"PrimaryContactFor" -> PartnershipType.PrimaryContactFor
	"Family" -> PartnershipType.Family
	"Friend" -> PartnershipType.Friend
	"Counselor" -> PartnershipType.Counselor
	"Contact" -> PartnershipType.Contact
	"Brother" -> PartnershipType.Brother
	"Brotherinlaw" -> PartnershipType.Brotherinlaw
	"Child" -> PartnershipType.Child
	"Daughter" -> PartnershipType.Daughter
	"Employer" -> PartnershipType.Employer
	"Father" -> PartnershipType.Father
	"Grandchild" -> PartnershipType.Grandchild
	"Grandparent" -> PartnershipType.Grandparent
	"Husband" -> PartnershipType.Husband
	"Lawyer" -> PartnershipType.Lawyer
	"Mother" -> PartnershipType.Mother
	"Neighbour" -> PartnershipType.Neighbour
	"Notary" -> PartnershipType.Notary
	"Partner" -> PartnershipType.Partner
	"Sister" -> PartnershipType.Sister
	"Sisterinlaw" -> PartnershipType.Sisterinlaw
	"Son" -> PartnershipType.Son
	"Spouse" -> PartnershipType.Spouse
	"Stepdaughter" -> PartnershipType.Stepdaughter
	"Stepfather" -> PartnershipType.Stepfather
	"Stepmother" -> PartnershipType.Stepmother
	"Stepson" -> PartnershipType.Stepson
	"Tutor" -> PartnershipType.Tutor
	"NextOfKin" -> PartnershipType.NextOfKin
	"FederalAgency" -> PartnershipType.FederalAgency
	"InsuranceCompany" -> PartnershipType.InsuranceCompany
	"StateAgency" -> PartnershipType.StateAgency
	"Unknown" -> PartnershipType.Unknown
	"Seealso" -> PartnershipType.Seealso
	"Refer" -> PartnershipType.Refer
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.PartnershipType: $obj""")
}
