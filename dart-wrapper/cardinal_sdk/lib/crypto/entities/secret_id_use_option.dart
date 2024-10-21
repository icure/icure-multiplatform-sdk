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
}

class SecretIdUseOptionUseAnyConfidential implements SecretIdUseOption {
	static final SecretIdUseOptionUseAnyConfidential _singleton = SecretIdUseOptionUseAnyConfidential._internal();

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

	SecretIdUseOptionUse({
		required this.secretIds
	});

	static Map<String, dynamic> encode(SecretIdUseOptionUse value) {
		Map<String, dynamic> entityAsMap = {
			"secretIds" : value.secretIds.map((x0) => x0)
		};
		return entityAsMap;
	}
}