// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'healthcare_party_history_status.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$HealthcarePartyHistoryStatus {
  HealthcarePartyStatus get status;
  String get specialisationCode;
  int get startDate;
  bool get active;

  /// Create a copy of HealthcarePartyHistoryStatus
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $HealthcarePartyHistoryStatusCopyWith<HealthcarePartyHistoryStatus>
      get copyWith => _$HealthcarePartyHistoryStatusCopyWithImpl<
              HealthcarePartyHistoryStatus>(
          this as HealthcarePartyHistoryStatus, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is HealthcarePartyHistoryStatus &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.specialisationCode, specialisationCode) ||
                other.specialisationCode == specialisationCode) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.active, active) || other.active == active));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, status, specialisationCode, startDate, active);

  @override
  String toString() {
    return 'HealthcarePartyHistoryStatus(status: $status, specialisationCode: $specialisationCode, startDate: $startDate, active: $active)';
  }
}

/// @nodoc
abstract mixin class $HealthcarePartyHistoryStatusCopyWith<$Res> {
  factory $HealthcarePartyHistoryStatusCopyWith(
          HealthcarePartyHistoryStatus value,
          $Res Function(HealthcarePartyHistoryStatus) _then) =
      _$HealthcarePartyHistoryStatusCopyWithImpl;
  @useResult
  $Res call(
      {HealthcarePartyStatus status,
      String specialisationCode,
      int startDate,
      bool active});
}

/// @nodoc
class _$HealthcarePartyHistoryStatusCopyWithImpl<$Res>
    implements $HealthcarePartyHistoryStatusCopyWith<$Res> {
  _$HealthcarePartyHistoryStatusCopyWithImpl(this._self, this._then);

  final HealthcarePartyHistoryStatus _self;
  final $Res Function(HealthcarePartyHistoryStatus) _then;

  /// Create a copy of HealthcarePartyHistoryStatus
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? status = null,
    Object? specialisationCode = null,
    Object? startDate = null,
    Object? active = null,
  }) {
    return _then(_self.copyWith(
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as HealthcarePartyStatus,
      specialisationCode: null == specialisationCode
          ? _self.specialisationCode
          : specialisationCode // ignore: cast_nullable_to_non_nullable
              as String,
      startDate: null == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int,
      active: null == active
          ? _self.active
          : active // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _HealthcarePartyHistoryStatus implements HealthcarePartyHistoryStatus {
  const _HealthcarePartyHistoryStatus(
      {required this.status,
      required this.specialisationCode,
      required this.startDate,
      required this.active});

  @override
  final HealthcarePartyStatus status;
  @override
  final String specialisationCode;
  @override
  final int startDate;
  @override
  final bool active;

  /// Create a copy of HealthcarePartyHistoryStatus
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$HealthcarePartyHistoryStatusCopyWith<_HealthcarePartyHistoryStatus>
      get copyWith => __$HealthcarePartyHistoryStatusCopyWithImpl<
          _HealthcarePartyHistoryStatus>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _HealthcarePartyHistoryStatus &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.specialisationCode, specialisationCode) ||
                other.specialisationCode == specialisationCode) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.active, active) || other.active == active));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, status, specialisationCode, startDate, active);

  @override
  String toString() {
    return 'HealthcarePartyHistoryStatus(status: $status, specialisationCode: $specialisationCode, startDate: $startDate, active: $active)';
  }
}

/// @nodoc
abstract mixin class _$HealthcarePartyHistoryStatusCopyWith<$Res>
    implements $HealthcarePartyHistoryStatusCopyWith<$Res> {
  factory _$HealthcarePartyHistoryStatusCopyWith(
          _HealthcarePartyHistoryStatus value,
          $Res Function(_HealthcarePartyHistoryStatus) _then) =
      __$HealthcarePartyHistoryStatusCopyWithImpl;
  @override
  @useResult
  $Res call(
      {HealthcarePartyStatus status,
      String specialisationCode,
      int startDate,
      bool active});
}

/// @nodoc
class __$HealthcarePartyHistoryStatusCopyWithImpl<$Res>
    implements _$HealthcarePartyHistoryStatusCopyWith<$Res> {
  __$HealthcarePartyHistoryStatusCopyWithImpl(this._self, this._then);

  final _HealthcarePartyHistoryStatus _self;
  final $Res Function(_HealthcarePartyHistoryStatus) _then;

  /// Create a copy of HealthcarePartyHistoryStatus
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? status = null,
    Object? specialisationCode = null,
    Object? startDate = null,
    Object? active = null,
  }) {
    return _then(_HealthcarePartyHistoryStatus(
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as HealthcarePartyStatus,
      specialisationCode: null == specialisationCode
          ? _self.specialisationCode
          : specialisationCode // ignore: cast_nullable_to_non_nullable
              as String,
      startDate: null == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int,
      active: null == active
          ? _self.active
          : active // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on
