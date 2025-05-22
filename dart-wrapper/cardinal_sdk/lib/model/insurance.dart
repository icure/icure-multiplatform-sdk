// auto-generated file
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "insurance.freezed.dart";


@freezed
abstract class Insurance with _$Insurance implements StoredDocument {
	const factory Insurance({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default({}) Map<String, String> name,
		@Default(false) bool privateInsurance,
		@Default(false) bool hospitalisationInsurance,
		@Default(false) bool ambulatoryInsurance,
		@Default(null) String? code,
		@Default(null) String? agreementNumber,
		@Default(null) String? parent,
		required DecryptedAddress address,
	}) = _Insurance;


	static Map<String, dynamic> encode(Insurance value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name.map((k0, v0) => MapEntry(k0, v0)),
			"privateInsurance" : value.privateInsurance,
			"hospitalisationInsurance" : value.hospitalisationInsurance,
			"ambulatoryInsurance" : value.ambulatoryInsurance,
			"code" : value.code,
			"agreementNumber" : value.agreementNumber,
			"parent" : value.parent,
			"address" : DecryptedAddress.encode(value.address)
		};
		return entityAsMap;
	}

	static Insurance fromJSON(Map<String, dynamic> data) {
		return Insurance(
			id: (data["id"] as String),
			address: DecryptedAddress.fromJSON(data["address"]),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			privateInsurance: (data["privateInsurance"] as bool),
			hospitalisationInsurance: (data["hospitalisationInsurance"] as bool),
			ambulatoryInsurance: (data["ambulatoryInsurance"] as bool),
			code: (data["code"] as String?),
			agreementNumber: (data["agreementNumber"] as String?),
			parent: (data["parent"] as String?),
		);
	}
}