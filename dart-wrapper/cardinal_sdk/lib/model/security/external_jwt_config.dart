// auto-generated file
import 'package:cardinal_sdk/model/security/identifier_selector.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
part "external_jwt_config.freezed.dart";


@freezed
abstract class ExternalJwtConfig with _$ExternalJwtConfig {
	const factory ExternalJwtConfig({
		required Base64String publicKey,
		@Default(null) String? id,
		@Default(null) String? emailField,
		@Default(null) String? loginField,
		@Default(null) String? mobilePhoneField,
		@Default(null) IdentifierSelector? identifierField,
	}) = _ExternalJwtConfig;


	static Map<String, dynamic> encode(ExternalJwtConfig value) {
		Map<String, dynamic> entityAsMap = {
			"publicKey" : value.publicKey,
			"id" : value.id,
			"emailField" : value.emailField,
			"loginField" : value.loginField,
			"mobilePhoneField" : value.mobilePhoneField,
			"identifierField" : value.identifierField == null ? null : IdentifierSelector.encode(value.identifierField!)
		};
		return entityAsMap;
	}

	static ExternalJwtConfig fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfig(
			publicKey: (data["publicKey"] as Base64String),
			id: (data["id"] as String?),
			emailField: (data["emailField"] as String?),
			loginField: (data["loginField"] as String?),
			mobilePhoneField: (data["mobilePhoneField"] as String?),
			identifierField: data["identifierField"] == null ? null : IdentifierSelector.fromJSON(data["identifierField"]),
		);
	}
}