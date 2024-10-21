// This file is auto-generated
import 'package:cardinal_sdk/model/embed/payment_type.dart';


class Payment {
	int paymentDate = 0;
	PaymentType? paymentType;
	double? paid;

	Payment({
		this.paymentType,
		this.paid,
		int? paymentDate
	}) : paymentDate = paymentDate ?? 0;

	static Map<String, dynamic> encode(Payment value) {
		Map<String, dynamic> entityAsMap = {
			"paymentDate" : value.paymentDate,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid
		};
		return entityAsMap;
	}
}