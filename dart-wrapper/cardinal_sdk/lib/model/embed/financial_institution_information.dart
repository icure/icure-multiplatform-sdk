// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/financial_institution_information.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "financial_institution_information.freezed.dart";


sealed class FinancialInstitutionInformation implements Encryptable {
	abstract final String? name;
	abstract final String? key;
	abstract final String? bankAccount;
	abstract final String? bic;
	abstract final String? proxyBankAccount;
	abstract final String? proxyBic;
	abstract final Set<String> preferredFiiForPartners;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(FinancialInstitutionInformation value) {
		switch (value) {
			case EncryptedFinancialInstitutionInformation entity:
				Map<String, dynamic> entityJson = EncryptedFinancialInstitutionInformation.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation";
				return entityJson;
			case DecryptedFinancialInstitutionInformation entity:
				Map<String, dynamic> entityJson = DecryptedFinancialInstitutionInformation.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation";
				return entityJson;
		}
	}

	static FinancialInstitutionInformation fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation":
				return EncryptedFinancialInstitutionInformation.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation":
				return DecryptedFinancialInstitutionInformation.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedFinancialInstitutionInformation with _$EncryptedFinancialInstitutionInformation implements FinancialInstitutionInformation {
	const factory EncryptedFinancialInstitutionInformation({
		@Default(null) String? name,
		@Default(null) String? key,
		@Default(null) String? bankAccount,
		@Default(null) String? bic,
		@Default(null) String? proxyBankAccount,
		@Default(null) String? proxyBic,
		@Default({}) Set<String> preferredFiiForPartners,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedFinancialInstitutionInformation;


	static Map<String, dynamic> encode(EncryptedFinancialInstitutionInformation value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"key" : value.key,
			"bankAccount" : value.bankAccount,
			"bic" : value.bic,
			"proxyBankAccount" : value.proxyBankAccount,
			"proxyBic" : value.proxyBic,
			"preferredFiiForPartners" : value.preferredFiiForPartners.map((x0) => x0).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedFinancialInstitutionInformation fromJSON(Map<String, dynamic> data) {
		return EncryptedFinancialInstitutionInformation(
			name: (data["name"] as String?),
			key: (data["key"] as String?),
			bankAccount: (data["bankAccount"] as String?),
			bic: (data["bic"] as String?),
			proxyBankAccount: (data["proxyBankAccount"] as String?),
			proxyBic: (data["proxyBic"] as String?),
			preferredFiiForPartners: (data["preferredFiiForPartners"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class DecryptedFinancialInstitutionInformation with _$DecryptedFinancialInstitutionInformation implements FinancialInstitutionInformation {
	const factory DecryptedFinancialInstitutionInformation({
		@Default(null) String? name,
		@Default(null) String? key,
		@Default(null) String? bankAccount,
		@Default(null) String? bic,
		@Default(null) String? proxyBankAccount,
		@Default(null) String? proxyBic,
		@Default({}) Set<String> preferredFiiForPartners,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedFinancialInstitutionInformation;


	static Map<String, dynamic> encode(DecryptedFinancialInstitutionInformation value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"key" : value.key,
			"bankAccount" : value.bankAccount,
			"bic" : value.bic,
			"proxyBankAccount" : value.proxyBankAccount,
			"proxyBic" : value.proxyBic,
			"preferredFiiForPartners" : value.preferredFiiForPartners.map((x0) => x0).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedFinancialInstitutionInformation fromJSON(Map<String, dynamic> data) {
		return DecryptedFinancialInstitutionInformation(
			name: (data["name"] as String?),
			key: (data["key"] as String?),
			bankAccount: (data["bankAccount"] as String?),
			bic: (data["bic"] as String?),
			proxyBankAccount: (data["proxyBankAccount"] as String?),
			proxyBic: (data["proxyBic"] as String?),
			preferredFiiForPartners: (data["preferredFiiForPartners"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}