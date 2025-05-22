// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'user_group.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$UserGroup {
  String? get groupId;
  String? get groupName;
  List<Group> get groupsHierarchy;
  String? get userId;
  String? get login;
  String? get name;
  String? get email;
  String? get phone;
  String? get patientId;
  String? get healthcarePartyId;
  String? get deviceId;
  String? get nameOfParentOfTopmostGroupInHierarchy;

  /// Create a copy of UserGroup
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $UserGroupCopyWith<UserGroup> get copyWith =>
      _$UserGroupCopyWithImpl<UserGroup>(this as UserGroup, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is UserGroup &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.groupName, groupName) ||
                other.groupName == groupName) &&
            const DeepCollectionEquality()
                .equals(other.groupsHierarchy, groupsHierarchy) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.login, login) || other.login == login) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.email, email) || other.email == email) &&
            (identical(other.phone, phone) || other.phone == phone) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.deviceId, deviceId) ||
                other.deviceId == deviceId) &&
            (identical(other.nameOfParentOfTopmostGroupInHierarchy,
                    nameOfParentOfTopmostGroupInHierarchy) ||
                other.nameOfParentOfTopmostGroupInHierarchy ==
                    nameOfParentOfTopmostGroupInHierarchy));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      groupId,
      groupName,
      const DeepCollectionEquality().hash(groupsHierarchy),
      userId,
      login,
      name,
      email,
      phone,
      patientId,
      healthcarePartyId,
      deviceId,
      nameOfParentOfTopmostGroupInHierarchy);

  @override
  String toString() {
    return 'UserGroup(groupId: $groupId, groupName: $groupName, groupsHierarchy: $groupsHierarchy, userId: $userId, login: $login, name: $name, email: $email, phone: $phone, patientId: $patientId, healthcarePartyId: $healthcarePartyId, deviceId: $deviceId, nameOfParentOfTopmostGroupInHierarchy: $nameOfParentOfTopmostGroupInHierarchy)';
  }
}

/// @nodoc
abstract mixin class $UserGroupCopyWith<$Res> {
  factory $UserGroupCopyWith(UserGroup value, $Res Function(UserGroup) _then) =
      _$UserGroupCopyWithImpl;
  @useResult
  $Res call(
      {String? groupId,
      String? groupName,
      List<Group> groupsHierarchy,
      String? userId,
      String? login,
      String? name,
      String? email,
      String? phone,
      String? patientId,
      String? healthcarePartyId,
      String? deviceId,
      String? nameOfParentOfTopmostGroupInHierarchy});
}

/// @nodoc
class _$UserGroupCopyWithImpl<$Res> implements $UserGroupCopyWith<$Res> {
  _$UserGroupCopyWithImpl(this._self, this._then);

  final UserGroup _self;
  final $Res Function(UserGroup) _then;

  /// Create a copy of UserGroup
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? groupId = freezed,
    Object? groupName = freezed,
    Object? groupsHierarchy = null,
    Object? userId = freezed,
    Object? login = freezed,
    Object? name = freezed,
    Object? email = freezed,
    Object? phone = freezed,
    Object? patientId = freezed,
    Object? healthcarePartyId = freezed,
    Object? deviceId = freezed,
    Object? nameOfParentOfTopmostGroupInHierarchy = freezed,
  }) {
    return _then(_self.copyWith(
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      groupName: freezed == groupName
          ? _self.groupName
          : groupName // ignore: cast_nullable_to_non_nullable
              as String?,
      groupsHierarchy: null == groupsHierarchy
          ? _self.groupsHierarchy
          : groupsHierarchy // ignore: cast_nullable_to_non_nullable
              as List<Group>,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      login: freezed == login
          ? _self.login
          : login // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      email: freezed == email
          ? _self.email
          : email // ignore: cast_nullable_to_non_nullable
              as String?,
      phone: freezed == phone
          ? _self.phone
          : phone // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      deviceId: freezed == deviceId
          ? _self.deviceId
          : deviceId // ignore: cast_nullable_to_non_nullable
              as String?,
      nameOfParentOfTopmostGroupInHierarchy: freezed ==
              nameOfParentOfTopmostGroupInHierarchy
          ? _self.nameOfParentOfTopmostGroupInHierarchy
          : nameOfParentOfTopmostGroupInHierarchy // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _UserGroup implements UserGroup {
  const _UserGroup(
      {this.groupId = null,
      this.groupName = null,
      final List<Group> groupsHierarchy = const [],
      this.userId = null,
      this.login = null,
      this.name = null,
      this.email = null,
      this.phone = null,
      this.patientId = null,
      this.healthcarePartyId = null,
      this.deviceId = null,
      this.nameOfParentOfTopmostGroupInHierarchy = null})
      : _groupsHierarchy = groupsHierarchy;

  @override
  @JsonKey()
  final String? groupId;
  @override
  @JsonKey()
  final String? groupName;
  final List<Group> _groupsHierarchy;
  @override
  @JsonKey()
  List<Group> get groupsHierarchy {
    if (_groupsHierarchy is EqualUnmodifiableListView) return _groupsHierarchy;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_groupsHierarchy);
  }

  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? login;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? email;
  @override
  @JsonKey()
  final String? phone;
  @override
  @JsonKey()
  final String? patientId;
  @override
  @JsonKey()
  final String? healthcarePartyId;
  @override
  @JsonKey()
  final String? deviceId;
  @override
  @JsonKey()
  final String? nameOfParentOfTopmostGroupInHierarchy;

  /// Create a copy of UserGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$UserGroupCopyWith<_UserGroup> get copyWith =>
      __$UserGroupCopyWithImpl<_UserGroup>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _UserGroup &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.groupName, groupName) ||
                other.groupName == groupName) &&
            const DeepCollectionEquality()
                .equals(other._groupsHierarchy, _groupsHierarchy) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.login, login) || other.login == login) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.email, email) || other.email == email) &&
            (identical(other.phone, phone) || other.phone == phone) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.deviceId, deviceId) ||
                other.deviceId == deviceId) &&
            (identical(other.nameOfParentOfTopmostGroupInHierarchy,
                    nameOfParentOfTopmostGroupInHierarchy) ||
                other.nameOfParentOfTopmostGroupInHierarchy ==
                    nameOfParentOfTopmostGroupInHierarchy));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      groupId,
      groupName,
      const DeepCollectionEquality().hash(_groupsHierarchy),
      userId,
      login,
      name,
      email,
      phone,
      patientId,
      healthcarePartyId,
      deviceId,
      nameOfParentOfTopmostGroupInHierarchy);

  @override
  String toString() {
    return 'UserGroup(groupId: $groupId, groupName: $groupName, groupsHierarchy: $groupsHierarchy, userId: $userId, login: $login, name: $name, email: $email, phone: $phone, patientId: $patientId, healthcarePartyId: $healthcarePartyId, deviceId: $deviceId, nameOfParentOfTopmostGroupInHierarchy: $nameOfParentOfTopmostGroupInHierarchy)';
  }
}

/// @nodoc
abstract mixin class _$UserGroupCopyWith<$Res>
    implements $UserGroupCopyWith<$Res> {
  factory _$UserGroupCopyWith(
          _UserGroup value, $Res Function(_UserGroup) _then) =
      __$UserGroupCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? groupId,
      String? groupName,
      List<Group> groupsHierarchy,
      String? userId,
      String? login,
      String? name,
      String? email,
      String? phone,
      String? patientId,
      String? healthcarePartyId,
      String? deviceId,
      String? nameOfParentOfTopmostGroupInHierarchy});
}

/// @nodoc
class __$UserGroupCopyWithImpl<$Res> implements _$UserGroupCopyWith<$Res> {
  __$UserGroupCopyWithImpl(this._self, this._then);

  final _UserGroup _self;
  final $Res Function(_UserGroup) _then;

  /// Create a copy of UserGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? groupId = freezed,
    Object? groupName = freezed,
    Object? groupsHierarchy = null,
    Object? userId = freezed,
    Object? login = freezed,
    Object? name = freezed,
    Object? email = freezed,
    Object? phone = freezed,
    Object? patientId = freezed,
    Object? healthcarePartyId = freezed,
    Object? deviceId = freezed,
    Object? nameOfParentOfTopmostGroupInHierarchy = freezed,
  }) {
    return _then(_UserGroup(
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      groupName: freezed == groupName
          ? _self.groupName
          : groupName // ignore: cast_nullable_to_non_nullable
              as String?,
      groupsHierarchy: null == groupsHierarchy
          ? _self._groupsHierarchy
          : groupsHierarchy // ignore: cast_nullable_to_non_nullable
              as List<Group>,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      login: freezed == login
          ? _self.login
          : login // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      email: freezed == email
          ? _self.email
          : email // ignore: cast_nullable_to_non_nullable
              as String?,
      phone: freezed == phone
          ? _self.phone
          : phone // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      deviceId: freezed == deviceId
          ? _self.deviceId
          : deviceId // ignore: cast_nullable_to_non_nullable
              as String?,
      nameOfParentOfTopmostGroupInHierarchy: freezed ==
              nameOfParentOfTopmostGroupInHierarchy
          ? _self.nameOfParentOfTopmostGroupInHierarchy
          : nameOfParentOfTopmostGroupInHierarchy // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
