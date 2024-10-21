// This file is auto-generated
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class RecoveryData implements StoredDocument {
	@override  String id;
	@override  String? rev;
	String recipient;
	Base64String encryptedSelf;
	RecoveryDataType type;
	int? expirationInstant;
	@override  int? deletionDate;

	RecoveryData({
		required this.id,
		required this.recipient,
		required this.encryptedSelf,
		required this.type,
		this.rev,
		this.expirationInstant,
		this.deletionDate
	});

	static Map<String, dynamic> encode(RecoveryData value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"recipient" : value.recipient,
			"encryptedSelf" : value.encryptedSelf,
			"type" : RecoveryDataType.encode(value.type),
			"expirationInstant" : value.expirationInstant,
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}

enum RecoveryDataType {
	keypairRecovery,
	exchangeKeyRecovery;

	static String encode(RecoveryDataType value) {
		switch (value) {
			case RecoveryDataType.keypairRecovery:
				return '"KeypairRecovery"';
			case RecoveryDataType.exchangeKeyRecovery:
				return '"ExchangeKeyRecovery"';
			}
	}

}