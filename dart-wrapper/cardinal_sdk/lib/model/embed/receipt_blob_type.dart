// This file is auto-generated


enum ReceiptBlobType {
	xades,
	kmehrRequest,
	kmehrResponse,
	soapRequest,
	soapResponse,
	soapConversation,
	tack;

	static String encode(ReceiptBlobType value) {
		switch (value) {
			case ReceiptBlobType.xades:
				return '"Xades"';
			case ReceiptBlobType.kmehrRequest:
				return '"KmehrRequest"';
			case ReceiptBlobType.kmehrResponse:
				return '"KmehrResponse"';
			case ReceiptBlobType.soapRequest:
				return '"SoapRequest"';
			case ReceiptBlobType.soapResponse:
				return '"SoapResponse"';
			case ReceiptBlobType.soapConversation:
				return '"SoapConversation"';
			case ReceiptBlobType.tack:
				return '"Tack"';
			}
	}

}