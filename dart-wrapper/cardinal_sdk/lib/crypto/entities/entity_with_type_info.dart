// auto-generated file
import 'package:cardinal_sdk/crypto/entities/entity_with_encryption_metadata_type_name.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "entity_with_type_info.freezed.dart";


@freezed
abstract class EntityWithTypeInfo<T extends HasEncryptionMetadata> with _$EntityWithTypeInfo<T> {
	const factory EntityWithTypeInfo({
		required T entity,
		required EntityWithEncryptionMetadataTypeName type,
	}) = _EntityWithTypeInfo;


	static Map<String, dynamic> encode<T extends HasEncryptionMetadata>(EntityWithTypeInfo<T> value, dynamic Function(T) encodeT) {
		Map<String, dynamic> entityAsMap = {
			"entity" : encodeT(value.entity),
			"type" : EntityWithEncryptionMetadataTypeName.encode(value.type)
		};
		return entityAsMap;
	}

	static EntityWithTypeInfo<T> fromJSON<T extends HasEncryptionMetadata>(Map<String, dynamic> data, T Function(dynamic) decodeT) {
		return EntityWithTypeInfo(
			entity: decodeT(data["entity"]),
			type: EntityWithEncryptionMetadataTypeName.fromJSON(data["type"])
		);
	}
}