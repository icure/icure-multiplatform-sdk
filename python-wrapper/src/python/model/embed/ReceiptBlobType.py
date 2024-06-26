from typing import Union, Dict
from enum import Enum

class ReceiptBlobType(Enum):
	Xades = "xades"
	KmehrRequest = "kmehrRequest"
	KmehrResponse = "kmehrResponse"
	SoapRequest = "soapRequest"
	SoapResponse = "soapResponse"
	SoapConversation = "soapConversation"
	Tack = "tack"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReceiptBlobType':
		if data == "xades":
			return ReceiptBlobType.Xades
		elif data == "kmehrRequest":
			return ReceiptBlobType.KmehrRequest
		elif data == "kmehrResponse":
			return ReceiptBlobType.KmehrResponse
		elif data == "soapRequest":
			return ReceiptBlobType.SoapRequest
		elif data == "soapResponse":
			return ReceiptBlobType.SoapResponse
		elif data == "soapConversation":
			return ReceiptBlobType.SoapConversation
		elif data == "tack":
			return ReceiptBlobType.Tack
		else:
			raise Exception(f"{data} is not a valid value for ReceiptBlobType enum.")

__all__ = ['ReceiptBlobType']