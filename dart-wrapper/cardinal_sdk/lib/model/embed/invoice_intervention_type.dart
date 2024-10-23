// auto-generated file


enum InvoiceInterventionType {
	total,
	userfees;

	static String encode(InvoiceInterventionType value) {
		switch (value) {
			case InvoiceInterventionType.total:
				return '"total"';
			case InvoiceInterventionType.userfees:
				return '"userfees"';
			}
	}


	static InvoiceInterventionType fromJSON(String data) {
		switch (data) {
			case "total":
				return InvoiceInterventionType.total;
			case "userfees":
				return InvoiceInterventionType.userfees;
			default:
				throw ArgumentError('Invalid InvoiceInterventionType entry value $data');
			}
	}

}