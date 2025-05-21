// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'registration_success.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$RegistrationSuccess {
  String get groupId;
  String get userId;
  String get token;

  /// Create a copy of RegistrationSuccess
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RegistrationSuccessCopyWith<RegistrationSuccess> get copyWith =>
      _$RegistrationSuccessCopyWithImpl<RegistrationSuccess>(
          this as RegistrationSuccess, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is RegistrationSuccess &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.token, token) || other.token == token));
  }

  @override
  int get hashCode => Object.hash(runtimeType, groupId, userId, token);

  @override
  String toString() {
    return 'RegistrationSuccess(groupId: $groupId, userId: $userId, token: $token)';
  }
}

/// @nodoc
abstract mixin class $RegistrationSuccessCopyWith<$Res> {
  factory $RegistrationSuccessCopyWith(
          RegistrationSuccess value, $Res Function(RegistrationSuccess) _then) =
      _$RegistrationSuccessCopyWithImpl;
  @useResult
  $Res call({String groupId, String userId, String token});
}

/// @nodoc
class _$RegistrationSuccessCopyWithImpl<$Res>
    implements $RegistrationSuccessCopyWith<$Res> {
  _$RegistrationSuccessCopyWithImpl(this._self, this._then);

  final RegistrationSuccess _self;
  final $Res Function(RegistrationSuccess) _then;

  /// Create a copy of RegistrationSuccess
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? groupId = null,
    Object? userId = null,
    Object? token = null,
  }) {
    return _then(_self.copyWith(
      groupId: null == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
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

class _RegistrationSuccess implements RegistrationSuccess {
  const _RegistrationSuccess(
      {required this.groupId, required this.userId, required this.token});

  @override
  final String groupId;
  @override
  final String userId;
  @override
  final String token;

  /// Create a copy of RegistrationSuccess
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RegistrationSuccessCopyWith<_RegistrationSuccess> get copyWith =>
      __$RegistrationSuccessCopyWithImpl<_RegistrationSuccess>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _RegistrationSuccess &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.token, token) || other.token == token));
  }

  @override
  int get hashCode => Object.hash(runtimeType, groupId, userId, token);

  @override
  String toString() {
    return 'RegistrationSuccess(groupId: $groupId, userId: $userId, token: $token)';
  }
}

/// @nodoc
abstract mixin class _$RegistrationSuccessCopyWith<$Res>
    implements $RegistrationSuccessCopyWith<$Res> {
  factory _$RegistrationSuccessCopyWith(_RegistrationSuccess value,
          $Res Function(_RegistrationSuccess) _then) =
      __$RegistrationSuccessCopyWithImpl;
  @override
  @useResult
  $Res call({String groupId, String userId, String token});
}

/// @nodoc
class __$RegistrationSuccessCopyWithImpl<$Res>
    implements _$RegistrationSuccessCopyWith<$Res> {
  __$RegistrationSuccessCopyWithImpl(this._self, this._then);

  final _RegistrationSuccess _self;
  final $Res Function(_RegistrationSuccess) _then;

  /// Create a copy of RegistrationSuccess
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? groupId = null,
    Object? userId = null,
    Object? token = null,
  }) {
    return _then(_RegistrationSuccess(
      groupId: null == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
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
