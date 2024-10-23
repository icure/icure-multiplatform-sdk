// auto-generated file


class SecretIdUseOption {
	final Map<String, dynamic> _json;
	static const SecretIdUseOption UseAnyConfidential = SecretIdUseOption._internal({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential"});
	static const SecretIdUseOption UseAnySharedWithParent = SecretIdUseOption._internal({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent"});
	const SecretIdUseOption._internal(this._json);

	factory SecretIdUseOption.Use(Set<String> secretIds) {
		return SecretIdUseOption._internal({"secretIds": secretIds.map((x0) => x0), "kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use"});
	}

	factory SecretIdUseOption.fromJSON(Map<String, dynamic> data) {
		return SecretIdUseOption._internal(data);
	}

	static Map<String, dynamic> encode(SecretIdUseOption value) {
		return Map.unmodifiable(value._json);
	}
}