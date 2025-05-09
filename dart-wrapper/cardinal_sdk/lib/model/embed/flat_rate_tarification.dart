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
	@override String? code = null;
	@override FlatRateType? flatRateType = null;
	@override Map<String, String>? label = null;
	@override List<EncryptedValorisation> valorisations = [];
	@override Base64String? encryptedSelf = null;
	EncryptedFlatRateTarification({
			String? code,
			FlatRateType? flatRateType,
			Map<String, String>? label,
			List<EncryptedValorisation>? valorisations,
			Base64String? encryptedSelf
		}) : code = code ?? null,
		flatRateType = flatRateType ?? null,
		label = label ?? null,
		valorisations = valorisations ?? [],
		encryptedSelf = encryptedSelf ?? null;

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

	static EncryptedFlatRateTarification fromJSON(Map<String, dynamic> data) {
		return EncryptedFlatRateTarification(
			code: (data["code"] as String?),
			flatRateType: data["flatRateType"] == null ? null : FlatRateType.fromJSON(data["flatRateType"]),
			label: (data["label"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			valorisations: (data["valorisations"] as List<dynamic>).map((x0) => EncryptedValorisation.fromJSON(x0) ).toList(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

class DecryptedFlatRateTarification implements FlatRateTarification {
	@override String? code = null;
	@override FlatRateType? flatRateType = null;
	@override Map<String, String>? label = null;
	@override List<DecryptedValorisation> valorisations = [];
	@override Base64String? encryptedSelf = null;
	DecryptedFlatRateTarification({
			String? code,
			FlatRateType? flatRateType,
			Map<String, String>? label,
			List<DecryptedValorisation>? valorisations,
			Base64String? encryptedSelf
		}) : code = code ?? null,
		flatRateType = flatRateType ?? null,
		label = label ?? null,
		valorisations = valorisations ?? [],
		encryptedSelf = encryptedSelf ?? null;

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

	static DecryptedFlatRateTarification fromJSON(Map<String, dynamic> data) {
		return DecryptedFlatRateTarification(
			code: (data["code"] as String?),
			flatRateType: data["flatRateType"] == null ? null : FlatRateType.fromJSON(data["flatRateType"]),
			label: (data["label"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			valorisations: (data["valorisations"] as List<dynamic>).map((x0) => DecryptedValorisation.fromJSON(x0) ).toList(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}