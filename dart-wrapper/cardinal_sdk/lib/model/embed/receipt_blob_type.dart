// auto-generated file


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
				return 'xades';
			case ReceiptBlobType.kmehrRequest:
				return 'kmehrRequest';
			case ReceiptBlobType.kmehrResponse:
				return 'kmehrResponse';
			case ReceiptBlobType.soapRequest:
				return 'soapRequest';
			case ReceiptBlobType.soapResponse:
				return 'soapResponse';
			case ReceiptBlobType.soapConversation:
				return 'soapConversation';
			case ReceiptBlobType.tack:
				return 'tack';
			}
	}


	static ReceiptBlobType fromJSON(String data) {
		switch (data) {
			case "xades":
				return ReceiptBlobType.xades;
			case "kmehrRequest":
				return ReceiptBlobType.kmehrRequest;
			case "kmehrResponse":
				return ReceiptBlobType.kmehrResponse;
			case "soapRequest":
				return ReceiptBlobType.soapRequest;
			case "soapResponse":
				return ReceiptBlobType.soapResponse;
			case "soapConversation":
				return ReceiptBlobType.soapConversation;
			case "tack":
				return ReceiptBlobType.tack;
			default:
				throw ArgumentError('Invalid ReceiptBlobType entry value $data');
			}
	}

}