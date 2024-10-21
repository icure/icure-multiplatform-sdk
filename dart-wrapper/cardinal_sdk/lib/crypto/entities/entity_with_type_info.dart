// This file is auto-generated
import 'package:cardinal_sdk/crypto/entities/entity_with_encryption_metadata_type_name.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';


class EntityWithTypeInfo<T extends HasEncryptionMetadata> {
	T entity;
	EntityWithEncryptionMetadataTypeName type;

	EntityWithTypeInfo({
		required this.entity,
		required this.type
	});

	static Map<String, dynamic> encode(EntityWithTypeInfo value) {
		Map<String, dynamic> entityAsMap = {
			"entity" : HasEncryptionMetadata.encode(value.entity),
			"type" : EntityWithEncryptionMetadataTypeName.encode(value.type)
		};
		return entityAsMap;
	}
}