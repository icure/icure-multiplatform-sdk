// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'data_owner_registration_success.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DataOwnerRegistrationSuccess {
  String get userLogin;
  String get userId;
  String get token;

  /// Create a copy of DataOwnerRegistrationSuccess
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DataOwnerRegistrationSuccessCopyWith<DataOwnerRegistrationSuccess>
      get copyWith => _$DataOwnerRegistrationSuccessCopyWithImpl<
              DataOwnerRegistrationSuccess>(
          this as DataOwnerRegistrationSuccess, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DataOwnerRegistrationSuccess &&
            (identical(other.userLogin, userLogin) ||
                other.userLogin == userLogin) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.token, token) || other.token == token));
  }

  @override
  int get hashCode => Object.hash(runtimeType, userLogin, userId, token);

  @override
  String toString() {
    return 'DataOwnerRegistrationSuccess(userLogin: $userLogin, userId: $userId, token: $token)';
  }
}

/// @nodoc
abstract mixin class $DataOwnerRegistrationSuccessCopyWith<$Res> {
  factory $DataOwnerRegistrationSuccessCopyWith(
          DataOwnerRegistrationSuccess value,
          $Res Function(DataOwnerRegistrationSuccess) _then) =
      _$DataOwnerRegistrationSuccessCopyWithImpl;
  @useResult
  $Res call({String userLogin, String userId, String token});
}

/// @nodoc
class _$DataOwnerRegistrationSuccessCopyWithImpl<$Res>
    implements $DataOwnerRegistrationSuccessCopyWith<$Res> {
  _$DataOwnerRegistrationSuccessCopyWithImpl(this._self, this._then);

  final DataOwnerRegistrationSuccess _self;
  final $Res Function(DataOwnerRegistrationSuccess) _then;

  /// Create a copy of DataOwnerRegistrationSuccess
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? userLogin = null,
    Object? userId = null,
    Object? token = null,
  }) {
    return _then(_self.copyWith(
      userLogin: null == userLogin
          ? _self.userLogin
          : userLogin // ignore: cast_nullable_to_non_nullable
              as String,
      userId: null == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String,
      token: null == token
          ? _self.token
          : token // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _DataOwnerRegistrationSuccess implements DataOwnerRegistrationSuccess {
  const _DataOwnerRegistrationSuccess(
      {required this.userLogin, required this.userId, required this.token});

  @override
  final String userLogin;
  @override
  final String userId;
  @override
  final String token;

  /// Create a copy of DataOwnerRegistrationSuccess
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DataOwnerRegistrationSuccessCopyWith<_DataOwnerRegistrationSuccess>
      get copyWith => __$DataOwnerRegistrationSuccessCopyWithImpl<
          _DataOwnerRegistrationSuccess>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DataOwnerRegistrationSuccess &&
            (identical(other.userLogin, userLogin) ||
                other.userLogin == userLogin) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.token, token) || other.token == token));
  }

  @override
  int get hashCode => Object.hash(runtimeType, userLogin, userId, token);

  @override
  String toString() {
    return 'DataOwnerRegistrationSuccess(userLogin: $userLogin, userId: $userId, token: $token)';
  }
}

/// @nodoc
abstract mixin class _$DataOwnerRegistrationSuccessCopyWith<$Res>
    implements $DataOwnerRegistrationSuccessCopyWith<$Res> {
  factory _$DataOwnerRegistrationSuccessCopyWith(
          _DataOwnerRegistrationSuccess value,
          $Res Function(_DataOwnerRegistrationSuccess) _then) =
      __$DataOwnerRegistrationSuccessCopyWithImpl;
  @override
  @useResult
  $Res call({String userLogin, String userId, String token});
}

/// @nodoc
class __$DataOwnerRegistrationSuccessCopyWithImpl<$Res>
    implements _$DataOwnerRegistrationSuccessCopyWith<$Res> {
  __$DataOwnerRegistrationSuccessCopyWithImpl(this._self, this._then);

  final _DataOwnerRegistrationSuccess _self;
  final $Res Function(_DataOwnerRegistrationSuccess) _then;

  /// Create a copy of DataOwnerRegistrationSuccess
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? userLogin = null,
    Object? userId = null,
    Object? token = null,
  }) {
    return _then(_DataOwnerRegistrationSuccess(
      userLogin: null == userLogin
          ? _self.userLogin
          : userLogin // ignore: cast_nullable_to_non_nullable
              as String,
      userId: null == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String,
      token: null == token
          ? _self.token
          : token // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on
