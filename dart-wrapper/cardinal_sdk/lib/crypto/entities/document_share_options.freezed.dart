// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'document_share_options.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DocumentShareOptions {
  RequestedPermission get requestedPermissions;
  ShareMetadataBehaviour get shareEncryptionKey;
  ShareMetadataBehaviour get shareMessageId;
  SecretIdShareOptions get shareSecretIds;

  /// Create a copy of DocumentShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DocumentShareOptionsCopyWith<DocumentShareOptions> get copyWith =>
      _$DocumentShareOptionsCopyWithImpl<DocumentShareOptions>(
          this as DocumentShareOptions, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DocumentShareOptions &&
            (identical(other.requestedPermissions, requestedPermissions) ||
                other.requestedPermissions == requestedPermissions) &&
            (identical(other.shareEncryptionKey, shareEncryptionKey) ||
                other.shareEncryptionKey == shareEncryptionKey) &&
            (identical(other.shareMessageId, shareMessageId) ||
                other.shareMessageId == shareMessageId) &&
            (identical(other.shareSecretIds, shareSecretIds) ||
                other.shareSecretIds == shareSecretIds));
  }

  @override
  int get hashCode => Object.hash(runtimeType, requestedPermissions,
      shareEncryptionKey, shareMessageId, shareSecretIds);

  @override
  String toString() {
    return 'DocumentShareOptions(requestedPermissions: $requestedPermissions, shareEncryptionKey: $shareEncryptionKey, shareMessageId: $shareMessageId, shareSecretIds: $shareSecretIds)';
  }
}

/// @nodoc
abstract mixin class $DocumentShareOptionsCopyWith<$Res> {
  factory $DocumentShareOptionsCopyWith(DocumentShareOptions value,
          $Res Function(DocumentShareOptions) _then) =
      _$DocumentShareOptionsCopyWithImpl;
  @useResult
  $Res call(
      {RequestedPermission requestedPermissions,
      ShareMetadataBehaviour shareEncryptionKey,
      ShareMetadataBehaviour shareMessageId,
      SecretIdShareOptions shareSecretIds});
}

/// @nodoc
class _$DocumentShareOptionsCopyWithImpl<$Res>
    implements $DocumentShareOptionsCopyWith<$Res> {
  _$DocumentShareOptionsCopyWithImpl(this._self, this._then);

  final DocumentShareOptions _self;
  final $Res Function(DocumentShareOptions) _then;

  /// Create a copy of DocumentShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? requestedPermissions = null,
    Object? shareEncryptionKey = null,
    Object? shareMessageId = null,
    Object? shareSecretIds = null,
  }) {
    return _then(_self.copyWith(
      requestedPermissions: null == requestedPermissions
          ? _self.requestedPermissions
          : requestedPermissions // ignore: cast_nullable_to_non_nullable
              as RequestedPermission,
      shareEncryptionKey: null == shareEncryptionKey
          ? _self.shareEncryptionKey
          : shareEncryptionKey // ignore: cast_nullable_to_non_nullable
              as ShareMetadataBehaviour,
      shareMessageId: null == shareMessageId
          ? _self.shareMessageId
          : shareMessageId // ignore: cast_nullable_to_non_nullable
              as ShareMetadataBehaviour,
      shareSecretIds: null == shareSecretIds
          ? _self.shareSecretIds
          : shareSecretIds // ignore: cast_nullable_to_non_nullable
              as SecretIdShareOptions,
    ));
  }
}

/// @nodoc

class _DocumentShareOptions implements DocumentShareOptions {
  const _DocumentShareOptions(
      {this.requestedPermissions = RequestedPermission.maxWrite,
      this.shareEncryptionKey = ShareMetadataBehaviour.ifAvailable,
      this.shareMessageId = ShareMetadataBehaviour.ifAvailable,
      this.shareSecretIds = const SecretIdShareOptionsAllAvailable()});

  @override
  @JsonKey()
  final RequestedPermission requestedPermissions;
  @override
  @JsonKey()
  final ShareMetadataBehaviour shareEncryptionKey;
  @override
  @JsonKey()
  final ShareMetadataBehaviour shareMessageId;
  @override
  @JsonKey()
  final SecretIdShareOptions shareSecretIds;

  /// Create a copy of DocumentShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DocumentShareOptionsCopyWith<_DocumentShareOptions> get copyWith =>
      __$DocumentShareOptionsCopyWithImpl<_DocumentShareOptions>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DocumentShareOptions &&
            (identical(other.requestedPermissions, requestedPermissions) ||
                other.requestedPermissions == requestedPermissions) &&
            (identical(other.shareEncryptionKey, shareEncryptionKey) ||
                other.shareEncryptionKey == shareEncryptionKey) &&
            (identical(other.shareMessageId, shareMessageId) ||
                other.shareMessageId == shareMessageId) &&
            (identical(other.shareSecretIds, shareSecretIds) ||
                other.shareSecretIds == shareSecretIds));
  }

  @override
  int get hashCode => Object.hash(runtimeType, requestedPermissions,
      shareEncryptionKey, shareMessageId, shareSecretIds);

  @override
  String toString() {
    return 'DocumentShareOptions(requestedPermissions: $requestedPermissions, shareEncryptionKey: $shareEncryptionKey, shareMessageId: $shareMessageId, shareSecretIds: $shareSecretIds)';
  }
}

/// @nodoc
abstract mixin class _$DocumentShareOptionsCopyWith<$Res>
    implements $DocumentShareOptionsCopyWith<$Res> {
  factory _$DocumentShareOptionsCopyWith(_DocumentShareOptions value,
          $Res Function(_DocumentShareOptions) _then) =
      __$DocumentShareOptionsCopyWithImpl;
  @override
  @useResult
  $Res call(
      {RequestedPermission requestedPermissions,
      ShareMetadataBehaviour shareEncryptionKey,
      ShareMetadataBehaviour shareMessageId,
      SecretIdShareOptions shareSecretIds});
}

/// @nodoc
class __$DocumentShareOptionsCopyWithImpl<$Res>
    implements _$DocumentShareOptionsCopyWith<$Res> {
  __$DocumentShareOptionsCopyWithImpl(this._self, this._then);

  final _DocumentShareOptions _self;
  final $Res Function(_DocumentShareOptions) _then;

  /// Create a copy of DocumentShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? requestedPermissions = null,
    Object? shareEncryptionKey = null,
    Object? shareMessageId = null,
    Object? shareSecretIds = null,
  }) {
    return _then(_DocumentShareOptions(
      requestedPermissions: null == requestedPermissions
          ? _self.requestedPermissions
          : requestedPermissions // ignore: cast_nullable_to_non_nullable
              as RequestedPermission,
      shareEncryptionKey: null == shareEncryptionKey
          ? _self.shareEncryptionKey
          : shareEncryptionKey // ignore: cast_nullable_to_non_nullable
              as ShareMetadataBehaviour,
      shareMessageId: null == shareMessageId
          ? _self.shareMessageId
          : shareMessageId // ignore: cast_nullable_to_non_nullable
              as ShareMetadataBehaviour,
      shareSecretIds: null == shareSecretIds
          ? _self.shareSecretIds
          : shareSecretIds // ignore: cast_nullable_to_non_nullable
              as SecretIdShareOptions,
    ));
  }
}

// dart format on
