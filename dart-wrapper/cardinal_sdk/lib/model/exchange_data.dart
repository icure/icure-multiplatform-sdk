// This file is auto-generated
import 'package:cardinal_sdk/model/specializations/keypair_fingerprint_v2string.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class ExchangeData implements StoredDocument {
	@override  String id;
	@override  String? rev;
	String delegator;
	String delegate;
	Map<KeypairFingerprintV2String, Base64String> exchangeKey;
	Map<KeypairFingerprintV2String, Base64String> accessControlSecret;
	Map<KeypairFingerprintV2String, Base64String> delegatorSignature;
	Map<KeypairFingerprintV2String, Base64String> sharedSignatureKey;
	Base64String sharedSignature;
	@override  int? deletionDate;

	ExchangeData({
		required this.id,
		required this.delegator,
		required this.delegate,
		required this.exchangeKey,
		required this.accessControlSecret,
		required this.delegatorSignature,
		required this.sharedSignatureKey,
		required this.sharedSignature,
		this.rev,
		this.deletionDate
	});

	static Map<String, dynamic> encode(ExchangeData value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"delegator" : value.delegator,
			"delegate" : value.delegate,
			"exchangeKey" : value.exchangeKey.map((k0, v0) => MapEntry(k0, v0)),
			"accessControlSecret" : value.accessControlSecret.map((k0, v0) => MapEntry(k0, v0)),
			"delegatorSignature" : value.delegatorSignature.map((k0, v0) => MapEntry(k0, v0)),
			"sharedSignatureKey" : value.sharedSignatureKey.map((k0, v0) => MapEntry(k0, v0)),
			"sharedSignature" : value.sharedSignature,
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}