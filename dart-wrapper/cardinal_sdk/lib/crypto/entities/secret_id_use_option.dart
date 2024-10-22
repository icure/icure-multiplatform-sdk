// This file is auto-generated


sealed class SecretIdUseOption {

	static Map<String, dynamic> encode(SecretIdUseOption value) {
		switch (value) {
			case SecretIdUseOptionUseAnyConfidential _:
				return {"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential"};
			case SecretIdUseOptionUseAnySharedWithParent _:
				return {"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent"};
			case SecretIdUseOptionUse entity:
				Map<String, dynamic> entityJson = SecretIdUseOptionUse.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use";
				return entityJson;
		}
	}

	static SecretIdUseOption fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential":
				return SecretIdUseOptionUseAnyConfidential.fromJSON(data);
			case "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent":
				return SecretIdUseOptionUseAnySharedWithParent.fromJSON(data);
			case "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use":
				return SecretIdUseOptionUse.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class SecretIdUseOptionUseAnyConfidential implements SecretIdUseOption {
	static final SecretIdUseOptionUseAnyConfidential _singleton = SecretIdUseOptionUseAnyConfidential._internal();
	factory SecretIdUseOptionUseAnyConfidential.fromJSON(Map<String, dynamic> data) {
		return SecretIdUseOptionUseAnyConfidential(
		);
	}

	SecretIdUseOptionUseAnyConfidential._internal();

	factory SecretIdUseOptionUseAnyConfidential() {
		return _singleton;
	}

	static Map<String, dynamic> encode(SecretIdUseOptionUseAnyConfidential value) {
		Map<String, dynamic> entityAsMap = {
		};
		return entityAsMap;
	}
}

class SecretIdUseOptionUseAnySharedWithParent implements SecretIdUseOption {
	static final SecretIdUseOptionUseAnySharedWithParent _singleton = SecretIdUseOptionUseAnySharedWithParent._internal();
	factory SecretIdUseOptionUseAnySharedWithParent.fromJSON(Map<String, dynamic> data) {
		return SecretIdUseOptionUseAnySharedWithParent(
		);
	}

	SecretIdUseOptionUseAnySharedWithParent._internal();

	factory SecretIdUseOptionUseAnySharedWithParent() {
		return _singleton;
	}

	static Map<String, dynamic> encode(SecretIdUseOptionUseAnySharedWithParent value) {
		Map<String, dynamic> entityAsMap = {
		};
		return entityAsMap;
	}
}

class SecretIdUseOptionUse implements SecretIdUseOption {
	Set<String> secretIds;
	SecretIdUseOptionUse(this.secretIds);

	factory SecretIdUseOptionUse.fromJSON(Map<String, dynamic> data) {
		return SecretIdUseOptionUse(
			data["secretIds"].map((x0) => x0 )
		);
	}

	static Map<String, dynamic> encode(SecretIdUseOptionUse value) {
		Map<String, dynamic> entityAsMap = {
			"secretIds" : value.secretIds.map((x0) => x0)
		};
		return entityAsMap;
	}
}