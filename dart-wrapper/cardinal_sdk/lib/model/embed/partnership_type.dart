// This file is auto-generated


enum PartnershipType {
	primaryContact,
	primaryContactFor,
	family,
	friend,
	counselor,
	contact,
	brother,
	brotherinlaw,
	child,
	daughter,
	employer,
	father,
	grandchild,
	grandparent,
	husband,
	lawyer,
	mother,
	neighbour,
	notary,
	partner,
	sister,
	sisterinlaw,
	son,
	spouse,
	stepdaughter,
	stepfather,
	stepmother,
	stepson,
	tutor,
	cohabiting,
	registeredPartner,
	nextOfKin,
	federalAgency,
	insuranceCompany,
	stateAgency,
	unknown,
	seealso,
	refer;

	static String encode(PartnershipType value) {
		switch (value) {
			case PartnershipType.primaryContact:
				return '"PrimaryContact"';
			case PartnershipType.primaryContactFor:
				return '"PrimaryContactFor"';
			case PartnershipType.family:
				return '"Family"';
			case PartnershipType.friend:
				return '"Friend"';
			case PartnershipType.counselor:
				return '"Counselor"';
			case PartnershipType.contact:
				return '"Contact"';
			case PartnershipType.brother:
				return '"Brother"';
			case PartnershipType.brotherinlaw:
				return '"Brotherinlaw"';
			case PartnershipType.child:
				return '"Child"';
			case PartnershipType.daughter:
				return '"Daughter"';
			case PartnershipType.employer:
				return '"Employer"';
			case PartnershipType.father:
				return '"Father"';
			case PartnershipType.grandchild:
				return '"Grandchild"';
			case PartnershipType.grandparent:
				return '"Grandparent"';
			case PartnershipType.husband:
				return '"Husband"';
			case PartnershipType.lawyer:
				return '"Lawyer"';
			case PartnershipType.mother:
				return '"Mother"';
			case PartnershipType.neighbour:
				return '"Neighbour"';
			case PartnershipType.notary:
				return '"Notary"';
			case PartnershipType.partner:
				return '"Partner"';
			case PartnershipType.sister:
				return '"Sister"';
			case PartnershipType.sisterinlaw:
				return '"Sisterinlaw"';
			case PartnershipType.son:
				return '"Son"';
			case PartnershipType.spouse:
				return '"Spouse"';
			case PartnershipType.stepdaughter:
				return '"Stepdaughter"';
			case PartnershipType.stepfather:
				return '"Stepfather"';
			case PartnershipType.stepmother:
				return '"Stepmother"';
			case PartnershipType.stepson:
				return '"Stepson"';
			case PartnershipType.tutor:
				return '"Tutor"';
			case PartnershipType.cohabiting:
				return '"Cohabiting"';
			case PartnershipType.registeredPartner:
				return '"RegisteredPartner"';
			case PartnershipType.nextOfKin:
				return '"NextOfKin"';
			case PartnershipType.federalAgency:
				return '"FederalAgency"';
			case PartnershipType.insuranceCompany:
				return '"InsuranceCompany"';
			case PartnershipType.stateAgency:
				return '"StateAgency"';
			case PartnershipType.unknown:
				return '"Unknown"';
			case PartnershipType.seealso:
				return '"Seealso"';
			case PartnershipType.refer:
				return '"Refer"';
			}
	}

}