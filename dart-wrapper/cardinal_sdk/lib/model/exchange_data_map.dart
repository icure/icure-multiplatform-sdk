// This file is auto-generated
import 'package:cardinal_sdk/model/specializations/keypair_fingerprint_v2string.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class ExchangeDataMap implements StoredDocument {
	@override  String id;
	@override  String? rev;
	Map<KeypairFingerprintV2String, Base64String> encryptedExchangeDataIds = {};
	@override  int? deletionDate;

	ExchangeDataMap({
		required this.id,
		this.rev,
		this.deletionDate,
		Map<KeypairFingerprintV2String, Base64String>? encryptedExchangeDataIds
	}) : encryptedExchangeDataIds = encryptedExchangeDataIds ?? {};

	static Map<String, dynamic> encode(ExchangeDataMap value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"encryptedExchangeDataIds" : value.encryptedExchangeDataIds.map((k0, v0) => MapEntry(k0, v0)),
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}