// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'maintenance_task_share_options.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$MaintenanceTaskShareOptions {
  RequestedPermission get requestedPermissions;
  ShareMetadataBehaviour get shareEncryptionKey;
  SecretIdShareOptions get shareSecretIds;

  /// Create a copy of MaintenanceTaskShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $MaintenanceTaskShareOptionsCopyWith<MaintenanceTaskShareOptions>
      get copyWith => _$MaintenanceTaskShareOptionsCopyWithImpl<
              MaintenanceTaskShareOptions>(
          this as MaintenanceTaskShareOptions, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is MaintenanceTaskShareOptions &&
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
    return 'MaintenanceTaskShareOptions(requestedPermissions: $requestedPermissions, shareEncryptionKey: $shareEncryptionKey, shareSecretIds: $shareSecretIds)';
  }
}

/// @nodoc
abstract mixin class $MaintenanceTaskShareOptionsCopyWith<$Res> {
  factory $MaintenanceTaskShareOptionsCopyWith(
          MaintenanceTaskShareOptions value,
          $Res Function(MaintenanceTaskShareOptions) _then) =
      _$MaintenanceTaskShareOptionsCopyWithImpl;
  @useResult
  $Res call(
      {RequestedPermission requestedPermissions,
      ShareMetadataBehaviour shareEncryptionKey,
      SecretIdShareOptions shareSecretIds});
}

/// @nodoc
class _$MaintenanceTaskShareOptionsCopyWithImpl<$Res>
    implements $MaintenanceTaskShareOptionsCopyWith<$Res> {
  _$MaintenanceTaskShareOptionsCopyWithImpl(this._self, this._then);

  final MaintenanceTaskShareOptions _self;
  final $Res Function(MaintenanceTaskShareOptions) _then;

  /// Create a copy of MaintenanceTaskShareOptions
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

class _MaintenanceTaskShareOptions implements MaintenanceTaskShareOptions {
  const _MaintenanceTaskShareOptions(
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

  /// Create a copy of MaintenanceTaskShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$MaintenanceTaskShareOptionsCopyWith<_MaintenanceTaskShareOptions>
      get copyWith => __$MaintenanceTaskShareOptionsCopyWithImpl<
          _MaintenanceTaskShareOptions>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _MaintenanceTaskShareOptions &&
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
    return 'MaintenanceTaskShareOptions(requestedPermissions: $requestedPermissions, shareEncryptionKey: $shareEncryptionKey, shareSecretIds: $shareSecretIds)';
  }
}

/// @nodoc
abstract mixin class _$MaintenanceTaskShareOptionsCopyWith<$Res>
    implements $MaintenanceTaskShareOptionsCopyWith<$Res> {
  factory _$MaintenanceTaskShareOptionsCopyWith(
          _MaintenanceTaskShareOptions value,
          $Res Function(_MaintenanceTaskShareOptions) _then) =
      __$MaintenanceTaskShareOptionsCopyWithImpl;
  @override
  @useResult
  $Res call(
      {RequestedPermission requestedPermissions,
      ShareMetadataBehaviour shareEncryptionKey,
      SecretIdShareOptions shareSecretIds});
}

/// @nodoc
class __$MaintenanceTaskShareOptionsCopyWithImpl<$Res>
    implements _$MaintenanceTaskShareOptionsCopyWith<$Res> {
  __$MaintenanceTaskShareOptionsCopyWithImpl(this._self, this._then);

  final _MaintenanceTaskShareOptions _self;
  final $Res Function(_MaintenanceTaskShareOptions) _then;

  /// Create a copy of MaintenanceTaskShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? requestedPermissions = null,
    Object? shareEncryptionKey = null,
    Object? shareSecretIds = null,
  }) {
    return _then(_MaintenanceTaskShareOptions(
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
