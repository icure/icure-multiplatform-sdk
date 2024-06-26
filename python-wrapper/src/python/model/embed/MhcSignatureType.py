from typing import Union, Dict
from enum import Enum

class MhcSignatureType(Enum):
	HolderEid = "holderEid"
	HolderPaper = "holderPaper"
	LegalrepresentativeEid = "legalrepresentativeEid"
	LegalrepresentativePaper = "legalrepresentativePaper"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MhcSignatureType':
		if data == "holderEid":
			return MhcSignatureType.HolderEid
		elif data == "holderPaper":
			return MhcSignatureType.HolderPaper
		elif data == "legalrepresentativeEid":
			return MhcSignatureType.LegalrepresentativeEid
		elif data == "legalrepresentativePaper":
			return MhcSignatureType.LegalrepresentativePaper
		else:
			raise Exception(f"{data} is not a valid value for MhcSignatureType enum.")

__all__ = ['MhcSignatureType']