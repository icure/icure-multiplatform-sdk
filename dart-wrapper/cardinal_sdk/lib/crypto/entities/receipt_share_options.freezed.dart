// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'receipt_share_options.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ReceiptShareOptions {
  RequestedPermission get requestedPermissions;
  ShareMetadataBehaviour get shareEncryptionKey;
  SecretIdShareOptions get shareSecretIds;

  /// Create a copy of ReceiptShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ReceiptShareOptionsCopyWith<ReceiptShareOptions> get copyWith =>
      _$ReceiptShareOptionsCopyWithImpl<ReceiptShareOptions>(
          this as ReceiptShareOptions, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ReceiptShareOptions &&
            (identical(other.requestedPermissions, requestedPermissions) ||
                other.requestedPermissions == requestedPermissions) &&
            (identical(other.shareEncryptionKey, shareEncryptionKey) ||
                other.shareEncryptionKey == shareEncryptionKey) &&
            (identical(other.shareSecretIds, shareSecretIds) ||
                other.shareSecretIds == shareSecretIds));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, requestedPermissions, shareEncryptionKey, shareSecretIds);

  @override
  String toString() {
    return 'ReceiptShareOptions(requestedPermissions: $requestedPermissions, shareEncryptionKey: $shareEncryptionKey, shareSecretIds: $shareSecretIds)';
  }
}

/// @nodoc
abstract mixin class $ReceiptShareOptionsCopyWith<$Res> {
  factory $ReceiptShareOptionsCopyWith(
          ReceiptShareOptions value, $Res Function(ReceiptShareOptions) _then) =
      _$ReceiptShareOptionsCopyWithImpl;
  @useResult
  $Res call(
      {RequestedPermission requestedPermissions,
      ShareMetadataBehaviour shareEncryptionKey,
      SecretIdShareOptions shareSecretIds});
}

/// @nodoc
class _$ReceiptShareOptionsCopyWithImpl<$Res>
    implements $ReceiptShareOptionsCopyWith<$Res> {
  _$ReceiptShareOptionsCopyWithImpl(this._self, this._then);

  final ReceiptShareOptions _self;
  final $Res Function(ReceiptShareOptions) _then;

  /// Create a copy of ReceiptShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? requestedPermissions = null,
    Object? shareEncryptionKey = null,
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
      shareSecretIds: null == shareSecretIds
          ? _self.shareSecretIds
          : shareSecretIds // ignore: cast_nullable_to_non_nullable
              as SecretIdShareOptions,
    ));
  }
}

/// @nodoc

class _ReceiptShareOptions implements ReceiptShareOptions {
  const _ReceiptShareOptions(
      {this.requestedPermissions = RequestedPermission.maxWrite,
      this.shareEncryptionKey = ShareMetadataBehaviour.ifAvailable,
      this.shareSecretIds = const SecretIdShareOptionsAllAvailable()});

  @override
  @JsonKey()
  final RequestedPermission requestedPermissions;
  @override
  @JsonKey()
  final ShareMetadataBehaviour shareEncryptionKey;
  @override
  @JsonKey()
  final SecretIdShareOptions shareSecretIds;

  /// Create a copy of ReceiptShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ReceiptShareOptionsCopyWith<_ReceiptShareOptions> get copyWith =>
      __$ReceiptShareOptionsCopyWithImpl<_ReceiptShareOptions>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ReceiptShareOptions &&
            (identical(other.requestedPermissions, requestedPermissions) ||
                other.requestedPermissions == requestedPermissions) &&
            (identical(other.shareEncryptionKey, shareEncryptionKey) ||
                other.shareEncryptionKey == shareEncryptionKey) &&
            (identical(other.shareSecretIds, shareSecretIds) ||
                other.shareSecretIds == shareSecretIds));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, requestedPermissions, shareEncryptionKey, shareSecretIds);

  @override
  String toString() {
    return 'ReceiptShareOptions(requestedPermissions: $requestedPermissions, shareEncryptionKey: $shareEncryptionKey, shareSecretIds: $shareSecretIds)';
  }
}

/// @nodoc
abstract mixin class _$ReceiptShareOptionsCopyWith<$Res>
    implements $ReceiptShareOptionsCopyWith<$Res> {
  factory _$ReceiptShareOptionsCopyWith(_ReceiptShareOptions value,
          $Res Function(_ReceiptShareOptions) _then) =
      __$ReceiptShareOptionsCopyWithImpl;
  @override
  @useResult
  $Res call(
      {RequestedPermission requestedPermissions,
      ShareMetadataBehaviour shareEncryptionKey,
      SecretIdShareOptions shareSecretIds});
}

/// @nodoc
class __$ReceiptShareOptionsCopyWithImpl<$Res>
    implements _$ReceiptShareOptionsCopyWith<$Res> {
  __$ReceiptShareOptionsCopyWithImpl(this._self, this._then);

  final _ReceiptShareOptions _self;
  final $Res Function(_ReceiptShareOptions) _then;

  /// Create a copy of ReceiptShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? requestedPermissions = null,
    Object? shareEncryptionKey = null,
    Object? shareSecretIds = null,
  }) {
    return _then(_ReceiptShareOptions(
      requestedPermissions: null == requestedPermissions
          ? _self.requestedPermissions
          : requestedPermissions // ignore: cast_nullable_to_non_nullable
              as RequestedPermission,
      shareEncryptionKey: null == shareEncryptionKey
          ? _self.shareEncryptionKey
          : shareEncryptionKey // ignore: cast_nullable_to_non_nullable
              as ShareMetadataBehaviour,
      shareSecretIds: null == shareSecretIds
          ? _self.shareSecretIds
          : shareSecretIds // ignore: cast_nullable_to_non_nullable
              as SecretIdShareOptions,
    ));
  }
}

// dart format on
