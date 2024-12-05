// auto-generated file
import 'package:cardinal_sdk/crypto/entities/entity_with_encryption_metadata_type_name.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';


class EntityWithTypeInfo<T extends HasEncryptionMetadata> {
	T entity;
	EntityWithEncryptionMetadataTypeName type;
	EntityWithTypeInfo(
		this.entity,
		this.type
		);

	static Map<String, dynamic> encode<T extends HasEncryptionMetadata>(EntityWithTypeInfo<T> value, dynamic Function(T)  encodeT) {
		Map<String, dynamic> entityAsMap = {
			"entity" : encodeT(value.entity),
			"type" : EntityWithEncryptionMetadataTypeName.encode(value.type)
		};
		return entityAsMap;
	}

	static EntityWithTypeInfo<T> fromJSON<T extends HasEncryptionMetadata>(Map<String, dynamic> data, T Function(dynamic)  decodeT) {
		return EntityWithTypeInfo(
			decodeT(data["entity"]),
			EntityWithEncryptionMetadataTypeName.fromJSON(data["type"])
		);
	}
}