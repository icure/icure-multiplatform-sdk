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
	@override String? name;
	@override String? key;
	@override String? bankAccount;
	@override String? bic;
	@override String? proxyBankAccount;
	@override String? proxyBic;
	@override Set<String> preferredFiiForPartners = {};
	@override Base64String? encryptedSelf;
	EncryptedFinancialInstitutionInformation({
			this.name,
			this.key,
			this.bankAccount,
			this.bic,
			this.proxyBankAccount,
			this.proxyBic,
			this.encryptedSelf,
			Set<String>? preferredFiiForPartners
		}) : preferredFiiForPartners = preferredFiiForPartners ?? {};

	factory EncryptedFinancialInstitutionInformation.fromJSON(Map<String, dynamic> data) {
		return EncryptedFinancialInstitutionInformation(
			name: data["name"],
			key: data["key"],
			bankAccount: data["bankAccount"],
			bic: data["bic"],
			proxyBankAccount: data["proxyBankAccount"],
			proxyBic: data["proxyBic"],
			preferredFiiForPartners: data["preferredFiiForPartners"].map((x0) => x0 ),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(EncryptedFinancialInstitutionInformation value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"key" : value.key,
			"bankAccount" : value.bankAccount,
			"bic" : value.bic,
			"proxyBankAccount" : value.proxyBankAccount,
			"proxyBic" : value.proxyBic,
			"preferredFiiForPartners" : value.preferredFiiForPartners.map((x0) => x0),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedFinancialInstitutionInformation implements FinancialInstitutionInformation {
	@override String? name;
	@override String? key;
	@override String? bankAccount;
	@override String? bic;
	@override String? proxyBankAccount;
	@override String? proxyBic;
	@override Set<String> preferredFiiForPartners = {};
	@override Base64String? encryptedSelf;
	DecryptedFinancialInstitutionInformation({
			this.name,
			this.key,
			this.bankAccount,
			this.bic,
			this.proxyBankAccount,
			this.proxyBic,
			this.encryptedSelf,
			Set<String>? preferredFiiForPartners
		}) : preferredFiiForPartners = preferredFiiForPartners ?? {};

	factory DecryptedFinancialInstitutionInformation.fromJSON(Map<String, dynamic> data) {
		return DecryptedFinancialInstitutionInformation(
			name: data["name"],
			key: data["key"],
			bankAccount: data["bankAccount"],
			bic: data["bic"],
			proxyBankAccount: data["proxyBankAccount"],
			proxyBic: data["proxyBic"],
			preferredFiiForPartners: data["preferredFiiForPartners"].map((x0) => x0 ),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(DecryptedFinancialInstitutionInformation value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"key" : value.key,
			"bankAccount" : value.bankAccount,
			"bic" : value.bic,
			"proxyBankAccount" : value.proxyBankAccount,
			"proxyBic" : value.proxyBic,
			"preferredFiiForPartners" : value.preferredFiiForPartners.map((x0) => x0),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}