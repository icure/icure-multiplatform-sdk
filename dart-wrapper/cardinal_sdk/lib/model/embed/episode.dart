// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/episode.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/model/base/named.dart';


sealed class Episode implements Encryptable, Identifiable<String>, Named {
	@override abstract String id;
	@override abstract String? name;
	abstract String? comment;
	abstract int? startDate;
	abstract int? endDate;
	@override abstract Base64String? encryptedSelf;

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

class DecryptedEpisode implements Episode {
	@override String id;
	@override String? name = null;
	@override String? comment = null;
	@override int? startDate = null;
	@override int? endDate = null;
	@override Base64String? encryptedSelf = null;
	DecryptedEpisode(
		this.id,
		{
			String? name,
			String? comment,
			int? startDate,
			int? endDate,
			Base64String? encryptedSelf
		}) : name = name ?? null,
		comment = comment ?? null,
		startDate = startDate ?? null,
		endDate = endDate ?? null,
		encryptedSelf = encryptedSelf ?? null;

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
			(data["id"] as String),
			name: (data["name"] as String?),
			comment: (data["comment"] as String?),
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}

class EncryptedEpisode implements Episode {
	@override String id;
	@override String? name = null;
	@override String? comment = null;
	@override int? startDate = null;
	@override int? endDate = null;
	@override Base64String? encryptedSelf = null;
	EncryptedEpisode(
		this.id,
		{
			String? name,
			String? comment,
			int? startDate,
			int? endDate,
			Base64String? encryptedSelf
		}) : name = name ?? null,
		comment = comment ?? null,
		startDate = startDate ?? null,
		endDate = endDate ?? null,
		encryptedSelf = encryptedSelf ?? null;

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
			(data["id"] as String),
			name: (data["name"] as String?),
			comment: (data["comment"] as String?),
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}