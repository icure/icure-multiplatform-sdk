// This file is auto-generated
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class Insurance implements StoredDocument {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	Map<String, String> name = {};
	bool privateInsurance = false;
	bool hospitalisationInsurance = false;
	bool ambulatoryInsurance = false;
	String? code;
	String? agreementNumber;
	String? parent;
	DecryptedAddress address;

	Insurance({
		required this.id,
		required this.address,
		this.rev,
		this.deletionDate,
		this.code,
		this.agreementNumber,
		this.parent,
		Map<String, String>? name,
		bool? privateInsurance,
		bool? hospitalisationInsurance,
		bool? ambulatoryInsurance
	}) : name = name ?? {},
		privateInsurance = privateInsurance ?? false,
		hospitalisationInsurance = hospitalisationInsurance ?? false,
		ambulatoryInsurance = ambulatoryInsurance ?? false;

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
}