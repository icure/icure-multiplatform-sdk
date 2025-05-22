// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'remote_authentication.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$RemoteAuthentication {
  Basic? get basic;

  /// Create a copy of RemoteAuthentication
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RemoteAuthenticationCopyWith<RemoteAuthentication> get copyWith =>
      _$RemoteAuthenticationCopyWithImpl<RemoteAuthentication>(
          this as RemoteAuthentication, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is RemoteAuthentication &&
            (identical(other.basic, basic) || other.basic == basic));
  }

  @override
  int get hashCode => Object.hash(runtimeType, basic);

  @override
  String toString() {
    return 'RemoteAuthentication(basic: $basic)';
  }
}

/// @nodoc
abstract mixin class $RemoteAuthenticationCopyWith<$Res> {
  factory $RemoteAuthenticationCopyWith(RemoteAuthentication value,
          $Res Function(RemoteAuthentication) _then) =
      _$RemoteAuthenticationCopyWithImpl;
  @useResult
  $Res call({Basic? basic});

  $BasicCopyWith<$Res>? get basic;
}

/// @nodoc
class _$RemoteAuthenticationCopyWithImpl<$Res>
    implements $RemoteAuthenticationCopyWith<$Res> {
  _$RemoteAuthenticationCopyWithImpl(this._self, this._then);

  final RemoteAuthentication _self;
  final $Res Function(RemoteAuthentication) _then;

  /// Create a copy of RemoteAuthentication
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? basic = freezed,
  }) {
    return _then(_self.copyWith(
      basic: freezed == basic
          ? _self.basic
          : basic // ignore: cast_nullable_to_non_nullable
              as Basic?,
    ));
  }

  /// Create a copy of RemoteAuthentication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $BasicCopyWith<$Res>? get basic {
    if (_self.basic == null) {
      return null;
    }

    return $BasicCopyWith<$Res>(_self.basic!, (value) {
      return _then(_self.copyWith(basic: value));
    });
  }
}

/// @nodoc

class _RemoteAuthentication implements RemoteAuthentication {
  const _RemoteAuthentication({this.basic = null});

  @override
  @JsonKey()
  final Basic? basic;

  /// Create a copy of RemoteAuthentication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RemoteAuthenticationCopyWith<_RemoteAuthentication> get copyWith =>
      __$RemoteAuthenticationCopyWithImpl<_RemoteAuthentication>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _RemoteAuthentication &&
            (identical(other.basic, basic) || other.basic == basic));
  }

  @override
  int get hashCode => Object.hash(runtimeType, basic);

  @override
  String toString() {
    return 'RemoteAuthentication(basic: $basic)';
  }
}

/// @nodoc
abstract mixin class _$RemoteAuthenticationCopyWith<$Res>
    implements $RemoteAuthenticationCopyWith<$Res> {
  factory _$RemoteAuthenticationCopyWith(_RemoteAuthentication value,
          $Res Function(_RemoteAuthentication) _then) =
      __$RemoteAuthenticationCopyWithImpl;
  @override
  @useResult
  $Res call({Basic? basic});

  @override
  $BasicCopyWith<$Res>? get basic;
}

/// @nodoc
class __$RemoteAuthenticationCopyWithImpl<$Res>
    implements _$RemoteAuthenticationCopyWith<$Res> {
  __$RemoteAuthenticationCopyWithImpl(this._self, this._then);

  final _RemoteAuthentication _self;
  final $Res Function(_RemoteAuthentication) _then;

  /// Create a copy of RemoteAuthentication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? basic = freezed,
  }) {
    return _then(_RemoteAuthentication(
      basic: freezed == basic
          ? _self.basic
          : basic // ignore: cast_nullable_to_non_nullable
              as Basic?,
    ));
  }

  /// Create a copy of RemoteAuthentication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $BasicCopyWith<$Res>? get basic {
    if (_self.basic == null) {
      return null;
    }

    return $BasicCopyWith<$Res>(_self.basic!, (value) {
      return _then(_self.copyWith(basic: value));
    });
  }
}

// dart format on
