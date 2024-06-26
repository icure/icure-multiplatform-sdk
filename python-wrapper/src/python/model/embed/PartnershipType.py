from typing import Union, Dict
from enum import Enum

class PartnershipType(Enum):
	PrimaryContact = "primary_contact"
	PrimaryContactFor = "primary_contact_for"
	Family = "family"
	Friend = "friend"
	Counselor = "counselor"
	Contact = "contact"
	Brother = "brother"
	Brotherinlaw = "brotherinlaw"
	Child = "child"
	Daughter = "daughter"
	Employer = "employer"
	Father = "father"
	Grandchild = "grandchild"
	Grandparent = "grandparent"
	Husband = "husband"
	Lawyer = "lawyer"
	Mother = "mother"
	Neighbour = "neighbour"
	Notary = "notary"
	Partner = "partner"
	Sister = "sister"
	Sisterinlaw = "sisterinlaw"
	Son = "son"
	Spouse = "spouse"
	Stepdaughter = "stepdaughter"
	Stepfather = "stepfather"
	Stepmother = "stepmother"
	Stepson = "stepson"
	Tutor = "tutor"
	NextOfKin = "next_of_kin"
	FederalAgency = "federal_agency"
	InsuranceCompany = "insurance_company"
	StateAgency = "state_agency"
	Unknown = "unknown"
	Seealso = "seealso"
	Refer = "refer"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PartnershipType':
		if data == "primary_contact":
			return PartnershipType.PrimaryContact
		elif data == "primary_contact_for":
			return PartnershipType.PrimaryContactFor
		elif data == "family":
			return PartnershipType.Family
		elif data == "friend":
			return PartnershipType.Friend
		elif data == "counselor":
			return PartnershipType.Counselor
		elif data == "contact":
			return PartnershipType.Contact
		elif data == "brother":
			return PartnershipType.Brother
		elif data == "brotherinlaw":
			return PartnershipType.Brotherinlaw
		elif data == "child":
			return PartnershipType.Child
		elif data == "daughter":
			return PartnershipType.Daughter
		elif data == "employer":
			return PartnershipType.Employer
		elif data == "father":
			return PartnershipType.Father
		elif data == "grandchild":
			return PartnershipType.Grandchild
		elif data == "grandparent":
			return PartnershipType.Grandparent
		elif data == "husband":
			return PartnershipType.Husband
		elif data == "lawyer":
			return PartnershipType.Lawyer
		elif data == "mother":
			return PartnershipType.Mother
		elif data == "neighbour":
			return PartnershipType.Neighbour
		elif data == "notary":
			return PartnershipType.Notary
		elif data == "partner":
			return PartnershipType.Partner
		elif data == "sister":
			return PartnershipType.Sister
		elif data == "sisterinlaw":
			return PartnershipType.Sisterinlaw
		elif data == "son":
			return PartnershipType.Son
		elif data == "spouse":
			return PartnershipType.Spouse
		elif data == "stepdaughter":
			return PartnershipType.Stepdaughter
		elif data == "stepfather":
			return PartnershipType.Stepfather
		elif data == "stepmother":
			return PartnershipType.Stepmother
		elif data == "stepson":
			return PartnershipType.Stepson
		elif data == "tutor":
			return PartnershipType.Tutor
		elif data == "next_of_kin":
			return PartnershipType.NextOfKin
		elif data == "federal_agency":
			return PartnershipType.FederalAgency
		elif data == "insurance_company":
			return PartnershipType.InsuranceCompany
		elif data == "state_agency":
			return PartnershipType.StateAgency
		elif data == "unknown":
			return PartnershipType.Unknown
		elif data == "seealso":
			return PartnershipType.Seealso
		elif data == "refer":
			return PartnershipType.Refer
		else:
			raise Exception(f"{data} is not a valid value for PartnershipType enum.")

__all__ = ['PartnershipType']