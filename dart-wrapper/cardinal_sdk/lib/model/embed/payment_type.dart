// This file is auto-generated


enum PaymentType {
	cash,
	wired,
	insurance,
	creditcard,
	debitcard,
	paypal,
	bitcoin,
	other;

	static String encode(PaymentType value) {
		switch (value) {
			case PaymentType.cash:
				return '"Cash"';
			case PaymentType.wired:
				return '"Wired"';
			case PaymentType.insurance:
				return '"Insurance"';
			case PaymentType.creditcard:
				return '"Creditcard"';
			case PaymentType.debitcard:
				return '"Debitcard"';
			case PaymentType.paypal:
				return '"Paypal"';
			case PaymentType.bitcoin:
				return '"Bitcoin"';
			case PaymentType.other:
				return '"Other"';
			}
	}

}