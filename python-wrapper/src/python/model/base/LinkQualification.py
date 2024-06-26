from typing import Union, Dict
from enum import Enum

class LinkQualification(Enum):
	Exact = "exact"
	Narrower = "narrower"
	Broader = "broader"
	Approximate = "approximate"
	Sequence = "sequence"
	Parent = "parent"
	Child = "child"
	RelatedCode = "relatedCode"
	LinkedPackage = "linkedPackage"
	RelatedService = "relatedService"
	InResponseTo = "inResponseTo"
	Replaces = "replaces"
	Transforms = "transforms"
	TransformsAndReplaces = "transformsAndReplaces"
	AppendsTo = "appendsTo"
	BasedOn = "basedOn"
	DerivedFrom = "derivedFrom"
	Device = "device"
	Focus = "focus"
	HasMember = "hasMember"
	Performer = "performer"
	Specimen = "specimen"
	ResultInterpreter = "resultInterpreter"
	Request = "request"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'LinkQualification':
		if data == "exact":
			return LinkQualification.Exact
		elif data == "narrower":
			return LinkQualification.Narrower
		elif data == "broader":
			return LinkQualification.Broader
		elif data == "approximate":
			return LinkQualification.Approximate
		elif data == "sequence":
			return LinkQualification.Sequence
		elif data == "parent":
			return LinkQualification.Parent
		elif data == "child":
			return LinkQualification.Child
		elif data == "relatedCode":
			return LinkQualification.RelatedCode
		elif data == "linkedPackage":
			return LinkQualification.LinkedPackage
		elif data == "relatedService":
			return LinkQualification.RelatedService
		elif data == "inResponseTo":
			return LinkQualification.InResponseTo
		elif data == "replaces":
			return LinkQualification.Replaces
		elif data == "transforms":
			return LinkQualification.Transforms
		elif data == "transformsAndReplaces":
			return LinkQualification.TransformsAndReplaces
		elif data == "appendsTo":
			return LinkQualification.AppendsTo
		elif data == "basedOn":
			return LinkQualification.BasedOn
		elif data == "derivedFrom":
			return LinkQualification.DerivedFrom
		elif data == "device":
			return LinkQualification.Device
		elif data == "focus":
			return LinkQualification.Focus
		elif data == "hasMember":
			return LinkQualification.HasMember
		elif data == "performer":
			return LinkQualification.Performer
		elif data == "specimen":
			return LinkQualification.Specimen
		elif data == "resultInterpreter":
			return LinkQualification.ResultInterpreter
		elif data == "request":
			return LinkQualification.Request
		else:
			raise Exception(f"{data} is not a valid value for LinkQualification enum.")

__all__ = ['LinkQualification']