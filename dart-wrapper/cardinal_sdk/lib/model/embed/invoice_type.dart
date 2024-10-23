// auto-generated file


enum InvoiceType {
	patient,
	mutualfund,
	payingagency,
	insurance,
	efact,
	other;

	static String encode(InvoiceType value) {
		switch (value) {
			case InvoiceType.patient:
				return '"patient"';
			case InvoiceType.mutualfund:
				return '"mutualfund"';
			case InvoiceType.payingagency:
				return '"payingagency"';
			case InvoiceType.insurance:
				return '"insurance"';
			case InvoiceType.efact:
				return '"efact"';
			case InvoiceType.other:
				return '"other"';
			}
	}


	static InvoiceType fromJSON(String data) {
		switch (data) {
			case "patient":
				return InvoiceType.patient;
			case "mutualfund":
				return InvoiceType.mutualfund;
			case "payingagency":
				return InvoiceType.payingagency;
			case "insurance":
				return InvoiceType.insurance;
			case "efact":
				return InvoiceType.efact;
			case "other":
				return InvoiceType.other;
			default:
				throw ArgumentError('Invalid InvoiceType entry value $data');
			}
	}

}