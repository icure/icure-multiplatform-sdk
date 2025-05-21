// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'authentication_token.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$AuthenticationToken {
  String? get token;
  int get creationTime;
  int get validity;
  int? get deletionDate;

  /// Create a copy of AuthenticationToken
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AuthenticationTokenCopyWith<AuthenticationToken> get copyWith =>
      _$AuthenticationTokenCopyWithImpl<AuthenticationToken>(
          this as AuthenticationToken, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is AuthenticationToken &&
            (identical(other.token, token) || other.token == token) &&
            (identical(other.creationTime, creationTime) ||
                other.creationTime == creationTime) &&
            (identical(other.validity, validity) ||
                other.validity == validity) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, token, creationTime, validity, deletionDate);

  @override
  String toString() {
    return 'AuthenticationToken(token: $token, creationTime: $creationTime, validity: $validity, deletionDate: $deletionDate)';
  }
}

/// @nodoc
abstract mixin class $AuthenticationTokenCopyWith<$Res> {
  factory $AuthenticationTokenCopyWith(
          AuthenticationToken value, $Res Function(AuthenticationToken) _then) =
      _$AuthenticationTokenCopyWithImpl;
  @useResult
  $Res call({String? token, int creationTime, int validity, int? deletionDate});
}

/// @nodoc
class _$AuthenticationTokenCopyWithImpl<$Res>
    implements $AuthenticationTokenCopyWith<$Res> {
  _$AuthenticationTokenCopyWithImpl(this._self, this._then);

  final AuthenticationToken _self;
  final $Res Function(AuthenticationToken) _then;

  /// Create a copy of AuthenticationToken
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? token = freezed,
    Object? creationTime = null,
    Object? validity = null,
    Object? deletionDate = freezed,
  }) {
    return _then(_self.copyWith(
      token: freezed == token
          ? _self.token
          : token // ignore: cast_nullable_to_non_nullable
              as String?,
      creationTime: null == creationTime
          ? _self.creationTime
          : creationTime // ignore: cast_nullable_to_non_nullable
              as int,
      validity: null == validity
          ? _self.validity
          : validity // ignore: cast_nullable_to_non_nullable
              as int,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

/// @nodoc

class _AuthenticationToken implements AuthenticationToken {
  const _AuthenticationToken(
      {this.token = null,
      required this.creationTime,
      required this.validity,
      this.deletionDate = null});

  @override
  @JsonKey()
  final String? token;
  @override
  final int creationTime;
  @override
  final int validity;
  @override
  @JsonKey()
  final int? deletionDate;

  /// Create a copy of AuthenticationToken
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AuthenticationTokenCopyWith<_AuthenticationToken> get copyWith =>
      __$AuthenticationTokenCopyWithImpl<_AuthenticationToken>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _AuthenticationToken &&
            (identical(other.token, token) || other.token == token) &&
            (identical(other.creationTime, creationTime) ||
                other.creationTime == creationTime) &&
            (identical(other.validity, validity) ||
                other.validity == validity) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, token, creationTime, validity, deletionDate);

  @override
  String toString() {
    return 'AuthenticationToken(token: $token, creationTime: $creationTime, validity: $validity, deletionDate: $deletionDate)';
  }
}

/// @nodoc
abstract mixin class _$AuthenticationTokenCopyWith<$Res>
    implements $AuthenticationTokenCopyWith<$Res> {
  factory _$AuthenticationTokenCopyWith(_AuthenticationToken value,
          $Res Function(_AuthenticationToken) _then) =
      __$AuthenticationTokenCopyWithImpl;
  @override
  @useResult
  $Res call({String? token, int creationTime, int validity, int? deletionDate});
}

/// @nodoc
class __$AuthenticationTokenCopyWithImpl<$Res>
    implements _$AuthenticationTokenCopyWith<$Res> {
  __$AuthenticationTokenCopyWithImpl(this._self, this._then);

  final _AuthenticationToken _self;
  final $Res Function(_AuthenticationToken) _then;

  /// Create a copy of AuthenticationToken
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? token = freezed,
    Object? creationTime = null,
    Object? validity = null,
    Object? deletionDate = freezed,
  }) {
    return _then(_AuthenticationToken(
      token: freezed == token
          ? _self.token
          : token // ignore: cast_nullable_to_non_nullable
              as String?,
      creationTime: null == creationTime
          ? _self.creationTime
          : creationTime // ignore: cast_nullable_to_non_nullable
              as int,
      validity: null == validity
          ? _self.validity
          : validity // ignore: cast_nullable_to_non_nullable
              as int,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

// dart format on
