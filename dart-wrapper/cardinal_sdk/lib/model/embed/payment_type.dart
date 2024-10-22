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
				return '"cash"';
			case PaymentType.wired:
				return '"wired"';
			case PaymentType.insurance:
				return '"insurance"';
			case PaymentType.creditcard:
				return '"creditcard"';
			case PaymentType.debitcard:
				return '"debitcard"';
			case PaymentType.paypal:
				return '"paypal"';
			case PaymentType.bitcoin:
				return '"bitcoin"';
			case PaymentType.other:
				return '"other"';
			}
	}


	static PaymentType fromJSON(String data) {
		switch (data) {
			case "cash":
				return PaymentType.cash;
			case "wired":
				return PaymentType.wired;
			case "insurance":
				return PaymentType.insurance;
			case "creditcard":
				return PaymentType.creditcard;
			case "debitcard":
				return PaymentType.debitcard;
			case "paypal":
				return PaymentType.paypal;
			case "bitcoin":
				return PaymentType.bitcoin;
			case "other":
				return PaymentType.other;
			default:
				throw ArgumentError('Invalid PaymentType entry value $data');
			}
	}

}