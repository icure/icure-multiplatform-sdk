// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'care_team_member.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedCareTeamMember {
  String get id;
  CareTeamMemberType? get careTeamMemberType;
  String? get healthcarePartyId;
  CodeStub? get quality;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedCareTeamMemberCopyWith<EncryptedCareTeamMember> get copyWith =>
      _$EncryptedCareTeamMemberCopyWithImpl<EncryptedCareTeamMember>(
          this as EncryptedCareTeamMember, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedCareTeamMember &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.careTeamMemberType, careTeamMemberType) ||
                other.careTeamMemberType == careTeamMemberType) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.quality, quality) || other.quality == quality) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, careTeamMemberType,
      healthcarePartyId, quality, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedCareTeamMember(id: $id, careTeamMemberType: $careTeamMemberType, healthcarePartyId: $healthcarePartyId, quality: $quality, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedCareTeamMemberCopyWith<$Res> {
  factory $EncryptedCareTeamMemberCopyWith(EncryptedCareTeamMember value,
          $Res Function(EncryptedCareTeamMember) _then) =
      _$EncryptedCareTeamMemberCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      CareTeamMemberType? careTeamMemberType,
      String? healthcarePartyId,
      CodeStub? quality,
      Base64String? encryptedSelf});

  $CodeStubCopyWith<$Res>? get quality;
}

/// @nodoc
class _$EncryptedCareTeamMemberCopyWithImpl<$Res>
    implements $EncryptedCareTeamMemberCopyWith<$Res> {
  _$EncryptedCareTeamMemberCopyWithImpl(this._self, this._then);

  final EncryptedCareTeamMember _self;
  final $Res Function(EncryptedCareTeamMember) _then;

  /// Create a copy of EncryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? careTeamMemberType = freezed,
    Object? healthcarePartyId = freezed,
    Object? quality = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      careTeamMemberType: freezed == careTeamMemberType
          ? _self.careTeamMemberType
          : careTeamMemberType // ignore: cast_nullable_to_non_nullable
              as CareTeamMemberType?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      quality: freezed == quality
          ? _self.quality
          : quality // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get quality {
    if (_self.quality == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.quality!, (value) {
      return _then(_self.copyWith(quality: value));
    });
  }
}

/// @nodoc

class _EncryptedCareTeamMember implements EncryptedCareTeamMember {
  const _EncryptedCareTeamMember(
      {required this.id,
      this.careTeamMemberType = null,
      this.healthcarePartyId = null,
      this.quality = null,
      this.encryptedSelf = null});

  @override
  final String id;
  @override
  @JsonKey()
  final CareTeamMemberType? careTeamMemberType;
  @override
  @JsonKey()
  final String? healthcarePartyId;
  @override
  @JsonKey()
  final CodeStub? quality;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedCareTeamMemberCopyWith<_EncryptedCareTeamMember> get copyWith =>
      __$EncryptedCareTeamMemberCopyWithImpl<_EncryptedCareTeamMember>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedCareTeamMember &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.careTeamMemberType, careTeamMemberType) ||
                other.careTeamMemberType == careTeamMemberType) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.quality, quality) || other.quality == quality) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, careTeamMemberType,
      healthcarePartyId, quality, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedCareTeamMember(id: $id, careTeamMemberType: $careTeamMemberType, healthcarePartyId: $healthcarePartyId, quality: $quality, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedCareTeamMemberCopyWith<$Res>
    implements $EncryptedCareTeamMemberCopyWith<$Res> {
  factory _$EncryptedCareTeamMemberCopyWith(_EncryptedCareTeamMember value,
          $Res Function(_EncryptedCareTeamMember) _then) =
      __$EncryptedCareTeamMemberCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      CareTeamMemberType? careTeamMemberType,
      String? healthcarePartyId,
      CodeStub? quality,
      Base64String? encryptedSelf});

  @override
  $CodeStubCopyWith<$Res>? get quality;
}

/// @nodoc
class __$EncryptedCareTeamMemberCopyWithImpl<$Res>
    implements _$EncryptedCareTeamMemberCopyWith<$Res> {
  __$EncryptedCareTeamMemberCopyWithImpl(this._self, this._then);

  final _EncryptedCareTeamMember _self;
  final $Res Function(_EncryptedCareTeamMember) _then;

  /// Create a copy of EncryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? careTeamMemberType = freezed,
    Object? healthcarePartyId = freezed,
    Object? quality = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedCareTeamMember(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      careTeamMemberType: freezed == careTeamMemberType
          ? _self.careTeamMemberType
          : careTeamMemberType // ignore: cast_nullable_to_non_nullable
              as CareTeamMemberType?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      quality: freezed == quality
          ? _self.quality
          : quality // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get quality {
    if (_self.quality == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.quality!, (value) {
      return _then(_self.copyWith(quality: value));
    });
  }
}

/// @nodoc
mixin _$DecryptedCareTeamMember {
  String get id;
  CareTeamMemberType? get careTeamMemberType;
  String? get healthcarePartyId;
  CodeStub? get quality;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedCareTeamMemberCopyWith<DecryptedCareTeamMember> get copyWith =>
      _$DecryptedCareTeamMemberCopyWithImpl<DecryptedCareTeamMember>(
          this as DecryptedCareTeamMember, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedCareTeamMember &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.careTeamMemberType, careTeamMemberType) ||
                other.careTeamMemberType == careTeamMemberType) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.quality, quality) || other.quality == quality) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, careTeamMemberType,
      healthcarePartyId, quality, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedCareTeamMember(id: $id, careTeamMemberType: $careTeamMemberType, healthcarePartyId: $healthcarePartyId, quality: $quality, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedCareTeamMemberCopyWith<$Res> {
  factory $DecryptedCareTeamMemberCopyWith(DecryptedCareTeamMember value,
          $Res Function(DecryptedCareTeamMember) _then) =
      _$DecryptedCareTeamMemberCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      CareTeamMemberType? careTeamMemberType,
      String? healthcarePartyId,
      CodeStub? quality,
      Base64String? encryptedSelf});

  $CodeStubCopyWith<$Res>? get quality;
}

/// @nodoc
class _$DecryptedCareTeamMemberCopyWithImpl<$Res>
    implements $DecryptedCareTeamMemberCopyWith<$Res> {
  _$DecryptedCareTeamMemberCopyWithImpl(this._self, this._then);

  final DecryptedCareTeamMember _self;
  final $Res Function(DecryptedCareTeamMember) _then;

  /// Create a copy of DecryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? careTeamMemberType = freezed,
    Object? healthcarePartyId = freezed,
    Object? quality = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      careTeamMemberType: freezed == careTeamMemberType
          ? _self.careTeamMemberType
          : careTeamMemberType // ignore: cast_nullable_to_non_nullable
              as CareTeamMemberType?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      quality: freezed == quality
          ? _self.quality
          : quality // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get quality {
    if (_self.quality == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.quality!, (value) {
      return _then(_self.copyWith(quality: value));
    });
  }
}

/// @nodoc

class _DecryptedCareTeamMember implements DecryptedCareTeamMember {
  const _DecryptedCareTeamMember(
      {required this.id,
      this.careTeamMemberType = null,
      this.healthcarePartyId = null,
      this.quality = null,
      this.encryptedSelf = null});

  @override
  final String id;
  @override
  @JsonKey()
  final CareTeamMemberType? careTeamMemberType;
  @override
  @JsonKey()
  final String? healthcarePartyId;
  @override
  @JsonKey()
  final CodeStub? quality;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedCareTeamMemberCopyWith<_DecryptedCareTeamMember> get copyWith =>
      __$DecryptedCareTeamMemberCopyWithImpl<_DecryptedCareTeamMember>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedCareTeamMember &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.careTeamMemberType, careTeamMemberType) ||
                other.careTeamMemberType == careTeamMemberType) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.quality, quality) || other.quality == quality) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, careTeamMemberType,
      healthcarePartyId, quality, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedCareTeamMember(id: $id, careTeamMemberType: $careTeamMemberType, healthcarePartyId: $healthcarePartyId, quality: $quality, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedCareTeamMemberCopyWith<$Res>
    implements $DecryptedCareTeamMemberCopyWith<$Res> {
  factory _$DecryptedCareTeamMemberCopyWith(_DecryptedCareTeamMember value,
          $Res Function(_DecryptedCareTeamMember) _then) =
      __$DecryptedCareTeamMemberCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      CareTeamMemberType? careTeamMemberType,
      String? healthcarePartyId,
      CodeStub? quality,
      Base64String? encryptedSelf});

  @override
  $CodeStubCopyWith<$Res>? get quality;
}

/// @nodoc
class __$DecryptedCareTeamMemberCopyWithImpl<$Res>
    implements _$DecryptedCareTeamMemberCopyWith<$Res> {
  __$DecryptedCareTeamMemberCopyWithImpl(this._self, this._then);

  final _DecryptedCareTeamMember _self;
  final $Res Function(_DecryptedCareTeamMember) _then;

  /// Create a copy of DecryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? careTeamMemberType = freezed,
    Object? healthcarePartyId = freezed,
    Object? quality = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedCareTeamMember(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      careTeamMemberType: freezed == careTeamMemberType
          ? _self.careTeamMemberType
          : careTeamMemberType // ignore: cast_nullable_to_non_nullable
              as CareTeamMemberType?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      quality: freezed == quality
          ? _self.quality
          : quality // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedCareTeamMember
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get quality {
    if (_self.quality == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.quality!, (value) {
      return _then(_self.copyWith(quality: value));
    });
  }
}

// dart format on
