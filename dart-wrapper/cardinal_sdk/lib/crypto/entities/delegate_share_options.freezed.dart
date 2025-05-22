// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'delegate_share_options.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DelegateShareOptions {
  Set<String> get shareSecretIds;
  Set<HexString> get shareEncryptionKeys;
  Set<String> get shareOwningEntityIds;
  RequestedPermission get requestedPermissions;

  /// Create a copy of DelegateShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DelegateShareOptionsCopyWith<DelegateShareOptions> get copyWith =>
      _$DelegateShareOptionsCopyWithImpl<DelegateShareOptions>(
          this as DelegateShareOptions, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DelegateShareOptions &&
            const DeepCollectionEquality()
                .equals(other.shareSecretIds, shareSecretIds) &&
            const DeepCollectionEquality()
                .equals(other.shareEncryptionKeys, shareEncryptionKeys) &&
            const DeepCollectionEquality()
                .equals(other.shareOwningEntityIds, shareOwningEntityIds) &&
            (identical(other.requestedPermissions, requestedPermissions) ||
                other.requestedPermissions == requestedPermissions));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(shareSecretIds),
      const DeepCollectionEquality().hash(shareEncryptionKeys),
      const DeepCollectionEquality().hash(shareOwningEntityIds),
      requestedPermissions);

  @override
  String toString() {
    return 'DelegateShareOptions(shareSecretIds: $shareSecretIds, shareEncryptionKeys: $shareEncryptionKeys, shareOwningEntityIds: $shareOwningEntityIds, requestedPermissions: $requestedPermissions)';
  }
}

/// @nodoc
abstract mixin class $DelegateShareOptionsCopyWith<$Res> {
  factory $DelegateShareOptionsCopyWith(DelegateShareOptions value,
          $Res Function(DelegateShareOptions) _then) =
      _$DelegateShareOptionsCopyWithImpl;
  @useResult
  $Res call(
      {Set<String> shareSecretIds,
      Set<HexString> shareEncryptionKeys,
      Set<String> shareOwningEntityIds,
      RequestedPermission requestedPermissions});
}

/// @nodoc
class _$DelegateShareOptionsCopyWithImpl<$Res>
    implements $DelegateShareOptionsCopyWith<$Res> {
  _$DelegateShareOptionsCopyWithImpl(this._self, this._then);

  final DelegateShareOptions _self;
  final $Res Function(DelegateShareOptions) _then;

  /// Create a copy of DelegateShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? shareSecretIds = null,
    Object? shareEncryptionKeys = null,
    Object? shareOwningEntityIds = null,
    Object? requestedPermissions = null,
  }) {
    return _then(_self.copyWith(
      shareSecretIds: null == shareSecretIds
          ? _self.shareSecretIds
          : shareSecretIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      shareEncryptionKeys: null == shareEncryptionKeys
          ? _self.shareEncryptionKeys
          : shareEncryptionKeys // ignore: cast_nullable_to_non_nullable
              as Set<HexString>,
      shareOwningEntityIds: null == shareOwningEntityIds
          ? _self.shareOwningEntityIds
          : shareOwningEntityIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      requestedPermissions: null == requestedPermissions
          ? _self.requestedPermissions
          : requestedPermissions // ignore: cast_nullable_to_non_nullable
              as RequestedPermission,
    ));
  }
}

/// @nodoc

class _DelegateShareOptions implements DelegateShareOptions {
  const _DelegateShareOptions(
      {required final Set<String> shareSecretIds,
      required final Set<HexString> shareEncryptionKeys,
      required final Set<String> shareOwningEntityIds,
      required this.requestedPermissions})
      : _shareSecretIds = shareSecretIds,
        _shareEncryptionKeys = shareEncryptionKeys,
        _shareOwningEntityIds = shareOwningEntityIds;

  final Set<String> _shareSecretIds;
  @override
  Set<String> get shareSecretIds {
    if (_shareSecretIds is EqualUnmodifiableSetView) return _shareSecretIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_shareSecretIds);
  }

  final Set<HexString> _shareEncryptionKeys;
  @override
  Set<HexString> get shareEncryptionKeys {
    if (_shareEncryptionKeys is EqualUnmodifiableSetView)
      return _shareEncryptionKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_shareEncryptionKeys);
  }

  final Set<String> _shareOwningEntityIds;
  @override
  Set<String> get shareOwningEntityIds {
    if (_shareOwningEntityIds is EqualUnmodifiableSetView)
      return _shareOwningEntityIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_shareOwningEntityIds);
  }

  @override
  final RequestedPermission requestedPermissions;

  /// Create a copy of DelegateShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DelegateShareOptionsCopyWith<_DelegateShareOptions> get copyWith =>
      __$DelegateShareOptionsCopyWithImpl<_DelegateShareOptions>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DelegateShareOptions &&
            const DeepCollectionEquality()
                .equals(other._shareSecretIds, _shareSecretIds) &&
            const DeepCollectionEquality()
                .equals(other._shareEncryptionKeys, _shareEncryptionKeys) &&
            const DeepCollectionEquality()
                .equals(other._shareOwningEntityIds, _shareOwningEntityIds) &&
            (identical(other.requestedPermissions, requestedPermissions) ||
                other.requestedPermissions == requestedPermissions));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_shareSecretIds),
      const DeepCollectionEquality().hash(_shareEncryptionKeys),
      const DeepCollectionEquality().hash(_shareOwningEntityIds),
      requestedPermissions);

  @override
  String toString() {
    return 'DelegateShareOptions(shareSecretIds: $shareSecretIds, shareEncryptionKeys: $shareEncryptionKeys, shareOwningEntityIds: $shareOwningEntityIds, requestedPermissions: $requestedPermissions)';
  }
}

/// @nodoc
abstract mixin class _$DelegateShareOptionsCopyWith<$Res>
    implements $DelegateShareOptionsCopyWith<$Res> {
  factory _$DelegateShareOptionsCopyWith(_DelegateShareOptions value,
          $Res Function(_DelegateShareOptions) _then) =
      __$DelegateShareOptionsCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Set<String> shareSecretIds,
      Set<HexString> shareEncryptionKeys,
      Set<String> shareOwningEntityIds,
      RequestedPermission requestedPermissions});
}

/// @nodoc
class __$DelegateShareOptionsCopyWithImpl<$Res>
    implements _$DelegateShareOptionsCopyWith<$Res> {
  __$DelegateShareOptionsCopyWithImpl(this._self, this._then);

  final _DelegateShareOptions _self;
  final $Res Function(_DelegateShareOptions) _then;

  /// Create a copy of DelegateShareOptions
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? shareSecretIds = null,
    Object? shareEncryptionKeys = null,
    Object? shareOwningEntityIds = null,
    Object? requestedPermissions = null,
  }) {
    return _then(_DelegateShareOptions(
      shareSecretIds: null == shareSecretIds
          ? _self._shareSecretIds
          : shareSecretIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      shareEncryptionKeys: null == shareEncryptionKeys
          ? _self._shareEncryptionKeys
          : shareEncryptionKeys // ignore: cast_nullable_to_non_nullable
              as Set<HexString>,
      shareOwningEntityIds: null == shareOwningEntityIds
          ? _self._shareOwningEntityIds
          : shareOwningEntityIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      requestedPermissions: null == requestedPermissions
          ? _self.requestedPermissions
          : requestedPermissions // ignore: cast_nullable_to_non_nullable
              as RequestedPermission,
    ));
  }
}

// dart format on
