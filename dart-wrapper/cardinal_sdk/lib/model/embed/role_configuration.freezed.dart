// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'role_configuration.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$RoleConfiguration {
  RoleConfigurationSource get source;
  Set<String> get roles;

  /// Create a copy of RoleConfiguration
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RoleConfigurationCopyWith<RoleConfiguration> get copyWith =>
      _$RoleConfigurationCopyWithImpl<RoleConfiguration>(
          this as RoleConfiguration, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is RoleConfiguration &&
            (identical(other.source, source) || other.source == source) &&
            const DeepCollectionEquality().equals(other.roles, roles));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, source, const DeepCollectionEquality().hash(roles));

  @override
  String toString() {
    return 'RoleConfiguration(source: $source, roles: $roles)';
  }
}

/// @nodoc
abstract mixin class $RoleConfigurationCopyWith<$Res> {
  factory $RoleConfigurationCopyWith(
          RoleConfiguration value, $Res Function(RoleConfiguration) _then) =
      _$RoleConfigurationCopyWithImpl;
  @useResult
  $Res call({RoleConfigurationSource source, Set<String> roles});
}

/// @nodoc
class _$RoleConfigurationCopyWithImpl<$Res>
    implements $RoleConfigurationCopyWith<$Res> {
  _$RoleConfigurationCopyWithImpl(this._self, this._then);

  final RoleConfiguration _self;
  final $Res Function(RoleConfiguration) _then;

  /// Create a copy of RoleConfiguration
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? source = null,
    Object? roles = null,
  }) {
    return _then(_self.copyWith(
      source: null == source
          ? _self.source
          : source // ignore: cast_nullable_to_non_nullable
              as RoleConfigurationSource,
      roles: null == roles
          ? _self.roles
          : roles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }
}

/// @nodoc

class _RoleConfiguration implements RoleConfiguration {
  const _RoleConfiguration(
      {required this.source, final Set<String> roles = const {}})
      : _roles = roles;

  @override
  final RoleConfigurationSource source;
  final Set<String> _roles;
  @override
  @JsonKey()
  Set<String> get roles {
    if (_roles is EqualUnmodifiableSetView) return _roles;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_roles);
  }

  /// Create a copy of RoleConfiguration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RoleConfigurationCopyWith<_RoleConfiguration> get copyWith =>
      __$RoleConfigurationCopyWithImpl<_RoleConfiguration>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _RoleConfiguration &&
            (identical(other.source, source) || other.source == source) &&
            const DeepCollectionEquality().equals(other._roles, _roles));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, source, const DeepCollectionEquality().hash(_roles));

  @override
  String toString() {
    return 'RoleConfiguration(source: $source, roles: $roles)';
  }
}

/// @nodoc
abstract mixin class _$RoleConfigurationCopyWith<$Res>
    implements $RoleConfigurationCopyWith<$Res> {
  factory _$RoleConfigurationCopyWith(
          _RoleConfiguration value, $Res Function(_RoleConfiguration) _then) =
      __$RoleConfigurationCopyWithImpl;
  @override
  @useResult
  $Res call({RoleConfigurationSource source, Set<String> roles});
}

/// @nodoc
class __$RoleConfigurationCopyWithImpl<$Res>
    implements _$RoleConfigurationCopyWith<$Res> {
  __$RoleConfigurationCopyWithImpl(this._self, this._then);

  final _RoleConfiguration _self;
  final $Res Function(_RoleConfiguration) _then;

  /// Create a copy of RoleConfiguration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? source = null,
    Object? roles = null,
  }) {
    return _then(_RoleConfiguration(
      source: null == source
          ? _self.source
          : source // ignore: cast_nullable_to_non_nullable
              as RoleConfigurationSource,
      roles: null == roles
          ? _self._roles
          : roles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }
}

// dart format on
