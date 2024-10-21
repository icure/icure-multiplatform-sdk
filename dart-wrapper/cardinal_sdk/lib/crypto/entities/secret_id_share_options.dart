// This file is auto-generated


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
}

class SecretIdShareOptionsAllAvailable implements SecretIdShareOptions {
	bool requireAtLeastOne;

	SecretIdShareOptionsAllAvailable({
		required this.requireAtLeastOne
	});

	static Map<String, dynamic> encode(SecretIdShareOptionsAllAvailable value) {
		Map<String, dynamic> entityAsMap = {
			"requireAtLeastOne" : value.requireAtLeastOne
		};
		return entityAsMap;
	}
}

class SecretIdShareOptionsUseExactly implements SecretIdShareOptions {
	Set<String> secretIds;
	bool createUnknownSecretIds;

	SecretIdShareOptionsUseExactly({
		required this.secretIds,
		required this.createUnknownSecretIds
	});

	static Map<String, dynamic> encode(SecretIdShareOptionsUseExactly value) {
		Map<String, dynamic> entityAsMap = {
			"secretIds" : value.secretIds.map((x0) => x0),
			"createUnknownSecretIds" : value.createUnknownSecretIds
		};
		return entityAsMap;
	}
}