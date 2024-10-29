// auto-generated file
import 'package:cardinal_sdk/model/embed/payment_type.dart';


class Payment {
	int paymentDate = 0;
	PaymentType? paymentType = null;
	double? paid = null;
	Payment({
			int? paymentDate,
			PaymentType? paymentType,
			double? paid
		}) : paymentDate = paymentDate ?? 0,
		paymentType = paymentType ?? null,
		paid = paid ?? null;

	factory Payment.fromJSON(Map<String, dynamic> data) {
		return Payment(
			paymentDate: (data["paymentDate"] as int),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble()
		);
	}

	static Map<String, dynamic> encode(Payment value) {
		Map<String, dynamic> entityAsMap = {
			"paymentDate" : value.paymentDate,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid
		};
		return entityAsMap;
	}
}