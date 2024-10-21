// This file is auto-generated
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
}

class DecryptedEpisode implements Episode {
	@override  String id;
	@override  String? name;
	@override  String? comment;
	@override  int? startDate;
	@override  int? endDate;
	@override  Base64String? encryptedSelf;

	DecryptedEpisode({
		required this.id,
		this.name,
		this.comment,
		this.startDate,
		this.endDate,
		this.encryptedSelf
	});

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
}

class EncryptedEpisode implements Episode {
	@override  String id;
	@override  String? name;
	@override  String? comment;
	@override  int? startDate;
	@override  int? endDate;
	@override  Base64String? encryptedSelf;

	EncryptedEpisode({
		required this.id,
		this.name,
		this.comment,
		this.startDate,
		this.endDate,
		this.encryptedSelf
	});

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
}