// auto-generated file
import 'package:cardinal_sdk/model/embed/payment_type.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "payment.freezed.dart";


@freezed
abstract class Payment with _$Payment {
	const factory Payment({
		@Default(0) int paymentDate,
		@Default(null) PaymentType? paymentType,
		@Default(null) double? paid,
	}) = _Payment;


	static Map<String, dynamic> encode(Payment value) {
		Map<String, dynamic> entityAsMap = {
			"paymentDate" : value.paymentDate,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid
		};
		return entityAsMap;
	}

	static Payment fromJSON(Map<String, dynamic> data) {
		return Payment(
			paymentDate: (data["paymentDate"] as int),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble()
		);
	}
}