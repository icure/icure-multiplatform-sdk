// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "secret_id_share_options.freezed.dart";


sealed class SecretIdShareOptions {

	static Map<String, dynamic> encode(SecretIdShareOptions value) {
		switch (value) {
			case SecretIdShareOptionsAllAvailable entity:
				Map<String, dynamic> entityJson = SecretIdShareOptionsAllAvailable.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable";
				return entityJson;
			case SecretIdShareOptionsUseExactly entity:
				Map<String, dynamic> entityJson = SecretIdShareOptionsUseExactly.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly";
				return entityJson;
		}
	}

	static SecretIdShareOptions fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable":
				return SecretIdShareOptionsAllAvailable.fromJSON(data);
			case "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly":
				return SecretIdShareOptionsUseExactly.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class SecretIdShareOptionsAllAvailable with _$SecretIdShareOptionsAllAvailable implements SecretIdShareOptions {
	const factory SecretIdShareOptionsAllAvailable({
		@Default(false) bool requireAtLeastOne,
	}) = _SecretIdShareOptionsAllAvailable;


	static Map<String, dynamic> encode(SecretIdShareOptionsAllAvailable value) {
		Map<String, dynamic> entityAsMap = {
			"requireAtLeastOne" : value.requireAtLeastOne
		};
		return entityAsMap;
	}

	static SecretIdShareOptionsAllAvailable fromJSON(Map<String, dynamic> data) {
		return SecretIdShareOptionsAllAvailable(
			requireAtLeastOne: (data["requireAtLeastOne"] as bool)
		);
	}
}

@freezed
abstract class SecretIdShareOptionsUseExactly with _$SecretIdShareOptionsUseExactly implements SecretIdShareOptions {
	const factory SecretIdShareOptionsUseExactly({
		required Set<String> secretIds,
		required bool createUnknownSecretIds,
	}) = _SecretIdShareOptionsUseExactly;


	static Map<String, dynamic> encode(SecretIdShareOptionsUseExactly value) {
		Map<String, dynamic> entityAsMap = {
			"secretIds" : value.secretIds.map((x0) => x0).toList(),
			"createUnknownSecretIds" : value.createUnknownSecretIds
		};
		return entityAsMap;
	}

	static SecretIdShareOptionsUseExactly fromJSON(Map<String, dynamic> data) {
		return SecretIdShareOptionsUseExactly(
			secretIds: (data["secretIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			createUnknownSecretIds: (data["createUnknownSecretIds"] as bool)
		);
	}
}