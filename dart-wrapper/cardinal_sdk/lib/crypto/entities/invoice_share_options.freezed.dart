// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'invoice_share_options.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$InvoiceShareOptions {
  RequestedPermission get requestedPermissions;
  ShareMetadataBehaviour get shareEncryptionKey;
  ShareMetadataBehaviour get sharePatientId;
  SecretIdShareOptions get shareSecretIds;

  /// Create a copy of InvoiceShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $InvoiceShareOptionsCopyWith<InvoiceShareOptions> get copyWith =>
      _$InvoiceShareOptionsCopyWithImpl<InvoiceShareOptions>(
          this as InvoiceShareOptions, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is InvoiceShareOptions &&
            (identical(other.requestedPermissions, requestedPermissions) ||
                other.requestedPermissions == requestedPermissions) &&
            (identical(other.shareEncryptionKey, shareEncryptionKey) ||
                other.shareEncryptionKey == shareEncryptionKey) &&
            (identical(other.sharePatientId, sharePatientId) ||
                other.sharePatientId == sharePatientId) &&
            (identical(other.shareSecretIds, shareSecretIds) ||
                other.shareSecretIds == shareSecretIds));
  }

  @override
  int get hashCode => Object.hash(runtimeType, requestedPermissions,
      shareEncryptionKey, sharePatientId, shareSecretIds);

  @override
  String toString() {
    return 'InvoiceShareOptions(requestedPermissions: $requestedPermissions, shareEncryptionKey: $shareEncryptionKey, sharePatientId: $sharePatientId, shareSecretIds: $shareSecretIds)';
  }
}

/// @nodoc
abstract mixin class $InvoiceShareOptionsCopyWith<$Res> {
  factory $InvoiceShareOptionsCopyWith(
          InvoiceShareOptions value, $Res Function(InvoiceShareOptions) _then) =
      _$InvoiceShareOptionsCopyWithImpl;
  @useResult
  $Res call(
      {RequestedPermission requestedPermissions,
      ShareMetadataBehaviour shareEncryptionKey,
      ShareMetadataBehaviour sharePatientId,
      SecretIdShareOptions shareSecretIds});
}

/// @nodoc
class _$InvoiceShareOptionsCopyWithImpl<$Res>
    implements $InvoiceShareOptionsCopyWith<$Res> {
  _$InvoiceShareOptionsCopyWithImpl(this._self, this._then);

  final InvoiceShareOptions _self;
  final $Res Function(InvoiceShareOptions) _then;

  /// Create a copy of InvoiceShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? requestedPermissions = null,
    Object? shareEncryptionKey = null,
    Object? sharePatientId = null,
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
      sharePatientId: null == sharePatientId
          ? _self.sharePatientId
          : sharePatientId // ignore: cast_nullable_to_non_nullable
              as ShareMetadataBehaviour,
      shareSecretIds: null == shareSecretIds
          ? _self.shareSecretIds
          : shareSecretIds // ignore: cast_nullable_to_non_nullable
              as SecretIdShareOptions,
    ));
  }
}

/// @nodoc

class _InvoiceShareOptions implements InvoiceShareOptions {
  const _InvoiceShareOptions(
      {this.requestedPermissions = RequestedPermission.maxWrite,
      this.shareEncryptionKey = ShareMetadataBehaviour.ifAvailable,
      this.sharePatientId = ShareMetadataBehaviour.ifAvailable,
      this.shareSecretIds = const SecretIdShareOptionsAllAvailable()});

  @override
  @JsonKey()
  final RequestedPermission requestedPermissions;
  @override
  @JsonKey()
  final ShareMetadataBehaviour shareEncryptionKey;
  @override
  @JsonKey()
  final ShareMetadataBehaviour sharePatientId;
  @override
  @JsonKey()
  final SecretIdShareOptions shareSecretIds;

  /// Create a copy of InvoiceShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$InvoiceShareOptionsCopyWith<_InvoiceShareOptions> get copyWith =>
      __$InvoiceShareOptionsCopyWithImpl<_InvoiceShareOptions>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _InvoiceShareOptions &&
            (identical(other.requestedPermissions, requestedPermissions) ||
                other.requestedPermissions == requestedPermissions) &&
            (identical(other.shareEncryptionKey, shareEncryptionKey) ||
                other.shareEncryptionKey == shareEncryptionKey) &&
            (identical(other.sharePatientId, sharePatientId) ||
                other.sharePatientId == sharePatientId) &&
            (identical(other.shareSecretIds, shareSecretIds) ||
                other.shareSecretIds == shareSecretIds));
  }

  @override
  int get hashCode => Object.hash(runtimeType, requestedPermissions,
      shareEncryptionKey, sharePatientId, shareSecretIds);

  @override
  String toString() {
    return 'InvoiceShareOptions(requestedPermissions: $requestedPermissions, shareEncryptionKey: $shareEncryptionKey, sharePatientId: $sharePatientId, shareSecretIds: $shareSecretIds)';
  }
}

/// @nodoc
abstract mixin class _$InvoiceShareOptionsCopyWith<$Res>
    implements $InvoiceShareOptionsCopyWith<$Res> {
  factory _$InvoiceShareOptionsCopyWith(_InvoiceShareOptions value,
          $Res Function(_InvoiceShareOptions) _then) =
      __$InvoiceShareOptionsCopyWithImpl;
  @override
  @useResult
  $Res call(
      {RequestedPermission requestedPermissions,
      ShareMetadataBehaviour shareEncryptionKey,
      ShareMetadataBehaviour sharePatientId,
      SecretIdShareOptions shareSecretIds});
}

/// @nodoc
class __$InvoiceShareOptionsCopyWithImpl<$Res>
    implements _$InvoiceShareOptionsCopyWith<$Res> {
  __$InvoiceShareOptionsCopyWithImpl(this._self, this._then);

  final _InvoiceShareOptions _self;
  final $Res Function(_InvoiceShareOptions) _then;

  /// Create a copy of InvoiceShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? requestedPermissions = null,
    Object? shareEncryptionKey = null,
    Object? sharePatientId = null,
    Object? shareSecretIds = null,
  }) {
    return _then(_InvoiceShareOptions(
      requestedPermissions: null == requestedPermissions
          ? _self.requestedPermissions
          : requestedPermissions // ignore: cast_nullable_to_non_nullable
              as RequestedPermission,
      shareEncryptionKey: null == shareEncryptionKey
          ? _self.shareEncryptionKey
          : shareEncryptionKey // ignore: cast_nullable_to_non_nullable
              as ShareMetadataBehaviour,
      sharePatientId: null == sharePatientId
          ? _self.sharePatientId
          : sharePatientId // ignore: cast_nullable_to_non_nullable
              as ShareMetadataBehaviour,
      shareSecretIds: null == shareSecretIds
          ? _self.shareSecretIds
          : shareSecretIds // ignore: cast_nullable_to_non_nullable
              as SecretIdShareOptions,
    ));
  }
}

// dart format on
