// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'token_with_group.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$TokenWithGroup {
  String get token;
  String get groupId;
  String? get groupName;

  /// Create a copy of TokenWithGroup
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $TokenWithGroupCopyWith<TokenWithGroup> get copyWith =>
      _$TokenWithGroupCopyWithImpl<TokenWithGroup>(
          this as TokenWithGroup, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is TokenWithGroup &&
            (identical(other.token, token) || other.token == token) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.groupName, groupName) ||
                other.groupName == groupName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, token, groupId, groupName);

  @override
  String toString() {
    return 'TokenWithGroup(token: $token, groupId: $groupId, groupName: $groupName)';
  }
}

/// @nodoc
abstract mixin class $TokenWithGroupCopyWith<$Res> {
  factory $TokenWithGroupCopyWith(
          TokenWithGroup value, $Res Function(TokenWithGroup) _then) =
      _$TokenWithGroupCopyWithImpl;
  @useResult
  $Res call({String token, String groupId, String? groupName});
}

/// @nodoc
class _$TokenWithGroupCopyWithImpl<$Res>
    implements $TokenWithGroupCopyWith<$Res> {
  _$TokenWithGroupCopyWithImpl(this._self, this._then);

  final TokenWithGroup _self;
  final $Res Function(TokenWithGroup) _then;

  /// Create a copy of TokenWithGroup
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? token = null,
    Object? groupId = null,
    Object? groupName = freezed,
  }) {
    return _then(_self.copyWith(
      token: null == token
          ? _self.token
          : token // ignore: cast_nullable_to_non_nullable
              as String,
      groupId: null == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String,
      groupName: freezed == groupName
          ? _self.groupName
          : groupName // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _TokenWithGroup implements TokenWithGroup {
  const _TokenWithGroup(
      {required this.token, required this.groupId, this.groupName = null});

  @override
  final String token;
  @override
  final String groupId;
  @override
  @JsonKey()
  final String? groupName;

  /// Create a copy of TokenWithGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$TokenWithGroupCopyWith<_TokenWithGroup> get copyWith =>
      __$TokenWithGroupCopyWithImpl<_TokenWithGroup>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _TokenWithGroup &&
            (identical(other.token, token) || other.token == token) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.groupName, groupName) ||
                other.groupName == groupName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, token, groupId, groupName);

  @override
  String toString() {
    return 'TokenWithGroup(token: $token, groupId: $groupId, groupName: $groupName)';
  }
}

/// @nodoc
abstract mixin class _$TokenWithGroupCopyWith<$Res>
    implements $TokenWithGroupCopyWith<$Res> {
  factory _$TokenWithGroupCopyWith(
          _TokenWithGroup value, $Res Function(_TokenWithGroup) _then) =
      __$TokenWithGroupCopyWithImpl;
  @override
  @useResult
  $Res call({String token, String groupId, String? groupName});
}

/// @nodoc
class __$TokenWithGroupCopyWithImpl<$Res>
    implements _$TokenWithGroupCopyWith<$Res> {
  __$TokenWithGroupCopyWithImpl(this._self, this._then);

  final _TokenWithGroup _self;
  final $Res Function(_TokenWithGroup) _then;

  /// Create a copy of TokenWithGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? token = null,
    Object? groupId = null,
    Object? groupName = freezed,
  }) {
    return _then(_TokenWithGroup(
      token: null == token
          ? _self.token
          : token // ignore: cast_nullable_to_non_nullable
              as String,
      groupId: null == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String,
      groupName: freezed == groupName
          ? _self.groupName
          : groupName // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
