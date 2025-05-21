// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'security_metadata.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$SecurityMetadata {
  Map<SecureDelegationKeyString, SecureDelegation> get secureDelegations;

  /// Create a copy of SecurityMetadata
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<SecurityMetadata> get copyWith =>
      _$SecurityMetadataCopyWithImpl<SecurityMetadata>(
          this as SecurityMetadata, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is SecurityMetadata &&
            const DeepCollectionEquality()
                .equals(other.secureDelegations, secureDelegations));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(secureDelegations));

  @override
  String toString() {
    return 'SecurityMetadata(secureDelegations: $secureDelegations)';
  }
}

/// @nodoc
abstract mixin class $SecurityMetadataCopyWith<$Res> {
  factory $SecurityMetadataCopyWith(
          SecurityMetadata value, $Res Function(SecurityMetadata) _then) =
      _$SecurityMetadataCopyWithImpl;
  @useResult
  $Res call(
      {Map<SecureDelegationKeyString, SecureDelegation> secureDelegations});
}

/// @nodoc
class _$SecurityMetadataCopyWithImpl<$Res>
    implements $SecurityMetadataCopyWith<$Res> {
  _$SecurityMetadataCopyWithImpl(this._self, this._then);

  final SecurityMetadata _self;
  final $Res Function(SecurityMetadata) _then;

  /// Create a copy of SecurityMetadata
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? secureDelegations = null,
  }) {
    return _then(_self.copyWith(
      secureDelegations: null == secureDelegations
          ? _self.secureDelegations
          : secureDelegations // ignore: cast_nullable_to_non_nullable
              as Map<SecureDelegationKeyString, SecureDelegation>,
    ));
  }
}

/// @nodoc

class _SecurityMetadata implements SecurityMetadata {
  const _SecurityMetadata(
      {required final Map<SecureDelegationKeyString, SecureDelegation>
          secureDelegations})
      : _secureDelegations = secureDelegations;

  final Map<SecureDelegationKeyString, SecureDelegation> _secureDelegations;
  @override
  Map<SecureDelegationKeyString, SecureDelegation> get secureDelegations {
    if (_secureDelegations is EqualUnmodifiableMapView)
      return _secureDelegations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_secureDelegations);
  }

  /// Create a copy of SecurityMetadata
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$SecurityMetadataCopyWith<_SecurityMetadata> get copyWith =>
      __$SecurityMetadataCopyWithImpl<_SecurityMetadata>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _SecurityMetadata &&
            const DeepCollectionEquality()
                .equals(other._secureDelegations, _secureDelegations));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(_secureDelegations));

  @override
  String toString() {
    return 'SecurityMetadata(secureDelegations: $secureDelegations)';
  }
}

/// @nodoc
abstract mixin class _$SecurityMetadataCopyWith<$Res>
    implements $SecurityMetadataCopyWith<$Res> {
  factory _$SecurityMetadataCopyWith(
          _SecurityMetadata value, $Res Function(_SecurityMetadata) _then) =
      __$SecurityMetadataCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Map<SecureDelegationKeyString, SecureDelegation> secureDelegations});
}

/// @nodoc
class __$SecurityMetadataCopyWithImpl<$Res>
    implements _$SecurityMetadataCopyWith<$Res> {
  __$SecurityMetadataCopyWithImpl(this._self, this._then);

  final _SecurityMetadata _self;
  final $Res Function(_SecurityMetadata) _then;

  /// Create a copy of SecurityMetadata
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? secureDelegations = null,
  }) {
    return _then(_SecurityMetadata(
      secureDelegations: null == secureDelegations
          ? _self._secureDelegations
          : secureDelegations // ignore: cast_nullable_to_non_nullable
              as Map<SecureDelegationKeyString, SecureDelegation>,
    ));
  }
}

// dart format on
