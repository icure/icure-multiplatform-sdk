import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class InvoiceByHcPartyCodeDateFilter:
	code: str
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	start_invoice_date: Optional[int] = None
	end_invoice_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"code": self.code,
			"startInvoiceDate": self.start_invoice_date,
			"endInvoiceDate": self.end_invoice_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'InvoiceByHcPartyCodeDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			code = deserialized_dict["code"],
			start_invoice_date = deserialized_dict.get("startInvoiceDate"),
			end_invoice_date = deserialized_dict.get("endInvoiceDate"),
		)

__all__ = ['InvoiceByHcPartyCodeDateFilter']