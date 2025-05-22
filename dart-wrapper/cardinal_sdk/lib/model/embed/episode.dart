// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/episode.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "episode.freezed.dart";


sealed class Episode implements Encryptable, Identifiable<String>, Named {
	@override abstract final String id;
	@override abstract final String? name;
	abstract final String? comment;
	abstract final int? startDate;
	abstract final int? endDate;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(Episode value) {
		switch (value) {
			case DecryptedEpisode entity:
				Map<String, dynamic> entityJson = DecryptedEpisode.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedEpisode";
				return entityJson;
			case EncryptedEpisode entity:
				Map<String, dynamic> entityJson = EncryptedEpisode.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedEpisode";
				return entityJson;
		}
	}

	static Episode fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedEpisode":
				return DecryptedEpisode.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedEpisode":
				return EncryptedEpisode.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedEpisode with _$DecryptedEpisode implements Episode {
	const factory DecryptedEpisode({
		required String id,
		@Default(null) String? name,
		@Default(null) String? comment,
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedEpisode;


	static Map<String, dynamic> encode(DecryptedEpisode value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"name" : value.name,
			"comment" : value.comment,
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedEpisode fromJSON(Map<String, dynamic> data) {
		return DecryptedEpisode(
			id: (data["id"] as String),
			name: (data["name"] as String?),
			comment: (data["comment"] as String?),
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}

@freezed
abstract class EncryptedEpisode with _$EncryptedEpisode implements Episode {
	const factory EncryptedEpisode({
		required String id,
		@Default(null) String? name,
		@Default(null) String? comment,
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedEpisode;


	static Map<String, dynamic> encode(EncryptedEpisode value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"name" : value.name,
			"comment" : value.comment,
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedEpisode fromJSON(Map<String, dynamic> data) {
		return EncryptedEpisode(
			id: (data["id"] as String),
			name: (data["name"] as String?),
			comment: (data["comment"] as String?),
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}