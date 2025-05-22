// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'care_team_membership.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedCareTeamMembership {
  int? get startDate;
  int? get endDate;
  String? get careTeamMemberId;
  MembershipType? get membershipType;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedCareTeamMembership
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedCareTeamMembershipCopyWith<DecryptedCareTeamMembership>
      get copyWith => _$DecryptedCareTeamMembershipCopyWithImpl<
              DecryptedCareTeamMembership>(
          this as DecryptedCareTeamMembership, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedCareTeamMembership &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.careTeamMemberId, careTeamMemberId) ||
                other.careTeamMemberId == careTeamMemberId) &&
            (identical(other.membershipType, membershipType) ||
                other.membershipType == membershipType) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startDate, endDate,
      careTeamMemberId, membershipType, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedCareTeamMembership(startDate: $startDate, endDate: $endDate, careTeamMemberId: $careTeamMemberId, membershipType: $membershipType, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedCareTeamMembershipCopyWith<$Res> {
  factory $DecryptedCareTeamMembershipCopyWith(
          DecryptedCareTeamMembership value,
          $Res Function(DecryptedCareTeamMembership) _then) =
      _$DecryptedCareTeamMembershipCopyWithImpl;
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      String? careTeamMemberId,
      MembershipType? membershipType,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedCareTeamMembershipCopyWithImpl<$Res>
    implements $DecryptedCareTeamMembershipCopyWith<$Res> {
  _$DecryptedCareTeamMembershipCopyWithImpl(this._self, this._then);

  final DecryptedCareTeamMembership _self;
  final $Res Function(DecryptedCareTeamMembership) _then;

  /// Create a copy of DecryptedCareTeamMembership
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? careTeamMemberId = freezed,
    Object? membershipType = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      careTeamMemberId: freezed == careTeamMemberId
          ? _self.careTeamMemberId
          : careTeamMemberId // ignore: cast_nullable_to_non_nullable
              as String?,
      membershipType: freezed == membershipType
          ? _self.membershipType
          : membershipType // ignore: cast_nullable_to_non_nullable
              as MembershipType?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedCareTeamMembership implements DecryptedCareTeamMembership {
  const _DecryptedCareTeamMembership(
      {this.startDate = null,
      this.endDate = null,
      this.careTeamMemberId = null,
      this.membershipType = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final String? careTeamMemberId;
  @override
  @JsonKey()
  final MembershipType? membershipType;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedCareTeamMembership
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedCareTeamMembershipCopyWith<_DecryptedCareTeamMembership>
      get copyWith => __$DecryptedCareTeamMembershipCopyWithImpl<
          _DecryptedCareTeamMembership>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedCareTeamMembership &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.careTeamMemberId, careTeamMemberId) ||
                other.careTeamMemberId == careTeamMemberId) &&
            (identical(other.membershipType, membershipType) ||
                other.membershipType == membershipType) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startDate, endDate,
      careTeamMemberId, membershipType, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedCareTeamMembership(startDate: $startDate, endDate: $endDate, careTeamMemberId: $careTeamMemberId, membershipType: $membershipType, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedCareTeamMembershipCopyWith<$Res>
    implements $DecryptedCareTeamMembershipCopyWith<$Res> {
  factory _$DecryptedCareTeamMembershipCopyWith(
          _DecryptedCareTeamMembership value,
          $Res Function(_DecryptedCareTeamMembership) _then) =
      __$DecryptedCareTeamMembershipCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      String? careTeamMemberId,
      MembershipType? membershipType,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedCareTeamMembershipCopyWithImpl<$Res>
    implements _$DecryptedCareTeamMembershipCopyWith<$Res> {
  __$DecryptedCareTeamMembershipCopyWithImpl(this._self, this._then);

  final _DecryptedCareTeamMembership _self;
  final $Res Function(_DecryptedCareTeamMembership) _then;

  /// Create a copy of DecryptedCareTeamMembership
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? careTeamMemberId = freezed,
    Object? membershipType = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedCareTeamMembership(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      careTeamMemberId: freezed == careTeamMemberId
          ? _self.careTeamMemberId
          : careTeamMemberId // ignore: cast_nullable_to_non_nullable
              as String?,
      membershipType: freezed == membershipType
          ? _self.membershipType
          : membershipType // ignore: cast_nullable_to_non_nullable
              as MembershipType?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$EncryptedCareTeamMembership {
  int? get startDate;
  int? get endDate;
  String? get careTeamMemberId;
  MembershipType? get membershipType;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedCareTeamMembership
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedCareTeamMembershipCopyWith<EncryptedCareTeamMembership>
      get copyWith => _$EncryptedCareTeamMembershipCopyWithImpl<
              EncryptedCareTeamMembership>(
          this as EncryptedCareTeamMembership, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedCareTeamMembership &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.careTeamMemberId, careTeamMemberId) ||
                other.careTeamMemberId == careTeamMemberId) &&
            (identical(other.membershipType, membershipType) ||
                other.membershipType == membershipType) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startDate, endDate,
      careTeamMemberId, membershipType, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedCareTeamMembership(startDate: $startDate, endDate: $endDate, careTeamMemberId: $careTeamMemberId, membershipType: $membershipType, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedCareTeamMembershipCopyWith<$Res> {
  factory $EncryptedCareTeamMembershipCopyWith(
          EncryptedCareTeamMembership value,
          $Res Function(EncryptedCareTeamMembership) _then) =
      _$EncryptedCareTeamMembershipCopyWithImpl;
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      String? careTeamMemberId,
      MembershipType? membershipType,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedCareTeamMembershipCopyWithImpl<$Res>
    implements $EncryptedCareTeamMembershipCopyWith<$Res> {
  _$EncryptedCareTeamMembershipCopyWithImpl(this._self, this._then);

  final EncryptedCareTeamMembership _self;
  final $Res Function(EncryptedCareTeamMembership) _then;

  /// Create a copy of EncryptedCareTeamMembership
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? careTeamMemberId = freezed,
    Object? membershipType = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      careTeamMemberId: freezed == careTeamMemberId
          ? _self.careTeamMemberId
          : careTeamMemberId // ignore: cast_nullable_to_non_nullable
              as String?,
      membershipType: freezed == membershipType
          ? _self.membershipType
          : membershipType // ignore: cast_nullable_to_non_nullable
              as MembershipType?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedCareTeamMembership implements EncryptedCareTeamMembership {
  const _EncryptedCareTeamMembership(
      {this.startDate = null,
      this.endDate = null,
      this.careTeamMemberId = null,
      this.membershipType = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final String? careTeamMemberId;
  @override
  @JsonKey()
  final MembershipType? membershipType;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedCareTeamMembership
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedCareTeamMembershipCopyWith<_EncryptedCareTeamMembership>
      get copyWith => __$EncryptedCareTeamMembershipCopyWithImpl<
          _EncryptedCareTeamMembership>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedCareTeamMembership &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.careTeamMemberId, careTeamMemberId) ||
                other.careTeamMemberId == careTeamMemberId) &&
            (identical(other.membershipType, membershipType) ||
                other.membershipType == membershipType) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startDate, endDate,
      careTeamMemberId, membershipType, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedCareTeamMembership(startDate: $startDate, endDate: $endDate, careTeamMemberId: $careTeamMemberId, membershipType: $membershipType, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedCareTeamMembershipCopyWith<$Res>
    implements $EncryptedCareTeamMembershipCopyWith<$Res> {
  factory _$EncryptedCareTeamMembershipCopyWith(
          _EncryptedCareTeamMembership value,
          $Res Function(_EncryptedCareTeamMembership) _then) =
      __$EncryptedCareTeamMembershipCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      String? careTeamMemberId,
      MembershipType? membershipType,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedCareTeamMembershipCopyWithImpl<$Res>
    implements _$EncryptedCareTeamMembershipCopyWith<$Res> {
  __$EncryptedCareTeamMembershipCopyWithImpl(this._self, this._then);

  final _EncryptedCareTeamMembership _self;
  final $Res Function(_EncryptedCareTeamMembership) _then;

  /// Create a copy of EncryptedCareTeamMembership
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? careTeamMemberId = freezed,
    Object? membershipType = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedCareTeamMembership(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      careTeamMemberId: freezed == careTeamMemberId
          ? _self.careTeamMemberId
          : careTeamMemberId // ignore: cast_nullable_to_non_nullable
              as String?,
      membershipType: freezed == membershipType
          ? _self.membershipType
          : membershipType // ignore: cast_nullable_to_non_nullable
              as MembershipType?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
