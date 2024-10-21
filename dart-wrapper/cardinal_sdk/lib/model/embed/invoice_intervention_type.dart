// This file is auto-generated


enum InvoiceInterventionType {
	total,
	userfees;

	static String encode(InvoiceInterventionType value) {
		switch (value) {
			case InvoiceInterventionType.total:
				return '"Total"';
			case InvoiceInterventionType.userfees:
				return '"Userfees"';
			}
	}

}