// auto-generated file
import 'package:cardinal_sdk/model/embed/flat_rate_type.dart';
import 'package:cardinal_sdk/model/embed/valorisation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/flat_rate_tarification.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class FlatRateTarification implements Encryptable {
	abstract String? code;
	abstract FlatRateType? flatRateType;
	abstract Map<String, String>? label;
	List<Valorisation> get valorisations;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(FlatRateTarification value) {
		switch (value) {
			case EncryptedFlatRateTarification entity:
				Map<String, dynamic> entityJson = EncryptedFlatRateTarification.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification";
				return entityJson;
			case DecryptedFlatRateTarification entity:
				Map<String, dynamic> entityJson = DecryptedFlatRateTarification.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification";
				return entityJson;
		}
	}

	static FlatRateTarification fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification":
				return EncryptedFlatRateTarification.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification":
				return DecryptedFlatRateTarification.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedFlatRateTarification implements FlatRateTarification {
	@override String? code;
	@override FlatRateType? flatRateType;
	@override Map<String, String>? label;
	@override List<EncryptedValorisation> valorisations = [];
	@override Base64String? encryptedSelf;
	EncryptedFlatRateTarification({
			this.code,
			this.flatRateType,
			this.label,
			this.encryptedSelf,
			List<EncryptedValorisation>? valorisations
		}) : valorisations = valorisations ?? [];

	factory EncryptedFlatRateTarification.fromJSON(Map<String, dynamic> data) {
		return EncryptedFlatRateTarification(
			code: data["code"],
			flatRateType: data["flatRateType"] == null ? null : FlatRateType.fromJSON(data["flatRateType"]),
			label: data["label"]?.map((k0, v0) => MapEntry(k0, v0)),
			valorisations: data["valorisations"].map((x0) => EncryptedValorisation.fromJSON(x0) ).toList(),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(EncryptedFlatRateTarification value) {
		Map<String, dynamic> entityAsMap = {
			"code" : value.code,
			"flatRateType" : value.flatRateType == null ? null : FlatRateType.encode(value.flatRateType!),
			"label" : value.label?.map((k0, v0) => MapEntry(k0, v0)),
			"valorisations" : value.valorisations.map((x0) => EncryptedValorisation.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedFlatRateTarification implements FlatRateTarification {
	@override String? code;
	@override FlatRateType? flatRateType;
	@override Map<String, String>? label;
	@override List<DecryptedValorisation> valorisations = [];
	@override Base64String? encryptedSelf;
	DecryptedFlatRateTarification({
			this.code,
			this.flatRateType,
			this.label,
			this.encryptedSelf,
			List<DecryptedValorisation>? valorisations
		}) : valorisations = valorisations ?? [];

	factory DecryptedFlatRateTarification.fromJSON(Map<String, dynamic> data) {
		return DecryptedFlatRateTarification(
			code: data["code"],
			flatRateType: data["flatRateType"] == null ? null : FlatRateType.fromJSON(data["flatRateType"]),
			label: data["label"]?.map((k0, v0) => MapEntry(k0, v0)),
			valorisations: data["valorisations"].map((x0) => DecryptedValorisation.fromJSON(x0) ).toList(),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(DecryptedFlatRateTarification value) {
		Map<String, dynamic> entityAsMap = {
			"code" : value.code,
			"flatRateType" : value.flatRateType == null ? null : FlatRateType.encode(value.flatRateType!),
			"label" : value.label?.map((k0, v0) => MapEntry(k0, v0)),
			"valorisations" : value.valorisations.map((x0) => DecryptedValorisation.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}