// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'entity_with_type_info.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EntityWithTypeInfo<T extends HasEncryptionMetadata> {
  T get entity;
  EntityWithEncryptionMetadataTypeName get type;

  /// Create a copy of EntityWithTypeInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EntityWithTypeInfoCopyWith<T, EntityWithTypeInfo<T>> get copyWith =>
      _$EntityWithTypeInfoCopyWithImpl<T, EntityWithTypeInfo<T>>(
          this as EntityWithTypeInfo<T>, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EntityWithTypeInfo<T> &&
            const DeepCollectionEquality().equals(other.entity, entity) &&
            (identical(other.type, type) || other.type == type));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(entity), type);

  @override
  String toString() {
    return 'EntityWithTypeInfo<$T>(entity: $entity, type: $type)';
  }
}

/// @nodoc
abstract mixin class $EntityWithTypeInfoCopyWith<
    T extends HasEncryptionMetadata, $Res> {
  factory $EntityWithTypeInfoCopyWith(EntityWithTypeInfo<T> value,
          $Res Function(EntityWithTypeInfo<T>) _then) =
      _$EntityWithTypeInfoCopyWithImpl;
  @useResult
  $Res call({T entity, EntityWithEncryptionMetadataTypeName type});
}

/// @nodoc
class _$EntityWithTypeInfoCopyWithImpl<T extends HasEncryptionMetadata, $Res>
    implements $EntityWithTypeInfoCopyWith<T, $Res> {
  _$EntityWithTypeInfoCopyWithImpl(this._self, this._then);

  final EntityWithTypeInfo<T> _self;
  final $Res Function(EntityWithTypeInfo<T>) _then;

  /// Create a copy of EntityWithTypeInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? entity = null,
    Object? type = null,
  }) {
    return _then(_self.copyWith(
      entity: null == entity
          ? _self.entity
          : entity // ignore: cast_nullable_to_non_nullable
              as T,
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as EntityWithEncryptionMetadataTypeName,
    ));
  }
}

/// @nodoc

class _EntityWithTypeInfo<T extends HasEncryptionMetadata>
    implements EntityWithTypeInfo<T> {
  const _EntityWithTypeInfo({required this.entity, required this.type});

  @override
  final T entity;
  @override
  final EntityWithEncryptionMetadataTypeName type;

  /// Create a copy of EntityWithTypeInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EntityWithTypeInfoCopyWith<T, _EntityWithTypeInfo<T>> get copyWith =>
      __$EntityWithTypeInfoCopyWithImpl<T, _EntityWithTypeInfo<T>>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EntityWithTypeInfo<T> &&
            const DeepCollectionEquality().equals(other.entity, entity) &&
            (identical(other.type, type) || other.type == type));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(entity), type);

  @override
  String toString() {
    return 'EntityWithTypeInfo<$T>(entity: $entity, type: $type)';
  }
}

/// @nodoc
abstract mixin class _$EntityWithTypeInfoCopyWith<
    T extends HasEncryptionMetadata,
    $Res> implements $EntityWithTypeInfoCopyWith<T, $Res> {
  factory _$EntityWithTypeInfoCopyWith(_EntityWithTypeInfo<T> value,
          $Res Function(_EntityWithTypeInfo<T>) _then) =
      __$EntityWithTypeInfoCopyWithImpl;
  @override
  @useResult
  $Res call({T entity, EntityWithEncryptionMetadataTypeName type});
}

/// @nodoc
class __$EntityWithTypeInfoCopyWithImpl<T extends HasEncryptionMetadata, $Res>
    implements _$EntityWithTypeInfoCopyWith<T, $Res> {
  __$EntityWithTypeInfoCopyWithImpl(this._self, this._then);

  final _EntityWithTypeInfo<T> _self;
  final $Res Function(_EntityWithTypeInfo<T>) _then;

  /// Create a copy of EntityWithTypeInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? entity = null,
    Object? type = null,
  }) {
    return _then(_EntityWithTypeInfo<T>(
      entity: null == entity
          ? _self.entity
          : entity // ignore: cast_nullable_to_non_nullable
              as T,
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as EntityWithEncryptionMetadataTypeName,
    ));
  }
}

// dart format on
