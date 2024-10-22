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
				return '"primary_contact"';
			case PartnershipType.primaryContactFor:
				return '"primary_contact_for"';
			case PartnershipType.family:
				return '"family"';
			case PartnershipType.friend:
				return '"friend"';
			case PartnershipType.counselor:
				return '"counselor"';
			case PartnershipType.contact:
				return '"contact"';
			case PartnershipType.brother:
				return '"brother"';
			case PartnershipType.brotherinlaw:
				return '"brotherinlaw"';
			case PartnershipType.child:
				return '"child"';
			case PartnershipType.daughter:
				return '"daughter"';
			case PartnershipType.employer:
				return '"employer"';
			case PartnershipType.father:
				return '"father"';
			case PartnershipType.grandchild:
				return '"grandchild"';
			case PartnershipType.grandparent:
				return '"grandparent"';
			case PartnershipType.husband:
				return '"husband"';
			case PartnershipType.lawyer:
				return '"lawyer"';
			case PartnershipType.mother:
				return '"mother"';
			case PartnershipType.neighbour:
				return '"neighbour"';
			case PartnershipType.notary:
				return '"notary"';
			case PartnershipType.partner:
				return '"partner"';
			case PartnershipType.sister:
				return '"sister"';
			case PartnershipType.sisterinlaw:
				return '"sisterinlaw"';
			case PartnershipType.son:
				return '"son"';
			case PartnershipType.spouse:
				return '"spouse"';
			case PartnershipType.stepdaughter:
				return '"stepdaughter"';
			case PartnershipType.stepfather:
				return '"stepfather"';
			case PartnershipType.stepmother:
				return '"stepmother"';
			case PartnershipType.stepson:
				return '"stepson"';
			case PartnershipType.tutor:
				return '"tutor"';
			case PartnershipType.cohabiting:
				return '"cohabiting"';
			case PartnershipType.registeredPartner:
				return '"registered_partner"';
			case PartnershipType.nextOfKin:
				return '"next_of_kin"';
			case PartnershipType.federalAgency:
				return '"federal_agency"';
			case PartnershipType.insuranceCompany:
				return '"insurance_company"';
			case PartnershipType.stateAgency:
				return '"state_agency"';
			case PartnershipType.unknown:
				return '"unknown"';
			case PartnershipType.seealso:
				return '"seealso"';
			case PartnershipType.refer:
				return '"refer"';
			}
	}


	static PartnershipType fromJSON(String data) {
		switch (data) {
			case "primary_contact":
				return PartnershipType.primaryContact;
			case "primary_contact_for":
				return PartnershipType.primaryContactFor;
			case "family":
				return PartnershipType.family;
			case "friend":
				return PartnershipType.friend;
			case "counselor":
				return PartnershipType.counselor;
			case "contact":
				return PartnershipType.contact;
			case "brother":
				return PartnershipType.brother;
			case "brotherinlaw":
				return PartnershipType.brotherinlaw;
			case "child":
				return PartnershipType.child;
			case "daughter":
				return PartnershipType.daughter;
			case "employer":
				return PartnershipType.employer;
			case "father":
				return PartnershipType.father;
			case "grandchild":
				return PartnershipType.grandchild;
			case "grandparent":
				return PartnershipType.grandparent;
			case "husband":
				return PartnershipType.husband;
			case "lawyer":
				return PartnershipType.lawyer;
			case "mother":
				return PartnershipType.mother;
			case "neighbour":
				return PartnershipType.neighbour;
			case "notary":
				return PartnershipType.notary;
			case "partner":
				return PartnershipType.partner;
			case "sister":
				return PartnershipType.sister;
			case "sisterinlaw":
				return PartnershipType.sisterinlaw;
			case "son":
				return PartnershipType.son;
			case "spouse":
				return PartnershipType.spouse;
			case "stepdaughter":
				return PartnershipType.stepdaughter;
			case "stepfather":
				return PartnershipType.stepfather;
			case "stepmother":
				return PartnershipType.stepmother;
			case "stepson":
				return PartnershipType.stepson;
			case "tutor":
				return PartnershipType.tutor;
			case "cohabiting":
				return PartnershipType.cohabiting;
			case "registered_partner":
				return PartnershipType.registeredPartner;
			case "next_of_kin":
				return PartnershipType.nextOfKin;
			case "federal_agency":
				return PartnershipType.federalAgency;
			case "insurance_company":
				return PartnershipType.insuranceCompany;
			case "state_agency":
				return PartnershipType.stateAgency;
			case "unknown":
				return PartnershipType.unknown;
			case "seealso":
				return PartnershipType.seealso;
			case "refer":
				return PartnershipType.refer;
			default:
				throw ArgumentError('Invalid PartnershipType entry value $data');
			}
	}

}