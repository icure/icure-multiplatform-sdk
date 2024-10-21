// This file is auto-generated


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
				return '"Patient"';
			case InvoiceType.mutualfund:
				return '"Mutualfund"';
			case InvoiceType.payingagency:
				return '"Payingagency"';
			case InvoiceType.insurance:
				return '"Insurance"';
			case InvoiceType.efact:
				return '"Efact"';
			case InvoiceType.other:
				return '"Other"';
			}
	}

}