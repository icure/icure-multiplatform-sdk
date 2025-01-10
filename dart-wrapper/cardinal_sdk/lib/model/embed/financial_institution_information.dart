// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/financial_institution_information.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class FinancialInstitutionInformation implements Encryptable {
	abstract String? name;
	abstract String? key;
	abstract String? bankAccount;
	abstract String? bic;
	abstract String? proxyBankAccount;
	abstract String? proxyBic;
	abstract Set<String> preferredFiiForPartners;
	@override abstract Base64String? encryptedSelf;

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

class EncryptedFinancialInstitutionInformation implements FinancialInstitutionInformation {
	@override String? name = null;
	@override String? key = null;
	@override String? bankAccount = null;
	@override String? bic = null;
	@override String? proxyBankAccount = null;
	@override String? proxyBic = null;
	@override Set<String> preferredFiiForPartners = {};
	@override Base64String? encryptedSelf = null;
	EncryptedFinancialInstitutionInformation({
			String? name,
			String? key,
			String? bankAccount,
			String? bic,
			String? proxyBankAccount,
			String? proxyBic,
			Set<String>? preferredFiiForPartners,
			Base64String? encryptedSelf
		}) : name = name ?? null,
		key = key ?? null,
		bankAccount = bankAccount ?? null,
		bic = bic ?? null,
		proxyBankAccount = proxyBankAccount ?? null,
		proxyBic = proxyBic ?? null,
		preferredFiiForPartners = preferredFiiForPartners ?? {},
		encryptedSelf = encryptedSelf ?? null;

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

class DecryptedFinancialInstitutionInformation implements FinancialInstitutionInformation {
	@override String? name = null;
	@override String? key = null;
	@override String? bankAccount = null;
	@override String? bic = null;
	@override String? proxyBankAccount = null;
	@override String? proxyBic = null;
	@override Set<String> preferredFiiForPartners = {};
	@override Base64String? encryptedSelf = null;
	DecryptedFinancialInstitutionInformation({
			String? name,
			String? key,
			String? bankAccount,
			String? bic,
			String? proxyBankAccount,
			String? proxyBic,
			Set<String>? preferredFiiForPartners,
			Base64String? encryptedSelf
		}) : name = name ?? null,
		key = key ?? null,
		bankAccount = bankAccount ?? null,
		bic = bic ?? null,
		proxyBankAccount = proxyBankAccount ?? null,
		proxyBic = proxyBic ?? null,
		preferredFiiForPartners = preferredFiiForPartners ?? {},
		encryptedSelf = encryptedSelf ?? null;

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